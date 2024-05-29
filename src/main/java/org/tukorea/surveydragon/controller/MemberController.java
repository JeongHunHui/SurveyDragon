package org.tukorea.surveydragon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.tukorea.surveydragon.domain.LoginDto;
import org.tukorea.surveydragon.domain.MemberVO;
import org.tukorea.surveydragon.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(value="/member")
public class MemberController {
	private final MemberService memberService;

	@GetMapping("/login")
    public String loginPage() throws Exception {
        return "login";
    }

	@GetMapping("/signup")
	public String signupPage() throws Exception {
		return "signup";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) throws Exception {
		request.getSession().invalidate();
		return "redirect:/";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute LoginDto dto, HttpServletRequest request) throws Exception {
		try{
			MemberVO memberVO = memberService.findByEmailAndPassword(dto);
			HttpSession session = request.getSession();
			session.setAttribute("user_email", memberVO.getEmail());
			session.setAttribute("user_name", memberVO.getName());
		} catch (Exception e) {
			return "login";
		}
		return "redirect:/";
	}

	@PostMapping("/signup")
	public String signup(@ModelAttribute MemberVO vo) throws Exception {
		memberService.addMember(vo);
		return "login";
	}
}