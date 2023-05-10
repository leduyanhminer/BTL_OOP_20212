import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GetCategoriesTest {
    @Test
    public void getCategoriesLogin() {
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com", "12345");

        Response res = Unirest.get("https://auctions-app-2.herokuapp.com/api/categories")
                .header("Authorization", "Bearer " + access_token)
                .asObject(Response.class)
                .getBody();
        assertEquals("1000", res.code);
        assertEquals("OK", res.message);
    }
    @Test
    public void getCategoriesWithoutLogin() {
        Response res = Unirest.get("https://auctions-app-2.herokuapp.com/api/categories")
                .asObject(Response.class)
                .getBody();
        assertEquals("1000", res.code);
        assertEquals("OK", res.message);
    }
}
