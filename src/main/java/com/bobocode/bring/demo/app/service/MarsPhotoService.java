package com.bobocode.bring.demo.app.service;

import com.bobocode.bring.demo.app.model.Photo;
import com.bobocode.bring.demo.app.model.PhotoData;

import java.util.List;

public interface MarsPhotoService {

    List<Photo> getMarsPhotos();

    PhotoData enrichPhotoData(Photo photo);

}
