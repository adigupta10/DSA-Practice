class Solution {
    public int totalFruit(int[] fruits) {
      int maxi=0;
      for(int i=0;i<fruits.length;i++){
        HashMap<Integer,Integer> map=new HashMap<>();
            for(int j=i;j<fruits.length;j++){
                map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
                if(map.size()<=2){
                    maxi=Math.max(maxi,j-i+1);
                }
                else{
                    break;
                }
            }
        }
        return maxi;
    }
}