package org.tukorea.surveydragon.persistence;

import java.util.List;

import org.tukorea.surveydragon.domain.SurveyVO;

public interface SurveyDAO {

	void add(SurveyVO survey) throws Exception;
	List<SurveyVO> readList() throws Exception;
	SurveyVO read(String id) throws Exception;
	void delete(String id) throws Exception;
	void update(SurveyVO survey) throws Exception;

}
