import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
public class CreateAuctionTest {
    @Test
    public void CreateAuction(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com","12345");
        ResponseCreateAuction res = Unirest.post(Constant.BASE_URL+"auctions/create")
                .header("Authorization", "Bearer" + access_token)
                .field("category_id","1")
                .queryString("start_date","2023-07-19T15:50:00")
                .queryString("end_date","2023-08-19T15:50:00")
                .queryString("title_ni",Utility.getRandomString(6))
                .asObject(ResponseCreateAuction.class)
                .getBody();
        assertEquals("1000",res.code);
        //System.out.println(res.message);
    }
    @Test
    public void CreateAuctionWithoutAccessToken(){
        String access_token = new String();
        ResponseCreateAuction res = Unirest.post(Constant.BASE_URL+"auctions/create")
                .header("Authorization", "Bearer" + access_token)
                .field("category_id","1")
                .queryString("start_date","2023-07-19T15:50:00")
                .queryString("end_date","2023-08-19T15:50:00")
                .queryString("title_ni",Utility.getRandomString(6))
                .asObject(ResponseCreateAuction.class)
                .getBody();
        assertNull(res);
    }
    @Test
    public void CreateAuctionWithWrongStartDate(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com","12345");
        ResponseCreateAuction res = Unirest.post(Constant.BASE_URL+"auctions/create")
                .header("Authorization","Bearer"+access_token)
                .queryString("category_id","1")
                .queryString("start_date","2022-07-19T15:50:00")
                .queryString("end_date","2023-08-19T15:50:00")
                .queryString("title_ni",Utility.getRandomString(6))
                .asObject(ResponseCreateAuction.class)
                .getBody();
        assertEquals("1001",res.code);
        //System.out.println(res.message);
    }
    @Test
    public void CreateAuctionWithWrongEndDate(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com","12345");
        ResponseCreateAuction res = Unirest.post(Constant.BASE_URL+"auctions/create")
                .header("Authorization","Bearer"+access_token)
                .queryString("category_id","1")
                .queryString("start_date","2023-07-19T15:50:00")
                .queryString("end_date","2023-06-19T15:50:00")
                .queryString("title_ni",Utility.getRandomString(6))
                .asObject(ResponseCreateAuction.class)
                .getBody();
        assertEquals("1001",res.code);
        //System.out.println(res.message);
    }
    @Test
    public void CreateAuctionWithTooBigCategoryId(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com","12345");
        ResponseCreateAuction res = Unirest.post(Constant.BASE_URL+"auctions/create")
                .header("Authorization","Bearer"+access_token)
                .queryString("category_id","300")
                .queryString("start_date","2023-07-19T15:50:00")
                .queryString("end_date","2023-08-19T15:50:00")
                .queryString("title_ni",Utility.getRandomString(6))
                .asObject(ResponseCreateAuction.class)
                .getBody();
        assertEquals("1001",res.code);
        //System.out.println(res.message);
    }
    @Test
    public void CreateAuctionWithWrongDateFormat(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com","12345");
        ResponseCreateAuction res = Unirest.post(Constant.BASE_URL+"auctions/create")
                .header("Authorization","Bearer"+access_token)
                .queryString("category_id","1")
                .queryString("start_date",Utility.getRandomString(6))
                .queryString("end_date",Utility.getRandomString(6))
                .queryString("title_ni",Utility.getRandomString(6))
                .asObject(ResponseCreateAuction.class)
                .getBody();
        assertEquals("1001",res.code);
        //System.out.println(res.message);
    }
    @Test
    public void CreateAuctionWithTooLongTitleNi(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com","12345");
        ResponseCreateAuction res = Unirest.post(Constant.BASE_URL+"auctions/create")
                .header("Authorization", "Bearer" + access_token)
                .field("category_id","1")
                .queryString("start_date","2023-07-19T15:50:00")
                .queryString("end_date","2023-08-19T15:50:00")
                .queryString("title_ni",Utility.getRandomString(300))
                .asObject(ResponseCreateAuction.class)
                .getBody();
        assertEquals("1001",res.code);
        //System.out.println(res.message);
    }
    @Test
    public void CreateAuctionWithoutInformation(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com","12345");
        ResponseCreateAuction res = Unirest.post(Constant.BASE_URL+"auctions/create")
                .header("Authorization", "Bearer" + access_token)
                .field("category_id","")
                .queryString("start_date","")
                .queryString("end_date","")
                .queryString("title_ni","")
                .asObject(ResponseCreateAuction.class)
                .getBody();
        assertEquals("1001",res.code);
        //System.out.println(res.message);
    }
}
