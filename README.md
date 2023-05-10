# test-automation


# Mô tả
*Cách chạy chương trình: Build và chạy bình thường, hoặc sử dụng file jar đã dựng sẵn: 
 **java -jar <<path to untitled1.jar>>**
- Đầu tiên, user lựa chọn link base URL cho API(default là https://auctions-app-2.herokuapp.com/api/)
- Sau đó, với base URL tương ứng, user sẽ chọn ra endpoint URL cần thực hiện kiểm thử
- Với mỗi endpoint URL cần kiểm thử, user sẽ có các lựa chọn: Chạy toàn bộ các test case. hoặc là chọn 1 trong các test case của test suite để chạy
- Kết quả trả về sẽ là số lượng test thành công hoặc thất bại.
# Technology
Java: JDK 17, Gradle 7.4, Junit 5.8.1, JUnit Jupiter 5.8.1, Unirest 3.11.9, Unirest Object Mapper Gson 3.13.10

 **IDE**: IntelliJ IDEA 2021.3.3
# Folder structure
## src/main/java 
Contain all java source code, divided to 2 modules
### src/main/java/test-data
Test to be run by main method
### src/main/java/utils
- **Constant.java**
Chứa các biến hằng để sử dụng trong các file khác
- **Response.java**
Chứa các class mô phỏng kiểu dữ liệu trả về của API. 
Dùng GSON Object Mapper chuyển đổi các file JSON thành các object có cấu trức dữ liệu được định nghĩa ở class Response
