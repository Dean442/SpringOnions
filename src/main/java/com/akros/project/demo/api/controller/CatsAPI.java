package com.akros.project.demo.api.controller;

import com.akros.project.demo.data.Cat;
import com.akros.project.demo.data.CatRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Tag(name = "cats", description = "Cat controller")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/cats")
public class CatsAPI {

    private final CatRepository catRepository;

    @GetMapping(path = "/get")
    public ResponseEntity<Cat> getCat(@RequestBody String catName) {
        final Cat cat = catRepository.findCatByName(catName);
        return new ResponseEntity<>(cat, HttpStatus.OK);
    }

    @GetMapping(path = "/getCats")
    public ResponseEntity<List> getCats() {
        List<Cat> allCats = catRepository.findAll();
        return new ResponseEntity<>(allCats, HttpStatus.OK);
    }

    @PostMapping(path = "/post", consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Cat> postCat(@RequestBody @Valid RequestEntity<Cat> data) {

        String name = data.getBody().getName();
        String color = data.getBody().getColor();
        String character = data.getBody().getCharacter();
        String gender = data.getBody().getGender();
        int price = data.getBody().getPrice();

        Cat cat = catRepository.save(new Cat(name, color, character, gender, price));
        return new ResponseEntity<>(cat, HttpStatus.CREATED);
    }


}
