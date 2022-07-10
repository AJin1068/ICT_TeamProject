package controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.product.ProductDao;
import vo.product.ProductVo;

@Controller
@RequestMapping("/product/")
public class ProductController {
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	ServletContext applicaton;
	
	ProductDao product_dao;

	public ProductController(ProductDao product_dao) {
		super();
		this.product_dao = product_dao;
	}
	
	//���߿� ��Ű������ ��ǰ������ �������� ���鵵�� ���� �ҿ���
	@RequestMapping("insert_form.do")
	public String insert_form(
			@RequestParam(value ="p_idx",required = false, defaultValue="null") String p_idx,
			@RequestParam(value ="p_name",required = false, defaultValue="null")String p_name
			) throws Exception {
		
		//���� ���� �Ķ���� ���� null�� �ƴϸ�
		if(!p_idx.equals("null")) {
			
			
			//��Ű ���� key = p_idx , value = p_name
			//�ѱ�(�����ڵ幮��)�� ��Ű�� ���� ���ϱ� ������ URLEncoder ���
			Cookie cookie = new Cookie(p_idx, URLEncoder.encode(p_name, "utf-8"));
			
			
			//��Ű�� ������ ����� ������ο����� ��Ű�� ���� ����
			cookie.setPath("/sanchumarket/");
			
			
			//��Ű����
			response.addCookie(cookie);
			
		}
		
		
		return "product/insert";
	}
	
	// ����Ʈ Ÿ������ ����
	//�������� �ȿ� �Ѳ����� ���� �����Ͱ� ���⶧���� �� �Ķ���ͷ� ����..
	@ResponseBody
	@RequestMapping(value = "product_insert.do", method = RequestMethod.POST)
	public Map product_insert(MultipartFile sumimage,
							  MultipartFile imageFile1, MultipartFile imageFile2,
							  MultipartFile imageFile3, MultipartFile imageFile4,
							  MultipartFile imageFile5, int u_idx, String p_name,
							  int c_idx, String p_location, String p_condition,
							  int p_price, String p_exp) {
		
		String path = applicaton.getRealPath("/resources/imgdata/");
		
		String p_status = "�ŷ�����";
		
		
		return null;
	}
	
	
	
}
