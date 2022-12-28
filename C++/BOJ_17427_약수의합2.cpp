#include <iostream>
using namespace std;

long long dp[1000001];
int main() {
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        int temp = i;
        while (temp <= n) {
            dp[temp] += i;
            temp += i;
        }
    }
    for (int i = 1; i <= n; i++) {
        dp[i] += dp[i - 1];
    }
    cout << dp[n] << endl;
    return 0;
}