class Solution {
    public List<Integer> grayCode(int n) {
        List<String> stans = new ArrayList<>();
        stans = genCode(n);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < stans.size(); i++)
            ans.add(Integer.parseInt(stans.get(i), 2));
        return ans;
    }

    public List<String> genCode(int n) {
        List<String> xd = new ArrayList<>();
        if (n == 1) {
            xd.add("0");
            xd.add("1");
            return xd;
        }
        List<String> temp = genCode(n - 1);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < temp.size(); i++)
            ans.add("0" + temp.get(i));
        for (int i = temp.size() - 1; i >= 0; i--)
            ans.add("1" + temp.get(i));
        return ans;

    }
}