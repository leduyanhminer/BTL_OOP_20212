import kong.unirest.Unirest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Signup API
 * Parameter list:
 * email string
 * password string
 * re_pass string: Should be the same as password
 * address string(optional)
 * name string
 * phone string
 * avatar file(optional)
 */
public class SignupTest {
    //cover properly signup
    @Test
    void SignUpSuccessfully() {
        String randomEmail = Utility.getRandomEmail(20);
        Response res = Unirest.post("https://auctions-app-2.herokuapp.com/api/signup")
                .field("email", randomEmail)
                .field("password", "123456")
                .field("re_pass", "123456")
                .field("address", "")
                .field("name", "Tuan Tran")
                .field("phone", "034209874")
                .asObject(Response.class)
                .getBody();
        System.out.println(res.message);

        assertEquals("1000", res.code);
        assertEquals("OK", res.message);
    }

    @Test
    void SignUpWithWrongEmailAndPhone() {
        Response res = Unirest.post("https://auctions-app-2.herokuapp.com/api/signup")
                .field("email", "annm@@gmail.com")
                .field("password", "123456")
                .field("re_pass", "123456")
                .field("address", "")
                .field("name", "Tuan Tran")
                .field("phone", "A9388883")
                .field("avatar", "")
                .asObject(Response.class)
                .getBody();
        assertEquals("1001", res.code);
    }

    @Test
    void SignUpWithOversize() {
        Response res = Unirest.post(Constant.BASE_URL + "signup")
                .field("email", Utility.getRandomString(260) + "@gmail.com")
                .field("password", Utility.getRandomString(260))
                .field("re_pass", Utility.getRandomString(260))
                .field("address", Utility.getRandomString(260))
                .field("name", Utility.getRandomString(260))
                .field("phone", Utility.getRandomPhone(90))
                .field("avatar", Utility.getRandomString(260))
                .asObject(Response.class)
                .getBody();
        assertEquals("1001", res.code);
    }

    @Test
    void SignUpAccountWasCreated() {
        Response res = Unirest.post("https://auctions-app-2.herokuapp.com/api/signup")
                .field("email", "bachtx@gmail.com")
                .field("password", "123456")
                .field("re_pass", "123456")
                .field("address", "")
                .field("name", "Bach Tran")
                .field("phone", "034209874")
                .field("avatar", "")
                .asObject(Response.class)
                .getBody();
        assertEquals("1001", res.code);
    }

    @Test
    void SignUpWithNoInput() {
        Response res = Unirest.post("https://auctions-app-2.herokuapp.com/api/signup")
                .field("email", "")
                .field("password", "")
                .field("re_pass", "")
                .field("address", "")
                .field("name", "")
                .field("phone", "")
                .field("avatar", "")
                .asObject(Response.class)
                .getBody();
        assertEquals("1001", res.code);
    }
}
