class Solution {
    public boolean isPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        while(left<right){
            char c=Character.toLowerCase(s.charAt(left));
            char d = Character.toLowerCase(s.charAt(right));
            while(!Character.isLetterOrDigit(c) && left<right){
                left++;
                c=Character.toLowerCase(s.charAt(left));
            }
            while(!Character.isLetterOrDigit(d) && left<right){
                right--;
                d=Character.toLowerCase(s.charAt(right));
            } 
            if(c==d){
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
