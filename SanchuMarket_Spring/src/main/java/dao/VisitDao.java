package dao;

import vo.VisitVo;

public interface VisitDao {
	
		//admin mainpage ���� �湮�ڼ�
		int todayVisitCount();
		
		//ù �湮�� ���� ��ȸ
		VisitVo todayVisitSelect();
		int todayVisitInsert();
		int todayVisitUpdate(int count);

}
