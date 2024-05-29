package org.tukorea.surveydragon.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tukorea.surveydragon.domain.SurveyVO;
import org.tukorea.surveydragon.service.SurveyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@AllArgsConstructor
@RequestMapping(value="/member/rest")
public class MemberRestController {
	private final SurveyService memberService;

    @GetMapping("/{id}")
    public SurveyVO readMember(@PathVariable String id) throws Exception {
        return memberService.readSurvey(id);
    }

    @PostMapping("/")
    public void createMember(@RequestBody SurveyVO studentVO) throws Exception {
        memberService.addSurvey(studentVO);
    }
}