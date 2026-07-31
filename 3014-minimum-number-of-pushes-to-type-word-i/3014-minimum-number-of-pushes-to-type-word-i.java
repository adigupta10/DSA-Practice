class Solution {
    public int minimumPushes(String word) {
        int sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int assign_key=2;
        for(int i=0;i<word.length();i++){
            if(assign_key>9){
                assign_key=2;
            }
            map.put(assign_key,map.getOrDefault(assign_key,0)+1);
            sum+=map.get(assign_key);
            assign_key++;
        }
        return sum;
    }
}