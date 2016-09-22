// $ANTLR 3.3 Nov 30, 2010 12:50:56 /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g 2012-03-20 16:09:27
 
	package org.se.lab; 


import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

public class StructParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "STRUCT", "ID", "LCURLY", "RCURLY", "SEMI", "LETTER", "COMMENT", "LINE_COMMENT", "WS", "'void'", "'char'", "'short'", "'int'", "'long'", "'float'", "'double'"
    };
    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int STRUCT=4;
    public static final int ID=5;
    public static final int LCURLY=6;
    public static final int RCURLY=7;
    public static final int SEMI=8;
    public static final int LETTER=9;
    public static final int COMMENT=10;
    public static final int LINE_COMMENT=11;
    public static final int WS=12;

    // delegates
    // delegators


        public StructParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public StructParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return StructParser.tokenNames; }
    public String getGrammarFileName() { return "/home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g"; }



    // $ANTLR start "prog"
    // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:18:1: prog returns [MStruct struct] : struct_def ;
    public final MStruct prog() throws RecognitionException {
        MStruct struct = null;

        MStruct struct_def1 = null;


        try {
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:19:2: ( struct_def )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:19:4: struct_def
            {
            pushFollow(FOLLOW_struct_def_in_prog39);
            struct_def1=struct_def();

            state._fsp--;


            			struct = struct_def1;
            		

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return struct;
    }
    // $ANTLR end "prog"


    // $ANTLR start "struct_def"
    // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:26:1: struct_def returns [MStruct struct] : STRUCT ID LCURLY field_list RCURLY SEMI ;
    public final MStruct struct_def() throws RecognitionException {
        MStruct struct = null;

        Token ID2=null;
        List<MField> field_list3 = null;


        try {
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:27:2: ( STRUCT ID LCURLY field_list RCURLY SEMI )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:27:4: STRUCT ID LCURLY field_list RCURLY SEMI
            {
            match(input,STRUCT,FOLLOW_STRUCT_in_struct_def59); 
            ID2=(Token)match(input,ID,FOLLOW_ID_in_struct_def61); 
            match(input,LCURLY,FOLLOW_LCURLY_in_struct_def63); 
            pushFollow(FOLLOW_field_list_in_struct_def65);
            field_list3=field_list();

            state._fsp--;

            match(input,RCURLY,FOLLOW_RCURLY_in_struct_def67); 
            match(input,SEMI,FOLLOW_SEMI_in_struct_def69); 

            			struct = new MStruct((ID2!=null?ID2.getText():null));
            			struct.setFields(field_list3);
            		

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return struct;
    }
    // $ANTLR end "struct_def"


    // $ANTLR start "field_list"
    // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:35:1: field_list returns [List<MField> fields] : ( field_def )+ ;
    public final List<MField> field_list() throws RecognitionException {
        List<MField> fields = null;

        MField field_def4 = null;



        	fields = new ArrayList<MField>();

        try {
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:40:2: ( ( field_def )+ )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:40:4: ( field_def )+
            {
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:40:4: ( field_def )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=13 && LA1_0<=19)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:40:5: field_def
            	    {
            	    pushFollow(FOLLOW_field_def_in_field_list98);
            	    field_def4=field_def();

            	    state._fsp--;

            	     fields.add(field_def4); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
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
        }
        return fields;
    }
    // $ANTLR end "field_list"


    // $ANTLR start "field_def"
    // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:44:1: field_def returns [MField field] : type_def ID SEMI ;
    public final MField field_def() throws RecognitionException {
        MField field = null;

        Token ID5=null;
        MType type_def6 = null;


        try {
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:45:2: ( type_def ID SEMI )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:45:4: type_def ID SEMI
            {
            pushFollow(FOLLOW_type_def_in_field_def120);
            type_def6=type_def();

            state._fsp--;

            ID5=(Token)match(input,ID,FOLLOW_ID_in_field_def122); 
            match(input,SEMI,FOLLOW_SEMI_in_field_def124); 

            			field = new MField((ID5!=null?ID5.getText():null), type_def6);		
            		

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return field;
    }
    // $ANTLR end "field_def"


    // $ANTLR start "type_def"
    // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:52:1: type_def returns [MType type] : type_specifier ;
    public final MType type_def() throws RecognitionException {
        MType type = null;

        StructParser.type_specifier_return type_specifier7 = null;


        try {
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:53:2: ( type_specifier )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:53:6: type_specifier
            {
            pushFollow(FOLLOW_type_specifier_in_type_def151);
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
    // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:60:1: type_specifier : ( 'void' | 'char' | 'short' | 'int' | 'long' | 'float' | 'double' );
    public final StructParser.type_specifier_return type_specifier() throws RecognitionException {
        StructParser.type_specifier_return retval = new StructParser.type_specifier_return();
        retval.start = input.LT(1);

        try {
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:61:2: ( 'void' | 'char' | 'short' | 'int' | 'long' | 'float' | 'double' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:
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


 

    public static final BitSet FOLLOW_struct_def_in_prog39 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRUCT_in_struct_def59 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_struct_def61 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_LCURLY_in_struct_def63 = new BitSet(new long[]{0x00000000000FE000L});
    public static final BitSet FOLLOW_field_list_in_struct_def65 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RCURLY_in_struct_def67 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_struct_def69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_field_def_in_field_list98 = new BitSet(new long[]{0x00000000000FE002L});
    public static final BitSet FOLLOW_type_def_in_field_def120 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_field_def122 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_SEMI_in_field_def124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_specifier_in_type_def151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_type_specifier0 = new BitSet(new long[]{0x0000000000000002L});

}