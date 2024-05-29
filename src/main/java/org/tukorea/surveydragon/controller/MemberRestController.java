package org.tukorea.surveydragon.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.tukorea.surveydragon.domain.MemberVO;
import org.tukorea.surveydragon.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@AllArgsConstructor
@RequestMapping(value="/member/rest")
public class MemberRestController {
	private final MemberService memberService;

    @GetMapping("/{id}")
    public MemberVO readMember(@PathVariable String id) throws Exception {
        return memberService.readMember(id);
    }
}