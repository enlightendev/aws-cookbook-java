package io.enlightendev.athena;

import com.amazonaws.athena.jdbc.shaded.com.amazonaws.ClientConfiguration;
import com.amazonaws.athena.jdbc.shaded.com.amazonaws.services.athena.AmazonAthena;
import com.amazonaws.athena.jdbc.shaded.com.amazonaws.services.athena.AmazonAthenaClientBuilder;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.regions.Regions;

public class AthenaClientFactory
{
    /**
     * AmazonAthenaClientBuilder to build AmazonAthena with the following properties:
     * - Set the region of the client
     * - Use Instance Profile from EC2 instance as its CredentialsProvider
     * - Configure the client to increase the execution timeout.
     */

    public AmazonAthena createClient()
    {
//        InstanceProfileCredentialsProvider instanceProfileCredentialsProvider =
//                InstanceProfileCredentialsProvider.getInstance();
//
//        AWSCredentials awsCredentials = instanceProfileCredentialsProvider.getCredentials();

        AmazonAthenaClientBuilder builder = AmazonAthenaClientBuilder.standard()
                .withRegion(Regions.US_EAST_1.getName())
//                .withCredentials(instanceProfileCredentialsProvider)
                .withClientConfiguration(new ClientConfiguration().withClientExecutionTimeout(ExampleConstants.CLIENT_EXECUTION_TIMEOUT));


        return builder.build();
    }
}
