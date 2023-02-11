package com.bobocode.bring.demo.app.service;

import com.bobocode.bring.demo.app.exception.MarsServiceException;
import com.bobocode.bring.demo.app.model.Photo;
import com.bobocode.bring.demo.app.model.PhotoData;
import com.bobocode.bring.demo.app.model.PhotoWrapper;
import com.bobocode.bring.demo.app.util.UriConverter;
import com.bringframework.annotation.Autowired;
import com.bringframework.annotation.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

@Component
public class MarsPhotoRemoteService implements MarsPhotoService {

    private static final Logger LOGGER = LoggerFactory.getLogger("MarsPhotoService");
    private static final String NASA_PHOTOS_URI = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=300&api_key=qWws2hdBXWMLsXsQpOhD05WhqLl9wjr3ns0grRHL";

    @Autowired
    private HttpClient httpClient;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UriConverter uriConverter;

    public List<Photo> getMarsPhotos() {
        try {
            HttpRequest request = HttpRequest.newBuilder(uriConverter.toUri(NASA_PHOTOS_URI)).GET().build();
            LOGGER.trace(request.toString());
            HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
            LOGGER.trace(response.toString());
            PhotoWrapper photoWrapper = objectMapper.readValue(response.body(), PhotoWrapper.class);
            return photoWrapper.photos();
        } catch (IOException | InterruptedException e) {
            throw new MarsServiceException("Unable to fetch photos", e);
        }
    }

    public PhotoData enrichPhotoData(Photo photo) {
        URI photoUri = uriConverter.toUri(photo.imgSrc());
        try {
            HttpRequest request = HttpRequest.newBuilder(photoUri)
                    .method("HEAD", BodyPublishers.noBody())
                    .build();
            LOGGER.trace(request.toString());
            HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
            LOGGER.trace(response.toString());
            long size = response.headers()
                    .firstValueAsLong("Content-Length")
                    .orElseThrow();
            return new PhotoData(photo, response.uri(), size);
        } catch (IOException | InterruptedException e) {
            throw new MarsServiceException("Unable to head for photo: " + photoUri, e);
        }
    }

}
