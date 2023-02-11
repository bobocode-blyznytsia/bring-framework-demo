package com.bobocode.bring.demo.app.exception;

public class PhotoNotFoundException extends RuntimeException {

    public PhotoNotFoundException() {
        super("Unable to found max photo");
    }
}
