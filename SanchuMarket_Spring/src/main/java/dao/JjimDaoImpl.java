package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.JjimVo;

public class JjimDaoImpl implements JjimDao {

	SqlSession sqlSession;
	
	
	public JjimDaoImpl(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}
	
	//ȸ���� ���� ��ǰ ���� ��ȸ
	@Override
	public List<JjimVo> selectList(int u_idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("jjim.jjim_select",u_idx);
	}
	
	//ȸ���� �̻�ǰ�� ���ߴ���
	@Override
	public JjimVo selectOne(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("jjim.jjim_select_one", map);
	}
	
	// ���ϱ�
	@Override
	public int insert(JjimVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("jjim.jjim_insert",vo);
	}
	
	//�����
	@Override
	public int delete(JjimVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("jjim.jjim_delete", vo);
	}



}
