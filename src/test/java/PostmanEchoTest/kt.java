package PostmanEchoTest;

import io.restassured.RestAssured.given
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test

class PostmanEchoTest {

    @Test
    fun testPostRequest() {
        val requestBody = "some data"

        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body(requestBody)
                .`when`()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody)) // Проверка, что данные в ответе совпадают с отправленными
    }
}

