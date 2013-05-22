#include <stdio.h>

// prototypes
// 2a. prime generator
void prime(int);

// 2b. the sieve of eratosthenes
void primeS();

void main() {
  // initializations
  int i = 0;
  int max = 10000; 

  // function calls
  for(i = 1; i <= max; i++)
     prime(i);

  printf("\n\n");
  primeS(max);
}// end main()

// function definitions
void prime(int n){
  // initializations
  int i = 0;
  int c = 0;
  
  // from 1 to n, add one to counter
  for(i = 1; i <= n; i++)
    if(n%i == 0)
      c += 1;

  // if only two multiples, num is prime
  if(c == 2)
    printf("%d, ", n);
}// end prime()

void primeS(int size){
  // initializations
  int i = 0;
  int j = 0;
  int aa[size];

  // initialize all elemetns to 1
  for(i = 0; i < size; i++)
    aa[i] = 1;
  
  // sets every element whose subscript is a 
  // multiple of that subscript to 0
  for(i = 2; i <= (size-1); i++)
    if(aa[i] != 0)
      for(j = (i+1); j <= (size-1); j++)
	if(aa[j] != 0)
	  if(j%i == 0)
	    aa[j] = 0;

  // print ignoring 0 and 1
  for(i = 2; i < size; i++)
    if(aa[i] == 1)
      printf("%d, ", i);
  
  printf("\n");
}// end primeS()
