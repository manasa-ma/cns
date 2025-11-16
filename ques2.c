#include <stdio.h>
#include <string.h>

int main() {
    char *str = "HelloWorld";   // original string
    char anded[100];            // result of AND
    char xored[100];            // result of XOR
    int i, len;

    len = strlen(str);

    printf("Original string: %s\n", str);

    // Apply AND with 127 to each character
    for(i = 0; i < len; i++) {
        anded[i] = str[i] & 127;
    }
    anded[len] = '\0';  // null-terminate string

    // Apply XOR with 127 to each character
    for(i = 0; i < len; i++) {
        xored[i] = str[i] ^ 127;
    }
    xored[len] = '\0';  // null-terminate string

    printf("After AND with 127: %s\n", anded);
    printf("After XOR with 127: %s\n", xored);

    return 0;
}
