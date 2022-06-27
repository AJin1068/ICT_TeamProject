package dao.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.product.ProductVo;

public class ProductDao {

	SqlSessionFactory factory;

	// single-ton : ��ü 1���� �����ؼ� ���
	static ProductDao single = null;

	public static ProductDao getinstance() {

		// ��ü�� null�̸� �����ض�
		if (single == null)
			single = new ProductDao();

		return single;
	}

	// �ܺο��� �������� �� ��
	private ProductDao() {
		// TODO Auto-generated constructor stub

		factory = MyBatisConnector.getInstance().getSqlSessionFactory();

	}

	public List<ProductVo> selectList() {

		List<ProductVo> list = null;

		// 1.SqlSession������
		SqlSession sqlSession = factory.openSession();


		// 3.�ݱ�
		sqlSession.close();

		return list;
	}

	// ��ǰ��� �޼���
	public int insert(ProductVo vo) {
		// TODO Auto-generated method stub
		
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.insert("product.product_insert",vo);
		
		
		sqlSession.close();
		
		return res;
	}
	
	//��ǰ 1�� ��ȸ �޼���
	public ProductVo selectOne(int p_idx) {
		// TODO Auto-generated method stub
		
		ProductVo vo = null;
		
		SqlSession sqlSession = factory.openSession();
		
		vo = sqlSession.selectOne("product.product_selectOne", p_idx);
		
		//connection �ݱ�
		sqlSession.close();
		
		return vo;
	}
	
	
	
	
}
