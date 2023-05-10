import java.util.ArrayList;

public class DataNews {
    public ArrayList<News> news;
    public String total;

    public static class News {
        public String user;
        public String new_id;
        public String title;
        public String content;
        public String updated_at;
        public String is_read;
    }
}
