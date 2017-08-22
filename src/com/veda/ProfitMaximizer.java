package com.veda;

public class ProfitMaximizer {
	public static void main(String[] args) {
		try {
			int[] stockPricesYesterday = new int[] {10, 7, 5, 8, 11, 9};
			System.out.println("Max profit: " + getMaxProfit(stockPricesYesterday));
		} catch(ProfitMaximizerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	static int getMaxProfit(int[] stockPricesFromYesterday) 
		throws ProfitMaximizerException {
		if(stockPricesFromYesterday == null || stockPricesFromYesterday.length < 1) {
			throw new ProfitMaximizerException("The input array's length needs to be at least 2.");
		}
		int minPrice = Math.min(stockPricesFromYesterday[0], stockPricesFromYesterday[1]);
		int maxPrice = Math.max(stockPricesFromYesterday[0], stockPricesFromYesterday[1]);
		
		int maxProfit  = maxPrice - minPrice;
		
		if(stockPricesFromYesterday.length == 2) {
			return maxProfit;
		}
		
		for(int index = 2; index < stockPricesFromYesterday.length; index++) {
			minPrice = Math.min(minPrice, stockPricesFromYesterday[index]);
			maxPrice = Math.max(maxPrice, stockPricesFromYesterday[index]);
			
			maxProfit = Math.max(maxProfit, maxPrice - minPrice);
		}
		
		return maxProfit;
	}
	
	static class ProfitMaximizerException extends Exception {
		ProfitMaximizerException() {
			super();
		}
		
		ProfitMaximizerException(String message) {
			super(message);
		}
	}
}
