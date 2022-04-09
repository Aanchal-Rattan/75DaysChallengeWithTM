class Solution {
    //smaller on left
     public static int[] leftSmaller(int[] arr) {
     int n = arr.length;
     int[] res = new int[n];
     Stack<Integer> st = new Stack<>();
     st.push( n - 1); // stack hold index of values
     for(int i = n - 2; i >= 0; i--) {
         // pop smaller value from stack and mark their next greater
         while(st.size() > 0 && arr[st.peek()] > arr[i]) {
             int indx = st.pop();
             res[indx] = i; // place value in res
         }
         st.push(i);
     }
     while(st.isEmpty() != true) {
         res[st.pop()] = -1;
     }
     return res;
     }
 
     //smaller on right
  public static int[] rightSmaller(int[] arr) {
     int n = arr.length;
     int[] res = new int[n];
     Stack<Integer> st = new Stack<>();
     st.push(0); // stack hold index of values
     for(int i = 1; i < n; i++) {
         // pop smaller value from stack and mark their next greater
         while(st.size() > 0 && arr[st.peek()] > arr[i]) {
             int indx = st.pop();
             res[indx] = i; // place value in res
         }
         st.push(i);
     }
     while(st.isEmpty() != true) {
         res[st.pop()] = n;
     }
     return res;
 }
 
 public int largestRectangleArea(int[] heights) {
     
     int left[] = leftSmaller(heights);
     int right[]= rightSmaller(heights);
     
     
     int max=0;
     for(int i=0;i<heights.length ;i++){
         max = Math.max(max, (right[i]-left[i]-1)*heights[i] );
     }
     return max;
 }
}