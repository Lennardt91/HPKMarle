#include "Function.h"
//#include <jni.h>
#include <math.h>
/** precision for the numerical calculus */
#define EPS 1.E-9
#define MAX_STEPS 10000
#ifdef __cplusplus
extern "C" {
#endif
/**
 * Calculate f'(x) = df/dx at point x.
 */
double differentiate(Function &f, double x);
/**
 *		   b
 *		  /
 * Calculate	/ f(t) dt.
 *	      /
 *	     a
 */
double integrate(Function &f, double a, double b);
char convergence(double, double);
#ifdef __cplusplus
}
#endif
