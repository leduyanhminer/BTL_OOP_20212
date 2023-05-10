import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import java.rmi.server.UnicastRemoteObject;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangePassTest {
    @Test
    public void ChangePassWithCorrectInput() {
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com", "12345");
        Response res = Unirest.post(Constant.BASE_URL + "changepass")
                .header("Authorization", "Bearer" + access_token)
                .queryString("old_pass", "12345")
                .queryString("new_pass", "12345")
                .queryString("re_pass", "12345")
                .asObject(Response.class)
                .getBody();
        assertEquals("1000", res.code);
    }

    @Test
    public void ChangePassWithoutAccessToken() {
        String access_token = new String();
        Response res = Unirest.post(Constant.BASE_URL + "changepass")
                .header("accept", "application/json")
                .header("Authorization", "Bearer" + access_token)
                .queryString("old_pass", "123123")
                .queryString("new_pass", "123123")
                .queryString("re_pass", "123123")
                .asObject(Response.class)
                .getBody();
//        System.out.println(res.code);
//        System.out.println(res.message);
    }

    @Test
    public void ChangePassWithNoInput() {
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com", "12345");
        Response res = Unirest.post(Constant.BASE_URL + "changepass")
                .header("Authorization", "Bearer" + access_token)
                .queryString("old_pass", "")
                .queryString("new_pass", "")
                .queryString("re_pass", "")
                .asObject(Response.class)
                .getBody();
        assertEquals("1001", res.code);
    }


}
