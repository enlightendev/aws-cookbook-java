package io.enlightendev.dynamo;


import software.amazon.awssdk.auth.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDBClient;
import software.amazon.awssdk.services.dynamodb.model.ListTablesRequest;
import software.amazon.awssdk.services.dynamodb.model.ListTablesResponse;

public class CreateTable {

//    static String tableName = "User";
//    static String hashKeyName = "username";
//    static String hashKeyType = "S";
//    static long readCapacityUnits = 1;
//    static long writeCapacityUnits = 1;
//
////    static DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(new ProfileCredentialsProvider()));
//    //static DynamoDB dynamoDB = new DynamoDB(new AmazonDynamoDBClient(AWSCredentialsFactory.getCredentials(AWSCredentialsFactory.CLASSPATH_PROPERTIES)));
//
//    static AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.defaultClient();
//
////    private static void deleteTable() throws InterruptedException {
////
////        Table table = amazonDynamoDB.getTable(tableName);
////
////        System.out.print("delete('" + tableName + "') ... ");
////        table.delete();
////        table.waitForDelete();
////        System.out.println("DONE");
////    }
//
//    private static void createTable() throws InterruptedException {
//
//        ArrayList<KeySchemaElement> keySchema = new ArrayList<KeySchemaElement>();
//        keySchema.add(new KeySchemaElement()
//                .withAttributeName(hashKeyName)
//                .withKeyType(KeyType.HASH));
//
//        ArrayList<AttributeDefinition> attributeDefinitions = new ArrayList<AttributeDefinition>();
//        attributeDefinitions.add(new AttributeDefinition()
//                .withAttributeName(hashKeyName)
//                .withAttributeType(hashKeyType));
//
//        CreateTableRequest request = new CreateTableRequest()
//                .withTableName(tableName)
//                .withKeySchema(keySchema)
//                .withProvisionedThroughput(new ProvisionedThroughput()
//                        .withReadCapacityUnits(readCapacityUnits)
//                        .withWriteCapacityUnits(writeCapacityUnits));
//
//        request.setAttributeDefinitions(attributeDefinitions);
//
//        System.out.print("createTable('" + tableName + "') ... ");
//
//        CreateTableResult createTableResult = amazonDynamoDB.createTable(request);
//
//        System.out.println("DONE");
//    }

//    private static void loadData() {
//
//        Table table = dynamoDB.getTable(tableName);
//
//        Item item = new Item()
//                .withPrimaryKey("username", "Dhruv")
//                .withNumber("userid", 123)
//                .withString("passwordhash", "8743b52063cd84097a65d1633f5c74f5");
//
//        System.out.print("putItem() ... ");
//        table.putItem(item);
//        System.out.println("DONE");
//    }

    private static void listTables(DynamoDBClient client){




        ListTablesResponse response = client.listTables(ListTablesRequest.builder()
                .limit(5)
                .build());

        response.tableNames().forEach(System.out::println);
    }

    public static void main(String[] args) {
        try {
            DynamoDBClient client = DynamoDBClient.builder()
                    .region(Region.US_EAST_1)
                    .credentialsProvider(ProfileCredentialsProvider.builder()
                            .profileName("default")
                            .build())
                    .build();

           // deleteTable();
//            createTable();
//            loadData();

            listTables(client);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
