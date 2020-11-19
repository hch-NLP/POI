package nudt.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class WordTest {
	public static void main(String[] args) throws Exception {
		String path = "C:\\Users\\lenovo\\Desktop\\聘用人员行为规范.docx";
		File file = new File(path);
		InputStream is = new FileInputStream(file);
		if (path.endsWith(".doc")) {
			HWPFDocument doc = new HWPFDocument(is);
			String content = doc.getDocumentText();
			System.out.println(content);
		} else if (path.endsWith("docx")) {
			XWPFDocument docx = new XWPFDocument(is);
			POIXMLTextExtractor extractor = new XWPFWordExtractor(docx);
			String content = extractor.getText();
			System.out.println(content);
		}
	}
}
