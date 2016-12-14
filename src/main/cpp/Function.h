#ifndef FUNCTION_H_
#define FUNCTION_H_
/**
 * Declaration for a real valued C function-pointer
 */
typedef double (*FctPointer)(double x);
/**
 * A C++ Function class wrapping standard C function-pointers
 */
class Function {
private:
	FctPointer fp; // C function-pointer to use
protected:
	const char *fctName; // optional function name
	// contructor for derived classes like JavaFunction
	Function() :
			fp(0), fctName("Java-Fct") {
	}
	;
public:
	// contructor to wrap a C math function-pointer
	Function(const FctPointer p, const char *n = "C-Fct") :
			fp(p), fctName(n) {
	}
	;
	// virtual destructor for derived classes
	virtual ~Function() {
	}
	;
	// access to the function name
	const char* name() const {
		return fctName;
	}
	;
	// operator to execute double y=f(x)
	virtual double operator()(double x) const {
		return fp(x);
	}
	;
};
#endif /*FUNCTION_H_*/
