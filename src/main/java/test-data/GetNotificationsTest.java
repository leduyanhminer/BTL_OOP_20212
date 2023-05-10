import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GetNotificationsTest {
    @Test
    public void GetNotificationsWithoutAuction() {
        String access_token = Utility.getAccessTokenForTest("thanhpro@gmail.com", "thanhpro");

        ResponseGetNotifications res = Unirest.get(Constant.BASE_URL + "notifications")
                .header("Authorization", "Bearer " + access_token)
                .queryString("index",5)
                .queryString("count",1)
                .queryString("is_not_read",1)
                .asObject(ResponseGetNotifications.class)
                .getBody();
        assertEquals("1000", res.code);
        assertEquals("1",res.data.total);
    }
    @Test
    public void GetNotificationsWithAuction() {
        String access_token = Utility.getAccessTokenForTest("thanhpro@gmail.com", "thanhpro");

        ResponseGetNotifications res = Unirest.get(Constant.BASE_URL + "notifications")
                .header("Authorization", "Bearer " + access_token)
                .queryString("index",1)
                .queryString("count",1)
                .queryString("is_not_read",0)
                .asObject(ResponseGetNotifications.class)
                .getBody();
        assertEquals("1000", res.code);

        assertEquals("2",res.data.denys.get(0).type);
    }
    @Test
    public void GetNotificationsWithAuction2() {
        String access_token = Utility.getAccessTokenForTest("thanhpro@gmail.com", "thanhpro");

        ResponseGetNotifications res = Unirest.get(Constant.BASE_URL + "notifications")
                .header("Authorization", "Bearer " + access_token)
                .queryString("index",1)
                .queryString("count",1)
                .queryString("is_not_read",0)
                .asObject(ResponseGetNotifications.class)
                .getBody();
        assertEquals("1000", res.code);

        assertEquals("108",res.data.denys.get(0).auction_id);
    }
}