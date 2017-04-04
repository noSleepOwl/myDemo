package myDemo.desingModel.PrototypeModel;

/**
 * 浅复制  将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的
 * @author uigsw
 *
 */
public class Prototype implements Cloneable {
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 年龄
	 */
	private int age ;
	/**
	 * 直属关系
	 */
	private Prototype about;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Prototype getAbout() {
		return about;
	}

	public void setAbout(Prototype about) {
		this.about = about;
	}

	@Override
	public Prototype clone() throws CloneNotSupportedException {
		return (Prototype) super.clone();
	}
	
}
