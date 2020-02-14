package com.restassured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restassured.config.BaseConfig;
import restassured.config.CommentsEndpoint;
import restassured.config.PostsEndpoint;

import static io.restassured.RestAssured.*;

public class Tests extends BaseConfig {

    @Test(groups = {"Backend"}, priority = 0)
    public void PostACat() {
    PostsEndpoint jsonplaceholder = new PostsEndpoint("animal","cat","2","2");

    given().
            body(jsonplaceholder).
    when().
            post("/posts/").
    then().
            statusCode(201);
    }

    @Test(groups = {"Backend"}, priority = 0)
    public void PostADog() {
        PostsEndpoint jsonplaceholder = new PostsEndpoint("animal","dog","3","3");

        given().
                body(jsonplaceholder).
        when().
                post("/posts/").
        then().
                statusCode(201);
    }

    @Test(groups = {"Backend"}, priority = 1)
    public void GetResource() {
        Response response = get("/posts/2");
        String id = response.path("$.id");
        System.out.println(id);
        int Status = response.statusCode();
        int ExpectedStatus = 200;
        Assert.assertEquals(Status, ExpectedStatus);
    }

    @Test(groups = {"Backend"}, priority = 2)
    public void DeleteResource() {
        given().

        when().
                delete("/posts/2").
        then().
                statusCode(200);
    }

    @Test
    public void PutResource() {
        CommentsEndpoint putResource = new CommentsEndpoint("1","2","Rick and Morty","morty@rick.com","adventure time");
        given().
                body(putResource).
        when().
                put("comments/2").
        then().
                statusCode(200);
    }

}
