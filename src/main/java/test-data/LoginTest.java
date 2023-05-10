import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Test for Login
 */
class LoginTest {
    //covers: email, password: an already created account info.
    @Test
    public void LoginWithExistingAccount() {
        Response res = Utility.doLogin("oop123456@gmail.com", "123456");
        Assertions.assertEquals("1000", res.code);
        Assertions.assertEquals("OK", res.message);
    }

    //covers: email, password: empty string
    @Test
    public void LoginWithNoInput() {
        Response res = Utility.doLogin("", "");
        Assertions.assertEquals("1001", res.code);
    }


    //covers: email: random email with correct format
    //        password: random password
    @Test
    public void LoginWithWrongInfo() {
        Response res = Utility.doLogin("bchdhsjss@gmail.com", "bruhbruhlmao");
        Assertions.assertEquals("1002", res.code);
    }

    //covers: email: random string(wrong email format)
    //        password: random string
    //
    @Test
    public void LoginWithWrongEmailFormat() {
        Response res = Utility.doLogin("faasddddffff", "bruhbruhlmao");
        Assertions.assertEquals("1001", res.code);
    }
}