import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InfoAuctionTest {
    @Test
    public void InfoAuction(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com","12345");
        ResponseInfoAuction res = Unirest.get(Constant.BASE_URL+"auctions/info/1786")
                .header("Authorization","Bearer"+access_token)
                .asObject(ResponseInfoAuction.class)
                .getBody();
        assertEquals("1000",res.code);
        //System.out.println(res.message);
    }
    @Test
    public void InfoAuctionWithoutAccessToken(){
        String access_token = new String();
        ResponseInfoAuction res = Unirest.get(Constant.BASE_URL+"auctions/info/1786")
                .header("Authorization","Bearer"+access_token)
                .asObject(ResponseInfoAuction.class)
                .getBody();
        assertEquals("1004",res.code);
        //System.out.println(res.message);
    }
    @Test
    public void InfoAuctionThatNotYours(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com","12345");
        ResponseInfoAuction res = Unirest.get(Constant.BASE_URL+"auctions/info/1717")
                .header("Authorization","Bearer"+access_token)
                .asObject(ResponseInfoAuction.class)
                .getBody();
        assertEquals("1000",res.code);
        //System.out.println(res.message);
    }
}
