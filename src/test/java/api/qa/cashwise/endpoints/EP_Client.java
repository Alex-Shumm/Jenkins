package api.qa.cashwise.endpoints;

import api.qa.cashwise.pojos.clients.PJ_Client;
import api.qa.cashwise.utils.APIJsonData;
import api.qa.cashwise.utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

public class EP_Client {

    final String json="application/json";

    public void validateCreateClientData(String expectedCompanyName, String nameTag
    , String tagCompanyName, String expectedEmail){

        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("create_client");

        Response response = RestAssured.given().header("Content-Type", json).accept(ContentType.JSON)
                .header("Authorization", ConfigReader.readProperty("token"))
                .body(APIJsonData.createClient(expectedCompanyName, expectedEmail))
                .when().post().then().log().body().statusCode(201).extract().response();

        PJ_Client deserializedResponse = response.as(PJ_Client.class);
        Assert.assertEquals(expectedCompanyName, deserializedResponse.getCompany_name());
        Assert.assertEquals(expectedEmail, deserializedResponse.getEmail());
        Assert.assertEquals(nameTag, deserializedResponse.getTags().get(0).getNameTag());
        Assert.assertEquals(tagCompanyName, deserializedResponse.getTags().get(0).getCompany().getCompanyName());
    }

    public void validateGetClientInformation(String expectedCompanyName, String nameTag
            , String tagCompanyName, String expectedEmail){

        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("get_client");

        Response response = RestAssured.given()
                .header("Authorization", ConfigReader.readProperty("token"))
                .when().get().then().log().body().statusCode(200).extract().response();

        PJ_Client deserializedResponse = response.as(PJ_Client.class);
        Assert.assertEquals(expectedCompanyName, deserializedResponse.getCompany_name());
        Assert.assertEquals(expectedEmail, deserializedResponse.getEmail());
        Assert.assertEquals(nameTag, deserializedResponse.getTags().get(0).getNameTag());
        Assert.assertEquals(tagCompanyName, deserializedResponse.getTags().get(0).getCompany().getCompanyName());
    }

    public void validatePutCreateClient(String expectedCompanyName, String nameTag
            , String tagCompanyName, String expectedEmail){

        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("update_client");

        Response response = RestAssured.given().header("Content-Type", json).accept(ContentType.JSON)
                .header("Authorization", ConfigReader.readProperty("token"))
                .body(APIJsonData.updateClient(expectedCompanyName, expectedEmail))
                .when().put().then().log().body().statusCode(200).extract().response();

        PJ_Client deserializedResponse = response.as(PJ_Client.class);
        Assert.assertEquals(expectedCompanyName, deserializedResponse.getCompany_name());
        Assert.assertEquals(expectedEmail, deserializedResponse.getEmail());
        Assert.assertEquals(nameTag, deserializedResponse.getTags().get(0).getNameTag());
        Assert.assertEquals(tagCompanyName, deserializedResponse.getTags().get(0).getCompany().getCompanyName());
    }

    public void validateDeleteClientInformation(String expectedCompanyName, String nameTag
            , String tagCompanyName, String expectedEmail){

        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("delete_client");

        Response response = RestAssured.given()
                .header("Authorization", ConfigReader.readProperty("token"))
                .when().delete().then().log().body().statusCode(200).extract().response();

        PJ_Client deserializedResponse = response.as(PJ_Client.class);
        Assert.assertEquals(expectedCompanyName, deserializedResponse.getCompany_name());
        Assert.assertEquals(expectedEmail, deserializedResponse.getEmail());
        Assert.assertEquals(nameTag, deserializedResponse.getTags().get(0).getNameTag());
        Assert.assertEquals(tagCompanyName, deserializedResponse.getTags().get(0).getCompany().getCompanyName());
    }

    public void validateGetDeletedClientInformation(String expectedMessage, String expectedDetails){

        RestAssured.baseURI = ConfigReader.readProperty("base_url");
        RestAssured.basePath = ConfigReader.readProperty("get_client");

        Response response = RestAssured.given()
                .header("Authorization", ConfigReader.readProperty("token"))
                .when().get().then().log().body().statusCode(500).extract().response();

        PJ_Client deserializedResponse = response.as(PJ_Client.class);
        Assert.assertEquals(expectedMessage, deserializedResponse.getMessage());
        Assert.assertEquals(expectedDetails, deserializedResponse.getDetails().get(0));
    }
}
