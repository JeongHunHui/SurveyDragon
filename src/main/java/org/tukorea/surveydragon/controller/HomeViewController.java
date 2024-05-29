package org.tukorea.surveydragon.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.tukorea.surveydragon.domain.SurveyVO;
import org.tukorea.surveydragon.service.SurveyService;

@Controller
@AllArgsConstructor
public class HomeViewController {
	private final SurveyService surveyService;

	@GetMapping("/")
	public String home(HttpServletRequest request, Model model) throws Exception {
		List<SurveyVO> surveys = surveyService.readSurveyList();
		HttpSession session = request.getSession();
		Boolean isLogin = session.getAttribute("user_name") != null;
		model.addAttribute("surveys", surveys);
		model.addAttribute("isLogin", isLogin);
		return "home";
	}
}
