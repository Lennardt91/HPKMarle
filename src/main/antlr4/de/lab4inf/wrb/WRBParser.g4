parser grammar WRBParser;

options
{
	language = Java;
	tokenVocab = WRBLexer;
}

programm: state (SEP state)* (SEP)? (EOF)?;

state: exp | vardec |funcdec;


funcdec: VAR LBRACKET VAR(KOM VAR)* RBRACKET EQUAL exp;
vardec: VAR EQUAL exp;

exp:(sign)?LBRACKET exp RBRACKET #Bracket
	//Rechtsrekursion erzwingen
	|<assoc=right>left=exp EXPO right=exp #Expo
	|left=exp DIV right=exp #Div
	|left=exp MULT right=exp #Mult
	|left= exp SUB right=exp #Sub
	|left=exp ADD right=exp #Add
	|(sign)?function#Func
	|(sign)?VAR #Var
	|(sign)?NUMBER#Num
	|(sign) #signfragment;

function: VAR LBRACKET exp(KOM exp)* RBRACKET;


sign: SUB | ADD;




