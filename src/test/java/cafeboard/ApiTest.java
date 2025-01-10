package cafeboard;
import cafeboard.Board.Board;
import cafeboard.Board.CreateBoardRequest;
import cafeboard.Board.ReadBoardResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTest {

    @LocalServerPort
    int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void 상품목록생성() {
        RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(new CreateBoardRequest("게시판 생성 테스트중입니다."))
                .when()
                .post("/boards") // POST /members 요청
                .then().log().all()
                .statusCode(200);

    }
    @Test
    void createDate검증() {
        Board board = RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(new CreateBoardRequest("게시판 생성 테스트중입니다."))
                .when()
                .post("/boards") // POST /members 요청
                .then().log().all()
                .statusCode(200).extract().as(Board.class);

        System.out.println(board.getCreateTime());
        assertThat(board.getId()).isEqualTo(1);
        assertThat(board.getTitle()).isEqualTo("게시판 생성 테스트중입니다.");

    }

}