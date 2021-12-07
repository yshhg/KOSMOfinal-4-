package front.mem.dao;

import java.util.List;

import front.mem.vo.MemberVO;


import org.apache.log4j.Logger;

import org.mybatis.spring.SqlSessionTemplate;
/*
import org.mybatis.spring.SqlSessionTemplate;
SqlSession 인터페이스를 구현하는 Singleton 버전의 SqlSession 구성 요소.
안전한 스레드 SqlSession 개체를 생성
서비스 등 싱글톤 구성요소에 DI를 적용할 수 있습니다.

전역 변수를 사용하지 않고 객체를 하나만 생성 하도록 하며, 생성된 객체를 어디에서든지 참조할 수 있도록 하는 패턴
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


//@repository 패키지는 DB에 접근하는 모든 코드가 모여있다고 생각하시면 됩니다.

//@service 패키지는 DB에 접근하는 코드는 repository에 위임하고, 비즈니스 로직과 관련된 모든 코드가 모여있습니다.
@Repository
public class MemberDAOImpl implements MemberDAO {
	Logger logger = Logger.getLogger(MemberDAOImpl.class);
	
	@Autowired(required=false)	
	private SqlSessionTemplate sqlSession;
	
			

	@Override
	public List<MemberVO> memberSelectAll(MemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("memberDAOImpl memberSelectAll() 함수진입");
		
		
		return sqlSession.selectList("memberSelectAll", mvo);
		/* SqlSession : 핵심적인 역할을 하는 클래스로서 SQL 실행이다 트랙잭션 관리를 실행한다. 
		SqlSession 오브젝트는 Thread-Safe 하지 않으므로 thread마다 필요에 따라 생성한다
		
		트랜잭션 : 하나의 논리적 작업 단위로 수행되는 일련의 작업
		*/
		
	}

	@Override
	public List<MemberVO> memberSelect(MemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("memberDAOImpl memberSelect() 함수 진입");	
		return sqlSession.selectList("memberSelect",mvo);
	}

	@Override
	public int memberInsert(MemberVO mvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.insert("memberInsert",mvo);
	}

	@Override
	public int memberUpdate(MemberVO mvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.update("memberUpdate", mvo);
	}

	@Override
	public int memberDelete(MemberVO mvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.delete("memberDelete",mvo);
	}

	@Override
	public List<MemberVO> memberIdCheck(MemberVO mvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("memberIdCheck",mvo);
	}

	@Override
	public int insertMember(MemberVO mvo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("insertMember",mvo);
	}


}
