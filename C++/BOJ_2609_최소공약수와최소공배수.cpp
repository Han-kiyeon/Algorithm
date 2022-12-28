#include <iostream>

int gcd(int a, int b) {
    int r = a % b;
    if (r == 0) {
        return b;
    } else {
        return gcd(b, r);
    }
}

int main() {
    int a, b;
    scanf("%d", &a);
    scanf("%d", &b);

    if (a < b) {
        int temp = a;
        a = b;
        b = temp;
    }

    int gcdVal = gcd(a, b);
    int lcmVal = (a * b) / gcdVal;
    printf("%d\n%d\n", gcdVal, lcmVal);

    return 0;
}