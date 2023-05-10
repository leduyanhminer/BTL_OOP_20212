import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InfoItemTest {
    @Test
    public void InfoItem() {
        String access_token = Utility.getAccessTokenForTest("thanhpro@gmail.com", "thanhpro");
        ResponseInfoItem res = Unirest.get(Constant.BASE_URL + "items/info/1")
                .header("Authorization", "Bearer" + access_token)
                .header("accept", "applicaton/json")
                .asObject(ResponseInfoItem.class)
                .getBody();
        assertEquals("1000", res.code);
    }

    @Test
    public void InfoItemWithoutAccessToken() {
        String access_token = new String();
        ResponseInfoItem res = Unirest.get(Constant.BASE_URL + "items/info/1")
                .header("Authorization", "Bearer" + access_token)
                .asObject(ResponseInfoItem.class)
                .getBody();
        assertNotNull(res);
    }
}
