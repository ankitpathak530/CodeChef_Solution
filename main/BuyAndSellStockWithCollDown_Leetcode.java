package main;

public class BuyAndSellStockWithCollDown_Leetcode {

	   public int maxProfit(int[] prices) {
		   
	        int buy = - prices[0];
	        int sell = 0;
	        int coolDown = 0;

	        for(int i = 1; i < prices.length; i++) 
	        {
	            int preBuy = buy;
	            int preSell = sell;
	            int preCoolDown = coolDown;
	            
	            buy = Math.max(preBuy, preCoolDown - prices[i]);
	            sell = Math.max(preSell, preBuy + prices[i]);
	            coolDown = Math.max(preCoolDown, preSell);
	        }
	    return sell;
	    }
}
