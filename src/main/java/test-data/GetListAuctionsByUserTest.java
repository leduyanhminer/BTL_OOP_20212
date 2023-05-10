import kong.unirest.Unirest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GetListAuctionsByUserTest {
    @Test
    void GetListAuctionsByNewUser() {
        String access_token = Utility.getAccessTokenForTest();
        ResponseDataAuction res = Unirest.get(Constant.BASE_URL + "auctions/listAuctionsByUser" + "/{statusId}")
                .routeParam("statusId", "3")
                .queryString("index", "0")
                .queryString("count", "10")
                .header("Authorization", "Bearer " + access_token)
                .asObject(ResponseDataAuction.class)
                .getBody();
        assertEquals("1000", res.code);
        assertEquals("OK", res.message);
    }
}
