package com.bobocode.bring.demo.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Rover(
        Long id,
        String name,
        @JsonProperty("landing_date") String landingDate,
        @JsonProperty("launch_date") String launchDate,
        String status
) {
}
