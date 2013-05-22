# include <stdio.h>

//prototypes
// 1a. power funtion without recursion
int integerPower(int, int);

// 1b. power function with recursion
int power(int, int);

int main() {
  // initialization
  int x = 0;
  int y = 0;
  int ans = 0;

  // absorbing input
  printf("X:  ");
  scanf("%d", &x);
  printf("Y:  ");
  scanf("%d", &y);

  // function calls
  //printf("1A X^y = %d\n", integerPower(x, y));
  printf("1B X^y = %d\n", power(x, y));
}// end main()

// function definitions
int integerPower(int x, int y){
  // initialization
  int i;
  int ans = 1;

  for(i = 0; i < y; i++)
    ans *= x;
  
  return ans;
}// end integerPower()

int power(int x, int y){
  if(y == 0)
    return 1;
  else
    return (x * power(x, y-1));
}// end power()
