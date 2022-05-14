package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override //해당 메서드를 오버라이딩함으로써 서블릿 객체가 실행되면 바로 해당 메서드가 실행될 수 있도록 한다
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* 서비스 메서드가 제대로 실행되는지 확인 */
        System.out.println("HelloServlet.service");
        /* 사용자 요청이 오면 request 와 response가 잘 생성되는지 확인 */
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        /* http 요청메시지를 받을 때 쿼리 파라미터를 받았는지 확인
        *  서블릿 객체의 request 를 통해 쉽게 받을 수 있다 */
        String username = request.getParameter("username");
        System.out.println("username = " + username);
        /* http 응답 메시지 처리 */
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username);
    }
}
