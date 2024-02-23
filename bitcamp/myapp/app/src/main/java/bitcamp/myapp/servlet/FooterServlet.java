package bitcamp.myapp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/footer")
public class FooterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<footer style='background-color:gray; color:white; padding=10px; text-align:center;'>");
        out.println("<address>서울시 강남구 강남대로94길 20, 삼오빌딩 5층</address>");
        out.println("<p>&copy; 2024 네이버 클라우드 데브옵스 과정 5기</p>");
        out.println("</footer>");
    }
}
