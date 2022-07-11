package dao.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.user.UserVo;

public class UserDaoImpl {

	SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	
	//������ ��ü ȸ�� ��ȸ
	public List<UserVo> selectList(){
		
		return sqlSession.selectList("user.user_list");
	}
	
	
	public List<UserVo> selectList(int u_idx) {

		return sqlSession.selectList("product.product_user_list",u_idx);
	}
	
	
	public UserVo selectOneByIdx(int u_idx){
		
		return sqlSession.selectOne("user.user_idx", u_idx);
	}
	
	
	// �Ǹ��� ������ ������ ������ ���������
	public UserVo selectOneByIdxTime(int u_idx){
		
		return sqlSession.selectOne("user.user_idx_reg", u_idx);
	}
	
	
	//ȸ�����Խ� ���̵� �ߺ� ����, �α���
	public UserVo selectOneById(String u_id){
		
		return sqlSession.selectOne("user.check_id", u_id);
		
	}
	
	//ȸ�����Խ� �г��� �ߺ� ����
	public UserVo selectOneByNickname(String u_nickname){
		
		return sqlSession.selectOne("user.check_nickname", u_nickname);
	}
	
	
	//ȸ�����Խ� �̸��� �ߺ� ����
	public UserVo selectOneByEmail(String email) {
		
		return sqlSession.selectOne("user.check_email", email);
		
	}
	
	
	//admin mainpage ���� �湮��
	public int selectTodayCount() {

		return sqlSession.selectOne("trade.today_count");
	}
		
	
	public int insert(UserVo vo) {
		

		return sqlSession.insert("user.user_insert", vo);
		
	}

	public int update(UserVo vo) {

		return sqlSession.update("user.user_update",vo);
	}
	
	
	public int delete(String u_id) {
		
		return sqlSession.delete("user.withdraw_account", u_id);
		
	}
	
}
