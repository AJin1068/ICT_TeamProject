package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.ProductDao;
import dao.TradeDao;
import vo.ProductVo;

@Controller
@RequestMapping("/product/")
public class TradeController {

	 @Autowired 
	 ServletContext application;
	  
	 @Autowired 
	 HttpSession session;
		  
	 @Autowired 
	 HttpServletRequest request;
	 
	 TradeDao trade_dao;
	 ProductDao product_dao;


	public TradeController(TradeDao trade_dao, ProductDao product_dao) {
		super();
		this.trade_dao = trade_dao;
		this.product_dao = product_dao;
	}


	@RequestMapping("trade.do")
	@ResponseBody
	public Map tradeStart(
			int seller_u_idx,
			int	buyer_u_idx,	
			int p_idx) {
		
		
//		System.out.println(seller_u_idx);
//		System.out.println(buyer_u_idx);
//		System.out.println(p_idx);

		
		//p_idx�� �ش� ��ǰ p_status '�ŷ���'���� �����ϱ�
		Map updateMap = new HashMap();
		
		updateMap.put("p_idx", p_idx);
		updateMap.put("p_status", "�ŷ���");
		
		 int res = product_dao.statusUpdate(updateMap);
		
		/*
			�޾ƿ� u_idx��� �Ǹ���, ������ id ������ ����
			�ŷ� ���̺� �ֱ�(��ǰ�����߰�����)
		 */
		
		
		
		
		
		
		
		return null;
	}
	 
	 
}
