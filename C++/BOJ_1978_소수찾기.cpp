#include <iostream>
bool memo[1001];
int main() {
    memo[1] = true;  // 1은 소수가 아니다.
    for (int i = 2; i <= 1000; i++) {
        if (memo[i]) {  // 자연수 i가 어떤 소수의 배수인 경우
            continue;
        }

        int temp = i + i;  // 소수 i의 배수 찾기
        while (temp <= 1000) {
            memo[temp] = true;
            temp += i;
        }
    }
    
    int n, ans = 0;
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        int temp;
        scanf("%d", &temp);
        if (!memo[temp]) {
            ans++;
        }
    }
    printf("%d\n", ans);
}