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
		// 判断excel的两种格式xls,xlsx
		if (fileName.toLowerCase().endsWith("xlsx")) {
			workbook = new XSSFWorkbook(fis);
		} else if (fileName.toLowerCase().endsWith("xls")) {
			workbook = new HSSFWorkbook(fis);
		}
		// 得到sheet的总数
		int numberOfSheets = workbook.getNumberOfSheets();
		System.out.println("一共" + numberOfSheets + "个sheet");
		// 循环每一个sheet
		for (int i = 0; i < numberOfSheets; i++) {
			// 得到第i个sheet
			Sheet sheet = workbook.getSheetAt(i);
			System.out.println(sheet.getSheetName() + "sheet");
			// 得到行的迭代器
			Iterator<Row> rowIterator = sheet.iterator();
			int rowCount = 0;
			// 循环每一行
			while (rowIterator.hasNext()) {
				System.out.print("第" + (rowCount++) + "行  ");
				// 得到一行对象
				Row row = rowIterator.next();
				// 得到列对象
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					// 检查数据类型
					System.out.print(cell.toString() + "\t");
				}
				System.out.println();
			}
		}
		System.out.println("read excel successfully...");
		fis.close();
	}
}
