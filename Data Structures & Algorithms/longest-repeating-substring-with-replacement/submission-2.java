class Solution {
    public int characterReplacement(String s, int k) {
        int[] charArr = new int[26];
        int left=0, right=0, res=0;
        int n=s.length();
        int windowSize=0,repReq =0;
        char c ='a';
        int maxf = 0;
        while(right<n){
            c=s.charAt(right);
            charArr[c-'A']++;
            maxf = Math.max(maxf,charArr[c-'A']);
            windowSize = right-left+1;
            while(windowSize-maxf > k){
                char d = s.charAt(left);
                charArr[d-'A']--;
                left++;
                windowSize = right-left+1;
            }
        
            res = Math.max(res,windowSize);
            
            right++;
        }
        return res;
    }
}
