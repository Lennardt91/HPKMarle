#include "Function.h"
#include "DiffAndInt.h"
#include <cmath>

double differentiate(Function &f, double x) {
	double dx = 100;
	double dxOld = 0;
	double h = 1.;
	int i = 0;
	while (std::abs((dx - dxOld)) > EPS) {
		dxOld = dx;
		if (i > 50) {
			throw "nicht konvergent";
		}
		dx = (f(x + h) - f(x - h)) / (2 * h);
		h /= 4;
		i++;
	}
	return dx;
}

