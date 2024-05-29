package org.tukorea.surveydragon.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class SurveyVO {
	private String id;
	private String title;
	private String purpose;
	private String endDate;
	private String reward;
	private String rewardCount;
	private String memberId;
	private String url;
}
