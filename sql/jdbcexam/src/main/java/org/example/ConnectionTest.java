package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionTest {
    public static void main(String[] args) {
        //DB연결을 위한 인터페이스 - mysql-connector-j라는 jdbc 드라이버가 구현하고 있다.
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // DBMS접속, jdbc url은 DMBS에서 정한 방식으로 입력
            // DBMS와 연결후 Connection을 구현하고 있는 객체를 반환
            // DriverManager는 jdbc url에서 mysql jdbc타입인것을 인지하고 ConnectionImpl객체를 만들어 리턴한다.(실패하면 Exception)

            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/examplesdb?useUnicode=true&serverTimezone=Asia/Seoul",
                    "chobo5",
                    "12241509");

            if (conn != null) {
                System.out.println("DBMS 연결성공");
                System.out.println(conn.getClass().getName()); //getClass().getName()은 자바 reflection관련 메서드
            }

            //SQL을 작성하고 실행하는 코드
            //insert into role(role_id, name) values (값, '값'); 다음과 같은 sql을 실행하려면...
            //;은 생략하고 정해져 있지 않은 부분은 ?로한다.
            //conn에게 지금 연결된 DBMS에 해당 SQL을 준비하며, ?부분은 남겨놓으라고 요청한다.
            //그리고 준비한것을 참조하도록 prepareStatement를 return 해준다.
            ps = conn.prepareStatement("insert into role(role_id, name) values (?, ?)");

            //물음표에 값을 채워주는것 -> binding
            ps.setInt(1, 3); //첫번쨰 물음표에 정수값 설정
            ps.setString(2, "ROLE_TEST"); //두번째 물음표에 문자열 값을 설정
            //바인딩하면 SQL실행 준비가 됨

            //SQL 실행 - executeUpdate(): insert, update, delete할 때 사용
            int updateCount = ps.executeUpdate(); //실행된 건수 리턴
            System.out.println("수정된 건수: " + updateCount);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            try {
                //종료시 PrepareStatement 자원을을 반드시 해제해야 한다.
                if(ps != null) ps.close();
                //종료시 Connection 연결을 반드시 끊어줘야 한다.
                if(conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
