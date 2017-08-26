package io.enlightendev.athena;

public class ExampleConstants {

    public static String ATHENA_DEFAULT_DATABASE = "mb_athena";
    public static String ATHENA_OUTPUT_BUCKET = "console://datafilesroot/athenaoutput";
    public static String ATHENA_SAMPLE_QUERY = "SELECT count(*) as total FROM mb_athena.cloudfront_logs2;";

    public static int CLIENT_EXECUTION_TIMEOUT = 5000;
}
