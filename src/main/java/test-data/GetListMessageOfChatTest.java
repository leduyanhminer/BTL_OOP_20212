import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetListMessageOfChatTest {
    @Test
    public void getWithAccessToken() {
        String access_token = Utility.getAccessTokenForTest();
        ResponseListMessageOfChat res = Unirest.get(Constant.BASE_URL + "chat/listMessages/2")
                .header("Authorization", "Bearer " + access_token)
                .asObject(ResponseListMessageOfChat.class)
                .getBody();
        assertEquals("1000", res.code);
    }

    @Test
    public void getWithoutAccessToken() {
        String access_token = "";
        ResponseListMessageOfChat res = Unirest.get(Constant.BASE_URL + "chat/listMessages/2")
                .header("Authorization", "Bearer " + access_token)
                .asObject(ResponseListMessageOfChat.class)
                .getBody();
        assertEquals("1004", res.code);
    }
    
}
