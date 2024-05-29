package org.tukorea.surveydragon.persistence;

import java.util.List;

import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.tukorea.surveydragon.domain.LoginDto;
import org.tukorea.surveydragon.domain.MemberVO;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class MemberDAOImpl implements MemberDAO {
	private final SqlSession sqlSession;
	
	private static final String namespace = "org.tukorea.surveydragon.mapper.MemberMapper";

	public MemberVO read(String id) throws Exception {
		return sqlSession.selectOne(namespace+".selectByid", id);
	}

	public List<MemberVO> readList() throws Exception {
		return sqlSession.selectList(namespace + ".selectAll");
	}

	public void add(MemberVO member) throws Exception {
		sqlSession.insert(namespace + ".insert", member);
	}

	public void delete(String id) throws Exception {
		sqlSession.delete(namespace + ".delete", id);
	}

	public void update(MemberVO member) throws Exception {
	    sqlSession.update(namespace + ".update", member);
	}

	public MemberVO selectByEmailAndPassword(LoginDto loginDto) {
		return sqlSession.selectOne(namespace + ".selectByEmailAndPassword", loginDto);
	}
}
