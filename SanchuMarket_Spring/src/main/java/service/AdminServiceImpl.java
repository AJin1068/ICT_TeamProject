package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.AdminDao;
import vo.CategoryVo;
import vo.ProductVo;
import vo.ReportVo;
import vo.UserVo;
import vo.WithdrawlVo;

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
		List<CategoryVo> category_list = admin_dao.select_category_cnt();//4
		
		//���� ī�װ� DB�� �ִ� �� �޾ƿ���
		List<CategoryVo> list = admin_dao.select_category_list();//6
		
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
		
		
		//1. �⵵�� ȸ�� ���Լ�
		List<UserVo> annual_enrollList = admin_dao.countAnnualEnroll();//DB�����ҷ���randomVO
		List<Integer> list2 = new ArrayList<>();//list�� ���� ���ϱ� ���� �ӽ� �迭
		
		for(int i = 0; i < annual_enrollList.size(); i++) {
			list2.add(annual_enrollList.get(i).getU_month());
		}
		
		//DB���� �ҷ��� list�� ���� 12�� �� ������ ���� �� ����(tot�� 0���� ����)
		for(int i = 1; i <= 12; i++) {
			if(!list2.contains(i)) {
				UserVo vo = new UserVo();
				vo.setU_month(i);
				vo.setU_tot(0);
				annual_enrollList.add(vo);
			}
		}
		
		//2. �⵵�� ȸ�� Ż���
		List<WithdrawlVo> annual_withdrawlList = admin_dao.countAnnualWithdrawl();//DB�����ҷ���randomVO
		List<Integer> list3 = new ArrayList<>();//list�� ���� ���ϱ� ���� �ӽ� �迭
		
		for(int i = 0; i < annual_withdrawlList.size(); i++) {
			list2.add(annual_withdrawlList.get(i).getW_month());
		}
		
		//DB���� �ҷ��� list�� ���� 12�� �� ������ ���� �� ����(tot�� 0���� ����)
		for(int i = 1; i <= 12; i++) {
			if(!list3.contains(i)) {
				WithdrawlVo vo = new WithdrawlVo();
				vo.setW_month(i);
				vo.setW_tot(0);
				annual_withdrawlList.add(vo);
			}
		}
	
		//�� ����
		Collections.sort(annual_enrollList,new Comparator<UserVo>() {
			
			@Override
			public int compare(UserVo o1, UserVo o2) {
				
				return (o1.getU_month())-(o2.getU_month());
			}
		});
		
		Collections.sort(annual_withdrawlList,new Comparator<WithdrawlVo>() {
			
			@Override
			public int compare(WithdrawlVo o1, WithdrawlVo o2) {
				
				return (o1.getW_month())-(o2.getW_month());
			}
		});
			

		//�Ű� ȸ�� ��ȸ
		List<ReportVo> r_list = admin_dao.select_reportUser();
		
		
		Map map = new HashMap();
		
		map.put("p_list", p_list);
		map.put("r_list", r_list);
		map.put("category_list", category_list);
		map.put("today_p_count",today_p_count);
		map.put("today_t_count",today_t_count);
		map.put("today_v_count",today_v_count);
		map.put("today_u_count",today_u_count);
		map.put("annual_enrollList", annual_enrollList);
		map.put("annual_withdrawlList", annual_withdrawlList);
		
	
		return map;
	}

}
