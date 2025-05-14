package com.example.java.advance;

import java.util.ArrayList;
import java.util.List;

public class StockBuySellMaxKTransWithMaxProfit {
	public static void main(String[] args) {
		int k =1;
		int[] prices = {90, 80, 70, 60, 50};
		int buyPrice = 0;
		int profit=0;
		List<Integer> transactions = new ArrayList<>();
		for(int i=0; i< prices.length -1; i++) {
			boolean isBuy= prices[i]< prices[i+1];
			if(isBuy && buyPrice ==0) {
				buyPrice = prices[i];
			}
			else if(!isBuy && buyPrice > prices[i+1] && buyPrice > 0) {
				transactions.add(prices[i] - buyPrice);
				buyPrice = prices[i+1];
			}
		}
		
		if(buyPrice< prices[prices.length-1] && buyPrice>0) {
			transactions.add(prices[prices.length-1] - buyPrice);
		}
		
		System.out.println(transactions);
		
		int prof= transactions.stream().sorted((a,b) -> b-a).limit(k).reduce(0, (a,b) -> a+b);
		
		System.out.println(prof);
		
	}


}
