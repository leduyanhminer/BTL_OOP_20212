import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LikeAuctionTest {
    @Test
    public void LikeAuctionId1641(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com", "12345");

        ResponseLikeAuction res = Unirest.post(Constant.BASE_URL + "updateLike/1641")
                .header("Authorization", "Bearer " + access_token)
                .asObject(ResponseLikeAuction.class)
                .getBody();
        assertEquals("1000", res.code);
        assertEquals("1291", res.data.user_id);
    }
    @Test
    public void LikeAuctionId1(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com", "12345");

        ResponseLikeAuction res = Unirest.post(Constant.BASE_URL + "updateLike/1")
                .header("Authorization", "Bearer " + access_token)
                .asObject(ResponseLikeAuction.class)
                .getBody();
        assertEquals("1000", res.code);
        assertEquals("1", res.data.auction_id);
    }
    @Test
    public void LikeAuctionWithoutLogin(){

        ResponseLikeAuction res = Unirest.post(Constant.BASE_URL + "updateLike/1641")
                .asObject(ResponseLikeAuction.class)
                .getBody();
        assertNull(res);
    }
}
