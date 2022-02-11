package com.akros.project.demo.api.controller;

import lombok.*;

@Builder
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CatDto {
    @NonNull
    private String name;
    @NonNull
    private String color;
    @NonNull
    private String character;
    @NonNull
    private String gender;
    @NonNull
    private int price;
}
