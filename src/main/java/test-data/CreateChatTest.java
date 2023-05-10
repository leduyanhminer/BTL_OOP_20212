import kong.unirest.HttpResponse;
import kong.unirest.Proxy;
import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateChatTest {

    @Test
    public void CreateChatWithAccessToken(){

        String access_token = Utility.getAccessTokenForTest();
        ResponseCreateChat res =
                Unirest.post(Constant.BASE_URL + "chat/conversation/2").header(
                        "Authorization", "Bearer " + access_token).asObject(ResponseCreateChat.class).getBody();
        //2: random user ID
        assertEquals("1000", res.code);
        assertEquals("OK", res.message);
    }
    @Test
    public void CreateChatWithoutAccessToken(){
        String access_token = "12313124";
        HttpResponse<ResponseCreateChat> httpRes =
                Unirest.post(Constant.BASE_URL + "chat/conversation/2").header(
                        "Authorization", "Bearer " + access_token).asObject(ResponseCreateChat.class);

        if(Objects.isNull(httpRes.getBody()) && httpRes.getStatus() == 302){
            return;
        }
        ResponseCreateChat res = httpRes.getBody();
        //2: random user ID
        System.out.println(
                Unirest.post(Constant.BASE_URL + "chat/conversation/2").header(
                        "Authorization", "Bearer " + access_token).asObject(ResponseCreateChat.class).getStatus());
        assertEquals("1004", res.code);
        assertEquals("OK", res.message);
    }
}
