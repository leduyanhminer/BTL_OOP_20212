import kong.unirest.Unirest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SearchTest {
    @Test
    void SearchWithoutAccessToken() {
        ResponseSearchResult res = Unirest.get(Constant.BASE_URL.concat("search"))
                .queryString("type", "4")
                .queryString("key", "a")
                .asObject(ResponseSearchResult.class)
                .getBody();

        assertEquals("1000", res.code);
        assertEquals("OK", res.message);
        assertNotEquals(null, res.data);
    }

    @Test
    void SearchWithAccessToken() {
        String access_token = Utility.getAccessTokenForTest();
        ResponseSearchResult res = Unirest.get(Constant.BASE_URL.concat("search"))
                .queryString("type", "4")
                .queryString("key", "a")
                .header("Authentication", "Bearer " + access_token)
                .asObject(ResponseSearchResult.class)
                .getBody();
        assertEquals("1000", res.code);
        assertEquals("OK", res.message);
        assertNotNull(res.data);
    }

    @Test
    void SearchWithNoKeywordAndNoAccessToken() {
        ResponseSearchResult res = Unirest.get(Constant.BASE_URL.concat("search"))
                .queryString("type", "4")
                .queryString("key", "")
                .asObject(ResponseSearchResult.class)
                .getBody();
        assertEquals("9998", res.code);
        assertNull(res.data);
    }

}

