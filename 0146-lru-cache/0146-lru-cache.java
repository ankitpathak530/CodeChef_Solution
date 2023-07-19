class LRUCache {
    
    LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;        

    }
    
    public int get(int key) {
          
         if(map.containsKey(key)){
             int val = map.get(key);
             map.remove(key);
             map.put(key, val);
             return val;
         }
        return -1;
    }
    
    public void put(int key, int value) {
         
         if(map.containsKey(key)){ //if key is already available just remove from previous position and insert them in last.
             map.remove(key);
             map.put(key, value);
         }
         else if(map.size() < this.capacity){//if we have sufficient capacity to insert element to the map then just add it.
             map.put(key,value);
         }
         else{//if size of map is out of capacity then first remvoe least use element then add new element.
             int firstKey = map.entrySet().stream().findFirst().get().getKey();
             map.remove(firstKey);
             map.put(key,value);
         }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */