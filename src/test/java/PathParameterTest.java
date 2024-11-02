import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PathParameterTest {

	// GetBookingID details
	public static void getBookingDetailsByID() {

		RequestSpecification reqSpec = RestAssured.given().baseUri("https://restful-booker.herokuapp.com/")
				.basePath("{pathName}/{bookingID}").header("Content-Type", "applicatin/json")
				.pathParam("pathName", "booking").pathParam("bookingID", 2).log().all();

		Response response = reqSpec.when().get();

		ValidatableResponse vresponse = response.then();

		vresponse.header("Content-Type", "application/json; charset=utf-8").assertThat().statusCode(200).log().all();
		System.out.println("First name : " + response.jsonPath().get("firstname").toString());
		System.out.println("Last name : " + response.jsonPath().get("lastname").toString());
		System.out.println("Total price : " + response.jsonPath().getInt("totalprice"));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getBookingDetailsByID();
	}

}
