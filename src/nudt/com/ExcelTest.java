package nudt.com;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest {
	public static void main(String[] args) throws Exception {

		String fileName = "../poitest/src/nudt/com/test.xlsx";
		FileInputStream fis = new FileInputStream(fileName);
		Workbook workbook = null;
		// �ж�excel�����ָ�ʽxls,xlsx
		if (fileName.toLowerCase().endsWith("xlsx")) {
			workbook = new XSSFWorkbook(fis);
		} else if (fileName.toLowerCase().endsWith("xls")) {
			workbook = new HSSFWorkbook(fis);
		}
		// �õ�sheet������
		int numberOfSheets = workbook.getNumberOfSheets();
		System.out.println("һ��" + numberOfSheets + "��sheet");
		// ѭ��ÿһ��sheet
		for (int i = 0; i < numberOfSheets; i++) {
			// �õ���i��sheet
			Sheet sheet = workbook.getSheetAt(i);
			System.out.println(sheet.getSheetName() + "sheet");
			// �õ��еĵ�����
			Iterator<Row> rowIterator = sheet.iterator();
			int rowCount = 0;
			// ѭ��ÿһ��
			while (rowIterator.hasNext()) {
				System.out.print("��" + (rowCount++) + "��  ");
				// �õ�һ�ж���
				Row row = rowIterator.next();
				// �õ��ж���
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					// �����������
					System.out.print(cell.toString() + "\t");
				}
				System.out.println();
			}
		}
		System.out.println("read excel successfully...");
		fis.close();
	}
}
