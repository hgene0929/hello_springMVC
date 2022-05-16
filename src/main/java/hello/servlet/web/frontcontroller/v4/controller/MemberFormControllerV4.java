package hello.servlet.web.frontcontroller.v4.controller;

import hello.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4 {
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        /* 뷰이름을 매핑하여 이후에 뷰리졸버를 통해 렌더링될 수 있도록 구현 */
        return "new-form";
    }
}
