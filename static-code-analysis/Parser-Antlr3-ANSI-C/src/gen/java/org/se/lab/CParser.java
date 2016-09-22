// $ANTLR 3.4 /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g 2016-01-29 19:43:34

package org.se.lab;

import java.util.Set;
import java.util.HashSet;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/** ANSI C ANTLR v3 grammar

Translated from Jutta Degener's 1995 ANSI C yacc grammar by Terence Parr
July 2006.  The lexical rules were taken from the Java grammar.

Jutta says: "In 1985, Jeff Lee published his Yacc grammar (which
is accompanied by a matching Lex specification) for the April 30, 1985 draft
version of the ANSI C standard.  Tom Stockfisch reposted it to net.sources in
1987; that original, as mentioned in the answer to question 17.25 of the
comp.lang.c FAQ, can be ftp'ed from ftp.uu.net,
   file usenet/net.sources/ansi.c.grammar.Z.
I intend to keep this version as close to the current C Standard grammar as
possible; please let me know if you discover discrepancies. Jutta Degener, 1995"

Generally speaking, you need symbol table info to parse C; typedefs
define types and then IDENTIFIERS are either types or plain IDs.  I'm doing
the min necessary here tracking only type names.  This is a good example
of the global scope (called Symbols).  Every rule that declares its usage
of Symbols pushes a new copy on the stack effectively creating a new
symbol scope.  Also note rule declaration declares a rule scope that
lets any invoked rule see isTypedef boolean.  It's much easier than
passing that info down as parameters.  Very clean.  Rule
direct_declarator can then easily determine whether the IDENTIFIER
should be declared as a type name.

I have only tested this on a single file, though it is 3500 lines.

This grammar requires ANTLR v3.0.1 or higher.

Terence Parr
July 2006
*/
@SuppressWarnings({"all", "warnings", "unchecked"})
public class CParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CHARACTER_LITERAL", "COMMENT", "DECIMAL_LITERAL", "EscapeSequence", "Exponent", "FLOATING_POINT_LITERAL", "FloatTypeSuffix", "HEX_LITERAL", "HexDigit", "IDENTIFIER", "IntegerTypeSuffix", "LETTER", "LINE_COMMAND", "LINE_COMMENT", "OCTAL_LITERAL", "OctalEscape", "STRING_LITERAL", "UnicodeEscape", "WS", "'!'", "'!='", "'%'", "'%='", "'&&'", "'&'", "'&='", "'('", "')'", "'*'", "'*='", "'+'", "'++'", "'+='", "','", "'-'", "'--'", "'-='", "'->'", "'.'", "'...'", "'/'", "'/='", "':'", "';'", "'<'", "'<<'", "'<<='", "'<='", "'='", "'=='", "'>'", "'>='", "'>>'", "'>>='", "'?'", "'['", "']'", "'^'", "'^='", "'auto'", "'break'", "'case'", "'char'", "'const'", "'continue'", "'default'", "'do'", "'double'", "'else'", "'enum'", "'extern'", "'float'", "'for'", "'goto'", "'if'", "'int'", "'long'", "'register'", "'return'", "'short'", "'signed'", "'sizeof'", "'static'", "'struct'", "'switch'", "'typedef'", "'union'", "'unsigned'", "'void'", "'volatile'", "'while'", "'{'", "'|'", "'|='", "'||'", "'}'", "'~'"
    };

    public static final int EOF=-1;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__59=59;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__90=90;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__99=99;
    public static final int T__100=100;
    public static final int CHARACTER_LITERAL=4;
    public static final int COMMENT=5;
    public static final int DECIMAL_LITERAL=6;
    public static final int EscapeSequence=7;
    public static final int Exponent=8;
    public static final int FLOATING_POINT_LITERAL=9;
    public static final int FloatTypeSuffix=10;
    public static final int HEX_LITERAL=11;
    public static final int HexDigit=12;
    public static final int IDENTIFIER=13;
    public static final int IntegerTypeSuffix=14;
    public static final int LETTER=15;
    public static final int LINE_COMMAND=16;
    public static final int LINE_COMMENT=17;
    public static final int OCTAL_LITERAL=18;
    public static final int OctalEscape=19;
    public static final int STRING_LITERAL=20;
    public static final int UnicodeEscape=21;
    public static final int WS=22;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators

    protected static class Symbols_scope {
        Set types;
    }
    protected Stack Symbols_stack = new Stack();



    public CParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public CParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.ruleMemo = new HashMap[213+1];
         

    }

    public String[] getTokenNames() { return CParser.tokenNames; }
    public String getGrammarFileName() { return "/home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g"; }


    	boolean isTypeName(String name) {
    		for (int i = Symbols_stack.size()-1; i>=0; i--) {
    			Symbols_scope scope = (Symbols_scope)Symbols_stack.get(i);
    			if ( scope.types.contains(name) ) {
    				return true;
    			}
    		}
    		return false;
    	}



    // $ANTLR start "translation_unit"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:61:1: translation_unit : ( external_declaration )+ ;
    public final void translation_unit() throws RecognitionException {
        Symbols_stack.push(new Symbols_scope());

        int translation_unit_StartIndex = input.index();


          ((Symbols_scope)Symbols_stack.peek()).types = new HashSet();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:66:2: ( ( external_declaration )+ )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:66:4: ( external_declaration )+
            {
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:66:4: ( external_declaration )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==IDENTIFIER||LA1_0==30||LA1_0==32||LA1_0==63||(LA1_0 >= 66 && LA1_0 <= 67)||LA1_0==71||(LA1_0 >= 73 && LA1_0 <= 75)||(LA1_0 >= 79 && LA1_0 <= 81)||(LA1_0 >= 83 && LA1_0 <= 84)||(LA1_0 >= 86 && LA1_0 <= 87)||(LA1_0 >= 89 && LA1_0 <= 93)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:66:4: external_declaration
            	    {
            	    pushFollow(FOLLOW_external_declaration_in_translation_unit74);
            	    external_declaration();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, translation_unit_StartIndex); }

            Symbols_stack.pop();

        }
        return ;
    }
    // $ANTLR end "translation_unit"



    // $ANTLR start "external_declaration"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:83:1: external_declaration options {k=1; } : ( ( ( declaration_specifiers )? declarator ( declaration )* '{' )=> function_definition | declaration );
    public final void external_declaration() throws RecognitionException {
        int external_declaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:85:2: ( ( ( declaration_specifiers )? declarator ( declaration )* '{' )=> function_definition | declaration )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==63||LA2_0==74||LA2_0==81||LA2_0==86) ) {
                int LA2_1 = input.LA(2);

                if ( (synpred4_C()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA2_0==92) ) {
                int LA2_2 = input.LA(2);

                if ( (synpred4_C()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;

                }
            }
            else if ( (LA2_0==66) ) {
                int LA2_3 = input.LA(2);

                if ( (synpred4_C()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 3, input);

                    throw nvae;

                }
            }
            else if ( (LA2_0==83) ) {
                int LA2_4 = input.LA(2);

                if ( (synpred4_C()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 4, input);

                    throw nvae;

                }
            }
            else if ( (LA2_0==79) ) {
                int LA2_5 = input.LA(2);

                if ( (synpred4_C()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 5, input);

                    throw nvae;

                }
            }
            else if ( (LA2_0==80) ) {
                int LA2_6 = input.LA(2);

                if ( (synpred4_C()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 6, input);

                    throw nvae;

                }
            }
            else if ( (LA2_0==75) ) {
                int LA2_7 = input.LA(2);

                if ( (synpred4_C()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 7, input);

                    throw nvae;

                }
            }
            else if ( (LA2_0==71) ) {
                int LA2_8 = input.LA(2);

                if ( (synpred4_C()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 8, input);

                    throw nvae;

                }
            }
            else if ( (LA2_0==84) ) {
                int LA2_9 = input.LA(2);

                if ( (synpred4_C()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 9, input);

                    throw nvae;

                }
            }
            else if ( (LA2_0==91) ) {
                int LA2_10 = input.LA(2);

                if ( (synpred4_C()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 10, input);

                    throw nvae;

                }
            }
            else if ( (LA2_0==87||LA2_0==90) ) {
                int LA2_11 = input.LA(2);

                if ( (synpred4_C()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 11, input);

                    throw nvae;

                }
            }
            else if ( (LA2_0==73) ) {
                int LA2_12 = input.LA(2);

                if ( (synpred4_C()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 12, input);

                    throw nvae;

                }
            }
            else if ( (LA2_0==IDENTIFIER) ) {
                int LA2_13 = input.LA(2);

                if ( (synpred4_C()) ) {
                    alt2=1;
                }
                else if ( ((isTypeName(input.LT(1).getText()))) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 13, input);

                    throw nvae;

                }
            }
            else if ( (LA2_0==67||LA2_0==93) ) {
                int LA2_14 = input.LA(2);

                if ( (synpred4_C()) ) {
                    alt2=1;
                }
                else if ( (true) ) {
                    alt2=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 14, input);

                    throw nvae;

                }
            }
            else if ( (LA2_0==32) && (synpred4_C())) {
                alt2=1;
            }
            else if ( (LA2_0==30) && (synpred4_C())) {
                alt2=1;
            }
            else if ( (LA2_0==89) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:85:4: ( ( declaration_specifiers )? declarator ( declaration )* '{' )=> function_definition
                    {
                    pushFollow(FOLLOW_function_definition_in_external_declaration110);
                    function_definition();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:86:4: declaration
                    {
                    pushFollow(FOLLOW_declaration_in_external_declaration115);
                    declaration();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, external_declaration_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "external_declaration"



    // $ANTLR start "function_definition"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:89:1: function_definition : ( declaration_specifiers )? declarator ( ( declaration )+ compound_statement | compound_statement ) ;
    public final void function_definition() throws RecognitionException {
        Symbols_stack.push(new Symbols_scope());

        int function_definition_StartIndex = input.index();


          ((Symbols_scope)Symbols_stack.peek()).types = new HashSet();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:94:2: ( ( declaration_specifiers )? declarator ( ( declaration )+ compound_statement | compound_statement ) )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:94:4: ( declaration_specifiers )? declarator ( ( declaration )+ compound_statement | compound_statement )
            {
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:94:4: ( declaration_specifiers )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==63||(LA3_0 >= 66 && LA3_0 <= 67)||LA3_0==71||(LA3_0 >= 73 && LA3_0 <= 75)||(LA3_0 >= 79 && LA3_0 <= 81)||(LA3_0 >= 83 && LA3_0 <= 84)||(LA3_0 >= 86 && LA3_0 <= 87)||(LA3_0 >= 90 && LA3_0 <= 93)) ) {
                alt3=1;
            }
            else if ( (LA3_0==IDENTIFIER) ) {
                switch ( input.LA(2) ) {
                    case 32:
                        {
                        alt3=1;
                        }
                        break;
                    case IDENTIFIER:
                        {
                        int LA3_18 = input.LA(3);

                        if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred5_C())) ) {
                            alt3=1;
                        }
                        }
                        break;
                    case 30:
                        {
                        int LA3_19 = input.LA(3);

                        if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred5_C())) ) {
                            alt3=1;
                        }
                        }
                        break;
                    case 63:
                    case 74:
                    case 81:
                    case 86:
                        {
                        int LA3_20 = input.LA(3);

                        if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred5_C())) ) {
                            alt3=1;
                        }
                        }
                        break;
                    case 92:
                        {
                        int LA3_21 = input.LA(3);

                        if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred5_C())) ) {
                            alt3=1;
                        }
                        }
                        break;
                    case 66:
                        {
                        int LA3_22 = input.LA(3);

                        if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred5_C())) ) {
                            alt3=1;
                        }
                        }
                        break;
                    case 83:
                        {
                        int LA3_23 = input.LA(3);

                        if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred5_C())) ) {
                            alt3=1;
                        }
                        }
                        break;
                    case 79:
                        {
                        int LA3_24 = input.LA(3);

                        if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred5_C())) ) {
                            alt3=1;
                        }
                        }
                        break;
                    case 80:
                        {
                        int LA3_25 = input.LA(3);

                        if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred5_C())) ) {
                            alt3=1;
                        }
                        }
                        break;
                    case 75:
                        {
                        int LA3_26 = input.LA(3);

                        if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred5_C())) ) {
                            alt3=1;
                        }
                        }
                        break;
                    case 71:
                        {
                        int LA3_27 = input.LA(3);

                        if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred5_C())) ) {
                            alt3=1;
                        }
                        }
                        break;
                    case 84:
                        {
                        int LA3_28 = input.LA(3);

                        if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred5_C())) ) {
                            alt3=1;
                        }
                        }
                        break;
                    case 91:
                        {
                        int LA3_29 = input.LA(3);

                        if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred5_C())) ) {
                            alt3=1;
                        }
                        }
                        break;
                    case 87:
                    case 90:
                        {
                        int LA3_30 = input.LA(3);

                        if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred5_C())) ) {
                            alt3=1;
                        }
                        }
                        break;
                    case 73:
                        {
                        int LA3_31 = input.LA(3);

                        if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred5_C())) ) {
                            alt3=1;
                        }
                        }
                        break;
                    case 67:
                    case 93:
                        {
                        int LA3_32 = input.LA(3);

                        if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred5_C())) ) {
                            alt3=1;
                        }
                        }
                        break;
                }

            }
            switch (alt3) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:94:4: declaration_specifiers
                    {
                    pushFollow(FOLLOW_declaration_specifiers_in_function_definition137);
                    declaration_specifiers();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            pushFollow(FOLLOW_declarator_in_function_definition140);
            declarator();

            state._fsp--;
            if (state.failed) return ;

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:95:3: ( ( declaration )+ compound_statement | compound_statement )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==IDENTIFIER||LA5_0==63||(LA5_0 >= 66 && LA5_0 <= 67)||LA5_0==71||(LA5_0 >= 73 && LA5_0 <= 75)||(LA5_0 >= 79 && LA5_0 <= 81)||(LA5_0 >= 83 && LA5_0 <= 84)||(LA5_0 >= 86 && LA5_0 <= 87)||(LA5_0 >= 89 && LA5_0 <= 93)) ) {
                alt5=1;
            }
            else if ( (LA5_0==95) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:95:5: ( declaration )+ compound_statement
                    {
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:95:5: ( declaration )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==IDENTIFIER||LA4_0==63||(LA4_0 >= 66 && LA4_0 <= 67)||LA4_0==71||(LA4_0 >= 73 && LA4_0 <= 75)||(LA4_0 >= 79 && LA4_0 <= 81)||(LA4_0 >= 83 && LA4_0 <= 84)||(LA4_0 >= 86 && LA4_0 <= 87)||(LA4_0 >= 89 && LA4_0 <= 93)) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:95:5: declaration
                    	    {
                    	    pushFollow(FOLLOW_declaration_in_function_definition146);
                    	    declaration();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);


                    pushFollow(FOLLOW_compound_statement_in_function_definition149);
                    compound_statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:96:5: compound_statement
                    {
                    pushFollow(FOLLOW_compound_statement_in_function_definition156);
                    compound_statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, function_definition_StartIndex); }

            Symbols_stack.pop();

        }
        return ;
    }
    // $ANTLR end "function_definition"


    protected static class declaration_scope {
        boolean isTypedef;
    }
    protected Stack declaration_stack = new Stack();



    // $ANTLR start "declaration"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:100:1: declaration : ( 'typedef' ( declaration_specifiers )? init_declarator_list ';' | declaration_specifiers ( init_declarator_list )? ';' );
    public final void declaration() throws RecognitionException {
        declaration_stack.push(new declaration_scope());
        int declaration_StartIndex = input.index();


          ((declaration_scope)declaration_stack.peek()).isTypedef = false;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:107:2: ( 'typedef' ( declaration_specifiers )? init_declarator_list ';' | declaration_specifiers ( init_declarator_list )? ';' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==89) ) {
                alt8=1;
            }
            else if ( (LA8_0==IDENTIFIER||LA8_0==63||(LA8_0 >= 66 && LA8_0 <= 67)||LA8_0==71||(LA8_0 >= 73 && LA8_0 <= 75)||(LA8_0 >= 79 && LA8_0 <= 81)||(LA8_0 >= 83 && LA8_0 <= 84)||(LA8_0 >= 86 && LA8_0 <= 87)||(LA8_0 >= 90 && LA8_0 <= 93)) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:107:4: 'typedef' ( declaration_specifiers )? init_declarator_list ';'
                    {
                    match(input,89,FOLLOW_89_in_declaration184); if (state.failed) return ;

                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:107:14: ( declaration_specifiers )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==63||(LA6_0 >= 66 && LA6_0 <= 67)||LA6_0==71||(LA6_0 >= 73 && LA6_0 <= 75)||(LA6_0 >= 79 && LA6_0 <= 81)||(LA6_0 >= 83 && LA6_0 <= 84)||(LA6_0 >= 86 && LA6_0 <= 87)||(LA6_0 >= 90 && LA6_0 <= 93)) ) {
                        alt6=1;
                    }
                    else if ( (LA6_0==IDENTIFIER) ) {
                        int LA6_13 = input.LA(2);

                        if ( (LA6_13==IDENTIFIER||LA6_13==32||LA6_13==63||(LA6_13 >= 66 && LA6_13 <= 67)||LA6_13==71||(LA6_13 >= 73 && LA6_13 <= 75)||(LA6_13 >= 79 && LA6_13 <= 81)||(LA6_13 >= 83 && LA6_13 <= 84)||(LA6_13 >= 86 && LA6_13 <= 87)||(LA6_13 >= 90 && LA6_13 <= 93)) ) {
                            alt6=1;
                        }
                        else if ( (LA6_13==30) ) {
                            int LA6_19 = input.LA(3);

                            if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred8_C())) ) {
                                alt6=1;
                            }
                        }
                    }
                    switch (alt6) {
                        case 1 :
                            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:107:14: declaration_specifiers
                            {
                            pushFollow(FOLLOW_declaration_specifiers_in_declaration186);
                            declaration_specifiers();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    if ( state.backtracking==0 ) {((declaration_scope)declaration_stack.peek()).isTypedef =true;}

                    pushFollow(FOLLOW_init_declarator_list_in_declaration194);
                    init_declarator_list();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,47,FOLLOW_47_in_declaration196); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:109:4: declaration_specifiers ( init_declarator_list )? ';'
                    {
                    pushFollow(FOLLOW_declaration_specifiers_in_declaration202);
                    declaration_specifiers();

                    state._fsp--;
                    if (state.failed) return ;

                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:109:27: ( init_declarator_list )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==IDENTIFIER||LA7_0==30||LA7_0==32) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:109:27: init_declarator_list
                            {
                            pushFollow(FOLLOW_init_declarator_list_in_declaration204);
                            init_declarator_list();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,47,FOLLOW_47_in_declaration207); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, declaration_StartIndex); }

            declaration_stack.pop();
        }
        return ;
    }
    // $ANTLR end "declaration"



    // $ANTLR start "declaration_specifiers"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:112:1: declaration_specifiers : ( storage_class_specifier | type_specifier | type_qualifier )+ ;
    public final void declaration_specifiers() throws RecognitionException {
        int declaration_specifiers_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:113:2: ( ( storage_class_specifier | type_specifier | type_qualifier )+ )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:113:6: ( storage_class_specifier | type_specifier | type_qualifier )+
            {
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:113:6: ( storage_class_specifier | type_specifier | type_qualifier )+
            int cnt9=0;
            loop9:
            do {
                int alt9=4;
                switch ( input.LA(1) ) {
                case IDENTIFIER:
                    {
                    int LA9_2 = input.LA(2);

                    if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred12_C())) ) {
                        alt9=2;
                    }


                    }
                    break;
                case 63:
                case 74:
                case 81:
                case 86:
                    {
                    alt9=1;
                    }
                    break;
                case 66:
                case 71:
                case 73:
                case 75:
                case 79:
                case 80:
                case 83:
                case 84:
                case 87:
                case 90:
                case 91:
                case 92:
                    {
                    alt9=2;
                    }
                    break;
                case 67:
                case 93:
                    {
                    alt9=3;
                    }
                    break;

                }

                switch (alt9) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:113:10: storage_class_specifier
            	    {
            	    pushFollow(FOLLOW_storage_class_specifier_in_declaration_specifiers224);
            	    storage_class_specifier();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:114:7: type_specifier
            	    {
            	    pushFollow(FOLLOW_type_specifier_in_declaration_specifiers232);
            	    type_specifier();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;
            	case 3 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:115:13: type_qualifier
            	    {
            	    pushFollow(FOLLOW_type_qualifier_in_declaration_specifiers246);
            	    type_qualifier();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, declaration_specifiers_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "declaration_specifiers"



    // $ANTLR start "init_declarator_list"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:119:1: init_declarator_list : init_declarator ( ',' init_declarator )* ;
    public final void init_declarator_list() throws RecognitionException {
        int init_declarator_list_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:120:2: ( init_declarator ( ',' init_declarator )* )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:120:4: init_declarator ( ',' init_declarator )*
            {
            pushFollow(FOLLOW_init_declarator_in_init_declarator_list268);
            init_declarator();

            state._fsp--;
            if (state.failed) return ;

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:120:20: ( ',' init_declarator )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==37) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:120:21: ',' init_declarator
            	    {
            	    match(input,37,FOLLOW_37_in_init_declarator_list271); if (state.failed) return ;

            	    pushFollow(FOLLOW_init_declarator_in_init_declarator_list273);
            	    init_declarator();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, init_declarator_list_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "init_declarator_list"



    // $ANTLR start "init_declarator"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:123:1: init_declarator : declarator ( '=' initializer )? ;
    public final void init_declarator() throws RecognitionException {
        int init_declarator_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:124:2: ( declarator ( '=' initializer )? )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:124:4: declarator ( '=' initializer )?
            {
            pushFollow(FOLLOW_declarator_in_init_declarator286);
            declarator();

            state._fsp--;
            if (state.failed) return ;

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:124:15: ( '=' initializer )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==52) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:124:16: '=' initializer
                    {
                    match(input,52,FOLLOW_52_in_init_declarator289); if (state.failed) return ;

                    pushFollow(FOLLOW_initializer_in_init_declarator291);
                    initializer();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, init_declarator_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "init_declarator"



    // $ANTLR start "storage_class_specifier"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:127:1: storage_class_specifier : ( 'extern' | 'static' | 'auto' | 'register' );
    public final void storage_class_specifier() throws RecognitionException {
        int storage_class_specifier_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:128:2: ( 'extern' | 'static' | 'auto' | 'register' )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:
            {
            if ( input.LA(1)==63||input.LA(1)==74||input.LA(1)==81||input.LA(1)==86 ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, storage_class_specifier_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "storage_class_specifier"



    // $ANTLR start "type_specifier"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:134:1: type_specifier : ( 'void' | 'char' | 'short' | 'int' | 'long' | 'float' | 'double' | 'signed' | 'unsigned' | struct_or_union_specifier | enum_specifier | type_id );
    public final void type_specifier() throws RecognitionException {
        int type_specifier_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:135:2: ( 'void' | 'char' | 'short' | 'int' | 'long' | 'float' | 'double' | 'signed' | 'unsigned' | struct_or_union_specifier | enum_specifier | type_id )
            int alt12=12;
            switch ( input.LA(1) ) {
            case 92:
                {
                alt12=1;
                }
                break;
            case 66:
                {
                alt12=2;
                }
                break;
            case 83:
                {
                alt12=3;
                }
                break;
            case 79:
                {
                alt12=4;
                }
                break;
            case 80:
                {
                alt12=5;
                }
                break;
            case 75:
                {
                alt12=6;
                }
                break;
            case 71:
                {
                alt12=7;
                }
                break;
            case 84:
                {
                alt12=8;
                }
                break;
            case 91:
                {
                alt12=9;
                }
                break;
            case 87:
            case 90:
                {
                alt12=10;
                }
                break;
            case 73:
                {
                alt12=11;
                }
                break;
            case IDENTIFIER:
                {
                alt12=12;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }

            switch (alt12) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:135:4: 'void'
                    {
                    match(input,92,FOLLOW_92_in_type_specifier330); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:136:4: 'char'
                    {
                    match(input,66,FOLLOW_66_in_type_specifier335); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:137:4: 'short'
                    {
                    match(input,83,FOLLOW_83_in_type_specifier340); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:138:4: 'int'
                    {
                    match(input,79,FOLLOW_79_in_type_specifier345); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:139:4: 'long'
                    {
                    match(input,80,FOLLOW_80_in_type_specifier350); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:140:4: 'float'
                    {
                    match(input,75,FOLLOW_75_in_type_specifier355); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:141:4: 'double'
                    {
                    match(input,71,FOLLOW_71_in_type_specifier360); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:142:4: 'signed'
                    {
                    match(input,84,FOLLOW_84_in_type_specifier365); if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:143:4: 'unsigned'
                    {
                    match(input,91,FOLLOW_91_in_type_specifier370); if (state.failed) return ;

                    }
                    break;
                case 10 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:144:4: struct_or_union_specifier
                    {
                    pushFollow(FOLLOW_struct_or_union_specifier_in_type_specifier375);
                    struct_or_union_specifier();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 11 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:145:4: enum_specifier
                    {
                    pushFollow(FOLLOW_enum_specifier_in_type_specifier380);
                    enum_specifier();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 12 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:146:4: type_id
                    {
                    pushFollow(FOLLOW_type_id_in_type_specifier385);
                    type_id();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, type_specifier_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "type_specifier"



    // $ANTLR start "type_id"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:149:1: type_id :{...}? IDENTIFIER ;
    public final void type_id() throws RecognitionException {
        int type_id_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:150:5: ({...}? IDENTIFIER )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:150:9: {...}? IDENTIFIER
            {
            if ( !((isTypeName(input.LT(1).getText()))) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "type_id", "isTypeName(input.LT(1).getText())");
            }

            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_type_id403); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, type_id_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "type_id"



    // $ANTLR start "struct_or_union_specifier"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:154:1: struct_or_union_specifier options {k=3; } : ( struct_or_union ( IDENTIFIER )? '{' struct_declaration_list '}' | struct_or_union IDENTIFIER );
    public final void struct_or_union_specifier() throws RecognitionException {
        Symbols_stack.push(new Symbols_scope());

        int struct_or_union_specifier_StartIndex = input.index();


          ((Symbols_scope)Symbols_stack.peek()).types = new HashSet();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:160:2: ( struct_or_union ( IDENTIFIER )? '{' struct_declaration_list '}' | struct_or_union IDENTIFIER )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==87||LA14_0==90) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==IDENTIFIER) ) {
                    int LA14_2 = input.LA(3);

                    if ( (LA14_2==95) ) {
                        alt14=1;
                    }
                    else if ( (LA14_2==EOF||LA14_2==IDENTIFIER||(LA14_2 >= 30 && LA14_2 <= 32)||LA14_2==37||(LA14_2 >= 46 && LA14_2 <= 47)||LA14_2==59||LA14_2==63||(LA14_2 >= 66 && LA14_2 <= 67)||LA14_2==71||(LA14_2 >= 73 && LA14_2 <= 75)||(LA14_2 >= 79 && LA14_2 <= 81)||(LA14_2 >= 83 && LA14_2 <= 84)||(LA14_2 >= 86 && LA14_2 <= 87)||(LA14_2 >= 90 && LA14_2 <= 93)) ) {
                        alt14=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 2, input);

                        throw nvae;

                    }
                }
                else if ( (LA14_1==95) ) {
                    alt14=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }
            switch (alt14) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:160:4: struct_or_union ( IDENTIFIER )? '{' struct_declaration_list '}'
                    {
                    pushFollow(FOLLOW_struct_or_union_in_struct_or_union_specifier436);
                    struct_or_union();

                    state._fsp--;
                    if (state.failed) return ;

                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:160:20: ( IDENTIFIER )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==IDENTIFIER) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:160:20: IDENTIFIER
                            {
                            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_struct_or_union_specifier438); if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,95,FOLLOW_95_in_struct_or_union_specifier441); if (state.failed) return ;

                    pushFollow(FOLLOW_struct_declaration_list_in_struct_or_union_specifier443);
                    struct_declaration_list();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,99,FOLLOW_99_in_struct_or_union_specifier445); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:161:4: struct_or_union IDENTIFIER
                    {
                    pushFollow(FOLLOW_struct_or_union_in_struct_or_union_specifier450);
                    struct_or_union();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_struct_or_union_specifier452); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, struct_or_union_specifier_StartIndex); }

            Symbols_stack.pop();

        }
        return ;
    }
    // $ANTLR end "struct_or_union_specifier"



    // $ANTLR start "struct_or_union"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:164:1: struct_or_union : ( 'struct' | 'union' );
    public final void struct_or_union() throws RecognitionException {
        int struct_or_union_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:165:2: ( 'struct' | 'union' )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:
            {
            if ( input.LA(1)==87||input.LA(1)==90 ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, struct_or_union_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "struct_or_union"



    // $ANTLR start "struct_declaration_list"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:169:1: struct_declaration_list : ( struct_declaration )+ ;
    public final void struct_declaration_list() throws RecognitionException {
        int struct_declaration_list_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:170:2: ( ( struct_declaration )+ )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:170:4: ( struct_declaration )+
            {
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:170:4: ( struct_declaration )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==IDENTIFIER||(LA15_0 >= 66 && LA15_0 <= 67)||LA15_0==71||LA15_0==73||LA15_0==75||(LA15_0 >= 79 && LA15_0 <= 80)||(LA15_0 >= 83 && LA15_0 <= 84)||LA15_0==87||(LA15_0 >= 90 && LA15_0 <= 93)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:170:4: struct_declaration
            	    {
            	    pushFollow(FOLLOW_struct_declaration_in_struct_declaration_list479);
            	    struct_declaration();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, struct_declaration_list_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "struct_declaration_list"



    // $ANTLR start "struct_declaration"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:173:1: struct_declaration : specifier_qualifier_list struct_declarator_list ';' ;
    public final void struct_declaration() throws RecognitionException {
        int struct_declaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:174:2: ( specifier_qualifier_list struct_declarator_list ';' )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:174:4: specifier_qualifier_list struct_declarator_list ';'
            {
            pushFollow(FOLLOW_specifier_qualifier_list_in_struct_declaration491);
            specifier_qualifier_list();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_struct_declarator_list_in_struct_declaration493);
            struct_declarator_list();

            state._fsp--;
            if (state.failed) return ;

            match(input,47,FOLLOW_47_in_struct_declaration495); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, struct_declaration_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "struct_declaration"



    // $ANTLR start "specifier_qualifier_list"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:177:1: specifier_qualifier_list : ( type_qualifier | type_specifier )+ ;
    public final void specifier_qualifier_list() throws RecognitionException {
        int specifier_qualifier_list_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:178:2: ( ( type_qualifier | type_specifier )+ )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:178:4: ( type_qualifier | type_specifier )+
            {
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:178:4: ( type_qualifier | type_specifier )+
            int cnt16=0;
            loop16:
            do {
                int alt16=3;
                switch ( input.LA(1) ) {
                case IDENTIFIER:
                    {
                    switch ( input.LA(2) ) {
                    case 59:
                        {
                        int LA16_19 = input.LA(3);

                        if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred35_C())) ) {
                            alt16=2;
                        }


                        }
                        break;
                    case 30:
                        {
                        int LA16_20 = input.LA(3);

                        if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred35_C())) ) {
                            alt16=2;
                        }


                        }
                        break;
                    case 46:
                        {
                        int LA16_21 = input.LA(3);

                        if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred35_C())) ) {
                            alt16=2;
                        }


                        }
                        break;
                    case IDENTIFIER:
                    case 31:
                    case 32:
                    case 66:
                    case 67:
                    case 71:
                    case 73:
                    case 75:
                    case 79:
                    case 80:
                    case 83:
                    case 84:
                    case 87:
                    case 90:
                    case 91:
                    case 92:
                    case 93:
                        {
                        alt16=2;
                        }
                        break;

                    }

                    }
                    break;
                case 67:
                case 93:
                    {
                    alt16=1;
                    }
                    break;
                case 66:
                case 71:
                case 73:
                case 75:
                case 79:
                case 80:
                case 83:
                case 84:
                case 87:
                case 90:
                case 91:
                case 92:
                    {
                    alt16=2;
                    }
                    break;

                }

                switch (alt16) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:178:6: type_qualifier
            	    {
            	    pushFollow(FOLLOW_type_qualifier_in_specifier_qualifier_list508);
            	    type_qualifier();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:178:23: type_specifier
            	    {
            	    pushFollow(FOLLOW_type_specifier_in_specifier_qualifier_list512);
            	    type_specifier();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 15, specifier_qualifier_list_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "specifier_qualifier_list"



    // $ANTLR start "struct_declarator_list"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:181:1: struct_declarator_list : struct_declarator ( ',' struct_declarator )* ;
    public final void struct_declarator_list() throws RecognitionException {
        int struct_declarator_list_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:182:2: ( struct_declarator ( ',' struct_declarator )* )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:182:4: struct_declarator ( ',' struct_declarator )*
            {
            pushFollow(FOLLOW_struct_declarator_in_struct_declarator_list526);
            struct_declarator();

            state._fsp--;
            if (state.failed) return ;

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:182:22: ( ',' struct_declarator )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==37) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:182:23: ',' struct_declarator
            	    {
            	    match(input,37,FOLLOW_37_in_struct_declarator_list529); if (state.failed) return ;

            	    pushFollow(FOLLOW_struct_declarator_in_struct_declarator_list531);
            	    struct_declarator();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 16, struct_declarator_list_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "struct_declarator_list"



    // $ANTLR start "struct_declarator"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:185:1: struct_declarator : ( declarator ( ':' constant_expression )? | ':' constant_expression );
    public final void struct_declarator() throws RecognitionException {
        int struct_declarator_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:186:2: ( declarator ( ':' constant_expression )? | ':' constant_expression )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==IDENTIFIER||LA19_0==30||LA19_0==32) ) {
                alt19=1;
            }
            else if ( (LA19_0==46) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;

            }
            switch (alt19) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:186:4: declarator ( ':' constant_expression )?
                    {
                    pushFollow(FOLLOW_declarator_in_struct_declarator544);
                    declarator();

                    state._fsp--;
                    if (state.failed) return ;

                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:186:15: ( ':' constant_expression )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==46) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:186:16: ':' constant_expression
                            {
                            match(input,46,FOLLOW_46_in_struct_declarator547); if (state.failed) return ;

                            pushFollow(FOLLOW_constant_expression_in_struct_declarator549);
                            constant_expression();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:187:4: ':' constant_expression
                    {
                    match(input,46,FOLLOW_46_in_struct_declarator556); if (state.failed) return ;

                    pushFollow(FOLLOW_constant_expression_in_struct_declarator558);
                    constant_expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 17, struct_declarator_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "struct_declarator"



    // $ANTLR start "enum_specifier"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:190:1: enum_specifier options {k=3; } : ( 'enum' '{' enumerator_list '}' | 'enum' IDENTIFIER '{' enumerator_list '}' | 'enum' IDENTIFIER );
    public final void enum_specifier() throws RecognitionException {
        int enum_specifier_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:192:2: ( 'enum' '{' enumerator_list '}' | 'enum' IDENTIFIER '{' enumerator_list '}' | 'enum' IDENTIFIER )
            int alt20=3;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==73) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==95) ) {
                    alt20=1;
                }
                else if ( (LA20_1==IDENTIFIER) ) {
                    int LA20_3 = input.LA(3);

                    if ( (LA20_3==95) ) {
                        alt20=2;
                    }
                    else if ( (LA20_3==EOF||LA20_3==IDENTIFIER||(LA20_3 >= 30 && LA20_3 <= 32)||LA20_3==37||(LA20_3 >= 46 && LA20_3 <= 47)||LA20_3==59||LA20_3==63||(LA20_3 >= 66 && LA20_3 <= 67)||LA20_3==71||(LA20_3 >= 73 && LA20_3 <= 75)||(LA20_3 >= 79 && LA20_3 <= 81)||(LA20_3 >= 83 && LA20_3 <= 84)||(LA20_3 >= 86 && LA20_3 <= 87)||(LA20_3 >= 90 && LA20_3 <= 93)) ) {
                        alt20=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 3, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;

            }
            switch (alt20) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:192:4: 'enum' '{' enumerator_list '}'
                    {
                    match(input,73,FOLLOW_73_in_enum_specifier576); if (state.failed) return ;

                    match(input,95,FOLLOW_95_in_enum_specifier578); if (state.failed) return ;

                    pushFollow(FOLLOW_enumerator_list_in_enum_specifier580);
                    enumerator_list();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,99,FOLLOW_99_in_enum_specifier582); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:193:4: 'enum' IDENTIFIER '{' enumerator_list '}'
                    {
                    match(input,73,FOLLOW_73_in_enum_specifier587); if (state.failed) return ;

                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enum_specifier589); if (state.failed) return ;

                    match(input,95,FOLLOW_95_in_enum_specifier591); if (state.failed) return ;

                    pushFollow(FOLLOW_enumerator_list_in_enum_specifier593);
                    enumerator_list();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,99,FOLLOW_99_in_enum_specifier595); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:194:4: 'enum' IDENTIFIER
                    {
                    match(input,73,FOLLOW_73_in_enum_specifier600); if (state.failed) return ;

                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enum_specifier602); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 18, enum_specifier_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "enum_specifier"



    // $ANTLR start "enumerator_list"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:197:1: enumerator_list : enumerator ( ',' enumerator )* ;
    public final void enumerator_list() throws RecognitionException {
        int enumerator_list_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:198:2: ( enumerator ( ',' enumerator )* )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:198:4: enumerator ( ',' enumerator )*
            {
            pushFollow(FOLLOW_enumerator_in_enumerator_list613);
            enumerator();

            state._fsp--;
            if (state.failed) return ;

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:198:15: ( ',' enumerator )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==37) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:198:16: ',' enumerator
            	    {
            	    match(input,37,FOLLOW_37_in_enumerator_list616); if (state.failed) return ;

            	    pushFollow(FOLLOW_enumerator_in_enumerator_list618);
            	    enumerator();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 19, enumerator_list_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "enumerator_list"



    // $ANTLR start "enumerator"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:201:1: enumerator : IDENTIFIER ( '=' constant_expression )? ;
    public final void enumerator() throws RecognitionException {
        int enumerator_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:202:2: ( IDENTIFIER ( '=' constant_expression )? )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:202:4: IDENTIFIER ( '=' constant_expression )?
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumerator631); if (state.failed) return ;

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:202:15: ( '=' constant_expression )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==52) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:202:16: '=' constant_expression
                    {
                    match(input,52,FOLLOW_52_in_enumerator634); if (state.failed) return ;

                    pushFollow(FOLLOW_constant_expression_in_enumerator636);
                    constant_expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 20, enumerator_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "enumerator"



    // $ANTLR start "type_qualifier"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:205:1: type_qualifier : ( 'const' | 'volatile' );
    public final void type_qualifier() throws RecognitionException {
        int type_qualifier_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:206:2: ( 'const' | 'volatile' )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:
            {
            if ( input.LA(1)==67||input.LA(1)==93 ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 21, type_qualifier_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "type_qualifier"



    // $ANTLR start "declarator"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:210:1: declarator : ( ( pointer )? direct_declarator | pointer );
    public final void declarator() throws RecognitionException {
        int declarator_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:211:2: ( ( pointer )? direct_declarator | pointer )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==32) ) {
                int LA24_1 = input.LA(2);

                if ( (synpred45_C()) ) {
                    alt24=1;
                }
                else if ( (true) ) {
                    alt24=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA24_0==IDENTIFIER||LA24_0==30) ) {
                alt24=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }
            switch (alt24) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:211:4: ( pointer )? direct_declarator
                    {
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:211:4: ( pointer )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==32) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:211:4: pointer
                            {
                            pushFollow(FOLLOW_pointer_in_declarator665);
                            pointer();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    pushFollow(FOLLOW_direct_declarator_in_declarator668);
                    direct_declarator();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:212:4: pointer
                    {
                    pushFollow(FOLLOW_pointer_in_declarator673);
                    pointer();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 22, declarator_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "declarator"



    // $ANTLR start "direct_declarator"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:215:1: direct_declarator : ( IDENTIFIER | '(' declarator ')' ) ( declarator_suffix )* ;
    public final void direct_declarator() throws RecognitionException {
        int direct_declarator_StartIndex = input.index();

        Token IDENTIFIER1=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:216:2: ( ( IDENTIFIER | '(' declarator ')' ) ( declarator_suffix )* )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:216:6: ( IDENTIFIER | '(' declarator ')' ) ( declarator_suffix )*
            {
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:216:6: ( IDENTIFIER | '(' declarator ')' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==IDENTIFIER) ) {
                alt25=1;
            }
            else if ( (LA25_0==30) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }
            switch (alt25) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:216:8: IDENTIFIER
                    {
                    IDENTIFIER1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_direct_declarator688); if (state.failed) return ;

                    if ( state.backtracking==0 ) {
                    			if (declaration_stack.size()>0&&((declaration_scope)declaration_stack.peek()).isTypedef) {
                    				((Symbols_scope)Symbols_stack.peek()).types.add((IDENTIFIER1!=null?IDENTIFIER1.getText():null));
                    				System.out.println("define type "+(IDENTIFIER1!=null?IDENTIFIER1.getText():null));
                    			}
                    			}

                    }
                    break;
                case 2 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:223:5: '(' declarator ')'
                    {
                    match(input,30,FOLLOW_30_in_direct_declarator699); if (state.failed) return ;

                    pushFollow(FOLLOW_declarator_in_direct_declarator701);
                    declarator();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,31,FOLLOW_31_in_direct_declarator703); if (state.failed) return ;

                    }
                    break;

            }


            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:225:9: ( declarator_suffix )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==30) ) {
                    switch ( input.LA(2) ) {
                    case 31:
                        {
                        int LA26_26 = input.LA(3);

                        if ( (synpred47_C()) ) {
                            alt26=1;
                        }


                        }
                        break;
                    case IDENTIFIER:
                        {
                        int LA26_28 = input.LA(3);

                        if ( (synpred47_C()) ) {
                            alt26=1;
                        }


                        }
                        break;
                    case 63:
                    case 74:
                    case 81:
                    case 86:
                        {
                        int LA26_31 = input.LA(3);

                        if ( (synpred47_C()) ) {
                            alt26=1;
                        }


                        }
                        break;
                    case 92:
                        {
                        int LA26_32 = input.LA(3);

                        if ( (synpred47_C()) ) {
                            alt26=1;
                        }


                        }
                        break;
                    case 66:
                        {
                        int LA26_33 = input.LA(3);

                        if ( (synpred47_C()) ) {
                            alt26=1;
                        }


                        }
                        break;
                    case 83:
                        {
                        int LA26_34 = input.LA(3);

                        if ( (synpred47_C()) ) {
                            alt26=1;
                        }


                        }
                        break;
                    case 79:
                        {
                        int LA26_35 = input.LA(3);

                        if ( (synpred47_C()) ) {
                            alt26=1;
                        }


                        }
                        break;
                    case 80:
                        {
                        int LA26_36 = input.LA(3);

                        if ( (synpred47_C()) ) {
                            alt26=1;
                        }


                        }
                        break;
                    case 75:
                        {
                        int LA26_37 = input.LA(3);

                        if ( (synpred47_C()) ) {
                            alt26=1;
                        }


                        }
                        break;
                    case 71:
                        {
                        int LA26_38 = input.LA(3);

                        if ( (synpred47_C()) ) {
                            alt26=1;
                        }


                        }
                        break;
                    case 84:
                        {
                        int LA26_39 = input.LA(3);

                        if ( (synpred47_C()) ) {
                            alt26=1;
                        }


                        }
                        break;
                    case 91:
                        {
                        int LA26_40 = input.LA(3);

                        if ( (synpred47_C()) ) {
                            alt26=1;
                        }


                        }
                        break;
                    case 87:
                    case 90:
                        {
                        int LA26_41 = input.LA(3);

                        if ( (synpred47_C()) ) {
                            alt26=1;
                        }


                        }
                        break;
                    case 73:
                        {
                        int LA26_42 = input.LA(3);

                        if ( (synpred47_C()) ) {
                            alt26=1;
                        }


                        }
                        break;
                    case 67:
                    case 93:
                        {
                        int LA26_43 = input.LA(3);

                        if ( (synpred47_C()) ) {
                            alt26=1;
                        }


                        }
                        break;

                    }

                }
                else if ( (LA26_0==59) ) {
                    switch ( input.LA(2) ) {
                    case 60:
                        {
                        int LA26_44 = input.LA(3);

                        if ( (synpred47_C()) ) {
                            alt26=1;
                        }


                        }
                        break;
                    case 30:
                        {
                        int LA26_45 = input.LA(3);

                        if ( (synpred47_C()) ) {
                            alt26=1;
                        }


                        }
                        break;
                    case IDENTIFIER:
                        {
                        int LA26_46 = input.LA(3);

                        if ( (synpred47_C()) ) {
                            alt26=1;
                        }


                        }
                        break;
                    case CHARACTER_LITERAL:
                    case DECIMAL_LITERAL:
                    case FLOATING_POINT_LITERAL:
                    case HEX_LITERAL:
                    case OCTAL_LITERAL:
                    case STRING_LITERAL:
                        {
                        int LA26_47 = input.LA(3);

                        if ( (synpred47_C()) ) {
                            alt26=1;
                        }


                        }
                        break;
                    case 35:
                        {
                        int LA26_48 = input.LA(3);

                        if ( (synpred47_C()) ) {
                            alt26=1;
                        }


                        }
                        break;
                    case 39:
                        {
                        int LA26_49 = input.LA(3);

                        if ( (synpred47_C()) ) {
                            alt26=1;
                        }


                        }
                        break;
                    case 23:
                    case 28:
                    case 32:
                    case 34:
                    case 38:
                    case 100:
                        {
                        int LA26_50 = input.LA(3);

                        if ( (synpred47_C()) ) {
                            alt26=1;
                        }


                        }
                        break;
                    case 85:
                        {
                        int LA26_51 = input.LA(3);

                        if ( (synpred47_C()) ) {
                            alt26=1;
                        }


                        }
                        break;

                    }

                }


                switch (alt26) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:225:9: declarator_suffix
            	    {
            	    pushFollow(FOLLOW_declarator_suffix_in_direct_declarator717);
            	    declarator_suffix();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 23, direct_declarator_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "direct_declarator"



    // $ANTLR start "declarator_suffix"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:228:1: declarator_suffix : ( '[' constant_expression ']' | '[' ']' | '(' parameter_type_list ')' | '(' identifier_list ')' | '(' ')' );
    public final void declarator_suffix() throws RecognitionException {
        int declarator_suffix_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:229:2: ( '[' constant_expression ']' | '[' ']' | '(' parameter_type_list ')' | '(' identifier_list ')' | '(' ')' )
            int alt27=5;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==59) ) {
                int LA27_1 = input.LA(2);

                if ( (LA27_1==60) ) {
                    alt27=2;
                }
                else if ( (LA27_1==CHARACTER_LITERAL||LA27_1==DECIMAL_LITERAL||LA27_1==FLOATING_POINT_LITERAL||LA27_1==HEX_LITERAL||LA27_1==IDENTIFIER||LA27_1==OCTAL_LITERAL||LA27_1==STRING_LITERAL||LA27_1==23||LA27_1==28||LA27_1==30||LA27_1==32||(LA27_1 >= 34 && LA27_1 <= 35)||(LA27_1 >= 38 && LA27_1 <= 39)||LA27_1==85||LA27_1==100) ) {
                    alt27=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA27_0==30) ) {
                switch ( input.LA(2) ) {
                case 31:
                    {
                    alt27=5;
                    }
                    break;
                case 63:
                case 66:
                case 67:
                case 71:
                case 73:
                case 74:
                case 75:
                case 79:
                case 80:
                case 81:
                case 83:
                case 84:
                case 86:
                case 87:
                case 90:
                case 91:
                case 92:
                case 93:
                    {
                    alt27=3;
                    }
                    break;
                case IDENTIFIER:
                    {
                    int LA27_24 = input.LA(3);

                    if ( (synpred50_C()) ) {
                        alt27=3;
                    }
                    else if ( (synpred51_C()) ) {
                        alt27=4;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 27, 24, input);

                        throw nvae;

                    }
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 2, input);

                    throw nvae;

                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;

            }
            switch (alt27) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:229:6: '[' constant_expression ']'
                    {
                    match(input,59,FOLLOW_59_in_declarator_suffix731); if (state.failed) return ;

                    pushFollow(FOLLOW_constant_expression_in_declarator_suffix733);
                    constant_expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,60,FOLLOW_60_in_declarator_suffix735); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:230:9: '[' ']'
                    {
                    match(input,59,FOLLOW_59_in_declarator_suffix745); if (state.failed) return ;

                    match(input,60,FOLLOW_60_in_declarator_suffix747); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:231:9: '(' parameter_type_list ')'
                    {
                    match(input,30,FOLLOW_30_in_declarator_suffix757); if (state.failed) return ;

                    pushFollow(FOLLOW_parameter_type_list_in_declarator_suffix759);
                    parameter_type_list();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,31,FOLLOW_31_in_declarator_suffix761); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:232:9: '(' identifier_list ')'
                    {
                    match(input,30,FOLLOW_30_in_declarator_suffix771); if (state.failed) return ;

                    pushFollow(FOLLOW_identifier_list_in_declarator_suffix773);
                    identifier_list();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,31,FOLLOW_31_in_declarator_suffix775); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:233:9: '(' ')'
                    {
                    match(input,30,FOLLOW_30_in_declarator_suffix785); if (state.failed) return ;

                    match(input,31,FOLLOW_31_in_declarator_suffix787); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 24, declarator_suffix_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "declarator_suffix"



    // $ANTLR start "pointer"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:236:1: pointer : ( '*' ( type_qualifier )+ ( pointer )? | '*' pointer | '*' );
    public final void pointer() throws RecognitionException {
        int pointer_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:237:2: ( '*' ( type_qualifier )+ ( pointer )? | '*' pointer | '*' )
            int alt30=3;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==32) ) {
                switch ( input.LA(2) ) {
                case 67:
                case 93:
                    {
                    int LA30_2 = input.LA(3);

                    if ( (synpred54_C()) ) {
                        alt30=1;
                    }
                    else if ( (true) ) {
                        alt30=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 2, input);

                        throw nvae;

                    }
                    }
                    break;
                case 32:
                    {
                    int LA30_3 = input.LA(3);

                    if ( (synpred55_C()) ) {
                        alt30=2;
                    }
                    else if ( (true) ) {
                        alt30=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 30, 3, input);

                        throw nvae;

                    }
                    }
                    break;
                case EOF:
                case IDENTIFIER:
                case 30:
                case 31:
                case 37:
                case 46:
                case 47:
                case 52:
                case 59:
                case 63:
                case 66:
                case 71:
                case 73:
                case 74:
                case 75:
                case 79:
                case 80:
                case 81:
                case 83:
                case 84:
                case 86:
                case 87:
                case 89:
                case 90:
                case 91:
                case 92:
                case 95:
                    {
                    alt30=3;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 1, input);

                    throw nvae;

                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;

            }
            switch (alt30) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:237:4: '*' ( type_qualifier )+ ( pointer )?
                    {
                    match(input,32,FOLLOW_32_in_pointer798); if (state.failed) return ;

                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:237:8: ( type_qualifier )+
                    int cnt28=0;
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==67||LA28_0==93) ) {
                            int LA28_17 = input.LA(2);

                            if ( (synpred52_C()) ) {
                                alt28=1;
                            }


                        }


                        switch (alt28) {
                    	case 1 :
                    	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:237:8: type_qualifier
                    	    {
                    	    pushFollow(FOLLOW_type_qualifier_in_pointer800);
                    	    type_qualifier();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt28 >= 1 ) break loop28;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(28, input);
                                throw eee;
                        }
                        cnt28++;
                    } while (true);


                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:237:24: ( pointer )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==32) ) {
                        int LA29_1 = input.LA(2);

                        if ( (synpred53_C()) ) {
                            alt29=1;
                        }
                    }
                    switch (alt29) {
                        case 1 :
                            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:237:24: pointer
                            {
                            pushFollow(FOLLOW_pointer_in_pointer803);
                            pointer();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:238:4: '*' pointer
                    {
                    match(input,32,FOLLOW_32_in_pointer809); if (state.failed) return ;

                    pushFollow(FOLLOW_pointer_in_pointer811);
                    pointer();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:239:4: '*'
                    {
                    match(input,32,FOLLOW_32_in_pointer816); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 25, pointer_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "pointer"



    // $ANTLR start "parameter_type_list"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:242:1: parameter_type_list : parameter_list ( ',' '...' )? ;
    public final void parameter_type_list() throws RecognitionException {
        int parameter_type_list_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:243:2: ( parameter_list ( ',' '...' )? )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:243:4: parameter_list ( ',' '...' )?
            {
            pushFollow(FOLLOW_parameter_list_in_parameter_type_list827);
            parameter_list();

            state._fsp--;
            if (state.failed) return ;

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:243:19: ( ',' '...' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==37) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:243:20: ',' '...'
                    {
                    match(input,37,FOLLOW_37_in_parameter_type_list830); if (state.failed) return ;

                    match(input,43,FOLLOW_43_in_parameter_type_list832); if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 26, parameter_type_list_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "parameter_type_list"



    // $ANTLR start "parameter_list"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:246:1: parameter_list : parameter_declaration ( ',' parameter_declaration )* ;
    public final void parameter_list() throws RecognitionException {
        int parameter_list_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:247:2: ( parameter_declaration ( ',' parameter_declaration )* )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:247:4: parameter_declaration ( ',' parameter_declaration )*
            {
            pushFollow(FOLLOW_parameter_declaration_in_parameter_list845);
            parameter_declaration();

            state._fsp--;
            if (state.failed) return ;

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:247:26: ( ',' parameter_declaration )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==37) ) {
                    int LA32_1 = input.LA(2);

                    if ( (LA32_1==IDENTIFIER||LA32_1==63||(LA32_1 >= 66 && LA32_1 <= 67)||LA32_1==71||(LA32_1 >= 73 && LA32_1 <= 75)||(LA32_1 >= 79 && LA32_1 <= 81)||(LA32_1 >= 83 && LA32_1 <= 84)||(LA32_1 >= 86 && LA32_1 <= 87)||(LA32_1 >= 90 && LA32_1 <= 93)) ) {
                        alt32=1;
                    }


                }


                switch (alt32) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:247:27: ',' parameter_declaration
            	    {
            	    match(input,37,FOLLOW_37_in_parameter_list848); if (state.failed) return ;

            	    pushFollow(FOLLOW_parameter_declaration_in_parameter_list850);
            	    parameter_declaration();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 27, parameter_list_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "parameter_list"



    // $ANTLR start "parameter_declaration"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:250:1: parameter_declaration : declaration_specifiers ( declarator | abstract_declarator )* ;
    public final void parameter_declaration() throws RecognitionException {
        int parameter_declaration_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:251:2: ( declaration_specifiers ( declarator | abstract_declarator )* )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:251:4: declaration_specifiers ( declarator | abstract_declarator )*
            {
            pushFollow(FOLLOW_declaration_specifiers_in_parameter_declaration863);
            declaration_specifiers();

            state._fsp--;
            if (state.failed) return ;

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:251:27: ( declarator | abstract_declarator )*
            loop33:
            do {
                int alt33=3;
                switch ( input.LA(1) ) {
                case 32:
                    {
                    int LA33_4 = input.LA(2);

                    if ( (synpred58_C()) ) {
                        alt33=1;
                    }
                    else if ( (synpred59_C()) ) {
                        alt33=2;
                    }


                    }
                    break;
                case IDENTIFIER:
                    {
                    alt33=1;
                    }
                    break;
                case 30:
                    {
                    switch ( input.LA(2) ) {
                    case 31:
                    case 59:
                    case 63:
                    case 66:
                    case 67:
                    case 71:
                    case 73:
                    case 74:
                    case 75:
                    case 79:
                    case 80:
                    case 81:
                    case 83:
                    case 84:
                    case 86:
                    case 87:
                    case 90:
                    case 91:
                    case 92:
                    case 93:
                        {
                        alt33=2;
                        }
                        break;
                    case 32:
                        {
                        int LA33_17 = input.LA(3);

                        if ( (synpred58_C()) ) {
                            alt33=1;
                        }
                        else if ( (synpred59_C()) ) {
                            alt33=2;
                        }


                        }
                        break;
                    case IDENTIFIER:
                        {
                        int LA33_18 = input.LA(3);

                        if ( (synpred58_C()) ) {
                            alt33=1;
                        }
                        else if ( (synpred59_C()) ) {
                            alt33=2;
                        }


                        }
                        break;
                    case 30:
                        {
                        int LA33_19 = input.LA(3);

                        if ( (synpred58_C()) ) {
                            alt33=1;
                        }
                        else if ( (synpred59_C()) ) {
                            alt33=2;
                        }


                        }
                        break;

                    }

                    }
                    break;
                case 59:
                    {
                    alt33=2;
                    }
                    break;

                }

                switch (alt33) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:251:28: declarator
            	    {
            	    pushFollow(FOLLOW_declarator_in_parameter_declaration866);
            	    declarator();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:251:39: abstract_declarator
            	    {
            	    pushFollow(FOLLOW_abstract_declarator_in_parameter_declaration868);
            	    abstract_declarator();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 28, parameter_declaration_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "parameter_declaration"



    // $ANTLR start "identifier_list"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:254:1: identifier_list : IDENTIFIER ( ',' IDENTIFIER )* ;
    public final void identifier_list() throws RecognitionException {
        int identifier_list_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:255:2: ( IDENTIFIER ( ',' IDENTIFIER )* )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:255:4: IDENTIFIER ( ',' IDENTIFIER )*
            {
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_identifier_list881); if (state.failed) return ;

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:255:15: ( ',' IDENTIFIER )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==37) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:255:16: ',' IDENTIFIER
            	    {
            	    match(input,37,FOLLOW_37_in_identifier_list884); if (state.failed) return ;

            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_identifier_list886); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 29, identifier_list_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "identifier_list"



    // $ANTLR start "type_name"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:258:1: type_name : specifier_qualifier_list ( abstract_declarator )? ;
    public final void type_name() throws RecognitionException {
        int type_name_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:259:2: ( specifier_qualifier_list ( abstract_declarator )? )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:259:4: specifier_qualifier_list ( abstract_declarator )?
            {
            pushFollow(FOLLOW_specifier_qualifier_list_in_type_name899);
            specifier_qualifier_list();

            state._fsp--;
            if (state.failed) return ;

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:259:29: ( abstract_declarator )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==30||LA35_0==32||LA35_0==59) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:259:29: abstract_declarator
                    {
                    pushFollow(FOLLOW_abstract_declarator_in_type_name901);
                    abstract_declarator();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 30, type_name_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "type_name"



    // $ANTLR start "abstract_declarator"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:262:1: abstract_declarator : ( pointer ( direct_abstract_declarator )? | direct_abstract_declarator );
    public final void abstract_declarator() throws RecognitionException {
        int abstract_declarator_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:263:2: ( pointer ( direct_abstract_declarator )? | direct_abstract_declarator )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==32) ) {
                alt37=1;
            }
            else if ( (LA37_0==30||LA37_0==59) ) {
                alt37=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;

            }
            switch (alt37) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:263:4: pointer ( direct_abstract_declarator )?
                    {
                    pushFollow(FOLLOW_pointer_in_abstract_declarator913);
                    pointer();

                    state._fsp--;
                    if (state.failed) return ;

                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:263:12: ( direct_abstract_declarator )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==30) ) {
                        switch ( input.LA(2) ) {
                            case 31:
                                {
                                int LA36_8 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                            case 32:
                                {
                                int LA36_9 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                            case 30:
                                {
                                int LA36_10 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                            case 59:
                                {
                                int LA36_11 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                            case 63:
                            case 74:
                            case 81:
                            case 86:
                                {
                                int LA36_12 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                            case 92:
                                {
                                int LA36_13 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                            case 66:
                                {
                                int LA36_14 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                            case 83:
                                {
                                int LA36_15 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                            case 79:
                                {
                                int LA36_16 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                            case 80:
                                {
                                int LA36_17 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                            case 75:
                                {
                                int LA36_18 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                            case 71:
                                {
                                int LA36_19 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                            case 84:
                                {
                                int LA36_20 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                            case 91:
                                {
                                int LA36_21 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                            case 87:
                            case 90:
                                {
                                int LA36_22 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                            case 73:
                                {
                                int LA36_23 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                            case IDENTIFIER:
                                {
                                int LA36_24 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                            case 67:
                            case 93:
                                {
                                int LA36_25 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                        }

                    }
                    else if ( (LA36_0==59) ) {
                        switch ( input.LA(2) ) {
                            case 60:
                                {
                                int LA36_26 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                            case 30:
                                {
                                int LA36_27 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                            case IDENTIFIER:
                                {
                                int LA36_28 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                            case CHARACTER_LITERAL:
                            case DECIMAL_LITERAL:
                            case FLOATING_POINT_LITERAL:
                            case HEX_LITERAL:
                            case OCTAL_LITERAL:
                            case STRING_LITERAL:
                                {
                                int LA36_29 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                            case 35:
                                {
                                int LA36_30 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                            case 39:
                                {
                                int LA36_31 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                            case 23:
                            case 28:
                            case 32:
                            case 34:
                            case 38:
                            case 100:
                                {
                                int LA36_32 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                            case 85:
                                {
                                int LA36_33 = input.LA(3);

                                if ( (synpred62_C()) ) {
                                    alt36=1;
                                }
                                }
                                break;
                        }

                    }
                    switch (alt36) {
                        case 1 :
                            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:263:12: direct_abstract_declarator
                            {
                            pushFollow(FOLLOW_direct_abstract_declarator_in_abstract_declarator915);
                            direct_abstract_declarator();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:264:4: direct_abstract_declarator
                    {
                    pushFollow(FOLLOW_direct_abstract_declarator_in_abstract_declarator921);
                    direct_abstract_declarator();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 31, abstract_declarator_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "abstract_declarator"



    // $ANTLR start "direct_abstract_declarator"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:267:1: direct_abstract_declarator : ( '(' abstract_declarator ')' | abstract_declarator_suffix ) ( abstract_declarator_suffix )* ;
    public final void direct_abstract_declarator() throws RecognitionException {
        int direct_abstract_declarator_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:268:2: ( ( '(' abstract_declarator ')' | abstract_declarator_suffix ) ( abstract_declarator_suffix )* )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:268:4: ( '(' abstract_declarator ')' | abstract_declarator_suffix ) ( abstract_declarator_suffix )*
            {
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:268:4: ( '(' abstract_declarator ')' | abstract_declarator_suffix )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==30) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==IDENTIFIER||LA38_1==31||LA38_1==63||(LA38_1 >= 66 && LA38_1 <= 67)||LA38_1==71||(LA38_1 >= 73 && LA38_1 <= 75)||(LA38_1 >= 79 && LA38_1 <= 81)||(LA38_1 >= 83 && LA38_1 <= 84)||(LA38_1 >= 86 && LA38_1 <= 87)||(LA38_1 >= 90 && LA38_1 <= 93)) ) {
                    alt38=2;
                }
                else if ( (LA38_1==30||LA38_1==32||LA38_1==59) ) {
                    alt38=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA38_0==59) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;

            }
            switch (alt38) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:268:6: '(' abstract_declarator ')'
                    {
                    match(input,30,FOLLOW_30_in_direct_abstract_declarator934); if (state.failed) return ;

                    pushFollow(FOLLOW_abstract_declarator_in_direct_abstract_declarator936);
                    abstract_declarator();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,31,FOLLOW_31_in_direct_abstract_declarator938); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:268:36: abstract_declarator_suffix
                    {
                    pushFollow(FOLLOW_abstract_declarator_suffix_in_direct_abstract_declarator942);
                    abstract_declarator_suffix();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:268:65: ( abstract_declarator_suffix )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==30) ) {
                    switch ( input.LA(2) ) {
                    case 31:
                        {
                        int LA39_8 = input.LA(3);

                        if ( (synpred65_C()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case IDENTIFIER:
                        {
                        int LA39_10 = input.LA(3);

                        if ( (synpred65_C()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case 63:
                    case 74:
                    case 81:
                    case 86:
                        {
                        int LA39_13 = input.LA(3);

                        if ( (synpred65_C()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case 92:
                        {
                        int LA39_14 = input.LA(3);

                        if ( (synpred65_C()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case 66:
                        {
                        int LA39_15 = input.LA(3);

                        if ( (synpred65_C()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case 83:
                        {
                        int LA39_16 = input.LA(3);

                        if ( (synpred65_C()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case 79:
                        {
                        int LA39_17 = input.LA(3);

                        if ( (synpred65_C()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case 80:
                        {
                        int LA39_18 = input.LA(3);

                        if ( (synpred65_C()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case 75:
                        {
                        int LA39_19 = input.LA(3);

                        if ( (synpred65_C()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case 71:
                        {
                        int LA39_20 = input.LA(3);

                        if ( (synpred65_C()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case 84:
                        {
                        int LA39_21 = input.LA(3);

                        if ( (synpred65_C()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case 91:
                        {
                        int LA39_22 = input.LA(3);

                        if ( (synpred65_C()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case 87:
                    case 90:
                        {
                        int LA39_23 = input.LA(3);

                        if ( (synpred65_C()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case 73:
                        {
                        int LA39_24 = input.LA(3);

                        if ( (synpred65_C()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case 67:
                    case 93:
                        {
                        int LA39_25 = input.LA(3);

                        if ( (synpred65_C()) ) {
                            alt39=1;
                        }


                        }
                        break;

                    }

                }
                else if ( (LA39_0==59) ) {
                    switch ( input.LA(2) ) {
                    case 60:
                        {
                        int LA39_26 = input.LA(3);

                        if ( (synpred65_C()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case 30:
                        {
                        int LA39_27 = input.LA(3);

                        if ( (synpred65_C()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case IDENTIFIER:
                        {
                        int LA39_28 = input.LA(3);

                        if ( (synpred65_C()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case CHARACTER_LITERAL:
                    case DECIMAL_LITERAL:
                    case FLOATING_POINT_LITERAL:
                    case HEX_LITERAL:
                    case OCTAL_LITERAL:
                    case STRING_LITERAL:
                        {
                        int LA39_29 = input.LA(3);

                        if ( (synpred65_C()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case 35:
                        {
                        int LA39_30 = input.LA(3);

                        if ( (synpred65_C()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case 39:
                        {
                        int LA39_31 = input.LA(3);

                        if ( (synpred65_C()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case 23:
                    case 28:
                    case 32:
                    case 34:
                    case 38:
                    case 100:
                        {
                        int LA39_32 = input.LA(3);

                        if ( (synpred65_C()) ) {
                            alt39=1;
                        }


                        }
                        break;
                    case 85:
                        {
                        int LA39_33 = input.LA(3);

                        if ( (synpred65_C()) ) {
                            alt39=1;
                        }


                        }
                        break;

                    }

                }


                switch (alt39) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:268:65: abstract_declarator_suffix
            	    {
            	    pushFollow(FOLLOW_abstract_declarator_suffix_in_direct_abstract_declarator946);
            	    abstract_declarator_suffix();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 32, direct_abstract_declarator_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "direct_abstract_declarator"



    // $ANTLR start "abstract_declarator_suffix"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:271:1: abstract_declarator_suffix : ( '[' ']' | '[' constant_expression ']' | '(' ')' | '(' parameter_type_list ')' );
    public final void abstract_declarator_suffix() throws RecognitionException {
        int abstract_declarator_suffix_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:272:2: ( '[' ']' | '[' constant_expression ']' | '(' ')' | '(' parameter_type_list ')' )
            int alt40=4;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==59) ) {
                int LA40_1 = input.LA(2);

                if ( (LA40_1==60) ) {
                    alt40=1;
                }
                else if ( (LA40_1==CHARACTER_LITERAL||LA40_1==DECIMAL_LITERAL||LA40_1==FLOATING_POINT_LITERAL||LA40_1==HEX_LITERAL||LA40_1==IDENTIFIER||LA40_1==OCTAL_LITERAL||LA40_1==STRING_LITERAL||LA40_1==23||LA40_1==28||LA40_1==30||LA40_1==32||(LA40_1 >= 34 && LA40_1 <= 35)||(LA40_1 >= 38 && LA40_1 <= 39)||LA40_1==85||LA40_1==100) ) {
                    alt40=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA40_0==30) ) {
                int LA40_2 = input.LA(2);

                if ( (LA40_2==31) ) {
                    alt40=3;
                }
                else if ( (LA40_2==IDENTIFIER||LA40_2==63||(LA40_2 >= 66 && LA40_2 <= 67)||LA40_2==71||(LA40_2 >= 73 && LA40_2 <= 75)||(LA40_2 >= 79 && LA40_2 <= 81)||(LA40_2 >= 83 && LA40_2 <= 84)||(LA40_2 >= 86 && LA40_2 <= 87)||(LA40_2 >= 90 && LA40_2 <= 93)) ) {
                    alt40=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 2, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;

            }
            switch (alt40) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:272:4: '[' ']'
                    {
                    match(input,59,FOLLOW_59_in_abstract_declarator_suffix958); if (state.failed) return ;

                    match(input,60,FOLLOW_60_in_abstract_declarator_suffix960); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:273:4: '[' constant_expression ']'
                    {
                    match(input,59,FOLLOW_59_in_abstract_declarator_suffix965); if (state.failed) return ;

                    pushFollow(FOLLOW_constant_expression_in_abstract_declarator_suffix967);
                    constant_expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,60,FOLLOW_60_in_abstract_declarator_suffix969); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:274:4: '(' ')'
                    {
                    match(input,30,FOLLOW_30_in_abstract_declarator_suffix974); if (state.failed) return ;

                    match(input,31,FOLLOW_31_in_abstract_declarator_suffix976); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:275:4: '(' parameter_type_list ')'
                    {
                    match(input,30,FOLLOW_30_in_abstract_declarator_suffix981); if (state.failed) return ;

                    pushFollow(FOLLOW_parameter_type_list_in_abstract_declarator_suffix983);
                    parameter_type_list();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,31,FOLLOW_31_in_abstract_declarator_suffix985); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 33, abstract_declarator_suffix_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "abstract_declarator_suffix"



    // $ANTLR start "initializer"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:278:1: initializer : ( assignment_expression | '{' initializer_list ( ',' )? '}' );
    public final void initializer() throws RecognitionException {
        int initializer_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:279:2: ( assignment_expression | '{' initializer_list ( ',' )? '}' )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==CHARACTER_LITERAL||LA42_0==DECIMAL_LITERAL||LA42_0==FLOATING_POINT_LITERAL||LA42_0==HEX_LITERAL||LA42_0==IDENTIFIER||LA42_0==OCTAL_LITERAL||LA42_0==STRING_LITERAL||LA42_0==23||LA42_0==28||LA42_0==30||LA42_0==32||(LA42_0 >= 34 && LA42_0 <= 35)||(LA42_0 >= 38 && LA42_0 <= 39)||LA42_0==85||LA42_0==100) ) {
                alt42=1;
            }
            else if ( (LA42_0==95) ) {
                alt42=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;

            }
            switch (alt42) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:279:4: assignment_expression
                    {
                    pushFollow(FOLLOW_assignment_expression_in_initializer997);
                    assignment_expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:280:4: '{' initializer_list ( ',' )? '}'
                    {
                    match(input,95,FOLLOW_95_in_initializer1002); if (state.failed) return ;

                    pushFollow(FOLLOW_initializer_list_in_initializer1004);
                    initializer_list();

                    state._fsp--;
                    if (state.failed) return ;

                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:280:25: ( ',' )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==37) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:280:25: ','
                            {
                            match(input,37,FOLLOW_37_in_initializer1006); if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,99,FOLLOW_99_in_initializer1009); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 34, initializer_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "initializer"



    // $ANTLR start "initializer_list"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:283:1: initializer_list : initializer ( ',' initializer )* ;
    public final void initializer_list() throws RecognitionException {
        int initializer_list_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:284:2: ( initializer ( ',' initializer )* )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:284:4: initializer ( ',' initializer )*
            {
            pushFollow(FOLLOW_initializer_in_initializer_list1020);
            initializer();

            state._fsp--;
            if (state.failed) return ;

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:284:16: ( ',' initializer )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==37) ) {
                    int LA43_1 = input.LA(2);

                    if ( (LA43_1==CHARACTER_LITERAL||LA43_1==DECIMAL_LITERAL||LA43_1==FLOATING_POINT_LITERAL||LA43_1==HEX_LITERAL||LA43_1==IDENTIFIER||LA43_1==OCTAL_LITERAL||LA43_1==STRING_LITERAL||LA43_1==23||LA43_1==28||LA43_1==30||LA43_1==32||(LA43_1 >= 34 && LA43_1 <= 35)||(LA43_1 >= 38 && LA43_1 <= 39)||LA43_1==85||LA43_1==95||LA43_1==100) ) {
                        alt43=1;
                    }


                }


                switch (alt43) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:284:17: ',' initializer
            	    {
            	    match(input,37,FOLLOW_37_in_initializer_list1023); if (state.failed) return ;

            	    pushFollow(FOLLOW_initializer_in_initializer_list1025);
            	    initializer();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 35, initializer_list_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "initializer_list"



    // $ANTLR start "argument_expression_list"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:289:1: argument_expression_list : assignment_expression ( ',' assignment_expression )* ;
    public final void argument_expression_list() throws RecognitionException {
        int argument_expression_list_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:290:2: ( assignment_expression ( ',' assignment_expression )* )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:290:6: assignment_expression ( ',' assignment_expression )*
            {
            pushFollow(FOLLOW_assignment_expression_in_argument_expression_list1042);
            assignment_expression();

            state._fsp--;
            if (state.failed) return ;

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:290:28: ( ',' assignment_expression )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==37) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:290:29: ',' assignment_expression
            	    {
            	    match(input,37,FOLLOW_37_in_argument_expression_list1045); if (state.failed) return ;

            	    pushFollow(FOLLOW_assignment_expression_in_argument_expression_list1047);
            	    assignment_expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 36, argument_expression_list_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "argument_expression_list"



    // $ANTLR start "additive_expression"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:293:1: additive_expression : ( multiplicative_expression ) ( '+' multiplicative_expression | '-' multiplicative_expression )* ;
    public final void additive_expression() throws RecognitionException {
        int additive_expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:294:2: ( ( multiplicative_expression ) ( '+' multiplicative_expression | '-' multiplicative_expression )* )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:294:4: ( multiplicative_expression ) ( '+' multiplicative_expression | '-' multiplicative_expression )*
            {
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:294:4: ( multiplicative_expression )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:294:5: multiplicative_expression
            {
            pushFollow(FOLLOW_multiplicative_expression_in_additive_expression1061);
            multiplicative_expression();

            state._fsp--;
            if (state.failed) return ;

            }


            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:294:32: ( '+' multiplicative_expression | '-' multiplicative_expression )*
            loop45:
            do {
                int alt45=3;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==34) ) {
                    alt45=1;
                }
                else if ( (LA45_0==38) ) {
                    alt45=2;
                }


                switch (alt45) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:294:33: '+' multiplicative_expression
            	    {
            	    match(input,34,FOLLOW_34_in_additive_expression1065); if (state.failed) return ;

            	    pushFollow(FOLLOW_multiplicative_expression_in_additive_expression1067);
            	    multiplicative_expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:294:65: '-' multiplicative_expression
            	    {
            	    match(input,38,FOLLOW_38_in_additive_expression1071); if (state.failed) return ;

            	    pushFollow(FOLLOW_multiplicative_expression_in_additive_expression1073);
            	    multiplicative_expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 37, additive_expression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "additive_expression"



    // $ANTLR start "multiplicative_expression"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:297:1: multiplicative_expression : ( cast_expression ) ( '*' cast_expression | '/' cast_expression | '%' cast_expression )* ;
    public final void multiplicative_expression() throws RecognitionException {
        int multiplicative_expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:298:2: ( ( cast_expression ) ( '*' cast_expression | '/' cast_expression | '%' cast_expression )* )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:298:4: ( cast_expression ) ( '*' cast_expression | '/' cast_expression | '%' cast_expression )*
            {
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:298:4: ( cast_expression )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:298:5: cast_expression
            {
            pushFollow(FOLLOW_cast_expression_in_multiplicative_expression1087);
            cast_expression();

            state._fsp--;
            if (state.failed) return ;

            }


            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:298:22: ( '*' cast_expression | '/' cast_expression | '%' cast_expression )*
            loop46:
            do {
                int alt46=4;
                switch ( input.LA(1) ) {
                case 32:
                    {
                    alt46=1;
                    }
                    break;
                case 44:
                    {
                    alt46=2;
                    }
                    break;
                case 25:
                    {
                    alt46=3;
                    }
                    break;

                }

                switch (alt46) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:298:23: '*' cast_expression
            	    {
            	    match(input,32,FOLLOW_32_in_multiplicative_expression1091); if (state.failed) return ;

            	    pushFollow(FOLLOW_cast_expression_in_multiplicative_expression1093);
            	    cast_expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:298:45: '/' cast_expression
            	    {
            	    match(input,44,FOLLOW_44_in_multiplicative_expression1097); if (state.failed) return ;

            	    pushFollow(FOLLOW_cast_expression_in_multiplicative_expression1099);
            	    cast_expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;
            	case 3 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:298:67: '%' cast_expression
            	    {
            	    match(input,25,FOLLOW_25_in_multiplicative_expression1103); if (state.failed) return ;

            	    pushFollow(FOLLOW_cast_expression_in_multiplicative_expression1105);
            	    cast_expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 38, multiplicative_expression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "multiplicative_expression"



    // $ANTLR start "cast_expression"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:301:1: cast_expression : ( '(' type_name ')' cast_expression | unary_expression );
    public final void cast_expression() throws RecognitionException {
        int cast_expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:302:2: ( '(' type_name ')' cast_expression | unary_expression )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==30) ) {
                switch ( input.LA(2) ) {
                case 66:
                case 67:
                case 71:
                case 73:
                case 75:
                case 79:
                case 80:
                case 83:
                case 84:
                case 87:
                case 90:
                case 91:
                case 92:
                case 93:
                    {
                    alt47=1;
                    }
                    break;
                case IDENTIFIER:
                    {
                    int LA47_20 = input.LA(3);

                    if ( (synpred78_C()) ) {
                        alt47=1;
                    }
                    else if ( (true) ) {
                        alt47=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 47, 20, input);

                        throw nvae;

                    }
                    }
                    break;
                case CHARACTER_LITERAL:
                case DECIMAL_LITERAL:
                case FLOATING_POINT_LITERAL:
                case HEX_LITERAL:
                case OCTAL_LITERAL:
                case STRING_LITERAL:
                case 23:
                case 28:
                case 30:
                case 32:
                case 34:
                case 35:
                case 38:
                case 39:
                case 85:
                case 100:
                    {
                    alt47=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 1, input);

                    throw nvae;

                }

            }
            else if ( (LA47_0==CHARACTER_LITERAL||LA47_0==DECIMAL_LITERAL||LA47_0==FLOATING_POINT_LITERAL||LA47_0==HEX_LITERAL||LA47_0==IDENTIFIER||LA47_0==OCTAL_LITERAL||LA47_0==STRING_LITERAL||LA47_0==23||LA47_0==28||LA47_0==32||(LA47_0 >= 34 && LA47_0 <= 35)||(LA47_0 >= 38 && LA47_0 <= 39)||LA47_0==85||LA47_0==100) ) {
                alt47=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;

            }
            switch (alt47) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:302:4: '(' type_name ')' cast_expression
                    {
                    match(input,30,FOLLOW_30_in_cast_expression1118); if (state.failed) return ;

                    pushFollow(FOLLOW_type_name_in_cast_expression1120);
                    type_name();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,31,FOLLOW_31_in_cast_expression1122); if (state.failed) return ;

                    pushFollow(FOLLOW_cast_expression_in_cast_expression1124);
                    cast_expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:303:4: unary_expression
                    {
                    pushFollow(FOLLOW_unary_expression_in_cast_expression1129);
                    unary_expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 39, cast_expression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "cast_expression"



    // $ANTLR start "unary_expression"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:306:1: unary_expression : ( postfix_expression | '++' unary_expression | '--' unary_expression | unary_operator cast_expression | 'sizeof' unary_expression | 'sizeof' '(' type_name ')' );
    public final void unary_expression() throws RecognitionException {
        int unary_expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:307:2: ( postfix_expression | '++' unary_expression | '--' unary_expression | unary_operator cast_expression | 'sizeof' unary_expression | 'sizeof' '(' type_name ')' )
            int alt48=6;
            switch ( input.LA(1) ) {
            case CHARACTER_LITERAL:
            case DECIMAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case HEX_LITERAL:
            case IDENTIFIER:
            case OCTAL_LITERAL:
            case STRING_LITERAL:
            case 30:
                {
                alt48=1;
                }
                break;
            case 35:
                {
                alt48=2;
                }
                break;
            case 39:
                {
                alt48=3;
                }
                break;
            case 23:
            case 28:
            case 32:
            case 34:
            case 38:
            case 100:
                {
                alt48=4;
                }
                break;
            case 85:
                {
                int LA48_7 = input.LA(2);

                if ( (LA48_7==30) ) {
                    int LA48_8 = input.LA(3);

                    if ( (synpred83_C()) ) {
                        alt48=5;
                    }
                    else if ( (true) ) {
                        alt48=6;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 48, 8, input);

                        throw nvae;

                    }
                }
                else if ( (LA48_7==CHARACTER_LITERAL||LA48_7==DECIMAL_LITERAL||LA48_7==FLOATING_POINT_LITERAL||LA48_7==HEX_LITERAL||LA48_7==IDENTIFIER||LA48_7==OCTAL_LITERAL||LA48_7==STRING_LITERAL||LA48_7==23||LA48_7==28||LA48_7==32||(LA48_7 >= 34 && LA48_7 <= 35)||(LA48_7 >= 38 && LA48_7 <= 39)||LA48_7==85||LA48_7==100) ) {
                    alt48=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 7, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;

            }

            switch (alt48) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:307:4: postfix_expression
                    {
                    pushFollow(FOLLOW_postfix_expression_in_unary_expression1140);
                    postfix_expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:308:4: '++' unary_expression
                    {
                    match(input,35,FOLLOW_35_in_unary_expression1145); if (state.failed) return ;

                    pushFollow(FOLLOW_unary_expression_in_unary_expression1147);
                    unary_expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:309:4: '--' unary_expression
                    {
                    match(input,39,FOLLOW_39_in_unary_expression1152); if (state.failed) return ;

                    pushFollow(FOLLOW_unary_expression_in_unary_expression1154);
                    unary_expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:310:4: unary_operator cast_expression
                    {
                    pushFollow(FOLLOW_unary_operator_in_unary_expression1159);
                    unary_operator();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_cast_expression_in_unary_expression1161);
                    cast_expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:311:4: 'sizeof' unary_expression
                    {
                    match(input,85,FOLLOW_85_in_unary_expression1166); if (state.failed) return ;

                    pushFollow(FOLLOW_unary_expression_in_unary_expression1168);
                    unary_expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:312:4: 'sizeof' '(' type_name ')'
                    {
                    match(input,85,FOLLOW_85_in_unary_expression1173); if (state.failed) return ;

                    match(input,30,FOLLOW_30_in_unary_expression1175); if (state.failed) return ;

                    pushFollow(FOLLOW_type_name_in_unary_expression1177);
                    type_name();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,31,FOLLOW_31_in_unary_expression1179); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 40, unary_expression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "unary_expression"



    // $ANTLR start "postfix_expression"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:315:1: postfix_expression : primary_expression ( '[' expression ']' | '(' ')' | '(' argument_expression_list ')' | '.' IDENTIFIER | '->' IDENTIFIER | '++' | '--' )* ;
    public final void postfix_expression() throws RecognitionException {
        int postfix_expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:316:2: ( primary_expression ( '[' expression ']' | '(' ')' | '(' argument_expression_list ')' | '.' IDENTIFIER | '->' IDENTIFIER | '++' | '--' )* )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:316:6: primary_expression ( '[' expression ']' | '(' ')' | '(' argument_expression_list ')' | '.' IDENTIFIER | '->' IDENTIFIER | '++' | '--' )*
            {
            pushFollow(FOLLOW_primary_expression_in_postfix_expression1192);
            primary_expression();

            state._fsp--;
            if (state.failed) return ;

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:317:9: ( '[' expression ']' | '(' ')' | '(' argument_expression_list ')' | '.' IDENTIFIER | '->' IDENTIFIER | '++' | '--' )*
            loop49:
            do {
                int alt49=8;
                switch ( input.LA(1) ) {
                case 59:
                    {
                    alt49=1;
                    }
                    break;
                case 30:
                    {
                    int LA49_24 = input.LA(2);

                    if ( (LA49_24==31) ) {
                        alt49=2;
                    }
                    else if ( (LA49_24==CHARACTER_LITERAL||LA49_24==DECIMAL_LITERAL||LA49_24==FLOATING_POINT_LITERAL||LA49_24==HEX_LITERAL||LA49_24==IDENTIFIER||LA49_24==OCTAL_LITERAL||LA49_24==STRING_LITERAL||LA49_24==23||LA49_24==28||LA49_24==30||LA49_24==32||(LA49_24 >= 34 && LA49_24 <= 35)||(LA49_24 >= 38 && LA49_24 <= 39)||LA49_24==85||LA49_24==100) ) {
                        alt49=3;
                    }


                    }
                    break;
                case 42:
                    {
                    alt49=4;
                    }
                    break;
                case 41:
                    {
                    alt49=5;
                    }
                    break;
                case 35:
                    {
                    alt49=6;
                    }
                    break;
                case 39:
                    {
                    alt49=7;
                    }
                    break;

                }

                switch (alt49) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:317:13: '[' expression ']'
            	    {
            	    match(input,59,FOLLOW_59_in_postfix_expression1206); if (state.failed) return ;

            	    pushFollow(FOLLOW_expression_in_postfix_expression1208);
            	    expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    match(input,60,FOLLOW_60_in_postfix_expression1210); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:318:13: '(' ')'
            	    {
            	    match(input,30,FOLLOW_30_in_postfix_expression1224); if (state.failed) return ;

            	    match(input,31,FOLLOW_31_in_postfix_expression1226); if (state.failed) return ;

            	    }
            	    break;
            	case 3 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:319:13: '(' argument_expression_list ')'
            	    {
            	    match(input,30,FOLLOW_30_in_postfix_expression1240); if (state.failed) return ;

            	    pushFollow(FOLLOW_argument_expression_list_in_postfix_expression1242);
            	    argument_expression_list();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    match(input,31,FOLLOW_31_in_postfix_expression1244); if (state.failed) return ;

            	    }
            	    break;
            	case 4 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:320:13: '.' IDENTIFIER
            	    {
            	    match(input,42,FOLLOW_42_in_postfix_expression1258); if (state.failed) return ;

            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_postfix_expression1260); if (state.failed) return ;

            	    }
            	    break;
            	case 5 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:321:13: '->' IDENTIFIER
            	    {
            	    match(input,41,FOLLOW_41_in_postfix_expression1274); if (state.failed) return ;

            	    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_postfix_expression1276); if (state.failed) return ;

            	    }
            	    break;
            	case 6 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:322:13: '++'
            	    {
            	    match(input,35,FOLLOW_35_in_postfix_expression1290); if (state.failed) return ;

            	    }
            	    break;
            	case 7 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:323:13: '--'
            	    {
            	    match(input,39,FOLLOW_39_in_postfix_expression1304); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 41, postfix_expression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "postfix_expression"



    // $ANTLR start "unary_operator"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:327:1: unary_operator : ( '&' | '*' | '+' | '-' | '~' | '!' );
    public final void unary_operator() throws RecognitionException {
        int unary_operator_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:328:2: ( '&' | '*' | '+' | '-' | '~' | '!' )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:
            {
            if ( input.LA(1)==23||input.LA(1)==28||input.LA(1)==32||input.LA(1)==34||input.LA(1)==38||input.LA(1)==100 ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 42, unary_operator_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "unary_operator"



    // $ANTLR start "primary_expression"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:336:1: primary_expression : ( IDENTIFIER | constant | '(' expression ')' );
    public final void primary_expression() throws RecognitionException {
        int primary_expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:337:2: ( IDENTIFIER | constant | '(' expression ')' )
            int alt50=3;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt50=1;
                }
                break;
            case CHARACTER_LITERAL:
            case DECIMAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case HEX_LITERAL:
            case OCTAL_LITERAL:
            case STRING_LITERAL:
                {
                alt50=2;
                }
                break;
            case 30:
                {
                alt50=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;

            }

            switch (alt50) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:337:4: IDENTIFIER
                    {
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primary_expression1362); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:338:4: constant
                    {
                    pushFollow(FOLLOW_constant_in_primary_expression1367);
                    constant();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:339:4: '(' expression ')'
                    {
                    match(input,30,FOLLOW_30_in_primary_expression1372); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_primary_expression1374);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,31,FOLLOW_31_in_primary_expression1376); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 43, primary_expression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "primary_expression"



    // $ANTLR start "constant"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:342:1: constant : ( HEX_LITERAL | OCTAL_LITERAL | DECIMAL_LITERAL | CHARACTER_LITERAL | STRING_LITERAL | FLOATING_POINT_LITERAL );
    public final void constant() throws RecognitionException {
        int constant_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:343:5: ( HEX_LITERAL | OCTAL_LITERAL | DECIMAL_LITERAL | CHARACTER_LITERAL | STRING_LITERAL | FLOATING_POINT_LITERAL )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:
            {
            if ( input.LA(1)==CHARACTER_LITERAL||input.LA(1)==DECIMAL_LITERAL||input.LA(1)==FLOATING_POINT_LITERAL||input.LA(1)==HEX_LITERAL||input.LA(1)==OCTAL_LITERAL||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 44, constant_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "constant"



    // $ANTLR start "expression"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:353:1: expression : assignment_expression ( ',' assignment_expression )* ;
    public final void expression() throws RecognitionException {
        int expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:354:2: ( assignment_expression ( ',' assignment_expression )* )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:354:4: assignment_expression ( ',' assignment_expression )*
            {
            pushFollow(FOLLOW_assignment_expression_in_expression1451);
            assignment_expression();

            state._fsp--;
            if (state.failed) return ;

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:354:26: ( ',' assignment_expression )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==37) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:354:27: ',' assignment_expression
            	    {
            	    match(input,37,FOLLOW_37_in_expression1454); if (state.failed) return ;

            	    pushFollow(FOLLOW_assignment_expression_in_expression1456);
            	    assignment_expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 45, expression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "expression"



    // $ANTLR start "constant_expression"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:357:1: constant_expression : conditional_expression ;
    public final void constant_expression() throws RecognitionException {
        int constant_expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:358:2: ( conditional_expression )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:358:4: conditional_expression
            {
            pushFollow(FOLLOW_conditional_expression_in_constant_expression1469);
            conditional_expression();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 46, constant_expression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "constant_expression"



    // $ANTLR start "assignment_expression"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:361:1: assignment_expression : ( lvalue assignment_operator assignment_expression | conditional_expression );
    public final void assignment_expression() throws RecognitionException {
        int assignment_expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:362:2: ( lvalue assignment_operator assignment_expression | conditional_expression )
            int alt52=2;
            alt52 = dfa52.predict(input);
            switch (alt52) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:362:4: lvalue assignment_operator assignment_expression
                    {
                    pushFollow(FOLLOW_lvalue_in_assignment_expression1480);
                    lvalue();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_assignment_operator_in_assignment_expression1482);
                    assignment_operator();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_assignment_expression_in_assignment_expression1484);
                    assignment_expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:363:4: conditional_expression
                    {
                    pushFollow(FOLLOW_conditional_expression_in_assignment_expression1489);
                    conditional_expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 47, assignment_expression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "assignment_expression"



    // $ANTLR start "lvalue"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:366:1: lvalue : unary_expression ;
    public final void lvalue() throws RecognitionException {
        int lvalue_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:367:2: ( unary_expression )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:367:4: unary_expression
            {
            pushFollow(FOLLOW_unary_expression_in_lvalue1501);
            unary_expression();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 48, lvalue_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "lvalue"



    // $ANTLR start "assignment_operator"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:370:1: assignment_operator : ( '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|=' );
    public final void assignment_operator() throws RecognitionException {
        int assignment_operator_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:371:2: ( '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|=' )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:
            {
            if ( input.LA(1)==26||input.LA(1)==29||input.LA(1)==33||input.LA(1)==36||input.LA(1)==40||input.LA(1)==45||input.LA(1)==50||input.LA(1)==52||input.LA(1)==57||input.LA(1)==62||input.LA(1)==97 ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 49, assignment_operator_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "assignment_operator"



    // $ANTLR start "conditional_expression"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:384:1: conditional_expression : logical_or_expression ( '?' expression ':' conditional_expression )? ;
    public final void conditional_expression() throws RecognitionException {
        int conditional_expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:385:2: ( logical_or_expression ( '?' expression ':' conditional_expression )? )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:385:4: logical_or_expression ( '?' expression ':' conditional_expression )?
            {
            pushFollow(FOLLOW_logical_or_expression_in_conditional_expression1573);
            logical_or_expression();

            state._fsp--;
            if (state.failed) return ;

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:385:26: ( '?' expression ':' conditional_expression )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==58) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:385:27: '?' expression ':' conditional_expression
                    {
                    match(input,58,FOLLOW_58_in_conditional_expression1576); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_conditional_expression1578);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,46,FOLLOW_46_in_conditional_expression1580); if (state.failed) return ;

                    pushFollow(FOLLOW_conditional_expression_in_conditional_expression1582);
                    conditional_expression();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 50, conditional_expression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "conditional_expression"



    // $ANTLR start "logical_or_expression"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:388:1: logical_or_expression : logical_and_expression ( '||' logical_and_expression )* ;
    public final void logical_or_expression() throws RecognitionException {
        int logical_or_expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:389:2: ( logical_and_expression ( '||' logical_and_expression )* )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:389:4: logical_and_expression ( '||' logical_and_expression )*
            {
            pushFollow(FOLLOW_logical_and_expression_in_logical_or_expression1595);
            logical_and_expression();

            state._fsp--;
            if (state.failed) return ;

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:389:27: ( '||' logical_and_expression )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==98) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:389:28: '||' logical_and_expression
            	    {
            	    match(input,98,FOLLOW_98_in_logical_or_expression1598); if (state.failed) return ;

            	    pushFollow(FOLLOW_logical_and_expression_in_logical_or_expression1600);
            	    logical_and_expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 51, logical_or_expression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "logical_or_expression"



    // $ANTLR start "logical_and_expression"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:392:1: logical_and_expression : inclusive_or_expression ( '&&' inclusive_or_expression )* ;
    public final void logical_and_expression() throws RecognitionException {
        int logical_and_expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:393:2: ( inclusive_or_expression ( '&&' inclusive_or_expression )* )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:393:4: inclusive_or_expression ( '&&' inclusive_or_expression )*
            {
            pushFollow(FOLLOW_inclusive_or_expression_in_logical_and_expression1613);
            inclusive_or_expression();

            state._fsp--;
            if (state.failed) return ;

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:393:28: ( '&&' inclusive_or_expression )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==27) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:393:29: '&&' inclusive_or_expression
            	    {
            	    match(input,27,FOLLOW_27_in_logical_and_expression1616); if (state.failed) return ;

            	    pushFollow(FOLLOW_inclusive_or_expression_in_logical_and_expression1618);
            	    inclusive_or_expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 52, logical_and_expression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "logical_and_expression"



    // $ANTLR start "inclusive_or_expression"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:396:1: inclusive_or_expression : exclusive_or_expression ( '|' exclusive_or_expression )* ;
    public final void inclusive_or_expression() throws RecognitionException {
        int inclusive_or_expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:397:2: ( exclusive_or_expression ( '|' exclusive_or_expression )* )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:397:4: exclusive_or_expression ( '|' exclusive_or_expression )*
            {
            pushFollow(FOLLOW_exclusive_or_expression_in_inclusive_or_expression1631);
            exclusive_or_expression();

            state._fsp--;
            if (state.failed) return ;

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:397:28: ( '|' exclusive_or_expression )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==96) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:397:29: '|' exclusive_or_expression
            	    {
            	    match(input,96,FOLLOW_96_in_inclusive_or_expression1634); if (state.failed) return ;

            	    pushFollow(FOLLOW_exclusive_or_expression_in_inclusive_or_expression1636);
            	    exclusive_or_expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 53, inclusive_or_expression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "inclusive_or_expression"



    // $ANTLR start "exclusive_or_expression"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:400:1: exclusive_or_expression : and_expression ( '^' and_expression )* ;
    public final void exclusive_or_expression() throws RecognitionException {
        int exclusive_or_expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:401:2: ( and_expression ( '^' and_expression )* )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:401:4: and_expression ( '^' and_expression )*
            {
            pushFollow(FOLLOW_and_expression_in_exclusive_or_expression1649);
            and_expression();

            state._fsp--;
            if (state.failed) return ;

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:401:19: ( '^' and_expression )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==61) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:401:20: '^' and_expression
            	    {
            	    match(input,61,FOLLOW_61_in_exclusive_or_expression1652); if (state.failed) return ;

            	    pushFollow(FOLLOW_and_expression_in_exclusive_or_expression1654);
            	    and_expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 54, exclusive_or_expression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "exclusive_or_expression"



    // $ANTLR start "and_expression"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:404:1: and_expression : equality_expression ( '&' equality_expression )* ;
    public final void and_expression() throws RecognitionException {
        int and_expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:405:2: ( equality_expression ( '&' equality_expression )* )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:405:4: equality_expression ( '&' equality_expression )*
            {
            pushFollow(FOLLOW_equality_expression_in_and_expression1667);
            equality_expression();

            state._fsp--;
            if (state.failed) return ;

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:405:24: ( '&' equality_expression )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==28) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:405:25: '&' equality_expression
            	    {
            	    match(input,28,FOLLOW_28_in_and_expression1670); if (state.failed) return ;

            	    pushFollow(FOLLOW_equality_expression_in_and_expression1672);
            	    equality_expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 55, and_expression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "and_expression"



    // $ANTLR start "equality_expression"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:407:1: equality_expression : relational_expression ( ( '==' | '!=' ) relational_expression )* ;
    public final void equality_expression() throws RecognitionException {
        int equality_expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:408:2: ( relational_expression ( ( '==' | '!=' ) relational_expression )* )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:408:4: relational_expression ( ( '==' | '!=' ) relational_expression )*
            {
            pushFollow(FOLLOW_relational_expression_in_equality_expression1684);
            relational_expression();

            state._fsp--;
            if (state.failed) return ;

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:408:26: ( ( '==' | '!=' ) relational_expression )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==24||LA59_0==53) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:408:27: ( '==' | '!=' ) relational_expression
            	    {
            	    if ( input.LA(1)==24||input.LA(1)==53 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_relational_expression_in_equality_expression1693);
            	    relational_expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 56, equality_expression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "equality_expression"



    // $ANTLR start "relational_expression"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:411:1: relational_expression : shift_expression ( ( '<' | '>' | '<=' | '>=' ) shift_expression )* ;
    public final void relational_expression() throws RecognitionException {
        int relational_expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:412:2: ( shift_expression ( ( '<' | '>' | '<=' | '>=' ) shift_expression )* )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:412:4: shift_expression ( ( '<' | '>' | '<=' | '>=' ) shift_expression )*
            {
            pushFollow(FOLLOW_shift_expression_in_relational_expression1706);
            shift_expression();

            state._fsp--;
            if (state.failed) return ;

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:412:21: ( ( '<' | '>' | '<=' | '>=' ) shift_expression )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==48||LA60_0==51||(LA60_0 >= 54 && LA60_0 <= 55)) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:412:22: ( '<' | '>' | '<=' | '>=' ) shift_expression
            	    {
            	    if ( input.LA(1)==48||input.LA(1)==51||(input.LA(1) >= 54 && input.LA(1) <= 55) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_shift_expression_in_relational_expression1719);
            	    shift_expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 57, relational_expression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "relational_expression"



    // $ANTLR start "shift_expression"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:415:1: shift_expression : additive_expression ( ( '<<' | '>>' ) additive_expression )* ;
    public final void shift_expression() throws RecognitionException {
        int shift_expression_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:416:2: ( additive_expression ( ( '<<' | '>>' ) additive_expression )* )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:416:4: additive_expression ( ( '<<' | '>>' ) additive_expression )*
            {
            pushFollow(FOLLOW_additive_expression_in_shift_expression1732);
            additive_expression();

            state._fsp--;
            if (state.failed) return ;

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:416:24: ( ( '<<' | '>>' ) additive_expression )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==49||LA61_0==56) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:416:25: ( '<<' | '>>' ) additive_expression
            	    {
            	    if ( input.LA(1)==49||input.LA(1)==56 ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_additive_expression_in_shift_expression1741);
            	    additive_expression();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 58, shift_expression_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "shift_expression"



    // $ANTLR start "statement"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:421:1: statement : ( labeled_statement | compound_statement | expression_statement | selection_statement | iteration_statement | jump_statement );
    public final void statement() throws RecognitionException {
        int statement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:422:2: ( labeled_statement | compound_statement | expression_statement | selection_statement | iteration_statement | jump_statement )
            int alt62=6;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                int LA62_1 = input.LA(2);

                if ( (LA62_1==46) ) {
                    alt62=1;
                }
                else if ( ((LA62_1 >= 24 && LA62_1 <= 30)||(LA62_1 >= 32 && LA62_1 <= 42)||(LA62_1 >= 44 && LA62_1 <= 45)||(LA62_1 >= 47 && LA62_1 <= 59)||(LA62_1 >= 61 && LA62_1 <= 62)||(LA62_1 >= 96 && LA62_1 <= 98)) ) {
                    alt62=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 62, 1, input);

                    throw nvae;

                }
                }
                break;
            case 65:
            case 69:
                {
                alt62=1;
                }
                break;
            case 95:
                {
                alt62=2;
                }
                break;
            case CHARACTER_LITERAL:
            case DECIMAL_LITERAL:
            case FLOATING_POINT_LITERAL:
            case HEX_LITERAL:
            case OCTAL_LITERAL:
            case STRING_LITERAL:
            case 23:
            case 28:
            case 30:
            case 32:
            case 34:
            case 35:
            case 38:
            case 39:
            case 47:
            case 85:
            case 100:
                {
                alt62=3;
                }
                break;
            case 78:
            case 88:
                {
                alt62=4;
                }
                break;
            case 70:
            case 76:
            case 94:
                {
                alt62=5;
                }
                break;
            case 64:
            case 68:
            case 77:
            case 82:
                {
                alt62=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;

            }

            switch (alt62) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:422:4: labeled_statement
                    {
                    pushFollow(FOLLOW_labeled_statement_in_statement1756);
                    labeled_statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:423:4: compound_statement
                    {
                    pushFollow(FOLLOW_compound_statement_in_statement1761);
                    compound_statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:424:4: expression_statement
                    {
                    pushFollow(FOLLOW_expression_statement_in_statement1766);
                    expression_statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:425:4: selection_statement
                    {
                    pushFollow(FOLLOW_selection_statement_in_statement1771);
                    selection_statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:426:4: iteration_statement
                    {
                    pushFollow(FOLLOW_iteration_statement_in_statement1776);
                    iteration_statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:427:4: jump_statement
                    {
                    pushFollow(FOLLOW_jump_statement_in_statement1781);
                    jump_statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 59, statement_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "statement"



    // $ANTLR start "labeled_statement"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:430:1: labeled_statement : ( IDENTIFIER ':' statement | 'case' constant_expression ':' statement | 'default' ':' statement );
    public final void labeled_statement() throws RecognitionException {
        int labeled_statement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:431:2: ( IDENTIFIER ':' statement | 'case' constant_expression ':' statement | 'default' ':' statement )
            int alt63=3;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt63=1;
                }
                break;
            case 65:
                {
                alt63=2;
                }
                break;
            case 69:
                {
                alt63=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;

            }

            switch (alt63) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:431:4: IDENTIFIER ':' statement
                    {
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_labeled_statement1792); if (state.failed) return ;

                    match(input,46,FOLLOW_46_in_labeled_statement1794); if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_labeled_statement1796);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:432:4: 'case' constant_expression ':' statement
                    {
                    match(input,65,FOLLOW_65_in_labeled_statement1801); if (state.failed) return ;

                    pushFollow(FOLLOW_constant_expression_in_labeled_statement1803);
                    constant_expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,46,FOLLOW_46_in_labeled_statement1805); if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_labeled_statement1807);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:433:4: 'default' ':' statement
                    {
                    match(input,69,FOLLOW_69_in_labeled_statement1812); if (state.failed) return ;

                    match(input,46,FOLLOW_46_in_labeled_statement1814); if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_labeled_statement1816);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 60, labeled_statement_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "labeled_statement"



    // $ANTLR start "compound_statement"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:436:1: compound_statement : '{' ( declaration )* ( statement_list )? '}' ;
    public final void compound_statement() throws RecognitionException {
        Symbols_stack.push(new Symbols_scope());

        int compound_statement_StartIndex = input.index();


          ((Symbols_scope)Symbols_stack.peek()).types = new HashSet();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:441:2: ( '{' ( declaration )* ( statement_list )? '}' )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:441:4: '{' ( declaration )* ( statement_list )? '}'
            {
            match(input,95,FOLLOW_95_in_compound_statement1838); if (state.failed) return ;

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:441:8: ( declaration )*
            loop64:
            do {
                int alt64=2;
                alt64 = dfa64.predict(input);
                switch (alt64) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:441:8: declaration
            	    {
            	    pushFollow(FOLLOW_declaration_in_compound_statement1840);
            	    declaration();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);


            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:441:21: ( statement_list )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==CHARACTER_LITERAL||LA65_0==DECIMAL_LITERAL||LA65_0==FLOATING_POINT_LITERAL||LA65_0==HEX_LITERAL||LA65_0==IDENTIFIER||LA65_0==OCTAL_LITERAL||LA65_0==STRING_LITERAL||LA65_0==23||LA65_0==28||LA65_0==30||LA65_0==32||(LA65_0 >= 34 && LA65_0 <= 35)||(LA65_0 >= 38 && LA65_0 <= 39)||LA65_0==47||(LA65_0 >= 64 && LA65_0 <= 65)||(LA65_0 >= 68 && LA65_0 <= 70)||(LA65_0 >= 76 && LA65_0 <= 78)||LA65_0==82||LA65_0==85||LA65_0==88||(LA65_0 >= 94 && LA65_0 <= 95)||LA65_0==100) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:441:21: statement_list
                    {
                    pushFollow(FOLLOW_statement_list_in_compound_statement1843);
                    statement_list();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            match(input,99,FOLLOW_99_in_compound_statement1846); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 61, compound_statement_StartIndex); }

            Symbols_stack.pop();

        }
        return ;
    }
    // $ANTLR end "compound_statement"



    // $ANTLR start "statement_list"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:444:1: statement_list : ( statement )+ ;
    public final void statement_list() throws RecognitionException {
        int statement_list_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:445:2: ( ( statement )+ )
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:445:4: ( statement )+
            {
            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:445:4: ( statement )+
            int cnt66=0;
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==CHARACTER_LITERAL||LA66_0==DECIMAL_LITERAL||LA66_0==FLOATING_POINT_LITERAL||LA66_0==HEX_LITERAL||LA66_0==IDENTIFIER||LA66_0==OCTAL_LITERAL||LA66_0==STRING_LITERAL||LA66_0==23||LA66_0==28||LA66_0==30||LA66_0==32||(LA66_0 >= 34 && LA66_0 <= 35)||(LA66_0 >= 38 && LA66_0 <= 39)||LA66_0==47||(LA66_0 >= 64 && LA66_0 <= 65)||(LA66_0 >= 68 && LA66_0 <= 70)||(LA66_0 >= 76 && LA66_0 <= 78)||LA66_0==82||LA66_0==85||LA66_0==88||(LA66_0 >= 94 && LA66_0 <= 95)||LA66_0==100) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:445:4: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_statement_list1857);
            	    statement();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt66 >= 1 ) break loop66;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(66, input);
                        throw eee;
                }
                cnt66++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 62, statement_list_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "statement_list"



    // $ANTLR start "expression_statement"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:448:1: expression_statement : ( ';' | expression ';' );
    public final void expression_statement() throws RecognitionException {
        int expression_statement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:449:2: ( ';' | expression ';' )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==47) ) {
                alt67=1;
            }
            else if ( (LA67_0==CHARACTER_LITERAL||LA67_0==DECIMAL_LITERAL||LA67_0==FLOATING_POINT_LITERAL||LA67_0==HEX_LITERAL||LA67_0==IDENTIFIER||LA67_0==OCTAL_LITERAL||LA67_0==STRING_LITERAL||LA67_0==23||LA67_0==28||LA67_0==30||LA67_0==32||(LA67_0 >= 34 && LA67_0 <= 35)||(LA67_0 >= 38 && LA67_0 <= 39)||LA67_0==85||LA67_0==100) ) {
                alt67=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;

            }
            switch (alt67) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:449:4: ';'
                    {
                    match(input,47,FOLLOW_47_in_expression_statement1869); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:450:4: expression ';'
                    {
                    pushFollow(FOLLOW_expression_in_expression_statement1874);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,47,FOLLOW_47_in_expression_statement1876); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 63, expression_statement_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "expression_statement"



    // $ANTLR start "selection_statement"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:453:1: selection_statement : ( 'if' '(' expression ')' statement ( options {k=1; backtrack=false; } : 'else' statement )? | 'switch' '(' expression ')' statement );
    public final void selection_statement() throws RecognitionException {
        int selection_statement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:454:2: ( 'if' '(' expression ')' statement ( options {k=1; backtrack=false; } : 'else' statement )? | 'switch' '(' expression ')' statement )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==78) ) {
                alt69=1;
            }
            else if ( (LA69_0==88) ) {
                alt69=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;

            }
            switch (alt69) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:454:4: 'if' '(' expression ')' statement ( options {k=1; backtrack=false; } : 'else' statement )?
                    {
                    match(input,78,FOLLOW_78_in_selection_statement1887); if (state.failed) return ;

                    match(input,30,FOLLOW_30_in_selection_statement1889); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_selection_statement1891);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,31,FOLLOW_31_in_selection_statement1893); if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_selection_statement1895);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:454:38: ( options {k=1; backtrack=false; } : 'else' statement )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==72) ) {
                        int LA68_1 = input.LA(2);

                        if ( (true) ) {
                            alt68=1;
                        }
                    }
                    switch (alt68) {
                        case 1 :
                            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:454:71: 'else' statement
                            {
                            match(input,72,FOLLOW_72_in_selection_statement1910); if (state.failed) return ;

                            pushFollow(FOLLOW_statement_in_selection_statement1912);
                            statement();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:455:4: 'switch' '(' expression ')' statement
                    {
                    match(input,88,FOLLOW_88_in_selection_statement1919); if (state.failed) return ;

                    match(input,30,FOLLOW_30_in_selection_statement1921); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_selection_statement1923);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,31,FOLLOW_31_in_selection_statement1925); if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_selection_statement1927);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 64, selection_statement_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "selection_statement"



    // $ANTLR start "iteration_statement"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:458:1: iteration_statement : ( 'while' '(' expression ')' statement | 'do' statement 'while' '(' expression ')' ';' | 'for' '(' expression_statement expression_statement ( expression )? ')' statement );
    public final void iteration_statement() throws RecognitionException {
        int iteration_statement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:459:2: ( 'while' '(' expression ')' statement | 'do' statement 'while' '(' expression ')' ';' | 'for' '(' expression_statement expression_statement ( expression )? ')' statement )
            int alt71=3;
            switch ( input.LA(1) ) {
            case 94:
                {
                alt71=1;
                }
                break;
            case 70:
                {
                alt71=2;
                }
                break;
            case 76:
                {
                alt71=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;

            }

            switch (alt71) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:459:4: 'while' '(' expression ')' statement
                    {
                    match(input,94,FOLLOW_94_in_iteration_statement1938); if (state.failed) return ;

                    match(input,30,FOLLOW_30_in_iteration_statement1940); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_iteration_statement1942);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,31,FOLLOW_31_in_iteration_statement1944); if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_iteration_statement1946);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:460:4: 'do' statement 'while' '(' expression ')' ';'
                    {
                    match(input,70,FOLLOW_70_in_iteration_statement1951); if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_iteration_statement1953);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,94,FOLLOW_94_in_iteration_statement1955); if (state.failed) return ;

                    match(input,30,FOLLOW_30_in_iteration_statement1957); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_iteration_statement1959);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,31,FOLLOW_31_in_iteration_statement1961); if (state.failed) return ;

                    match(input,47,FOLLOW_47_in_iteration_statement1963); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:461:4: 'for' '(' expression_statement expression_statement ( expression )? ')' statement
                    {
                    match(input,76,FOLLOW_76_in_iteration_statement1968); if (state.failed) return ;

                    match(input,30,FOLLOW_30_in_iteration_statement1970); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_statement_in_iteration_statement1972);
                    expression_statement();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_expression_statement_in_iteration_statement1974);
                    expression_statement();

                    state._fsp--;
                    if (state.failed) return ;

                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:461:56: ( expression )?
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( (LA70_0==CHARACTER_LITERAL||LA70_0==DECIMAL_LITERAL||LA70_0==FLOATING_POINT_LITERAL||LA70_0==HEX_LITERAL||LA70_0==IDENTIFIER||LA70_0==OCTAL_LITERAL||LA70_0==STRING_LITERAL||LA70_0==23||LA70_0==28||LA70_0==30||LA70_0==32||(LA70_0 >= 34 && LA70_0 <= 35)||(LA70_0 >= 38 && LA70_0 <= 39)||LA70_0==85||LA70_0==100) ) {
                        alt70=1;
                    }
                    switch (alt70) {
                        case 1 :
                            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:461:56: expression
                            {
                            pushFollow(FOLLOW_expression_in_iteration_statement1976);
                            expression();

                            state._fsp--;
                            if (state.failed) return ;

                            }
                            break;

                    }


                    match(input,31,FOLLOW_31_in_iteration_statement1979); if (state.failed) return ;

                    pushFollow(FOLLOW_statement_in_iteration_statement1981);
                    statement();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 65, iteration_statement_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "iteration_statement"



    // $ANTLR start "jump_statement"
    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:464:1: jump_statement : ( 'goto' IDENTIFIER ';' | 'continue' ';' | 'break' ';' | 'return' ';' | 'return' expression ';' );
    public final void jump_statement() throws RecognitionException {
        int jump_statement_StartIndex = input.index();

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return ; }

            // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:465:2: ( 'goto' IDENTIFIER ';' | 'continue' ';' | 'break' ';' | 'return' ';' | 'return' expression ';' )
            int alt72=5;
            switch ( input.LA(1) ) {
            case 77:
                {
                alt72=1;
                }
                break;
            case 68:
                {
                alt72=2;
                }
                break;
            case 64:
                {
                alt72=3;
                }
                break;
            case 82:
                {
                int LA72_4 = input.LA(2);

                if ( (LA72_4==47) ) {
                    alt72=4;
                }
                else if ( (LA72_4==CHARACTER_LITERAL||LA72_4==DECIMAL_LITERAL||LA72_4==FLOATING_POINT_LITERAL||LA72_4==HEX_LITERAL||LA72_4==IDENTIFIER||LA72_4==OCTAL_LITERAL||LA72_4==STRING_LITERAL||LA72_4==23||LA72_4==28||LA72_4==30||LA72_4==32||(LA72_4 >= 34 && LA72_4 <= 35)||(LA72_4 >= 38 && LA72_4 <= 39)||LA72_4==85||LA72_4==100) ) {
                    alt72=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 72, 4, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;

            }

            switch (alt72) {
                case 1 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:465:4: 'goto' IDENTIFIER ';'
                    {
                    match(input,77,FOLLOW_77_in_jump_statement1992); if (state.failed) return ;

                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_jump_statement1994); if (state.failed) return ;

                    match(input,47,FOLLOW_47_in_jump_statement1996); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:466:4: 'continue' ';'
                    {
                    match(input,68,FOLLOW_68_in_jump_statement2001); if (state.failed) return ;

                    match(input,47,FOLLOW_47_in_jump_statement2003); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:467:4: 'break' ';'
                    {
                    match(input,64,FOLLOW_64_in_jump_statement2008); if (state.failed) return ;

                    match(input,47,FOLLOW_47_in_jump_statement2010); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:468:4: 'return' ';'
                    {
                    match(input,82,FOLLOW_82_in_jump_statement2015); if (state.failed) return ;

                    match(input,47,FOLLOW_47_in_jump_statement2017); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:469:4: 'return' expression ';'
                    {
                    match(input,82,FOLLOW_82_in_jump_statement2022); if (state.failed) return ;

                    pushFollow(FOLLOW_expression_in_jump_statement2024);
                    expression();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input,47,FOLLOW_47_in_jump_statement2026); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 66, jump_statement_StartIndex); }

        }
        return ;
    }
    // $ANTLR end "jump_statement"

    // $ANTLR start synpred2_C
    public final void synpred2_C_fragment() throws RecognitionException {
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:85:6: ( declaration_specifiers )
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:85:6: declaration_specifiers
        {
        pushFollow(FOLLOW_declaration_specifiers_in_synpred2_C97);
        declaration_specifiers();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred2_C

    // $ANTLR start synpred4_C
    public final void synpred4_C_fragment() throws RecognitionException {
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:85:4: ( ( declaration_specifiers )? declarator ( declaration )* '{' )
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:85:6: ( declaration_specifiers )? declarator ( declaration )* '{'
        {
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:85:6: ( declaration_specifiers )?
        int alt73=2;
        int LA73_0 = input.LA(1);

        if ( (LA73_0==63||(LA73_0 >= 66 && LA73_0 <= 67)||LA73_0==71||(LA73_0 >= 73 && LA73_0 <= 75)||(LA73_0 >= 79 && LA73_0 <= 81)||(LA73_0 >= 83 && LA73_0 <= 84)||(LA73_0 >= 86 && LA73_0 <= 87)||(LA73_0 >= 90 && LA73_0 <= 93)) ) {
            alt73=1;
        }
        else if ( (LA73_0==IDENTIFIER) ) {
            switch ( input.LA(2) ) {
                case 32:
                    {
                    alt73=1;
                    }
                    break;
                case IDENTIFIER:
                    {
                    int LA73_18 = input.LA(3);

                    if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred2_C())) ) {
                        alt73=1;
                    }
                    }
                    break;
                case 30:
                    {
                    int LA73_19 = input.LA(3);

                    if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred2_C())) ) {
                        alt73=1;
                    }
                    }
                    break;
                case 63:
                case 74:
                case 81:
                case 86:
                    {
                    int LA73_20 = input.LA(3);

                    if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred2_C())) ) {
                        alt73=1;
                    }
                    }
                    break;
                case 92:
                    {
                    int LA73_21 = input.LA(3);

                    if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred2_C())) ) {
                        alt73=1;
                    }
                    }
                    break;
                case 66:
                    {
                    int LA73_22 = input.LA(3);

                    if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred2_C())) ) {
                        alt73=1;
                    }
                    }
                    break;
                case 83:
                    {
                    int LA73_23 = input.LA(3);

                    if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred2_C())) ) {
                        alt73=1;
                    }
                    }
                    break;
                case 79:
                    {
                    int LA73_24 = input.LA(3);

                    if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred2_C())) ) {
                        alt73=1;
                    }
                    }
                    break;
                case 80:
                    {
                    int LA73_25 = input.LA(3);

                    if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred2_C())) ) {
                        alt73=1;
                    }
                    }
                    break;
                case 75:
                    {
                    int LA73_26 = input.LA(3);

                    if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred2_C())) ) {
                        alt73=1;
                    }
                    }
                    break;
                case 71:
                    {
                    int LA73_27 = input.LA(3);

                    if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred2_C())) ) {
                        alt73=1;
                    }
                    }
                    break;
                case 84:
                    {
                    int LA73_28 = input.LA(3);

                    if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred2_C())) ) {
                        alt73=1;
                    }
                    }
                    break;
                case 91:
                    {
                    int LA73_29 = input.LA(3);

                    if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred2_C())) ) {
                        alt73=1;
                    }
                    }
                    break;
                case 87:
                case 90:
                    {
                    int LA73_30 = input.LA(3);

                    if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred2_C())) ) {
                        alt73=1;
                    }
                    }
                    break;
                case 73:
                    {
                    int LA73_31 = input.LA(3);

                    if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred2_C())) ) {
                        alt73=1;
                    }
                    }
                    break;
                case 67:
                case 93:
                    {
                    int LA73_32 = input.LA(3);

                    if ( ((((isTypeName(input.LT(1).getText()))&&(isTypeName(input.LT(1).getText())))&&synpred2_C())) ) {
                        alt73=1;
                    }
                    }
                    break;
            }

        }
        switch (alt73) {
            case 1 :
                // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:85:6: declaration_specifiers
                {
                pushFollow(FOLLOW_declaration_specifiers_in_synpred4_C97);
                declaration_specifiers();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_declarator_in_synpred4_C100);
        declarator();

        state._fsp--;
        if (state.failed) return ;

        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:85:41: ( declaration )*
        loop74:
        do {
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==IDENTIFIER||LA74_0==63||(LA74_0 >= 66 && LA74_0 <= 67)||LA74_0==71||(LA74_0 >= 73 && LA74_0 <= 75)||(LA74_0 >= 79 && LA74_0 <= 81)||(LA74_0 >= 83 && LA74_0 <= 84)||(LA74_0 >= 86 && LA74_0 <= 87)||(LA74_0 >= 89 && LA74_0 <= 93)) ) {
                alt74=1;
            }


            switch (alt74) {
        	case 1 :
        	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:85:41: declaration
        	    {
        	    pushFollow(FOLLOW_declaration_in_synpred4_C102);
        	    declaration();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop74;
            }
        } while (true);


        match(input,95,FOLLOW_95_in_synpred4_C105); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred4_C

    // $ANTLR start synpred5_C
    public final void synpred5_C_fragment() throws RecognitionException {
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:94:4: ( declaration_specifiers )
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:94:4: declaration_specifiers
        {
        pushFollow(FOLLOW_declaration_specifiers_in_synpred5_C137);
        declaration_specifiers();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred5_C

    // $ANTLR start synpred8_C
    public final void synpred8_C_fragment() throws RecognitionException {
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:107:14: ( declaration_specifiers )
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:107:14: declaration_specifiers
        {
        pushFollow(FOLLOW_declaration_specifiers_in_synpred8_C186);
        declaration_specifiers();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred8_C

    // $ANTLR start synpred12_C
    public final void synpred12_C_fragment() throws RecognitionException {
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:114:7: ( type_specifier )
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:114:7: type_specifier
        {
        pushFollow(FOLLOW_type_specifier_in_synpred12_C232);
        type_specifier();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred12_C

    // $ANTLR start synpred35_C
    public final void synpred35_C_fragment() throws RecognitionException {
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:178:23: ( type_specifier )
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:178:23: type_specifier
        {
        pushFollow(FOLLOW_type_specifier_in_synpred35_C512);
        type_specifier();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred35_C

    // $ANTLR start synpred45_C
    public final void synpred45_C_fragment() throws RecognitionException {
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:211:4: ( ( pointer )? direct_declarator )
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:211:4: ( pointer )? direct_declarator
        {
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:211:4: ( pointer )?
        int alt79=2;
        int LA79_0 = input.LA(1);

        if ( (LA79_0==32) ) {
            alt79=1;
        }
        switch (alt79) {
            case 1 :
                // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:211:4: pointer
                {
                pushFollow(FOLLOW_pointer_in_synpred45_C665);
                pointer();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        pushFollow(FOLLOW_direct_declarator_in_synpred45_C668);
        direct_declarator();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred45_C

    // $ANTLR start synpred47_C
    public final void synpred47_C_fragment() throws RecognitionException {
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:225:9: ( declarator_suffix )
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:225:9: declarator_suffix
        {
        pushFollow(FOLLOW_declarator_suffix_in_synpred47_C717);
        declarator_suffix();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred47_C

    // $ANTLR start synpred50_C
    public final void synpred50_C_fragment() throws RecognitionException {
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:231:9: ( '(' parameter_type_list ')' )
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:231:9: '(' parameter_type_list ')'
        {
        match(input,30,FOLLOW_30_in_synpred50_C757); if (state.failed) return ;

        pushFollow(FOLLOW_parameter_type_list_in_synpred50_C759);
        parameter_type_list();

        state._fsp--;
        if (state.failed) return ;

        match(input,31,FOLLOW_31_in_synpred50_C761); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred50_C

    // $ANTLR start synpred51_C
    public final void synpred51_C_fragment() throws RecognitionException {
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:232:9: ( '(' identifier_list ')' )
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:232:9: '(' identifier_list ')'
        {
        match(input,30,FOLLOW_30_in_synpred51_C771); if (state.failed) return ;

        pushFollow(FOLLOW_identifier_list_in_synpred51_C773);
        identifier_list();

        state._fsp--;
        if (state.failed) return ;

        match(input,31,FOLLOW_31_in_synpred51_C775); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred51_C

    // $ANTLR start synpred52_C
    public final void synpred52_C_fragment() throws RecognitionException {
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:237:8: ( type_qualifier )
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:237:8: type_qualifier
        {
        pushFollow(FOLLOW_type_qualifier_in_synpred52_C800);
        type_qualifier();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred52_C

    // $ANTLR start synpred53_C
    public final void synpred53_C_fragment() throws RecognitionException {
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:237:24: ( pointer )
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:237:24: pointer
        {
        pushFollow(FOLLOW_pointer_in_synpred53_C803);
        pointer();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred53_C

    // $ANTLR start synpred54_C
    public final void synpred54_C_fragment() throws RecognitionException {
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:237:4: ( '*' ( type_qualifier )+ ( pointer )? )
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:237:4: '*' ( type_qualifier )+ ( pointer )?
        {
        match(input,32,FOLLOW_32_in_synpred54_C798); if (state.failed) return ;

        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:237:8: ( type_qualifier )+
        int cnt80=0;
        loop80:
        do {
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==67||LA80_0==93) ) {
                alt80=1;
            }


            switch (alt80) {
        	case 1 :
        	    // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:237:8: type_qualifier
        	    {
        	    pushFollow(FOLLOW_type_qualifier_in_synpred54_C800);
        	    type_qualifier();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt80 >= 1 ) break loop80;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(80, input);
                    throw eee;
            }
            cnt80++;
        } while (true);


        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:237:24: ( pointer )?
        int alt81=2;
        int LA81_0 = input.LA(1);

        if ( (LA81_0==32) ) {
            alt81=1;
        }
        switch (alt81) {
            case 1 :
                // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:237:24: pointer
                {
                pushFollow(FOLLOW_pointer_in_synpred54_C803);
                pointer();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }

    }
    // $ANTLR end synpred54_C

    // $ANTLR start synpred55_C
    public final void synpred55_C_fragment() throws RecognitionException {
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:238:4: ( '*' pointer )
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:238:4: '*' pointer
        {
        match(input,32,FOLLOW_32_in_synpred55_C809); if (state.failed) return ;

        pushFollow(FOLLOW_pointer_in_synpred55_C811);
        pointer();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred55_C

    // $ANTLR start synpred58_C
    public final void synpred58_C_fragment() throws RecognitionException {
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:251:28: ( declarator )
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:251:28: declarator
        {
        pushFollow(FOLLOW_declarator_in_synpred58_C866);
        declarator();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred58_C

    // $ANTLR start synpred59_C
    public final void synpred59_C_fragment() throws RecognitionException {
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:251:39: ( abstract_declarator )
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:251:39: abstract_declarator
        {
        pushFollow(FOLLOW_abstract_declarator_in_synpred59_C868);
        abstract_declarator();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred59_C

    // $ANTLR start synpred62_C
    public final void synpred62_C_fragment() throws RecognitionException {
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:263:12: ( direct_abstract_declarator )
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:263:12: direct_abstract_declarator
        {
        pushFollow(FOLLOW_direct_abstract_declarator_in_synpred62_C915);
        direct_abstract_declarator();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred62_C

    // $ANTLR start synpred65_C
    public final void synpred65_C_fragment() throws RecognitionException {
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:268:65: ( abstract_declarator_suffix )
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:268:65: abstract_declarator_suffix
        {
        pushFollow(FOLLOW_abstract_declarator_suffix_in_synpred65_C946);
        abstract_declarator_suffix();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred65_C

    // $ANTLR start synpred78_C
    public final void synpred78_C_fragment() throws RecognitionException {
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:302:4: ( '(' type_name ')' cast_expression )
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:302:4: '(' type_name ')' cast_expression
        {
        match(input,30,FOLLOW_30_in_synpred78_C1118); if (state.failed) return ;

        pushFollow(FOLLOW_type_name_in_synpred78_C1120);
        type_name();

        state._fsp--;
        if (state.failed) return ;

        match(input,31,FOLLOW_31_in_synpred78_C1122); if (state.failed) return ;

        pushFollow(FOLLOW_cast_expression_in_synpred78_C1124);
        cast_expression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred78_C

    // $ANTLR start synpred83_C
    public final void synpred83_C_fragment() throws RecognitionException {
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:311:4: ( 'sizeof' unary_expression )
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:311:4: 'sizeof' unary_expression
        {
        match(input,85,FOLLOW_85_in_synpred83_C1166); if (state.failed) return ;

        pushFollow(FOLLOW_unary_expression_in_synpred83_C1168);
        unary_expression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred83_C

    // $ANTLR start synpred104_C
    public final void synpred104_C_fragment() throws RecognitionException {
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:362:4: ( lvalue assignment_operator assignment_expression )
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:362:4: lvalue assignment_operator assignment_expression
        {
        pushFollow(FOLLOW_lvalue_in_synpred104_C1480);
        lvalue();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_assignment_operator_in_synpred104_C1482);
        assignment_operator();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_assignment_expression_in_synpred104_C1484);
        assignment_expression();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred104_C

    // $ANTLR start synpred136_C
    public final void synpred136_C_fragment() throws RecognitionException {
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:441:8: ( declaration )
        // /home/student/workspace-2015ws-ims15-SWSecurity/Parser-Antlr3-ANSI-C/src/main/resources/C.g:441:8: declaration
        {
        pushFollow(FOLLOW_declaration_in_synpred136_C1840);
        declaration();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred136_C

    // Delegated rules

    public final boolean synpred136_C() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred136_C_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_C() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_C_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_C() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_C_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred47_C() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_C_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred58_C() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred58_C_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred59_C() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred59_C_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred62_C() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred62_C_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred83_C() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred83_C_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred53_C() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_C_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_C() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_C_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred65_C() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred65_C_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_C() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_C_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred78_C() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred78_C_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_C() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_C_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_C() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_C_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_C() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_C_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_C() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_C_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_C() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_C_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred52_C() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_C_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred51_C() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred51_C_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred104_C() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred104_C_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred50_C() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_C_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA52 dfa52 = new DFA52(this);
    protected DFA64 dfa64 = new DFA64(this);
    static final String DFA52_eotS =
        "\157\uffff";
    static final String DFA52_eofS =
        "\1\uffff\2\17\154\uffff";
    static final String DFA52_minS =
        "\1\4\2\30\5\4\6\0\26\uffff\6\0\26\uffff\7\0\14\uffff\34\0";
    static final String DFA52_maxS =
        "\1\144\2\143\5\144\6\0\26\uffff\6\0\26\uffff\7\0\14\uffff\34\0";
    static final String DFA52_acceptS =
        "\16\uffff\1\1\1\2\137\uffff";
    static final String DFA52_specialS =
        "\10\uffff\1\0\1\1\1\2\1\3\1\4\1\5\26\uffff\1\6\1\7\1\10\1\11\1\12"+
        "\1\13\26\uffff\1\14\1\15\1\16\1\17\1\20\1\21\1\22\14\uffff\1\23"+
        "\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40"+
        "\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55"+
        "\1\56}>";
    static final String[] DFA52_transitionS = {
            "\1\2\1\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\1\1\4\uffff"+
            "\1\2\1\uffff\1\2\2\uffff\1\6\4\uffff\1\6\1\uffff\1\3\1\uffff"+
            "\1\6\1\uffff\1\6\1\4\2\uffff\1\6\1\5\55\uffff\1\7\16\uffff\1"+
            "\6",
            "\2\17\1\16\2\17\1\16\1\11\2\17\1\16\1\17\1\14\1\16\2\17\1\15"+
            "\1\16\1\13\1\12\1\uffff\1\17\1\16\4\17\1\16\1\17\1\16\4\17\1"+
            "\16\1\17\1\10\2\17\1\16\41\uffff\1\17\1\16\2\17",
            "\2\17\1\16\2\17\1\16\1\45\2\17\1\16\1\17\1\50\1\16\2\17\1\51"+
            "\1\16\1\47\1\46\1\uffff\1\17\1\16\4\17\1\16\1\17\1\16\4\17\1"+
            "\16\1\17\1\44\2\17\1\16\41\uffff\1\17\1\16\2\17",
            "\1\101\1\uffff\1\101\2\uffff\1\101\1\uffff\1\101\1\uffff\1"+
            "\100\4\uffff\1\101\1\uffff\1\101\2\uffff\1\105\4\uffff\1\105"+
            "\1\uffff\1\102\1\uffff\1\105\1\uffff\1\105\1\103\2\uffff\1\105"+
            "\1\104\32\uffff\2\17\3\uffff\1\17\1\uffff\1\17\1\uffff\1\17"+
            "\3\uffff\2\17\2\uffff\2\17\1\106\1\uffff\1\17\2\uffff\4\17\6"+
            "\uffff\1\105",
            "\1\124\1\uffff\1\124\2\uffff\1\124\1\uffff\1\124\1\uffff\1"+
            "\123\4\uffff\1\124\1\uffff\1\124\2\uffff\1\130\4\uffff\1\130"+
            "\1\uffff\1\125\1\uffff\1\130\1\uffff\1\130\1\126\2\uffff\1\130"+
            "\1\127\55\uffff\1\131\16\uffff\1\130",
            "\1\133\1\uffff\1\133\2\uffff\1\133\1\uffff\1\133\1\uffff\1"+
            "\132\4\uffff\1\133\1\uffff\1\133\2\uffff\1\137\4\uffff\1\137"+
            "\1\uffff\1\134\1\uffff\1\137\1\uffff\1\137\1\135\2\uffff\1\137"+
            "\1\136\55\uffff\1\140\16\uffff\1\137",
            "\1\143\1\uffff\1\143\2\uffff\1\143\1\uffff\1\143\1\uffff\1"+
            "\142\4\uffff\1\143\1\uffff\1\143\2\uffff\1\146\4\uffff\1\146"+
            "\1\uffff\1\141\1\uffff\1\146\1\uffff\1\146\1\144\2\uffff\1\146"+
            "\1\145\55\uffff\1\147\16\uffff\1\146",
            "\1\152\1\uffff\1\152\2\uffff\1\152\1\uffff\1\152\1\uffff\1"+
            "\151\4\uffff\1\152\1\uffff\1\152\2\uffff\1\155\4\uffff\1\155"+
            "\1\uffff\1\150\1\uffff\1\155\1\uffff\1\155\1\153\2\uffff\1\155"+
            "\1\154\55\uffff\1\156\16\uffff\1\155",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff"
    };

    static final short[] DFA52_eot = DFA.unpackEncodedString(DFA52_eotS);
    static final short[] DFA52_eof = DFA.unpackEncodedString(DFA52_eofS);
    static final char[] DFA52_min = DFA.unpackEncodedStringToUnsignedChars(DFA52_minS);
    static final char[] DFA52_max = DFA.unpackEncodedStringToUnsignedChars(DFA52_maxS);
    static final short[] DFA52_accept = DFA.unpackEncodedString(DFA52_acceptS);
    static final short[] DFA52_special = DFA.unpackEncodedString(DFA52_specialS);
    static final short[][] DFA52_transition;

    static {
        int numStates = DFA52_transitionS.length;
        DFA52_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA52_transition[i] = DFA.unpackEncodedString(DFA52_transitionS[i]);
        }
    }

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = DFA52_eot;
            this.eof = DFA52_eof;
            this.min = DFA52_min;
            this.max = DFA52_max;
            this.accept = DFA52_accept;
            this.special = DFA52_special;
            this.transition = DFA52_transition;
        }
        public String getDescription() {
            return "361:1: assignment_expression : ( lvalue assignment_operator assignment_expression | conditional_expression );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA52_8 = input.LA(1);

                         
                        int index52_8 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_8);

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA52_9 = input.LA(1);

                         
                        int index52_9 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_9);

                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA52_10 = input.LA(1);

                         
                        int index52_10 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_10);

                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA52_11 = input.LA(1);

                         
                        int index52_11 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_11);

                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA52_12 = input.LA(1);

                         
                        int index52_12 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_12);

                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA52_13 = input.LA(1);

                         
                        int index52_13 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_13);

                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA52_36 = input.LA(1);

                         
                        int index52_36 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_36);

                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA52_37 = input.LA(1);

                         
                        int index52_37 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_37);

                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA52_38 = input.LA(1);

                         
                        int index52_38 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_38);

                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA52_39 = input.LA(1);

                         
                        int index52_39 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_39);

                        if ( s>=0 ) return s;
                        break;

                    case 10 : 
                        int LA52_40 = input.LA(1);

                         
                        int index52_40 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_40);

                        if ( s>=0 ) return s;
                        break;

                    case 11 : 
                        int LA52_41 = input.LA(1);

                         
                        int index52_41 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_41);

                        if ( s>=0 ) return s;
                        break;

                    case 12 : 
                        int LA52_64 = input.LA(1);

                         
                        int index52_64 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_64);

                        if ( s>=0 ) return s;
                        break;

                    case 13 : 
                        int LA52_65 = input.LA(1);

                         
                        int index52_65 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_65);

                        if ( s>=0 ) return s;
                        break;

                    case 14 : 
                        int LA52_66 = input.LA(1);

                         
                        int index52_66 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_66);

                        if ( s>=0 ) return s;
                        break;

                    case 15 : 
                        int LA52_67 = input.LA(1);

                         
                        int index52_67 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_67);

                        if ( s>=0 ) return s;
                        break;

                    case 16 : 
                        int LA52_68 = input.LA(1);

                         
                        int index52_68 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_68);

                        if ( s>=0 ) return s;
                        break;

                    case 17 : 
                        int LA52_69 = input.LA(1);

                         
                        int index52_69 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_69);

                        if ( s>=0 ) return s;
                        break;

                    case 18 : 
                        int LA52_70 = input.LA(1);

                         
                        int index52_70 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_70);

                        if ( s>=0 ) return s;
                        break;

                    case 19 : 
                        int LA52_83 = input.LA(1);

                         
                        int index52_83 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_83);

                        if ( s>=0 ) return s;
                        break;

                    case 20 : 
                        int LA52_84 = input.LA(1);

                         
                        int index52_84 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_84);

                        if ( s>=0 ) return s;
                        break;

                    case 21 : 
                        int LA52_85 = input.LA(1);

                         
                        int index52_85 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_85);

                        if ( s>=0 ) return s;
                        break;

                    case 22 : 
                        int LA52_86 = input.LA(1);

                         
                        int index52_86 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_86);

                        if ( s>=0 ) return s;
                        break;

                    case 23 : 
                        int LA52_87 = input.LA(1);

                         
                        int index52_87 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_87);

                        if ( s>=0 ) return s;
                        break;

                    case 24 : 
                        int LA52_88 = input.LA(1);

                         
                        int index52_88 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_88);

                        if ( s>=0 ) return s;
                        break;

                    case 25 : 
                        int LA52_89 = input.LA(1);

                         
                        int index52_89 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_89);

                        if ( s>=0 ) return s;
                        break;

                    case 26 : 
                        int LA52_90 = input.LA(1);

                         
                        int index52_90 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_90);

                        if ( s>=0 ) return s;
                        break;

                    case 27 : 
                        int LA52_91 = input.LA(1);

                         
                        int index52_91 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_91);

                        if ( s>=0 ) return s;
                        break;

                    case 28 : 
                        int LA52_92 = input.LA(1);

                         
                        int index52_92 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_92);

                        if ( s>=0 ) return s;
                        break;

                    case 29 : 
                        int LA52_93 = input.LA(1);

                         
                        int index52_93 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_93);

                        if ( s>=0 ) return s;
                        break;

                    case 30 : 
                        int LA52_94 = input.LA(1);

                         
                        int index52_94 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_94);

                        if ( s>=0 ) return s;
                        break;

                    case 31 : 
                        int LA52_95 = input.LA(1);

                         
                        int index52_95 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_95);

                        if ( s>=0 ) return s;
                        break;

                    case 32 : 
                        int LA52_96 = input.LA(1);

                         
                        int index52_96 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_96);

                        if ( s>=0 ) return s;
                        break;

                    case 33 : 
                        int LA52_97 = input.LA(1);

                         
                        int index52_97 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_97);

                        if ( s>=0 ) return s;
                        break;

                    case 34 : 
                        int LA52_98 = input.LA(1);

                         
                        int index52_98 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_98);

                        if ( s>=0 ) return s;
                        break;

                    case 35 : 
                        int LA52_99 = input.LA(1);

                         
                        int index52_99 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_99);

                        if ( s>=0 ) return s;
                        break;

                    case 36 : 
                        int LA52_100 = input.LA(1);

                         
                        int index52_100 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_100);

                        if ( s>=0 ) return s;
                        break;

                    case 37 : 
                        int LA52_101 = input.LA(1);

                         
                        int index52_101 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_101);

                        if ( s>=0 ) return s;
                        break;

                    case 38 : 
                        int LA52_102 = input.LA(1);

                         
                        int index52_102 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_102);

                        if ( s>=0 ) return s;
                        break;

                    case 39 : 
                        int LA52_103 = input.LA(1);

                         
                        int index52_103 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_103);

                        if ( s>=0 ) return s;
                        break;

                    case 40 : 
                        int LA52_104 = input.LA(1);

                         
                        int index52_104 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_104);

                        if ( s>=0 ) return s;
                        break;

                    case 41 : 
                        int LA52_105 = input.LA(1);

                         
                        int index52_105 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_105);

                        if ( s>=0 ) return s;
                        break;

                    case 42 : 
                        int LA52_106 = input.LA(1);

                         
                        int index52_106 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_106);

                        if ( s>=0 ) return s;
                        break;

                    case 43 : 
                        int LA52_107 = input.LA(1);

                         
                        int index52_107 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_107);

                        if ( s>=0 ) return s;
                        break;

                    case 44 : 
                        int LA52_108 = input.LA(1);

                         
                        int index52_108 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_108);

                        if ( s>=0 ) return s;
                        break;

                    case 45 : 
                        int LA52_109 = input.LA(1);

                         
                        int index52_109 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_109);

                        if ( s>=0 ) return s;
                        break;

                    case 46 : 
                        int LA52_110 = input.LA(1);

                         
                        int index52_110 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred104_C()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index52_110);

                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}

            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 52, _s, input);
            error(nvae);
            throw nvae;
        }

    }
    static final String DFA64_eotS =
        "\112\uffff";
    static final String DFA64_eofS =
        "\112\uffff";
    static final String DFA64_minS =
        "\1\4\1\15\44\uffff\1\0\5\uffff\1\0\16\uffff\1\0\16\uffff";
    static final String DFA64_maxS =
        "\1\144\1\142\44\uffff\1\0\5\uffff\1\0\16\uffff\1\0\16\uffff";
    static final String DFA64_acceptS =
        "\2\uffff\1\2\23\uffff\1\1\63\uffff";
    static final String DFA64_specialS =
        "\46\uffff\1\0\5\uffff\1\1\16\uffff\1\2\16\uffff}>";
    static final String[] DFA64_transitionS = {
            "\1\2\1\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\1\1\4\uffff"+
            "\1\2\1\uffff\1\2\2\uffff\1\2\4\uffff\1\2\1\uffff\1\2\1\uffff"+
            "\1\2\1\uffff\2\2\2\uffff\2\2\7\uffff\1\2\17\uffff\1\26\2\2\2"+
            "\26\3\2\1\26\1\uffff\3\26\3\2\3\26\1\2\2\26\1\2\2\26\1\2\5\26"+
            "\2\2\3\uffff\2\2",
            "\1\26\12\uffff\6\2\1\46\1\uffff\1\54\12\2\1\uffff\3\2\1\73"+
            "\14\2\1\uffff\2\2\1\26\2\uffff\2\26\3\uffff\1\26\1\uffff\3\26"+
            "\3\uffff\3\26\1\uffff\2\26\1\uffff\2\26\2\uffff\4\26\2\uffff"+
            "\3\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA64_eot = DFA.unpackEncodedString(DFA64_eotS);
    static final short[] DFA64_eof = DFA.unpackEncodedString(DFA64_eofS);
    static final char[] DFA64_min = DFA.unpackEncodedStringToUnsignedChars(DFA64_minS);
    static final char[] DFA64_max = DFA.unpackEncodedStringToUnsignedChars(DFA64_maxS);
    static final short[] DFA64_accept = DFA.unpackEncodedString(DFA64_acceptS);
    static final short[] DFA64_special = DFA.unpackEncodedString(DFA64_specialS);
    static final short[][] DFA64_transition;

    static {
        int numStates = DFA64_transitionS.length;
        DFA64_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA64_transition[i] = DFA.unpackEncodedString(DFA64_transitionS[i]);
        }
    }

    class DFA64 extends DFA {

        public DFA64(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 64;
            this.eot = DFA64_eot;
            this.eof = DFA64_eof;
            this.min = DFA64_min;
            this.max = DFA64_max;
            this.accept = DFA64_accept;
            this.special = DFA64_special;
            this.transition = DFA64_transition;
        }
        public String getDescription() {
            return "()* loopback of 441:8: ( declaration )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA64_38 = input.LA(1);

                         
                        int index64_38 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (((synpred136_C()&&synpred136_C())&&(isTypeName(input.LT(1).getText())))) ) {s = 22;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index64_38);

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA64_44 = input.LA(1);

                         
                        int index64_44 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (((synpred136_C()&&synpred136_C())&&(isTypeName(input.LT(1).getText())))) ) {s = 22;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index64_44);

                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA64_59 = input.LA(1);

                         
                        int index64_59 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (((synpred136_C()&&synpred136_C())&&(isTypeName(input.LT(1).getText())))) ) {s = 22;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index64_59);

                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}

            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 64, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

    public static final BitSet FOLLOW_external_declaration_in_translation_unit74 = new BitSet(new long[]{0x8000000140002002L,0x000000003EDB8E8CL});
    public static final BitSet FOLLOW_function_definition_in_external_declaration110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_external_declaration115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_specifiers_in_function_definition137 = new BitSet(new long[]{0x0000000140002000L});
    public static final BitSet FOLLOW_declarator_in_function_definition140 = new BitSet(new long[]{0x8000000000002000L,0x00000000BEDB8E8CL});
    public static final BitSet FOLLOW_declaration_in_function_definition146 = new BitSet(new long[]{0x8000000000002000L,0x00000000BEDB8E8CL});
    public static final BitSet FOLLOW_compound_statement_in_function_definition149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compound_statement_in_function_definition156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_declaration184 = new BitSet(new long[]{0x8000000140002000L,0x000000003CDB8E8CL});
    public static final BitSet FOLLOW_declaration_specifiers_in_declaration186 = new BitSet(new long[]{0x0000000140002000L});
    public static final BitSet FOLLOW_init_declarator_list_in_declaration194 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_declaration196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_specifiers_in_declaration202 = new BitSet(new long[]{0x0000800140002000L});
    public static final BitSet FOLLOW_init_declarator_list_in_declaration204 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_declaration207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_storage_class_specifier_in_declaration_specifiers224 = new BitSet(new long[]{0x8000000000002002L,0x000000003CDB8E8CL});
    public static final BitSet FOLLOW_type_specifier_in_declaration_specifiers232 = new BitSet(new long[]{0x8000000000002002L,0x000000003CDB8E8CL});
    public static final BitSet FOLLOW_type_qualifier_in_declaration_specifiers246 = new BitSet(new long[]{0x8000000000002002L,0x000000003CDB8E8CL});
    public static final BitSet FOLLOW_init_declarator_in_init_declarator_list268 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_init_declarator_list271 = new BitSet(new long[]{0x0000000140002000L});
    public static final BitSet FOLLOW_init_declarator_in_init_declarator_list273 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_declarator_in_init_declarator286 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_52_in_init_declarator289 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001080200000L});
    public static final BitSet FOLLOW_initializer_in_init_declarator291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_type_specifier330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_type_specifier335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_type_specifier340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_type_specifier345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_type_specifier350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_type_specifier355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_type_specifier360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_type_specifier365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_type_specifier370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_struct_or_union_specifier_in_type_specifier375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enum_specifier_in_type_specifier380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_id_in_type_specifier385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_type_id403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_struct_or_union_in_struct_or_union_specifier436 = new BitSet(new long[]{0x0000000000002000L,0x0000000080000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_struct_or_union_specifier438 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_struct_or_union_specifier441 = new BitSet(new long[]{0x0000000000002000L,0x000000003C998A8CL});
    public static final BitSet FOLLOW_struct_declaration_list_in_struct_or_union_specifier443 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_struct_or_union_specifier445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_struct_or_union_in_struct_or_union_specifier450 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_struct_or_union_specifier452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_struct_declaration_in_struct_declaration_list479 = new BitSet(new long[]{0x0000000000002002L,0x000000003C998A8CL});
    public static final BitSet FOLLOW_specifier_qualifier_list_in_struct_declaration491 = new BitSet(new long[]{0x0000400140002000L});
    public static final BitSet FOLLOW_struct_declarator_list_in_struct_declaration493 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_struct_declaration495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_qualifier_in_specifier_qualifier_list508 = new BitSet(new long[]{0x0000000000002002L,0x000000003C998A8CL});
    public static final BitSet FOLLOW_type_specifier_in_specifier_qualifier_list512 = new BitSet(new long[]{0x0000000000002002L,0x000000003C998A8CL});
    public static final BitSet FOLLOW_struct_declarator_in_struct_declarator_list526 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_struct_declarator_list529 = new BitSet(new long[]{0x0000400140002000L});
    public static final BitSet FOLLOW_struct_declarator_in_struct_declarator_list531 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_declarator_in_struct_declarator544 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_struct_declarator547 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_constant_expression_in_struct_declarator549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_struct_declarator556 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_constant_expression_in_struct_declarator558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_enum_specifier576 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_enum_specifier578 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_enumerator_list_in_enum_specifier580 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_enum_specifier582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_enum_specifier587 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enum_specifier589 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
    public static final BitSet FOLLOW_95_in_enum_specifier591 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_enumerator_list_in_enum_specifier593 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_enum_specifier595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_enum_specifier600 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enum_specifier602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enumerator_in_enumerator_list613 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_enumerator_list616 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_enumerator_in_enumerator_list618 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_enumerator631 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_52_in_enumerator634 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_constant_expression_in_enumerator636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointer_in_declarator665 = new BitSet(new long[]{0x0000000040002000L});
    public static final BitSet FOLLOW_direct_declarator_in_declarator668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointer_in_declarator673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_direct_declarator688 = new BitSet(new long[]{0x0800000040000002L});
    public static final BitSet FOLLOW_30_in_direct_declarator699 = new BitSet(new long[]{0x0000000140002000L});
    public static final BitSet FOLLOW_declarator_in_direct_declarator701 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_direct_declarator703 = new BitSet(new long[]{0x0800000040000002L});
    public static final BitSet FOLLOW_declarator_suffix_in_direct_declarator717 = new BitSet(new long[]{0x0800000040000002L});
    public static final BitSet FOLLOW_59_in_declarator_suffix731 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_constant_expression_in_declarator_suffix733 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_declarator_suffix735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_declarator_suffix745 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_declarator_suffix747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_declarator_suffix757 = new BitSet(new long[]{0x8000000000002000L,0x000000003CDB8E8CL});
    public static final BitSet FOLLOW_parameter_type_list_in_declarator_suffix759 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_declarator_suffix761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_declarator_suffix771 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_identifier_list_in_declarator_suffix773 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_declarator_suffix775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_declarator_suffix785 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_declarator_suffix787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_pointer798 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000008L});
    public static final BitSet FOLLOW_type_qualifier_in_pointer800 = new BitSet(new long[]{0x0000000100000002L,0x0000000020000008L});
    public static final BitSet FOLLOW_pointer_in_pointer803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_pointer809 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pointer_in_pointer811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_pointer816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameter_list_in_parameter_type_list827 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_parameter_type_list830 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_parameter_type_list832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameter_declaration_in_parameter_list845 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_parameter_list848 = new BitSet(new long[]{0x8000000000002000L,0x000000003CDB8E8CL});
    public static final BitSet FOLLOW_parameter_declaration_in_parameter_list850 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_declaration_specifiers_in_parameter_declaration863 = new BitSet(new long[]{0x0800000140002002L});
    public static final BitSet FOLLOW_declarator_in_parameter_declaration866 = new BitSet(new long[]{0x0800000140002002L});
    public static final BitSet FOLLOW_abstract_declarator_in_parameter_declaration868 = new BitSet(new long[]{0x0800000140002002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_identifier_list881 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_identifier_list884 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_identifier_list886 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_specifier_qualifier_list_in_type_name899 = new BitSet(new long[]{0x0800000140000002L});
    public static final BitSet FOLLOW_abstract_declarator_in_type_name901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointer_in_abstract_declarator913 = new BitSet(new long[]{0x0800000040000002L});
    public static final BitSet FOLLOW_direct_abstract_declarator_in_abstract_declarator915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_direct_abstract_declarator_in_abstract_declarator921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_direct_abstract_declarator934 = new BitSet(new long[]{0x0800000140000000L});
    public static final BitSet FOLLOW_abstract_declarator_in_direct_abstract_declarator936 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_direct_abstract_declarator938 = new BitSet(new long[]{0x0800000040000002L});
    public static final BitSet FOLLOW_abstract_declarator_suffix_in_direct_abstract_declarator942 = new BitSet(new long[]{0x0800000040000002L});
    public static final BitSet FOLLOW_abstract_declarator_suffix_in_direct_abstract_declarator946 = new BitSet(new long[]{0x0800000040000002L});
    public static final BitSet FOLLOW_59_in_abstract_declarator_suffix958 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_abstract_declarator_suffix960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_abstract_declarator_suffix965 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_constant_expression_in_abstract_declarator_suffix967 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_abstract_declarator_suffix969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_abstract_declarator_suffix974 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_abstract_declarator_suffix976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_abstract_declarator_suffix981 = new BitSet(new long[]{0x8000000000002000L,0x000000003CDB8E8CL});
    public static final BitSet FOLLOW_parameter_type_list_in_abstract_declarator_suffix983 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_abstract_declarator_suffix985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_expression_in_initializer997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_initializer1002 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001080200000L});
    public static final BitSet FOLLOW_initializer_list_in_initializer1004 = new BitSet(new long[]{0x0000002000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_37_in_initializer1006 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_initializer1009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_initializer_in_initializer_list1020 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_initializer_list1023 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001080200000L});
    public static final BitSet FOLLOW_initializer_in_initializer_list1025 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_assignment_expression_in_argument_expression_list1042 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_argument_expression_list1045 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_assignment_expression_in_argument_expression_list1047 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_multiplicative_expression_in_additive_expression1061 = new BitSet(new long[]{0x0000004400000002L});
    public static final BitSet FOLLOW_34_in_additive_expression1065 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_multiplicative_expression_in_additive_expression1067 = new BitSet(new long[]{0x0000004400000002L});
    public static final BitSet FOLLOW_38_in_additive_expression1071 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_multiplicative_expression_in_additive_expression1073 = new BitSet(new long[]{0x0000004400000002L});
    public static final BitSet FOLLOW_cast_expression_in_multiplicative_expression1087 = new BitSet(new long[]{0x0000100102000002L});
    public static final BitSet FOLLOW_32_in_multiplicative_expression1091 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_cast_expression_in_multiplicative_expression1093 = new BitSet(new long[]{0x0000100102000002L});
    public static final BitSet FOLLOW_44_in_multiplicative_expression1097 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_cast_expression_in_multiplicative_expression1099 = new BitSet(new long[]{0x0000100102000002L});
    public static final BitSet FOLLOW_25_in_multiplicative_expression1103 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_cast_expression_in_multiplicative_expression1105 = new BitSet(new long[]{0x0000100102000002L});
    public static final BitSet FOLLOW_30_in_cast_expression1118 = new BitSet(new long[]{0x0000000000002000L,0x000000003C998A8CL});
    public static final BitSet FOLLOW_type_name_in_cast_expression1120 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_cast_expression1122 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_cast_expression_in_cast_expression1124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_expression_in_cast_expression1129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfix_expression_in_unary_expression1140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_unary_expression1145 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_unary_expression_in_unary_expression1147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_unary_expression1152 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_unary_expression_in_unary_expression1154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_operator_in_unary_expression1159 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_cast_expression_in_unary_expression1161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_unary_expression1166 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_unary_expression_in_unary_expression1168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_unary_expression1173 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_unary_expression1175 = new BitSet(new long[]{0x0000000000002000L,0x000000003C998A8CL});
    public static final BitSet FOLLOW_type_name_in_unary_expression1177 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_unary_expression1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primary_expression_in_postfix_expression1192 = new BitSet(new long[]{0x0800068840000002L});
    public static final BitSet FOLLOW_59_in_postfix_expression1206 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_expression_in_postfix_expression1208 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_postfix_expression1210 = new BitSet(new long[]{0x0800068840000002L});
    public static final BitSet FOLLOW_30_in_postfix_expression1224 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_postfix_expression1226 = new BitSet(new long[]{0x0800068840000002L});
    public static final BitSet FOLLOW_30_in_postfix_expression1240 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_argument_expression_list_in_postfix_expression1242 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_postfix_expression1244 = new BitSet(new long[]{0x0800068840000002L});
    public static final BitSet FOLLOW_42_in_postfix_expression1258 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_postfix_expression1260 = new BitSet(new long[]{0x0800068840000002L});
    public static final BitSet FOLLOW_41_in_postfix_expression1274 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_postfix_expression1276 = new BitSet(new long[]{0x0800068840000002L});
    public static final BitSet FOLLOW_35_in_postfix_expression1290 = new BitSet(new long[]{0x0800068840000002L});
    public static final BitSet FOLLOW_39_in_postfix_expression1304 = new BitSet(new long[]{0x0800068840000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primary_expression1362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_primary_expression1367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_primary_expression1372 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_expression_in_primary_expression1374 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_primary_expression1376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_expression_in_expression1451 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_expression1454 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_assignment_expression_in_expression1456 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_conditional_expression_in_constant_expression1469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lvalue_in_assignment_expression1480 = new BitSet(new long[]{0x4214211224000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_assignment_operator_in_assignment_expression1482 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_assignment_expression_in_assignment_expression1484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditional_expression_in_assignment_expression1489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_expression_in_lvalue1501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logical_or_expression_in_conditional_expression1573 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_58_in_conditional_expression1576 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_expression_in_conditional_expression1578 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_conditional_expression1580 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_conditional_expression_in_conditional_expression1582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logical_and_expression_in_logical_or_expression1595 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_98_in_logical_or_expression1598 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_logical_and_expression_in_logical_or_expression1600 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
    public static final BitSet FOLLOW_inclusive_or_expression_in_logical_and_expression1613 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_logical_and_expression1616 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_inclusive_or_expression_in_logical_and_expression1618 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_exclusive_or_expression_in_inclusive_or_expression1631 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_96_in_inclusive_or_expression1634 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_exclusive_or_expression_in_inclusive_or_expression1636 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
    public static final BitSet FOLLOW_and_expression_in_exclusive_or_expression1649 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_61_in_exclusive_or_expression1652 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_and_expression_in_exclusive_or_expression1654 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_equality_expression_in_and_expression1667 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_and_expression1670 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_equality_expression_in_and_expression1672 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_relational_expression_in_equality_expression1684 = new BitSet(new long[]{0x0020000001000002L});
    public static final BitSet FOLLOW_set_in_equality_expression1687 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_relational_expression_in_equality_expression1693 = new BitSet(new long[]{0x0020000001000002L});
    public static final BitSet FOLLOW_shift_expression_in_relational_expression1706 = new BitSet(new long[]{0x00C9000000000002L});
    public static final BitSet FOLLOW_set_in_relational_expression1709 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_shift_expression_in_relational_expression1719 = new BitSet(new long[]{0x00C9000000000002L});
    public static final BitSet FOLLOW_additive_expression_in_shift_expression1732 = new BitSet(new long[]{0x0102000000000002L});
    public static final BitSet FOLLOW_set_in_shift_expression1735 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_additive_expression_in_shift_expression1741 = new BitSet(new long[]{0x0102000000000002L});
    public static final BitSet FOLLOW_labeled_statement_in_statement1756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compound_statement_in_statement1761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_statement_in_statement1766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selection_statement_in_statement1771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_iteration_statement_in_statement1776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_jump_statement_in_statement1781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_labeled_statement1792 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_labeled_statement1794 = new BitSet(new long[]{0x000080CD50942A50L,0x00000010C1247073L});
    public static final BitSet FOLLOW_statement_in_labeled_statement1796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_labeled_statement1801 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_constant_expression_in_labeled_statement1803 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_labeled_statement1805 = new BitSet(new long[]{0x000080CD50942A50L,0x00000010C1247073L});
    public static final BitSet FOLLOW_statement_in_labeled_statement1807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_labeled_statement1812 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_labeled_statement1814 = new BitSet(new long[]{0x000080CD50942A50L,0x00000010C1247073L});
    public static final BitSet FOLLOW_statement_in_labeled_statement1816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_compound_statement1838 = new BitSet(new long[]{0x800080CD50942A50L,0x00000018FFFFFEFFL});
    public static final BitSet FOLLOW_declaration_in_compound_statement1840 = new BitSet(new long[]{0x800080CD50942A50L,0x00000018FFFFFEFFL});
    public static final BitSet FOLLOW_statement_list_in_compound_statement1843 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
    public static final BitSet FOLLOW_99_in_compound_statement1846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statement_list1857 = new BitSet(new long[]{0x000080CD50942A52L,0x00000010C1247073L});
    public static final BitSet FOLLOW_47_in_expression_statement1869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_expression_statement1874 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_expression_statement1876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_selection_statement1887 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_selection_statement1889 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_expression_in_selection_statement1891 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_selection_statement1893 = new BitSet(new long[]{0x000080CD50942A50L,0x00000010C1247073L});
    public static final BitSet FOLLOW_statement_in_selection_statement1895 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_selection_statement1910 = new BitSet(new long[]{0x000080CD50942A50L,0x00000010C1247073L});
    public static final BitSet FOLLOW_statement_in_selection_statement1912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_selection_statement1919 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_selection_statement1921 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_expression_in_selection_statement1923 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_selection_statement1925 = new BitSet(new long[]{0x000080CD50942A50L,0x00000010C1247073L});
    public static final BitSet FOLLOW_statement_in_selection_statement1927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_iteration_statement1938 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_iteration_statement1940 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_expression_in_iteration_statement1942 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_iteration_statement1944 = new BitSet(new long[]{0x000080CD50942A50L,0x00000010C1247073L});
    public static final BitSet FOLLOW_statement_in_iteration_statement1946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_iteration_statement1951 = new BitSet(new long[]{0x000080CD50942A50L,0x00000010C1247073L});
    public static final BitSet FOLLOW_statement_in_iteration_statement1953 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_94_in_iteration_statement1955 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_iteration_statement1957 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_expression_in_iteration_statement1959 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_iteration_statement1961 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_iteration_statement1963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_iteration_statement1968 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_iteration_statement1970 = new BitSet(new long[]{0x000080CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_expression_statement_in_iteration_statement1972 = new BitSet(new long[]{0x000080CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_expression_statement_in_iteration_statement1974 = new BitSet(new long[]{0x000000CDD0942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_expression_in_iteration_statement1976 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_iteration_statement1979 = new BitSet(new long[]{0x000080CD50942A50L,0x00000010C1247073L});
    public static final BitSet FOLLOW_statement_in_iteration_statement1981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_jump_statement1992 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_jump_statement1994 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_jump_statement1996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_jump_statement2001 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_jump_statement2003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_jump_statement2008 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_jump_statement2010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_jump_statement2015 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_jump_statement2017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_jump_statement2022 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_expression_in_jump_statement2024 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_jump_statement2026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_specifiers_in_synpred2_C97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_specifiers_in_synpred4_C97 = new BitSet(new long[]{0x0000000140002000L});
    public static final BitSet FOLLOW_declarator_in_synpred4_C100 = new BitSet(new long[]{0x8000000000002000L,0x00000000BEDB8E8CL});
    public static final BitSet FOLLOW_declaration_in_synpred4_C102 = new BitSet(new long[]{0x8000000000002000L,0x00000000BEDB8E8CL});
    public static final BitSet FOLLOW_95_in_synpred4_C105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_specifiers_in_synpred5_C137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_specifiers_in_synpred8_C186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_specifier_in_synpred12_C232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_specifier_in_synpred35_C512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointer_in_synpred45_C665 = new BitSet(new long[]{0x0000000040002000L});
    public static final BitSet FOLLOW_direct_declarator_in_synpred45_C668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarator_suffix_in_synpred47_C717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_synpred50_C757 = new BitSet(new long[]{0x8000000000002000L,0x000000003CDB8E8CL});
    public static final BitSet FOLLOW_parameter_type_list_in_synpred50_C759 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_synpred50_C761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_synpred51_C771 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_identifier_list_in_synpred51_C773 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_synpred51_C775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_qualifier_in_synpred52_C800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointer_in_synpred53_C803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_synpred54_C798 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000008L});
    public static final BitSet FOLLOW_type_qualifier_in_synpred54_C800 = new BitSet(new long[]{0x0000000100000002L,0x0000000020000008L});
    public static final BitSet FOLLOW_pointer_in_synpred54_C803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_synpred55_C809 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_pointer_in_synpred55_C811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declarator_in_synpred58_C866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abstract_declarator_in_synpred59_C868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_direct_abstract_declarator_in_synpred62_C915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abstract_declarator_suffix_in_synpred65_C946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_synpred78_C1118 = new BitSet(new long[]{0x0000000000002000L,0x000000003C998A8CL});
    public static final BitSet FOLLOW_type_name_in_synpred78_C1120 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_synpred78_C1122 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_cast_expression_in_synpred78_C1124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_synpred83_C1166 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_unary_expression_in_synpred83_C1168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lvalue_in_synpred104_C1480 = new BitSet(new long[]{0x4214211224000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_assignment_operator_in_synpred104_C1482 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
    public static final BitSet FOLLOW_assignment_expression_in_synpred104_C1484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_in_synpred136_C1840 = new BitSet(new long[]{0x0000000000000002L});

}