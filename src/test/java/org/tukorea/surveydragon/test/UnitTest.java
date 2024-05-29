package org.tukorea.surveydragon.test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tukorea.surveydragon.domain.MemberVO;
import org.tukorea.surveydragon.domain.SurveyVO;
import org.tukorea.surveydragon.persistence.MemberDAO;
import org.tukorea.surveydragon.persistence.SurveyDAO;
import org.tukorea.surveydragon.service.MemberServiceImpl;
import org.tukorea.surveydragon.service.SurveyServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class UnitTest {

	@InjectMocks
	private MemberServiceImpl memberService;

	@InjectMocks
	private SurveyServiceImpl surveyService;

	@Mock
	private MemberDAO memberDAO;

	@Mock
	private SurveyDAO surveyDAO;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testReadById() throws Exception {
		// Given
		MemberVO member = new MemberVO("1", "홍길동", "hong.gildong@example.com", "password123");
		when(memberDAO.read("1")).thenReturn(member);

		// When
		MemberVO result = memberService.readMember("1");

		// Then
		assertEquals("1", result.getId());
		assertEquals("홍길동", result.getName());
		verify(memberDAO, times(1)).read("1");
	}

	@Test
	public void testReadSurveyList() throws Exception {
		// Given
		SurveyVO survey1 = new SurveyVO("1", "설문조사 1", "목적 1", "2024-12-31", "기프트 카드", "100", "1", "http://example.com/survey1");
		SurveyVO survey2 = new SurveyVO("2", "설문조사 2", "목적 2", "2024-11-30", "쿠폰", "50", "1", "http://example.com/survey2");
		when(surveyDAO.readList()).thenReturn(Arrays.asList(survey1, survey2));

		// When
		List<SurveyVO> result = surveyService.readSurveyList();

		// Then
		assertEquals(2, result.size());
		assertEquals("설문조사 1", result.get(0).getTitle());
		verify(surveyDAO, times(1)).readList();
	}

	@Test
	public void testModify() throws Exception {
		// Given
		MemberVO member = new MemberVO("1", "홍길동", "hong.gildong@example.com", "password123");
		when(memberDAO.read("1")).thenReturn(member);

		// When
		member.setName("수정된 이름");
		memberService.updateMember(member);
		when(memberDAO.read("1")).thenReturn(member);

		// Then
		MemberVO result = memberService.readMember("1");
		assertEquals("수정된 이름", result.getName());
		verify(memberDAO, times(1)).update(member);
	}

	@Test
	public void testSurveyRead() throws Exception {
		// Given
		SurveyVO survey = new SurveyVO("1", "설문조사 1", "목적 1", "2024-12-31", "기프트 카드", "100", "1", "http://example.com/survey1");
		when(surveyDAO.read("1")).thenReturn(survey);

		// When
		SurveyVO result = surveyService.readSurvey("1");

		// Then
		assertEquals("1", result.getId());
		assertEquals("설문조사 1", result.getTitle());
		verify(surveyDAO, times(1)).read("1");
	}
}
