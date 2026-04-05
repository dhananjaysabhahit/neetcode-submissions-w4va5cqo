class Solution {
    public int lengthOfLongestSubstring(String s) {
        // int maxlen=0,curlen =0;
        // int left=0;
        // Map<Character,Integer> map = new HashMap();
        // for(int i=0;i<s.length();i++){
        //     char c=s.charAt(i);
        //     while(map.containsKey(c)){
        //         char d=s.charAt(left);
        //         map.remove(Character.valueOf(d));
        //         left++;
        //     }
        //     map.put(c,1);
        //     maxlen = Math.max(maxlen,i-left+1);
        
        // }
        // return maxlen;

        Set<Character> set = new HashSet<>();
        int left=0;
        int right=0;
        int res=0;
        while(right<s.length()){
            char c= s.charAt(right);
            while(set.contains(c)){
                char d = s.charAt(left);
                set.remove(d);
                left++;
            }
            res= Math.max(res,right-left+1);
            set.add(c);
            right++;
        }
        return res;
    }
}
