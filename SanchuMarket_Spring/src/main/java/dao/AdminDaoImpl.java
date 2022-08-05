package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.CategoryVo;
import vo.ProductVo;
import vo.ReportVo;
import vo.UserVo;
import vo.WithdrawlVo;

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
	
	
	public List<UserVo> countAnnualEnroll() {
		
		return sqlSession.selectList("user.annual_enroll_count");
	}
	
	@Override
	public List<WithdrawlVo> countAnnualWithdrawl() {
		
		return sqlSession.selectList("user.annual_withdrawl_count");
	}
	
	//ī�װ��� �ش��ϴ� ��ǰ ���� �޾ƿ���
	@Override
	public List<CategoryVo> select_category_cnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product.product_categorycnt");
	}
	
	
	//��ü īƼ���� �� ��� �޾ƿ���
	@Override
	public List<CategoryVo> select_category_list() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product.product_categorynum");
	}
	
	//�������� - ����¡�� ���� start-end �������� ���� ��ȸ
	public List<UserVo> select_userList(Map map){
		
		return sqlSession.selectList("user.user_conditionList", map);
	}
	
	//�������� - ����¡�� ���� start-end�� �˻� ���Ǻ��� ��ȸ
	public int count_userList(Map map) {
		
		return sqlSession.selectOne("user.user_list",map);
	}

	//�ֱ� �Ű� ���� ��ȸ
	@Override
	public List<ReportVo> select_reportUser() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("user.report_userList");
	}
	//�Ű� Ƚ�� �ջ�
	@Override
	public int select_reportCnt(int u_idx_reported) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("user.report_sum",u_idx_reported);
	}
	
	public ReportVo select_reportUser2(int r_idx) {
		
		return sqlSession.selectOne("user.report_userVo",r_idx);
	}





}
