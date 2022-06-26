package dao.image;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.image.ImageVo;

public class ImageDao {

	
	SqlSessionFactory factory;
	
	//single-ton : ��ü 1���� �����ؼ� �������!
	//����ƽ��ü�� ������ �ϳ��� ���������.
	static ImageDao single = null;

	//����ƽ�� ������ ����ƽ���θ�
	public static ImageDao getInstance() {

		//��ü�� ������ �����ض� ȣ��� �ѹ��� ��ü�� ����
		if (single == null)
			single = new ImageDao();

		return single;
	}

	//�ܺο��� ��ü�� �������� ���ϰ� ����
	private ImageDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
		
	}

	public int insert(ImageVo vo) {
		// TODO Auto-generated method stub
		
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		
		res = sqlSession.insert("image.image_insert",vo);
		
		
		sqlSession.close();
		
		
		return res;
	}
	
	
	
	
}
