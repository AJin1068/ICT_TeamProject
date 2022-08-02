package dao;

import java.util.List;
import java.util.Map;

import vo.UserVo;

public interface UserDao {

	
	//������ ��ü ȸ�� ��ȸ
	public List<UserVo> selectList();
		
	
	public List<UserVo> selectList(int u_idx);

	
	public UserVo selectOneByIdx(int u_idx);
		
		
	// �Ǹ��� ������ ������ ������ ���������
	public UserVo selectOneByIdxTime(int u_idx);
		
	
	//ȸ�����Խ� ���̵� �ߺ� ����, �α���
	public UserVo selectOneById(String u_id);
		
	
	//ȸ�����Խ� �г��� �ߺ� ����
	public UserVo selectOneByNickname(String u_nickname);
		
	
	//ȸ�����Խ� �̸��� �ߺ� ����
	public UserVo selectOneByEmail(String email);
	
	//��й�ȣ ã��� ���̵�,�̸��� ���� ����
	public int countForFindPwd(UserVo vo);
	
		
	public int insert(UserVo vo);
		

	public int update(UserVo vo);

	
	public int delete(String u_id);


	public int updatePwd(UserVo vo);


	public List<String> selectIdByNameTel(UserVo vo);


	public UserVo selectOneByPwd(Map check);


	public int updateStatus(Map updateMap);


	public int insertWithdrawl(int u_idx);
	
	
	

	
	
}
