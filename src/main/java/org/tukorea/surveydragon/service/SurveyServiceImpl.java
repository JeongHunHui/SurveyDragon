package org.tukorea.surveydragon.service;

import java.util.List;

import lombok.AllArgsConstructor;
import org.tukorea.surveydragon.domain.SurveyVO;
import org.tukorea.surveydragon.persistence.SurveyDAO;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SurveyServiceImpl implements SurveyService {
	private final SurveyDAO surveyDAO;

	public SurveyVO readSurvey(String id) throws Exception {
		return surveyDAO.read(id);
	}
	
	public List<SurveyVO> readSurveyList() throws Exception{
		return surveyDAO.readList();
	}
	
	public void addSurvey(SurveyVO survey) throws Exception {
		surveyDAO.add(survey);
	}
	
	public void deleteSurvey(String id) throws Exception {
		surveyDAO.delete(id);
	}
	
	public void updateSurvey(SurveyVO survey) throws Exception {
		surveyDAO.update(survey);
	}

}
