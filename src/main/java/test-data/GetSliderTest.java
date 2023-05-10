import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GetSliderTest {
    @Test
    public void GetSider() {
        String access_token = Utility.getAccessTokenForTest("thanhpro@gmail.com", "thanhpro");

        ResponseGetSlider res = Unirest.get(Constant.BASE_URL + "slider")
                .header("Authorization", "Bearer " + access_token)
                .asObject(ResponseGetSlider.class)
                .getBody();
        assertEquals("1000", res.code);

    }
}