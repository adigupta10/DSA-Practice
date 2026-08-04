class Solution {
    public int maxIceCream(int[] arr, int coins) {
        Arrays.sort(arr);
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(coins<arr[i]){
                return count;
            }
            coins-=arr[i];
            count++;
        }
        return count;
    }
}