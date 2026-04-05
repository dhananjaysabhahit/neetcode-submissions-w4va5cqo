class MedianFinder {
    int size=0;
    PriorityQueue<Integer> minpq;
    PriorityQueue<Integer> maxpq;

    public MedianFinder() {
        minpq= new PriorityQueue<>();
        maxpq= new PriorityQueue<>((a,b)->b-a);
    }
    
    public void addNum(int num) {
        size++;
        if(size==1)
            maxpq.add(num);
        else if(isEven(size)){
            maxpq.add(num);
            minpq.add(maxpq.poll());
        } else if(!isEven(size)){
            if(num<=maxpq.peek()){
                maxpq.add(num);
            } else{
                minpq.add(num);
                maxpq.add(minpq.poll());
            }
        } 
    }
    
    public double findMedian() {
        System.out.println(minpq);
        System.out.println(maxpq);
        if(isEven(size)){
            return (double)(minpq.peek()+maxpq.peek())/2;
        } else{
            return maxpq.peek();
        }
    }

    public boolean isEven(int size){
        return size%2==0;
    }
}
