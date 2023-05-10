import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GetNewsTest {
    @Test
    public void getNewsWithAccessToken() {
        String access_token = Utility.getAccessTokenForTest();
        System.out.println(access_token);
        ResponseNews res = Unirest.get(Constant.BASE_URL + "news")
                .queryString("index", "0")
                .queryString("count", "1")
                .header("Authorization", "Bearer " + access_token)
                .asObject(ResponseNews.class)
                .getBody();

        assertEquals("1000", res.code);
        assertEquals("OK", res.message);
    }

    @Test
    public void getNewsWithoutAccessToken() {
        ResponseNews res = Unirest.get(Constant.BASE_URL + "news")
                .queryString("index", "1")
                .queryString("count", "1")
                .asObject(ResponseNews.class)
                .getBody();
        assertEquals("1000", res.code);
        
    }
}
