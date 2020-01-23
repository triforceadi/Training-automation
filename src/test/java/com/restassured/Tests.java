package com.restassured;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Tests {

    @Test(groups = {"Backend"}, priority = 0)
    public void PostResource() {
        // Resource is not really updated on the server but it will be faked in the name of testing. Source: https://jsonplaceholder.typicode.com/
        baseURI="https://jsonplaceholder.typicode.com/";
        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Content-type", "application/json; charset=UTF-8");
        JSONObject requestParams = new JSONObject();
        requestParams.put("title","animal");
        requestParams.put("body","cat");
        requestParams.put("userId","2");
        httpRequest.body(requestParams.toJSONString());
        Response response = httpRequest.post("/posts/");

        String responseBody = response.getBody().asString();
        System.out.println("PostResourceResponse:" + responseBody);

        int ActualStatusCode = response.getStatusCode();
        int ExpectedActualCode = 201;
        Assert.assertEquals(ActualStatusCode,ExpectedActualCode);
    }

    @Test(groups = {"Backend"}, priority = 1)
    public void GetResource() {
        // The resource that it gets is not the one above, it is a fake one provided by: https://jsonplaceholder.typicode.com/
        baseURI="https://jsonplaceholder.typicode.com/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/posts/2");

        String responseBody = response.getBody().asString();
        System.out.println("GetResourceBody:" + responseBody);

        Assert.assertTrue(responseBody.contains("id\": 2"));
        Assert.assertTrue(responseBody.contains("userId\": 1"));
    }

    @Test(groups = {"Backend"}, priority = 2)
    public void DeleteResource() {
        // The resource will be faked as being deleted
        baseURI="https://jsonplaceholder.typicode.com/";
        RequestSpecification DeleteResource = RestAssured.given();
        Response response =  DeleteResource.request(Method.DELETE,"posts/2");
        int ActualStatusCode = response.getStatusCode();
        System.out.println("StatusCode of DeleteResource:" + " " + ActualStatusCode);
    }

}
