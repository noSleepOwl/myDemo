package myDemo.desingModel.adapterModel;

/**
 * 类的适配器模式 , 
 * 	自身持有一个source 类的实例,
 * 这样的话,在实现targetTable 类的时候, 
 * 就可以直接的使用 source的实例中的方法变相的适配
 * 个人感觉:
 * 	1:比直接的继承有有优势 在于封装了内部的方法 
 * @author uigsw
 *
 */
public class Warpper implements TargetTable {
	private Source source;
	public Warpper(Source source) {
		super();
		this.source = source;
	}
	@Override
	public void method1() {
		source.method1();
	}

	@Override
	public void method2() {
		System.out.println("this is the target method");
	}

}
