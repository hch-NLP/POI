package nudt.com;

import java.io.File;

public class ParseDirectory {

	public static void main(String[] args) {
		String path = "C:\\Users\\lenovo\\Desktop\\安装软件";		//要遍历的路径
		File file = new File(path);		//获取其file对象
		File[] fs = file.listFiles();	//遍历path下的文件和目录，放在File数组中
		for(File f:fs){					//遍历File[]数组
			if(!f.isDirectory())		//若非目录(即文件)，则打印
				System.out.println(f);
		}
	}

}
