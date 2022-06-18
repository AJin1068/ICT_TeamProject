package dao;

public class UserDao {

	//single-ton : ��ü 1���� �����ؼ� �������!
	//����ƽ��ü�� ������ �ϳ��� ���������.
	static UserDao single = null;

	//����ƽ�� ������ ����ƽ���θ�
	public static UserDao getInstance() {

		//��ü�� ������ �����ض� ȣ��� �ѹ��� ��ü�� ����
		if (single == null)
			single = new UserDao();

		return single;
	}

	//�ܺο��� ��ü�� �������� ���ϰ� ����
	private UserDao() {
		// TODO Auto-generated constructor stub
	}
	
}
