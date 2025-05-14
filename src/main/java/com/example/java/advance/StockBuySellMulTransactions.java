package com.example.java.advance;

import java.util.stream.IntStream;

public class StockBuySellMulTransactions {
	public static void main(String[] args) {
		int[] prices = {10, 22, 5, 75, 65, 80};;    //{100, 180, 260, 310, 40, 535, 695}; 12+
		
		int buyPrice=0;
		int profit=0;
		
		//IntStream.range(0, prices.length).map(k -> prices[k])
		
		for(int i=0;i<prices.length-1;i++) {
		//	for(int j=i+1; j < prices.length-1; j++) {
				boolean buy = toBuy(prices[i], prices[i+1]);
				if(buy && buyPrice==0) {
					buyPrice=prices[i];  //100
				} else if(!buy && buyPrice!=0) {
					profit= profit+prices[i]-buyPrice;
					buyPrice=prices[i+1];
				}
			//}
		}
		
		if(buyPrice< prices[prices.length-1])
			profit=profit+prices[prices.length-1]-buyPrice;
		
		int prof= getMaxProfit(prices);
		
		System.out.println(prof);
		
	}

	private static boolean toBuy(int a, int b) {
		// TODO Auto-generated method stub
		return b>a;
	}

	private static int getMaxProfit(int[] prices) {
		// TODO Auto-generated method stub
		return IntStream.range(0, prices.length-1).filter(i-> prices[i+1]>prices[i]).map(i-> prices[i+1]-prices[i]).sum();
	}


}
