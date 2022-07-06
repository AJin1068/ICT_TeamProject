package action.seller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.product.ProductDao;
import dao.user.UserDao;
import vo.product.ProductVo;
import vo.user.UserVo;

/**
 * Servlet implementation class SellerPageAction
 */
@WebServlet("/sellerpage/list.do")
public class SellerPageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// parameter�� u_idx �޾ƿ;���
		int u_idx = 3;

		// ��ü��� ��������
		List<ProductVo> list = ProductDao.getinstance().selectList(u_idx);

		// ȸ�� ���� �޾ƿ���
		UserVo user_info = UserDao.getInstance().selectOneByIdxTime(u_idx);

		String[] p_time = new String[list.size()];

		for (int i = 0; i < list.size(); i++) {
			p_time[i] = list.get(i).getP_time();
			int p_tim = Integer.parseInt(p_time[i]);
			String p_ti = "1����";
			/* System.out.println(p_tim); */
			if (p_tim < 10) {
				p_ti = "�����";
			} else if (p_tim < 60) {
				p_ti = String.format("%d����", p_tim);
			} else if (p_tim < 3600) {
				p_ti = Integer.toString(p_tim / 60);
				p_ti = String.format("%s����", p_ti);
			} else if (p_tim < 86400) {
				p_ti = Integer.toString(p_tim / 3600);
				p_ti = String.format("%s�ð���", p_ti);
			} else if (p_tim < 86400 * 30) {
				p_ti = Integer.toString(p_tim / 86400);
				p_ti = String.format("%s����", p_ti);
			} else if (p_tim < 86400 * 365) {
				p_ti = Integer.toString(p_tim / 86400 * 30);
				p_ti = String.format("%s����", p_ti);
			} else if (p_tim >= 86400 * 365) {
				if (p_tim > 2000000000) {
					p_ti = "���ֿ�����";
				} else {
					p_ti = Integer.toString(p_tim / ((86400 * 30) * 12));
					p_ti = String.format("%s����", p_ti);
				}
			}

			list.get(i).setP_date(p_ti);

		}

		/* System.out.println(user_info.getU_nickname()); */
		
		
		//��¥ ���ϴ� �ڵ�
		String u_time = user_info.getU_time();
		
		int u_time_int = (Integer.parseInt(u_time)/84000);
		
		u_time = String.format("%d", u_time_int);
		
		
		
		user_info.setU_regdate(u_time);
		

		// �Ǹ����� list binding
		request.setAttribute("list", list);

		// u_idx�� �ش��ϴ� ȸ������ binding
		request.setAttribute("user_info", user_info);

		// forward
		String forward_page = "seller_page.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
