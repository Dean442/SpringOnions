package com.akros.project.demo.api.controller;

import com.akros.project.demo.api.service.CatService;
import com.akros.project.demo.persistence.Cat;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


@Slf4j
@Tag(name = "cats", description = "Cat controller")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/cats")
public class CatController {

    private final CatService catService;

    @GetMapping(path = "/get/{catName}")
    public ResponseEntity<Cat> getCat(@PathVariable String catName) {
        final Cat cat = catService.findCatByName(catName);
        return new ResponseEntity<>(cat, HttpStatus.OK);
    }

    @GetMapping(path = "/getCats")
    public ResponseEntity<List> getCats() {
        List<Cat> allCats = catService.findAll();
        return new ResponseEntity<>(allCats, HttpStatus.OK);
    }

    @PostMapping(path = "/post", consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Cat> postCat(@RequestBody @Valid @NotNull RequestEntity<CatDto> data) {

        CatDto newCat = data.getBody();
        assert newCat != null;
        Cat cat = catService.save(new Cat(newCat.getName(), newCat.getColor(), newCat.getCharacter(), newCat.getGender(), newCat.getPrice()));
        return new ResponseEntity<>(cat, HttpStatus.CREATED);
    }

    @PutMapping(path = "/put/{id}")
    public ResponseEntity<Cat> putCat(@PathVariable long id, @RequestBody @Valid @NotNull RequestEntity<CatDto> data) {
        CatDto newCat = data.getBody();
        assert newCat != null;
        Cat cat = catService.updateCat(id, new Cat(newCat.getName(), newCat.getColor(), newCat.getCharacter(), newCat.getGender(), newCat.getPrice()));
        return new ResponseEntity<>(cat, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Cat> deleteCat(@PathVariable long id) {

        Cat cat = catService.deleteCat(id);
        return new ResponseEntity<>(cat, HttpStatus.OK);
    }


}
