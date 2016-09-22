grammar Struct;

@lexer::header { package org.se.lab; }
@parser::header { package org.se.lab; }

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

prog:	struct_specifier+;


struct_specifier
	: 'struct' IDENTIFIER? LCURLY struct_declaration_list RCURLY SEMI
	; 
		
struct_declaration_list
	: struct_declaration+
	;
	
struct_declaration
	: type_specifier IDENTIFIER SEMI
	;			
				
type_specifier
	: 'void'
	| 'char'
	| 'short'
	| 'int'
	| 'long'
	| 'float'
	| 'double'
	// ...
	;
	
	
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

SEMI	: ';' ;
LCURLY	: '{' ;
RCURLY	: '}' ;

LETTER
	:	'A'..'Z'
	|	'a'..'z'
	|	'_'
	;
	
IDENTIFIER
	:	LETTER (LETTER|'0'..'9')*
	;	

COMMENT
    :   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;

WS  :  (' '|'\r'|'\t'|'\u000C'|'\n') {skip();}
    ;
