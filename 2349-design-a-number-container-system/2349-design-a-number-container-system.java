import java.util.*;

class NumberContainers {

    HashMap<Integer, Integer> map;
    HashMap<Integer, PriorityQueue<Integer>> pq;

    public NumberContainers() {
        map = new HashMap<>();
        pq = new HashMap<>();
    }
    
    public void change(int index, int number) {
        map.put(index, number);

        pq.putIfAbsent(number, new PriorityQueue<>());
        pq.get(number).offer(index);
    }
    
    public int find(int number) {
        if (!pq.containsKey(number)) {
            return -1;
        }

        PriorityQueue<Integer> q = pq.get(number);

        while (!q.isEmpty()) {
            int index = q.peek();

            if (map.get(index) == number) {
                return index;
            }

            q.poll();
        }

        return -1;
    }
}


/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */