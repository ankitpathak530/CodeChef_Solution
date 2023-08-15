class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String res = countAndSay(n - 1);

        StringBuilder finalRes = new StringBuilder();
        char pch = res.charAt(0);
        int count = 1;

        for (int i = 1; i < res.length(); i++) {
            char ch = res.charAt(i);

            if (pch == ch) {
                count++;
            } else {
                finalRes.append(count).append(pch);
                count = 1;
                pch = ch;
            }
        }

        finalRes.append(count).append(pch);
        return finalRes.toString();
    }
}
