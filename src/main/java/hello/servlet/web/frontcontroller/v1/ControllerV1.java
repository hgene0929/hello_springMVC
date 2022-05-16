package hello.servlet.web.frontcontroller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV1 {
    /* 서블릿과 형태가 동일한 process 메서드 생성
    *  동일한 프론트 컨트롤러를 사용하는 컨트톨러 간의 일관성을 유지하기 위함 */
    void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}
