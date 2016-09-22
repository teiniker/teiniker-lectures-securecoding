grammar Struct;

@lexer::header 
{ 
	package org.se.lab; 
}

@parser::header 
{ 
	package org.se.lab; 
}


/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

prog returns [MStruct struct]
	:	struct_def
		{
			$struct = $struct_def.struct;
		}
	;


struct_def returns [MStruct struct]
	: STRUCT ID LCURLY field_list RCURLY SEMI
		{
			$struct = new MStruct($ID.text);
			$struct.setFields($field_list.fields);
		}
	; 
		

field_list returns [List<MField> fields]
@init
{
	$fields = new ArrayList<MField>();
}
	: (field_def { $fields.add($field_def.field); } )+
	;
	

field_def returns [MField field]
	: type_def ID SEMI
		{
			$field = new MField($ID.text, $type_def.type);		
		}
	;			
		

type_def returns [MType type]
	:   type_specifier
		{
			$type = new MType($type_specifier.text);
		} 	
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

SEMI	  : ';' ;
LCURLY	: '{' ;
RCURLY	: '}' ;
STRUCT  : 'struct';

fragment LETTER
	:	'A'..'Z'
	|	'a'..'z'
	|	'_'
	;
	
ID
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
