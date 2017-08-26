package io.enlightendev.service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juan on 4/20/17.
 */
@Service
public class S3Service {

    private String bucketName = "mb-dummy-bucket";

    @Autowired
    AmazonS3 amazonS3;

    public String[] listBuckets() {

        List<String> buckets = new ArrayList<>();

        try {

            for (Bucket bucket : amazonS3.listBuckets()) {
                buckets.add(bucket.getName());
            }

        } catch (AmazonServiceException ase) {

            S3Util.printExceptionMessageDetails(ase);

        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with S3, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }

        return buckets.toArray(new String[buckets.size()]);
    }



    public void createBucket() throws IOException {

        amazonS3.createBucket(bucketName);

            /*
             * Upload an object to your bucket - You can easily upload a file to
             * S3, or upload directly an InputStream if you know the length of
             * the data in the stream. You can also specify your own metadata
             * when uploading to S3, which allows you set a variety of options
             * like content-type and content-encoding, plus additional metadata
             * specific to your applications.
             */
        System.out.println("Uploading a new object to S3 from a file\n");
        amazonS3.putObject(new PutObjectRequest(bucketName, "dummy_object", S3Util.createSampleFile()));

    }

    /**
     * List objects in your bucket by prefix - There are many options for
     * listing the objects in your bucket.  Keep in mind that buckets with
     * many objects might truncate their results when listing their objects,
     * so be sure to check if the returned object listing is truncated, and
     * use the AmazonS3.listNextBatchOfObjects(...) operation to retrieve
     * additional results.
     */
    public void listObjects() {

        System.out.println("Listing objects");

        ObjectListing objectListing =
                amazonS3.listObjects(
                        new ListObjectsRequest()
                            .withBucketName(bucketName)
                            .withPrefix("dummy_object")
                );

        for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
            System.out.println(" - " + objectSummary.getKey() + "  " +
                    "(size = " + objectSummary.getSize() + ")");
        }
        System.out.println();

    }

    /**
     * Delete an object - Unless versioning has been turned on for your bucket,
     * there is no way to undelete an object, so use caution when deleting objects.
     */
    public void deleteObject() {

        System.out.println("Deleting an object\n");
        amazonS3.deleteObject(bucketName, "dummy_object");

    }

    /**
     * Delete a bucket - A bucket must be completely empty before it can be
     * deleted, so remember to delete any objects from your buckets before
     * you try to delete them.
     */
    public void deleteBucket() {

        System.out.println("Deleting bucket " + bucketName + "\n");
        amazonS3.deleteBucket(bucketName);

    }

}
