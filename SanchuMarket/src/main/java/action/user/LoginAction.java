package action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.user.UserDao;
import vo.user.UserVo;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/user/login.do")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//특수문자 들어와도 인코딩 해야함 

		String u_id = request.getParameter("u_id");
		String u_pwd = request.getParameter("u_pwd");
	
		UserVo user =  UserDao.getInstance().selectOneByIdPwd(u_id,u_pwd);
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user );
		
		//경로 지정 주의
		response.sendRedirect("../mainpage/list.do");
	}

}
