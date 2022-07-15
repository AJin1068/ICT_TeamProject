package controller;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.image.ImageDao;
import dao.product.ProductDao;
import util.MyFileUpload;
import vo.image.ImageVo;
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
		
		
		return "product/product_insert";
	}
	
	// ����Ʈ Ÿ������ ����
	//�������� �ȿ� �Ѳ����� ���� �����Ͱ� ���⶧���� �� �Ķ���ͷ� ����..
	@ResponseBody
	@RequestMapping(value = "product_insert.do", method = RequestMethod.POST)
	public Map product_insert(
	@RequestParam(value="imagedata") MultipartFile [] imagedata, 
	int u_idx, String p_name, int c_idx, String p_location, String p_condition, int p_price, String p_exp) {
		
		//�Ķ���ͷ� ���� ProductVo �����ڸ����� ����
		String p_status = "�ŷ�����";
		
		//								 ��������,ī�װ�,��ǳ��, ����,  ��ǰ����,  ��ǰ����, �ŷ�����, Ŭ����, �Ǹſ���
		ProductVo productVo = new ProductVo(u_idx, c_idx, p_name, p_price, p_condition, p_exp, p_location,0,p_status);
		
		//ProductDB�� Data �ֱ�
		//���� DB�� �ִ� ������ p_idx�� ���ϱ� ���ؼ�
		int res1 = product_dao.insert(productVo);
		int p_idx = product_dao.selectMaxIdx();
		
		System.out.println(p_idx);
		
		int res2 = 0;
		
		//������ ����
		String abs_path = applicaton.getRealPath("/resources/imgdata/");
		
		//for each�� ��� �迭�� ���� �̹��������� ����
		for(MultipartFile img : imagedata) {
			
			//���Ͼ��ε� �޼��� ���
			String img_str = MyFileUpload.myFileUpload(abs_path, img);
			
			//�̹��� Vo ����
			ImageVo imageVo = new ImageVo();
			
			//�̹���Vo�� �̹��� ���ϸ� �ֱ�
			imageVo.setImagedata(img_str);
			imageVo.setP_idx(p_idx);
			//���� DB�� �ֱ�
			res2 = image_dao.insert(imageVo);
			
		}
		
		//JsonConverter ����ϱ� ���� Map����
		Map map = new HashMap();

		//�⺻ ���ϰ� false
		boolean bResult = false;
		
		//���� ��ǰ��ϰ� �̹�������� ������..
		if(res1==1 && res2==1) {
			
			//���ϰ� true �� ����
			bResult = true;
			
		}
		//�ʿ� result�� �ֱ�
		map.put("res", bResult);
		
		return map;
	}
	
	@RequestMapping("product_modify_form.do")
	public String product_modify_form(int p_idx, Model model){
		
		ProductVo vo = product_dao.
		
		
		
		return "product_modify_form";
	}
	
}
