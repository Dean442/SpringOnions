package com.akros.project.demo.api.service;

import com.akros.project.demo.persistence.Cat;
import com.akros.project.demo.persistence.CatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CatService {

    @Autowired
    private final CatRepository catRepository;


    public Cat findCatByName(String catName) {
        return catRepository.findCatByName(catName);
    }

    public List<Cat> findAll() {
        return catRepository.findAll();
    }

    public Cat save(Cat cat) {
        return catRepository.save(cat);
    }

    public Cat updateCat(long id, Cat newCat) {
        Cat cat = catRepository.findCatById(id);
        cat.setName(newCat.getName());
        cat.setColor(newCat.getColor());
        cat.setCharacter(newCat.getCharacter());
        cat.setGender(newCat.getGender());
        cat.setPrice(newCat.getPrice());
        return catRepository.save(cat);
    }

    public Cat deleteCat(long id) {
        Cat cat = catRepository.findCatById(id);
        catRepository.deleteById(id);
        return cat;
    }
}
