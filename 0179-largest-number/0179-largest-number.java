class Solution {
    public String largestNumber(int[] nums) {
     ArrayList<String> l=new ArrayList<>();
     for(int i : nums){
        l.add(String.valueOf(i));
     }
      Collections.sort(l,(a,b)-> (b+a).compareTo(a+b));
      StringBuilder ans=new StringBuilder();
      StringBuilder res=new StringBuilder();
      for(String i : l){
        ans.append(i);
      }
    //   int j=0;
    //  while(ans.length()>1 && ans.charAt(0)=='0'){
    //     ans.deleteCharAt(0);
    //  }
    if(ans.charAt(0)=='0') return "0";
      return ans.toString();
    }
}