#include <stdio.h>
#include <stdlib.h>

// globals
#define TRUE 1
#define FALSE 0
typedef int boolean;

// constants
const int maxRow = 20;
const int maxCol = 20;
const int pUp = 0;
const int pDown = 1;
const char beenThere = '*';

boolean flag;

// structure
typedef struct{
  int row, col;
  int x, y;
  int drawp;
  int aa[20][20];
} pad;

// prototypes
void console(pad p, int n);
pad getPad();
pad clearPad(pad p);
void sketchPad(pad p);
int parseInp(pad p, char str[]);

int main() {
  char xStr[5];
  pad p1 = getPad();
  p1 = clearPad(p1);
  
  flag = TRUE;
  while(flag){
    
    printf("=) ");
    fgets(xStr, 5, stdin);
    
    int var = parseInp(p1, xStr);
    printf("parsed: %s \n", xStr);
    printf("returned: %d \n", var);
    if(var != 0)
       console(p1, var);
  }
}// end main

// function definitions
pad getPad(){
  pad p1;
}// end getPad()

int parseInp(pad p, char str[]){
  if(str[1] == 5){
    console(p, str[2]);
    printf("%s\n", str);
    return 0;
  }
  else{
    printf("else parseInp\n ");
    return str[0];
  }
}// end parseInp()

// resets the pad
pad clearPad(pad p){
  int i, j;
  int drawp = 1;
  p.row = maxRow;
  p.col = maxCol;
  p.x = 0;
  p.y = 0;

  for(i = 0; i < maxRow; i++)
    for(j = 0; j < maxCol; j++)
      p.aa[i][j] = 0;

  return p;
}// end clearPad()

// console keeps the input coming
void console(pad p, int choice){
  printf("choice %d\n", choice);  

  switch(choice){
  case 1: // pen up
    p.drawp = 1;
    break;
  case 2: // pen down
    p.drawp = 0;
    break;
  case 3: // turn right
    break;
  case 4: // turn left
    break;
  case 5: // move forward x spaces
    printf("you picked 5\n");
    break;
  case 6: // print pad
    sketchPad(p);
    break;
  case 9: // end of data
    printf("::terminated::\n");
    flag = FALSE;
   break;
  default:
    // go forward 'choice' steps
    break;
  }
}// end console()

// print the pad
void sketchPad(pad p){
  int i, j;
    
  for(i = 0; i < p.row; i++){
    for(j = 0; j < p.col; j++){
      if(p.aa[i][j] == 1)
	printf("%c ", beenThere);
      if(p.aa[i][j] == 0)
	printf("%d ", 0);
    }
      printf("\n");
  }
}// end sketchPad()
