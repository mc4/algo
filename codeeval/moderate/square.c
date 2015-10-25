/****************************************************************************************
 * 	 			CHALLENGE DESCRIPTION:					*
 *										 	*
 * You have coordinates of four points on a plane. Check whether they make a square.    *
 * example input: (4,6), (5,5), (5,6), (4,5)						*
 *  											*
 *											*
 ****************************************************************************************/

 #include <stdio.h>
 #include <stdlib.h>

 struct point { int x; int y; }point;

 struct point findLowerLeft(int points[]){
 	struct point temp;
 	//tests if 0th and 1th element are the bottom left coordinates
 	if(    (points[0] <= points[2] && points[1] <= points[3]) 
 		&& (points[0] <= points[4] && points[1] <= points[5]) 
 		&& (points[0] <= points[6] && points[1] <= points[7]) ){
 		temp.x = points[0];
 		temp.y = points[1];
 		return temp;
 	}
 	if(	   (points[2] <= points[0] && points[3] <= points[1]) 
 		&& (points[2] <= points[4] && points[3] <= points[5]) 
 		&& (points[2] <= points[6] && points[3] <= points[7]) ){
 		temp.x = points[2];
 		temp.y = points[3];
 		return temp;
 	}
 	if(	   (points[4] <= points[0] && points[5] <= points[1]) 
 		&& (points[4] <= points[2] && points[5] <= points[3]) 
 		&& (points[4] <= points[6] && points[5] <= points[7]) ){
 		temp.x = points[4];
 		temp.y = points[5];
 		return temp;
 	}
 	if(	   (points[6] <= points[0] && points[7] <= points[1]) 
 		&& (points[6] <= points[2] && points[7] <= points[3]) 
 		&& (points[6] <= points[4] && points[7] <= points[5]) ){
 		temp.x = points[6];
 		temp.y = points[7];
 		return temp;
 	}

 	return temp;
 }
 	//finds lower right coordinates
 struct point findLowerRight(int points[]){
 	struct point temp;
 	if(    (points[0] >= points[2] && points[1] >= points[3]) 
 		&& (points[0] <= points[4] && points[1] <= points[5]) 
 		&& (points[0] <= points[6] && points[1] <= points[7]) ){
 		temp.x = points[0];
 		temp.y = points[1];
 		return temp;
 	}
 	if(	   (points[2] >= points[0] && points[3] >= points[1]) 
 		&& (points[2] <= points[4] && points[3] <= points[5]) 
 		&& (points[2] <= points[6] && points[3] <= points[7]) ){
 		temp.x = points[2];
 		temp.y = points[3];
 		return temp;
 	}
 	if(	   (points[4] >= points[0] && points[4] >= points[1]) 
 		&& (points[4] <= points[2] && points[4] <= points[3]) 
 		&& (points[4] <= points[6] && points[4] <= points[7]) ){
 		temp.x = points[4];
 		temp.y = points[5];
 		return temp;
 	}
 	if(	   (points[6] >= points[0] && points[7] >= points[1]) 
 		&& (points[6] <= points[2] && points[7] <= points[3]) 
 		&& (points[6] <= points[4] && points[7] <= points[5]) ){
 		temp.x = points[6];
 		temp.y = points[7];
 		return temp;
 	}
 	return temp;
 }

 struct point findUpperLeft(int points[]){
 	struct point temp;
 	if(    (points[0] <= points[2] && points[1] <= points[3]) 
 		&& (points[0] <= points[4] && points[1] <= points[5]) 
 		&& (points[0] >= points[6] && points[1] >= points[7]) ){
 		temp.x = points[0];
 		temp.y = points[1];
 		return temp;
 	}
 	if(	   (points[2] <= points[0] && points[3] <= points[1]) 
 		&& (points[2] <= points[4] && points[3] <= points[5]) 
 		&& (points[2] >= points[6] && points[3] >= points[7]) ){
 		temp.x = points[2];
 		temp.y = points[3];
 		return temp;
 	}
 	if(	   (points[4] >= points[0] && points[4] >= points[1]) 
 		&& (points[4] <= points[2] && points[4] <= points[3]) 
 		&& (points[4] <= points[6] && points[4] <= points[7]) ){
 		temp.x = points[4];
 		temp.y = points[5];
 		return temp;
 	}
 	if(	   (points[6] <= points[0] && points[7] <= points[1]) 
 		&& (points[6] <= points[2] && points[7] <= points[3]) 
 		&& (points[6] >= points[4] && points[7] >= points[5]) ){
 		temp.x = points[6];
 		temp.y = points[7];
 		return temp;
 	}
 	return temp;
 }

 struct point findUpperRight(int points[]){
 	struct point temp;
 	if(    (points[0] >= points[2] && points[1] >= points[3]) 
 		&& (points[0] >= points[4] && points[1] >= points[5]) 
 		&& (points[0] >= points[6] && points[1] >= points[7]) ){
 		temp.x = points[0];
 		temp.y = points[1];
 		return temp;
 	}
 	if(	   (points[2] >= points[0] && points[3] >= points[1]) 
 		&& (points[2] >= points[4] && points[3] >= points[5]) 
 		&& (points[2] >= points[6] && points[3] >= points[7]) ){
 		temp.x = points[2];
 		temp.y = points[3];
 		return temp;
 	}
 	if(	   (points[4] >= points[0] && points[5] >= points[1]) 
 		&& (points[4] >= points[2] && points[5] >= points[3]) 
 		&& (points[4] >= points[6] && points[5] >= points[7]) ){
 		temp.x = points[4];
 		temp.y = points[5];
 		return temp;
 	}
 	if(	   (points[6] >= points[0] && points[7] >= points[1]) 
 		&& (points[6] >= points[2] && points[7] >= points[3]) 
 		&& (points[6] >= points[4] && points[7] >= points[5]) ){
 		temp.x = points[6];
 		temp.y = points[7];
 		return temp;
 	}
 	return temp;
 }

 //returns 1 if square
 int isSquare(struct point *ll, struct point *lr, struct point *ul, struct point *ur){
 	return (ll->x == ul->x && lr->x == ur->x && ll->y == lr->y && ul->y == ur->y);
 }

 int fpeek(FILE * const fp){
  const int c = getc(fp);
  return c == EOF ? EOF : ungetc(c, fp);
 }

 int main(int argc, char **argv){
 	FILE *fp;
	int c = 0;
	int coordinates[8]; 
	int index = 0; //index of position in each line

	struct point ll; //bottom left corner
	struct point lr; //bottom right corner
	struct point ur; //upper right corner
	struct point ul; //upper left corner

	fp = fopen(argv[1],"r"); 

	if(fp == NULL){ return -1; }

 	/* Scans document character by character */
	while ( (c = fgetc(fp)) != EOF ){
		//ascii 0=48, 9=57
		//fill array with only ints from line
		if(c >= 48 && c <= 57){
			coordinates[index] = c - '0'; //this line is so clutch
			index++;
		}
		else if(c == '\n' || (fpeek(fp) == EOF)){
			//gets corners of the square
			ll = findLowerLeft(coordinates);
			lr = findLowerRight(coordinates);
			ul = findUpperLeft(coordinates);
			ur = findUpperRight(coordinates);
			index = 0;

			//check if coordinates are a square, returns 1 if its a square
			if(isSquare(&ll,&lr,&ul,&ur)){
				printf("false\n");
			} else {
				printf("true\n");
			}
		} 
	}
	fclose(fp);
	return 0; 
}
