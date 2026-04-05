class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(target-numbers[i])){
                int index=map.get(target-numbers[i]);
                if(i<index){
                    return new int[]{i+1,index+1};
                } else {
                    return new int[]{index+1,i+1};
                }
            }
            map.putIfAbsent(numbers[i],i);
        }
        return new int[0];
    }
}
