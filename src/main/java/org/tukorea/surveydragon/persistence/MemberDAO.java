package org.tukorea.surveydragon.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.tukorea.surveydragon.domain.LoginDto;
import org.tukorea.surveydragon.domain.MemberVO;
import org.tukorea.surveydragon.domain.SurveyVO;

public interface MemberDAO {
	void add(MemberVO member) throws Exception;
	List<MemberVO> readList() throws Exception;
	MemberVO read(String id) throws Exception;
	void delete(String id) throws Exception;
	void update(MemberVO member) throws Exception;
	MemberVO selectByEmailAndPassword(LoginDto loginDto);
}
