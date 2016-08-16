/**
 * @author rahul.rathore
 *	
 *	11-Aug-2016
 */
package com.cucumber.framework.helper.DataProvider;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author rahul.rathore
 *	
 *	11-Aug-2016
 *
 */
@Target(value={ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelFileLocation {
	public String xlFileName() default "";
	public String sheetName() default "";
}