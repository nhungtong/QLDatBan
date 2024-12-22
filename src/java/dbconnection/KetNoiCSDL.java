package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoiCSDL {

    private static final String URL = "jdbc:mysql://localhost:3306/qldatban"; // Đảm bảo tên cơ sở dữ liệu đúng
    private static final String USERNAME = "root"; // Tên tài khoản MySQL
    private static final String PASSWORD = ""; // Mật khẩu MySQL

    // Phương thức lấy kết nối
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Đảm bảo driver MySQL đã được tải
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
