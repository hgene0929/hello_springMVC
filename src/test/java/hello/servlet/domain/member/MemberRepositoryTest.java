package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    /* 싱글톤으로 관리되는 객체 인스턴스 가져오기기 */
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void 회원저장() throws Exception {
        //given
        Member member = new Member("hello", 20);

        //when
        Member saveMember = memberRepository.save(member);
        Member findMember = memberRepository.findById(saveMember.getId());

        //then
        Assertions.assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    public void 회원전체조회() throws Exception {
        //given
        Member member1 = new Member("hello", 20);
        Member member2 = new Member("hi", 21);

        //when
        Member saveMember1 = memberRepository.save(member1);
        Member saveMember2 = memberRepository.save(member2);

        List<Member> members = memberRepository.findAll();

        //then
        Assertions.assertThat(members.size()).isEqualTo(2);
        Assertions.assertThat(members).contains(saveMember1, saveMember2);
    }
}