package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("springmvc/old-controller")
public class OldController implements Controller {

    /* 핸들러 호출 결과로 ModelAndView 타입의 객체를 반환 */
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        /* 핸들러 호출 결과로 뷰를 반환
        *  뷰리졸버를 고려하여 논리적 주소로 반환 */
        return new ModelAndView("new-form");
    }
}
