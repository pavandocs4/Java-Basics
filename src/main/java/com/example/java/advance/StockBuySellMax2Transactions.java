package com.example.java.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class StockBuySellMax2Transactions {
	public static void main(String[] args) {
		int[] prices = {90, 80, 70, 60, 50, 100, 40, 200, 10, 100};
		List<Integer> transactions = new ArrayList<>();
		
		int buyPrice=0;
		int profit=0;
		
		//IntStream.range(0, prices.length).map(k -> prices[k])
	//	int counter=0;
		for(int i=0;i<prices.length-1;i++) {
		//	for(int j=i+1; j < prices.length-1; j++) {
				boolean buy = prices[i] < prices[i+1];
				if(buy && buyPrice==0) {
					buyPrice=prices[i];  //10
				} else if(!buy && buyPrice > prices[i+1]) {
					profit= profit+prices[i]-buyPrice;
					transactions.add(prices[i]-buyPrice);
					buyPrice=prices[i+1];
					
				}
			//}
		}
		
		if(buyPrice< prices[prices.length-1] && buyPrice!=0) {
			profit=profit+prices[prices.length-1]-buyPrice;
			transactions.add(prices[prices.length-1]-buyPrice);
		}
		int prof=transactions.stream().sorted((a,b) -> b-a).limit(2).reduce(0, (c,d)-> c+d);
		
		//int profitSt = profByStream(prices);
		System.out.println(transactions);
		System.out.println(prof);
		
		
		
	}

}
