class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((x1,x2) -> x2-x1);

        for (Integer integ : stones){
            pQueue.offer(integ);
        }

        while (pQueue.size()>1){
            int firstStone = pQueue.poll();
            int secondStone = pQueue.poll();
            if (firstStone==secondStone) continue;
            pQueue.offer(Math.abs(firstStone-secondStone));
        }
        return pQueue.size() == 0 ? 0 : pQueue.poll();
    }
}