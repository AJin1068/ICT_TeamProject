package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.UserVo;

public class UserDao {

	SqlSessionFactory factory;
	//single-ton : ��ü 1���� �����ؼ� �������!
	//����ƽ��ü�� ������ �ϳ��� ���������.
	static UserDao single = null;

	//����ƽ�� ������ ����ƽ���θ�
	public static UserDao getInstance() {

		//��ü�� ������ �����ض� ȣ��� �ѹ��� ��ü�� ����
		if (single == null)
			single = new UserDao();

		return single;
	}

	//�ܺο��� ��ü�� �������� ���ϰ� ����
	private UserDao() {
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//������ ��ȸ
	public List<UserVo> selectList(){
		
		List<UserVo> list = null;
		
		SqlSession sqlsession = factory.openSession();
		
		list = sqlsession.selectList("user.user_list");
		
		sqlsession.close();
		
		return list;
	}
	
	public UserVo selectOneByIdx(int u_idx){
		
		UserVo user = null;
		
		SqlSession sqlsession = factory.openSession();
		
		user = sqlsession.selectOne("user.user_idx", u_idx);
		
		sqlsession.close();
		
		return user;
	}
	
	//ȸ�����Խ� ���� ���� ��ȸ(ajax)
	public UserVo selectOneById(String u_id){
		
		UserVo user = null;
		
		SqlSession sqlsession = factory.openSession();
		
		user = sqlsession.selectOne("user.check_id", u_id);
		
		sqlsession.close();
		
		return user;
	}
	
	public UserVo selectOneByNickname(String u_nickname){
		
		UserVo user = null;
		
		SqlSession sqlsession = factory.openSession();
		
		user = sqlsession.selectOne("user.check_nickname", u_nickname);
		
		sqlsession.close();
		
		return user;
	}
	
	public int insert(UserVo vo) {
		
		int res = 0;
		
		SqlSession sqlsession = factory.openSession();

		res = sqlsession.selectOne("user.user_insert", vo);
		
		sqlsession.close();
		
		return res;
	}

	public int update(UserVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		//1.SqlSession���
		SqlSession sqlSession = factory.openSession(true);//auto commit
		
		//2.����
		res = sqlSession.update("user.user_update",vo);
		//3.�ݱ�
		sqlSession.close();
		
		return res;
	}

	public List<UserVo> selectList(int u_idx) {
		// TODO Auto-generated method stub
		List<UserVo>list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("product.product_user_list",u_idx);
		
		sqlSession.close();
		

		return list;
	}
		
	
	
}
