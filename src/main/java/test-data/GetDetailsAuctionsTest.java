import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class GetDetailsAuctionsTest {
    @Test
    public void GetDetailsAuctions(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com","12345");
        ResponseGetDetailsAuctions res = Unirest.get(Constant.BASE_URL+"auctions/detail/1641")
                .header("Authorization","Bearer"+access_token)
                .asObject(ResponseGetDetailsAuctions.class)
                .getBody();
        assertEquals("1000",res.code);
        //System.out.println(res.message);
    }
    @Test
    public void GetDetailsAuctionsWithoutAccessToken(){
        String access_token = new String();
        ResponseGetDetailsAuctions res = Unirest.get(Constant.BASE_URL+"auctions/detail/1641")
                .header("Authorization","Bearer"+access_token)
                .asObject(ResponseGetDetailsAuctions.class)
                .getBody();
        assertEquals("1000",res.code);
        //System.out.println(res.message);
    }
}
