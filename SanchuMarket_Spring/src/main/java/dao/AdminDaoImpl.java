package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.CategoryVo;
import vo.ProductVo;

public class AdminDaoImpl implements AdminDao{

	SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//Admin ������ �ֱٻ�ǰ 6�� ��ȸ
	@Override
	public List<ProductVo> select_recent_product() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product.recent_product_six");
	}	
	
	//admin mainpage���� ��ǰ ���ε差
	@Override
	public int todayProductCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("product.today_count");
	}
	
	//�ֱ� ��ǰ ���ε� �Խù� 6�� ��ȸ
	@Override
	public List<ProductVo> selectRecentList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product.recent_product");
	}
		
	//admin mainpage ���� �ŷ���
	public int todayTradeCount() {
		
		return sqlSession.selectOne("trade.today_count");
	}	
		
	//admin mainpage ���� �湮�ڼ� ���
	public int todayVisitCount() {
		
		return sqlSession.selectOne("visit.today_count");
	}	
		
	//admin mainpage ���� ���Լ�
	public int todayEnrollCount() {
		
		return sqlSession.selectOne("user.enroll_count");
	}	
	
	//vo��ü�� ��ȿ�������� ������ �ʱ� ���� map���� ����.
	public Map<String,String> countAnnualEnroll() {
		
		return sqlSession.selectMap("user.count_enroll","");
	}
	
	//ī�װ��� �ش��ϴ� ��ǰ ���� �޾ƿ���
	@Override
	public List<CategoryVo> select_category_cnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product_categorycnt");
	}
	
	
	//��ü īƼ���� �� ��� �޾ƿ���
	@Override
	public List<CategoryVo> select_category_list() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product_categorynum");
	}


}
