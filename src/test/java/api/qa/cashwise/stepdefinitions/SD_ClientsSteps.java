package api.qa.cashwise.stepdefinitions;

import api.qa.cashwise.endpoints.EP_Client;
import io.cucumber.java.en.Then;

public class SD_ClientsSteps {
    EP_Client epClient = new EP_Client();
    @Then("User validates {string}, {string}, {string} and {string} from end-point")
    public void user_validates_and_from_end_point(String expectedCompanyName, String nameTag
            , String tagCompanyName, String expectedEmail) {

        epClient.validateCreateClientData(expectedCompanyName, nameTag, tagCompanyName, expectedEmail);
    }

    @Then("User validates {string}, {string}, {string} and {string} from end-point Get")
    public void user_validates_and_from_end_point_get(String expectedCompanyName, String nameTag
            , String tagCompanyName, String expectedEmail) {
        epClient.validateGetClientInformation(expectedCompanyName, nameTag, tagCompanyName, expectedEmail);
    }

    @Then("User validates {string}, {string}, {string} and {string} from end-point Put")
    public void user_validates_and_from_end_point_put(String expectedCompanyName, String nameTag
            , String tagCompanyName, String expectedEmail) {
            epClient.validatePutCreateClient(expectedCompanyName, nameTag, tagCompanyName,expectedEmail);
    }

    @Then("User validates {string}, {string}, {string} and {string} from end-point Delete")
    public void user_validates_and_from_end_point_delete(String expectedCompanyName, String nameTag
            , String tagCompanyName, String expectedEmail) {
        epClient.validateDeleteClientInformation(expectedCompanyName, nameTag, tagCompanyName, expectedEmail);
    }

    @Then("User validates {string} and {string}")
    public void user_validates(String expectedMessage ,String expectedDetails) {
        epClient.validateGetDeletedClientInformation(expectedMessage, expectedDetails);
    }
}
