class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    //     approach 3 - bucket sort
    //     Map<Integer,Integer> map = new HashMap();
    //     for(int num : nums){
    //         map.put(num,map.getOrDefault(num,0)+1);
    //     }

    //     List<Integer>[] freq = new List[nums.length+1];
    //     for(int i=0;i<freq.length;i++){
    //         freq[i]=new ArrayList();
    //     }

    //     for(Map.Entry<Integer,Integer> entry: map.entrySet()){
    //         freq[entry.getValue()].add(entry.getKey());
    //     }

    //     int[] res = new int[k];
    //     int index=0;
    //     for(int i=freq.length-1;i>=0;i--){
    //         for(Integer num: freq[i]){
    //             res[index++]=num;
    //             if(index==k){
    //                 return res;
    //             }
    //         }
    //     }
    //     return res;

        // approach 2 - sorting
        Map<Integer, Integer> count = new HashMap();
        for(int num: nums){
            count.put(num,count.getOrDefault(num,0)+1);
        }

        List<int[]> list  = new ArrayList();
        for(Map.Entry<Integer,Integer> entry: count.entrySet()){
            list.add(new int[]{entry.getValue(),entry.getKey()});
        }
        list.sort((a,b)->b[0]-a[0]);
        
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = list.get(i)[1];
        }
        return res;
    }
}
