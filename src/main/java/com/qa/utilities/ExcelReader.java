package com.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * Utility to read Excel files. This file makes use of apache poi for reading excel files.
 * It supports both "xls" and "xlsx" file extension.
 *
 */
public class ExcelReader  {
	private static Cell openCell;
	private static Row openRow;
	private static Sheet openSheet;
	private static Workbook openWorkbook;
	private static Map<String, List<String>> storedData = new LinkedHashMap<String, List<String>>();
	public static ResultSet resultset;
	protected static String TestDataPath=FileUtilities.fnGetCurrentUserDir()+"/testdata/TestData.xlsx";
	private static XSSFWorkbook workbook = null;
	private static XSSFSheet sheet = null;
	private XSSFRow row   =null;
	private XSSFCell cell = null;
	public  String path;
	public  FileInputStream fis = null;
	public  FileOutputStream fileOut =null;

	/**
	 * Name of Function 	:- ExcelReader
	* Class Name :- ExcelReader 
	 * Function Description :- Creates a ExcelReader object based on filePath
	 */
	public ExcelReader(String filePath) throws FileNotFoundException,IOException  {
		this(new File(filePath));
		System.out.println("Spreadsheet path :- ***** "+filePath +" *****");
		this.path=filePath;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	/**
	 * Name of Function 	:- ExcelReader
	 * Class Name :- ExcelReader 
	 * Function Description :- Creates a ExcelReader object based on <code>File</code> object passed
	 */
	public ExcelReader(File file) {
		try {
			this.openFile(file, 0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Name of Function 	:- ExcelReader
	* Class Name :- ExcelReader 
	 */
	public ExcelReader(InputStream fileStream) throws IOException, FileNotFoundException  {
		this.openFile(fileStream, 0);
	}

	/**
	 * Name of Function 	:- ExcelReader
	* Class Name :- ExcelReader 
	 */
	public ExcelReader(String filePath, int sheetNo) throws IOException, FileNotFoundException  {
		this.openFile(filePath, sheetNo);
	}
	
	/**
	 * Name of Function 	:- ExcelReader
	* Class Name :- ExcelReader 
	 */
	public ExcelReader(InputStream fileStream, int sheetNo) throws IOException, FileNotFoundException  {
		this.openFile(fileStream, sheetNo);
	}

	/**
	 * Name of Function 	:- ExcelReader
	* Class Name :- ExcelReader 
	 */
	public ExcelReader(String filePath, String sheetName) throws IOException, FileNotFoundException {
		this.openFile(filePath, sheetName);
	}
	
	/**
	 * Name of Function 	:- ExcelReader
	* Class Name :- ExcelReader 
	 */
	public ExcelReader(InputStream fileStream, String sheetName) throws IOException, FileNotFoundException {
		this.openFile(fileStream, sheetName);
	}

	/**
	 *Name of Function 		:- ExcelReader
	* Class Name :- ExcelReader 
	 */
	public ExcelReader(File file, int sheetNo) throws IOException, FileNotFoundException {
		try {
			this.openFile(file, sheetNo);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 *Name of Function 		:- ExcelReader
	* Class Name :- ExcelReader 
	 */
	public ExcelReader(File file, String sheetName) {
		try {
			this.openFile(file, sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 *Name of Function 		:- openFile
	* Class Name :- ExcelReader 
	 */
	public void openFile(File file, int sheetNo) throws IOException,FileNotFoundException {
		openWorkbook(file);
		openSheet = openWorkbook.getSheetAt(sheetNo);
	}
	
	/**
	 *Name of Function 		:- openFile
	* Class Name :- ExcelReader 
	 */
	public void openFile(InputStream fileStream, int sheetNo) throws IOException,FileNotFoundException {
		openWorkbook(fileStream);
		openSheet = openWorkbook.getSheetAt(sheetNo);
	}

	/**
	 *Name of Function 		:- openFile
	 * Class Name :- ExcelReader 
	 */
	public void openFile(String filePath, int sheetNo)throws FileNotFoundException, IOException {
		this.openFile(new File(filePath), sheetNo);
	}
	
	/**
	 *Name of Function 		:- openFile
	 * Class Name :- ExcelReader 
	 */
	public void openFile(File file, String sheetName)throws FileNotFoundException, IOException {
		openWorkbook(file);
		openSheet = openWorkbook.getSheet(sheetName);
	}
	
	/**
	 *Name of Function 		:- openFile
	* Class Name :- ExcelReader 
	 */
	public void openFile(String filePath, String sheetName)throws FileNotFoundException, IOException {
		openWorkbook(filePath);
		openSheet = openWorkbook.getSheet(sheetName);
	}
	
	/**
	 *Name of Function 		:- openFile
	 * Class Name :- ExcelReader 
	 */
	public void openFile(InputStream fileStream, String sheetName)throws FileNotFoundException, IOException {
		openWorkbook(fileStream);
		openSheet = openWorkbook.getSheet(sheetName);
	}
	
	/**
	 *Name of Function 		:- openWorkbook
	* Class Name :- ExcelReader 
	 */
	public static void openWorkbook(String filePath) throws FileNotFoundException,IOException {
		openWorkbook(new File(filePath));
	}
	
	/**
	 *Name of Function 		:- openWorkbook
	 * Class Name :- ExcelReader 
	 */
	public static void openWorkbook(File file) throws FileNotFoundException,IOException {
		try{
			openWorkbook = WorkbookFactory.create(file);
		} catch (Exception e ){
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 *Name of Function 		:- openWorkbook
	* Class Name :- ExcelReader
	 */
	public static void openWorkbook(InputStream fileStream) throws FileNotFoundException,IOException {
		try {
			openWorkbook = WorkbookFactory.create(fileStream);
			System.out.println(openWorkbook);
		} catch (InvalidFormatException e ){
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 *Name of Function 		:- openSheet
	* Class Name :- ExcelReader 
	 */
	@SuppressWarnings("unused")
	private void openSheet(){
		openSheet = openWorkbook.getSheetAt(0);
	}
	
	/**
	 *Name of Function 		:- openSheet
	* Class Name :- ExcelReader 
	 */
	@SuppressWarnings("unused")
	private void openSheet(int sheetNo){
		openSheet = openWorkbook.getSheetAt(sheetNo);
	}
	
	/**
	 *Name of Function 		:- openSheet
	* Class Name :- ExcelReader 
	 */
	public static boolean openSheet(String workbookpath, String sheetName){
		try{
			if(System.getProperty("os.name").equalsIgnoreCase("windows")){
				TestDataPath=workbookpath;
			}else{
				TestDataPath=workbookpath;
			}
			openWorkbook=new XSSFWorkbook(new File(TestDataPath));
			openSheet = openWorkbook.getSheet(sheetName);
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
		return openSheet.isSelected();
	}
	
	/**
	 *Name of Function 		:- getOpenWorkbook
	* Class Name :- ExcelReader 
	 */
	public Workbook getOpenWorkbook(){
		return openWorkbook;				
	}

	/**
	 *Name of Function 		:- getData
	* Class Name :- ExcelReader 
	 *  * Gets the data from the currently opened sheet based on row and column number
	 */
	public static String getData(int row, int column) {
		String data = "";
		try {
			openRow = openSheet.getRow(row);
			openCell = openRow.getCell(column);
			int cellType = openCell.getCellType();
			switch (cellType) {
			case 0:
				if (DateUtil.isCellDateFormatted(openCell)) {
					Date dt = openCell.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat(
							"dd MM yyyy HH:mm:ss");
					data = sdf.format(dt);
				} else
					data = Long.toString(Math.round(openCell
							.getNumericCellValue()));
				break;
			case 1:
				data = openCell.getRichStringCellValue().getString();
				break;
			case 2:
				data = openCell.getRichStringCellValue().getString();
				break;
			case 3:
				data = openCell.getRichStringCellValue().getString();
				break;
			case 4:
				data = Boolean.toString(openCell.getBooleanCellValue());
				break;
			case 5:
				data = Byte.toString(openCell.getErrorCellValue());
				break;
			default:
				data = openCell.getRichStringCellValue().getString();
			}
			if (data == null) {
				data = "";
			}
			return data;
		} catch (Exception e) {
			if (openRow == null || openCell == null || data == null) {
				data = "";
				return data;
			} else {
				System.out.println(e);
				return "";
			}
		}
	}

	/**
	 *Name of Function 		:- getNoOfRows
	* Class Name :- ExcelReader 
	 *  * Gets the no. of rows in the currently opened sheet
	 */
	public int getNoOfRows() {
		return openSheet.getPhysicalNumberOfRows();
	}
	/**
	 *Name of Function 		:- getNoOfColumn
	 * Class Name :- ExcelReader 
	 *  * Gets the no. of column present in the first row of the currently opened sheet.
	 */
	public int getNoOfColumn() {
		return this.getNoOfColumn(0);
	}
	
	/**
	 *Name of Function 		:- getNoOfColumn
	* Class Name :- ExcelReader 
	 *  * Gets the no. of column present in the specified row of the currently opened sheet.
	 */
	public int getNoOfColumn(int rowNo) {
		Row rw = openSheet.getRow(rowNo);
		return rw.getPhysicalNumberOfCells();
	}
	
	/**
	 *Name of Function 		:- getParameters
	* Class Name :- ExcelReader 
	 */
	public int getParameters() {
		Row rw = openSheet.getRow(0);
		return rw.getPhysicalNumberOfCells();
	}
	
	/**
	 *Name of Function 		:- storeData
	* Class Name :- ExcelReader 
	 *  * Stores the whole data of the currently opened sheet in a Map containing keys 
	 */
	public static void storeData() {
		try{
			int rowCount = openSheet.getPhysicalNumberOfRows();
			Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
			for (int i = 0; i < rowCount; i++) {
				Row row = openSheet.getRow(i);
				String rowKey = "";
				int cellCount = row.getPhysicalNumberOfCells();
				for (int j = 0; j < cellCount; j++) {
					String cellValue = row.getCell(j).getStringCellValue();
					if (j == 0) {
						rowKey = cellValue;
						map.put(rowKey, new ArrayList<String>());
					} else {
						map.get(rowKey).add(cellValue);
					}
				}
			}
			storedData = map;
		}catch(Exception ex){
			ex.getLocalizedMessage();};
	}
	
	/**
	 *Name of Function 		:- storeDataBkp
	* Class Name :- ExcelReader 
	 */
	public void storeDataBkp() {
		Row rw;
		int rowCount = openSheet.getPhysicalNumberOfRows();
		storedData.clear();
		for (int i = 0; i < rowCount - 1; i++) {
			rw = openSheet.getRow(i);
			String key = getData(0, i);
			List<String> valueList = new ArrayList<String>();
			storedData.put(key, valueList);
			for (int j = 1; j < rw.getPhysicalNumberOfCells(); j++) {
				String data = getData(j, i);
				valueList.add(data);
			}}
	}
	
	/**
	 *Name of Function 		:- getStoredData
	 * Class Name :- ExcelReader 
	 */
	public static Map<String, List<String>> getStoredData() {
		storeData();
		return storedData;
	}
	
	/**
	 *Name of Function 		:- getStoredDataBkp
	* Class Name :- ExcelReader 
	 */
	public Map<String, List<String>> getStoredDataBkp() {
		if(storedData.isEmpty()){
			storeData();
		}
		return storedData;
	}
	
	/**
	 *Name of Function 		:- getStoredData
	* Class Name :- ExcelReader 
	 */
	public static Map<String, List<String>> getStoredData(String workbookpath, String sheetName) {
		openSheet(workbookpath,sheetName);
		storedData.clear();
		return getStoredData();
	}
	
	/**
	 *Name of Function 		:- getStoredDataAsMap
	* Class Name :- ExcelReader 
	 */
	public static List<Map<String, String>> getStoredDataAsMap(String fileName) {
		List<Map<String, String>> listOfDataMap = new ArrayList<Map<String, String>>();
		try {
			// Create the input stream from the xlsx/xls file
			FileInputStream fis = new FileInputStream(fileName);
			// Create Workbook instance for xlsx/xls file input stream
			Workbook workbook = null;
			if (fileName.toLowerCase().endsWith("xlsx")) {
				workbook = new XSSFWorkbook(fis);
			} else if (fileName.toLowerCase().endsWith("xls")) {
				workbook = new HSSFWorkbook(fis);
			}
			// Get the 1st sheet from the workbook
			Sheet sheet = workbook.getSheetAt(0);
			// every sheet has rows, iterate over them
			Iterator<Row> rowIterator = sheet.iterator();
			boolean firstRowFlag = true;
			Row firstRow = null;
			while (rowIterator.hasNext()) {
				HashMap<String, String> rowMap = new HashMap<String, String>();
				Row currentRow = (Row) rowIterator.next();
				if (firstRowFlag) {
					//Sets to false once it founds the first row
					firstRowFlag = false;
					// Gets the first row and save it in a variable to use it later, which are expected to be column names
					firstRow = currentRow;
					continue; //Continue with next record.
				}
				//This loop executes from second row onwards, where actual test data starts
				for (int i = 0; i < currentRow.getLastCellNum(); i++) {
					//Gets the current cell value
					String currentCellValue = currentRow.getCell(i).getStringCellValue();
					//Gets the appropriate column name for the current cell
					String colName = firstRow.getCell(i).getStringCellValue();
					//Adds to the Row Map
					rowMap.put(colName, currentCellValue);
				}
				//Row Map adds to the List
				listOfDataMap.add(rowMap);
			}
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listOfDataMap;
	}
	
	/**
	 *Name of Function 		:- getListDataFromMap
	* Class Name :- ExcelReader 
	 */
	public static ArrayList<String> getListDataFromMap(Map<String, List<String>> excelData) {
		ArrayList<String> list=new ArrayList<String>();
		for (Map.Entry<String, List<String>> entry : excelData.entrySet()) {
			if (entry.getKey().equalsIgnoreCase(entry.getKey())){
				list=(ArrayList<String>) entry.getValue();
			}
		}
		return list;
	}
	
	/**
	 *Name of Function 		:- getNumberOfSheets
	* Class Name :- ExcelReader 
	 */
	public int getNumberOfSheets() {
		return openWorkbook.getNumberOfSheets();
	}

	/**
	 *Name of Function 		:- fn_GetCellData
	* Class Name :- ExcelReader 
	 */
	public static String fn_GetCellData(String WbookPath, String SheetName, int RowNum, String ColumnName)throws IOException {
		FileInputStream FISObj = new FileInputStream(WbookPath);
		@SuppressWarnings("resource")
		XSSFWorkbook WbookObj = new XSSFWorkbook(FISObj);
		XSSFSheet WSheetObj = WbookObj.getSheet(SheetName);
		XSSFRow RowObj = WSheetObj.getRow(RowNum);
		int columnNumber = fn_GetCellNumberByColumName(WSheetObj, ColumnName);
		XSSFCell CellObj = RowObj.getCell(columnNumber, XSSFRow.CREATE_NULL_AS_BLANK);
		int celltypenumber = CellObj.getCellType();
		String CellVal = null;
		if (celltypenumber == XSSFCell.CELL_TYPE_NUMERIC) {
			Double DblCellVal = CellObj.getNumericCellValue();
			Integer intcellval = DblCellVal.intValue();
			CellVal = intcellval.toString();
		} else if (celltypenumber == XSSFCell.CELL_TYPE_STRING) {
			CellVal = CellObj.getStringCellValue();
		}
		return CellVal;
	}

	/**
	 *Name of Function 		:- fn_GetCellNumberByColumName
	* Class Name :- ExcelReader 
	 */
	public static int fn_GetCellNumberByColumName(XSSFSheet WSheetObj, String ColumnName) throws IOException {
		XSSFRow FstRowObj = WSheetObj.getRow(0);
		int columnCount = FstRowObj.getLastCellNum();
		int columnNumber = 0;
		for (int i = 0; i <= columnCount - 1; i++) {
			XSSFCell cellObj = FstRowObj.getCell(i, XSSFRow.CREATE_NULL_AS_BLANK);
			String xl_ColumnName = cellObj.getStringCellValue();
			xl_ColumnName = xl_ColumnName.trim();
			ColumnName = ColumnName.trim();
			if (ColumnName.equalsIgnoreCase(xl_ColumnName) == true) {
				columnNumber = i;
				break;
			}
		}
		return columnNumber;
	}

	/**
	 *Name of Function 		:- fn_GetRowCount
	* Class Name :- ExcelReader 
	 */
	public static int fn_GetRowCount(String xl_FilePath, String SheetName) throws IOException {
		File xlFileObj = new File(xl_FilePath);
		FileInputStream FISObj = new FileInputStream(xlFileObj);
		@SuppressWarnings("resource")
		XSSFWorkbook WbookObj = new XSSFWorkbook(FISObj);
		XSSFSheet WSheetObj = WbookObj.getSheet(SheetName);
		int rowcount = WSheetObj.getLastRowNum();
		return rowcount;
	}

	/**
	 *Name of Function 		:- getAllData
	 * Class Name :- ExcelReader 
	 */
	public static void getAllData(String worbookPath, String sheetName) throws IOException {
		FileInputStream FISObj = new FileInputStream(worbookPath);
		@SuppressWarnings("resource")
		XSSFWorkbook WbookObj = new XSSFWorkbook(FISObj);
		XSSFSheet WSheetObj = WbookObj.getSheet(sheetName);
		int rowcount = WSheetObj.getLastRowNum();//// it returns nuberofrows-1
		for (int i = 1; i <= rowcount; i++) {
			XSSFRow RowObj = WSheetObj.getRow(i);
			int cellcount = 0;
			try {
				cellcount = RowObj.getPhysicalNumberOfCells();//// it returns
				//// number of
				//// cells only
				//// not -1
			} catch (Exception e) {}
			for (int j = 0; j <= cellcount - 1; j++) {
				MissingCellPolicy MCPObj = XSSFRow.CREATE_NULL_AS_BLANK;
				XSSFCell CellObj = RowObj.getCell(j, MCPObj);
				int celltypenumber = CellObj.getCellType();
				String CellVal = null;
				if (celltypenumber == XSSFCell.CELL_TYPE_NUMERIC) {
					Double DblCellVal = CellObj.getNumericCellValue();
					Integer intcellval = DblCellVal.intValue();
					CellVal = intcellval.toString();
				} else if (celltypenumber == XSSFCell.CELL_TYPE_STRING) {
					CellVal = CellObj.getStringCellValue();
				}
				System.out.print(CellVal + ",");
			}
		}
	}

	/**
	 *Name of Function 		:- storeDatafromRow
	* Class Name :- ExcelReader 
	 */
	public static void storeDatafromRow(int startRowNumber, int endRowNumber) {
		try {
			Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
			int rowCount = openSheet.getPhysicalNumberOfRows();
			if(rowCount>=endRowNumber){
				String[] array = new String[100];
				Row row = openSheet.getRow(0);
				int cellCount = row.getPhysicalNumberOfCells();
				for (int j = 0; j < cellCount; j++) {
					String cellValue = row.getCell(j).getStringCellValue();
					array[j] = cellValue;
					map.put(cellValue, new ArrayList<String>());
				}
				for (int i = startRowNumber; i < endRowNumber; i++) {
					row = openSheet.getRow(i);
					cellCount = row.getPhysicalNumberOfCells();
					for (int j = 0; j < cellCount; j++) {
						MissingCellPolicy MCPObj = XSSFRow.CREATE_NULL_AS_BLANK;
						XSSFCell CellObj = (XSSFCell) row.getCell(j, MCPObj);
						int celltypenumber = CellObj.getCellType();
						String cellValue = null;
						if (celltypenumber == XSSFCell.CELL_TYPE_NUMERIC) {
							Double DblCellVal = CellObj.getNumericCellValue();
							Integer intcellval = DblCellVal.intValue();
							cellValue = intcellval.toString();
						} else if (celltypenumber == XSSFCell.CELL_TYPE_STRING) {
							cellValue = CellObj.getStringCellValue();
						} else if (celltypenumber == XSSFCell.CELL_TYPE_BOOLEAN) {
							Boolean booleanCellValue = CellObj.getBooleanCellValue();
							cellValue = booleanCellValue.toString();
						}
						map.get(array[j]).add(cellValue);
					}
				}
			}
			storedData = map;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 *Name of Function 		:- getStoredDataFromSelectedRows
	* Class Name :- ExcelReader 
	 */
	public static Map<String, List<String>> getStoredDataFromSelectedRows(String workBook, String sheetName,
			int startRowNumber, int endRowNumber) {
		openSheet(workBook, sheetName);
		storedData.clear();
		storeDatafromRow(startRowNumber, endRowNumber);
		return storedData;
	}

	/**
	 *Name of Function 		:- read
	 * Class Name :- ExcelReader 
	 */
	public static List<String> read(XSSFSheet sheet) throws IOException {
		List<String> excelVal = new ArrayList<String>();
		Iterator<Row> rowIterator = sheet.rowIterator();
		while (rowIterator.hasNext()) {
			Row rovVal = (Row) rowIterator.next();
			String rowVal = "";
			for (int i = 0; i < rovVal.getLastCellNum(); i++) {
				XSSFCell cellA1 = (XSSFCell) rovVal.getCell(i);
				rowVal = rowVal + cellA1.getStringCellValue() + "~";
			}
			excelVal.add(rowVal);
		}

		return excelVal;
	}
	
	/**
	 *Name of Function 		:- readParamsFromExcel
	* Class Name :- ExcelReader 
	 */
	public static String[][] readParamsFromExcel(String excelFilePath, String sheetName, int numberOfParameters) {
		String[][] finalTestData = null;
		try {
			XSSFSheet sheet = (XSSFSheet) openWorkbook.getSheet(sheetName);
			List<String> excelVal = read(sheet);
			finalTestData = new String[excelVal.size()][numberOfParameters];
			int count=0;
			for (String rowVal : excelVal) {
				String[] col1DatatArray = rowVal.split("~");
				for(int i = 0; i < numberOfParameters; i++){
					finalTestData[count]=col1DatatArray;
				}
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return finalTestData;
	}

	/**
	 *Name of Function 	:- readData
	* Class Name :- ExcelReader 
	 */
	public static List<String> readData(XSSFSheet sheet) throws IOException {
		List<String> excelVal = new ArrayList<String>();
		Iterator<Row> rowIterator = sheet.rowIterator();
		while (rowIterator.hasNext()) {
			Row rovVal = (Row) rowIterator.next();
			String rowVal = "";
			for (int i = 0; i < rovVal.getLastCellNum(); i++) {
				XSSFCell cellA1 = (XSSFCell) rovVal.getCell(i);
				rowVal = rowVal + cellA1.getStringCellValue() + "~";
			}
			excelVal.add(rowVal);
		}
		return excelVal;
	}

	/**
	 *Name of Function 		:- getRowCount
	* Class Name :- ExcelReader 
	 * returns the row count in a sheet
	 */
	public static int getRowCount(String sheetName){
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1)
			return 0;
		else{
			sheet = workbook.getSheetAt(index);
			int number=sheet.getLastRowNum()+1;
			return number;
		}
	}
	
	/**
	 *Name of Function 		:- setCellData
	* Class Name :- ExcelReader 
	 * returns true if data is set successfully else false
	 */
	public boolean setCellData(String sheetName,String colName,int rowNum, String data){
		try{
			fis = new FileInputStream(path); 
			workbook = new XSSFWorkbook(fis);
			if(rowNum<=0)
				return false;
			int index = workbook.getSheetIndex(sheetName);
			int colNum=-1;
			if(index==-1)
				return false;
			sheet = workbook.getSheetAt(index);
			row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++){
				if(row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum=i;
			}
			if(colNum==-1)
				return false;
			sheet.autoSizeColumn(colNum); 
			row = sheet.getRow(rowNum-1);
			if (row == null)
				row = sheet.createRow(rowNum-1);

			cell = row.getCell(colNum);	
			if (cell == null)
				cell = row.createCell(colNum);
			cell.setCellValue(data);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();	
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 *Name of Function 		:- setCellData
	* Class Name :- ExcelReader 
	 * returns true if data is set successfully else false
	 */
	public boolean setCellData(String sheetName,String colName,int rowNum, String data,String url){
		//System.out.println("setCellData setCellData******************");
		try{
			fis = new FileInputStream(path); 
			workbook = new XSSFWorkbook(fis);
			if(rowNum<=0)
				return false;
			int index = workbook.getSheetIndex(sheetName);
			int colNum=-1;
			if(index==-1)
				return false;
			sheet = workbook.getSheetAt(index);
			//System.out.println("A");
			row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++){
				//System.out.println(row.getCell(i).getStringCellValue().trim());
				if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName))
					colNum=i;
			}
			if(colNum==-1)
				return false;
			sheet.autoSizeColumn(colNum); //ashish
			row = sheet.getRow(rowNum-1);
			if (row == null)
				row = sheet.createRow(rowNum-1);
			cell = row.getCell(colNum);	
			if (cell == null)
				cell = row.createCell(colNum);
			cell.setCellValue(data);
			XSSFCreationHelper createHelper = workbook.getCreationHelper();
			//cell style for hyperlinks
			//by default hypelrinks are blue and underlined
			CellStyle hlink_style = workbook.createCellStyle();
			XSSFFont hlink_font = workbook.createFont();
			hlink_font.setUnderline(XSSFFont.U_SINGLE);
			hlink_font.setColor(IndexedColors.BLUE.getIndex());
			hlink_style.setFont(hlink_font);
			//hlink_style.setWrapText(true);
			XSSFHyperlink link = createHelper.createHyperlink(XSSFHyperlink.LINK_FILE);
			link.setAddress(url);
			cell.setHyperlink(link);
			cell.setCellStyle(hlink_style);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();	
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 *Name of Function 		:- addSheet
	 * Class Name :- ExcelReader 
	 * returns true if sheet is created successfully else false
	 */
	
	public boolean addSheet(String  sheetname){		
		FileOutputStream fileOut;
		try {
			workbook.createSheet(sheetname);	
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();		    
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 *Name of Function 		:- removeSheet
	* Class Name :- ExcelReader 
	 * returns true if sheet is removed successfully else false if sheet does not exist
	 */
	public boolean removeSheet(String sheetName){		
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1)
			return false;
		FileOutputStream fileOut;
		try {
			workbook.removeSheetAt(index);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();		    
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 *Name of Function 		:- addColumn
	* Class Name :- ExcelReader 
	 * returns true if column is created successfully
	 */
	public boolean addColumn(String sheetName,String colName){
		//System.out.println("**************addColumn*********************");
		try{				
			fis = new FileInputStream(path); 
			workbook = new XSSFWorkbook(fis);
			int index = workbook.getSheetIndex(sheetName);
			if(index==-1)
				return false;
			XSSFCellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			sheet=workbook.getSheetAt(index);
			row = sheet.getRow(0);
			if (row == null)
				row = sheet.createRow(0);
			//cell = row.getCell();	
			//if (cell == null)
			//System.out.println(row.getLastCellNum());
			if(row.getLastCellNum() == -1)
				cell = row.createCell(0);
			else
				cell = row.createCell(row.getLastCellNum());
			cell.setCellValue(colName);
			cell.setCellStyle(style);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();		    
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 *Name of Function 		:- removeColumn
	* Class Name :- ExcelReader 
	 * removes a column and all the contents
	 */
	
	public boolean removeColumn(String sheetName, int colNum) {
		try{
			if(!isSheetExist(sheetName))
				return false;
			fis = new FileInputStream(path); 
			workbook = new XSSFWorkbook(fis);
			sheet=workbook.getSheet(sheetName);
			XSSFCellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			//XSSFCreationHelper createHelper = workbook.getCreationHelper();
			style.setFillPattern(HSSFCellStyle.NO_FILL);
			for(int i =0;i<getRowCount(sheetName);i++){
				row=sheet.getRow(i);	
				if(row!=null){
					cell=row.getCell(colNum);
					if(cell!=null){
						cell.setCellStyle(style);
						row.removeCell(cell);
					}
				}
			}
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 *Name of Function 		:- addHyperLink
	* Class Name :- ExcelReader 
	 * String sheetName, String testCaseName,String keyword ,String URL,String message
	 */
	public boolean addHyperLink(String sheetName,String screenShotColName,String testCaseName,int index,String url,String message){
		//System.out.println("ADDING addHyperLink******************");
		url=url.replace('\\', '/');
		if(!isSheetExist(sheetName))
			return false;
		sheet = workbook.getSheet(sheetName);
		for(int i=2;i<=getRowCount(sheetName);i++){
			if(getCellData(sheetName, 0, i).equalsIgnoreCase(testCaseName)){
				//System.out.println("**caught "+(i+index));
				setCellData(sheetName, screenShotColName, i+index, message,url);
				break;
			}
		}
		return true; 
	}

	/**
	 *Name of Function 		:- startRow
	 * Class Name :- ExcelReader 
	 * Function to get start row number
	 */
	public int startRow(ExcelReader xls, int rowNum){
		String testCaseStartRow= null;
		testCaseStartRow = xls.getCellData("Test Cases", 3, rowNum);
		int testCaseStartRowNum = Integer.parseInt(testCaseStartRow);
		return testCaseStartRowNum;
	}
	
	/**
	 *Name of Function 		:- endRow
	 * Class Name :- ExcelReader 
	 * Function to get End row number
	 */
	public int endRow(ExcelReader xls, int rowNum){
		String testCaseEndRow= null;
		testCaseEndRow = xls.getCellData("Test Cases", 4, rowNum);
		int testCaseEndRowNum = Integer.parseInt(testCaseEndRow);
		return testCaseEndRowNum;
	}

	/**
	 *Name of Function 		:- getCellData
	* Class Name :- ExcelReader 
	 * returns the data from a cell
	 */
	public String getCellData(String sheetName,String colName,int rowNum){
		try{
			if(rowNum <=0)
				return "";
			//System.out.println("sheet Name"+sheetName);
			int index = workbook.getSheetIndex(sheetName);
			int col_Num=-1;
			if(index==-1)
				return "";
			sheet = workbook.getSheetAt(index);
			row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++){
				//System.out.println(row.getCell(i).getStringCellValue().trim());
				if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num=i;
			}
			if(col_Num==-1)
				return "";
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum-1);
			if(row==null)
				return "";
			cell = row.getCell(col_Num);
			if(cell==null)
				return "";
			//System.out.println(cell.getCellType());
			if(cell.getCellType()==Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA ){
				String cellText  = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// format in form of M/D/YY
					double d = cell.getNumericCellValue();
					Calendar cal =Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText =
							(String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +
							cal.get(Calendar.MONTH)+1 + "/" + 
							cellText;
				}
				return cellText;
			}else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
				return ""; 
			else 
				return String.valueOf(cell.getBooleanCellValue());
		}
		catch(Exception e){
			e.printStackTrace();
			return "row "+rowNum+" or column "+colName +" does not exist in xls";
		}
	}

	/**
	 *Name of Function 		:- getColumnCount
	* Class Name :- ExcelReader 
	 * returns number of columns in a sheet	
	 */
	public int getColumnCount(String sheetName){
		// check if sheet exists
		if(!isSheetExist(sheetName))
			return -1;
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		if(row==null)
			return -1;
		return row.getLastCellNum();
	}
	/**
	 *Name of Function 		:- isSheetExist
	* Class Name :- ExcelReader 
	 */
	public boolean isSheetExist(String sheetName){
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1){
			index=workbook.getSheetIndex(sheetName.toUpperCase());
			if(index==-1)
				return false;
			else
				return true;
		}
		else
			return true;
	}
	
	/**
	 *Name of Function 		:- getColumnCount
	* Class Name :- ExcelReader 
	 * returns number of columns in a sheet	
	 */
	public int getColumnCount(String sheetName, int rowNumber){
		// check if sheet exists
		if(!isSheetExist(sheetName))
			return -1;
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNumber);
		if(row==null)
			return -1;
		return row.getLastCellNum();
	}
	
	/**
	 *Name of Function 		:- getCellRowNum
	 * Class Name :- ExcelReader 
	 */
	public int getCellRowNum(String sheetName,String colName,String cellValue){
		for(int i=2;i<=getRowCount(sheetName);i++){
			if(getCellData(sheetName,colName , i).equalsIgnoreCase(cellValue)){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 *Name of Function 		:- getCellData
	 * Class Name :- ExcelReader 
	 * returns the data from a cell
	 */
	public String getCellData(String sheetName,int colNum,int rowNum){
		try{
			if(rowNum <=0)
				return "";
			int index = workbook.getSheetIndex(sheetName);
			if(index==-1)
				return "";
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum-1);
			if(row==null)
				return "";
			cell = row.getCell(colNum);
			if(cell==null)
				return "";
			if(cell.getCellType()==Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA ){
				String cellText  = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					// format in form of M/D/YY
					double d = cell.getNumericCellValue();
					Calendar cal =Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText =
							(String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.MONTH)+1 + "/" +
							cal.get(Calendar.DAY_OF_MONTH) + "/" +
							cellText;
				}
				return cellText;
			}else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
				return "";
			else 
				return String.valueOf(cell.getBooleanCellValue());
		}
		catch(Exception e){
			e.printStackTrace();
			return "row "+rowNum+" or column "+colNum +" does not exist  in xls";
		}
	}
}