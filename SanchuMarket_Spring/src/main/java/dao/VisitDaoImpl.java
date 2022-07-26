package dao;

import org.apache.ibatis.session.SqlSession;

import vo.VisitVo;

public class VisitDaoImpl implements VisitDao{

	SqlSession sqlSession;
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	//admin mainpage ���� �湮�ڼ� ���
	public int todayVisitCount() {
		
		return sqlSession.selectOne("visit.today_count");
	}
	
	//���� ù �湮�� ���� ��ȸ
	public VisitVo todayVisitSelect() {
		
		return sqlSession.selectOne("visit.today_visit");
	}

	//���� ù �湮���϶� �湮�� record insert
	public int todayVisitInsert() {
		
		return sqlSession.insert("visit.today_visitInsert");
	}
	
	//���ͼ��Ϳ��� ��Űvalue�� 1�� ��Ű�� ������ + ���� �湮�ڼ��� �����Ҷ�
	public int todayVisitUpdate(int count) {
		
		return sqlSession.update("visit.today_visitUpdate");
	}

	
	
	
}
