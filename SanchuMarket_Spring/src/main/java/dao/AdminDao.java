package dao;

import java.util.List;
import java.util.Map;

import vo.CategoryVo;
import vo.ProductVo;
import vo.UserVo;
import vo.WithdrawlVo;

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
	
	//�⵵�� Ż���ڼ�
	public List<WithdrawlVo> countAnnualWithdrawl();
	
	//ī�װ��� �ش��ϴ� ��ǰ ���� �޾ƿ���
	public List<CategoryVo> select_category_cnt();
	
	//��ü īƼ���� �� ��� �޾ƿ���
	public List<CategoryVo> select_category_list();
	
	//�������� - ����¡�� ���� 5�� �������� ���� ��ȸ
	public List<UserVo> select_userList(Map map);
	
	////�������� - �˻� ���Ǻ��� ����¡�� ���� start-end count
	public int count_userList(Map map);

	

}
