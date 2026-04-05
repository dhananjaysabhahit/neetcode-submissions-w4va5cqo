class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen=0,curlen =0;
        int left=0;
        Map<Character,Integer> map = new HashMap();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            while(map.containsKey(c)){
                char d=s.charAt(left);
                map.remove(Character.valueOf(d));
                left++;
            }
            map.put(c,1);
            maxlen = Math.max(maxlen,i-left+1);
        
        }
        return maxlen;
    }
}
