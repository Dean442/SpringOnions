package com.akros.project.demo.persistence;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "CAT")
@Table()
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "ID")
    private Long id;

    @NonNull
    @NotNull
    @Column(name = "CAT_NAME")
    private String name;

    @NonNull
    @NotNull
    @Column(name = "COLOR")
    private String color;

    @NonNull
    @NotNull
    @Column(name = "CHARACTER")
    private String character;

    @NonNull
    @NotNull
    @Column(name = "GENDER")
    private String gender;

    @NonNull
    @NotNull
    @Column(name = "PRICE")
    private int price;

}
