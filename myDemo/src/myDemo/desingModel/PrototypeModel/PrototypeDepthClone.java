package myDemo.desingModel.PrototypeModel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。简单来说，就是深复制进行了完全彻底的复制，而浅复制不彻底。
 * @author uigsw
 *
 */
public class PrototypeDepthClone implements Cloneable ,Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private PrototypeDepthClone about;
	
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

	public PrototypeDepthClone getAbout() {
		return about;
	}

	public void setAbout(PrototypeDepthClone about) {
		this.about = about;
	}

	@Override
	public PrototypeDepthClone clone() {
		PrototypeDepthClone prototypeDepthClone = null;
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = null;
			try {
				objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				objectOutputStream.writeObject(this);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
			ObjectInputStream objectInputStream = null;
			try {
				objectInputStream = new ObjectInputStream(byteArrayInputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				prototypeDepthClone = (PrototypeDepthClone) objectInputStream.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return prototypeDepthClone;
	}
	
}
