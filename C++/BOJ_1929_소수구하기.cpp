#include <iostream>
bool memo[10000001];
int main() {
    int N, M;
    scanf("%d %d", &N, &M);

    memo[1] = true;  // 1은 소수가 아니다.
    for (int i = 2; i <= M; i++) {
        if (memo[i]) {  // 자연수 i가 어떤 소수의 배수인 경우
            continue;
        }

        int temp = i + i;  // 소수 i의 배수 찾기
        while (temp <= M) {
            memo[temp] = true;
            temp += i;
        }
    }

    for (int i = N; i <= M; i++) {
        if (!memo[i]) {
            printf("%d\n", i);
        }
    }
    return 0;
}