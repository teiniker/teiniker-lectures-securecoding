lexer grammar LexerExample;

@lexer::header { package org.se.lab; }

/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/
	
ID
	:	LETTER (LETTER|'0'..'9')*
	;	

fragment
LETTER
	:	'A'..'Z'
	|	'a'..'z'
	|	'_'
	;

SEMI	: ';' ;
QUESTION: '?' ;
LPAREN	: '(' ;
RPAREN	: ')' ;
LBRACK	: '[' ;
RBRACK	: ']' ;
LCURLY	: '{' ;
RCURLY	: '}' ;
OR		: '|' ;
XOR		: '^' ;
AND		: '&' ;
COLON	: ':' ;
COMMA	: ',' ;
DOT		: '.' ;
ASSIGN	: '=' ;
NOT		: '!' ;
LT		: '<' ;
GT		: '>' ;
DIV		: '/' ;
PLUS	: '+' ;
MINUS	: '-' ;
TILDE	: '~' ;
STAR	: '*' ;
MOD		: '%' ;
LSHIFT	: '<<';
RSHIFT	: '>>';

COMMENT
    :   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;

WS  :  (' '|'\r'|'\t'|'\u000C'|'\n') {skip();}
    ;
