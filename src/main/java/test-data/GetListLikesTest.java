import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GetListLikesTest {
    @Test
    public void GetListLikesWithOutNoLiked() {
        String access_token = Utility.getAccessTokenForTest("thanhpro@gmail.com", "thanhpro");

        ResponseGetListLikes res = Unirest.get(Constant.BASE_URL + "likes/1")
                .header("Authorization", "Bearer " + access_token)
                .queryString("index",1)
                .queryString("count",1)
                .asObject(ResponseGetListLikes.class)
                .getBody();
        assertEquals("1000", res.code);

    }
    @Test
    public void GetListLikesWithoutLogin() {
        String access_token = "";

        ResponseGetListLikes res = Unirest.get(Constant.BASE_URL + "likes/1")
                .header("Authorization", "Bearer " + access_token)
                .queryString("index",1)
                .queryString("count",1)
                .asObject(ResponseGetListLikes.class)
                .getBody();
        assertEquals("1004", res.code);

    }
    @Test
    public void GetListLikes() {
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com", "12345");

        ResponseGetListLikes res = Unirest.get(Constant.BASE_URL + "likes/0")
                .header("Authorization", "Bearer " + access_token)
                .queryString("index",1)
                .queryString("count",7)
                .asObject(ResponseGetListLikes.class)
                .getBody();
        assertEquals("1000", res.code);
        //assertEquals("1",res.data.auctions.get(0).category.type);

    }
}
