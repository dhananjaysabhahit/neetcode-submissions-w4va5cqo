class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1map = new int[26];
        int[] wmap = new int[26];
        int n2= s2.length();
        int n1= s1.length();

        if(n2<n1)
            return false;

        char a = 'a';
        for(int i=0;i<n1;i++){
            char d= s1.charAt(i);
            s1map[d - a]++;

            char c=s2.charAt(i);
            wmap[c-a]++;
        }
        int matches=0,target=26;

        for(int i=0;i<26;i++){
            if(s1map[i]==wmap[i]){
                matches++;
            }
        }


        for(int i=n1;i<n2;i++){
            if(matches==target)
                return true;
            char c= s2.charAt(i);
            wmap[c-a]++;
            if(wmap[c-a]==s1map[c-a])
                matches++;
            else if(wmap[c-a]==s1map[c-a]+1)
                matches--;

            char d= s2.charAt(i-n1);
            wmap[d-a]--;
            if(wmap[d-a]==s1map[d-a])
                matches++;
            else if(wmap[d-a]==s1map[d-a]-1)
                matches--;
        }

        return matches==target?true:false;
    }
}
