package myDemo.desingModel.statemodel.demon_2;

import java.util.HashMap;
import java.util.Map;
import myDemo.desingModel.statemodel.demon_2.votestateimpl.*;

public class VoteManager {
	private VoteState  state= null;
	private Map<String, String>  mapVote = new HashMap<>();
	private Map<String, Integer> mapVoteCount = new HashMap<>();
	
	public Map<String, String> getMapVote() {
		return mapVote;
	}
	 public void vote(String user,String voteItem){
	        //1.为该用户增加投票次数
	        //从记录中取出该用户已有的投票次数
	        Integer oldVoteCount = mapVoteCount.get(user);
	        if(oldVoteCount == null){
	            oldVoteCount = 0;
	        }
	        oldVoteCount += 1;
	        mapVoteCount.put(user, oldVoteCount);
	        //2.判断该用户的投票类型，就相当于判断对应的状态
	        //到底是正常投票、重复投票、恶意投票还是上黑名单的状态
	        if(oldVoteCount == 1){
	            state = new NormalVoteState();
	        }
	        else if(oldVoteCount > 1 && oldVoteCount < 5){
	            state = new RepeatVoteState();
	        }
	        else if(oldVoteCount >= 5 && oldVoteCount <8){
	            state = new SpiteVoteState();
	        }
	        else if(oldVoteCount > 8){
	            state = new BlackVoteState();
	        }
	        //然后转调状态对象来进行相应的操作
	        state.vote(user, voteItem, this);
	    }
}
