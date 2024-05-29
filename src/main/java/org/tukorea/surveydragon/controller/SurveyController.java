package org.tukorea.surveydragon.controller;

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
	public String surveyRegister(@ModelAttribute SurveyVO vo) throws Exception {
		surveyService.addSurvey(vo);
		return "redirect:/";
	}

	@GetMapping("/info")
	public String surveyRegisterPage(@RequestParam("id") String id, Model model) throws Exception {
		model.addAttribute("survey", surveyService.readSurvey(id));
		return "surveyInfo";
	}
}