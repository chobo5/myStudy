import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("HelloServlet 생성");
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("HelloServlet: init() 호출");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("HelloServlet: getServletConfig() 호출");
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("HelloServlet: service() 호출됨!");

        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("안녕하세요!!!");
    }

    @Override
    public String getServletInfo() {
        System.out.println("HelloServlet: getServletInfo() 호출");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("HelloServlet: destroy() 호출");
    }
}
