package com.bobocode.bring.demo.app.util;

import java.net.URI;
import java.net.URISyntaxException;

public class UriConverter {

    public URI toUri(String uriString) {
        try {
            return new URI(uriString);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException();
        }
    }

}
