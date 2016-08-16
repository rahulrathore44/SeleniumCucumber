/**
 * @author rahul.rathore
 *	
 *	11-Aug-2016
 */
package com.cucumber.framework.helper.ExcelReader;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.interfaces.IdataReader;




/**
 * @author rahul.rathore
 *
 *         11-Aug-2016
 *
 */
public class ExcelReaderHelper implements IdataReader {
	
	private XSSFWorkbook wBook = null;

	private final Logger log = LoggerHelper
			.getLogger(ExcelReaderHelper.class);

	public ExcelReaderHelper(String xlFile) {
		this(new File(xlFile));
	}

	public ExcelReaderHelper(File xlFile) {
		try {
			wBook = new XSSFWorkbook(xlFile);
		} catch (InvalidFormatException | IOException e) {
			log.error(
					"Error in opening Excel Sheet : "
							+ xlFile.getAbsolutePath(), e);
			e.printStackTrace();
		}
	}

	private List<String> getHeaderArray(String sheetName) {
		LinkedList<String> header = new LinkedList<String>();
		XSSFSheet sSheet = wBook.getSheet(sheetName);

		for (int i = sSheet.getRow(0).getFirstCellNum(); i < sSheet.getRow(0)
				.getLastCellNum(); i++) {
			header.add(sSheet.getRow(0).getCell(i).getStringCellValue());
			log.debug(sSheet.getRow(0).getCell(i).getStringCellValue());
		}
		return header;
	}

	@Override
	public synchronized Object[][] getData(String sheet) throws Exception {
		List<Map<String, Object>> tableData = getTableData(sheet);
		Object[][] data = new Object[tableData.size()][1];

		int i = 0;

		for (Map<String, Object> map : tableData) {
			data[i++][0] = map;
		}

		return data;
	}

	@Override
	public synchronized Object[][] getData(String sheet, String... columnName)
			throws Exception {
		List<Map<String, Object>> tableData = getTableData(sheet, columnName);

		Object[][] data = new Object[tableData.size()][1];

		int i = 0;

		for (Map<String, Object> map : tableData) {
			data[i++][0] = map;
		}

		return data;
	}

	@Override
	public synchronized List<Map<String, Object>> getTableData(String sheetName)
			throws Exception {
		XSSFSheet sheet = wBook.getSheet(sheetName);
		int totalCol = sheet.getRow(0).getLastCellNum();
		List<String> header = getHeaderArray(sheetName);
		List<Map<String, Object>> data = new LinkedList<Map<String, Object>>();
		LinkedHashMap<String, Object> xlData = null;

		for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
			xlData = new LinkedHashMap<String, Object>();
			XSSFRow dRow = sheet.getRow(i);

			if (null == dRow) {
				log.info("Empty row, stopping the excel reader");
				break;
			}

			for (int j = dRow.getFirstCellNum(); j < totalCol; j++) {

				switch (dRow.getCell(j).getCellType()) {
				case XSSFCell.CELL_TYPE_STRING:
					xlData.put(header.get(j), dRow.getCell(j)
							.getStringCellValue());
					log.debug(header.get(j) + " : "
							+ dRow.getCell(j).getStringCellValue());
					break;
				case XSSFCell.CELL_TYPE_NUMERIC:
					xlData.put(header.get(j), dRow.getCell(j)
							.getNumericCellValue());
					log.debug(header.get(j) + " : "
							+ dRow.getCell(j).getNumericCellValue());
					break;
				}
			}
			data.add(xlData);
		}
		return data;
	}

	@Override
	public synchronized List<Map<String, Object>> getTableData(String sheet,
			String... columnName) throws Exception {
		List<Map<String, Object>> tableData = getTableData(sheet);
		List<Map<String, Object>> filterData = new LinkedList<Map<String, Object>>();

		for (Map<String, Object> map : tableData) {
			Map<String, Object> filteMap = new LinkedHashMap<String, Object>();

			for (int i = 0; i < columnName.length; i++) {
				filteMap.put(columnName[i], map.get(columnName[i]));
			}
			filterData.add(filteMap);
		}
		return filterData;
	}
}
