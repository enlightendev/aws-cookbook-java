package io.enlightendev.web.controller;

import io.enlightendev.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 *
 */
@RestController
public class S3Controller {

    @Autowired
    public S3Service s3Service;

    @RequestMapping("/buckets")
    public String[] listBuckets(){
        return s3Service.listBuckets();
    }

    @RequestMapping("/create")
    public void createBuckets() throws IOException {
        s3Service.createBucket();
    }

    @RequestMapping("/objects")
    public void listObjects() {
        s3Service.listObjects();
    }

    @RequestMapping("/deleteObject")
    public void deleteObject() {
        s3Service.deleteObject();
    }

    @RequestMapping("/deletebucket")
    public void deleteBucket() {
        s3Service.deleteBucket();
    }

}