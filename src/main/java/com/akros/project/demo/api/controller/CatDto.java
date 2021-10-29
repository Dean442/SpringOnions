package com.akros.project.demo.api.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@Schema( name = "Cat", description = "Cat schema")
public class CatDto {
    @NonNull
    @NotNull
    @JsonProperty("name")
    private String name;
    @NonNull
    @NotNull
    @JsonProperty("color")
    private String color;
    @NonNull
    @NotNull
    @JsonProperty("character")
    private String character;
    @NonNull
    @NotNull
    @JsonProperty("gender")
    private String gender;
    @NonNull
    @NotNull
    @JsonProperty("price")
    private int price;
}
