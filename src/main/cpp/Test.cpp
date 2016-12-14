#include "DiffAndInt.h"
#include <stdio.h>

int main(void) {
	double result;
	char input[10];
	Function f = Function(sin);
	result = differentiate(f, 1);
	printf("is:%f sh:%f", result,0.540302305868139717400936607442976603732310420617922227670);
	f = Function(exp);
	result = differentiate(f, 1);
	printf("is:%f sh:%f", result,2.718281828459045235360287471352662497757247093699959574966);
	scanf(input);
	return 0;
};

