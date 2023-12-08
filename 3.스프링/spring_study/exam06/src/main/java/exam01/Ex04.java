package exam01;

import java.sql.*;

public class Ex04 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver"); // 동적 로딩

        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String username = "SPRING6";
        String password = "_aA123456";

        String sql = "INSERT INTO MEMBER(USER_NO, USER_ID, USER_PW, USER_NM, EMAIL) " +
                     "VALUES (SEQ_MEMBER.nextval, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql, new String[]
                     {"USER_NO"})) {

             pstmt.setString(1,"USER02");
             pstmt.setString(2,"123456");
             pstmt.setString(3,"사용자02");
             pstmt.setString(4,"user02@test.org");

             int result = pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if(rs.next()) {
                long userNo = rs.getLong(1);
                System.out.printf("USER_NO : %d%n", userNo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
