
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main(int argc, char **argv) {
    printf("Line to be counted\n");
    char *line = NULL;
    size_t size = 0;

    if (argc > 1) line = argv[1], size = strlen(line);
    else getline(&line, &size, stdin);

    int counts[27] = {0};

    for (int i = 0; i < size; i++) {
        char c = line[i];
        if (c >= 65 && c <= 90) counts[c - 65]++;
        else if (c >= 97 && c <= 122) counts[c - 97]++;
        else if (c == '\0' || c == '\n') break;
        else counts[26]++;
    }
    free(line);
    for (int i = 0; i < 27; i++) printf("%c: %d\n", (i == 26) ? '_' : i + 97, counts[i]);
}