class Solution {
    public int minimumTotal(List<List<Integer>> t) {
        int n=t.size();
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                int mini=t.get(i).get(j) + Math.min(t.get(i+1).get(j),t.get(i+1).get(j+1));
               t.get(i).set(j,mini);
            }
        }
        return t.get(0).get(0);
    }
}




//  // List<List<Integer>> l=new ArrayList<>();
//         int n=t.size();
//         // for(List<Integer> x:t){
//         //     l.add(new ArrayList<>(x));
//         // }
//         // for(int i=0;i<n;i++){
//         //     l.add(new ArrayList<>(t.get(i)));
//         // }
//         for(int i=n-2;i>=0;i--){
//             for(int j=0;j<=i;j++){
//                 int mini=l.get(i).get(j) + Math.min(l.get(i+1).get(j),l.get(i+1).get(j+1));
//                l.get(i).set(j,mini);
//             }
//         }
//         return l.get(0).get(0);