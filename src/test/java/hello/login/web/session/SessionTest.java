package hello.login.web.session;

import hello.login.domain.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class SessionTest {
    SessionManager sessionManager = new SessionManager();

    @Test
    public void sessionTest() {
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        // 세션 생성
        Member member = new Member();
        sessionManager.createSession(member, mockHttpServletResponse);

        // 요청에 응답 쿠키가 저장 되었는지 여부 확인
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.setCookies(mockHttpServletResponse.getCookies()); // mySessionId = 12312313

        // 세션 조회
        Object result = sessionManager.getSession(mockHttpServletRequest);
        Assertions.assertThat(result).isEqualTo(member);

        // 세션 만료
        sessionManager.expire(mockHttpServletRequest);
        Object expired = sessionManager.getSession(mockHttpServletRequest);
        Assertions.assertThat(expired).isNull();
    }
}
