lexer grammar WRBLexer;


VAR: LETTER(LETTER|DIGIT|UNDERSCORE)*;

NUMBER: INT|FLOAT;
FLOAT: INT '.' (DIGIT)*;
INT: DIGIT+;
DIGIT:[0-9];
LETTER: [a-z] | [A-Z];
WHITESPACE: [ \t\n]->skip;
SEP: ';';
KOM: ',';
EXPO: '^' | '**' ;

EQUAL: '=';
ADD: [+];
SUB: [-];
MULT: [*];
DIV: [/];
MODULO: [%];
UNDERSCORE: [_];
LBRACKET: '(';
RBRACKET: ')';
EVAL: 'eval ';
