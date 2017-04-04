package myDemo.desingModel.adapterModel;

/**
 * 适配器类 实现接口的方法, 继承source 类中的方法,使目标类中 既有 method1 ,也有method2
 * @author uigsw
 *
 */
public class Adapter  extends Source implements TargetTable{

	@Override
	public void method2() {
		System.out.println("this is target table method");
	}

}
