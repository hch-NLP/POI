package nudt.com;

import java.io.File;

public class ParseDirectory {

	public static void main(String[] args) {
		String path = "C:\\Users\\lenovo\\Desktop\\��װ���";		//Ҫ������·��
		File file = new File(path);		//��ȡ��file����
		File[] fs = file.listFiles();	//����path�µ��ļ���Ŀ¼������File������
		for(File f:fs){					//����File[]����
			if(!f.isDirectory())		//����Ŀ¼(���ļ�)�����ӡ
				System.out.println(f);
		}
	}

}
