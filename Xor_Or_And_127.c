// Online C compiler to run C program online
#include <stdio.h>
int main() {
    char *s="Hello World";
    char *res;
    int i;
    printf("The Input string is : %s",s);
    printf("\nThe string after Xor with 127 is : ");
    for(i=0;*(s+i)!='\0';i++){
        printf("%c",*(s+i)^127);
    }
    printf("\nThe string after Or with 127 is : ");
    for(i=0;*(s+i)!='\0';i++){
        printf("%c",*(s+i)|127);
    }
    printf("\nThe string after And with 127 is : ");
    for(i=0;*(s+i)!='\0';i++){
        printf("%c",*(s+i)&127);
    }
    return 0;
}