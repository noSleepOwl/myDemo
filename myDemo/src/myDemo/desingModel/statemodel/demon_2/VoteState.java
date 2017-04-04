package myDemo.desingModel.statemodel.demon_2;

/**
 * 投票的状态类
 * @author uigsw
 *
 */
public interface VoteState {
	/**
	 * 状态类执行的方法
	 * @param user  用户
	 * @param voteItem 投票项
	 * @param voteManager  投票上下文，用来在实现状态对应的功能处理的时候，
     *                         可以回调上下文的数据
	 */
	public void vote(String user,String voteItem,VoteManager voteManager);
}
