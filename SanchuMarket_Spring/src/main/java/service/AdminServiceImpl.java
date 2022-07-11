package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.ProductDao;
import dao.chat.ChatDao;
import dao.trade.TradeDao;
import vo.chat.ChatVo;
import vo.product.ProductVo;

public class AdminServiceImpl implements AdminService {

	ProductDao productDao;
	ChatDao chatDao;
	TradeDao tradeDao;
	
	@Override
	public Map list() {
		
		//�ǽð� ��ǰ&ä�� ���ε�(list��ĭ �ȿ� �ֱ� vo��ü �ϳ� ������(�ִ� 6��))
		List<ProductVo> p_list = productDao.selectList();
		List<ChatVo> ch_list = chatDao.SelectRecentList();
		
		//���� ��ǰ���ε�
		int today_p_count = productDao.selectTodayCount();
		
		//���� �ŷ���
		int today_t_count = tradeDao.selectTodayCount();

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
