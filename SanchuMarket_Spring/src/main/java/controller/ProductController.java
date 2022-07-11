package controller;

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

import dao.image.ImageDao;
import dao.product.ProductDao;
import util.MyFileUpload;
import vo.image.ImageVo;

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
	ImageDao image_dao;

	public ProductController(ProductDao product_dao, ImageDao image_dao) {
		super();
		this.product_dao = product_dao;
		this.image_dao = image_dao;
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
	public Map product_insert( MultipartFile sumimage,
	@RequestParam(value="imageFile1", required = false, defaultValue = "no_file") MultipartFile imageFile1, 
	@RequestParam(value="imageFile2", required = false, defaultValue = "no_file") MultipartFile imageFile2,
	@RequestParam(value="imageFile3", required = false, defaultValue = "no_file") MultipartFile imageFile3,
	@RequestParam(value="imageFile4", required = false, defaultValue = "no_file") MultipartFile imageFile4,
	@RequestParam(value="imageFile5", required = false, defaultValue = "no_file") MultipartFile imageFile5,
	int u_idx, String p_name, int c_idx, String p_location, String p_condition, int p_price, String p_exp) {
		
		String abs_path = applicaton.getRealPath("/resources/imgdata/");
		
		String sumimage_str = MyFileUpload.myFileUpload(abs_path, sumimage);
		String imageFile1_str = MyFileUpload.myFileUpload(abs_path, imageFile1);
		String imageFile2_str = MyFileUpload.myFileUpload(abs_path, imageFile2);
		String imageFile3_str = MyFileUpload.myFileUpload(abs_path, imageFile3);
		String imageFile4_str = MyFileUpload.myFileUpload(abs_path, imageFile4);
		String imageFile5_str = MyFileUpload.myFileUpload(abs_path, imageFile5);
		
		ImageVo imageVo = new ImageVo(sumimage_str, imageFile1_str, imageFile2_str, imageFile3_str, imageFile4_str, imageFile5_str);
		
		
		int res = image_dao.insert(imageVo);
		
		
		String p_status = "�ŷ�����";
		
		
		return null;
	}
	
	
	
}
