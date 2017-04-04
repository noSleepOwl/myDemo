package myDemo.desingModel.statemodel.demon_2.test;

import myDemo.desingModel.statemodel.demon_2.VoteManager;

public class test {
	public static void main(String[] args) {
		VoteManager vm = new VoteManager();
		for(int i = 0 ; i<99 ; i++)
		{
			vm.vote("gg", "bb");
		}
	}
}
