package Tools;

import myDemo.desingModel.adapterModel.Adapter;
import myDemo.desingModel.adapterModel.TargetTable;

public class TestClass {
	public static void main(String[] args) {
		TargetTable targetTable = new Adapter();
		targetTable.method1();
		targetTable.method2();
	}
	
}
