package dao.mypage;

import java.util.List;

import vo.product.ProductVo;
import vo.user.UserVo;

public interface MypageDao {
	
	// �� ���� �����ϱ�
	public int user_update(UserVo vo);
	
	// ȸ�� Ż���ϱ�
	public int withdraw_user(int u_idx);
	
	//u_idx �� ����Ʈ
	public List<ProductVo> selectList(int u_idx);
	
}
