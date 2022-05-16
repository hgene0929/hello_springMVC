package hello.servlet.web.frontcontroller.v4;

import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet.web.frontcontroller.v4.controller.MemberSaveControllerV4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {

    /* 매핑 정보보 */    private Map<String, ControllerV4> controllerMap = new HashMap<>();

    public FrontControllerServletV4() {
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    /* 서블릿 구현 */

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* 매핑 정보를 활용하여 해당 매핑 정보에 알맞은 응답 내보내기 */
        String requestURI = request.getRequestURI(); //요청 URI를 요청 메시지에서 꺼내기

        ControllerV4 controller = controllerMap.get(requestURI); //요청 URI에 해당 하는 객체 호출
        if(controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        /* 모델 객체에 요청 파라미터들을 저장 */
        Map<String, String> paramMap = createParamMap(request);
        /* 컨트롤러들에 파라미터로 전달될 모델 객체 구현 */
        HashMap<String, Object> model = new HashMap<>();

        /* 뷰이름 받아오기 */
        String viewName = controller.process(paramMap, model);

        /* 받아온 뷰이름( 논리적 이름 )을 URI로 렌더링 할 수 있는 형태로 만들어준다 */
        MyView view = viewResolver(viewName);
        view.render(model, request, response);
    }

    /* HttpServletRequest 에 담긴 요청 파라미터들을 모델객체에 저장 */
    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName,
                        request.getParameter(paramName)));
        return paramMap;
    }

    /* 받아온 뷰이름( 논리적 이름 )을 URI로 렌더링 할 수 있는 형태로 만들어준다  */
    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
