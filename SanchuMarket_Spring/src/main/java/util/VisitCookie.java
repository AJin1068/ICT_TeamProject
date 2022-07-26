package util;

import java.net.http.HttpRequest;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;

import dao.VisitDao;
import vo.VisitVo;

public class VisitCookie {
	
	@Autowired
	HttpRequest request;
	
	VisitDao visit_dao;
	
	public void setVisit_dao(VisitDao visit_dao) {
		this.visit_dao = visit_dao;
	}
	
	public static Cookie getVisitCookie() {

	//--------------------1.cookie�Ҵ�--------------------------
	Cookie [] visitCookieArr = request.getCookies();
	Cookie visitCookie = null;
	int cookieCnt;
	String cookieStr;
	
	//Ư�� ������ ���������� ���޵� ��� ��Ű�� Ȯ���ϰ�
	if(visitCookieArr != null) {
		for(int i=0; i < visitCookieArr.length; i++) {
			//�� �� �湮�ڼ� ��Ű�� ���⿡�� visitCookie�� �ִ´�.
			if(visitCookieArr[i].getName().equals("visitCookie")) {
				
				visitCookie = visitCookieArr[i];
				break;
			}
		}
	}
	
	//�� Ŭ���̾�Ʈ�� visitCookie�� ���� �ִٸ� ���� cookie�� value����
	if(visitCookie != null) {
		cookieCnt = Integer.parseInt(visitCookie.getValue());
		cookieCnt++;
		cookieStr = Integer.toString(cookieCnt);
		visitCookie.setValue(cookieStr);
	}
	
	//visitCookie�� ���ٸ� ���ο� visitCookie �Ҵ�	
	else {
		visitCookie = new Cookie("visitCookie","1");
	}
	
	//��Ű �Ҵ�
	response.addCookie(visitCookie);
	
	//-----------------2.cookie�� ������� visitDB ����----------------------
	
	//DB�� ���� �湮�� ���� ��ȸ
	VisitVo visitVo = visit_dao.todayVisitSelect();
	
	//DB�� ���� �湮�ڰ� 0�̸� �湮�ڼ� default 1�� visitDB record����
	if(visitVo == null) {
		
		visit_dao.todayVisitInsert();
	}
	//���� �湮�ڰ� 1�� �̻��̸� visitDB update
	else {
		
		if(Integer.parseInt(visitCookie.getValue()) == 1) {
			
			int todayVisitCount = visitVo.getV_count();
			
			int res = visit_dao.todayVisitUpdate(++todayVisitCount);
		}
	}
	
	}
	
}
