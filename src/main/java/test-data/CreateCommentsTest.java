import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CreateCommentsTest {
    @Test
    public void CreateCommentsLogin1(){

        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com", "12345");
        ResponeCreateComments res = Unirest.post(Constant.BASE_URL + "comments/create/1641")
                .header("Authorization", "Bearer " + access_token)
                .field("content",Utility.getRandomString(10))
                .queryString("comment_last_id",1)
                .asObject(ResponeCreateComments.class)
                .getBody();
        assertEquals("1000", res.code);
    }
    @Test
    public void CreateCommentsLogin2(){
        String access_token = Utility.getAccessTokenForTest("thanhpro@gmail.com", "thanhpro");
        ResponeCreateComments res = Unirest.post(Constant.BASE_URL + "comments/create/1641")
                .header("Authorization", "Bearer " + access_token)
                .field("content",Utility.getRandomString(10))
                .queryString("comment_last_id",1)
                .asObject(ResponeCreateComments.class)
                .getBody();
        assertEquals("1000", res.code);
    }
    @Test
    public void CreateCommentsWithoutLogin(){
        // res tra ve null
        String access_token = "1234";
        ResponeCreateComments res = Unirest.post(Constant.BASE_URL + "comments/create/1641")
                .header("Authorization", "Bearer " + access_token)
                .field("content",Utility.getRandomString(10))
                .queryString("comment_last_id",1)
                .asObject(ResponeCreateComments.class)
                .getBody();
        assertNull(res);
    }
    @Test
    public void CreateCommentsPhiendaugiaChuaduocduyet(){
        // phien dau gia chua duoc duyet
        String access_token = Utility.getAccessTokenForTest("thanhpro@gmail.com", "thanhpro");
        ResponeCreateComments res = Unirest.post(Constant.BASE_URL + "comments/create/1910")
                .header("Authorization", "Bearer " + access_token)
                .field("content",Utility.getRandomString(10))
                .queryString("comment_last_id",1)
                .asObject(ResponeCreateComments.class)
                .getBody();
        assertEquals("1008", res.code);
    }
}
