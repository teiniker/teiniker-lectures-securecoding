// $ANTLR 3.3 Nov 30, 2010 12:50:56 /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g 2012-03-30 11:08:26
 package org.se.lab; 

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

public class OperationParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENTIFIER", "LPAREN", "RPAREN", "SEMI", "COMMA", "LETTER", "COMMENT", "LINE_COMMENT", "WS", "'void'", "'char'", "'short'", "'int'", "'long'", "'float'", "'double'"
    };
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int IDENTIFIER=4;
    public static final int LPAREN=5;
    public static final int RPAREN=6;
    public static final int SEMI=7;
    public static final int COMMA=8;
    public static final int LETTER=9;
    public static final int COMMENT=10;
    public static final int LINE_COMMENT=11;
    public static final int WS=12;

    // delegates
    // delegators


        public OperationParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public OperationParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return OperationParser.tokenNames; }
    public String getGrammarFileName() { return "/home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g"; }



    // $ANTLR start "prog"
    // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:10:1: prog returns [MOperation op] : operation_def ;
    public final MOperation prog() throws RecognitionException {
        MOperation op = null;

        MOperation operation_def1 = null;


        try {
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:11:3: ( operation_def )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:11:5: operation_def
            {
            pushFollow(FOLLOW_operation_def_in_prog36);
            operation_def1=operation_def();

            state._fsp--;


                  op = operation_def1;
                

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return op;
    }
    // $ANTLR end "prog"


    // $ANTLR start "operation_def"
    // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:17:1: operation_def returns [MOperation op] : type_def IDENTIFIER LPAREN parameter_list RPAREN SEMI ;
    public final MOperation operation_def() throws RecognitionException {
        MOperation op = null;

        Token IDENTIFIER2=null;
        MType type_def3 = null;

        List<MParameter> parameter_list4 = null;


        try {
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:18:3: ( type_def IDENTIFIER LPAREN parameter_list RPAREN SEMI )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:18:5: type_def IDENTIFIER LPAREN parameter_list RPAREN SEMI
            {
            pushFollow(FOLLOW_type_def_in_operation_def59);
            type_def3=type_def();

            state._fsp--;

            IDENTIFIER2=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_operation_def61); 
            match(input,LPAREN,FOLLOW_LPAREN_in_operation_def63); 
            pushFollow(FOLLOW_parameter_list_in_operation_def65);
            parameter_list4=parameter_list();

            state._fsp--;

            match(input,RPAREN,FOLLOW_RPAREN_in_operation_def67); 
            match(input,SEMI,FOLLOW_SEMI_in_operation_def69); 

                  op = new MOperation((IDENTIFIER2!=null?IDENTIFIER2.getText():null), type_def3);
                  op.setParameters(parameter_list4);
                

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return op;
    }
    // $ANTLR end "operation_def"


    // $ANTLR start "parameter_list"
    // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:25:1: parameter_list returns [List<MParameter> list] : p1= parameter_def ( COMMA pn= parameter_def )* ;
    public final List<MParameter> parameter_list() throws RecognitionException {
        List<MParameter> list = null;

        MParameter p1 = null;

        MParameter pn = null;



          list = new ArrayList<MParameter>();

        try {
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:30:2: (p1= parameter_def ( COMMA pn= parameter_def )* )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:30:4: p1= parameter_def ( COMMA pn= parameter_def )*
            {
            pushFollow(FOLLOW_parameter_def_in_parameter_list98);
            p1=parameter_def();

            state._fsp--;


            	    list.add(p1);
            	  
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:34:4: ( COMMA pn= parameter_def )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==COMMA) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:34:5: COMMA pn= parameter_def
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_parameter_list110); 
            	    pushFollow(FOLLOW_parameter_def_in_parameter_list114);
            	    pn=parameter_def();

            	    state._fsp--;

            	    list.add(pn);

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return list;
    }
    // $ANTLR end "parameter_list"


    // $ANTLR start "parameter_def"
    // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:37:1: parameter_def returns [MParameter param] : type_def IDENTIFIER ;
    public final MParameter parameter_def() throws RecognitionException {
        MParameter param = null;

        Token IDENTIFIER5=null;
        MType type_def6 = null;


        try {
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:38:2: ( type_def IDENTIFIER )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:38:4: type_def IDENTIFIER
            {
            pushFollow(FOLLOW_type_def_in_parameter_def134);
            type_def6=type_def();

            state._fsp--;

            IDENTIFIER5=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_parameter_def136); 

            	    param = new MParameter((IDENTIFIER5!=null?IDENTIFIER5.getText():null), type_def6);
            	  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return param;
    }
    // $ANTLR end "parameter_def"


    // $ANTLR start "type_def"
    // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:44:1: type_def returns [MType type] : type_specifier ;
    public final MType type_def() throws RecognitionException {
        MType type = null;

        OperationParser.type_specifier_return type_specifier7 = null;


        try {
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:45:3: ( type_specifier )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:45:7: type_specifier
            {
            pushFollow(FOLLOW_type_specifier_in_type_def163);
            type_specifier7=type_specifier();

            state._fsp--;


                  type = new MType((type_specifier7!=null?input.toString(type_specifier7.start,type_specifier7.stop):null));
                

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return type;
    }
    // $ANTLR end "type_def"

    public static class type_specifier_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "type_specifier"
    // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:51:1: type_specifier : ( 'void' | 'char' | 'short' | 'int' | 'long' | 'float' | 'double' );
    public final OperationParser.type_specifier_return type_specifier() throws RecognitionException {
        OperationParser.type_specifier_return retval = new OperationParser.type_specifier_return();
        retval.start = input.LT(1);

        try {
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:52:2: ( 'void' | 'char' | 'short' | 'int' | 'long' | 'float' | 'double' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:
            {
            if ( (input.LA(1)>=13 && input.LA(1)<=19) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "type_specifier"

    // Delegated rules


 

    public static final BitSet FOLLOW_operation_def_in_prog36 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_def_in_operation_def59 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_operation_def61 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LPAREN_in_operation_def63 = new BitSet(new long[]{0x00000000000FE000L});
    public static final BitSet FOLLOW_parameter_list_in_operation_def65 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RPAREN_in_operation_def67 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_SEMI_in_operation_def69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameter_def_in_parameter_list98 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_COMMA_in_parameter_list110 = new BitSet(new long[]{0x00000000000FE000L});
    public static final BitSet FOLLOW_parameter_def_in_parameter_list114 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_type_def_in_parameter_def134 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENTIFIER_in_parameter_def136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_specifier_in_type_def163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_type_specifier0 = new BitSet(new long[]{0x0000000000000002L});

}