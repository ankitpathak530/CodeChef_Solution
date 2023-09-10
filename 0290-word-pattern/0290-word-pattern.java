class Solution {
    public boolean wordPattern(String pattern, String s) {
          
          Map<Character,String> map = new HashMap<>();
          Set<String> set = new HashSet<>();

          char[] chArray = pattern.toCharArray();
          String[] sArray = s.split(" ");

          if(chArray.length != sArray.length) return false;

          for(int i=0; i<chArray.length; i++){
              if(map.containsKey(chArray[i])){
                  if(!map.get(chArray[i]).equals(sArray[i]))
                     return false;
              }else{
                  if(set.contains(sArray[i])) return false;
                  map.put(chArray[i], sArray[i]);
                  set.add(sArray[i]);
              }
          }
          return true;
    }
}