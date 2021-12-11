package front.notices.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import front.notices.common.ConnProperty;

import front.notices.vo.NoticeVO;

public class NoticedaoImpl implements NoticeDAO {

	@Repository
	public class NoticeDAOImpl implements NoticeDAO {

		
		private Logger logger = Logger.getLogger(NoticeDAOImpl.class);

		@Autowired(required=false)
		private SqlSessionTemplate sqlSession;

		// Notice Article INSERT
		@Override
		public int noticeInsert(NoticeVO nvo) {
			logger.info("DAOImpl.noticeInsert() CALL");
			return (Integer)sqlSession.insert("noticeInsert", nvo);
		}
		
		// SELECT Notice List
		@Override
		public List<NoticeVO> noticeList(NoticeVO nvo){
			logger.info("DAOImpl.noticeList() CALL");

			String searchType = nvo.getSearchType();
			String keyword = nvo.getKeyword();
			Map<String, String> map = new HashMap<String, String>();
			map.put("searchType", searchType);
			map.put("keyword", keyword);
			return sqlSession.selectList("noticeList", nvo);
		}
		
		// SELECT One Notice Article
		@Override
		public NoticeVO noticeSelect(NoticeVO nvo) {
			logger.info("DAOImpl.noticeSelect() CALL");
			return sqlSession.selectOne("noticeSelect", nvo);
		}

		// UPDATE HIT +1 When SELECT One Notice Article
		@Override
		public void updateCntHit(String no_num) {
			logger.info("DAOImpl.updateCntHit() CALL");
			sqlSession.update("updateCntHit", no_num);
		}
		
		// UPDATE One Notice Article
		@Override
		public int noticeUpdate(NoticeVO nvo) {
			// TODO Auto-generated method stub
			return sqlSession.update("noticeUpdate", nvo);
		}
		
		// UPDATE One Notice Article
		@Override
		public int noticeDelete(NoticeVO nvo) {
			// TODO Auto-generated method stub
			return sqlSession.update("noticeDelete", nvo);
		}
	}
}

		
		

	
