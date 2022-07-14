package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.MailService;

@Controller
public class EmailController {

	@Autowired
	MailService mailService;


	//DB�۾��� �ʿ��� ��ŭ DAO�� �����ؾ���
	
	//���̵�� �̸����� ������ Ư���� ������ ����..
	@RequestMapping("/noticeMail.do")
	public String sendEmail(String id, String email, Model model) {
		
		String addr = "dkwlsdl8@google.com";
		
		String subject = "��й�ȣ ã�� ����";
		
		String body = "";
		
		mailService.sendEmail(email, addr, subject, body);
		
		return "";
	}
}
