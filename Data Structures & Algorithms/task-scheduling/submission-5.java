class Solution {
    public int leastInterval(char[] tasks, int n) {
        char[] freq= new char[26];
        for(char c: tasks){
            freq[c-'A']++;
        }
        PriorityQueue<int[]> maxpq= new PriorityQueue<>((a,b)->b[1]-a[1]);

        for(int i=0;i<26;i++){
            if(freq[i]>0)
                maxpq.offer(new int[]{i,freq[i]});
        }
        // Queue<int[]> q= new LinkedList<>();
        // while(!maxpq.isEmpty()){
        //     System.out.println(maxpq.peek()[0]+" "+maxpq.peek()[1]);
        //     q.add(maxpq.poll());
            
        // }
        

        int cnt=0;
        Queue<int[]> q1= new LinkedList<>();
        while(!maxpq.isEmpty()){            
            int[] cur= maxpq.poll();
            System.out.println((char)(cur[0]+'A'));
            cur[1]--;
            if(cur[1]!=0)
                q1.add(cur);
            cnt++;
            
            for(int i=0;i<n;i++){
                if(!maxpq.isEmpty()){
                    int[] incur= maxpq.poll();
                    System.out.println((char)(incur[0]+'A'));
                    incur[1]--;
                    if(incur[1]!=0)
                        q1.add(incur);
                    cnt++;
                } else if(q1.isEmpty() && maxpq.isEmpty())
                    break;
                else {cnt++;System.out.println("Idle");}
            }
            while(!q1.isEmpty()){
                maxpq.add(q1.poll());
            }
        }
        return cnt;
    }
}
