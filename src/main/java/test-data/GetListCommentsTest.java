import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GetListCommentsTest {
    @Test
    public void GetlistcommentsWithAuctionId1641(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com", "12345");

        ReaponseListComments res = Unirest.get(Constant.BASE_URL + "comments/1641")
                .header("Authorization", "Bearer " + access_token)
                .queryString("index",1)
                .queryString("count",1)
                .asObject(ReaponseListComments.class)
                .getBody();
        assertEquals("1000",res.code);
        //System.out.println(res.data.comments.get(0).user_name);
    }
    @Test
    public void GetlistcommentsWithAuction1(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com", "12345");

        ReaponseListComments res = Unirest.get(Constant.BASE_URL + "comments/1")
                .header("Authorization", "Bearer " + access_token)
                .queryString("index",0)
                .queryString("count",0)
                .asObject(ReaponseListComments.class)
                .getBody();
        assertEquals("1000",res.code);
        //System.out.println(res.data.comments.get(0).user_name);
    }
    @Test
    public void GetlistcommentsWithoutLogin(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com", "12345");

        ReaponseListComments res = Unirest.get(Constant.BASE_URL + "comments/1")
                .queryString("index",1)
                .queryString("count",1)
                .asObject(ReaponseListComments.class)
                .getBody();
        assertEquals("1000",res.code);
        //System.out.println(res.data.comments.get(0).user_name);
    }
}
