package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	 
	@Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	            throws Exception {
		 	
		//�α��� ���� ����
		//session�� false : session�� �������� �ʴ´ٸ� null��ȯ(��ȸ���� session���Ե��� �ʰ�)
	 	HttpSession session = request.getSession(false);
	 	
	 	if (session != null) {
	 		
            Object obj = session.getAttribute("user"); // ���ǿ� �ִ� user �Ӽ����� �����´�.
            if (obj != null) return true; // ���ǿ� user �Ӽ����� �ִٸ� true�� ������ ��Ʈ�ѷ��� ������ ���� ����.
        }
        // ������� �����Դٸ� ���ǿ� user �Ӽ����� ���ٴ� ���̹Ƿ� �α��� ȭ������ �����̷�Ʈ !
        response.sendRedirect(request.getContextPath() + "/login");
        return false;
		 	
	        
	    }

}
