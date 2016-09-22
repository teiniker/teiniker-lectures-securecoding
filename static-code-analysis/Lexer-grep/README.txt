#
# Analyze existing code using the grep command 
#

# Example: Beginning of line (^)
$ grep -n "^#" crunch.c
225:#include <assert.h>
226:#include <stdio.h>
227:#include <stdlib.h>
228:#include <string.h>
229:#include <ctype.h>
230:#include <errno.h>

# Example: Literals
$ grep -n "gets(" crunch.c
1066:      (void)fgets(buff, (int)sizeof(buff), optr);
1069:        (void)fgets(buff, (int)sizeof(buff), optr);
1682:      (void)fgets(buff, (int)sizeof(buff), optr);
1726:    while (fgets(buff, (int)sizeof(buff), optr) != NULL) {
1769:    while (fgets(buff, (int)sizeof(buff), optr) != NULL) {
1780:    while (fgets(buff, (int)sizeof(buff), optr) != NULL) {

$ grep -n -E "free|calloc" crunch.c
1040:  finalnewfile = calloc((end*3)+5+strlen(fpath), sizeof(char)); /* max length will be 3x outname */
1046:  newfile = calloc((end*3)+5+strlen(fpath), sizeof(char)); /* max length will be 3x outname */
1119:  free(newfile);
1120:  free(finalnewfile);
1199:          block2 = calloc(options.plen+1,sizeof(char)); /* block can't be bigger than max size */
1235:          free(block2);



# Example: Single Character (.)
$ grep -n "'.'" crunch.c 
318:      case '@':
319:        if (options.literalstring[i] != '@') 
322:      case ',':
323:        if (options.literalstring[i] != ',')
326:      case '%':
327:        if (options.literalstring[i] != '%')
330:      case '^':
331:        if (options.literalstring[i] != '^')


Example: Escaping the special character (\)
$ grep -n "\".*\"" crunch.c
244:static const char def_low_charset[] = "abcdefghijklmnopqrstuvwxyz";
245:static const char def_upp_charset[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
246:static const char def_num_charset[] = "0123456789";
247:static const char def_sym_charset[] = "!@#$%^&*()-_+=~`[]{}|\\:;\"'<>,.?/ ";
248:static const char version[] = "3.2";


# Example: Zero or more occurrence (*)
$ grep -n "printf(.*);" crunch.c
372:    printf("fill_minmax_strings: can't allocate memory for last_min\n");
379:    printf("fill_minmax_strings: can't allocate memory for first_max\n");
386:    printf("fill_minmax_strings: can't allocate memory for min_string\n");
393:    printf("fill_minmax_strings: can't allocate memory for max_string\n");
462:    printf("fill_pattern_info: can't allocate memory for pattern info\n");


# Example: One or more occurrence (\+)
$ grep -n "'.\+'" crunch.c
2101:            wordarray[temp][1] = '\0';
2108:        if ((i < argc) && (*argv[i] != '-')) {
2109:          if (*argv[i] != '+') {
2120:        if ((i < argc) && (*argv[i] != '-')) {
2121:          if (*argv[i] != '+') {
2132:        if ((i < argc) && (*argv[i] != '-')) {
2133:          if (*argv[i] != '+') {
2168:        hold = strrchr(argv[i+1], '/');
2219:            wordarray[temp][1] = '\0';
2356:      literalstring[i] = '-';
2357:    literalstring[max] = '\0';


# Example: count of matching lines
$ grep -c "calloc(" crunch.c
31

$ grep -c -"free(" crunch.c
32


# Example: Character Class ([0-9])
$ grep -n "[a-zA-Z_][a-zA-Z0-9_]*" crunch.c
1376:size_t t;
1377:char *temp[1];
1379:  if (sizePerm > unchanged) {
1380:    for(outer = unchanged; outer < sizePerm; outer++) {
1381:      *temp = wordarray[outer];
1382:      for(inner = outer; inner > unchanged; inner--) {
1383:        wordarray[inner] = wordarray[inner - 1];
1385:      wordarray[unchanged] = *temp;
1386:      Permutefilesize(wordarray, sizePerm, length, unchanged+1);
1388:      for(inner = unchanged; inner < outer; inner++) {
1389:        wordarray[inner] = wordarray[inner + 1];
1391:      wordarray[outer] = *temp;


# Example: Zero or one occurrence (\?) 
$ grep -n "[1-9][0-9]*U\?L" crunch.c
1987:          if (calc > 4 && multi >= 1073741824 && bytecount <= 4294967295ULL) {
2006:        if ((linecount*max) > 2147483648UL) {
2007:          calc = (2147483648UL/(unsigned long)max);
2012:          printf("The above value is calcualated based on 2147483648UL/max\n");

