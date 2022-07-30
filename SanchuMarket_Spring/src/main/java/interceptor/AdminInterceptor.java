package interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import vo.UserVo;

public class AdminInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminInterceptor.class);
	 
	@Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	            throws Exception {
		 	
			UserVo user = (UserVo) request.getSession().getAttribute("user");

			if ((user == null)) {
				response.sendRedirect("../user/login_form.do?reason=fail");
				return false;
			}
			
			//��û�� �Ķ���� �о����
			String uri = request.getRequestURI();
			
			//���������� ���ٽ�
			if(uri.contains("admin")) {
				
				// ȸ�� ��� �˾ƿ���
				String u_grade = (String) user.getU_grade();
				
				// �����ڰ� �ƴҶ�
				if (!u_grade.equals("������")) {
					
					response.sendRedirect("../mainpage/list.do?reason=fail");
					
				}
				
			}else if(uri.contains("mypage")) {
				
				// ���ǿ��� �޾ƿ� u_idx
				int u_idx = user.getU_idx();
				
				// �Ķ���Ϳ� �Էµ� u_idx
				int param_u_idx = Integer.parseInt(request.getParameter("u_idx"));
				
				//ȸ���� �ٸ�ȸ���� ������ �����Ϸ� �Ҷ�!
				if(u_idx!=param_u_idx) {
					response.sendRedirect("../mainpage/list.do?reason=fail");
				}
				
				
			}
			

			return super.preHandle(request, response, handler);
		}

}
