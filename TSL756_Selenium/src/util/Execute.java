package util;

public class Execute {

	public static void main(String[] args) {
		
		Excel excel = new Excel("C:\\Users\\vshadmin\\Desktop\\Excel09.xlsx");
				System.out.println(excel.rowCount("Sheet1"));
		System.out.println(excel.cellCount("Sheet1", 1));
		System.out.println(excel.Read("Sheet1", 1, 1));
		System.out.println(excel.Read("Sheet1", 2, 1));
		System.out.println(excel.Read("Sheet1", 4, 0));
		System.out.println(excel.Read("Sheet1", 0, 1));
	}
}
