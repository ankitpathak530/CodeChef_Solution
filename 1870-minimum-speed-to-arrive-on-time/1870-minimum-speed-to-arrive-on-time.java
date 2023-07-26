class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
           
           int left = 1;
           int right = 100000000;
            
           int result = -1;
        
           while(left <= right){
               
               int minSpeed = left + (right-left)/2;
               
               if(possibleTimeToTravelInMinSpeed(dist, minSpeed) <= hour){
                   result = minSpeed;
                   right = minSpeed-1;
               }
               else{
                   left = minSpeed+1;
               }
           }
        
        return result;
    }
    
    private double possibleTimeToTravelInMinSpeed(int[] dist, int minSpeed){
        int n = dist.length;
        
        double time = 0.0;
        
        for(int i=0; i<n-1; i++){
            double t = (double)dist[i]/(double)minSpeed;
            time += Math.ceil(t);
        }
        
        time += (double)dist[n-1]/(double)minSpeed;
        
        return time;
    }
}