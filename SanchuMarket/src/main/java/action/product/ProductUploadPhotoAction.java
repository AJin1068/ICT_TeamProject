package action.product;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class ProductUploadPhotoAction
 */
@WebServlet("/product_insert/photo_upload.do")
public class ProductUploadPhotoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//1. ������ ���� (������)
				String path = request.getServletContext().getRealPath("/upload/");
				
				//2. ���ε� �ִ�뷮
				int max_size = 1024 * 1024 * 100;
				
				//3.���ε� fileó��						  ����ó�� ������ġ �ִ�ũ�� ���ڵ�	    �������� -> �̸�����������
				MultipartRequest mr = new MultipartRequest(request,  path,  max_size, "utf-8", new DefaultFileRenamePolicy());
				
				//4.parameter �ޱ�
				int p_idx = Integer.parseInt(mr.getParameter("p_idx"));
				
				//�������� ����
//				PhotoVo originVo = PhotoDao.getInstance().selectListOne(p_idx);
//				File deleteFile = new File(path, originVo.getP_filename());
//				deleteFile.delete();
				
				//5.���ε������̸� ������
				String p_filename = mr.getOriginalFileName("photo");
				if(p_filename == null) p_filename = "no_file";
				
				
				//6.DB update_filename
//				PhotoVo vo = new PhotoVo();
//				vo.setP_idx(p_idx);
//				vo.setP_filename(p_filename);
//				
//				int res = PhotoDao.getInstance().update_filename(vo);
				
				//��� ���� : JSON = {"p_filename" : "b.jpg"};
				JSONObject json = new JSONObject();
				json.put("p_filename", p_filename);
				
				String json_str = json.toJSONString();
				
				response.setContentType("text/json; charset=utf-8;");
				
				response.getWriter().print(json_str);
				

		
		
	}

}
