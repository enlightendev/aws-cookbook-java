package io.enlightendev.dynamo;

/**
 *
 * http://docs.aws.amazon.com/amazondynamodb/latest/gettingstartedguide/GettingStarted.Java.html
 * http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/JavaDocumentAPITablesExample.html
 */
public class DynamoScratch {

//    private DynamoDB dynamoDB;
//
//    public DynamoScratch(){
//
//        //for local dynamo
//        AmazonDynamoDBClient client = new AmazonDynamoDBClient().withEndpoint("http://localhost:8000");
//
////        AmazonDynamoDBClient client = new AmazonDynamoDBClient(new ProfileCredentialsProvider());
//        dynamoDB = new DynamoDB(client);
//
//    }
//
//    private DynamoScratch createWatchListTable(){
//        try {
//            System.out.println("Attempting to create table; please wait...");
//
//            Table table = dynamoDB.createTable("watchlist",
//
//                    Arrays.asList(
//                            new KeySchemaElement("year", KeyType.HASH),  //Partition key
//                            new KeySchemaElement("title", KeyType.RANGE)), //Sort key
//
//                    Arrays.asList(
//                            new AttributeDefinition("year", ScalarAttributeType.N),
//                            new AttributeDefinition("title", ScalarAttributeType.S)),
//
//                    new ProvisionedThroughput(5L, 5L)
//            );
//
//            table.waitForActive();
//
//            System.out.println("Success. Table status: " + table.getDescription().getTableStatus());
//
//        } catch (Exception e) {
//            System.err.println("Unable to create table: ");
//            System.err.println(e.getMessage());
//        }
//
//        return this;
//    }
//
//    private DynamoScratch createTestTable(String tableName){
//
//        try {
//            ArrayList<AttributeDefinition> attributeDefinitions = new ArrayList<>();
//
//            attributeDefinitions.add(new AttributeDefinition().withAttributeName("Id").withAttributeType("N"));
//
//            ArrayList<KeySchemaElement> keySchema = new ArrayList<>();
//
//            keySchema.add(new KeySchemaElement().withAttributeName("Id").withKeyType(KeyType.HASH));
//
//            CreateTableRequest createTableRequest = new CreateTableRequest()
//                    .withTableName(tableName)
//                    .withKeySchema(keySchema)
//                    .withAttributeDefinitions(attributeDefinitions)
//                    .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(5L).withWriteCapacityUnits(5L));
//
//
//            Table table = dynamoDB.createTable(createTableRequest);
//
//            System.out.println("Waiting for " + tableName + " to be created...this may take a while...");
//
//            table.waitForActive();
//
//        } catch (Exception e){
//
//            System.err.println("CreateTable request failed for " + tableName);
//            System.err.println(e.getMessage());
//
//        }
//
//        return this;
//
//    }
//
//    /**
//     *
//     * @return
//     */
//    private DynamoScratch listTables(){
//
//        TableCollection<ListTablesResult> tables = dynamoDB.listTables();
//
//        Iterator<Table> iterator = tables.iterator();
//
//        while (iterator.hasNext()){
//            Table table = iterator.next();
//            System.out.println("Table: " + table.getTableName());
//        }
//
//        return this;
//
//    }
//
//    private DynamoScratch getTableInfo(String tableName){
//
//        Table table = dynamoDB.getTable(tableName);
//        table.describe();
//
//        if(table != null) {
//
//            TableDescription tableDescription = table.getDescription();
//
//            System.out.format("Name: %s:\n" + "Status: %s \n"
//                            + "Provisioned Throughput (read capacity units/sec): %d \n"
//                            + "Provisioned Throughput (write capacity units/sec): %d \n",
//                    tableDescription.getTableName(),
//                    tableDescription.getTableStatus(),
//                    tableDescription.getProvisionedThroughput().getReadCapacityUnits(),
//                    tableDescription.getProvisionedThroughput().getWriteCapacityUnits());
//
//        } else {
//
//            System.out.println("No table: " + tableName);
//
//        }
//
//        return this;
//    }
//
//    private DynamoScratch deleteExampleTable(String tableName) {
//
//        Table table = dynamoDB.getTable(tableName);
//        try {
//            System.out.println("Issuing DeleteTable request for " + tableName);
//            table.delete();
//
//            System.out.println("Waiting for " + tableName
//                    + " to be deleted...this may take a while...");
//
//            table.waitForDelete();
//        } catch (Exception e) {
//            System.err.println("DeleteTable request failed for " + tableName);
//            System.err.println(e.getMessage());
//        }
//
//        return  this;
//    }
//
//
//    public static void main(String[] args) throws Exception {
//
//        String TABLE_NAME = "TestTable";
//
//        new DynamoScratch()
////                .createWatchListTable()
////                .createTestTable(TABLE_NAME)
//                .listTables()
//                .getTableInfo(TABLE_NAME)
////                .deleteExampleTable(TABLE_NAME);
//                ;
//
//    }
}
