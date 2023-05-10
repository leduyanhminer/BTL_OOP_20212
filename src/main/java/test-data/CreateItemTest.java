import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CreateItemTest {
    @Test
    public void TaoDuocItem() {
        String auctionId = Utility.createAuction();
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com", "12345");
        ResponseCreateItem res = Unirest.post(Constant.BASE_URL + "items/create/" + auctionId)
                .header("Authorization", "Bearer " + access_token)
                .queryString("name", "1234ljdsf")
                .queryString("starting_price", "1000000")
                .queryString("brand_id", "1")
                .queryString("description", Utility.getRandomString(15))
                .asObject(ResponseCreateItem.class)
                .getBody();
        assertEquals("1000", res.code);
    }

    @Test
    public void KhongTheThemItem() {
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com", "12345");
        ResponseCreateItem res = Unirest.post(Constant.BASE_URL + "items/create/2070")
                .header("Authorization", "Bearer" + access_token)
                .queryString("name", "abc")
                .queryString("starting_price", "1000000")
                .queryString("brand_id", "1")
                .queryString("description", Utility.getRandomString(15))
                .queryString("series", "pet3")
                .asObject(ResponseCreateItem.class)
                .getBody();
        assertEquals("9995", res.code);
    }

    @Test
    public void CreateItemWithTooLongName() {
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com", "12345");
        ResponseCreateItem res = Unirest.post(Constant.BASE_URL + "items/create/2268")
                .header("Authorization", "Bearer" + access_token)
                .queryString("name", Utility.getRandomString(300))
                .queryString("starting_price", "100")
                .queryString("brand_id", "1")
                .queryString("description", Utility.getRandomString(15))
                .queryString("series", "pet4")
                .asObject(ResponseCreateItem.class)
                .getBody();
        assertEquals("1001", res.code);
    }

    @Test
    public void CreateItemThatTheSeriesExisted() {
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com", "12345");
        ResponseCreateItem res = Unirest.post(Constant.BASE_URL + "items/create/2268")
                .header("Authorization", "Bearer" + access_token)
                .queryString("name", "abc")
                .queryString("starting_price", "1000000")
                .queryString("brand_id", "1")
                .queryString("description", Utility.getRandomString(15))
                .queryString("series", "pet1")
                .asObject(ResponseCreateItem.class)
                .getBody();
        assertEquals("1001", res.code);
    }

    @Test
    public void CreateItemWithInvalidBrandId() {
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com", "12345");
        ResponseCreateItem res = Unirest.post(Constant.BASE_URL + "items/create/2268")
                .header("Authorization", "Bearer" + access_token)
                .queryString("name", "abc")
                .queryString("starting_price", "1000000")
                .queryString("brand_id", "100")
                .queryString("description", Utility.getRandomString(15))
                .queryString("series", "pet6")
                .asObject(ResponseCreateItem.class)
                .getBody();
        assertEquals("1001", res.code);
    }
}