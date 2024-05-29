package org.tukorea.surveydragon.service;

import lombok.AllArgsConstructor;
import org.tukorea.surveydragon.domain.LoginDto;
import org.tukorea.surveydragon.domain.MemberVO;
import org.tukorea.surveydragon.domain.SurveyVO;
import org.tukorea.surveydragon.persistence.MemberDAO;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberDAO memberDAO;

	public MemberVO readMember(String id) throws Exception {
		return memberDAO.read(id);
	}

	public void addMember(MemberVO member) throws Exception {
		memberDAO.add(member);
	}

	public void deleteMember(String id) throws Exception {
		memberDAO.delete(id);
	}

	public void updateMember(MemberVO member) throws Exception {
		memberDAO.update(member);
	}

	public MemberVO findByEmailAndPassword(LoginDto loginDto) throws Exception {
		return memberDAO.selectByEmailAndPassword(loginDto);
	}
}
