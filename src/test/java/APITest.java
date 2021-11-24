import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import io.restassured.response.Response;


public class APITest {
	@Test(description = "Validating response")
	public void ApiValidation1()
		{
			String url = "https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false";
			Response response = given().when().get(url);
			System.out.println(response.body().asPrettyString());
			response.then()
			.body("Name", equalTo("Carbon credits"),
				  "CanRelist", equalTo(true), 
				  "Promotions[1].Name", equalTo("Gallery"), 
				  "Promotions[1].Description", equalTo("Good position in category"));
			
		}
}