package dao.mypage;

import java.util.List;

import vo.product.ProductVo;

public interface MypageDao {
	
	//�Ǹ����� ��ǰ ���� �ҷ�����
	public List<ProductVo> selectlist(int u_idx);
	
	// �� ���� �����ϱ�
	public int user_update(int u_idx);
	
	// ȸ�� Ż���ϱ�
	public int withdraw_user(int u_idx);
}
