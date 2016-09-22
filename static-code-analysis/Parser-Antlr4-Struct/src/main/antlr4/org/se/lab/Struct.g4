grammar Struct;

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

COMMENT : '/*' .*? '*/' -> skip ; // .*? matches anything until the first */

LINE_COMMENT : '//' ~('\n'|'\r')* '\r'? '\n' -> skip ;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
