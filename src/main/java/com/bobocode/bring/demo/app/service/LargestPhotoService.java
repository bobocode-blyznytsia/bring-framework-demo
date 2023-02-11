package com.bobocode.bring.demo.app.service;

import com.bobocode.bring.demo.app.exception.PhotoNotFoundException;
import com.bobocode.bring.demo.app.model.Photo;
import com.bobocode.bring.demo.app.model.PhotoData;
import com.bringframework.annotation.Autowired;
import com.bringframework.annotation.Component;
import com.bringframework.annotation.Qualifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;

@Component
public class LargestPhotoService {

    private static final Logger log = LoggerFactory.getLogger(LargestPhotoService.class);

    @Autowired
    @Qualifier("marsPhotoRemoteService")
    private MarsPhotoService marsPhotoService;

    public PhotoData findLargestPhoto() {
        List<Photo> marsPhotos = marsPhotoService.getMarsPhotos();
        log.debug("Received `{}` mars photos", marsPhotos.size());
        return marsPhotos.stream()
                .parallel()
                .map(marsPhotoService::enrichPhotoData)
                .max(Comparator.comparing(PhotoData::size))
                .orElseThrow(PhotoNotFoundException::new);
    }

}
