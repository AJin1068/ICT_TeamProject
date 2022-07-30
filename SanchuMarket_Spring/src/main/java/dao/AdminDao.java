package dao;

import java.util.List;

import vo.CategoryVo;
import vo.ProductVo;
import vo.UserVo;

public interface AdminDao {

	
	//�ֱ� ��ǰ ��ȸ
	public List<ProductVo> selectRecentList();

	//�ֱ� �ö�� ��ǰ 6�� ��ȸ
	public List<ProductVo> select_recent_product();
	
	//��ǰ���ε�
	public int todayProductCount();

	//���� �ŷ���
	public int todayTradeCount();

	//���� �湮�ڼ�
	int todayVisitCount();

	//���� ���Լ�
	public int todayEnrollCount();
	
	//�⵵�� �����ڼ�
	public List<UserVo> countAnnualEnroll();
	
	//ī�װ��� �ش��ϴ� ��ǰ ���� �޾ƿ���
	public List<CategoryVo> select_category_cnt();
	
	//��ü īƼ���� �� ��� �޾ƿ���
	public List<CategoryVo> select_category_list();
	

}
