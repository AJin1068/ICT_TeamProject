package dao;

import java.util.Map;

import vo.TradeVo;

public interface TradeDao {

	//admin mainpage ���� �ŷ���
	public int todayTradeCount();
	
	public int tradeInsert(TradeVo vo);

	public int statusUpdate(Map Map);

}
