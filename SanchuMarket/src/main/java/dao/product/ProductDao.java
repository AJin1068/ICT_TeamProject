package dao.product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.jdi.connect.spi.Connection;


import vo.product.ProductVo;

public class ProductDao {
	
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

	}
	
	public List<ProductVo> selectList() {
		

		List<ProductVo> list = null;

		
		return list;
	}

}
