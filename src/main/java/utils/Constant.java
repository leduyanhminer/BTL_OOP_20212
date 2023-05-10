import java.util.*;

public class Constant {
    private final static ArrayList<String> baseEndpoints = new ArrayList<>(Arrays.asList("login", "signup", "edit", "logout", "auctions/listAuctionsByStatus/{statusId}", "auctions" + "/listAuctionByUser", "auctions/create", "auctions/edit", "items/create" + "/{auctionId}", "comments/{auctionId}", "bids/{auctionId}", "categories", "brands", "accept" + "/{auctionId}", "likes/{statusId}", "totalLikes" + "/{auctionId" + "}", "news", "news/read" + "/{newId}", "notifications", "notifications/read" + "/{auctionDenyId}", "slider", "search", "chat/message/{chatId}", "comments" + "/create/{auctionId}", "comments/delete" + "/{commentId}", "chat" + "/conversation" + "/{userReceiveId}", "changepass", "chat/listMessages" + "/{chatId}", "info", "updateLike/{auctionId}", "items/info/{itemId}"));
    private final static ArrayList<String> auctionEndpoints = new ArrayList<>(Arrays.asList("listAuctionsByStatus/{statusId}", "listAuctionByUser", "create", "edit"));
    private final static ArrayList<String> commentEndpoints = new ArrayList<>(Arrays.asList("create/{auctionId}", "{auctionId}", "delete/{commentId}"));
    private final static ArrayList<String> itemEndpoints = new ArrayList<>(Arrays.asList("create" + "/{auctionId}", "info/{itemId}"));
    static final String BASE_URL = "https://auctions-app-2.herokuapp.com/api/";
    /**
     * Cac thong tin chung de thuan tien cho viec test
     */
    public static String USER_ID = "490";
    public static final HashMap<String, String> BASE_URL_LIST = new HashMap<>() {{
        put("0", "https://auctions-app-2.herokuapp.com/api/");
        put("1", "https://auctions-app-2.herokuapp.com/api/comments/");
        put("2", "https://auctions-app-2.herokuapp.com/api/auctions/");
        put("3", "https://auctions-app-2.herokuapp.com/api/items/");
    }};

    public static HashMap<String, ArrayList<String>> ENDPOINT_LIST = new HashMap<>() {{
        put("0", baseEndpoints);
        put("1", commentEndpoints);
        put("2", auctionEndpoints);
        put("3", itemEndpoints);
    }};
    public static final HashMap<String, ArrayList<String>> MAPPED_TEST_SUITES_LIST = new HashMap<>() {{
        put("LoginTest", new ArrayList<>(List.of("0.0")));
        put("SignupTest", new ArrayList<>(List.of("0.1")));
        put("EditAccountTest", new ArrayList<>(List.of("0.2")));
        put("LogoutTest", new ArrayList<>(List.of("0.3")));
        put("GetListAuctionsByStatusTest", new ArrayList<>(List.of("0.4", "2.0")));
        put("GetListAuctionsByUserTest", new ArrayList<>(List.of("0.5", "2.1")));
        put("CreateAuctionTest", new ArrayList<>(List.of("0.6", "2.2")));
        put("EditAuctionTest", new ArrayList<>(List.of("0.7", "2.3")));
        put("CreateItemTest", new ArrayList<>(List.of("0.8", "3.1")));
        put("GetListCommentsTest", new ArrayList<>(List.of("0.9", "1.1")));
        put("GetListBidsTest", new ArrayList<>(List.of("0.10")));
        put("GetCategoriesTest", new ArrayList<>(List.of("0.11")));
        put("GetListBrandsTest", new ArrayList<>(List.of("0.12")));
        put("AcceptMaxBidsTest", new ArrayList<>(List.of("0.13")));
        put("GetListLikesTest", new ArrayList<>(List.of("0.14")));
        put("TotalLikeOfAuctionTest", new ArrayList<>(List.of("0.15")));
        put("GetNewsTest", new ArrayList<>(List.of("0.16")));
        put("ReadNewsTest", new ArrayList<>(List.of("0.17")));
        put("GetNotificationsTest", new ArrayList<>(List.of("0.18")));
        put("ReadNotificationsTest", new ArrayList<>(List.of("0.19")));
        put("GetSliderTest", new ArrayList<>(List.of("0.20")));
        put("SearchTest", new ArrayList<>(List.of("0.21")));
        put("CreateMessageOfChatTest", new ArrayList<>(List.of("0.22")));
        put("CreateCommentsTest", new ArrayList<>(List.of("0.23", "1.0")));
        put("DeleteCommentsTest", new ArrayList<>(List.of("0.24", "1.2")));
        put("CreateChatTest", new ArrayList<>(List.of("0.25")));
        put("ChangePassTest", new ArrayList<>(List.of("0.26")));
        put("GetListMessageOfChatTest", new ArrayList<>(List.of("0.27")));
        put("InfoTest", new ArrayList<>(List.of("0.28")));
        put("LikeAuctionTest", new ArrayList<>(List.of("0.29")));
        put("InfoItemTest", new ArrayList<>(List.of("0.30", "3.1")));

    }};

}
