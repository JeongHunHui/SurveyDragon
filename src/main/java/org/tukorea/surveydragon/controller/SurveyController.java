package org.tukorea.surveydragon.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.tukorea.surveydragon.domain.SurveyVO;
import org.tukorea.surveydragon.service.SurveyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@AllArgsConstructor
@RequestMapping(value="/survey")
public class SurveyController {
	private final SurveyService surveyService;

	@GetMapping("/register")
    public String surveyRegisterPage() throws Exception {
        return "registerSurvey";
    }

	@PostMapping("/register")
	public String surveyRegister(@ModelAttribute SurveyVO vo, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		vo.setMemberId((String) session.getAttribute("id"));
		surveyService.addSurvey(vo);
		return "redirect:/";
	}

	@GetMapping("/manage")
	public String manageSurveys(Model model, HttpServletRequest request) {
		List<SurveyVO> surveys = surveyService.getSurveysByUserId((String) request.getSession().getAttribute("id"));
		model.addAttribute("surveys", surveys);
		return "manageSurvey";
	}

	@GetMapping("/info")
	public String surveyRegisterPage(@RequestParam("id") String id, Model model) throws Exception {
		model.addAttribute("survey", surveyService.readSurvey(id));
		return "surveyInfo";
	}

	@GetMapping("/delete")
	public String deleteSurvey(@RequestParam("id") String surveyId, Model model) {
		try {
			surveyService.deleteSurvey(surveyId);
			return "redirect:/survey/manage";
		} catch (Exception e) {
			model.addAttribute("error", "설문 삭제 중 오류가 발생했습니다.");
			return "manageSurvey";
		}
	}

	@GetMapping("/edit")
	public String editSurvey(Model model, @RequestParam("id") String surveyId) throws Exception {
		model.addAttribute("survey", surveyService.readSurvey(surveyId));
		return "editSurvey";
	}

	@PostMapping("/update")
	public String surveyUpdate(@ModelAttribute SurveyVO vo) throws Exception {
		surveyService.updateSurvey(vo);
		return "redirect:/survey/manage";
	}
}