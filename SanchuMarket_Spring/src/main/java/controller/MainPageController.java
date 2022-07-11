package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.product.ProductDao;
import util.Mytime;
import vo.product.ProductVo;

@Controller
@RequestMapping("/mainpage/")
public class MainPageController {
	


	@Autowired 
	 ServletContext application;
	  
	 @Autowired 
	 HttpSession session;
		  
	 @Autowired 
	 HttpServletRequest request;
	 
	 ProductDao product_dao;

	 public MainPageController(ProductDao product_dao) {
		 super();
		 this.product_dao = product_dao;
	 }
	
	 @RequestMapping("list.do")
	 public String list(Model model,  @RequestParam(value="c_idx",required = false ,defaultValue="null")String 	c_idx
			 				 , @RequestParam(value="searchtext", required = false , defaultValue="all") String searchtext) {
		 
		 System.out.println(c_idx);
		// ,
		//		
		 
			
			// ��ü��� ��������
			
		 	if( c_idx.equals("null") ) {
		 		
		 		List<ProductVo> list = product_dao.selectList();
		 		
		 		// �ð���� �޼ҵ�ȭ
		 		Mytime.time_cal(list);
		 		
		 		
		 		
		 		model.addAttribute("list", list);
		 	}

			
			// ī�װ���� ��������
			if (!c_idx.equals("null")) {

				List<ProductVo> list = product_dao.selectList_cate(Integer.parseInt(c_idx));
				// �ð���� �޼ҵ�ȭ
				Mytime.time_cal(list);

				model.addAttribute("list", list);

			}
//			
//			
//			//�˻�
			//���ڿ��� ���� ����  .equals�� ����.
			if (!searchtext.equals("all")) {

				Map map = new HashMap();
				map.put("p_name", searchtext);
				map.put("p_exp", searchtext);

				List<ProductVo> list = product_dao.selectList(map);

				// �ð���� �޼ҵ�ȭ
				Mytime.time_cal(list);

				model.addAttribute("list", list);

			}
			
//			//��Ű �����ϱ�(admin������ �湮�ڼ� ����)
//			int cnt = 0;
//			cnt++;
//			
//			//��Ű ��ü �����ø��� value ����
//			Cookie cookie = new Cookie("cookie_cnt", cnt+"");
//			
//			//��Ű ��ȿ�ð� �Ϸ�� ����
//			cookie.setMaxAge(24*60*60);
//			
//			//��Ű ��ȿ ������ �������� ����
//			cookie.setPath("/");
//			response.addCookie(cookie);

			
			
			// session�޾Ƽ� ó�����ּ���

			
//			  UserVo user = (UserVo) request.getSession().getAttribute("user");
//			  
//				/*
//				 * if(session.getAttribute("user")==null) {
//				 * 
//				 * }else {
//				 * 
//				 * }
//				 */	 
//			System.out.println(user);

		 
		 
		 //String visitCookie = "";
		// String visitCookieCnt = "";
		 
		 //admin ���� �湮�� cookie����
		 //Cookie cookie = new Cookie("visitCookie", "visitCookieCnt");
		
		return "mainpage/mainpage_list";
	 }	
	 
}
