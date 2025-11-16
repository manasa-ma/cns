#include <stdio.h>
#include <string.h>

int main() {
    char str[] = "HelloWorld";      // original string
    char str1[100];                 // XORed string
    int i, len;

    len = strlen(str);

    printf("Original string: %s\n", str);

    // XOR each character with 0
    for(i = 0; i < len; i++) {
        str1[i] = str[i] ^ 0;       // XOR with 0
    }
    str1[len] = '\0';               // null-terminate the string

    printf("After XOR with 0: %s\n", str1);

    return 0;
}
