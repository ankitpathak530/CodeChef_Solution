class Solution {
    public List<String> summaryRanges(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        List<String> result = new ArrayList<>();


        List<Integer> l = new ArrayList<>();
           
        for(int i=0; i<nums.length; i++){

            if(i == nums.length-1){
                l.add(nums[i]);
                list.add(l);
                break;
            }

            if(nums[i]+1 == nums[i+1]){
                 l.add(nums[i]);
             }else{
                 l.add(nums[i]);
                 list.add(l);
                 l = new ArrayList<>();
             } 
        }

        System.out.println(list);

        for(List<Integer> myList : list){
             if(myList.size() == 1){
                 result.add(myList.get(0)+"");
             }else{
                 result.add(myList.get(0) +"->"+ myList.get(myList.size()-1));
             }
        }

        return result;        
    }
}