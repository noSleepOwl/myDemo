package Tools;

import myDemo.desingModel.PrototypeModel.PrototypeDepthClone;

public class TestClass {
	public static void main(String[] args) {
		PrototypeDepthClone prototype = new PrototypeDepthClone();
		prototype.setName("小明");
		prototype.setAge(10);
		// 小明的直接克隆对象
		PrototypeDepthClone xmChildren = null;
		xmChildren=	prototype.clone();
		xmChildren.setAbout(prototype);
		prototype.setName("中明");
		// 小明直接的克隆对象的克隆
		PrototypeDepthClone xmX2 = null;
		xmX2 =	xmChildren.clone();
		xmX2.getAbout().setName("大明");
		System.out.println(xmX2.getAbout().getName());
		System.out.println(prototype.getName());
	}
}
