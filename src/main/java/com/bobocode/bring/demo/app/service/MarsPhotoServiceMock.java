package com.bobocode.bring.demo.app.service;

import com.bobocode.bring.demo.app.model.Photo;
import com.bobocode.bring.demo.app.model.PhotoData;
import com.bringframework.annotation.Component;

import java.util.Collections;
import java.util.List;

@Component
public class MarsPhotoServiceMock implements MarsPhotoService {

    @Override
    public List<Photo> getMarsPhotos() {
        return Collections.emptyList();
    }

    @Override
    public PhotoData enrichPhotoData(Photo photo) {
        return null;
    }
}
