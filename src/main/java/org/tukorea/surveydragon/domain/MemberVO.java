package org.tukorea.surveydragon.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class MemberVO {
	private String id;
	private String name;
	private String email;
	private String password;
}
