// $ANTLR 3.3 Nov 30, 2010 12:50:56 /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g 2012-03-30 11:08:27
 package org.se.lab; 

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

public class OperationLexer extends Lexer {
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

    public OperationLexer() {;} 
    public OperationLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public OperationLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:5:7: ( 'void' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:5:9: 'void'
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
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:6:7: ( 'char' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:6:9: 'char'
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
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:7:7: ( 'short' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:7:9: 'short'
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
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:8:7: ( 'int' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:8:9: 'int'
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
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:9:7: ( 'long' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:9:9: 'long'
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
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:10:7: ( 'float' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:10:9: 'float'
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
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:11:7: ( 'double' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:11:9: 'double'
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

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:68:7: ( ',' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:68:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:69:6: ( ';' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:69:8: ';'
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

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:70:8: ( '(' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:70:10: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:71:8: ( ')' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:71:10: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:75:2: ( 'A' .. 'Z' | 'a' .. 'z' | '_' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:
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

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:81:2: ( LETTER ( LETTER | '0' .. '9' )* )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:81:4: LETTER ( LETTER | '0' .. '9' )*
            {
            mLETTER(); 
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:81:11: ( LETTER | '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:
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
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:85:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:85:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:85:14: ( options {greedy=false; } : . )*
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
            	    // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:85:42: .
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
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:89:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:89:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:89:12: (~ ( '\\n' | '\\r' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='\t')||(LA3_0>='\u000B' && LA3_0<='\f')||(LA3_0>='\u000E' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:89:12: ~ ( '\\n' | '\\r' )
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

            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:89:26: ( '\\r' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\r') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:89:26: '\\r'
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
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:92:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:92:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
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
        // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | COMMA | SEMI | LPAREN | RPAREN | IDENTIFIER | COMMENT | LINE_COMMENT | WS )
        int alt5=15;
        alt5 = dfa5.predict(input);
        switch (alt5) {
            case 1 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:1:52: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 9 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:1:58: SEMI
                {
                mSEMI(); 

                }
                break;
            case 10 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:1:63: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 11 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:1:70: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 12 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:1:77: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;
            case 13 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:1:88: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 14 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:1:96: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;
            case 15 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-operation-AST-heterogeneous/Operation.g:1:109: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\1\uffff\7\14\7\uffff\7\14\2\uffff\3\14\1\42\3\14\1\46\1\47\1\14"+
        "\1\uffff\1\51\2\14\2\uffff\1\54\1\uffff\1\55\1\14\2\uffff\1\57\1"+
        "\uffff";
    static final String DFA5_eofS =
        "\60\uffff";
    static final String DFA5_minS =
        "\1\11\1\157\2\150\1\156\1\157\1\154\1\157\5\uffff\1\52\1\uffff\1"+
        "\151\1\141\1\157\1\164\1\156\1\157\1\165\2\uffff\1\144\2\162\1\60"+
        "\1\147\1\141\1\142\2\60\1\164\1\uffff\1\60\1\164\1\154\2\uffff\1"+
        "\60\1\uffff\1\60\1\145\2\uffff\1\60\1\uffff";
    static final String DFA5_maxS =
        "\1\172\1\157\2\150\1\156\1\157\1\154\1\157\5\uffff\1\57\1\uffff"+
        "\1\151\1\141\1\157\1\164\1\156\1\157\1\165\2\uffff\1\144\2\162\1"+
        "\172\1\147\1\141\1\142\2\172\1\164\1\uffff\1\172\1\164\1\154\2\uffff"+
        "\1\172\1\uffff\1\172\1\145\2\uffff\1\172\1\uffff";
    static final String DFA5_acceptS =
        "\10\uffff\1\10\1\11\1\12\1\13\1\14\1\uffff\1\17\7\uffff\1\15\1\16"+
        "\12\uffff\1\4\3\uffff\1\1\1\2\1\uffff\1\5\2\uffff\1\3\1\6\1\uffff"+
        "\1\7";
    static final String DFA5_specialS =
        "\60\uffff}>";
    static final String[] DFA5_transitionS = {
            "\2\16\1\uffff\2\16\22\uffff\1\16\7\uffff\1\12\1\13\2\uffff\1"+
            "\10\2\uffff\1\15\13\uffff\1\11\5\uffff\32\14\4\uffff\1\14\1"+
            "\uffff\2\14\1\2\1\7\1\14\1\6\2\14\1\4\2\14\1\5\6\14\1\3\2\14"+
            "\1\1\4\14",
            "\1\17",
            "\1\20",
            "\1\21",
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\25",
            "",
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
            "",
            "",
            "\1\37",
            "\1\40",
            "\1\41",
            "\12\14\7\uffff\32\14\4\uffff\1\14\1\uffff\32\14",
            "\1\43",
            "\1\44",
            "\1\45",
            "\12\14\7\uffff\32\14\4\uffff\1\14\1\uffff\32\14",
            "\12\14\7\uffff\32\14\4\uffff\1\14\1\uffff\32\14",
            "\1\50",
            "",
            "\12\14\7\uffff\32\14\4\uffff\1\14\1\uffff\32\14",
            "\1\52",
            "\1\53",
            "",
            "",
            "\12\14\7\uffff\32\14\4\uffff\1\14\1\uffff\32\14",
            "",
            "\12\14\7\uffff\32\14\4\uffff\1\14\1\uffff\32\14",
            "\1\56",
            "",
            "",
            "\12\14\7\uffff\32\14\4\uffff\1\14\1\uffff\32\14",
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
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | COMMA | SEMI | LPAREN | RPAREN | IDENTIFIER | COMMENT | LINE_COMMENT | WS );";
        }
    }
 

}