package myDemo.desingModel.statemodel.demon_2.votestateimpl;

import myDemo.desingModel.statemodel.demon_2.VoteManager;
import myDemo.desingModel.statemodel.demon_2.VoteState;

/**
 * 正常的投票状态
 * @author uigsw
 *
 */
public class NormalVoteState implements VoteState {

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		voteManager.getMapVote().put(user, voteItem);
		System.out.println("vote success");
	}

}
