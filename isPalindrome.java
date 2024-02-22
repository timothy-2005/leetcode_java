public class isPalindrome{
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }else if (x == 0){
            return true;
        }
        int cnt = 0;
        long test = x;
        long div = 1;
        while (test > 0){
            test = x;
            test = test / div;
            div = div * 10;
            cnt++;
        }
        cnt--;
        if (cnt == 1){
            return true;
        }
        int[] a = new int[cnt];
        int test2 = x;
        for (int i = 0; i < cnt; i++){
            a[i] = test2 % 10;
            test2 = test2 / 10;
        }
        int cnt2 = cnt;
        if (cnt % 2 == 0){
            cnt = cnt / 2;
        }else {
            cnt = cnt / 2 + 1;
        }
        boolean[] result = new boolean[cnt];
        for(int i = 0; i < cnt; i++){
            if (a[i] == a[cnt2 - i - 1]){
                result[i] = true;
            }else{
                result[i] = false;
            }
        }
        for (boolean y : result){
            if (y == false){
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome_solution(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }
}

//https://leetcode.cn/problems/palindrome-number/
//时间复杂度O(log(n))
//空间复杂度O(1)