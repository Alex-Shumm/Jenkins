package api.qa.cashwise.utils;

public class APIJsonData {

    public static String createClient(String company_name, String email) {
        return "{\n" +
                "  \"company_name\": \"" + company_name + "\",\n" +
                "  \"client_name\": \"Oleg Shuma\",\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"phone_number\": \"123456789\",\n" +
                "  \"address\": \"123 Main st\",\n" +
                "  \"tags_id\": [\n" +
                "    99\n" +
                "  ]\n" +
                "}";
    }

    public static String updateClient(String company_name, String email) {
        return "{\n" +
                "  \"company_name\": \"NewName\",\n" +
                "  \"client_name\": \"Alex\",\n" +
                "  \"email\": \"Alex@gmail.com\",\n" +
                "  \"phone_number\": \"2222222222\",\n" +
                "  \"address\": \"123 Oak st\",\n" +
                "  \"tags_id\": [\n" +
                "    98\n" +
                "  ]\n" +
                "}";
    }
}
