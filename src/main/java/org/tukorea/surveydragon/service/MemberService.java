package org.tukorea.surveydragon.service;

import org.tukorea.surveydragon.domain.LoginDto;
import org.tukorea.surveydragon.domain.MemberVO;

public interface MemberService {
	MemberVO readMember(String id) throws Exception;
	void addMember(MemberVO member) throws Exception;
	void deleteMember(String id) throws Exception;
	void updateMember(MemberVO member) throws Exception;
	MemberVO findByEmailAndPassword(LoginDto loginDto) throws Exception;
}
