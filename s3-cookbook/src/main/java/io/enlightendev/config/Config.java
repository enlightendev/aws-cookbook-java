package io.enlightendev.config;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Juan on 4/20/17.
 */
@Configuration
public class Config {

    @Bean
    public AmazonS3 get(){
        return AmazonS3ClientBuilder.defaultClient();
    }

}
