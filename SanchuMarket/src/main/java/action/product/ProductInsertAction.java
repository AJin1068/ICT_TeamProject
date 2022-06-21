package action.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductInsertAction
 */
@WebServlet("/product/insert.do")
public class ProductInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//1. request encoding �ϱ�
		request.setCharacterEncoding("utf-8");
		
		//2. parameter �ޱ�
		//����
		String p_name = request.getParameter("p_name");
		
		//ī�װ���ȣ
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));

		//��ǰ����
		String p_condition = request.getParameter("p_condition");
		
		
		
		//����		
		int p_price = Integer.parseInt(request.getParameter("p_price"));
		
		//��ǰ����
		String p_exp = request.getParameter("p_exp").replaceAll("\r\n", "<br>");
		
		
		
		

	}

}
