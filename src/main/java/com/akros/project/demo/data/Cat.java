package com.akros.project.demo.data;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity(name = "CAT")
@Table()
@Getter
@Setter
@RequiredArgsConstructor
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "ID")
    private Long id;

    @Column(name = "CAT_NAME")
    private String name;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "CHARACTER")
    private String character;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "PRICE")
    private int price;

    public Cat(String name, String color, String character, String gender, int price) {
        this.name = name;
        this.color = color;
        this.character = character;
        this.gender = gender;
        this.price = price;
    }
}
