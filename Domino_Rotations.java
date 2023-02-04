//Time complexity is 4*O(N) N is length of tops or bottoms
//space complexity is O(1)
class Solution {
    int result = Integer.MAX_VALUE;
    public int minDominoRotations(int[] tops, int[] bottoms) {
        helper(tops, bottoms, tops[0]);
        helper(tops, bottoms, bottoms[0]);
        helper(bottoms, tops, bottoms[0]);
        helper(bottoms, tops, tops[0]);
        return result==Integer.MAX_VALUE?-1:result;
    }
    public void helper(int[] arr1, int[] arr2, int n){
        int count =0;
        int len= arr1.length;
        for(int i=0;i<len;i++){
            if(arr1[i]!=n){
                if(arr2[i]==n){
                    count=count+1;
                }
                else{
                    return;
                }
            }
        }
        result=Math.min(result, count);
    }
}