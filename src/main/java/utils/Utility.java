import kong.unirest.Unirest;
import org.apache.commons.lang3.math.NumberUtils;


import java.util.*;

public class Utility {


    //Get default access token

    public static String chooseBaseUrl() {
        Scanner sc = new Scanner(System.in);
        String baseUrl;
        String baseUrlID;
        displayMenu();
        baseUrlID = sc.nextLine()
                .trim();
        if (baseUrlID.isEmpty()) {
            System.out.println("Base URL is: https://auctions-app-2.herokuapp.com/api/");
            return "0";
        }
        while (!Constant.BASE_URL_LIST.containsKey(baseUrlID)) { //Users enter wrong option
            if (baseUrlID.equals("x")) {
                System.out.println("Exiting...");
                System.exit(0);
            }
            System.out.println("Wrong options");
            displayMenu();
            baseUrlID = sc.nextLine()
                    .trim();
            if (baseUrlID.isEmpty()) {
                System.out.println("Base URL is: https://auctions-app-2.herokuapp.com/api/");
                return "0";
            }
        }
        baseUrl = Constant.BASE_URL_LIST.get(baseUrlID);
        System.out.println("Base URL is: " + baseUrl);


        return baseUrlID;
    }

    private static ArrayList<Integer> getImplementedOptions(String baseUrlId) {
        ArrayList<Integer> implementedOptionsList = new ArrayList<>();
        for (ArrayList<String> list : Constant.MAPPED_TEST_SUITES_LIST.values()) {
            for (String element : list) {
                if (element.startsWith(baseUrlId)) {
                    implementedOptionsList.add(Integer.parseInt(element.substring(2)));
                }
            }
        }
        Collections.sort(implementedOptionsList);
        return implementedOptionsList;
    }

    public static ResponseDataAuction getListAuctionsByStatusId(String statusId) {
        ResponseDataAuction res = Unirest.get(Constant.BASE_URL + "auctions/listAuctionsByStatus" + "/{statusId}")
                .routeParam("statusId", statusId)
                .queryString("index", "1")
                .queryString("count", "10")
                .asObject(ResponseDataAuction.class)
                .getBody();
        return res;
    }

    public static String chooseAPIEndPoint(String baseUrlId) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> endPointList = Constant.ENDPOINT_LIST.get(baseUrlId);
        ArrayList<Integer> implementedOptionsList = getImplementedOptions(baseUrlId);
        displayAPIOption(endPointList, implementedOptionsList);
        String endPointId = sc.nextLine()
                .trim();
        if (endPointId.isEmpty()) {
            displayAPIOption(endPointList, implementedOptionsList);
            System.out.println("Please enter an option: ");
        }
        //If user inputs unexpected options, display the menu and ask for user input again
        while (!implementedOptionsList.contains(NumberUtils.toInt(endPointId, -1))) {
            if (endPointId.isEmpty()) {
                displayAPIOption(endPointList, implementedOptionsList);
                System.out.println("Please enter an option: ");
            } else {
                displayAPIOption(endPointList, implementedOptionsList);
                System.out.println("Option not implemented! Please choose another one: ");
            }
            endPointId = sc.nextLine()
                    .trim();

        }
        return baseUrlId + "." + endPointId;
    }

    private static void displayAPIOption(ArrayList<String> endPointList, ArrayList<Integer> implementedOptionsList) {
        System.out.println("Choose an endpoint" + "(0-" + endPointList.size() + ")");
        int index = 0;
        for (String endPoint : endPointList) System.out.println(index++ + ":/" + endPoint);
    }
    // Register a new account with fixed password and random email

    /**
     * @return AbstractMap.SimpleEntry<String, String>
     */
    public static AbstractMap.SimpleEntry<String, String> RandomSignup() {
        String randomEmail = getRandomEmail(20);
        Unirest.post("https://auctions-app-2.herokuapp.com/api/signup")
                .field("email", randomEmail)
                .field("password", "123456")
                .field("re_pass", "123456")
                .field("address", "")
                .field("name", "Tuan Tran")
                .field("phone", "034209874")
                .field("avatar", "")
                .asObject(Response.class)
                .getBody();
        //Return credential for further use
        return new AbstractMap.SimpleEntry<>(randomEmail, "123456");
    }

    public static Response doLogin(String email, String password) {
        return Unirest.post("https://auctions-app-2.herokuapp.com/api/login")
                .field("email", email)
                .field("password", password)
                .asObject(Response.class)
                .getBody();
    }

    /**
     * length should be equal or greater than 9
     */
    public static String getRandomEmail(int length) { //length: So ki tu bao gom ca @gmail.com
        if (length < 9) return "@gmail.com";
        String generatedString = getRandomString(length - 9);

        return generatedString.concat("@gmail.com");
    }

    public static String getRandomString(int length) {
        // create a string of uppercase and lowercase characters and numbers
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        // combine all strings
        String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;
        // create random string builder
        StringBuilder sb = new StringBuilder();
        // create an object of Random class
        Random random = new Random();
        // specify length of random string
        for (int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphaNumeric.length());

            // get character specified by index
            // from the string
            char randomChar = alphaNumeric.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public static String getRandomPhone(int length) {
        // create a string of uppercase and lowercase characters and numbers

        String numbers = "0123456789";
        // combine all strings
        String alphaNumeric = numbers;
        // create random string builder
        StringBuilder sb = new StringBuilder();
        // create an object of Random class
        Random random = new Random();
        // specify length of random string
        for (int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphaNumeric.length());

            // get character specified by index
            // from the string
            char randomChar = alphaNumeric.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }
        return sb.toString();
    }

    private static void displayMenu() {

        System.out.println("==============MENU==============");
//        System.out.println("Choose base URL(0/1/2/3/Enter): ");
//
//        System.out.println("Enter(0): https://auctions-app-2.herokuapp.com/api/");
//        System.out.println("1: https://auctions-app-2.herokuapp.com/api/comments/");
//        System.out.println("2: https://auctions-app-2.herokuapp.com/api/auctions/");
//        System.out.println("3: https://auctions-app-2.herokuapp.com/api/items/");

        System.out.println("Choose a base URL: ");
        for (Map.Entry<String, String> set : Constant.BASE_URL_LIST.entrySet()) {
            if (set.getKey()
                    .equals("0")) {
                System.out.println("Enter(0):" + set.getValue());
            } else {
                System.out.println(set.getKey() + ": " + set.getValue());
            }
        }
        System.out.println("x: Exit");
    }

    public static String getAccessTokenForTest() {
        return getAccessTokenForTest("oop123456@gmail.com", "123456");
    }

    public static String getAccessTokenForTest(String email, String password) {
        //Login successfully first
        ResponseWithAccessToken res = Unirest.post("https://auctions-app-2.herokuapp.com/api/login")
                .field("email", email)
                .field("password", password)
                .asObject(ResponseWithAccessToken.class)//ObjectMapper
                .getBody();
        //If successfully login, return access token for use
        if (res.code.equals("1000")) {
            return res.data.access_token;
        }
        return "Wrong user info";
    }

    public static String createAuction() {
        String access_token = Utility.getAccessTokenForTest("bachtx@gmail.com", "12345");
        ResponseCreateAuction res = Unirest.post(Constant.BASE_URL + "auctions/create")
                .header("Authorization", "Bearer" + access_token)
                .field("category_id", "1")
                .queryString("start_date", "2023-07-19T15:50:00")
                .queryString("end_date", "2023-08-19T15:50:00")
                .queryString("title_ni", Utility.getRandomString(6))
                .asObject(ResponseCreateAuction.class)
                .getBody();
        return res.data.auction_id;
    }

    public static String createComment(String access_token) {
        ResponeCreateComments res = Unirest.post(Constant.BASE_URL + "comments/create/1641")
                .header("Authorization", "Bearer " + access_token)
                .field("content", Utility.getRandomString(10))
                .queryString("comment_last_id", 1)
                .asObject(ResponeCreateComments.class)
                .getBody();
        ReaponseListComments res_2 = Unirest.get(Constant.BASE_URL + "comments/1641")
                .header("Authorization", "Bearer " + access_token)
                .queryString("index", 1)
                .queryString("count", 1)
                .asObject(ReaponseListComments.class)
                .getBody();
        return res_2.data.comments.get(0).comment_id;
    }

    public static ResponseDataAccount editAccount(String access_token, String newEmail, String newPassword, String newRe_pass, String newName, String newPhone) {


        return Unirest.post(Constant.BASE_URL + "edit")
                .header("Authorization", "Bearer " + access_token)
                .header("accept", "application/json")
                .field("email", newEmail)
                .field("password", newPassword)//Different from the old one
                .field("re_pass", newRe_pass)
                .field("name", newName)
                .field("phone", newPhone)
                .asObject(ResponseDataAccount.class)
                .getBody();
    }
}
