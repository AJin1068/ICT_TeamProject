package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import vo.UserVo;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/login.do")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//Ư������ ���͵� ���ڵ� �ؾ��� 

		String m_id = request.getParameter("m_id");
		String m_pwd = request.getParameter("m_pwd");
		
		UserVo user = null;
		
		//session tracking 1.
		if(user==null) {
			
			response.sendRedirect("login_form.do?reason=fail_id");
			return;
		}
		
		//session tracking 2.
		//dao�� ������ user������ vo���̹Ƿ� getter��
		if(user.getU_pwd().equals(m_pwd)==false){
			
		  //����� Ʋ������ id�� �α���â�� ����� ���� parameter�γѰ���
			response.sendRedirect("login_form.do?reason=fail_pwd&m_id="+m_id);
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user );
		
		//��� ���� ����
		response.sendRedirect("../photo/list.do");
	}

}
