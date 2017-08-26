package io.enlightendev.dynamo;


/**
 *
 */
public class DynamoDBApp {

    //OLD SDK


//    private AmazonDynamoDB amazonDynamoDB;
//
//    public static final String ACCOUNT_TABLE = "Accounts";
//
//    public DynamoDBApp(){
//
//        amazonDynamoDB = AmazonDynamoDBClientBuilder.defaultClient();
//
//    }
//
//    private void createTable(){
//
//        DynamoDBUtils.buildTable(amazonDynamoDB, ACCOUNT_TABLE);
//
//    }
//
//    private void describeTable(String tableName){
//
//        DescribeTableRequest describeTableRequest = new DescribeTableRequest()
//                .withTableName(tableName);
//
//        DescribeTableResult tableDescription = amazonDynamoDB.describeTable(describeTableRequest);
//
//        System.out.println(tableDescription.toString());
//
//    }
//
//    public void populateTable(){
//
//        List<Account> accounts = new ArrayList<Account>();
//        accounts.add(new Account().withCompany("Amazon.com").withEmail("johndoe@amazon.com").withFirst("John")
//                .withLast("Doe").withAge("33"));
//        accounts.add(new Account().withCompany("Asperatus Tech").withEmail("janedoe@amazon.com").withFirst("Jane")
//                .withLast("Doe").withAge("24"));
//        accounts.add(new Account().withCompany("Amazon.com").withEmail("jimjohnson@amazon.com").withFirst("Jim")
//                .withLast("Johnson"));
//
//        for(Account account: accounts){
//            createAccountItem(amazonDynamoDB, ACCOUNT_TABLE, account);
//        }
//    }
//
//    public void createAccountItem(AmazonDynamoDB ddbClient, String tableName, Account account) {
//
//        // Create a HashMap<String, AttributeValue> object to hold the attributes of the item to add.
//        Map<String, AttributeValue> itemAttributes = new HashMap<String, AttributeValue>();
//        // Add the required items (Company and Email) from the account parameter to the attribute HashMap.
//        itemAttributes.put("Company", new AttributeValue().withS(account.getCompany()));
//        itemAttributes.put("Email", new AttributeValue().withS(account.getEmail()));
//
//        // Check the account parameter and add all values that aren't empty strings ("") to the attribute HashMap.
//        if (!account.getFirst().equals("")) {
//            itemAttributes.put("First", new AttributeValue().withS(account.getFirst()));
//        }
//        if (!account.getLast().equals("")) {
//            itemAttributes.put("Last", new AttributeValue().withS(account.getLast()));
//        }
//        if (!account.getAge().equals("")) {
//            itemAttributes.put("Age", new AttributeValue().withN(account.getAge()));
//        }
//
//        // Construct a PutItemRequest object to put the attributes into the specified table.
//        PutItemRequest putItemRequest = new PutItemRequest().withTableName(tableName).withItem(itemAttributes);
//
//        // Submit the request using the putItem method of the ddbClient object.
//        ddbClient.putItem(putItemRequest);
//    }
//
//    public QueryResult lookupByHashKey(String tableName, String company) {
//
//        // Construct an AttributeValue object containing the provided company name.
//        AttributeValue attributeValue = new AttributeValue().withS(company);
//
//        // Construct a Condition object containing the desired comparison ("EQ") and the attribute value
//        // containing the company name.
//        Condition condition = new Condition().withComparisonOperator("EQ").withAttributeValueList(attributeValue);
//
//        // Construct a QueryRequest object that performs a consistent read on the specified table for the
//        // previously constructed condition.
//        QueryRequest queryRequest = new QueryRequest().withTableName(tableName).withConsistentRead(true);
//        queryRequest.addKeyConditionsEntry("Company", condition);
//
//        // Submit the query by calling the query method of the ddbClient object and return the result.
//        return amazonDynamoDB.query(queryRequest);
//    }
//
//    public static void main(String[] args) {
//
//        DynamoDBApp dynamoDBApp = new DynamoDBApp();
//        dynamoDBApp.createTable();
//        dynamoDBApp.describeTable(DynamoDBApp.ACCOUNT_TABLE);
//        dynamoDBApp.populateTable();
//
//        QueryResult queryResult = dynamoDBApp.lookupByHashKey(DynamoDBApp.ACCOUNT_TABLE, "Amazons.com");
//
//        if (queryResult != null && queryResult.getCount() > 0) {
//            // Record was found
//            for (Map<String, AttributeValue> item : queryResult.getItems()) {
//                System.out.println("Item Found-");
//
//                for (Map.Entry<String, AttributeValue> attribute : item.entrySet()) {
//                    System.out.print("    " + attribute.getKey() + ":");
//                    if (attribute.getKey().equals("Age")) {
//                        System.out.println(attribute.getValue().getN());
//                    } else {
//                        System.out.println(attribute.getValue().getS());
//                    }
//                }
//            }
//        } else {
//            System.out.println("No matches found.");
//        }
//    }
}