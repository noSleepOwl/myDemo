package Tools;

import myDemo.desingModel.statemodel.demon_1.Context;
import myDemo.desingModel.statemodel.demon_1.Sunshie;

public class TestClass {
	public static void main(String[] args) {
		Context context = new Context();
		context.setState(new Sunshie());
		System.out.println(context.stateMessage());
	}
}
