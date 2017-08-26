package io.enlightendev.config;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class Config {

    @Value("${aws.sqs.simpleQueueURL}")
    private String messageValidationQueue;

    @Bean
    AmazonSQS getClient() {
        return AmazonSQSClientBuilder.defaultClient();
    }
}