import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadNewsTest {
    @Test
    public void readNewsWithAccessToken() {
        String access_token = Utility.getAccessTokenForTest();
        ResponseReadNews res = Unirest.get(Constant.BASE_URL + "news/read/1")
                .header("Authorization", "Bearer " + access_token)
                .asObject(ResponseReadNews.class)
                .getBody();
        assertEquals("1000", res.code);
        assertEquals("1", res.data.is_read);
    }
}
