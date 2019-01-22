package utility.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData {

	private Map<String, Map<String, TestKey>> data = new HashMap<>();
	private String dataSheetName = null;
	private String xlsPath;
	
	public TestData(String xlsPath) {
		this.xlsPath = xlsPath;
		loadData();
	}

	public void setDataSheetName(String dataSheetName) {
		this.dataSheetName = dataSheetName;
	}

	private void loadData() {
		try {
			readXL();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readXL() throws IOException {
		File f1 = new File(xlsPath);
		FileInputStream f2 = new FileInputStream(f1);
		XSSFWorkbook wr = new XSSFWorkbook(f2);

		for (int i = 0; i < wr.getNumberOfSheets(); i++) {
			XSSFSheet sh = wr.getSheetAt(i);
			for (int row = 1; row <= sh.getLastRowNum(); row++) {
				XSSFRow rw = sh.getRow(row);
				String key = rw.getCell(0).getStringCellValue();
				String type;
				try {
					type = rw.getCell(1).getStringCellValue();
				} catch (Exception e1) {
					//e1.printStackTrace();
					type=null;
				}
				String value;
				try {
					value = rw.getCell(2).getStringCellValue();
				} catch (Exception e) {
					//e.printStackTrace();
					value = null;
				}
				if(!data.containsKey(sh.getSheetName())) {
					data.put(sh.getSheetName(), new HashMap<>());
				}
				Map<String, TestKey> dataKey = data.get(sh.getSheetName());
				dataKey.put(key, new TestKey(key, type, value));
			}
		}
		wr.close();
	}
	
	public TestKey getPOM(String sheetName, String key) {
		if (!data.containsKey(sheetName)) {
			assert false : "Invalid Sheet Name " + sheetName;
			return null;
		}
		return data.get(sheetName).get(key);
	}

	public TestKey getPOM(String key) {
		setDataSheetName(StaticData.pom);		
		return getPOM(dataSheetName, key);
	}
	
	public String getData(String sheetName,String key) {
		TestKey tk=data.get(sheetName).get(key);
		String value = tk.getType();
		return value;
	}
	
	public static void main(String[] args) throws IOException {

		new TestData(StaticData.xlspath);
		
	}

}
