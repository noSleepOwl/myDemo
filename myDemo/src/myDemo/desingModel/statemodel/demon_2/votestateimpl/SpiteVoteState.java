package myDemo.desingModel.statemodel.demon_2.votestateimpl;

import myDemo.desingModel.statemodel.demon_2.VoteManager;
import myDemo.desingModel.statemodel.demon_2.VoteState;

public class SpiteVoteState implements VoteState {

	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		String str  =  voteManager.getMapVote().get(user);
		if(str != null){
			voteManager.getMapVote().remove(user);
		}
		System.out.println("___die die die go die");
	}

}
