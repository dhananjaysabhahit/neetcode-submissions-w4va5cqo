class Solution {
    public String reorganizeString(String s) {
        int n= s.length();
        if(n==1)
            return s;
        int[] freq = new int[26];
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }

        PriorityQueue<int[]> maxpq= new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i=0;i<26;i++){
            if(freq[i]>0)
                maxpq.add(new int[]{i,freq[i]});
        }
        
        if(maxpq.peek()[1]>(s.length()+1)/2){
            return "";
        }

        StringBuilder sb =new StringBuilder();
        int[] prev=null;
        while(!maxpq.isEmpty()){
            int[] ele1 =maxpq.poll();
            System.out.println((char)(ele1[0]+'a'));
            sb.append((char)(ele1[0]+'a'));
            ele1[1]--;
            int[] ele2=null;
            if(!maxpq.isEmpty()){
                ele2 = maxpq.poll();
                sb.append((char)(ele2[0]+'a'));
                ele2[1]--;
                
            }
            if(ele1[1]>0)
                maxpq.add(ele1);
            if(ele2!=null && ele2[1]>0) 
                maxpq.add(ele2);
        }

        return sb.toString();
    }
}