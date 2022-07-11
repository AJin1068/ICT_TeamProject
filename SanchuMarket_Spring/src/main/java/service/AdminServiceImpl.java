package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.chat.ChatDao;
import dao.product.ProductDao;
import dao.trade.TradeDao;
import vo.chat.ChatVo;
import vo.product.ProductVo;

public class AdminServiceImpl implements AdminService {

	ProductDao product_dao;
	ChatDao chat_dao;
	TradeDao trade_dao;
	


	public AdminServiceImpl(ProductDao product_dao, ChatDao chat_dao, TradeDao trade_dao) {
		super();
		this.product_dao = product_dao;
		this.chat_dao = chat_dao;
		this.trade_dao = trade_dao;
	}


	@Override
	public Map list() {
		
		//�ǽð� ��ǰ&ä�� ���ε�(list��ĭ �ȿ� �ֱ� vo��ü �ϳ� ������(�ִ� 6��))
		List<ProductVo> p_list = product_dao.selectList();
		List<ChatVo> ch_list = chat_dao.SelectRecentList();
		
		//���� ��ǰ���ε�
		int today_p_count = product_dao.selectTodayCount();
		
		//���� �ŷ���
		int today_t_count = trade_dao.selectTodayCount();

		Map map = new HashMap();
		
		map.put("p_list", p_list);
		map.put("ch_list", ch_list);
		map.put("today_p_count",today_p_count);
		map.put("today_t_count",today_t_count);
		
		//service�� ��� joinpoint���� advice�� �Ѿ�� �α��� 1.234�� �Ŀ� ���. 
		//list�޼ҵ� ȣ�� ������ 1.234�� ������Ű�°�.
		/*
		 * try { Thread.sleep(1234); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */
		
		return map;
	}

}
