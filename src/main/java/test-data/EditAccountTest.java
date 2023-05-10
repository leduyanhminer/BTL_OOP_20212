import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import java.util.AbstractMap;

import static org.junit.jupiter.api.Assertions.*;

public class EditAccountTest {
    @Test
    void EditPasswordOnly() {
        AbstractMap.SimpleEntry<String, String> userInfo = Utility.RandomSignup();
        String email = userInfo.getKey();
        String password = userInfo.getValue();
        String newPassword = Utility.getRandomString(10);

        String access_token = Utility.getAccessTokenForTest(email, password);
        ResponseDataAccount res = Unirest.post(Constant.BASE_URL + "edit")
                .header("Authorization", "Bearer " + access_token)
                .header("accept", "application/json")
                .field("email", email)
                .field("password", newPassword)//Different from the old one
                .field("re_pass", newPassword)
                .field("name", "Lol")
                .field("phone", "02312793912")
                .asObject(ResponseDataAccount.class)
                .getBody();

        assertEquals("1000", res.code);
        assertEquals("OK", res.message);

        //Try to login again with old password
        String resWithOldPass = Utility.getAccessTokenForTest(email, password);
        assertEquals("Wrong user info", resWithOldPass);
        //Try to login with new password
        String resWithNewPass = Utility.getAccessTokenForTest(email, newPassword);
        assertNotEquals("Wrong user info", resWithNewPass);
    }

    @Test
    void EditEmailAndPasswordCorrectly() {
        AbstractMap.SimpleEntry<String, String> userInfo = Utility.RandomSignup();
        String email = userInfo.getKey();
        String password = userInfo.getValue();
        String newPassword = Utility.getRandomString(10);
        String access_token = Utility.getAccessTokenForTest(email, password);
        ResponseDataAccount res = Utility.editAccount(access_token, email, newPassword, newPassword, "Lo4l", "349028402384");

        System.out.println(res.message);
        assertEquals("1000", res.code);
        assertEquals("OK", res.message);
        String resWithNewPass = Utility.getAccessTokenForTest(email, newPassword);
        assertNotEquals("Wrong user info", resWithNewPass);

    }

    @Test
    void EditEmailOnly() {
        AbstractMap.SimpleEntry<String, String> userInfo = Utility.RandomSignup();
        String email = userInfo.getKey();
        String password = userInfo.getValue();
        String newEmail = Utility.getRandomEmail(10);
        String access_token = Utility.getAccessTokenForTest(email, password);
        ResponseDataAccount res = Utility.editAccount(access_token, newEmail, password, password, "Lo4l", "349028402384");

        System.out.println(res.message);
        assertEquals("1000", res.code);
        assertEquals("OK", res.message);
        String resWithNewPass = Utility.getAccessTokenForTest(newEmail, password);
        assertNotEquals("Wrong user info", resWithNewPass);
    }
    //Tao 2 tai khoan, edit truong email cua tai khoan thu nhat bang gia tri cua tai khoan thu 2
    // Expected: code = 1001, login vao tai khoan thu nhat va thu 2 voi thong tin cu ok
//    @Test
//    void EditWithExistingEmail() {
//
//
//
//        //Edit new email with an existing email
//        ResponseDataAccount res = randomSignupLoginAndEdit(anotherEmail, "12314802384", "12314802384", "Lol", "48092343204");
//
//
//        assertEquals("1001", res.code);
//        assertNotEquals("Wrong user info", Utility.getAccessTokenForTest(anotherEmail, anotherPassword));
//
//    }


}
