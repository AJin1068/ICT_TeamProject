package util;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import dao.VisitDao;
import vo.VisitVo;

public class VisitCookie {
	

	public static Cookie getVisitCookie(HttpServletRequest request, HttpServletResponse response, VisitDao visit_dao) {

		
	//--------------------1.cookie�Ҵ�--------------------------
	Cookie [] cookieArr = request.getCookies();
	Cookie visitCookie = null;
	int cookieCnt;
	String cookieStr;
	
	//Ư�� ������ ���������� ���޵� ��� ��Ű�� Ȯ���ϰ�
	if(cookieArr != null) {
		for(int i=0; i < cookieArr.length; i++) {
			//�� �� �湮�ڼ� ��Ű�� ���⿡�� visitCookie�� �ִ´�.
			if(cookieArr[i].getName().equals("visitCookie")) {
				
				visitCookie = cookieArr[i];
				break;
			}
		}
	}
	
	//�� ���� ����Ͽ� Ŭ���̾�Ʈ�� visitCookie�� ���� �ִٸ� ���� cookie�� value����
	if(visitCookie != null) {
		cookieCnt = Integer.parseInt(visitCookie.getValue());
		cookieCnt++;
		cookieStr = Integer.toString(cookieCnt);
		visitCookie.setValue(cookieStr);
	}
	//visitCookie���ٸ� ���� ����
	else {
		visitCookie = new Cookie("visitCookie","1");
	}

	
	return visitCookie;

	}
	
}
