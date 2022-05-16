package hello.servlet.web.frontcontroller.v4.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Member> members = memberRepository.findAll();

        /* 모델 역할을 하는 파라미터를 통해 데이터 담아서 전달
         *  모델이 파라미터로 전달되기 때문에, 모델을 직접 생성하지 않아도 된다 */
        model.put("members", members);

        /* 뷰이름을 매핑하여 이후에 뷰리졸버를 통해 렌더링될 수 있도록 구현 */
        return "members";
    }
}
