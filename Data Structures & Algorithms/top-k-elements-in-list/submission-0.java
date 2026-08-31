class Element implements Comparable<Element> {

    int key;
    int freq;

    public Element(int key , int freq){
        this.key = key;
        this.freq = freq;
    }

    @Override
    public int compareTo(Element o){
        return  o.freq - this.freq;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        PriorityQueue<Element> queue = new PriorityQueue<Element>();
        int ans[] = new int[k];

        for (int index = 0; index < nums.length; index++){

            freqMap.put(nums[index], freqMap.getOrDefault(nums[index], 0)+1);
        }

        for (int key: freqMap.keySet()){

            int value = freqMap.get(key);
            queue.add(new Element(key, value));
        }

        for (int pos = 0; queue.size() > 0 && pos < k ; pos++){
            ans[pos] = queue.poll().key;
        }

        return ans;
    }
}
