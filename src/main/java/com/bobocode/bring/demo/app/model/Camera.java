package com.bobocode.bring.demo.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Camera(
        Long id,
        String name,
        @JsonProperty("rover_id") Long roverId,
        @JsonProperty("full_name") String fullName
) {
}