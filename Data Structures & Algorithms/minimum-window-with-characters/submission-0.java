class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tmap = new HashMap();
        Map<Character, Integer> smap = new HashMap();

        if(s == "")
            return "";

        for(char c: t.toCharArray()){
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }

        int left=0, minWindowLength=Integer.MAX_VALUE;
        int target = t.length();
        int cnt=0;
        String res ="";
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            smap.put(c,smap.getOrDefault(c,0)+1);
            if(tmap.containsKey(c) && smap.get(c)<=tmap.get(c)){
                cnt++;
            } 
            while(cnt==target){
                if(minWindowLength>i-left+1){
                    res = s.substring(left,i+1);
                    minWindowLength = i-left+1;
                }
                char d = s.charAt(left);
                smap.put(d,smap.get(d)-1);
                left++;
                if(tmap.containsKey(d) && smap.get(d)<tmap.get(d)){
                    cnt--;
                }
            }
    
        }
        return res;
    }
}
