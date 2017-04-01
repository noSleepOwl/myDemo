package Tools;

import myDemo.desingModel.Context;
import myDemo.desingModel.Sunshie;

public class TestClass {
	public static void main(String[] args) {
		Context context = new Context();
		context.setState(new Sunshie());
		System.out.println(context.stateMessage());
	}
}
