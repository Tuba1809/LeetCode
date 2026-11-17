class UndergroundSystem {

    Map<Integer, Object[]> checkInMap;
    Map<String, int[]> journeyMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        journeyMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Object[]{stationName, t});
    }

    public void checkOut(int id, String stationName, int t) {

        Object[] checkIn = checkInMap.get(id);

        String startStation = (String) checkIn[0];
        int startTime = (int) checkIn[1];

        int travelTime = t - startTime;

        String route = startStation + "->" + stationName;

        journeyMap.putIfAbsent(route, new int[]{0, 0});

        int[] data = journeyMap.get(route);

        data[0] += travelTime;
        data[1]++;

        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {

        String route = startStation + "->" + endStation;

        int[] data = journeyMap.get(route);

        return (double) data[0] / data[1];
    }
}


/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */