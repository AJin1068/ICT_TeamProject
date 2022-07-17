package dao.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.product.ProductVo;

public class ProductDaoImpl implements ProductDao {

	SqlSession sqlSession;
	
	
	public ProductDaoImpl(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	//��ǰ ��ü��ȸ
	@Override
	public List<ProductVo> selectList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product.product_list");
	}

	// ī�װ��� ��ȸ 
	@Override
	public List<ProductVo> selectList_cate(int c_idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product.product_c_idx", c_idx);
	}

	//ȸ��
	@Override
	public List<ProductVo> selectList(int u_idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product.product_user_idx",u_idx);
	}

	//��ǰ �ϳ� ��ȸ
	@Override
	public ProductVo selectList2(int p_idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("product.product_p_idx",p_idx);
	}
	
	//��ǰ������ ��ǰ�̹��� �ϳ��� ��������
	@Override
	public ProductVo selectListproduct(int p_idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("product.product_p_idx_one",p_idx);
	}
	
	
	//�ֱ� ��ǰ ���ε� �Խù� 6�� ��ȸ
	@Override
	public List<ProductVo> selectRecentList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product.recent_product");
	}

	//admin mainpage���� ��ǰ ���ε差
	@Override
	public int todayProductCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("product.today_count");
	}

	//��ǰ ���
	@Override
	public int insert(ProductVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("product.product_insert",vo);
	}


	// ��ǰ �˻� ���
	@Override
	public List<ProductVo> selectList(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product.product_list_search",map);
	}
	
	// ���� ���� ��ǰ�� �˻�
	@Override
	public List<ProductVo> select_price_text_search(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product.product_price_text_search",map);
	}
	
	// ���� �����˻�
	@Override
	public List<ProductVo> select_price_search(Map map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product.product_price_search",map);
	}
	
	
	//��ǰ��Ͻ� p_idx �˾Ƴ��� ���� �޼���
	@Override
	public int selectMaxIdx() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("product.product_max_idx");
	}





	

	

	



	
	
	
}
