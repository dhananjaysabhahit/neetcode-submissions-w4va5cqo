class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n=triplets.length;
        List<int[]> tlist = Arrays.stream(triplets).collect(Collectors.toCollection(ArrayList::new));
        if(n==1 && (triplets[0][0]!=target[0] || triplets[0][1]!=target[1] 
        || triplets[0][2]!=target[2])){
            return false;
        } else if(n==1){
            return true;
        }
        boolean a,b,c;
        a=b=c=false;
        Iterator<int[]> itr= tlist.iterator();

        while(itr.hasNext()){
            int[] cur = itr.next();
            if(cur[0]>target[0] || cur[1]>target[1] || cur[2]>target[2]){
                itr.remove();
            } else{
                if(cur[0]==target[0]) a=true;
                if(cur[1]==target[1]) b=true;
                if(cur[2]==target[2]) c=true;
            }
        }
        return a && b && c ? true:false;
    }
}
