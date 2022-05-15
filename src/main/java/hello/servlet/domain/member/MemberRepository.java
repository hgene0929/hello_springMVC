package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    /* 로컨 메모리에 저장소 구현 */
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    /* 싱글톤 패턴 적용 */
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository() { //생성자를 막아 싱글톤 패턴 적용

    }

    /* 기능 : 저장, 조회( 전체, id조회 ), 전체 삭제( 테스트용 ) */
    public Member save(Member member) {
        member.setId(++sequence); //회원ID 를 저장시 1씩 증가하도록 설정
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
