package com.akros.project.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {

    List<Cat> findAllByPrice(int price);
    Cat findCatByName(String name);

    Cat findCatById(long id);
}
