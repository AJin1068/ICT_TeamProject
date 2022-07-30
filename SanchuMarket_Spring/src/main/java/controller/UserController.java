package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.UserDao;
import vo.UserVo;

@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	ServletContext application;

	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;

	UserDao user_dao;

	public void setUser_dao(UserDao user_dao) {
		this.user_dao = user_dao;
	}

	@RequestMapping("check_email.do")
	@ResponseBody
	public Map checkEmail(String u_mail) {

		UserVo vo = user_dao.selectOneByEmail(u_mail);

		String result = "";

		// ���̵� �������� ������ ���� ����
		if (vo == null) {
			result = "Y";
		} else {
			result = "N";
		}

		Map map = new HashMap();

		map.put("result", result);

		return map;
	}

	@RequestMapping("check_id.do")
	@ResponseBody
	public Map checkId(String u_id) {

		UserVo vo = user_dao.selectOneById(u_id);

		String result = "";

		// ���̵� �������� ������ ���� ����
		if (vo == null) {
			result = "Y";
		} else {
			result = "N";
		}

		Map map = new HashMap();

		map.put("result", result);

		return map;
	}

	@RequestMapping("check_nickname.do")
	@ResponseBody
	public Map checkNickname(String u_nickname) {

		UserVo vo = user_dao.selectOneByNickname(u_nickname);

		String result = "";

		// �г��� �������� ������ ���� ����
		if (vo == null) {
			result = "Y";
		} else {
			result = "N";
		}

		Map map = new HashMap();

		map.put("result", result);

		return map;
	}

	@RequestMapping("enroll.do")
	public String enroll(String detail, String address, UserVo vo, Model model) {

		String u_ip = request.getRemoteAddr();

		// u_addr = �⺻ �ּ� + �� �ּ�
		StringBuilder sb = new StringBuilder();
		sb.append(address).append(" ").append(detail);
		String u_addr = sb.toString();

		vo.setU_ip(u_ip);
		vo.setU_addr(u_addr);

		int res = user_dao.insert(vo);

		if (res == 0) {
			model.addAttribute("reason", "failed_enroll");
			return "user/enroll_form.do";
		}

		return "redirect:../mainpage/list.do";
	}

	@RequestMapping("enroll_form.do")
	public String enrollForm() {

		return "user/enroll_form";
	}

	@RequestMapping("login.do")
	@ResponseBody
	public Map login(UserVo vo) {

		String u_id = vo.getU_id();
		String u_pwd = vo.getU_pwd();

		UserVo userVo = user_dao.selectOneById(u_id);

		String result = "";

		//�α��� ���� ��ȸ ����
		if (userVo == null || !u_pwd.equals(userVo.getU_pwd())) {
			System.out.println("����̳� ���̵� Ʋ��");
			result = "login_failed";
		} 
		//�Ϲ�ȸ��
		else if(userVo.getU_grade().equals("�Ϲ�ȸ��")){
			System.out.println("�Ϲ�ȸ��");
			HttpSession session = request.getSession();
			session.setAttribute("user", userVo);
			result = "user";
		}
		//������
		else if(userVo.getU_grade().equals("������")){
			System.out.println("������");
			HttpSession session = request.getSession();
			session.setAttribute("user", userVo);
			result = "admin";
		}
		

			Map map = new HashMap();

			map.put("result", result);


		return map;
	}

	@RequestMapping("login_form.do")
	public String loginForm() {

		return "user/login_form";
	}

	// ���̵� ã��
	@RequestMapping("findId.do")
	@ResponseBody
	public String findId(@RequestParam("name") String u_name, @RequestParam("phone") String u_tel) {
		
		
		UserVo vo = new UserVo();
		vo.setU_name(u_name);
		vo.setU_tel(u_tel);

		List<String> idList = user_dao.selectIdByNameTel(vo);
		// Map map = new HashMap();

		JSONArray jsonArr = new JSONArray();
		JSONObject json = new JSONObject();

		if (idList.size() >= 1) {

			for (int i = 0; i < idList.size(); i++) {
				// ���Խ� ����ŷ
				String id = idList.get(i).replaceAll("(?<=.{5}).", "*");

				jsonArr.add(id);
			}

			json.put("id", jsonArr);
		} else {
			json.put("id", "noExist");
		}

		return json.toJSONString();
	}

	// ��й�ȣã��
	@RequestMapping("count_emailId.do")
	@ResponseBody
	public Map countEmailId(@RequestParam("id") String u_id, @RequestParam("email") String u_email) {

		UserVo vo = new UserVo();
		vo.setU_id(u_id);
		vo.setU_mail(u_email);

		int count = user_dao.countForFindPwd(vo);

		Map map = new HashMap();

		if (count == 0) {
			map.put("result", "noExist");
			return map;
		} else {
			map.put("result", "exist");
		}

		return map;
	}

}
