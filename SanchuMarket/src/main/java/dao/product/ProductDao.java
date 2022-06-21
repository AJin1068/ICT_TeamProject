package dao.product;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.product.ProductVo;

public class ProductDao {
	
	
	SqlSessionFactory factory;
	
	//single-ton : ��ü 1���� �����ؼ� ���
	static ProductDao single = null;

	public static ProductDao getinstance() {

		//��ü�� null�̸� �����ض�
		if (single == null)
			single = new ProductDao();

		return single;
	}

	//�ܺο��� �������� �� ��
	private ProductDao() {
		// TODO Auto-generated constructor stub
		
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();

	}
	
	public List<ProductVo> selectList() {
		

		List<ProductVo> list = null;

		
		return list;
	}

}
