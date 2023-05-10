import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EditAuctionTest {
    @Test
    public void EditAuction(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com","12345");
        ResponseEditAuction res = Unirest.post(Constant.BASE_URL+"auctions/edit/1786")
                .header("Authorization","Bearer"+access_token)
                .queryString("category_id","1")
                .queryString("start_date","2023-07-19T15:50:00")
                .queryString("end_date","2023-09-19T15:50:00")
                .queryString("title_ni",Utility.getRandomString(6))
                .asObject(ResponseEditAuction.class)
                .getBody();
        assertEquals("1000",res.code);
    }
    @Test
    public void EditAuctionWithoutAccessToken(){
        String access_token = new String();
        ResponseEditAuction res = Unirest.post(Constant.BASE_URL+"auctions/edit/1786")
                .header("Authorization","Bearer"+access_token)
                .queryString("category_id","1")
                .queryString("start_date","2023-07-19T15:50:00")
                .queryString("end_date","2023-09-19T15:50:00")
                .queryString("title_ni",Utility.getRandomString(6))
                .asObject(ResponseEditAuction.class)
                .getBody();
        assertNull(res);
    }
    @Test
    public void EditAuctionWithApprovedAuction(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com","12345");
        ResponseEditAuction res = Unirest.post(Constant.BASE_URL+"auctions/edit/1717")
                .header("Authorization","Bearer"+access_token)
                .queryString("category_id","1")
                .queryString("start_date","2023-07-19T15:50:00")
                .queryString("end_date","2023-09-19T15:50:00")
                .queryString("title_ni",Utility.getRandomString(6))
                .asObject(ResponseEditAuction.class)
                .getBody();
        assertEquals("1005",res.code);
        //System.out.println(res.message);
    }
    @Test
    public void EditAuctionThatNotYours(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com","12345");
        ResponseEditAuction res = Unirest.post(Constant.BASE_URL+"auctions/edit/1719")
                .header("Authorization","Bearer"+access_token)
                .queryString("category_id","1")
                .queryString("start_date","2023-07-19T15:50:00")
                .queryString("end_date","2023-09-19T15:50:00")
                .queryString("title_ni",Utility.getRandomString(6))
                .asObject(ResponseEditAuction.class)
                .getBody();
        assertEquals("1006",res.code);
        //System.out.println(res.message);
    }
    @Test
    public void EditAuctionWithWrongStartDate(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com","12345");
        ResponseEditAuction res = Unirest.post(Constant.BASE_URL+"auctions/edit/1786")
                .header("Authorization","Bearer"+access_token)
                .queryString("category_id","1")
                .queryString("start_date","2022-07-19T15:50:00")
                .queryString("end_date","2023-09-19T15:50:00")
                .queryString("title_ni",Utility.getRandomString(6))
                .asObject(ResponseEditAuction.class)
                .getBody();
        assertEquals("1001",res.code);
    }
    @Test
    public void EditAuctionWithWrongDateFormat(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com","12345");
        ResponseEditAuction res = Unirest.post(Constant.BASE_URL+"auctions/edit/1786")
                .header("Authorization","Bearer"+access_token)
                .queryString("category_id","1")
                .queryString("start_date","abc")
                .queryString("end_date","def")
                .queryString("title_ni",Utility.getRandomString(6))
                .asObject(ResponseEditAuction.class)
                .getBody();
        assertEquals("1001",res.code);
    }
    @Test
    public void EditAuctionWithWrongEndDate(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com","12345");
        ResponseEditAuction res = Unirest.post(Constant.BASE_URL+"auctions/edit/1786")
                .header("Authorization","Bearer"+access_token)
                .queryString("category_id","1")
                .queryString("start_date","2023-07-19T15:50:00")
                .queryString("end_date","2023-06-19T15:50:00")
                .queryString("title_ni",Utility.getRandomString(6))
                .asObject(ResponseEditAuction.class)
                .getBody();
        assertEquals("1001",res.code);
    }
    @Test
    public void EditAuctionWithTooLongTitleNi(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com","12345");
        ResponseEditAuction res = Unirest.post(Constant.BASE_URL+"auctions/edit/1786")
                .header("Authorization","Bearer"+access_token)
                .queryString("category_id","1")
                .queryString("start_date","2023-07-19T15:50:00")
                .queryString("end_date","2023-09-19T15:50:00")
                .queryString("title_ni",Utility.getRandomString(300))
                .asObject(ResponseEditAuction.class)
                .getBody();
        assertEquals("1001",res.code);
    }
    @Test
    public void EditAuctionWithoutInformation(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com","12345");
        ResponseEditAuction res = Unirest.post(Constant.BASE_URL+"auctions/edit/1786")
                .header("Authorization","Bearer"+access_token)
                .queryString("category_id","")
                .queryString("start_date","")
                .queryString("end_date","")
                .queryString("title_ni","")
                .asObject(ResponseEditAuction.class)
                .getBody();
        assertEquals("1001",res.code);
    }
}
