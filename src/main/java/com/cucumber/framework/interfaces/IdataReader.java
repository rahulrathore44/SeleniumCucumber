/**
 * @author rahul.rathore
 *	
 *	11-Aug-2016
 */
package com.cucumber.framework.interfaces;

import java.util.List;
import java.util.Map;

/**
 * @author rahul.rathore
 *	
 *	11-Aug-2016
 *
 */
public interface IdataReader {
	
	public Object[][] getData(String query,String... columnName) throws Exception;
	public Object[][] getData(String query) throws Exception;
	public List<Map<String, Object>> getTableData(String query) throws Exception;
	public List<Map<String, Object>> getTableData(String query,String... columnName) throws Exception;

}
