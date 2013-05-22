# include <stdio.h>
# include <stdlib.h>
# include <string.h>

// prototypes
// commandLine
char* cmdLine(int i, char *a, FILE *f);
// 1a. characters vs. occurences
int* letters(int *i, char *a);
// 1b. word length vs. occurences
// 1c. words vs. occurences 
// 1d. words vs. occurences (sorted alphabetically)
// 1e. words vs. occurences (sorted by occurences)

int size = 0;

int main(int argc, char *argv[]) {
  char *arrayp;
  int *intp;
  printf("input file: %s\n", argv[1]);
  FILE *filep = fopen(argv[1], "r");
  
  if(filep == 0)
    printf("file not found::\n");

  else {
    if(argc == 3){
      // output goes to argv[argc-1]
      printf("output file: %s\n", argv[2]);
      arrayp = cmdLine(3, *argv, filep);
   } 
    else if(argc == 2){
      // output to screen
      arrayp = cmdLine(2, *argv, filep);
    }
    
    intp = letters(intp, arrayp);
    
    int r = 0;
    for(r = 0; r < size; r++){}  // printing returned side effect array
      // printf("%c", arrayp[r]);
    
  }// end if/else
}// end main()

char* cmdLine(int c, char *aa, FILE *file){
  int cnt = 0;
  int sz, y;
  char *inPtr;

  fseek(file, 0, SEEK_END);
  sz = ftell(file);
  fseek(file, 0, SEEK_SET);

  inPtr = (char *)malloc(sz * sizeof(char *));

  size = sz;
  
  while((y = fgetc(file)) != EOF) {
    cnt += 1;
    inPtr[cnt-1] = y;
  }// end while
  
  return inPtr;
}// end cmdLine()

int* letters(int *ip, char *ap) {
  int i = 0;
  
  ip = (int *)malloc(26 * sizeof(int *));

  for(i = 97; i <= 122; i++){
    int j = 0;
    for(j = 0; j <= size; j++){
      if(ap[j] == i)
	ip[i-97] += 1;
    }// end for
  }// end for

  printf("letters vs occurences\n");
  for(i = 0; i < 26; i++){
    printf("%c ", i+97);
    printf("%d\n", ip[i]);
  }// end for
  return ip;
}// end letters()
