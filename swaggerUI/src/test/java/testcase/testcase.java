package testcase;
import static io.restassured.RestAssured.*;
import org.junit.Test;
import io.restassured.response.Response;
public class testcase {
	    String access_token="";
		String username="upskills_admin";
		String password="Talent4$$";
		
		public void main(String args[]) {
		    String payload = "{\n" +
		            "    \"username\":\"upskills_admin\",\n" +
		            "    \"password\":\"Talent4$$\"\n" +
		            "}";
		}
		
		@Test
		public void getAccessToken() {
			
		Response response=given().when().header("Authorization","Basic dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9jbGllbnQ6dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9zZWNyZXQ=")
		//.auth().preemptive()
		//.basic(username, password)
		//.param("grant_type", "client_credentials")
		.log().all()
		.post("http://rest-api.upskills.in/api/rest_admin/oauth2/token/client_credentials");
		
		response.prettyPrint();
		System.out.println("Status Code is " +response.statusCode());
		//access_token=response.getBody().path("access_token");
		//System.out.println("Access Token is "+access_token);
		}
		
		@Test
		public void getLogin() {
			String payload = "{\n" +
		            "    \"username\":\"upskills_admin\",\n" +
		            "    \"password\":\"Talent4$$\"\n" +
		            "}";
			
			Response reslogin = given().headers("Content-Type", "application/json").body(payload).when().post("http://rest-api.upskills.in/doc/admin/#/2.%20Admin%20User/loginUser");
			System.out.println(reslogin.getStatusCode());
		}
		
		@Test
		public void getAdminLogout() {
			 String payload = "{\n" +
			            "    \"username\":\"upskills_admin\",\n" +
			            "    \"password\":\"Talent4$$\"\n" +
			            "}";
			Response response=given().headers("Content-Type", "application/json").body(payload).when()
			.post("http://rest-api.upskills.in/doc/admin/#/2.%20Admin%20User/logoutUser");
			
			response.prettyPrint();
			System.out.println("Status Code is " +response.statusCode());
		}
		
		@Test
		public void getTC_015() {
			
		}
}
