package Day1;

public class array {

    public static void main(String[] args) {
        // Sample array inputs
        int arr[] = {4, 2, 0, 6, 3, 2, 5};
        int prices[] = {7, 1, 5, 6, 3, 4};

        // Uncomment the following to test individual functionalities

        // System.out.println("Maximum Subarray Sum (Brute Force): " + maxSubArraySum(arr));
        // System.out.println("Maximum Subarray Sum (Better 1): " + maxSubArraySum2(arr));
        // System.out.println("Maximum Subarray Sum (Prefix Sum): " + maxSubArraySum3(arr));
        // System.out.println("Maximum Subarray Sum (Kadane's Algorithm): " + kadaneAlgo(arr));
        // System.out.println("Trapped Rainwater: " + trappingRainwater(arr));
//        System.out.println("Maximum Profit from Stock: " + buyAndSellStock(prices));
    }

    // Prints all subarrays of the input array
    public static void subArrays(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    // Prints all pairs of the input array
    public static void pairs(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + ", " + arr[j] + ") ");
                count++;
            }
            System.out.println();
        }
        System.out.println("Total number of pairs: " + count);
    }

    // Utility method to print an array
    public static void printArr(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // 1. Maximum Subarray Sum using Brute Force
    public static int maxSubArraySum(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int currentSum = 0;
                for (int k = i; k <= j; k++) {
                    currentSum += arr[k];
                }
                max = Math.max(max, currentSum);
            }
        }
        return max;
    }

    // 2. Maximum Subarray Sum using Better Approach
    public static int maxSubArraySum2(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;
            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j];
                max = Math.max(max, currentSum);
            }
        }
        return max;
    }

    // 3. Maximum Subarray Sum using Prefix Sum
    public static int maxSubArraySum3(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = arr[i] + prefix[i - 1];
        }

        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int currentSum = (i == 0) ? prefix[j] : prefix[j] - prefix[i - 1];
                max = Math.max(max, currentSum);
            }
        }
        return max;
    }

    // 4. Maximum Subarray Sum using Kadane's Algorithm
    public static int kadaneAlgo(int[] arr) {
        int max = arr[0];
        int currentSum = 0;
        for (int value : arr) {
            currentSum = Math.max(value, currentSum + value);
            max = Math.max(max, currentSum);
        }
        return max;
    }

    // Trapping Rainwater Problem
    public static int trappingRainwater(int[] arr) {
        int n = arr.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int water = 0;

        // Compute left max boundary
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        // Compute right max boundary
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        // Calculate trapped water
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }
        return water;
    }

    // Buy and Sell Stock Problem
    public static int buyAndSellStock(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }
}
