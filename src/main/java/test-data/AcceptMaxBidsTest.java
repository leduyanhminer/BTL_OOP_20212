import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AcceptMaxBidsTest {
    @Test
    public void AcceptMaxBidsChuaKetThuc() {
        // Phien dau gia chua ket thuc
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com", "12345");
        ResponseAcceptMaxBid res = Unirest.post(Constant.BASE_URL + "accept/1641")
                .header("Authorization", "Bearer " + access_token)
                .queryString("selling_info", "1233454542543j")
                .asObject(ResponseAcceptMaxBid.class)
                .getBody();
        assertEquals("1009", res.code);
    }
    @Test
    public void AcceptMaxBidsKhongCoQuyen() {
        String access_token = Utility.getAccessTokenForTest("thanhpro@gmail.com", "thanhpro");
        ResponseAcceptMaxBid res = Unirest.post(Constant.BASE_URL + "accept/1641")
                .header("Authorization", "Bearer " + access_token)
                .queryString("selling_info", "1233454542543j")
                .asObject(ResponseAcceptMaxBid.class)
                .getBody();
        assertEquals("1006", res.code);
        // khong co quyen
    }
    @Test
    public void AcceptMaxBidsTestWithoutLogin() {
        // res tra ve Null
        String access_token = "";
        ResponseAcceptMaxBid res = Unirest.post(Constant.BASE_URL + "accept/1641")
                .header("Authorization", "Bearer " + access_token)
                .queryString("selling_info", "1233454542543j")
                .asObject(ResponseAcceptMaxBid.class)
                .getBody();
        assertNull(res);
        // chua dang nhap
    }
}
