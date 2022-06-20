package dao.product;

import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;

public class ProductDao123 {
	
	
	SqlSessionFactory factory;
	
	//single-ton : ��ü 1���� �����ؼ� �������!
	//����ƽ��ü�� ������ �ϳ��� ���������.
	static ProductDao123 single = null;

	//����ƽ�� ������ ����ƽ���θ�
	public static ProductDao123 getInstance() {

		//��ü�� ������ �����ض� ȣ��� �ѹ��� ��ü�� ����
		if (single == null)
			single = new ProductDao123();

		return single;
	}

	//�ܺο��� ��ü�� �������� ���ϰ� ����
	private ProductDao123() {
		// TODO Auto-generated constructor stub
		
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
		
		
	}
	
	
	
}
