package dao;

import org.apache.ibatis.session.SqlSession;

public class TradeDaoImpl {

	SqlSession sqlSession;
	
	//admin mainpage ���� �ŷ���
	public int selectTodayCount() {
		
		return sqlSession.selectOne("trade.today_count");
	}
}
