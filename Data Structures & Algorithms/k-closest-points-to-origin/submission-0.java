
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> pq= new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
        for(int[] point: points){
            double dist = Math.sqrt(Math.pow(point[0],2)+Math.pow(point[1],2));
            pq.add(new double[]{dist,point[0],point[1]});
            if(pq.size()>k)
                pq.poll();
        }
        int[][] res=new int[pq.size()][2];
        
        int i=0;
        while(!pq.isEmpty()){
            double[] point = pq.poll();
            res[i][0]=(int)point[1];
            res[i][1]=(int)point[2];
            i++;
        }

        return res;
    }
}
