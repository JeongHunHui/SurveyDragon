package org.tukorea.surveydragon.service;

import java.util.List;

import org.tukorea.surveydragon.domain.SurveyVO;

public interface SurveyService {
	SurveyVO readSurvey(String id) throws Exception;
	List<SurveyVO> readSurveyList() throws Exception;
	void addSurvey(SurveyVO survey) throws Exception;
	void deleteSurvey(String id) throws Exception;
	void updateSurvey(SurveyVO survey) throws Exception;
}
