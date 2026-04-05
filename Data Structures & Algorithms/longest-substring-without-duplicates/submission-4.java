class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen=0,curlen =0;
        int left=0;
        Set<Character> set = new HashSet();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            while(set.contains(c)){
                char d=s.charAt(left);
                set.remove(Character.valueOf(d));
                left++;
            }
            set.add(c);
            maxlen = Math.max(maxlen,i-left+1);
        
        }
        return maxlen;
    }
}
