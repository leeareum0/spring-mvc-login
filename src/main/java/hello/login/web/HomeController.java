package hello.login.web;

import hello.login.domain.member.Member;
import hello.login.web.session.SessionManger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final SessionManger sessionManger;

//    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/")
    public String homeLogin(HttpServletRequest request, Model model) {

        //세션 관리자에 저장된 회원 정보 조회
        Member member = (Member) sessionManger.getSession(request);
        if (member == null) {
            return "home";
        }

        //로그인
        model.addAttribute("member", member);
        return "loginHome";
    }
}