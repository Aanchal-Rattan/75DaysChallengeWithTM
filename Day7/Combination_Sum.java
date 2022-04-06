class Solution 
{
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        List<List<Integer>> ans=new ArrayList<>();//to store all the combinations
        ArrayList<Integer> temp=new ArrayList<>();//to store each combination
        sum(ans,0,target,candidates,temp);
        return ans;
    }
    public void sum(List<List<Integer>> ans, int i,int target,int[] arr, ArrayList<Integer> temp)
    {
        if(i==arr.length)
        {
            if(target==0)
                ans.add(new ArrayList<>(temp));
            return;
        }
        if(arr[i]<=target)
        {
            temp.add(arr[i]);
            sum(ans,i,target-arr[i],arr,temp);
            temp.remove(temp.size()-1);
        }
        sum(ans,i+1,target,arr,temp);
    }
}