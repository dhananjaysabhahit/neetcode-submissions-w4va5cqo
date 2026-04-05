class Solution {
    public boolean isHappy(int n) {
        // approch 1
        // int slow=0, fast=0;
        // while(true){
        //     slow = findDigitSquareSum(n);
        //     fast = findDigitSquareSum(findDigitSquareSum(n));
        //     if(fast==1 || slow == 1){
        //         break;
        //     } else if(slow==fast){
        //         return false;
        //     }
        // }
        // return true;

        // approach 2 hashset
        Set<Integer> visit = new HashSet();
        int tempn = n;
        while(!visit.contains(tempn)){
            if(tempn==1){
                return true;
            }
            visit.add(tempn);
            tempn = findDigitSquareSum(tempn);
        }
        return false;
    }

    public int findDigitSquareSum(int n){
        int sum = 0;
        while(n!=0){
            int rem = n%10;
            sum+= rem*rem;
            n=n/10;
        }
        return sum;
    }
}
