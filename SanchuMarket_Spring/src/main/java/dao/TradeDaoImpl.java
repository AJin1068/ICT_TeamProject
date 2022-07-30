package dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.TradeVo;

public class TradeDaoImpl implements TradeDao{

	SqlSession sqlSession;
	
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//�ŷ����̺� ���
	@Override
	public int tradeInsert(TradeVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("trade.trade_insert",vo);
	}

	//��ǰ ���� ������Ʈ
	@Override
	public int statusUpdate(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.update("trade.trade_update", map);
	}
	
	
	//�湮�ڰ� �����ϴ���??
	@Override
	public TradeVo select_user(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("trade.trade_select",map);
	}
	
	//�ŷ� ���
	@Override
	public int delete(int p_idx) {
		// TODO Auto-generated method stub
		return sqlSession.delete("trade.trade_cancel", p_idx);
	}
	
	
	
}
