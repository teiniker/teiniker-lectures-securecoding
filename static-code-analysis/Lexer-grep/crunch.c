/*  character-set based brute-forcing algorithm
 *  Copyright (C) 2004 by mimayin@aciiid.ath.cx
 *  Copyright (C) 2008, 2009, 2010, 2011, 2012 by bofh28@gmail.com
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, version 2 only of the License
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  crunch version 1.0 was written by mimayin@aciiid.ath.cx
 *  all later versions of crunch have been updated by bofh28@gmail.com
 *
 *  Changelog:
 *  version 1.0 initial release in 2004 (guess based on copyright date) 194 lines of code
 *  version 1.1 added support to read character list from a specified file
 *  version 1.2 added output parameter
 *  version 1.3 added -c parameter to break apart output file. I would prefer to break
 *              apart on file size instead of number of lines, but there is no reliable
 *              way to get that information while the file is being created.
 *  version 1.4 added better help documentation and fixed some bugs:
 *              space character was sometimes getting stripped off in charset
 *              replace if (pattern[0]==0) { with if ((strncmp(&pattern[0],"\0",1)==0)) {
 *              to make splint happy
 *              rename templ variable to pattern
 *              changed some fixed size local buffers to dynamically allocated buffers
 *              if max-len was larger than strlen of the -t parameter crunch would generate
 *              duplicate words
 *              documented the code
 *  version 1.5 fixed length and -s parameter.  Before if you did ./crunch 1 3 -s 	
 *              you would only get j-z and not j-zzz
 *              converted some fixed length buffers to variable length
 *              added checks to fclose
 *              fixed it so that -s and -t can now work together
 *              added support to generate wordlists greater than 2GB even though several
 *              programs can't access files of this size (john the ripper for example)
 *              This support works on Ubuntu intrepid.  This probably works on most Linux
 *              platforms.  Support for Solaris, HP-UX, Windows, BSD is unknown.
 *  version 1.6 add option (-p) to support factorial instead of exponentail processing.  i.e.
 *              if you did ./crunch 3 3 abc you would get 27 results (3x3x3): a through ccc
 *              This new option will give you 6 results (3! = 3x2x1)
 *              i.e. (abc, acb, bac, bca, cab, cba)
 *              the permute function was written by Richard Heathfield
 *              and copied from
 *              http://bytes.com/groups/c/536779-richard-heathfields-tsp-permutation-algorithm
 *              I did change temp from an int to char to make splint happy.
 *              Richard Heathfield may be contacted at rjh@cpax.org.uk
 *
 *  version 1.7 add option (-m) to support factoring words instead of characters
 *
 *  version 1.8 add option (-z) to support compressing the output
 *
 *  version 1.9 only need permute2 (remove permute and renamed permute2 to permute)
 *              fix off by 1 error - reported by MikeCa
 *              fix issue where output file wasn't being renamed
 *              fork compression process
 *              really fix it so that -s and -t can now work together
 *              when using -c sometimes the output was 1 larger than requested
 *              cstring_cmp from  http://www.anyexample.com/programming/c/qsort__sorting_array_of_strings__integers_and_structs.xml to sort words to permute so the results will be in sorted order
 *
 *  version 2.0 permute now supports -c -o & -z. -f is also supported for permuting letters
 *              really really fix it so that -s and -t can now work together
 *              added null checks for parameter values to prevent segmentation faults
 *              added support to invert chunk output - written by Pillenski
 *              added support to breakup file based on size - written by Pillenski
 *
 *  version 2.1 permute now supports -b
 *              add signal handling - pressing ctrl break will cause crunch
 *              to finish the word it is processing and then gracefully exit instead
 *              of leaving files open and words half finished.  This is the first
 *              step in supporting resume.
 *              chunk now supports resume
 *
 *  version 2.2 pattern supports numbers and symbols
 *
 *  version 2.3 fix bytecount
 *              add new options to usage
 *
 *  version 2.4 fix usage (-m and not -n) - reported by Tape
 *              clarified -b option in help and man file - reported by Tape
 *              fix Makefile install to /pentest/passwords not /pentest/password -
 *              reported by Tape
 *              make bytecount behave consistently - reported by Tape
 *              fixed up copyrights
 *
 *  version 2.5 -q permute supports reading from strings from file
 *              sorted parameters in code and usage
 *              -t supports upper and lower case letters
 *              -f supports multiple charsets
 *              add -v option to show version information
 *              add correct gpl.txt (version 2 not 3)
 *              fix charset.lst (some symbol14 had 15 chars)
 *              add symbol14, symbol14-space, symbol-all, and symbol-all-space to charset.lst
 *              removed examples and parameters from usage.  I added a sentence
 *              telling people to refer to the man page.  It is easier to update
 *              the man only.
 *              combined -m and -p into -p
 *              got rid of some unnecessary casts
 *              changed all mallocs to callocs, this shuts up a few splint warnings
 *
 *  version 2.6 fix -p seg fault - reported by Tape
 *              improve -p documentation - reported by Tape
 *              fix Makefile to install to correct directory again - reported by Tape
 *              fix Makefile to install charset.lst - reported by Tape
 *              fix memory leak
 *              replace if (argv[i+1] != NULL) with if (i+1 < argc) as argv[i+1]
 *              can be filled garbage so it is not an accurate test
 *              fix an off by 1 in resume counter
 *              resume now respects the -b parameter, previously it was ignored
 *              -s now supports the @*%^ symbols in -t
 *              added status report when saving to file
 *              renamed some variables to better names
 *              added a few comments to variables
 *              added a hex string 0123456789abcdef to charset.lst
 *  version 2.7 fix progress bar when using -s
 *              fixed typo man file - Thanks Tape
 *              add -u option to suppress all filesize and linecount so crunch
 *              can feed another program
 *              fork a child process for progress %%
 *              Niclas Kroon added swedish characters to the charset.lst
 *              permute supports -t
 *              added -std=c99 to Makefile since unsigned long long isn't in c89
 *              ran valgrind and fixed a small memory issue.  I forgot to allocate
 *              space for the \0 character in a few places.  Doh!
 *              improved documentation of the charset field.
 *  version 2.8 fix progress message.  It could cause a fatal error under certain
 *              circumstances
 *  version 2.9 fix divide by zero error.
 *  version 3.0 fix wrong version number
 *              changed the * character of -t option to a , (comma) as * is a reserved character
 *              strip off blank lines when reading file for permute (-q option)
 *              I fixed a problem with using -i and -t together
 *              add -l to allow for literal characters of @,%^
 *              fix -b and -c and % output
 *              fix permute -t to work with -b and -c
 *              fixed crash when / character was in filename
 *                 replace / with space - reported by Nazagul
 *  version 3.0.1 fix printpermutepattern - it was using $ instead of ,
 *  version 3.1 make -l take a string so you can have @ and characters
 *              add TB and PB to output size
 *              fix comments referencing $ that should be ,
 *              add -e to end generation after user specified string (useful when piping crunch to a program)
 *  version 3.2 add -d to limit duplicate characters
 *              put correct function name into error messages to help with debugging
 *              fix Makefile uninstall to remove crunch directory and install GPL.TXT
 *              removed flag5 as it wasn't needed
 *              if you press Ctrl-C crunch will now print where it stops so you resume piping crunch into another program
 * 
 *  TODO: Listed in no particular order
 *         add resume support to permute (I am not sure this is possible)
 *         make permute more intelligent (min, max) (I am not sure this is possible either)
 *         support SIGINFO when Linux supports it
 *         use SIGUSR1 until SIGINFO is available
 *         add unicode support
 *         let user specify placeholder characters (@,%^)
 *         add date support?
 *         specify multiple charset names using -f i.e. -f charset.lst + ualpha 123 +
 *         make permute use -e
 *
 *
 *  usage: ./crunch <min-len> <max-len> [charset]
 *  e.g: ./crunch 3 7 abcdef
 *
 *  This example will compute all passwords between 3 and 7 chars
 *  using 'abcdef' as the character set and dump it to stdout.
 *
 *  usage: ./crunch <from-len> <to-len> [-f <path to charset.lst> charset-name] [-o wordlist.txt or START] [-t [FIXED]@@@@] [-s startblock]
 *
 *  Options:
 *  -b          : maximum bytes to write to output file. depending on the blocksize
 *                files may be some bytes smaller than specified but never bigger.
 *  -c          : numbers of lines to write to output file, only works if "-o START"
 *                is used, eg: 60  The output files will be in the format of starting
 *                letter - ending letter for example:
 *                crunch 1 5 -f /pentest/password/charset.lst mixalpha -o START -c 52
 *                will result in 2 files: a-7.txt and 8-\ .txt  The reason for the
 *                slash in the second filename is the ending character is space and
 *                ls has to escape it to print it.  Yes you will need to put in
 *                the \ when specifying the filename.
 *  -d          : specify -d [n][@,%^] to suppress generation of strings with more
 *                than [n] adjacent duplicates from the given character set. For example:
 *                ./crunch 5 5 -d 2@  
 *                Will print all combinations with 2 or less adjacent lowercase duplicates.
 *  -e          : tells crunch to stop generating words at string.  Useful when piping 
 *                crunch to another program.
 *  -f          : path to a file containing a list of character sets, eg: charset.lst
 *                name of the character set in the above file eg:
 *                mixalpha-numeric-all-space
 *  -i          : inverts the output so the first character will change very often
 *  -l          : literal characters to use in -t @,%^
 *  -o          : allows you to specify the file to write the output to, eg:
 *                wordlist.txt
 *  -p          : prints permutations without repeating characters.  This option
 *                CANNOT be used with -s.  It also ignores min and max lengths.
 *  -q          : Like the -p option except it reads the strings from the specified
 *                file.  It CANNOT be used with -s.  It also ignores min and max.
 *  -r          : resume a previous session.  You must use the same command line as
 *                the previous session.
 *  -s          : allows you to specify the starting string, eg: 03god22fs
 *  -t [FIXED]@,%^  : allows you to specify a pattern, eg: @@god@@@@
 *                where the only the @'s will change with lowercase letters
 *                the ,'s will change with uppercase letters
 *                the %'s will change with numbers
 *                the ^'s will change with symbols
 *  -u          : only print words; supress file size information, aka unheard
 *  -z          : adds support to compress the generated output.  Must be used
 *                with -o option.  Only supports gzip, bzip, and lzma.
 *
 *  This code can be easily adapted for use in brute-force attacks
 *  against network services or cryptography.
 *
 *  Compiles on: linux (32 bit Ubuntu for sure, 32 bit Linux in general should work,
 *     64 bit Linux works according to a report I received.  I have received word that
 *     crunch compiles MacOS.
 *  It should compile on ms visual c++ and freebsd and the others but I don't
 *     don't have access to any of the those systems.  Please let me know.
 */

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <errno.h>
#include <signal.h>
#include <math.h>
#include <pthread.h>
#include <unistd.h>
#include <limits.h>
#include <sys/wait.h>
#include <sys/types.h>

/* largest output string */
#define MAXSTRING 128
/* longest character set */
#define MAXCSET 256

static const char def_low_charset[] = "abcdefghijklmnopqrstuvwxyz";
static const char def_upp_charset[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
static const char def_num_charset[] = "0123456789";
static const char def_sym_charset[] = "!@#$%^&*()-_+=~`[]{}|\\:;\"'<>,.?/ ";
static const char version[] = "3.2";

static size_t inc[128];
static size_t numofelements = 0;
static size_t inverted = 0;  /* 0 for normal output 1 for aaa,baa,caa,etc */
static size_t flag2 = 0;     /* 0 to free wordarray 1 to free elements of wordarray */

static unsigned long long linecount = 0; /* user specified break output into count lines */
static unsigned long long linetotal = 0; /* total number of lines so far */
static unsigned long long finallinecount = 0; /* total size of output */
static unsigned long long linecounter = 0; /* counts number of lines in output resets to 0 */

static unsigned long long bytecount = 0 ;  /* user specified break output into size */

static volatile sig_atomic_t ctrlbreak = 0; /* 0 user did NOT press Ctrl-C 1 they did */

static FILE *fptr;        /* file pointer */

struct thread_data{
unsigned long long finalfilesize; /* total size of output */
unsigned long long bytetotal;  /* total number of bytes so far */
unsigned long long bytecounter; /* count number of bytes in output resets to 0 */
};

/* pattern info */
struct pinfo {
  char *cset; /* character set pattern[i] is member of */
  size_t clen;
  int is_fixed; /* whether pattern[i] is a fixed value */
  size_t start_index, end_index; /* index into cset for the start and end strings */
  unsigned long duplicates;
};

/* program options */
struct opts_struct {
  char *low_charset, *upp_charset, *num_charset, *sym_charset;
  size_t clen, ulen, nlen, slen;
  char *pattern;
  size_t plen;
  char *literalstring, *startstring, *endstring;
  unsigned long duplicates[4]; /* allowed number of duplicates for each charset */

  size_t min, max;
  char *last_min, *first_max; /* last string of length min, first string of length max */
  char *min_string, *max_string; /* either startstring/endstring or calculated using the pattern */
  struct pinfo *pattern_info; /* information generated from pattern */
};
typedef struct opts_struct options_type;

static struct thread_data my_thread;

static int cstring_cmp(const void *a, const void *b) {
  const char **ia = (const char **)a;
  const char **ib = (const char **)b;
  return strcmp(*ia, *ib);
}

static void ex_program() {
  ctrlbreak = 1;
  (void) signal(SIGINT, SIG_DFL);
}

/* return 0 if string1 does not comply with options.pattern and options.literalstring */
static int check_member(const char *string1, const options_type options) {
const char *cset;
size_t i;

  for (i = 0; i < strlen(string1); i++) {
    cset = NULL;
    switch (options.pattern[i]) {
      case '@':
        if (options.literalstring[i] != '@') 
          cset = options.low_charset;
        break;
      case ',':
        if (options.literalstring[i] != ',')
          cset = options.upp_charset;
        break;
      case '%':
        if (options.literalstring[i] != '%')
          cset = options.num_charset;
        break;
      case '^':
        if (options.literalstring[i] != '^')
          cset = options.sym_charset;
        break;
      default: /* constant part of pattern */
        break;
    }
    
    if (cset == NULL) {
      if (string1[i] != options.pattern[i])
        return 0;
      continue;
    }
    
    while (*cset)
      if (string1[i] == *cset)
        break;
      else
        cset++;
    if (!*cset)
      return 0;
  }
  return 1;
}

/* NOTE: similar to strpbrk but length limited and only searches for a single char */
static size_t find_index(const char *cset, size_t clen, char tofind) {
size_t i;
  for (i = 0; i < clen; i++)
    if (cset[i] == tofind)
      return i;
  return -1;
}

static void fill_minmax_strings(options_type *options) {
size_t i;
char *last_min; /* last string of size min */
char *first_max; /* first string of size max */
char *min_string, *max_string; /* first string of size min, last string of size max */

  last_min = calloc(options->min + 1,sizeof(char));
  if (last_min == NULL) {
    printf("fill_minmax_strings: can't allocate memory for last_min\n");
    exit(EXIT_FAILURE);
  }
  last_min[options->min] = '\0';
  
  first_max = calloc(options->max + 1,sizeof(char));
  if (first_max == NULL) {
    printf("fill_minmax_strings: can't allocate memory for first_max\n");
    exit(EXIT_FAILURE);
  }
  first_max[options->max] = '\0';

  min_string = calloc(options->min + 1,sizeof(char));
  if (min_string == NULL) {
    printf("fill_minmax_strings: can't allocate memory for min_string\n");
    exit(EXIT_FAILURE);
  }
  min_string[options->min] = '\0';

  max_string = calloc(options->max + 1,sizeof(char));
  if (max_string == NULL) {
    printf("fill_minmax_strings: can't allocate memory for max_string\n");
    exit(EXIT_FAILURE);
  }
  max_string[options->max] = '\0';

  /* fill last_min and first_max */
  for (i = 0; i < options->max; i++) {
    if (options->pattern == NULL) {
      if (i < options->min) {
        last_min[i] = options->low_charset[options->clen-1];
        min_string[i] = options->low_charset[0];
      }
      first_max[i] = options->low_charset[0];
      max_string[i] = options->low_charset[options->clen-1];
    }
    else { /* min == max */
      min_string[i] = max_string[i] = last_min[i] = first_max[i] = options->pattern[i];
      switch (options->pattern[i]) {
      case '@':
        if (options->literalstring[i] != '@') {
          max_string[i] = last_min[i] = options->low_charset[options->clen - 1];
          min_string[i] = first_max[i] = options->low_charset[0];
        }
        break;
      case ',':
        if (options->literalstring[i] != ',') {
          max_string[i] = last_min[i] = options->upp_charset[options->ulen - 1];
          min_string[i] = first_max[i] = options->upp_charset[0];
        }
        break;
      case '%':
        if (options->literalstring[i] != '%') {
          max_string[i] = last_min[i] = options->num_charset[options->nlen - 1];
          min_string[i] = first_max[i] = options->num_charset[0];
        }
        break;
      case '^':
        if (options->literalstring[i] != '^') {
          max_string[i] = last_min[i] = options->sym_charset[options->slen - 1];
          min_string[i] = first_max[i] = options->sym_charset[0];
        }
        break;
      default:
        break;
      }
    }
  }
  
  options->last_min = last_min;
  options->first_max = first_max;
  if (options->startstring)
    for (i = 0; i < options->min; i++)
      min_string[i] = options->startstring[i];
  if (options->endstring)
    for (i = 0; i < options->max; i++)
      max_string[i] = options->endstring[i];
  options->min_string = min_string;
  options->max_string = max_string;
}

static void fill_pattern_info(options_type *options) {
struct pinfo *p;
char *cset;
size_t i, clen, index, si, ei;
int is_fixed;
unsigned long dupes;
  
  options->pattern_info = calloc(options->max, sizeof(struct pinfo));
  if (options->pattern_info == NULL) {
    printf("fill_pattern_info: can't allocate memory for pattern info\n");
    exit(EXIT_FAILURE);
  }

  for (i = 0; i < options->max; i++) {
    index = 0;
    is_fixed = 1;
    dupes = options->duplicates[0];
    if (options->pattern == NULL) {
      cset = options->low_charset;
      clen = options->clen;
      is_fixed = 0;
    }
    else {
      cset = NULL;
      switch (options->pattern[i]) {
        case '@':
          if (options->literalstring[i] != '@') {
            cset = options->low_charset;
            clen = options->clen;
            is_fixed = 0;
            dupes = options->duplicates[0];
          }
          break;
        case ',':
          if (options->literalstring[i] != ',') {
            cset = options->upp_charset;
            clen = options->ulen;
            is_fixed = 0;
            dupes = options->duplicates[1];
          }
          break;
        case '%':
          if (options->literalstring[i] != '%') {
            cset = options->num_charset;
            clen = options->nlen;
            is_fixed = 0;
            dupes = options->duplicates[2];
          }
          break;
        case '^':
          if (options->literalstring[i] != '^') {
            cset = options->sym_charset;
            clen = options->slen;
            is_fixed = 0;
            dupes = options->duplicates[3];
          }
          break;
        default: /* constant part of pattern */
          break;
      }
    }
    
    if (cset == NULL) {
      cset = options->low_charset;
      clen = options->clen;
      dupes = options->duplicates[0];
      if ((index = find_index(cset, clen, options->pattern[i])) == -1) {
        cset = options->upp_charset;
        clen = options->ulen;
        dupes = options->duplicates[1];
        if ((index = find_index(cset, clen, options->pattern[i])) == -1) {
          cset = options->num_charset;
          clen = options->nlen;
          dupes = options->duplicates[2];
          if ((index = find_index(cset, clen, options->pattern[i])) == -1) {
            cset = options->sym_charset;
            clen = options->slen;
            dupes = options->duplicates[3];
            if ((index = find_index(cset, clen, options->pattern[i])) == -1) {
              cset = NULL;
              clen = 0;
              dupes = ULONG_MAX;
              index = 0;
            }
          }
        }
      }
      si = ei = index;
    }
    else {
      si = find_index(cset, clen, options->min_string[i]);
      ei = find_index(cset, clen, options->max_string[i]);
    }
    p = &(options->pattern_info[i]);
    p->cset = cset;
    p->clen = clen;
    p->is_fixed = is_fixed;
    p->start_index = si;
    p->end_index = ei;
    p->duplicates = dupes;
  }
  
#ifdef DEBUG
  printf("pattern_info duplicates: ");
  for (i = 0; i < options->max; i++) {
    p = &(options->pattern_info[i]);
    printf("(%d %d %d %d %d %d)", p->cset, p->clen, p->is_fixed, p->start_index, p->end_index, p->duplicates);
  }
  printf("\n");
#endif
}

static unsigned long long fill_next_count(size_t si, size_t ei, int repeats, unsigned long long sum, unsigned long long *current_count, unsigned long long *next_count, size_t len) {
size_t i;
unsigned long long nextsum = 0;
  
  for (i = 0; i < si; i++)
    next_count[i] = 0;
  
  if (repeats == 0 || current_count == NULL)
    nextsum = sum;
  else if (repeats == 1)
    for (; i <= ei; i++) {
      next_count[i] = sum - current_count[i];
      nextsum += next_count[i];
    }
  else /* repeats > 1 */
    for (; i <= ei; i++) {
      next_count[i] = current_count[i];
      nextsum += next_count[i];
    }
    
  for (; i < len; i++)
    next_count[i] = 0;
  
  return nextsum;
}

/* calculate the number of strings from start to end taking into account duplicate removal 
 *   worst case: O(2^n), could be improved using memoize */
static unsigned long long calculate_with_dupes(int start_point, int end_point, size_t first, size_t last, size_t pattern_index, int repeats, unsigned long long current_sum, unsigned long long *current_count, const options_type options, size_t plen) {
unsigned long long count[MAXCSET], *next_count;
unsigned long long total = 0, sum = 0;
size_t start_index, end_index;
size_t i;
  
  if (first < 0 || last < 0 || first > last || pattern_index > plen) /* sanity check */
    return 0;
  
   /* check for too many duplicates */
  if (pattern_index > 0 && repeats > options.pattern_info[pattern_index-1].duplicates)
    return 0;

  /* create the result count for pattern_index - 1 */
  if (pattern_index == 0) {
    sum = current_sum;
    next_count = NULL;
  }
  else if (pattern_index == 1 || 
      (options.pattern_info[pattern_index-1].cset != NULL &&
      options.pattern_info[pattern_index-2].cset != options.pattern_info[pattern_index-1].cset) ||
      (options.pattern_info[pattern_index-1].cset == NULL && 
      options.pattern[pattern_index-2] != options.pattern[pattern_index-1])) {
    /* beginning new cset */
    if (repeats > 1) 
      return 0;
    if (options.pattern_info[pattern_index-1].cset != NULL) {
      for (i = 0; i < first; i++)
        count[i] = 0;
      for (; i <= last; i++)
        count[i] = current_sum;
      for (; i < options.pattern_info[pattern_index-1].clen; i++)
        count[i] = 0;
      next_count = count;
    } else
      next_count = NULL;
    sum = current_sum * (last - first + 1);
  }    
  else if (options.pattern_info[pattern_index-1].cset == NULL &&
      options.pattern[pattern_index-2] == options.pattern[pattern_index-1]) { 
    /* continuing unknown cset */
    sum = current_sum;
    next_count = NULL;
  }
  else {
    /* continuing previous cset */
    sum = fill_next_count(first, last, repeats, current_sum, current_count, count, options.pattern_info[pattern_index-1].clen);
    next_count = count;
  }

  if (sum == 0)
    return 0;

  if (pattern_index == plen) { /* check for the end of the pattern */
    return sum;
  }
  
  if (options.pattern_info[pattern_index].is_fixed) {
    start_index = end_index = options.pattern_info[pattern_index].start_index;
  }
  else {
    start_index = 0;
    end_index = options.pattern_info[pattern_index].clen - 1;
    if (start_point)
      start_index = options.pattern_info[pattern_index].start_index;
    if (end_point)
      end_index = options.pattern_info[pattern_index].end_index;
  }

  if (start_index == end_index) {
    /* [0..si..0](sp, ep) */
    if (repeats > 0)
      total += calculate_with_dupes(start_point, end_point, start_index, end_index, pattern_index + 1, repeats + 1, sum, next_count, options, plen);
    total += calculate_with_dupes(start_point, end_point, start_index, end_index, pattern_index + 1, 1, sum, next_count, options, plen);
  }
  else {
    if (start_point) {
      /* [0..si..0](sp, 0) */
      if (repeats > 0)
        total += calculate_with_dupes(start_point, 0, start_index, start_index, pattern_index + 1, repeats + 1, sum, next_count, options, plen);
      total += calculate_with_dupes(start_point, 0, start_index, start_index, pattern_index + 1, 1, sum, next_count, options, plen);
      start_index++;
    }
    
    if (end_point) {
      /* [0..ei..0](0, ep) */
      if (repeats > 0)
        total += calculate_with_dupes(0, end_point, end_index, end_index, pattern_index + 1, repeats + 1, sum, next_count, options, plen);
      total += calculate_with_dupes(0, end_point, end_index, end_index, pattern_index + 1, 1, sum, next_count, options, plen);
      end_index--;
    }
    
    if (start_index <= end_index) {  /* middle */
      /* [0..si..ei..0](0,0) */
      if (repeats > 0)
        total += calculate_with_dupes(0, 0, start_index, end_index, pattern_index + 1, repeats + 1, sum, next_count, options, plen);
      total += calculate_with_dupes(0, 0, start_index, end_index, pattern_index + 1, 1, sum, next_count, options, plen);
    }
  }

  return total;
}

/* calculate the number of strings from start to end 
 *   O(n)  */
static unsigned long long calculate_simple(const char *startstring, const char *endstring, const char *cset, int clen) {
unsigned long long total = 1;
size_t index1, index2;

  for (; *endstring && *startstring; endstring++, startstring++) {
    for (index1 = 0; cset[index1] != '\0' && cset[index1] != *endstring;) 
      index1++;
    if (cset[index1] == '\0')
      index1 -= 1;
    for (index2 = 0; cset[index2] != '\0' && cset[index2] != *startstring;) 
      index2++;
    if (cset[index2] == '\0')
      index2 = 0;
    total = (total - 1) * (unsigned long long)clen + (unsigned long long)index1 - (unsigned long long)index2 + 1;
  }
  return total;
}

/* calculate the number of strings from start to end, inclusive, taking into account the pattern 
 *   O(n) */
static unsigned long long calculate_with_pattern(const char *startstring, const char *endstring, const options_type options) {
unsigned long long total = 1;
size_t temp, clen;
const char *cset;
size_t index1, index2;

  if (options.pattern == NULL) {
    return calculate_simple(startstring, endstring, options.low_charset, options.clen);
  }

  for (temp = 0; temp < options.plen; temp++) {
    cset = NULL;
    switch (options.pattern[temp]) {
      case '@':
        if (options.literalstring[temp] != '@') {
          clen = options.clen;
          cset = options.low_charset;
        }
        break;
      case ',':
        if (options.literalstring[temp] != ',') {
          clen = options.ulen;
          cset = options.upp_charset;
        }
        break;
      case '%':
        if (options.literalstring[temp] != '%') {
          clen = options.nlen;
          cset = options.num_charset;
        }
        break;
      case '^':
        if (options.literalstring[temp] != '^') {
          clen = options.slen;
          cset = options.sym_charset;
        }
        break;
      default: /* constant part of pattern */
        break;
    }
    if (cset) {
      for (index1 = 0; index1 < clen && cset[index1] != endstring[temp];) 
        index1++;
      if (index1 == clen)
        index1 = clen - 1;
      for (index2 = 0; index2 < clen && cset[index2] != startstring[temp];) 
        index2++;
      if (index2 == clen)
        index2 = 0;
      total = (total - 1) * clen + (unsigned long long)index1 - (unsigned long long)index2 + 1;
    }
  }
  return total;
}

/* calculate the number of lines and bytes to output */
static void count_strings(unsigned long long *lines, unsigned long long *bytes, const options_type options) {
const char *startstring = options.startstring, *endstring = options.endstring;
size_t min = options.min, max = options.max;
size_t i, j;
unsigned long long temp;
int check_dupes; /* need to take duplicates into account */
  
/* parameters for counting taking dupes into consideration */
size_t first, last; /* index of the first character and last character */
int start_point = 0, end_point = 0; /* whether to consider a starting or ending string */
 
  if (max == 0) {
    *lines = 0;
    *bytes = 0;
    return;
  }
  
  if (min == max) { /* strings of the same length */
    check_dupes = 0;
    for (i = 0; i < min; i++)
      if (options.pattern_info[i].duplicates < min)
        check_dupes = 1;
    if (check_dupes) { /* must take duplicates into account */
      first = 0;
      last = options.pattern_info[0].clen - 1;
      if (startstring) {
        first = options.pattern_info[0].start_index;
        start_point = 1;
      }
      if (endstring) {
        last = options.pattern_info[0].end_index;
        end_point = 1;
      }
      temp = calculate_with_dupes(start_point, end_point, first, last, 0, 0, 1, NULL, options, min);
    }
    else {      
      temp = calculate_with_pattern(options.min_string, options.max_string, options);
    }
    
    *lines = temp;
    *bytes = temp * (max + 1);
  }
  else {
    /* add beginning from startstring to last_min */
    check_dupes = 0;
    for (i = 0; i < min; i++)
      if (options.pattern_info[i].duplicates < min)
        check_dupes = 1;
    if (check_dupes) { /* must take duplicates into account */
      first = 0;
      last = options.pattern_info[0].clen - 1;
      if (startstring) {
        first = options.pattern_info[0].start_index;
        start_point = 1;
      }
      temp = calculate_with_dupes(start_point, 0, first, last, 0, 0, 1, NULL, options, min);
    }
    else {      
      if (startstring)
        temp = calculate_simple(startstring, options.last_min, options.low_charset, options.clen);
      else
        temp = (unsigned long long)pow((double)options.clen, (double)min);
    }
    
    *lines = temp;
    *bytes = temp * (min + 1);

    /* add middle permutations */
    for (i = min + 1; i < max; i++) {
      first = 0;
      last = options.pattern_info[0].clen - 1;
      check_dupes = 0;
      for (j = 0; j < i; j++)
        if (options.pattern_info[j].duplicates < i)
          check_dupes = 1;
      if (check_dupes)  /* must take duplicates into account */
        temp = calculate_with_dupes(0, 0, first, last, 0, 0, 1, NULL, options, i);
      else
        temp = (unsigned long long)pow((double)options.clen, (double)i);
      
      *lines += temp;
      *bytes += temp * (i+1);
    }

    /* add ending from first_max to endstring */
    check_dupes = 0;
    for (i = 0; i < max; i++)
      if (options.pattern_info[i].duplicates < max)
        check_dupes = 1;
    if (check_dupes) { /* must take duplicates into account */
      first = 0;
      last = options.pattern_info[0].clen - 1;
      if (endstring) {
        last = options.pattern_info[0].end_index;
        end_point = 1;
      }
      temp = calculate_with_dupes(0, end_point, first, last, 0, 0, 1, NULL, options, max);
    }
    else {      
      if (endstring)
        temp = calculate_simple(options.first_max, endstring, options.low_charset, options.clen);
      else
        temp = (unsigned long long)pow((double)options.clen, (double)max);
    }
    *lines += temp;
    *bytes += temp * (max + 1);
  }
}

static int finished(const char *block, const options_type options) {
size_t i;
  if (options.pattern == NULL) {
    for (i = 0; i < strlen(block); i++)
      if (inc[i] < options.clen-1)
        return 0;
  }
  else {
    for (i = 0; i < strlen(block); i++) {
      if (((options.pattern[i] == '@') && (inc[i] < options.clen-1) && (options.literalstring[i] != '@')) || \
          ((options.pattern[i] == ',') && (inc[i] < options.ulen-1) && (options.literalstring[i] != ',')) || \
          ((options.pattern[i] == '%') && (inc[i] < options.nlen-1) && (options.literalstring[i] != '%')) || \
          ((options.pattern[i] == '^') && (inc[i] < options.slen-1) && (options.literalstring[i] != '^'))) {
        return 0;
      }
    }
  }
  return 1;
}

static int too_many_duplicates(const char *block, const options_type options) {
char current_char = '\0';
unsigned long dupes_seen = 0;
  
  while (*block != '\0') {
    if (*block == current_char) {
      dupes_seen += 1;
      /* check for overflow of duplicates */
      if (dupes_seen > options.duplicates[0]) {
        if (find_index(options.low_charset, options.clen, current_char) != -1)
          return 1;
      }
      if (dupes_seen > options.duplicates[1]) {
        if (find_index(options.upp_charset, options.ulen, current_char) != -1)
          return 1;
      }
      if (dupes_seen > options.duplicates[2]) {
        if (find_index(options.num_charset, options.nlen, current_char) != -1)
          return 1;
      }
      if (dupes_seen > options.duplicates[3]) {
        if (find_index(options.sym_charset, options.slen, current_char) != -1)
          return 1;
      }
    }
    else {
      current_char = *block;
      dupes_seen = 1;
    }
    block++;
  }
  return 0;
}

static void increment(char *block, const options_type options) {
int i, start, stop, step;
int blocklen = (int) strlen(block);

const char *matching_set;
size_t mslen;

  if ((options.low_charset == NULL) || (options.upp_charset == NULL) || (options.num_charset == NULL) || (options.sym_charset == NULL)) {
     printf("increment: SOMETHING REALLY BAD HAPPENED\n");
     exit(EXIT_FAILURE);
  }

  if (inverted == 0) {
    start = blocklen-1;
    stop = -1;
    step = -1;
  }
  else {
    start = 0;
    stop = blocklen;
    step = 1;
  }
  
  for (i = start; i != stop; i += step) {
    if (options.pattern == NULL) {
      matching_set = options.low_charset;
      mslen = options.clen;
    }
    else {
      switch (options.pattern[i]) {
        case '@':
          matching_set = options.low_charset;
          mslen = options.clen;
          break;
        case ',':
          matching_set = options.upp_charset;
          mslen = options.ulen;
          break;
        case '%':
          matching_set = options.num_charset;
          mslen = options.nlen;
          break;
        case '^':
          matching_set = options.sym_charset;
          mslen = options.slen;
          break;
        default:
          matching_set = NULL;
      }
    }
    if (matching_set == NULL || (options.pattern != NULL && options.literalstring[i] == options.pattern[i])) {
      block[i] = options.pattern[i]; /* add pattern letter to word */
    }
    else {
      if (inc[i] < mslen-1) {
        block[i] = matching_set[++inc[i]];
        break;
      }
      else {
        block[i] = matching_set[0];
        inc[i] = 0;
      }
    }
  }
}

static void *PrintPercentage(void *threadarg) {
struct thread_data *threaddata;
unsigned long long linec;
unsigned long long finall;
unsigned long long counter;
unsigned long long calc;

  threaddata = (struct thread_data *) threadarg;

  while (1 != 0) {
    (void)sleep(10);
    linec = threaddata->finalfilesize;
    finall = threaddata->bytetotal;
    counter = threaddata->bytecounter;
    calc = 100L * counter / linec;
    printf("%3llu%%\n", calc);
    (void)fflush(stdout);
  }
  pthread_exit(NULL);
  return (void *)1;
}

static void renamefile(const size_t end, const char *fpath, const char *outputfilename, const char *compressalgo) {
FILE *optr;     /* ptr to START output file; will be renamed later */
char *newfile;  /* holds the new filename */
char *finalnewfile; /*final filename with escape characters */
char *findit = NULL;   /* holds location of / character */
int status;     /* rename returns int */
char buff[512]; /* buffer to hold line from wordlist */
pid_t pid, pidret; /* pid and pid return */

  errno=0;
  memset(buff,0,sizeof(buff));

  printf("%3d%%\n", (int)(100L * my_thread.bytetotal / my_thread.finalfilesize));
  (void)fflush(stdout);

  finalnewfile = calloc((end*3)+5+strlen(fpath), sizeof(char)); /* max length will be 3x outname */
  if (finalnewfile == NULL) {
    printf("rename: can't allocate memory for finalnewfile\n");
    exit(EXIT_FAILURE);
  }

  newfile = calloc((end*3)+5+strlen(fpath), sizeof(char)); /* max length will be 3x outname */
  if (newfile == NULL) {
    printf("rename: can't allocate memory for newfile\n");
    exit(EXIT_FAILURE);
  }

  if (strncmp(outputfilename, fpath, strlen(fpath)) != 0) {
    status = rename(fpath, outputfilename); /* rename from START to user specified name */
    if (status != 0) {
      printf("Error renaming file.  Status1 = %d  Code = %d\n",status,errno);
      printf("The problem is = %s\n", strerror(errno));
      exit(EXIT_FAILURE);
    }
  }
  else {
    if ((optr = fopen(fpath,"r")) == NULL) {
      printf("rename: File START could not be opened\n");
      exit(EXIT_FAILURE);
    }
    else {  /* file opened above now read first line */
      (void)fgets(buff, (int)sizeof(buff), optr);
      strncat(newfile, buff, strlen(buff)-1); /* get rid of CR */
      while (feof(optr) == 0) {
        (void)fgets(buff, (int)sizeof(buff), optr);
      } /* all of this just to get last line */
      if (fclose(optr) != 0) {
        printf("rename: fclose returned error number = %d\n", errno);
        printf("The problem is = %s\n", strerror(errno));
        exit(EXIT_FAILURE);
      }
    }
    strcat(newfile, "-"); /* build new filename */
    strncat(newfile, buff, strlen(buff)-1); /* get rid of CR */

    strncpy(finalnewfile,fpath,strlen(fpath)-5);

    findit = strstr(newfile,"/");
    if (findit == NULL) {
      strncat(finalnewfile,newfile,strlen(newfile));
      strncat(finalnewfile, ".txt", 4);
    }
    else {
//      findit = newfile;
      while ((findit = strchr(newfile, '/')) != NULL) {
        *findit++ = ' ';
      }
      strncat(finalnewfile,newfile,strlen(newfile));
      strncat(finalnewfile, ".txt", 4);
    }

    status = rename(fpath, finalnewfile); /* rename START to proper filename */
    if (status != 0) {
      printf("Error renaming file.  Status2 = %d  Code = %d\n",status,errno);
      printf("The problem is = %s\n", strerror(errno));
      exit(EXIT_FAILURE);
    }
  }

  if (compressalgo != NULL) {
    pid = fork();
    pidret = wait(&status);
    if (pid == 0) {
      if (strncmp(outputfilename, fpath, 5) == 0)
        status=execlp(compressalgo, compressalgo, "-9", "-f", newfile, NULL);
      else
        status=execlp(compressalgo, compressalgo, "-9", "-f", outputfilename, NULL);
      if (status < 0) {
        printf("Error compressing file.  Status = %d  Code = %d\n", status, errno);
        printf("The problem is = %s\n", strerror(errno));
        exit(EXIT_FAILURE);
      }
    }
  }
  free(newfile);
  free(finalnewfile);
}

static void printpermutepattern(const char *block2, const char *pattern, const char *literalstring, char **wordarray) {
size_t j, t;

  for (t = 0, j = 0; t < strlen(pattern); t++) {
    if ((pattern[t] == '@') || (pattern[t] == ',') || (pattern[t] == '%') ||  (pattern[t] == '^')) {
      switch (pattern[t]) {
      case '@':
        if (literalstring[t] == '@') {
          fprintf(fptr, "@");
          break;
        }
      case ',':
        if (literalstring[t] == ',') {
          fprintf(fptr, ",");
          break;
        }
      case '%':
        if (literalstring[t] == '%') {
          fprintf(fptr, "%%");
          break;
        }
      case '^':
        if (literalstring[t] == '^') {
          fprintf(fptr, "^");
          break;
        }
      default:
        fprintf(fptr, "%c", block2[t]);
      }
      my_thread.bytecounter+=1;
    }
    else {
      fprintf(fptr, "%s", wordarray[j]);
      my_thread.bytecounter+=(unsigned long long)strlen(wordarray[j]);
      j++;
    }
  }
  fprintf(fptr, "\n");
  my_thread.bytecounter++;
  linecounter++;
}

static void Permute(const char *fpath, const char *outputfilename, const char *compressalgo, char **wordarray, const options_type options, const size_t sizePerm, size_t unchanged) {
size_t outer = 0;
size_t inner = 0;
size_t wordlength = 0;
size_t t;
char *temp[1];
char *block2;      /* block is word being created */

  errno = 0;

  if (sizePerm > unchanged) {
    for(outer = unchanged; outer < sizePerm; outer++) {
      *temp = wordarray[outer];
      for(inner = outer; inner > unchanged; inner--) {
        wordarray[inner] = wordarray[inner - 1];
      }
      wordarray[unchanged] = *temp;
      Permute(fpath, outputfilename, compressalgo, wordarray, options, sizePerm, unchanged+1);

      for(inner = unchanged; inner < outer; inner++) {
        wordarray[inner] = wordarray[inner + 1];
      }
      wordarray[outer] = *temp;
    }
  }
  else {
    if (outputfilename == NULL) {
      if (options.pattern == NULL) {
        for (t = 0; t < sizePerm; t++) {
          fprintf(fptr, "%s", wordarray[t]);
        }
        fprintf(fptr, "\n");
      }
      else {
          block2 = calloc(options.plen+1,sizeof(char)); /* block can't be bigger than max size */
          if (block2 == NULL) {
            printf("permute: can't allocate memory for block2\n");
            exit(EXIT_FAILURE);
          }

          for (t = 0; t < options.plen; t++) {
            switch (options.pattern[t]) {
              case '@':
                block2[t] = options.low_charset[0]; /* placeholder is set so add character */
                inc[t] = 0;
                break;
              case ',':
                block2[t] = options.upp_charset[0]; /* placeholder is set so add   character */
                inc[t] = 0;
                break;
              case '%':
                block2[t] = options.num_charset[0]; /* placeholder is set so add character */
                inc[t] = 0;
                break;
              case '^':
                block2[t] = options.sym_charset[0]; /* placeholder is set so add character */
                inc[t] = 0;
                break;
              default:
                block2[t] = ' '; /* add pattern letter to word */
            }
          } /* for j=0 */

          while (!finished(block2, options) && !ctrlbreak) {
              if (!too_many_duplicates(block2, options))
                printpermutepattern(block2, options.pattern, options.literalstring, wordarray);
              increment(block2, options);
          }
          if (!too_many_duplicates(block2, options))
            printpermutepattern(block2, options.pattern, options.literalstring, wordarray);
          free(block2);
      }
    }
    else {
      if ((fptr = fopen(fpath,"a+")) == NULL) { /* append to file */
        printf("permute: File START could not be opened\n");
        printf("The problem is = %s\n", strerror(errno));
        exit(EXIT_FAILURE);
      }
      else {
        for (t = 0; t < sizePerm; t++) {
          wordlength += strlen(wordarray[t]);
        }
        wordlength++; /*for cr*/
        if (options.pattern == NULL) {
          if ((linecounter <= (linecount-1)) && (my_thread.bytecounter <= (bytecount - wordlength))) { /* not time to create a new file */
            for (t = 0; t < sizePerm; t++) {
              fprintf(fptr, "%s", wordarray[t]);
            }
            my_thread.bytecounter+=wordlength;
            fprintf(fptr, "\n");
//            my_thread.bytecounter++;
            linecounter++;
          }
          else {
            my_thread.bytetotal+=my_thread.bytecounter;
            linetotal+=linecounter;

            if (fclose(fptr) != 0) {
              printf("permute: fclose returned error number = %d\n", errno);
              printf("The problem is = %s\n", strerror(errno));
              exit(EXIT_FAILURE);
            }

            renamefile(((wordlength*2)+5), fpath, outputfilename, compressalgo);
            if ((fptr = fopen(fpath, "w")) == NULL) {
              printf("permute2: Ouput file START could not be opened\n");
              exit(EXIT_FAILURE);
            }
            linecounter = 0;
            my_thread.bytecounter = 0;
            for (t = 0; t < sizePerm; t++) {
              fprintf(fptr, "%s", wordarray[t]);
            }
            my_thread.bytecounter+=wordlength;
            fprintf(fptr, "\n");
//            my_thread.bytecounter++;
            linecounter++;
          }
        }
        else { /* user specified a pattern */
          block2 = calloc(options.plen+1,sizeof(char)); /* block can't be bigger than max size */
          if (block2 == NULL) {
            printf("permute2: can't allocate memory for block2\n");
            exit(EXIT_FAILURE);
          }

          for (t = 0; t < options.plen; t++) {
            switch (options.pattern[t]) {
              case '@':
                block2[t] = options.low_charset[0]; /* placeholder is set so add character */
                inc[t] = 0;
                break;
              case ',':
                block2[t] = options.upp_charset[0]; /* placeholder is set so add   character */
                inc[t] = 0;
                break;
              case '%':
                block2[t] = options.num_charset[0]; /* placeholder is set so add character */
                inc[t] = 0;
                break;
              case '^':
                block2[t] = options.sym_charset[0]; /* placeholder is set so add character */
                inc[t] = 0;
                break;
              default:
                block2[t] = ' '; /* add pattern letter to word */
            }
          } /* for j=0 */

          while (!finished(block2, options) && !ctrlbreak) {
            if ((linecounter <= (linecount-1)) && (my_thread.bytecounter <= (bytecount - wordlength))) { /* not time to create a new file */
              if (!too_many_duplicates(block2, options))
                printpermutepattern(block2, options.pattern, options.literalstring, wordarray);
              increment(block2, options);
            }
            else {
              my_thread.bytetotal+=my_thread.bytecounter;
              linetotal+=linecounter;

              if (fptr == NULL) {
                printf("permute: something really bad happened1\n");
                exit(EXIT_FAILURE);
              }
              else {
                if (fclose(fptr) != 0) {
                  printf("permute2: fclose returned error number = %d\n", errno);
                  printf("The problem is = %s\n", strerror(errno));
                  exit(EXIT_FAILURE);
                }
              }

              renamefile(((wordlength*2)+5), fpath, outputfilename, compressalgo);
              if ((fptr = fopen(fpath, "w")) == NULL) {
                printf("permute2: Ouput file START could not be opened\n");
                free(block2);
                exit(EXIT_FAILURE);
              }
              linecounter = 0;
              my_thread.bytecounter = 0;
            }
          }
          if (!too_many_duplicates(block2, options))
            printpermutepattern(block2, options.pattern, options.literalstring, wordarray);
          free(block2);
        }
        
        if (fptr == NULL) {
          printf("permute2: something really bad happened1\n");
          exit(EXIT_FAILURE);
        }
        else {
          if (ferror(fptr) != 0) {
            printf("permute2: fprintf failed = %d\n", errno);
            printf("The problem is = %s\n", strerror(errno));
            exit(EXIT_FAILURE);
          }
          if (fclose(fptr) != 0) {
            printf("permute3: fclose returned error number = %d\n", errno);
            printf("The problem is = %s\n", strerror(errno));
            exit(EXIT_FAILURE);
          }
        }
      }
    }
  }
}

static void Permutefilesize(char **wordarray, const size_t sizePerm, const size_t length, size_t unchanged) {
size_t outer = 0;
size_t inner = 0;
size_t t;
char *temp[1];

  if (sizePerm > unchanged) {
    for(outer = unchanged; outer < sizePerm; outer++) {
      *temp = wordarray[outer];
      for(inner = outer; inner > unchanged; inner--) {
        wordarray[inner] = wordarray[inner - 1];
      }
      wordarray[unchanged] = *temp;
      Permutefilesize(wordarray, sizePerm, length, unchanged+1);

      for(inner = unchanged; inner < outer; inner++) {
        wordarray[inner] = wordarray[inner + 1];
      }
      wordarray[outer] = *temp;
    }
  }
  else {
    for (t = 0; t < length; t++) {
      my_thread.bytecounter+=(unsigned long long)strlen(wordarray[t]);
    }
    my_thread.bytecounter++;
  }
}

static void loadstring(char *block2, const size_t j, const char *startblock, const options_type options) {
size_t k;

  if (startblock == NULL) { /* is startblock null? */
    if (options.pattern == NULL) { /* Yes so now test if pattern null? */
      block2[j] = options.low_charset[0]; /* pattern is null so add character */
      inc[j] = 0;
    }
    else { /* pattern is not null */
      switch (options.pattern[j]) {
        case '@':
          if (options.literalstring[j] != '@') {
            block2[j] = options.low_charset[0]; /* placeholder is set so add character */
            inc[j] = 0;
          }
          else {
           block2[j] = options.pattern[j]; /* add pattern letter to word */
          }
          break;
        case ',':
          if (options.literalstring[j] != ',') {
            block2[j] = options.upp_charset[0]; /* placeholder is set so add character */
            inc[j] = 0;
          }
          else {
            block2[j] = options.pattern[j]; /* add pattern letter to word */
          }
          break;
        case '%':
          if (options.literalstring[j] != '%') {
            block2[j] = options.num_charset[0]; /* placeholder is set so add character */
            inc[j] = 0;
          }
          else {
            block2[j] = options.pattern[j]; /* add pattern letter to word */
          }
          break;
        case '^':
          if (options.literalstring[j] != '^') {
            block2[j] = options.sym_charset[0]; /* placeholder is set so add character */
            inc[j] = 0;
          }
          else {
            block2[j] = options.pattern[j]; /* add pattern letter to word */
          }
          break;
        default:
          block2[j] = options.pattern[j]; /* add pattern letter to word */
        }
      }
    }
    else { /* startblock is not null */
      if (options.pattern == NULL) { /* Yes so now test if pattern null? */
        block2[j] = startblock[j]; /* pattern is null so add character */
        for(k = 0; k < strlen(options.low_charset); k++) {
          if (block2[j] == options.low_charset[k]) {
            inc[j] = k;
          }
        }
      }
      else {
        switch (options.pattern[j]) {
          case '@':
            if (options.literalstring[j] != '@') {
              block2[j] = startblock[j]; /* pattern is null so add character */
              for(k = 0; k < strlen(options.low_charset); k++)
                if (block2[j] == options.low_charset[k])
                  inc[j] = k;
            }
            else {
              block2[j] = options.pattern[j]; /* add pattern letter to word */
            }
          break;
          case ',':
            if (options.literalstring[j] != ',') {
              block2[j] = startblock[j]; /* pattern is null so add character */
              for(k = 0; k < strlen(options.upp_charset); k++)
                if (block2[j] == options.upp_charset[k])
                  inc[j] = k;
            }
            else {
              block2[j] = options.pattern[j]; /* add pattern letter to word */
            }
          break;
          case '%':
            if (options.literalstring[j] != '%') {
              block2[j] = startblock[j]; /* pattern is null so add character */
              for(k = 0; k < strlen(options.num_charset); k++)
                if (block2[j] == options.num_charset[k])
                  inc[j] = k;
            }
            else {
              block2[j] = options.pattern[j]; /* add pattern letter to word */
            }
          break;
          case '^':
            if (options.literalstring[j] != '^') {
              block2[j] = startblock[j]; /* pattern is null so add character */
              for(k = 0; k < strlen(options.sym_charset); k++)
                if (block2[j] == options.sym_charset[k])
                  inc[j] = k;
            }
            else {
              block2[j] = options.pattern[j]; /* add pattern letter to word */
            }
          break;
          default:
            block2[j] = options.pattern[j]; /* add pattern letter to word */
        }
      }
    } /* for j=0 */
  
}

static void chunk(const size_t start, const size_t end, const char *startblock, const options_type options, const char *fpath, const char *outputfilename, const char *compressalgo) {
size_t i,j;      /* loop counters */
char *block2;      /* block is word being created */

  errno = 0;
  block2 = calloc(end+1,sizeof(char)); /* block can't be bigger than max size */
  if (block2 == NULL) {
    printf("chunk: can't allocate memory for block2\n");
    exit(EXIT_FAILURE);
  }

  for (i = start; (i <= end) && !ctrlbreak; i++) {
    for (j = 0; j < i; j++) {
      loadstring(block2, j, startblock, options);
    }
    startblock = NULL;

    if (outputfilename == NULL) { /* user wants to display words on screen */
      if (options.endstring == NULL) {
        while (!finished(block2,options) && !ctrlbreak) {
          if (!too_many_duplicates(block2, options)) {
            fprintf(fptr, "%s\n", block2);
          }
          increment(block2, options);
        }
        if (!too_many_duplicates(block2, options)) { /*flush last word */
          fprintf(fptr, "%s\n", block2);
        }
      }
      else {
        while (!finished(block2,options) && !ctrlbreak && (strncmp(block2,options.endstring,strlen(options.endstring)) != 0)) {
          if (!too_many_duplicates(block2, options)) {
            fprintf(fptr, "%s\n", block2);
            linecounter++;
          }
          increment(block2, options);
        }
        if (!too_many_duplicates(block2, options)) { /*flush last word */
          fprintf(fptr, "%s\n", block2);
        }
        if (strncmp(block2,options.endstring,strlen(options.endstring)) == 0)
          break;
      }
    }
    else { /* user wants to generate a file */
      if ((fptr = fopen(fpath,"a+")) == NULL) { /* append to file */
        printf("chunk1: File START could not be opened\n");
        printf("The problem is = %s\n", strerror(errno));
        exit(EXIT_FAILURE);
      }
      else { /* file opened start writing.  file will be renamed when done */
        while (!finished(block2, options) && (ferror(fptr) == 0) && !ctrlbreak) {
          if ((options.endstring != NULL) && (strncmp(block2,options.endstring,strlen(options.endstring)) == 0))
            break;
          if ((linecounter <= (linecount-1)) && (my_thread.bytecounter <= (bytecount - strlen(block2)))) { /* not time to create a new file */
            if (!too_many_duplicates(block2, options)) {
              fprintf(fptr, "%s\n", block2);
              if (ferror(fptr) != 0) {
                printf("chunk1: fprintf failed = %d\n", errno);
                printf("The problem is = %s\n", strerror(errno));
                free(block2);
                exit(EXIT_FAILURE);
              }
              my_thread.bytecounter += (unsigned long long)strlen(block2)+1;
              linecounter++;
            }
            increment(block2,options);
          }
          else { /* time to create a new file */
            my_thread.bytetotal+=my_thread.bytecounter;
            linetotal+=linecounter;

            if (fclose(fptr) != 0) {
              printf("chunk1: fclose returned error number = %d\n",errno);
              printf("The problem is = %s\n", strerror(errno));
              free(block2);
              exit(EXIT_FAILURE);
            }
            renamefile(end, fpath, outputfilename, compressalgo);
    
            if (options.endstring == NULL) {
              if ((fptr = fopen(fpath, "w")) == NULL) {
                printf("chunk2: Ouput file START could not be opened\n");
                free(block2);
                exit(EXIT_FAILURE);
              }
              linecounter = 0;
              my_thread.bytecounter = 0;
            }
            else {
              goto killloop;
            }
          }
        }

        if (fptr == NULL) {
          printf("chunk: something really bad happened\n");
          exit(EXIT_FAILURE);
        }
        else {
          if (!too_many_duplicates(block2, options)) {

            fprintf(fptr, "%s\n", block2); /* flush the last word */

            linecounter++;
            linetotal+=linecounter;
            my_thread.bytecounter += (unsigned long long)strlen(block2)+1;

            if (ferror(fptr) != 0) {
              printf("chunk2: fprintf failed = %d\n", errno);
              printf("The problem is = %s\n", strerror(errno));
              free(block2);
              exit(EXIT_FAILURE);
            }
          }
          if (fclose(fptr) != 0) {
            printf("chunk2: fclose returned error number = %d\n", errno);
            printf("The problem is = %s\n", strerror(errno));
            free(block2);
            exit(EXIT_FAILURE);
          }

          if ((options.endstring != NULL) && (strncmp(block2,options.endstring,strlen(options.endstring)) == 0))
            break;

          if (ctrlbreak == 1)
            break;
        }
      } /* else from if fopen */
    } /* else from outputfilename == NULL */
  } /* for start < end loop */

  if (ctrlbreak == 1 ) {
    printf("Crunch ending at %s\n",block2);
  }

  killloop:
  my_thread.bytetotal += my_thread.bytecounter;

  if ((outputfilename != NULL) && !ctrlbreak) {
    renamefile(end, fpath, outputfilename, compressalgo);
  }

  free(block2);
}

static void usage() {
  printf("crunch version %s\n\n", version);
  printf("Please refer to the man page for instructions and examples on how to use crunch.\n");
}

static char *resumesession(const char *fpath, const char *charset) {
FILE *optr;     /* ptr to START output file; will be renamed later */
char buff[512]; /* buffer to hold line from wordlist */
char *startblock;
size_t j, k;

  errno = 0;
  memset(buff, 0, sizeof(buff));

  if ((optr = fopen(fpath,"r")) == NULL) {
    printf("resume: File START could not be opened\n");
    exit(EXIT_FAILURE);
  }
  else {  /* file opened above now read first line */
    while (feof(optr) == 0) {
      (void)fgets(buff, (int)sizeof(buff), optr);
      ++linecounter;
      my_thread.bytecounter += (unsigned long long)strlen(buff);
    } /* all of this just to get last line */
    linecounter--; /* -1 to get correct num */
    my_thread.bytecounter -= (unsigned long long)strlen(buff);

    if (fclose(optr) != 0) {
      printf("resume: fclose returned error number = %d\n", errno);
      printf("The problem is = %s\n", strerror(errno));
      exit(EXIT_FAILURE);
    }
    startblock = calloc(strlen(buff), sizeof(char));
    if (startblock == NULL) {
      printf("resume: can't allocate memory for startblock\n");
      exit(EXIT_FAILURE);
    }
    memcpy(startblock, buff, strlen(buff)-1);
    printf("Resuming from = %s\n", startblock);

    for (j = 0; j < strlen(startblock); j++) {
      for(k = 0; k < strlen(charset); k++)
        if (startblock[j] == charset[k])
          inc[j] = k;
    }
  return startblock;
  }
}

static char *readcharsetfile(const char *charfilename, const char *charsetname) {
FILE *optr;  /* ptr to user specified charset file */
char *temp;  /* holds character set name from charset file */
char *chars; /* holds characters from specified charsetname i.e. stuff after [ */
char *charset = NULL; /* holds the characters to used */
char buff[512]; /* buffer to hold line from charset file */

  errno = 0;
  memset(buff, 0, sizeof(buff));
  if ((optr = fopen(charfilename,"r")) == NULL) { /* open file to read from */
    printf("readcharset: File %s could not be opened\n", charfilename);
    printf("The problem is = %s\n", strerror(errno));
    exit(EXIT_FAILURE);
  }
  else {  /* file opened above now scan file for charsetname */
    while (fgets(buff, (int)sizeof(buff), optr) != NULL) {
      temp = strtok(buff, " ");
      if (strcmp(charsetname, temp)==0) {
        chars = strtok(NULL, "["); /* move to = sign in file */
        if ((chars = strtok(NULL, "\n")) != NULL) { /* get rest of string after [ */
          charset = calloc(strlen(chars), sizeof(char));
          if (charset == NULL) {
            printf("readcharset: can't allocate memory for charset\n");
            exit(EXIT_FAILURE);
          }
          if (strncmp(&chars[(strlen(chars)-1)], "]", 1) == 0)
            memcpy(charset, chars, strlen(chars)-1); /* don't strip off space only ]*/
          else
            memcpy(charset, chars, strlen(chars)-2); /* strip off ] */
        }
        break;
      }
    }
    if (fclose(optr) != 0) {
      printf("readcharset: fclose returned error number = %d\n", errno);
      printf("The problem is = %s\n", strerror(errno));
      exit(EXIT_FAILURE);
    }
  }
  return charset;
}

static char **readpermute(const char *charfilename) {
FILE *optr;  /* ptr to user specified charset file */
char **wordarray2; /* holds characters from specified charsetname */
char buff[512]; /* buffer to hold line from charset file */
size_t temp = 0;

  errno = 0;
  numofelements = 0;
  memset(buff, 0, sizeof(buff));
  if ((optr = fopen(charfilename,"r")) == NULL) { /* open file to read from */
    printf("readpermute: File %s could not be opened\n", charfilename);
    printf("The problem is = %s\n", strerror(errno));
    exit(EXIT_FAILURE);
  }
  else {  /* file opened above now get the number of line in file */
    flag2 = 1;
    while (fgets(buff, (int)sizeof(buff), optr) != NULL) {
      if (buff[0] != '\n')
        numofelements++;
    }
    (void)fseek(optr, 0, SEEK_SET);

    wordarray2 = calloc(numofelements, sizeof(*wordarray2));
    if (wordarray2 == NULL) {
      printf("readpermute: can't allocate memory for wordarray1\n");
      exit(EXIT_FAILURE);
    }
    while (fgets(buff, (int)sizeof(buff), optr) != NULL) {
      if (buff[0] != '\n') {
        wordarray2[temp] = calloc(strlen(buff), sizeof(char));
        if (wordarray2[temp] == NULL) {
          printf("readpermute: can't allocate memory for wordarray2\n");
          exit(EXIT_FAILURE);
        }
        memcpy(wordarray2[temp], buff, strlen(buff)-1);
        temp++;
      }
    }

    if (fclose(optr) != 0) {
      printf("readpermute: fclose returned error number = %d\n", errno);
      printf("The problem is = %s\n", strerror(errno));
      exit(EXIT_FAILURE);
    }
  return wordarray2;
  }
}

int main(int argc, char **argv) {
size_t flag = 0;   /* 0 for chunk 1 for permute */
size_t flag3 = 0;  /* 0 display file size info 1 supress file size info */
size_t flag4 = 0;  /* 0 don't create thread 1 create print % done thread */
size_t loaded = 0; /* loaded wordarray from specified file */
size_t resume = 0; /* 0 new session 1 for resume */
size_t arglen = 0; /* used in -b option to hold strlen */
size_t min, max;   /* minimum and maximum size */
size_t temp;       /* temp varible */

unsigned long calc = 0;  /* recommend count */
unsigned long dupvalue; /* value for duplicates option */

int i = 3;      /* minimum number of parameters */
int ret = 0;    /* return value of pthread_create */
int multi = 0;

char *charset; /* character set */
char *upp_charset = NULL;
char *num_charset = NULL;
char *sym_charset = NULL;
char *startblock = NULL; /* user specified starting point */
char *pattern = NULL;    /* user specified pattern */
char *fpath = NULL;          /* path to outputfilename if specified*/
char *outputfilename = NULL; /* user specified filename to write output to */
char *compressalgo = NULL;   /* user specified compression program */
char *endstring = NULL;      /* hold -e option */
char *charsetfilename = NULL;
char *tempfilename = NULL;
char *bcountval = NULL;
char *literalstring = NULL; /* user passed something using -l */
char *hold;
char *endptr; /* temp pointer for duplicates option */

options_type options; /* store validated parameters passed to the program */

char **wordarray; /* array to store words */

pthread_t threads;

  (void) signal(SIGINT, ex_program);
//  (void) signal(SIGINFO, printme);

  memset(&threads,0,sizeof(threads));
  fptr = stdout;

  if ((argc == 2) && (strncmp(argv[1], "-v", 2) == 0)) {  /* print version information */
    printf("crunch version %s\n", version);
    return 0;
  }

  if (argc < 3) {
    usage();
    return 0;
  }
  charset = calloc(27, sizeof(char));
  if (charset == NULL) {
    printf("crunch: can't allocate memory for default charset\n");
    exit(EXIT_FAILURE);
  }
  memcpy(charset, def_low_charset, 26);

  upp_charset = calloc(27, sizeof(char));
  if (upp_charset == NULL) {
    printf("crunch: can't allocate memory for default upp_charset\n");
    exit(EXIT_FAILURE);
  }
  memcpy(upp_charset, def_upp_charset, 26);

  num_charset = calloc(11, sizeof(char));
  if (num_charset == NULL) {
    printf("crunch: can't allocate memory for default num_charset\n");
    exit(EXIT_FAILURE);
  }
  memcpy(num_charset, def_num_charset, 10);

  sym_charset = calloc(34, sizeof(char));
  if (sym_charset == NULL) {
    printf("crunch: can't allocate memory for default sym_charset\n");
    exit(EXIT_FAILURE);
  }
  memcpy(sym_charset, def_sym_charset, 33);

  if (argc >= 4) {
    if ((argc > i) && (*argv[i] != '-')) { /*test for ./crunch 1 2 -? */
      if (*argv[i] != '+') {
        free(charset);
        charset = calloc(strlen(argv[i])+1, sizeof(char)); /* user specified lower charset */
        if (charset == NULL) {
          printf("crunch: can't allocate memory for user charset\n");
          exit(EXIT_FAILURE);
        }
        /* remove duplicate characters from user defined charset */
        for (min = 0; min < strlen(argv[i]); min++) {
          temp = 0;
          for (max = 0; max < strlen(charset); max++)
            if (argv[i][min] == charset[max])
              temp = 1;
            if (temp == 0)
              strncat(charset, &argv[i][min], 1);
        }
      }
      i++; /* user specified a charset and a parameter */
    }

    if ((argc > i) && (*argv[i] != '-')) { /*test for ./crunch 1 2 -? */
      if (*argv[i] != '+') {
        free(upp_charset);
        upp_charset = calloc(strlen(argv[i])+1, sizeof(char)); /* user specified upp_charset */
        if (upp_charset == NULL) {
          printf("crunch: can't allocate memory for upp_charset\n");
          exit(EXIT_FAILURE);
        }
        /* remove duplicate characters from user defined charset */
        for (min = 0; min < strlen(argv[i]); min++) {
          temp = 0;
          for (max = 0; max < strlen(upp_charset); max++)
            if (argv[i][min] == upp_charset[max])
              temp = 1;
            if (temp == 0)
              strncat(upp_charset, &argv[i][min], 1);
        }
      }
      i++; /* user specified a upp_charset and a parameter */
    }
    if ((argc > i) && (*argv[i] != '-')) { /*test for ./crunch 1 2 -? */
      if (*argv[i] != '+') {
        free(num_charset);
        num_charset = calloc(strlen(argv[i])+1, sizeof(char)); /* user specified num_charset */
        if (num_charset == NULL) {
          printf("crunch: can't allocate memory for num_charset\n");
          exit(EXIT_FAILURE);
        }
        memcpy(num_charset, argv[i], strlen(argv[i]));
      }
      i++; /* user specified a num_charset and a parameter */
    }
    if ((argc > i) && (*argv[i] != '-')) { /*test for ./crunch 1 2 -? */
      if (*argv[i] != '+') {
        free(sym_charset);
        sym_charset = calloc(strlen(argv[i])+1, sizeof(char)); /* user specified sym_charset */
        if (sym_charset == NULL) {
          printf("crunch: can't allocate memory for sym_charset\n");
          exit(EXIT_FAILURE);
        }
        memcpy(sym_charset, argv[i], strlen(argv[i]));
      }
      i++; /* user specified a sym_charset and a parameter */
    }
  }

  min = (size_t)atoi(argv[1]);
  max = (size_t)atoi(argv[2]);

  if (max < min) {
    printf("Starting length is greater than the ending length\n");
    exit(EXIT_FAILURE);
  }

  if (max > MAXSTRING) {
    printf("Crunch can only make words with a length of less than %d characters\n", MAXSTRING+1);
    exit(EXIT_FAILURE);
  }
  
  for (temp = 0; temp < 4; temp++)
    options.duplicates[temp] = ULONG_MAX;

  for (; i<argc; i+=2) { /* add 2 to skip the parameter value */
    if (strncmp(argv[i], "-b", 2) == 0) { /* user wants to split files by size */
      if (i+1 < argc) {
        bcountval = argv[i+1];
        if (bcountval != NULL) {
          arglen = strlen(bcountval);

          for (temp = 0; temp < arglen; temp++)
            bcountval[temp] = tolower(bcountval[temp]);

          if (strstr(bcountval, "kb") != 0) multi=1000;
          else if (strstr(bcountval, "mb")  != 0) multi = 1000000;
          else if (strstr(bcountval, "gb")  != 0) multi = 1000000000;
          else if (strstr(bcountval, "kib") != 0) multi = 1024;
          else if (strstr(bcountval, "mib") != 0) multi = 1048576;
          else if (strstr(bcountval, "gib") != 0) multi = 1073741824;

          calc = strtoul(bcountval, NULL, 10);
          bytecount = calc * multi;
          if (calc > 4 && multi >= 1073741824 && bytecount <= 4294967295ULL) {
            printf("ERROR: Your system is unable to process numbers greater than 4.294.967.295. Please specify a filesize <= 4GiB.\n");
            exit(EXIT_FAILURE);
          }
        }
        else {
          printf("bvalue has a serious problem\n");
          exit(EXIT_FAILURE);
        }
      }
      else {
        printf("Please specify a value\n");
        exit(EXIT_FAILURE);
      }
    }

    if (strncmp(argv[i], "-c", 2) == 0) {
      if (i+1 < argc) {
        linecount = strtoul(argv[i+1], NULL, 10);
        if ((linecount*max) > 2147483648UL) {
          calc = (2147483648UL/(unsigned long)max);
          printf("WARNING: resulting file will probably be larger than 2GB \n");
          printf("Some applications (john the ripper) can't use wordlists greater than 2GB\n");
          printf("A value of %lu ",calc);
          printf("or less should result in a file less than 2GB\n");
          printf("The above value is calcualated based on 2147483648UL/max\n");
          exit(EXIT_FAILURE);
        }
      }
      else {
        printf("Please specify the number of lines you want\n");
        exit(EXIT_FAILURE);
      }
    }

    if (strncmp(argv[i], "-d", 2) == 0) {  /* specify duplicates to skip */
      if (i+1 < argc) {
        dupvalue = strtoul(argv[i+1], &endptr, 10);
        if (argv[i+1] == NULL || endptr == argv[i+1]) {
          printf("-d must be followed by [n][@,%%^]\n");
          exit(EXIT_FAILURE);
        }
        if (*endptr == '\0') /* default to @ charset */
          options.duplicates[0] = dupvalue; 
        while (*endptr != '\0') {
          switch (*endptr) {
            case '@':
              options.duplicates[0] = dupvalue;
              break;
            case ',':
              options.duplicates[1] = dupvalue;
              break;
            case '%':
              options.duplicates[2] = dupvalue;
              break;
            case '^':
              options.duplicates[3] = dupvalue;
              break;
            default:
              printf("the type of duplicates must be one of [@,%%^]\n");
              exit(EXIT_FAILURE);
              break;
          }
          endptr++;
        }
      }
      else {
        printf("Please specify the type of duplicates to skip\n");
        exit(EXIT_FAILURE);
      }
    }

    if (strncmp(argv[i], "-e", 2) == 0) {
      if (i+1 < argc) {
        endstring = argv[i+1];
      }
      else {
        printf("Please specify the string you want crunch to stop at\n");
        exit(EXIT_FAILURE);
      }
    }

    if (strncmp(argv[i], "-f", 2) == 0) { /* user specified a charset.lst */
      if (i+1 < argc) {
        charsetfilename = calloc(strlen(argv[i+1]), sizeof(char)); 
        if (charsetfilename == NULL) {
          printf("can't allocate memory for charsetfilename\n");
          exit(EXIT_FAILURE);
        }
        memcpy(charsetfilename, argv[i+1], strlen(argv[i+1]));
        i += 2; /* skip -f and filename */
      }

      if ((i < argc) && (argv[i] != NULL) && (*argv[i] != '-')) { /* lowercase */
        free(charset);
        charset = readcharsetfile(charsetfilename, argv[i]);
        if (charset == NULL) {
          printf("charset = %s not found in %s\n", argv[i], charsetfilename);
          exit(EXIT_FAILURE);
        }
        else {
          numofelements = strlen(charset);
          wordarray = calloc(numofelements, sizeof(*wordarray));
          if (wordarray == NULL) {
            printf("can't allocate memory for wordarray1\n");
            exit(EXIT_FAILURE);
          }
          for (temp = 0; temp < numofelements; temp++) {
            wordarray[temp] = calloc(2, sizeof(char)); /* space for letter + \0 */
            if (wordarray[temp] == NULL) {
              printf("can't allocate memory for wordarray2\n");
              exit(EXIT_FAILURE);
            }
            wordarray[temp][0] = charset[temp];
            wordarray[temp][1] = '\0';
          }
          loaded = 1;
          i++;
        }

/* uppercase */
        if ((i < argc) && (*argv[i] != '-')) {
          if (*argv[i] != '+') {
            free(upp_charset);
            upp_charset = readcharsetfile(charsetfilename, argv[i]);
            if (upp_charset == NULL) {
              printf("upp_charset = %s not found in %s\n", argv[i], charsetfilename);
              exit(EXIT_FAILURE);
            }
          }
          i++;
        }
/* numbers */
        if ((i < argc) && (*argv[i] != '-')) {
          if (*argv[i] != '+') {
            free(num_charset);
            num_charset = readcharsetfile(charsetfilename, argv[i]);
            if (num_charset == NULL) {
              printf("num_charset = %s not found in %s\n", argv[i], charsetfilename);
              exit(EXIT_FAILURE);
            }
          }
          i++;
        }
/* symbols */
        if ((i < argc) && (*argv[i] != '-')) {
          if (*argv[i] != '+') {
            free(sym_charset);
            sym_charset = readcharsetfile(charsetfilename, argv[i]);
            if (sym_charset == NULL) {
              printf("sym_charset = %s not found in %s\n", argv[i], charsetfilename);
              exit(EXIT_FAILURE);
            }
          }
        }
        i -= 2; /* have to subtract 2 to continue processing parameter values */
      }
      else {
        printf("Please specify a filename and character set\n");
        exit(EXIT_FAILURE);
      }
    }

    if (strncmp(argv[i], "-i", 2) == 0) { /* user wants to invert output calculation */
      inverted = 1;
      i--; /* decrease by 1 since -i has no parameter value */
    }

    if (strncmp(argv[i], "-l", 2) == 0) { /* user wants to list literal characters */
      if (i+1 < argc) {
        literalstring = argv[i+1];
      }
      else {
        printf("Please specify a list of characters you want to treat as literal @?%%^\n");
        exit(EXIT_FAILURE);
      }
    }

    if (strncmp(argv[i], "-o", 2) == 0) {  /* outputfilename specified */
      flag4=1;
      if (i+1 < argc) {
        hold = strrchr(argv[i+1], '/');
        outputfilename = argv[i+1];
        if (hold == NULL) {
          fpath = calloc(6, sizeof(char));
          if (fpath == NULL) {
            printf("crunch: can't allocate memory for fpath1\n");
            exit(EXIT_FAILURE);
          }
          memcpy(fpath, "START", 5);
          tempfilename = outputfilename;
        }
        else {
          temp = strlen(argv[i+1])-strlen(hold)+1;
          tempfilename = &argv[i+1][temp];
          fpath = calloc(temp+6, sizeof(char)); /* 6 for START +1 */
          if (fpath == NULL) {
            printf("crunch: can't allocate memory for fpath2\n");
            exit(EXIT_FAILURE);
          }
          memcpy(fpath, argv[i+1], temp);
          strncat(fpath, "START", 5);
        }
      }
      else {
        printf("Please specify a output filename\n");
        exit(EXIT_FAILURE);
      }
    }

    if (strncmp(argv[i], "-p", 2) == 0) { /* user specified letters/words to permute */
      if (i+1 < argc) {
        flag = 1;
        numofelements = (size_t)(argc-i)-1;

        if (numofelements == 1) {
          flag2 = 1;
          numofelements = strlen(argv[argc-1]);

          wordarray = calloc(numofelements, sizeof(*wordarray));
          if (wordarray == NULL) {
            printf("can't allocate memory for wordarray3\n");
            exit(EXIT_FAILURE);
          }

          for (temp = 0; temp < numofelements; temp++) {
            wordarray[temp] = calloc(2, sizeof(char)); /* space for letter + \0 char */
            if (wordarray[temp] == NULL) {
              printf("can't allocate memory for wordarray2\n");
              exit(EXIT_FAILURE);
            }
            wordarray[temp][0] = argv[i+1][temp];
            wordarray[temp][1] = '\0';
          }
        }
        else {
          wordarray = calloc(numofelements, sizeof(*wordarray));
          if (wordarray == NULL) {
            printf("can't allocate memory for wordarray3\n");
            exit(EXIT_FAILURE);
          }

          for (temp = 0; temp < numofelements; temp++, i++) {
            wordarray[temp] = argv[i+1];
          }
        }
        /* sort wordarray so the results are sorted */
        qsort(wordarray, temp, sizeof(char *), cstring_cmp);
      }
      else {
        printf("Please specify a word or words to permute\n");
        exit(EXIT_FAILURE);
      }
    }

    if (strncmp(argv[i], "-q", 2) == 0) { /* user specified file of words to permute */
      if (i+1 < argc) {
        wordarray = readpermute(argv[i+1]);
        /* sort wordarray so the results are sorted */
        qsort(wordarray, numofelements, sizeof(char *), cstring_cmp);
        flag = 1;
      }
      else {
        printf("Please specify a filename for permute to read\n");
        exit(EXIT_FAILURE);
      }
    }

    if (strncmp(argv[i], "-r", 2) == 0) { /* user wants to resume a previous session */
      resume = 1;
      i--; /* decrease by 1 since -r has no parameter value */
    }

    if (strncmp(argv[i], "-s", 2) == 0) { /* startblock specified */
      if (i+1 < argc) {
        if (strlen(argv[i+1]) != min) {
          printf("Warning: minimum length should be %d\n", (int)strlen(argv[i+1]));
          exit(EXIT_FAILURE);
        }
        else
          startblock = argv[i+1];
      }
      else {
        printf("Please specify the number of lines you want\n");
        exit(EXIT_FAILURE);
      }
    }

    if (strncmp(argv[i], "-t", 2) == 0) { /* pattern specified */
      if (i+1 < argc) {
        if ((max > strlen(argv[i+1])) || (min < strlen(argv[i+1]))) {
          printf("The maximum and minimum length should be the same size as the pattern you specified. \n");
          printf("min = %d  max = %d  strlen = %s\n",(int)min, (int)max, argv[i+1]);
          exit(EXIT_FAILURE);
        }
        else
          pattern = argv[i+1];
      }
      else {
        printf("Please specify a pattern\n");
        exit(EXIT_FAILURE);
      }
    }

    if (strncmp(argv[i], "-u", 2) == 0) {  /* suppress filesize info */
      flag3 = 1;
      i--;
    }

    if (strncmp(argv[i], "-z", 2) == 0) {  /* compression algorithm specified */
      if (i+1 < argc) {
        compressalgo = argv[i+1];
        if ((compressalgo != NULL) && (strcmp(compressalgo, "gzip") != 0) && (strcmp(compressalgo, "bzip2") != 0) &&   (strcmp(compressalgo,"lzma") != 0)) {
          printf("Only gzip, bzip2, and lzma are supported\n");
          exit(EXIT_FAILURE);
        }
      }
      else {
        printf("Only gzip, bzip2, and lzma are supported\n");
        exit(EXIT_FAILURE);
      }
    }
  } /* end parameter processing */

  /* parameter validation */
  if ((literalstring != NULL) && (pattern == NULL)) {
    printf("you must specify -t when using -l\n");
    exit(EXIT_FAILURE);
  }

  if ((literalstring != NULL) && (pattern != NULL)) {
    if (strlen(literalstring) != strlen(pattern)) {
      printf("Length of literal string should be the same length as pattern^\n");
      exit(EXIT_FAILURE);
    }
  }

  if (tempfilename != NULL) {
    if ((bytecount > 0) && (strcmp(tempfilename, "START") != 0)) {
      printf("you must use -o START if you specify a count\n");
      exit(EXIT_FAILURE);
    }
  }

  if (endstring != NULL) { 
    if (max != strlen(endstring)) {
      printf("End string length must equal maximum string size\n");
      exit(EXIT_FAILURE);
    }
  }
  
  if (startblock != NULL && endstring != NULL) {
    for (temp = 0; temp < strlen(startblock); temp++) {
      if (startblock[temp] > endstring[temp]) {
        printf("End string must be greater than start string\n");
        exit(EXIT_FAILURE);
      }
      if (startblock[temp] < endstring[temp])
        break;
    }
  }

  if (literalstring == NULL) { /* create a default literalstring */
    literalstring = calloc(max+1, sizeof(*literalstring));
    if (literalstring == NULL) {
      printf("can't allocate memory for literalstring\n");
      exit(EXIT_FAILURE);
    }
    for (i = 0; i < max; i++)
      literalstring[i] = '-';
    literalstring[max] = '\0';
  }
    
  options.low_charset = charset;
  options.upp_charset = upp_charset;
  options.num_charset = num_charset;
  options.sym_charset = sym_charset;
  options.clen = charset ? strlen(charset) : 0;
  options.ulen = upp_charset ? strlen(upp_charset) : 0;
  options.nlen = num_charset ? strlen(num_charset) : 0;
  options.slen = sym_charset ? strlen(sym_charset) : 0;
  options.pattern = pattern;
  options.plen = pattern ? strlen(pattern) : 0;
  options.literalstring = literalstring;
  options.endstring = endstring;
  options.max = max;

  if (pattern != NULL && startblock != NULL) 
      if (!check_member(startblock, options)) {
        printf("startblock is not valid according to the pattern/literalstring\n");
        exit(EXIT_FAILURE);
      }
  if (pattern != NULL && endstring != NULL) 
      if (!check_member(endstring, options)) {
        printf("endstring is not valid according to the pattern/literalstring\n");
        exit(EXIT_FAILURE);
      }

  /* start processing */
  if (resume == 1) {
    if (startblock != NULL) {
      printf("you cannot specify a startblock and resume\n");
      exit(EXIT_FAILURE);
    }
    if (flag == 0) {
      startblock = resumesession(fpath, charset);
      min = strlen(startblock);
      increment(startblock, options);
    }
    if (flag == 1) {
      printf("permute doesn't support resume\n");
      exit(EXIT_FAILURE);
    }
  }
  else {
    if (fpath != NULL)
      (void)remove(fpath);
  }
  options.startstring = startblock;
  options.min = min;
  fill_minmax_strings(&options);
  fill_pattern_info(&options);
  
  if (flag == 0) { /* chunk */
    
    count_strings(&linecounter, &my_thread.finalfilesize, options);
      
    /* subtract already calculated data size */
    finallinecount = linecounter - linetotal;
    my_thread.finalfilesize -= my_thread.bytetotal;
    
    /* if ((linecount > 0) && (finallinecount > linecount)) {
      finallinecount = linecount - linetotal;
    */ /* TODO: must calculate finalfilesize during line calculation */
    
    if (flag3 == 0) {
      printf("Crunch will now generate the following amount of data: ");
      printf("%llu bytes\n",my_thread.finalfilesize);
      printf("%llu MB\n",my_thread.finalfilesize/1048576);
      printf("%llu GB\n",my_thread.finalfilesize/1073741824);
      printf("%llu TB\n",my_thread.finalfilesize/1099511627776);
      printf("%llu PB\n",my_thread.finalfilesize/1125899906842624);
      printf("Crunch will now generate the following number of lines: ");
      if (pattern == NULL)
        printf("%llu \n",finallinecount);
      else
        printf("%llu \n",my_thread.finalfilesize/(max+1));

      (void) sleep(3);
      if (flag4 == 1) {
        ret = pthread_create(&threads, NULL, PrintPercentage, (void *)&my_thread);
        if (ret != 0){
          printf("pthread_create error is %d\n", ret);
          exit(EXIT_FAILURE);
        }
        (void) pthread_detach(threads);
      }
    }
    my_thread.finalfilesize+=my_thread.bytetotal;
    linecounter = 0;

    chunk(min, max, startblock, options, fpath, outputfilename, compressalgo);
  }
  else { /* permute */
    finallinecount = 1;
    temp = 1;
    min = 0;

    /* calculate number of lines per section */
    while (temp <= numofelements) {
      finallinecount *= temp;
      temp++;
    }
    linecounter=finallinecount; /* hold factoral */

    if (pattern == NULL) {
      my_thread.finalfilesize = 1;
      for (temp = 0; temp <numofelements; temp++) {
        my_thread.finalfilesize += strlen(wordarray[temp]);
      }
      my_thread.finalfilesize *= linecounter;
    }
    else {
      temp = 0;
      for (temp = 0; temp < strlen(pattern); temp++) {
        switch (pattern[temp]) {
        case '@':
          if (literalstring[temp] != '@')
            finallinecount *= strlen(charset);
          break;
        case ',':
          if (literalstring[temp] != ',')
            finallinecount *= strlen(upp_charset);
          break;
        case '%':
          if (literalstring[temp] != '%')
            finallinecount *= strlen(num_charset);
          break;
        case '^':
          if (literalstring[temp] != '^')
            finallinecount *= strlen(sym_charset);
          break;
        default:
          min++;
          break;
        }
      }

      /* calculate filesize */
      Permutefilesize(wordarray, numofelements, min, 0);

      my_thread.finalfilesize = (finallinecount/linecounter) * (linecounter*(max-min)+my_thread.bytecounter);
    }
    
    if (flag3 == 0) {
      printf("Crunch will now generate approximately the following amount of data: ");
      printf("%llu bytes\n",my_thread.finalfilesize);
      printf("%llu MB\n",my_thread.finalfilesize/1048576);
      printf("%llu GB\n",my_thread.finalfilesize/1073741824);
      printf("%llu TB\n",my_thread.finalfilesize/1099511627776);
      printf("%llu PB\n",my_thread.finalfilesize/1125899906842624);
      printf("Crunch will now generate the following number of lines: ");
      printf("%llu \n",finallinecount);
      (void) sleep(3);
    }

    my_thread.bytecounter = 0;
    linecounter=0;

    Permute(fpath, outputfilename, compressalgo, wordarray, options, numofelements, 0);

    if (flag2 == 1) {
      for (temp = 0; temp < numofelements; temp++) {
        free(wordarray[temp]);
      }
    }

    free(wordarray);
    wordarray=NULL;

    my_thread.bytetotal+=my_thread.bytecounter;
    linetotal+=linecounter;
    if ((outputfilename != NULL) && (linecounter != 0))
      renamefile(((size_t)(finallinecount*2)+5), fpath, outputfilename, compressalgo);
  }

  free(fpath);
  free(charsetfilename);
  free(charset);
  free(upp_charset);
  free(num_charset);
  free(sym_charset);
  /* free(literalstring); */
  
  free(options.last_min);
  free(options.first_max);
  free(options.min_string);
  free(options.max_string);

  return 0;
}
