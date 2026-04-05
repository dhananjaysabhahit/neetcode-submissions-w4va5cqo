class Solution {
    public boolean isHappy(int n) {
        // approch 1
        // int slow=n, fast=n;
        // while(fast!=1){
        //     slow = findDigitSquareSum(slow);
        //     fast = findDigitSquareSum(findDigitSquareSum(fast));
        //     if(slow==fast && slow!=1){
        //         return false;
        //     }
        // }
        // return true;


        // approach 2 hashset
        // Set<Integer> visit = new HashSet();
        // int tempn = n;
        // while(!visit.contains(tempn)){
        //     if(tempn==1){
        //         return true;
        //     }
        //     visit.add(tempn);
        //     tempn = findDigitSquareSum(tempn);
        // }
        // return false;

        //approach 3 recursion
        int sum=0;
        if(n==1 || n==7)
            return true;
        else if(n<10)
            return false;
        else{
            while(n!=0){
                int rem = n%10;
                sum+=rem*rem;
                n=n/10;
            }
        }
        return isHappy(sum);
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
