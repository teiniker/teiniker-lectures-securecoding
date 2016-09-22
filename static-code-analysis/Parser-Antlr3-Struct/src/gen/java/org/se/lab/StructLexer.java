// $ANTLR 3.3 Nov 30, 2010 12:50:56 /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g 2012-03-20 16:09:28
 
	package org.se.lab; 


import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

public class StructLexer extends Lexer {
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

    public StructLexer() {;} 
    public StructLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public StructLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:7:7: ( 'void' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:7:9: 'void'
            {
            match("void"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:8:7: ( 'char' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:8:9: 'char'
            {
            match("char"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:9:7: ( 'short' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:9:9: 'short'
            {
            match("short"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:10:7: ( 'int' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:10:9: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:11:7: ( 'long' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:11:9: 'long'
            {
            match("long"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:12:7: ( 'float' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:12:9: 'float'
            {
            match("float"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:13:7: ( 'double' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:13:9: 'double'
            {
            match("double"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:77:8: ( ';' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:77:10: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMI"

    // $ANTLR start "LCURLY"
    public final void mLCURLY() throws RecognitionException {
        try {
            int _type = LCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:78:8: ( '{' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:78:10: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LCURLY"

    // $ANTLR start "RCURLY"
    public final void mRCURLY() throws RecognitionException {
        try {
            int _type = RCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:79:8: ( '}' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:79:10: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RCURLY"

    // $ANTLR start "STRUCT"
    public final void mSTRUCT() throws RecognitionException {
        try {
            int _type = STRUCT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:80:9: ( 'struct' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:80:11: 'struct'
            {
            match("struct"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRUCT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:83:2: ( 'A' .. 'Z' | 'a' .. 'z' | '_' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:89:2: ( LETTER ( LETTER | '0' .. '9' )* )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:89:4: LETTER ( LETTER | '0' .. '9' )*
            {
            mLETTER(); 
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:89:11: ( LETTER | '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:93:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:93:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:93:14: ( options {greedy=false; } : . )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='*') ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1=='/') ) {
                        alt2=2;
                    }
                    else if ( ((LA2_1>='\u0000' && LA2_1<='.')||(LA2_1>='0' && LA2_1<='\uFFFF')) ) {
                        alt2=1;
                    }


                }
                else if ( ((LA2_0>='\u0000' && LA2_0<=')')||(LA2_0>='+' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:93:42: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match("*/"); 

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:97:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:97:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:97:12: (~ ( '\\n' | '\\r' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:97:12: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:97:26: ( '\\r' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\r') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:97:26: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LINE_COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:100:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:100:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | SEMI | LCURLY | RCURLY | STRUCT | ID | COMMENT | LINE_COMMENT | WS )
        int alt5=15;
        alt5 = dfa5.predict(input);
        switch (alt5) {
            case 1 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:1:52: SEMI
                {
                mSEMI(); 

                }
                break;
            case 9 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:1:57: LCURLY
                {
                mLCURLY(); 

                }
                break;
            case 10 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:1:64: RCURLY
                {
                mRCURLY(); 

                }
                break;
            case 11 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:1:71: STRUCT
                {
                mSTRUCT(); 

                }
                break;
            case 12 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:1:78: ID
                {
                mID(); 

                }
                break;
            case 13 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:1:81: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 14 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:1:89: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;
            case 15 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-struct-AST-heterogeneous/Struct.g:1:102: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\1\uffff\7\13\6\uffff\10\13\2\uffff\4\13\1\44\3\13\1\50\1\51\2\13"+
        "\1\uffff\1\54\2\13\2\uffff\1\57\1\13\1\uffff\1\61\1\13\1\uffff\1"+
        "\63\1\uffff\1\64\2\uffff";
    static final String DFA5_eofS =
        "\65\uffff";
    static final String DFA5_minS =
        "\1\11\1\157\2\150\1\156\1\157\1\154\1\157\4\uffff\1\52\1\uffff\1"+
        "\151\1\141\1\157\1\162\1\164\1\156\1\157\1\165\2\uffff\1\144\2\162"+
        "\1\165\1\60\1\147\1\141\1\142\2\60\1\164\1\143\1\uffff\1\60\1\164"+
        "\1\154\2\uffff\1\60\1\164\1\uffff\1\60\1\145\1\uffff\1\60\1\uffff"+
        "\1\60\2\uffff";
    static final String DFA5_maxS =
        "\1\175\1\157\1\150\1\164\1\156\1\157\1\154\1\157\4\uffff\1\57\1"+
        "\uffff\1\151\1\141\1\157\1\162\1\164\1\156\1\157\1\165\2\uffff\1"+
        "\144\2\162\1\165\1\172\1\147\1\141\1\142\2\172\1\164\1\143\1\uffff"+
        "\1\172\1\164\1\154\2\uffff\1\172\1\164\1\uffff\1\172\1\145\1\uffff"+
        "\1\172\1\uffff\1\172\2\uffff";
    static final String DFA5_acceptS =
        "\10\uffff\1\10\1\11\1\12\1\14\1\uffff\1\17\10\uffff\1\15\1\16\14"+
        "\uffff\1\4\3\uffff\1\1\1\2\2\uffff\1\5\2\uffff\1\3\1\uffff\1\6\1"+
        "\uffff\1\13\1\7";
    static final String DFA5_specialS =
        "\65\uffff}>";
    static final String[] DFA5_transitionS = {
            "\2\15\1\uffff\2\15\22\uffff\1\15\16\uffff\1\14\13\uffff\1\10"+
            "\5\uffff\32\13\4\uffff\1\13\1\uffff\2\13\1\2\1\7\1\13\1\6\2"+
            "\13\1\4\2\13\1\5\6\13\1\3\2\13\1\1\4\13\1\11\1\uffff\1\12",
            "\1\16",
            "\1\17",
            "\1\20\13\uffff\1\21",
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\25",
            "",
            "",
            "",
            "",
            "\1\26\4\uffff\1\27",
            "",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "",
            "",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43",
            "\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
            "\1\45",
            "\1\46",
            "\1\47",
            "\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
            "\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
            "\1\52",
            "\1\53",
            "",
            "\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
            "\1\55",
            "\1\56",
            "",
            "",
            "\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
            "\1\60",
            "",
            "\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
            "\1\62",
            "",
            "\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
            "",
            "\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | SEMI | LCURLY | RCURLY | STRUCT | ID | COMMENT | LINE_COMMENT | WS );";
        }
    }
 

}