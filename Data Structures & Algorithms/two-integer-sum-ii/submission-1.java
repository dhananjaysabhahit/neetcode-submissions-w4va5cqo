class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //approach 1
        // Map<Integer,Integer> map = new HashMap<>();

        // for(int i=0;i<numbers.length;i++){
        //     if(map.containsKey(target-numbers[i])){
        //         int index=map.get(target-numbers[i]);
        //         if(i<index){
        //             return new int[]{i+1,index+1};
        //         } else {
        //             return new int[]{index+1,i+1};
        //         }
        //     }
        //     map.putIfAbsent(numbers[i],i);
        // }
        // return new int[0];

        //approach 2
        int n = numbers.length;
        int left=0, right=n-1;
        while(left<right){
            int sum = numbers[left]+numbers[right];
            if(sum==target){
                return new int[]{left+1,right+1};
            } else if(sum<target){
                left++;
            } else{
                right--;
            }
        }
        return new int[0];
    }
}
