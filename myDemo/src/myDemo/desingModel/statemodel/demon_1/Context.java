package myDemo.desingModel.statemodel.demon_1;

/**
 * 保存当前状态的类型
 * @author uigsw
 *
 */
public class Context {
	private State state ;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	public String stateMessage(){
		return state.getState();
	}
}
