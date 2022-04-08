class Solution {
    public static class Trans {
        String name, city;
        int time, amount;
    }

    public List<String> invalidTransactions(String[] transactions) {
        List<String> ans = new ArrayList<>();
        Trans[] arr = new Trans[transactions.length];
        for (int i = 0; i < transactions.length; i++) {
            Trans t = new Trans();
            String val[] = transactions[i].split(",");
            t.name = val[0];
            t.time = Integer.parseInt(val[1]);
            t.amount = Integer.parseInt(val[2]);
            t.city = val[3];
            arr[i] = t;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j)
                    continue;
                if (arr[i].name.equals(arr[j].name) && Math.abs(arr[i].time - arr[j].time) <= 60
                        && !arr[i].city.equals(arr[j].city)) {
                    ans.add(transactions[i]);
                    break;
                }
                if (arr[i].amount >= 1000) {
                    ans.add(transactions[i]);
                    break;
                }
            }
        }
        return ans;
    }
}