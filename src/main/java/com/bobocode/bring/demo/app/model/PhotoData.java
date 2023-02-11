package com.bobocode.bring.demo.app.model;

import java.net.URI;

public record PhotoData(
        Photo photo,
        URI uri,
        long size
) {
}
