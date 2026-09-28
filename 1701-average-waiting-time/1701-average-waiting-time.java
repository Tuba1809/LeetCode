class Solution {
    public double averageWaitingTime(int[][] customers) {
        long finishTime = 0;
        long totalWaiting = 0;
        for (int[] customer : customers) {
            int arrival = customer[0];
            int time = customer[1];
            finishTime = Math.max(finishTime, arrival);
            finishTime += time;
            totalWaiting += finishTime - arrival;
        }
        return (double) totalWaiting / customers.length;
    }
}