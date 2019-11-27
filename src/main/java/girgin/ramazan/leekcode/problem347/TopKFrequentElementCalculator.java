package girgin.ramazan.leekcode.problem347;

import java.util.*;

class TopKFrequentElementCalculator {
    public List<Integer> calculate(int[] nums, int k) {
        Map<Integer, Integer> countsMap = initializeCountMap(nums);
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = loadQueue(countsMap);
        return retrieveTopK(k, priorityQueue);
    }

    private Map<Integer, Integer> initializeCountMap(int[] nums) {
        //could be written with stream api - groupingBy, counting()
        // but this way is more efficient
        Map<Integer, Integer> countsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (countsMap.containsKey(num)) {
                countsMap.put(num, countsMap.get(num) + 1);
            } else {
                countsMap.put(num, 1);
            }
        }
        return countsMap;
    }

    private PriorityQueue<Map.Entry<Integer, Integer>> loadQueue(Map<Integer, Integer> countsMap) {
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(countsMap.entrySet().size(), (e1, e2) -> e2.getValue() - e1.getValue());
        priorityQueue.addAll(countsMap.entrySet());
        return priorityQueue;
    }

    private List<Integer> retrieveTopK(int k, PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue) {
        List<Integer> retList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (priorityQueue.isEmpty()) {
                break;
            }
            retList.add(priorityQueue.poll().getKey());
        }
        return retList;
    }
}
