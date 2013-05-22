# include <stdio.h>
# include <stdlib.h>
# include <unistd.h>
# include <sys/types.h>
# include "iplib2New.c" // read/write
//# include "ip03mainSample.c" // sample usage

# define n 3
# define rr 200 // not used?
# define cc 225

// structure
typedef struct{
  pid_t pid;
  int maskH[n][n];
  int maskV[n][n];
} mask;

typedef struct{
  int pLabel;
  unsigned char Eh[n][n], Ev[n][n], Ce[n][n];
  image_ptr vert, hori, comb;
} subImage;

// prototype
subImage applyMask(mask, image_ptr);
mask getMask();

int main(int argc, char *argv[]){
  pid_t pid;
  int size = 448; // number of rows in image
  int i, j, mean, stDev, fd[2], nbytes;
  int rows=n, cols=n;
  int type = 5; // PGM
  int pLabel=0, value=0;
  image_ptr imPtr, imPtr2;
  unsigned char image2[n][n];
  mask maskp = getMask();
  subImage sub, sub1;
  
  if(argc == 8)
    printf("correct syntax..\n");

  for(i = 0; i < 3; i++){ // used to be size
    printf("**********************\n");
    if(pipe(fd) == 0){ // pipe opened successfully
      if((pid = fork()) != -1) // forked properly
	printf("=)\n");
      if(pid == 0){ // then child
	printf("child\n");
	
	imPtr = read_pnm(argv[1], &rows, &cols, &type);
	pLabel += 1;
	printf("%d, ", pLabel);
	sub = applyMask(maskp, imPtr);
	// write struct to pipe(fd[0])
	write(fd[1], &sub, sizeof(subImage));
	close(fd[1]);

      } else{ // parent
	printf("parent\n");
	wait(pid);

	// read from pipe(fd[1])
	*imPtr2 = read(fd[0], &sub, sizeof(subImage));
       
	// send shit from subImage to correct file
	write_pnm(imPtr2, "stuff.c", n, n, type);
	close(fd[0]);
      }// end else
    } else perror("pipe did not open::\n");
   }// end for
  
  return 68;
}// end main

subImage applyMask(mask m1, image_ptr imp){
  int i=0, j=0;
  int value=0, value2=0;
  int result=0, result2=0;
  subImage sub1;

  for(i = 0; i < n; i++){
    for(j = 0; j < n; j++){
      value = imp[i*n + j] * m1.maskH[i][j];
      value2 = imp[i*n + j]* m1.maskV[i][j];
      result += value;
      result2 += value2;
    }// end for
    sub1.Eh[i][j] = result;
    sub1.Ev[i][j] = result2;
    // DONT FORGET COMBINED
  }// end for

  sub1.hori = (image_ptr) sub1.Eh;
  sub1.vert = (image_ptr) sub1.Ev;
  //sub1.comb = (image_ptr) sub1.Ce;

  return sub1;
}// end applyMask()

mask getMask(){
  mask m1; // = (mask) malloc(sizeof(mask));

  m1.maskH[0][0] = -1, -2, -1;
  m1.maskH[1][0] = 0, 0, 0;
  m1.maskH[2][0] = 1, 2, 1;

  m1.maskV[0][0] = -1, 0, 1;
  m1.maskV[1][0] = -2, 0, 2;
  m1.maskV[2][0] = -1, 0, 1;

  return m1;
}// end getMask()
