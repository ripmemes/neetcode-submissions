class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] out = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (Integer i : nums) {
            map.put(i,map.getOrDefault(i,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a,b)->b.getValue().compareTo(a.getValue()));

        maxHeap.addAll(map.entrySet());

        for (int i = 0 ; i < k ;i++) {
            out[i] = maxHeap.poll().getKey();
        }
        return out;
    }
}
