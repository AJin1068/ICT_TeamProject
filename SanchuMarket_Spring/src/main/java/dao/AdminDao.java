package dao;

import java.util.List;
import java.util.Map;

import vo.ProductVo;

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
	public Map countAnnualEnroll();

}
