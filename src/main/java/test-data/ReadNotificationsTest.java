import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ReadNotificationsTest {
    @Test
    public void readNotificationsWithAccessToken() {
        String access_token = Utility.getAccessTokenForTest("thanhpro@gmail.com","thanhpro");

        ResponseReadNotifications res = Unirest.get(Constant.BASE_URL + "notifications/read/108")
                .header("Authorization", "Bearer " + access_token)
                .asObject(ResponseReadNotifications.class)
                .getBody();
        assertEquals("1000", res.code);
        assertEquals("1", res.data.is_read);
    }
    @Test
    public void readNotificationsWithAccessToken1() {
        String access_token = Utility.getAccessTokenForTest("thanhpro@gmail.com","thanhpro");

        ResponseReadNotifications res = Unirest.get(Constant.BASE_URL + "notifications/read/4")
                .header("Authorization", "Bearer " + access_token)
                .asObject(ResponseReadNotifications.class)
                .getBody();
        assertEquals("1006", res.code);
        assertNull(res.data);
    }
    @Test
    public void readNotificationsWithAccessToken2() {
        String access_token = "";

        ResponseReadNotifications res = Unirest.get(Constant.BASE_URL + "notifications/read/108")
                .header("Authorization", "Bearer " + access_token)
                .asObject(ResponseReadNotifications.class)
                .getBody();
        assertEquals("1004", res.code);
        assertNull(res.data);

}   @Test
    public void readNotificationsWithAccessToken4() {
        String access_token = Utility.getAccessTokenForTest("Bachtx@gmail.com","12345");

        ResponseReadNotifications res = Unirest.get(Constant.BASE_URL + "notifications/read/108")
                .header("Authorization", "Bearer " + access_token)
                .asObject(ResponseReadNotifications.class)
                .getBody();
        assertEquals("1004", res.code);
        assertNull(res.data);
    }
}