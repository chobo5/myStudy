package org.example;

import java.sql.*;

public class TransactionTest03 {
    public static void main(String[] args) {
        //DB연결을 위한 인터페이스 - mysql-connector-j라는 jdbc 드라이버가 구현하고 있다.
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            // DBMS접속, jdbc url은 DMBS에서 정한 방식으로 입력
            // DBMS와 연결후 Connection을 구현하고 있는 객체를 반환
            // DriverManager는 jdbc url에서 mysql jdbc타입인것을 인지하고 ConnectionImpl객체를 만들어 리턴한다.(실패하면 Exception)

            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/examplesdb?useUnicode=true&serverTimezone=Asia/Seoul",
                    "chobo5",
                    "12241509");

            //autocommit을 false로 설정
            conn.setAutoCommit(false);

            ps = conn.prepareStatement("update board set view_cnt = view_cnt + 1 where board_id = ?");
            ps.setInt(1, 1);
            int updateCount = ps.executeUpdate();
            if (updateCount == 0) {
                throw new RuntimeException("board_id에 해당하는 게시물이 없습니다.");
            }

            //하나의 트랜젝션 안에서 같은 prepareStatement를 쓸떄는 clearParameters를 해주는게 좋다.
            ps.clearParameters();

            ps = conn.prepareStatement("select board_id, title, content, user_id, regdate, view_cnt from board where board_id = ?");
            ps.setInt(1, 1); //첫번쨰 물음표에 정수값 설정

            rs = ps.executeQuery();
            if(rs.next()) { //데이터를 읽어왔을떄
                int boardId = rs.getInt("board_id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                int userId = rs.getInt("user_id");
                Date regdate = rs.getDate("regdate");
                int viewCnt = rs.getInt("view_cnt");
                System.out.println(boardId + ", " + title + ", " + content + ". " + userId + ", " + regdate + ", " + viewCnt);
            } else {
                throw new RuntimeException("board_id에 해당하는 자료가 없습니다.");
            }


            conn.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                System.out.println("rollback 합니다.");
                conn.rollback();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } finally {
            try {
                if(rs != null) rs.close();
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
