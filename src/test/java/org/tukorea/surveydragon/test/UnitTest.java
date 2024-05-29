package org.tukorea.surveydragon.test;

import java.util.List;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tukorea.surveydragon.domain.MemberVO;
import org.tukorea.surveydragon.domain.SurveyVO;
import org.tukorea.surveydragon.persistence.MemberDAO;
import org.tukorea.surveydragon.persistence.SurveyDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class UnitTest {

	@Autowired
	private MemberDAO dao;
    @Autowired
    private SurveyDAO surveyDAO;

	private static final Logger logger = (Logger) LoggerFactory.getLogger(UnitTest.class);

	// 1. id로 member 조회 테스트
	@Test
	public void testReadById() throws Exception {
		addTestData();
		MemberVO vo = dao.read("1");
		logger.info(vo.toString());
		deleteTestData();
	}

	// 2. id로 member 목록 조회 테스트
	@Test
	public void testReadList() throws Exception {
		addTestData();
		List<MemberVO> voList = dao.readList();
		for(MemberVO vo : voList) {
			logger.info(vo.toString());
		}
		deleteTestData();
	}

	// 3. id로 member 수정 테스트
	@Test
	public void testModify() throws Exception {
		addTestData();
		MemberVO vo = dao.read("1");
		logger.info(vo.toString());
		vo.setName("modifiedName");
		dao.update(vo);
		MemberVO vo2 = dao.read("1");
		logger.info(vo2.toString());
		deleteTestData();
	}

    // 4. id로 survey 조회 테스트
    @Test
    public void testSurveyRead() throws Exception {
        SurveyVO vo = new SurveyVO("1", "test", "test", "test", "test", "test", "1", "test");
        surveyDAO.add(vo);

        SurveyVO vo2 = surveyDAO.read("1");
        logger.info(vo2.toString());

        surveyDAO.delete("1");
    }

	private void addTestData() throws Exception {
        MemberVO vo = new MemberVO("1", "test", "test", "test");
		dao.add(vo);
	}

	private void deleteTestData() throws Exception {
		dao.delete("1");
	}
}
