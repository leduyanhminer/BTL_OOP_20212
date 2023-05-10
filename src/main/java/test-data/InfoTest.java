import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InfoTest {
    @Test
    public void InfoWithCorrectInputAndAccessToken() {
        String access_token = Utility.getAccessTokenForTest("annm@gmail.com", "123123");
        ResponseInfo res = Unirest.get(Constant.BASE_URL + "info")
                .header("Authorization", "Bearer" + access_token)
                .asObject(ResponseInfo.class)
                .getBody();
        assertEquals("1000", res.code);
        assertEquals("OK", res.message);
    }

    @Test
    public void InfoWithNoAccessToken() {
        String access_token = new String();
        ResponseInfo res = Unirest.get(Constant.BASE_URL + "info")
                .header("Authorization", "Bearer" + access_token)
                .asObject(ResponseInfo.class)
                .getBody();
        assertEquals("1004", res.code);
    }

    @Test
    public void InfoWithWrongAccessToken() {
        String access_token = Utility.getRandomString(100);
        ResponseInfo res = Unirest.get(Constant.BASE_URL + "info")
                .header("Authorization", "Bearer" + access_token)
                .asObject(ResponseInfo.class)
                .getBody();
        assertEquals("1004", res.code);
    }

}
