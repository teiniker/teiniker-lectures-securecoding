// $ANTLR 3.3 Nov 30, 2010 12:50:56 /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g 2012-03-15 16:42:13
 package org.se.lab; 

import org.antlr.runtime.CharStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

public class XmlLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int STRING=4;
    public static final int LETTER=5;
    public static final int COMMENT=6;
    public static final int WS=7;

    // delegates
    // delegators

    public XmlLexer() {;} 
    public XmlLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public XmlLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g"; }

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:5:6: ( '<' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:5:8: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:6:6: ( '>' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:6:8: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:7:7: ( '</' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:7:9: '</'
            {
            match("</"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:53:2: ( 'A' .. 'Z' | 'a' .. 'z' | '_' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:
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

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:59:2: ( ( LETTER | '0' .. '9' )* )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:59:4: ( LETTER | '0' .. '9' )*
            {
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:59:4: ( LETTER | '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:
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
    // $ANTLR end "STRING"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:63:5: ( '<--' ( options {greedy=false; } : . )* '-->' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:63:9: '<--' ( options {greedy=false; } : . )* '-->'
            {
            match("<--"); 

            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:63:15: ( options {greedy=false; } : . )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='-') ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1=='-') ) {
                        int LA2_3 = input.LA(3);

                        if ( (LA2_3=='>') ) {
                            alt2=2;
                        }
                        else if ( ((LA2_3>='\u0000' && LA2_3<='=')||(LA2_3>='?' && LA2_3<='\uFFFF')) ) {
                            alt2=1;
                        }


                    }
                    else if ( ((LA2_1>='\u0000' && LA2_1<=',')||(LA2_1>='.' && LA2_1<='\uFFFF')) ) {
                        alt2=1;
                    }


                }
                else if ( ((LA2_0>='\u0000' && LA2_0<=',')||(LA2_0>='.' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:63:43: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match("-->"); 

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:66:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:66:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
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
        // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:1:8: ( T__8 | T__9 | T__10 | STRING | COMMENT | WS )
        int alt3=6;
        switch ( input.LA(1) ) {
        case '<':
            {
            switch ( input.LA(2) ) {
            case '/':
                {
                alt3=3;
                }
                break;
            case '-':
                {
                alt3=5;
                }
                break;
            default:
                alt3=1;}

            }
            break;
        case '>':
            {
            alt3=2;
            }
            break;
        case '\t':
        case '\n':
        case '\f':
        case '\r':
        case ' ':
            {
            alt3=6;
            }
            break;
        default:
            alt3=4;}

        switch (alt3) {
            case 1 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:1:10: T__8
                {
                mT__8(); 

                }
                break;
            case 2 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:1:15: T__9
                {
                mT__9(); 

                }
                break;
            case 3 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:1:20: T__10
                {
                mT__10(); 

                }
                break;
            case 4 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:1:26: STRING
                {
                mSTRING(); 

                }
                break;
            case 5 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:1:33: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 6 :
                // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:1:41: WS
                {
                mWS(); 

                }
                break;

        }

    }


 

}