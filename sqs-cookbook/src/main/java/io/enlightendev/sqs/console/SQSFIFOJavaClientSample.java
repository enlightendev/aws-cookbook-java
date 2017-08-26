package io.enlightendev.sqs.console;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.DeleteQueueRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import io.enlightendev.sqs.SQSUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class SQSFIFOJavaClientSample {

    public static void main(String[] args) throws Exception {


        AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
//        sqs.setEndpoint("https://sqs.us-east-1.amazonaws.com");

        System.out.println("=======================================================");
        System.out.println("Getting Started with Amazon SQS FIFO Queues");
        System.out.println("=======================================================\n");

        try {

            // Create a FIFO queue
            System.out.println("Creating a new Amazon SQS FIFO queue called MyFifoQueue.fifo.\n");
            Map<String, String> attributes = new HashMap<String, String>();

            // A FIFO queue must have the FifoQueue attribute set to True
            attributes.put("FifoQueue", "true");

            // Generate a MessageDeduplicationId based on the content, if the user doesn't provide a MessageDeduplicationId
            attributes.put("ContentBasedDeduplication", "true");

            // The FIFO queue name must end with the .fifo suffix
            CreateQueueRequest createQueueRequest = new CreateQueueRequest("MyFifoQueue.fifo").withAttributes(attributes);
            String myQueueUrl = sqs.createQueue(createQueueRequest).getQueueUrl();

            // List queues
            System.out.println("Listing all queues in your account.\n");
            for (String queueUrl : sqs.listQueues().getQueueUrls()) {
                System.out.println("  QueueUrl: " + queueUrl);
            }
            System.out.println();

            // Send a message
            System.out.println("Sending a message to MyFifoQueue.fifo.\n");
            SendMessageRequest sendMessageRequest = new SendMessageRequest(myQueueUrl, "This is my message text.");

            // You must provide a non-empty MessageGroupId when sending messages to a FIFO queue
            sendMessageRequest.setMessageGroupId("messageGroup1");
            // Uncomment the following to provide the MessageDeduplicationId
            sendMessageRequest.setMessageDeduplicationId("1");


            SendMessageResult sendMessageResult = sqs.sendMessage(sendMessageRequest);
            String sequenceNumber = sendMessageResult.getSequenceNumber();
            String messageId = sendMessageResult.getMessageId();
            System.out.println("SendMessage succeed with messageId " + messageId + ", sequence number " + sequenceNumber + "\n");

            // Receive messages
            System.out.println("Receiving messages from MyFifoQueue.fifo.\n");
            ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(myQueueUrl);
            // Uncomment the following to provide the ReceiveRequestDeduplicationId
            //receiveMessageRequest.setReceiveRequestAttemptId("1");
            List<Message> messages = sqs.receiveMessage(receiveMessageRequest).getMessages();
            SQSUtil.printSQSMessages(messages);
            System.out.println();

            // Delete the message
            System.out.println("Deleting the message.\n");
            String messageReceiptHandle = messages.get(0).getReceiptHandle();
            sqs.deleteMessage(new DeleteMessageRequest(myQueueUrl, messageReceiptHandle));

            // Delete the queue
            System.out.println("Deleting the queue.\n");
            sqs.deleteQueue(new DeleteQueueRequest(myQueueUrl));
        } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which means your request made it " +
                    "to Amazon SQS, but was rejected with an error response for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which means the client encountered " +
                    "a serious internal problem while trying to communicate with SQS, such as not " +
                    "being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }
    }

}
