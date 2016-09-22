// $ANTLR 3.5 /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g 2016-01-28 17:14:03
 package org.se.lab; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class LexerExample extends Lexer {
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int ASSIGN=5;
	public static final int COLON=6;
	public static final int COMMA=7;
	public static final int COMMENT=8;
	public static final int DIV=9;
	public static final int DOT=10;
	public static final int GT=11;
	public static final int ID=12;
	public static final int LBRACK=13;
	public static final int LCURLY=14;
	public static final int LETTER=15;
	public static final int LINE_COMMENT=16;
	public static final int LPAREN=17;
	public static final int LSHIFT=18;
	public static final int LT=19;
	public static final int MINUS=20;
	public static final int MOD=21;
	public static final int NOT=22;
	public static final int OR=23;
	public static final int PLUS=24;
	public static final int QUESTION=25;
	public static final int RBRACK=26;
	public static final int RCURLY=27;
	public static final int RPAREN=28;
	public static final int RSHIFT=29;
	public static final int SEMI=30;
	public static final int STAR=31;
	public static final int TILDE=32;
	public static final int WS=33;
	public static final int XOR=34;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public LexerExample() {} 
	public LexerExample(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public LexerExample(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g"; }

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:10:2: ( LETTER ( LETTER | '0' .. '9' )* )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:10:4: LETTER ( LETTER | '0' .. '9' )*
			{
			mLETTER(); 

			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:10:11: ( LETTER | '0' .. '9' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:15:2: ( 'A' .. 'Z' | 'a' .. 'z' | '_' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETTER"

	// $ANTLR start "SEMI"
	public final void mSEMI() throws RecognitionException {
		try {
			int _type = SEMI;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:20:6: ( ';' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:20:8: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMI"

	// $ANTLR start "QUESTION"
	public final void mQUESTION() throws RecognitionException {
		try {
			int _type = QUESTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:21:9: ( '?' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:21:11: '?'
			{
			match('?'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QUESTION"

	// $ANTLR start "LPAREN"
	public final void mLPAREN() throws RecognitionException {
		try {
			int _type = LPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:22:8: ( '(' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:22:10: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAREN"

	// $ANTLR start "RPAREN"
	public final void mRPAREN() throws RecognitionException {
		try {
			int _type = RPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:23:8: ( ')' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:23:10: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAREN"

	// $ANTLR start "LBRACK"
	public final void mLBRACK() throws RecognitionException {
		try {
			int _type = LBRACK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:24:8: ( '[' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:24:10: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LBRACK"

	// $ANTLR start "RBRACK"
	public final void mRBRACK() throws RecognitionException {
		try {
			int _type = RBRACK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:25:8: ( ']' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:25:10: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RBRACK"

	// $ANTLR start "LCURLY"
	public final void mLCURLY() throws RecognitionException {
		try {
			int _type = LCURLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:26:8: ( '{' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:26:10: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LCURLY"

	// $ANTLR start "RCURLY"
	public final void mRCURLY() throws RecognitionException {
		try {
			int _type = RCURLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:27:8: ( '}' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:27:10: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RCURLY"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:28:5: ( '|' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:28:7: '|'
			{
			match('|'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "XOR"
	public final void mXOR() throws RecognitionException {
		try {
			int _type = XOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:29:6: ( '^' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:29:8: '^'
			{
			match('^'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "XOR"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:30:6: ( '&' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:30:8: '&'
			{
			match('&'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:31:7: ( ':' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:31:9: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:32:7: ( ',' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:32:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "DOT"
	public final void mDOT() throws RecognitionException {
		try {
			int _type = DOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:33:6: ( '.' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:33:8: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOT"

	// $ANTLR start "ASSIGN"
	public final void mASSIGN() throws RecognitionException {
		try {
			int _type = ASSIGN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:34:8: ( '=' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:34:10: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASSIGN"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:35:6: ( '!' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:35:8: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "LT"
	public final void mLT() throws RecognitionException {
		try {
			int _type = LT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:36:5: ( '<' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:36:7: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LT"

	// $ANTLR start "GT"
	public final void mGT() throws RecognitionException {
		try {
			int _type = GT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:37:5: ( '>' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:37:7: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GT"

	// $ANTLR start "DIV"
	public final void mDIV() throws RecognitionException {
		try {
			int _type = DIV;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:38:6: ( '/' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:38:8: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIV"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:39:6: ( '+' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:39:8: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:40:7: ( '-' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:40:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "TILDE"
	public final void mTILDE() throws RecognitionException {
		try {
			int _type = TILDE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:41:7: ( '~' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:41:9: '~'
			{
			match('~'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TILDE"

	// $ANTLR start "STAR"
	public final void mSTAR() throws RecognitionException {
		try {
			int _type = STAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:42:6: ( '*' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:42:8: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STAR"

	// $ANTLR start "MOD"
	public final void mMOD() throws RecognitionException {
		try {
			int _type = MOD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:43:6: ( '%' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:43:8: '%'
			{
			match('%'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MOD"

	// $ANTLR start "LSHIFT"
	public final void mLSHIFT() throws RecognitionException {
		try {
			int _type = LSHIFT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:44:8: ( '<<' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:44:10: '<<'
			{
			match("<<"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LSHIFT"

	// $ANTLR start "RSHIFT"
	public final void mRSHIFT() throws RecognitionException {
		try {
			int _type = RSHIFT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:45:8: ( '>>' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:45:10: '>>'
			{
			match(">>"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RSHIFT"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:48:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:48:9: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:48:14: ( options {greedy=false; } : . )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0=='*') ) {
					int LA2_1 = input.LA(2);
					if ( (LA2_1=='/') ) {
						alt2=2;
					}
					else if ( ((LA2_1 >= '\u0000' && LA2_1 <= '.')||(LA2_1 >= '0' && LA2_1 <= '\uFFFF')) ) {
						alt2=1;
					}

				}
				else if ( ((LA2_0 >= '\u0000' && LA2_0 <= ')')||(LA2_0 >= '+' && LA2_0 <= '\uFFFF')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:48:42: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop2;
				}
			}

			match("*/"); 

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "LINE_COMMENT"
	public final void mLINE_COMMENT() throws RecognitionException {
		try {
			int _type = LINE_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:52:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:52:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
			{
			match("//"); 

			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:52:12: (~ ( '\\n' | '\\r' ) )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '\uFFFF')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop3;
				}
			}

			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:52:26: ( '\\r' )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='\r') ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:52:26: '\\r'
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
			// do for sure before leaving
		}
	}
	// $ANTLR end "LINE_COMMENT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:55:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
			// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:55:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
			{
			if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:8: ( ID | SEMI | QUESTION | LPAREN | RPAREN | LBRACK | RBRACK | LCURLY | RCURLY | OR | XOR | AND | COLON | COMMA | DOT | ASSIGN | NOT | LT | GT | DIV | PLUS | MINUS | TILDE | STAR | MOD | LSHIFT | RSHIFT | COMMENT | LINE_COMMENT | WS )
		int alt5=30;
		switch ( input.LA(1) ) {
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
		case 'G':
		case 'H':
		case 'I':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
		case 'T':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
		case '_':
		case 'a':
		case 'b':
		case 'c':
		case 'd':
		case 'e':
		case 'f':
		case 'g':
		case 'h':
		case 'i':
		case 'j':
		case 'k':
		case 'l':
		case 'm':
		case 'n':
		case 'o':
		case 'p':
		case 'q':
		case 'r':
		case 's':
		case 't':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt5=1;
			}
			break;
		case ';':
			{
			alt5=2;
			}
			break;
		case '?':
			{
			alt5=3;
			}
			break;
		case '(':
			{
			alt5=4;
			}
			break;
		case ')':
			{
			alt5=5;
			}
			break;
		case '[':
			{
			alt5=6;
			}
			break;
		case ']':
			{
			alt5=7;
			}
			break;
		case '{':
			{
			alt5=8;
			}
			break;
		case '}':
			{
			alt5=9;
			}
			break;
		case '|':
			{
			alt5=10;
			}
			break;
		case '^':
			{
			alt5=11;
			}
			break;
		case '&':
			{
			alt5=12;
			}
			break;
		case ':':
			{
			alt5=13;
			}
			break;
		case ',':
			{
			alt5=14;
			}
			break;
		case '.':
			{
			alt5=15;
			}
			break;
		case '=':
			{
			alt5=16;
			}
			break;
		case '!':
			{
			alt5=17;
			}
			break;
		case '<':
			{
			int LA5_18 = input.LA(2);
			if ( (LA5_18=='<') ) {
				alt5=26;
			}

			else {
				alt5=18;
			}

			}
			break;
		case '>':
			{
			int LA5_19 = input.LA(2);
			if ( (LA5_19=='>') ) {
				alt5=27;
			}

			else {
				alt5=19;
			}

			}
			break;
		case '/':
			{
			switch ( input.LA(2) ) {
			case '*':
				{
				alt5=28;
				}
				break;
			case '/':
				{
				alt5=29;
				}
				break;
			default:
				alt5=20;
			}
			}
			break;
		case '+':
			{
			alt5=21;
			}
			break;
		case '-':
			{
			alt5=22;
			}
			break;
		case '~':
			{
			alt5=23;
			}
			break;
		case '*':
			{
			alt5=24;
			}
			break;
		case '%':
			{
			alt5=25;
			}
			break;
		case '\t':
		case '\n':
		case '\f':
		case '\r':
		case ' ':
			{
			alt5=30;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 5, 0, input);
			throw nvae;
		}
		switch (alt5) {
			case 1 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:10: ID
				{
				mID(); 

				}
				break;
			case 2 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:13: SEMI
				{
				mSEMI(); 

				}
				break;
			case 3 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:18: QUESTION
				{
				mQUESTION(); 

				}
				break;
			case 4 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:27: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 5 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:34: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 6 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:41: LBRACK
				{
				mLBRACK(); 

				}
				break;
			case 7 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:48: RBRACK
				{
				mRBRACK(); 

				}
				break;
			case 8 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:55: LCURLY
				{
				mLCURLY(); 

				}
				break;
			case 9 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:62: RCURLY
				{
				mRCURLY(); 

				}
				break;
			case 10 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:69: OR
				{
				mOR(); 

				}
				break;
			case 11 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:72: XOR
				{
				mXOR(); 

				}
				break;
			case 12 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:76: AND
				{
				mAND(); 

				}
				break;
			case 13 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:80: COLON
				{
				mCOLON(); 

				}
				break;
			case 14 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:86: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 15 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:92: DOT
				{
				mDOT(); 

				}
				break;
			case 16 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:96: ASSIGN
				{
				mASSIGN(); 

				}
				break;
			case 17 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:103: NOT
				{
				mNOT(); 

				}
				break;
			case 18 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:107: LT
				{
				mLT(); 

				}
				break;
			case 19 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:110: GT
				{
				mGT(); 

				}
				break;
			case 20 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:113: DIV
				{
				mDIV(); 

				}
				break;
			case 21 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:117: PLUS
				{
				mPLUS(); 

				}
				break;
			case 22 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:122: MINUS
				{
				mMINUS(); 

				}
				break;
			case 23 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:128: TILDE
				{
				mTILDE(); 

				}
				break;
			case 24 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:134: STAR
				{
				mSTAR(); 

				}
				break;
			case 25 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:139: MOD
				{
				mMOD(); 

				}
				break;
			case 26 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:143: LSHIFT
				{
				mLSHIFT(); 

				}
				break;
			case 27 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:150: RSHIFT
				{
				mRSHIFT(); 

				}
				break;
			case 28 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:157: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 29 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:165: LINE_COMMENT
				{
				mLINE_COMMENT(); 

				}
				break;
			case 30 :
				// /home/student/workspace-2015ws-ims15-SWSecurity/Lexer-Antlr/src/test/resources/LexerExample.g:1:178: WS
				{
				mWS(); 

				}
				break;

		}
	}



}
