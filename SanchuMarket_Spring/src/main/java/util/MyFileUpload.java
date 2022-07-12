package util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class MyFileUpload {
	
	public static String myFileUpload(String abs_path, MultipartFile file) {
		
		
		//������ ����ִٸ�
		if(file.isEmpty()) {
			
			return "no_file";
		}
		
		System.out.println("���Ͼ��ε� if��������� ");
		
		//���� ���� �̸� �޾ƿ���
		String image_str = file.getOriginalFilename();
		
		File f = new File(abs_path, image_str);
		
		//�������ϸ��� �����ϸ� �̸��ٲٱ�(�ð�_�������ϸ�)
		if(f.exists()) {
			
			long time = System.currentTimeMillis();
			
			image_str = String.format("%d_%s",time, image_str);
			
			f = new File(abs_path, image_str);
		}
		
		try {
			file.transferTo(f);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return image_str;
	}
	
}
