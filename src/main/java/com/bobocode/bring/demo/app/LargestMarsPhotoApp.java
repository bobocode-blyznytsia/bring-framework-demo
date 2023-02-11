package com.bobocode.bring.demo.app;

import com.bobocode.bring.demo.app.model.PhotoData;
import com.bobocode.bring.demo.app.service.LargestPhotoService;
import com.bringframework.BringApplication;
import com.bringframework.context.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LargestMarsPhotoApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(LargestMarsPhotoApp.class);

    public static void main(String[] args) {
        BringApplication bringApplication = new BringApplication("com.bobocode.bring.demo.app");
        ApplicationContext context = bringApplication.run();

        LargestPhotoService largestPhotoService = context.getBean(LargestPhotoService.class);
        PhotoData largestPhoto = largestPhotoService.findLargestPhoto();
        LOGGER.info("The largest photo url is {}", largestPhoto.uri());
        LOGGER.info("The largest photo details {}", largestPhoto);
    }

}
