package Tools;

import myDemo.desingModel.adapterModel.Source;
import myDemo.desingModel.adapterModel.TargetTable;
import myDemo.desingModel.adapterModel.Warpper;

public class TestClass {
	public static void main(String[] args) {
		Source source = new Source();
		TargetTable tar  = new Warpper(source);
		tar.method1();
		tar.method2();
	}
}
