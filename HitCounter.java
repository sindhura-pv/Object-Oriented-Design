import java.util.HashMap;
import java.io.*; 
import java.util.*; 

class HitCounter {
    
    HashMap<Integer, Integer> hits_so_far;
    ArrayList<Integer> hit_time;
    int total_hits;
    

    /** Initialize your data structure here. */
    public HitCounter() {
        
        this.hits_so_far = new HashMap<>();
        this.hit_time = new ArrayList<>();
        this.total_hits = 0;
        
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int time) {
        
        //this.hits.put(time, this.hits.getOrDefault(time, 0)+1);
        this.total_hits++;
        this.hits_so_far.put(time, this.total_hits);
        
        int n = this.hit_time.size(); 
        if (n==0 || this.hit_time.get(n-1) != time)
            this.hit_time.add(time);
                      
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int time) {
        
        if (time<=300)
            return this.total_hits;
        
        int i = this.hit_time.size()-1;
        int res = this.total_hits;
        
        while (i>=0 && (time-this.hit_time.get(i)) < 300 ){
            i -= 1;
        }
        
        if (i<0)
            return res;
        else{
            int prev_time = this.hit_time.get(i);
            return res - this.hits_so_far.get(prev_time);
        }
        
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
