package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.ChatDao;
import dao.ProductDao;
import dao.TradeDao;
import dao.UserDao;
import dao.VisitDao;
import vo.CategoryVo;
import vo.ProductVo;

public class AdminServiceImpl implements AdminService {

	ProductDao product_dao;
	ChatDao chat_dao;
	TradeDao trade_dao;
	UserDao user_dao;
	VisitDao visit_dao;
	
	
	public AdminServiceImpl(ProductDao product_dao, ChatDao chat_dao, TradeDao trade_dao, UserDao user_dao,
			VisitDao visit_dao) {
		super();
		this.product_dao = product_dao;
		this.chat_dao = chat_dao;
		this.trade_dao = trade_dao;
		this.user_dao = user_dao;
		this.visit_dao = visit_dao;
	}

	@Override
	public Map list() {
		
		//�ǽð� ��ǰ&ä�� ���ε�(list��ĭ �ȿ� �ֱ� vo��ü �ϳ� ������(�ִ� 6��))
		List<ProductVo> p_list = product_dao.select_recent_product();
//		List<ChatVo> ch_list = chat_dao.SelectRecentList();
		
		//���� ��ǰ���ε�
		int today_p_count = product_dao.todayProductCount();
		
		//���� �ŷ���
		int today_t_count = trade_dao.todayTradeCount();
		
		//���� �湮�ڼ�
		int today_v_count = visit_dao.todayVisitCount();
		
		//���� �����ڼ�
		int today_u_count = user_dao.todayEnrollCount();
		
		
		/*
			ī�װ� ���� ��ǰ�� ���� �� ������ 
			�����Ͻ� ���� ���� ó��
		*/
		
		
		
		
		//���� ��ǰ DB�� �ִ� ī�װ��� ��ǰ���� �������
		List<CategoryVo> category_list = product_dao.select_category_cnt();//4
		
		//���� ī�װ� DB�� �ִ� �� �޾ƿ���
		List<CategoryVo> list = product_dao.select_category_list();//6
		
		// ī�װ� ������ ũ�� ����
		List<Integer> categorysize = new ArrayList<Integer>();
		
		for(int i=0; i<list.size(); i++) {
			categorysize.add(i+1);
		}
		
		//��ǰ ������ ũ�� ����
		List<Integer> productsize = new ArrayList<Integer>();		
		
		for(int i=0; i<category_list.size(); i++) {
			productsize.add(category_list.get(i).getC_idx());
		}
		
		
		for(int i=0; i<categorysize.size(); i++) {
			
			//
			if(!productsize.contains(categorysize.get(i))) {
				CategoryVo vo = new CategoryVo(i+1, 0);
				category_list.add(vo);
			}
			
		}
		
		//��ü �����ϱ�
		Collections.sort(category_list, new Comparator<CategoryVo>() {

			@Override
			public int compare(CategoryVo o1, CategoryVo o2) {
				// TODO Auto-generated method stub
				
				return o1.getC_idx()-o2.getC_idx();
			}
		});
		
		
	
		
		
	
		
		//�⵵�� ȸ�� ����Ż���
		//Map annual_enroll_count = user_dao.countAnnualEnroll();

		Map map = new HashMap();
		
		map.put("p_list", p_list);
		map.put("category_list", category_list);
		map.put("today_p_count",today_p_count);
		map.put("today_t_count",today_t_count);
		map.put("today_v_count",today_v_count);
		map.put("today_u_count",today_u_count);
		
		
		//service�� ��� joinpoint���� advice�� �Ѿ�� �α��� 1.234�� �Ŀ� ���. 
		//list�޼ҵ� ȣ�� ������ 1.234�� ������Ű�°�.
		/*
		 * try { Thread.sleep(1234); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */
		
		return map;
	}

}
