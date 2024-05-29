package org.tukorea.surveydragon.persistence;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.tukorea.surveydragon.domain.SurveyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SurveyDAOImpl implements SurveyDAO {
	private final SqlSession sqlSession;
	
	private static final String namespace = "org.tukorea.surveydragon.mapper.SurveyMapper";

	public SurveyVO read(String id) throws Exception {
		SurveyVO vo = sqlSession.selectOne(namespace+".selectByid", id);
		return vo;   
	}
 
	public List<SurveyVO> readList() throws Exception {
		List<SurveyVO> surveyList = new ArrayList<SurveyVO>();
		surveyList = sqlSession.selectList(namespace + ".selectAll");
		return surveyList;
	}
	
	public void add(SurveyVO survey) throws Exception {
		sqlSession.insert(namespace + ".insert", survey);
	}

	public void delete(String id) throws Exception {
		sqlSession.delete(namespace + ".delete", id);
	}

	public void update(SurveyVO survey) throws Exception {
	    sqlSession.update(namespace + ".update", survey);
	}

	public List<SurveyVO> getSurveysByUserId(String memberId) {
		return sqlSession.selectList(namespace + ".selectByUserId", memberId);
	}
}
