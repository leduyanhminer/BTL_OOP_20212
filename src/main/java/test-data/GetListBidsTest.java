import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GetListBidsTest {
    // Khong can dang nhap
    @Test
    public void ListBidsTestLogin(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com", "12345");

        ResponseListBids res = Unirest.get(Constant.BASE_URL + "bids/1641")
                .header("Authorization", "Bearer " + access_token)
                .queryString("index",1)
                .queryString("count",1)
                .asObject(ResponseListBids.class)
                .getBody();
        assertEquals("1000", res.code);
    }
    @Test
    public void ListBidsTest(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com", "12345");

        ResponseListBids res = Unirest.get(Constant.BASE_URL + "bids/1")
                .header("Authorization", "Bearer " + access_token)
                .queryString("index",1)
                .queryString("count",1)
                .asObject(ResponseListBids.class)
                .getBody();
        assertEquals("1000", res.code);
        //System.out.println(res.data.bids.get(0).user_name);
    }
    @Test
    public void ListBidsTestWithoutLogin(){
        String access_token = "";

        ResponseListBids res = Unirest.get(Constant.BASE_URL + "bids/1641")
                .header("Authorization", "Bearer " + access_token)
                .queryString("index",1)
                .queryString("count",1)
                .asObject(ResponseListBids.class)
                .getBody();
        assertEquals("1000", res.code);
    }
}

