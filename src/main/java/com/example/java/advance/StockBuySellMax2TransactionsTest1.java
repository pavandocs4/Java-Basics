package com.example.java.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StockBuySellMax2TransactionsTest1 {
	// int[] prices = {90, 80, 70, 60, 50, 100, 40, 200, 300, 10, 100};

	// at a b>a then -> buy , a>b && b>c sell if exists,

	public static void main(String[] args) {
		int[] prices = { 90, 80, 70, 60, 50, 100, 40, 200, 10, 100 };
		List<Integer> trans = new ArrayList<>();
		// trans = getAllTransaction(prices);
		trans = getAllTransactionByStreams(prices);
		int profit = trans.stream().sorted((a, b) -> b - a).limit(2).collect(Collectors.summingInt(val -> val));
		System.out.println("Max prof:" + profit);
	}

	private static List<Integer> getAllTransactionByStreams(int[] prices) {
		List<Integer> allTrans = new ArrayList<>();
		final int[] buy = { 0 }; // use array to mutate inside lambda

		IntStream.range(0, prices.length).forEach(i -> {
			if (buy[0] != 0 && buy[0] < prices[i]) {
				allTrans.add(prices[i] - buy[0]);
				buy[0] = 0;
			} else if (i + 1 < prices.length && prices[i + 1] > prices[i]) {
				buy[0] = prices[i];
			}
		});

		System.out.println(allTrans);
		return allTrans;

	}

	private static List<Integer> getAllTransaction(int[] prices) {
		// TODO Auto-generated method stub
		int buy = 0;
		int sell = 0;
		List<Integer> allTrans = new ArrayList<>();

		// int[] prices = {90, 80, 70, 60, 50, 100, 40, 200, 10, 100};
		for (int i = 0; i < prices.length; i++) {
			if (buy != 0 && buy < prices[i]) {
				allTrans.add(prices[i] - buy);
				buy = 0;
			} else if (i + 1 < prices.length && prices[i + 1] > prices[i]) {
				buy = prices[i];
			}
		}
		System.out.println(allTrans);
		return allTrans;
	}

}
