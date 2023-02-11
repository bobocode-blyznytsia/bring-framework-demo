package com.bobocode.bring.demo.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Photo(
        Long id,
        Long sol,
        Camera camera,
        @JsonProperty("img_src") String imgSrc,
        @JsonProperty("earth_date") String earthDate,
        Rover rover
) {
}