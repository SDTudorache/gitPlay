package com.qa.framework.client;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class BasketClient {

    public String createBasket() {
        return given()
                .post("/api/baskets")
                .then()
                .statusCode(201)
                .extract()
                .path("id");
    }

    public void addItem(String basketId, int productId, int quantity) {
        given()
            .contentType("application/json")
            .body("""
                    {
                      "productId": %d,
                      "quantity": %d
                    }
                    """.formatted(productId, quantity))
            .post("/api/baskets/%s/items".formatted(basketId))
            .then()
            .statusCode(201);
    }

    public Response calculate(String basketId) {
        return given()
                .get("/api/baskets/%s/calculate".formatted(basketId));
    }
}
