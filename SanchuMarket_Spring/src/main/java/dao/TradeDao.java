package dao;

import vo.TradeVo;

public interface TradeDao {

	
	//admin mainpage ���� �ŷ���
	public int todayTradeCount();
	
	public int tradeInsert(TradeVo vo);

}
