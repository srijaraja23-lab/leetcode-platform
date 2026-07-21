class Solution {
    public int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            int digit = x % 10;
            x = x / 10;

            // Check for overflow
            if (rev > Integer.MAX_VALUE / 10 ||
               (rev == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            // Check for underflow
            if (rev < Integer.MIN_VALUE / 10 ||
               (rev == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            rev = rev * 10 + digit;
        }

        return rev;
    }
}
Dry Run
Example 1

Input:

x = 123
x	digit	rev
123	3	3
12	2	32
1	1	321
0	-	321

Output:

321
Example 2

Input:

x = -123
x	digit	rev
-123	-3	-3
-12	-2	-32
-1	-1	-321
0	-	-321

Output:

-321
Example 3

Input:

x = 120
x	digit	rev
120	0	0
12	2	2
1	1	21
0	-	21

Output:

21
Time Complexity
O(log₁₀ n) — One iteration for each digit.
Space Complexity
O(1) — Uses only a few integer variables.
Interview Tip

The interviewer will usually expect you to:

Use modulo (%) to get the last digit.
Use division (/) to remove the last digit.
Check for overflow before rev = rev * 10 + digit.

This is the optimal Java solution accepted on LeetCode.
