package io.enlightendev.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import io.enlightendev.sqs.SQSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class SQSService {

    @Autowired
    AmazonSQS amazonSQSClient;

    @Value("${aws.sqs.simpleQueueURL}")
    private String simpleQueueURL;

    public void readFromSQS() {

        // Receive messages
        System.out.println("Receiving messages from MyQueue.\n");
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(simpleQueueURL);

        List<Message> messages = amazonSQSClient.receiveMessage(receiveMessageRequest).getMessages();

        SQSUtil.printSQSMessages(messages);

        // Delete a message
        System.out.println("Deleting a message.\n");
        String messageReceiptHandle = messages.get(0).getReceiptHandle();
        amazonSQSClient.deleteMessage(new DeleteMessageRequest(simpleQueueURL, messageReceiptHandle));

    }

    public void listQueues() {

        System.out.println("Listing all queues in your account.\n");
        for (String queueUrl : amazonSQSClient.listQueues().getQueueUrls()) {
            System.out.println("  QueueUrl: " + queueUrl);
        }
        System.out.println();

    }
}
