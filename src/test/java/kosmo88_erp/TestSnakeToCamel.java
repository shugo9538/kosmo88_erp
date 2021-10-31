package kosmo88_erp;

import com.kosmo88.logistics_erp.wms.util.DtoFunction;

public class TestSnakeToCamel {

	public TestSnakeToCamel() {
	}
	
	public static void main(String[] args) {
		DtoFunction.enableBasicLog();
		DtoFunction.snakeToCamel("hello_my_friend");
//		DtoFunction.disableLog();
		DtoFunction.camelToSnake("helloMyWorld");
//		DtoFunction.camelToSnake("HelloMyWorld");
		
		
	}
}
