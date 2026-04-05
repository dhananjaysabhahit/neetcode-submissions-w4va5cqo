class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n=position.length;
        if(n<=1){
            return n;
        }

        List<int[]> cars = new ArrayList<>();
        for(int i=0;i<n;i++){
            
            cars.add(new int[]{position[i],speed[i]});
        }
        cars.sort((a,b)->{
            return Integer.compare(b[0],a[0]);
        });
        Stack<Float> st = new Stack<>();


        for(int i=0;i<n;i++){
            float time = (float)(target - cars.get(i)[0])/(float)cars.get(i)[1];
            if(st.isEmpty() || time>st.peek())
                st.push(time);
        }
        return st.size();
    }
}
