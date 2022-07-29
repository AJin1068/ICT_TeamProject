package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.AdminDao;
import dao.ChatDao;
import dao.ProductDao;
import dao.TradeDao;
import dao.UserDao;
import dao.VisitDao;
import vo.CategoryVo;
import vo.ProductVo;

public class AdminServiceImpl implements AdminService {

	
	AdminDao admin_dao;
	
	public void setAdmin_dao(AdminDao admin_dao) {
		this.admin_dao = admin_dao;
	}

	@Override
	public Map list() {
		
		//�ǽð� ��ǰ ���ε�(list��ĭ �ȿ� �ֱ� vo��ü �ϳ� ������(�ִ� 6��))
		List<ProductVo> p_list = admin_dao.select_recent_product();
		
		//���� ��ǰ���ε�
		int today_p_count = admin_dao.todayProductCount();
		
		//���� �ŷ���
		int today_t_count = admin_dao.todayTradeCount();
		
		//���� �湮�ڼ�
		int today_v_count = admin_dao.todayVisitCount();
		
		//���� �����ڼ�
		int today_u_count = admin_dao.todayEnrollCount();
		
		
		/*
			ī�װ� ���� ��ǰ�� ���� �� ������ 
			�����Ͻ� ���� ���� ó��
		*/
		
		
		
		
		//���� ��ǰ DB�� �ִ� ī�װ��� ��ǰ���� �������
		List<CategoryVo> category_list = product_dao.select_category_cnt();//4
		//[3,4,5,6]
		
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
			
			if(!productsize.contains(categorysize.get(i))) {
				CategoryVo vo = new CategoryVo(i+1, 0);
				category_list.add(vo);
			}
			
		}
		
	
		
		//�⵵�� ȸ�� ����Ż���
		//Map annual_enroll_count = admin_dao.countAnnualEnroll();

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
