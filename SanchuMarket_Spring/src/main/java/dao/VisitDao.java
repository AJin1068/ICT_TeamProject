package dao;

import vo.VisitVo;

public interface VisitDao {
	
		
		//ù �湮�� ���� ��ȸ
		VisitVo todayVisitSelect();
		int todayVisitInsert();
		int todayVisitUpdate(int count);

}
