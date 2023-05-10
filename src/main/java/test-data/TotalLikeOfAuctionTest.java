import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TotalLikeOfAuctionTest {
    @Test
    public void TotalLikeOfAuction() {
        String access_token = Utility.getAccessTokenForTest("thanhpro@gmail.com", "thanhpro");

        ResponseTotalLikeOfAuction res = Unirest.get(Constant.BASE_URL + "totalLikes/1641")
                .header("Authorization", "Bearer " + access_token)
                .asObject(ResponseTotalLikeOfAuction.class)
                .getBody();
        assertEquals("1000", res.code);

    }

    @Test
    public void TotalLikeOfAuctionWithNullID() {
        String access_token = Utility.getAccessTokenForTest("thanhpro@gmail.com", "thanhpro");

        ResponseTotalLikeOfAuction res = Unirest.get(Constant.BASE_URL + "totalLikes/99999")
                .header("Authorization", "Bearer " + access_token)
                .asObject(ResponseTotalLikeOfAuction.class)
                .getBody();
        assertEquals("9993", res.code);


    }

    @Test
    public void TotalLikeOfAuction2() {
        String access_token = Utility.getAccessTokenForTest("thanhpro@gmail.com", "thanhpro");

        ResponseTotalLikeOfAuction res = Unirest.get(Constant.BASE_URL + "totalLikes/1")
                .header("Authorization", "Bearer " + access_token)
                .asObject(ResponseTotalLikeOfAuction.class)
                .getBody();
        assertEquals("1000", res.code);
        assertEquals("1", res.data.auction_id);

    }

    @Test
    public void TotalLikeOfAuction3() {
        String access_token = Utility.getAccessTokenForTest("thanhpro@gmail.com", "thanhpro");

        ResponseTotalLikeOfAuction res = Unirest.get(Constant.BASE_URL + "totalLikes/1641")
                .header("Authorization", "Bearer " + access_token)
                .asObject(ResponseTotalLikeOfAuction.class)
                .getBody();
        assertEquals("1000", res.code);

    }
}