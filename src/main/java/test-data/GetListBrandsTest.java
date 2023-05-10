import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetListBrandsTest {
    @Test
    public void ListBidsTest(){
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com", "12345");

        ResponeListBrands res = Unirest.get(Constant.BASE_URL + "brands")
                .header("Authorization", "Bearer " + access_token)
                .asObject(ResponeListBrands.class)
                .getBody();
        assertEquals("1000", res.code);
        //System.out.println(res.data.brand.get(0).name);
    }
    @Test
    public void ListBidsTestWithoutLogin(){
        String access_token = "";

        ResponeListBrands res = Unirest.get(Constant.BASE_URL + "brands")
                .header("Authorization", "Bearer " + access_token)
                .asObject(ResponeListBrands.class)
                .getBody();
        assertEquals("1000", res.code);
    }
}
