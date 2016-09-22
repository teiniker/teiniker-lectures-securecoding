grammar Operation;

@lexer::header { package org.se.lab; }
@parser::header { package org.se.lab; }

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

prog returns [MOperation op]
  :	operation_def
    {
      $op = $operation_def.op;
    }
  ;

operation_def returns [MOperation op]
  : type_def IDENTIFIER LPAREN parameter_list RPAREN SEMI
    {
      $op = new MOperation($IDENTIFIER.text, $type_def.type);
      op.setParameters($parameter_list.list);
    }
  ;

parameter_list returns [List<MParameter> list]
@init
{
  $list = new ArrayList<MParameter>();
}
	: p1=parameter_def 
	  {
	    $list.add($p1.param);
	  }
	  (COMMA pn=parameter_def {$list.add($pn.param);} )*
	;

parameter_def returns [MParameter param]
	: type_def IDENTIFIER
	  {
	    $param = new MParameter($IDENTIFIER.text, $type_def.type);
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

COMMA	: ',' ;
SEMI	: ';' ;
LPAREN	: '(' ;
RPAREN	: ')' ;


fragment LETTER
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
