class Solution {
    //simple swp fn
    public void swap(int i, int n, int[]nums ){
        int temp = nums[i];
        nums[i] = nums[n];
        nums[n] =temp;
    }
    // swap every value of array to get permuatation
    public void helper(int[] nums, int n, List<List<Integer>> ans ){
        if(n == nums.length  ){
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<nums.length ;i++){
                temp.add(nums[i] );
            }
            ans.add(temp);
            return;
        }
        
        for(int i= n ;i< nums.length; i++){
            swap(i,n,nums );
            helper(nums,n+1,ans );
            swap(i,n,nums);
        }
        return;
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,0, ans  );
        return ans;
    }
}