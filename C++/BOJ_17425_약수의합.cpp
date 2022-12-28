#include <iostream>

long long dp[1000001];
int main() {
    int N = 1000000;
    for (int i = 1; i <= N; i++) {
        int temp = i;
        while (temp <= N) {
            dp[temp] += i;
            temp += i;
        }
    }

    for (int i = 1; i <= N; i++) {
        dp[i] += dp[i - 1];
    }

    int T;
    scanf("%d", &T);
    for (int tc = 0; tc < T; tc++) {
        int idx;
        scanf("%d", &idx);
        printf("%lld\n", dp[idx]);
    }

    return 0;
}