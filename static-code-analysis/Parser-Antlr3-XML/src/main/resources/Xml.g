grammar Xml;

@lexer::header { package org.se.lab; }
@parser::header { package org.se.lab; }

// Parser rules -------------------------------------------

xml returns [XmlElement xml]
  : element
    {
      $xml = $element.xml;
    }
  | open_tag element_list close_tag
    {
      if(!$open_tag.s.equals($close_tag.s))
        throw new IllegalStateException("Element <" + $open_tag.s +"> is NOT well formed!");
      $xml = new XmlElement($open_tag.s); 
      $xml.setElements($element_list.list);
    }
  ;
		
		
element_list returns [List<XmlElement> list]
@init
{
  $list = new ArrayList<XmlElement>();
} 
  : (element {$list.add($element.xml);})+  
	;
	
	
element returns [XmlElement xml]
	: open_tag STRING close_tag
	  {
      if(!$open_tag.s.equals($close_tag.s))
        throw new IllegalStateException("Element <" + $open_tag.s +"> is NOT well formed!");
	    $xml = new XmlElement($open_tag.s, $STRING.text);
	  }
	;
	
open_tag returns [String s]
	: '<' STRING { $s = $STRING.text; } '>'
	;			
	
close_tag returns [String s]
  : '</' STRING { $s = $STRING.text; } '>'
  ;     
	
	
// Lexer rules --------------------------------------------

fragment LETTER
	:	'A'..'Z'
	|	'a'..'z'
	|	'_'
	;
	
STRING
	:	(LETTER|'0'..'9')*
	;	

COMMENT
    :   '<--' ( options {greedy=false;} : . )* '-->' {$channel=HIDDEN;}
    ;

WS  :  (' '|'\r'|'\t'|'\u000C'|'\n') {skip();}
    ;
