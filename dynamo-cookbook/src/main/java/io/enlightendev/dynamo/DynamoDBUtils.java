package io.enlightendev.dynamo;


/**
 *
 */
public class DynamoDBUtils {
//
//    public static void buildTable(DynamoDBClient ddbClient, String tableName) {
//
//        System.out.println("Creating table.");
//
//        CreateTableRequest createTableRequest = new CreateTableRequest().withTableName(tableName);
//
//        createTableRequest.setAttributeDefinitions(new ArrayList<AttributeDefinition>());
//        // Define attributes
//        createTableRequest.getAttributeDefinitions().add(
//                new AttributeDefinition().withAttributeName("Company").withAttributeType("S"));
//        createTableRequest.getAttributeDefinitions().add(
//                new AttributeDefinition().withAttributeName("Email").withAttributeType("S"));
//        // Define key schema
//        createTableRequest.setKeySchema(new ArrayList<KeySchemaElement>());
//        createTableRequest.getKeySchema().add(new KeySchemaElement().withAttributeName("Company").withKeyType("HASH"));
//        createTableRequest.getKeySchema().add(new KeySchemaElement().withAttributeName("Email").withKeyType("RANGE"));
//
//        // Define provisioned throughput
//        createTableRequest.setProvisionedThroughput(
//                new ProvisionedThroughput()
//                        .withReadCapacityUnits(10L)
//                        .withWriteCapacityUnits(5L)
//        );
//
//        // Submit create request
//        ddbClient.createTable(createTableRequest);
//
//        // Pause until the table is active
//        waitForStatus(ddbClient, tableName, "ACTIVE");
//
//        System.out.println("Table created and active.");
//    }
//
//    public static void waitForStatus(AmazonDynamoDB ddbClient, String tableName, String status) {
//
//        while (!getTableStatus(ddbClient, tableName).equals(status)) {
//            // Sleep for one second.
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                // Just gobble up the exception.
//            }
//        }
//    }
//
//    public static String getTableStatus(AmazonDynamoDB ddbClient, String tableName) {
//
//        TableDescription tableDescription = getTableDescription(ddbClient, tableName);
//        if (tableDescription == null) {
//            return "NOTFOUND";
//        }
//
//        return tableDescription.getTableStatus();
//    }
//
//    public static TableDescription getTableDescription(AmazonDynamoDB amazonDynamoDBClient, String tableName) {
//
//        try {
//            DescribeTableRequest describeTableRequest = new DescribeTableRequest().withTableName(tableName);
//
//            DescribeTableResult describeTableResult = amazonDynamoDBClient.describeTable(describeTableRequest);
//
//            return describeTableResult.getTable();
//        } catch (AmazonServiceException ase) {
//            // If the table isn't found, there's no problem.
//            // If the error is something else, re-throw the exception to bubble it up to the caller.
//            if (!ase.getErrorCode().equals("ResourceNotFoundException")) {
//                throw ase;
//            }
//            return null;
//        }
//    }
//
//    public static void deleteTable(AmazonDynamoDBClient ddbClient, String tableName) {
//
//        String tableStatus = getTableStatus(ddbClient, tableName);
//        if (tableStatus.equals("ACTIVE")) {
//            System.out.println("Deleting pre-existing table.");
//            DeleteTableRequest deleteTableRequest = new DeleteTableRequest().withTableName(tableName);
//            ddbClient.deleteTable(deleteTableRequest);
//            waitForStatus(ddbClient, tableName, "NOTFOUND");
//
//            System.out.println("Table deletion confirmed.");
//        } else if (tableStatus.equals("NOTFOUND")) {
//            System.out.println("Skipped deletion operation. Table not found.");
//        } else {
//            System.out.println("Skipped deletion operation. Table not in correct state.");
//        }
//    }
}