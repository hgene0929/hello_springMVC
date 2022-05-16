package hello.servlet.web.frontcontroller;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter @Setter //모델에 원하는 데이터를 담고 전달하기 위해 getter/setter 메서드를 열어둔다
public class ModelView {

    private String viewName; //뷰 렌더링을 위해 필요한 필드
    private Map<String, Object> model = new HashMap<>(); //모델 객체

    public ModelView(String viewName) { //모델 객체 생성시, 뷰이름을 매핑해준다
        this.viewName = viewName;
    }
}
