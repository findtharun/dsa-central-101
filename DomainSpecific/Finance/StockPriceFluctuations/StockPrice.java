package DomainSpecific.Finance.StockPriceFluctuations;

import java.util.*;
// https://leetcode.com/problems/stock-price-fluctuation/
class StockPrice {
    int latestTime;
    // Store price of each stock at each timestamp.
    Map<Integer, Integer> timestampPriceMap;
    // Store stock prices in increasing order to get min and max price.
    TreeMap<Integer, Integer> priceFrequency;

    public StockPrice() {
        latestTime = 0;
        timestampPriceMap = new HashMap<>();
        priceFrequency = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        // Update latestTime to latest timestamp.
        latestTime = Math.max(latestTime, timestamp);

        // If same timestamp occurs again, previous price was wrong.
        if (timestampPriceMap.containsKey(timestamp)) {
            // Remove previous price.
            int oldPrice = timestampPriceMap.get(timestamp);
            /**
             * To handle the case where we will have same price at mutiple timestamp.
             * Ex: at time 1 and 2 price was 5
             * time:1 price:5
             * time: 2 price:5
             * Now we get update price to 6 at time 1,
             * time: 1 , price:6
             * time: 2 , price 5.
             * If we don't keep frequency we will loss time 2 data
             */
            priceFrequency.put(oldPrice, priceFrequency.get(oldPrice) - 1);

            // Remove the entry from the map.
            if (priceFrequency.get(oldPrice) == 0) {
                priceFrequency.remove(oldPrice);
            }
        }

        // Add latest price for timestamp.
        timestampPriceMap.put(timestamp, price);
        priceFrequency.put(price, priceFrequency.getOrDefault(price, 0) + 1);
    }

    public int current() {
        // Return latest price of the stock.
        return timestampPriceMap.get(latestTime);
    }

    public int maximum() {
        // Return the maximum price stored at the end of sorted-map.
        return priceFrequency.lastKey();
    }

    public int minimum() {
        // Return the maximum price stored at the front of sorted-map.
        return priceFrequency.firstKey();
    }
}