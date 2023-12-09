package com.example.servletexam;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//http://locahost:8080/plus?x=10&y=20
//?이하는 parameter
//parameter 구조: name=value&name2=value2&name3=value3
@WebServlet(name = "plusServlet", value = "/plus")
public class PlusServlet extends HttpServlet {

    //GET, POST, DELETE등 모두 처하는 메소드
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strX = req.getParameter("x");
        String strY = req.getParameter("y");

        //입력 받으면 입력값을 검증한다 반드시


        int x = Integer.parseInt(strX); //parameter를 전달받지 못하면 NullPointerException
        int y = Integer.parseInt(strY);

        int value = x + y;

//        PrintWriter out = resp.getWriter();
//        out.println("<h1>");
//        out.println(x + " + " + y + " = " + value);
//        out.println("</h1>");
        //직접 입력은 너무 귀찮다.

        //1. 요청정보의 x, y, value키에 값들을 request에 담는다.
        req.setAttribute("x", x);
        req.setAttribute("y", y);
        req.setAttribute("value", value);
        //2.plus.jsp를 사용할 수 있는 requestDispatcher를 생성하고
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/plus.jsp");
        //3. servlet이 가지고있는 req, resp를 plus.jsp에 전달한다.
        requestDispatcher.forward(req, resp); //포워딩 (중요: 포워딩과 리다이렉트)



    }
}
