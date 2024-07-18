#include <stdio.h>
int main()
{
    char *s="Hello World";
    char *res;
    int i;
    printf("The Inpuut string is : %s\n",s);
    printf("The string after Xor with 0 is : ");
    for(i=0;*(s+i)!='\0';i++){
        printf("%c",*(s+i)^0);
    }
    return 0;
}