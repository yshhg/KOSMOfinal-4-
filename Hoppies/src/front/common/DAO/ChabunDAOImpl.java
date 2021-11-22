package front.common.DAO;

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

import front.mem.vo.MemberVO;

@Repository
public class ChabunDAOImpl implements ChabunDAO {
	private Logger logger = Logger.getLogger(ChabunDAOImpl.class);

	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;
	/* SqlSession : 핵심적인 역할을 하는 클래스로서 SQL 실행이다 트랙잭션 관리를 실행한다. 
	SqlSession 오브젝트는 Thread-Safe 하지 않으므로 thread마다 필요에 따라 생성한다
	
	트랜잭션 : 하나의 논리적 작업 단위로 수행되는 일련의 작업
	*/
	
	@Override
	public MemberVO getMemChabun() {
		// TODO Auto-generated method stub
		logger.info("ChabunDAOImpl getMemChabun >>> : ");
		return sqlSession.selectOne("getMemChabun");
	}

}
