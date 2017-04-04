package myDemo.desingModel.statemodel.demon_2.votestateimpl;

import myDemo.desingModel.statemodel.demon_2.VoteManager;
import myDemo.desingModel.statemodel.demon_2.VoteState;

/**
 * 重复投票的状态类
 * @author uigsw
 *
 */
public class RepeatVoteState implements VoteState {

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		System.out.println("please not repeat vote");
	}

}
