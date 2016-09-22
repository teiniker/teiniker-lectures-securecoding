// $ANTLR 3.3 Nov 30, 2010 12:50:56 /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g 2012-03-15 16:42:13
 package org.se.lab; 

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

public class XmlParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "STRING", "LETTER", "COMMENT", "WS", "'<'", "'>'", "'</'"
    };
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


        public XmlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public XmlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return XmlParser.tokenNames; }
    public String getGrammarFileName() { return "/home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g"; }



    // $ANTLR start "xml"
    // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:8:1: xml returns [XmlElement xml] : ( element | open_tag element_list close_tag );
    public final XmlElement xml() throws RecognitionException {
        XmlElement xml = null;

        XmlElement element1 = null;

        String open_tag2 = null;

        String close_tag3 = null;

        List<XmlElement> element_list4 = null;


        try {
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:9:3: ( element | open_tag element_list close_tag )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==8) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==STRING) ) {
                    int LA1_2 = input.LA(3);

                    if ( (LA1_2==9) ) {
                        int LA1_3 = input.LA(4);

                        if ( (LA1_3==STRING) ) {
                            alt1=1;
                        }
                        else if ( (LA1_3==8) ) {
                            alt1=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 1, 3, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:9:5: element
                    {
                    pushFollow(FOLLOW_element_in_xml35);
                    element1=element();

                    state._fsp--;


                          xml = element1;
                        

                    }
                    break;
                case 2 :
                    // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:13:5: open_tag element_list close_tag
                    {
                    pushFollow(FOLLOW_open_tag_in_xml47);
                    open_tag2=open_tag();

                    state._fsp--;

                    pushFollow(FOLLOW_element_list_in_xml49);
                    element_list4=element_list();

                    state._fsp--;

                    pushFollow(FOLLOW_close_tag_in_xml51);
                    close_tag3=close_tag();

                    state._fsp--;


                          if(!open_tag2.equals(close_tag3))
                            throw new IllegalStateException("Element <" + open_tag2 +"> is NOT well formed!");
                          xml = new XmlElement(open_tag2); 
                          xml.setElements(element_list4);
                        

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return xml;
    }
    // $ANTLR end "xml"


    // $ANTLR start "element_list"
    // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:23:1: element_list returns [List<XmlElement> list] : ( element )+ ;
    public final List<XmlElement> element_list() throws RecognitionException {
        List<XmlElement> list = null;

        XmlElement element5 = null;



          list = new ArrayList<XmlElement>();

        try {
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:28:3: ( ( element )+ )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:28:5: ( element )+
            {
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:28:5: ( element )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==8) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:28:6: element
            	    {
            	    pushFollow(FOLLOW_element_in_element_list86);
            	    element5=element();

            	    state._fsp--;

            	    list.add(element5);

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
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
    // $ANTLR end "element_list"


    // $ANTLR start "element"
    // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:32:1: element returns [XmlElement xml] : open_tag STRING close_tag ;
    public final XmlElement element() throws RecognitionException {
        XmlElement xml = null;

        Token STRING8=null;
        String open_tag6 = null;

        String close_tag7 = null;


        try {
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:33:2: ( open_tag STRING close_tag )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:33:4: open_tag STRING close_tag
            {
            pushFollow(FOLLOW_open_tag_in_element110);
            open_tag6=open_tag();

            state._fsp--;

            STRING8=(Token)match(input,STRING,FOLLOW_STRING_in_element112); 
            pushFollow(FOLLOW_close_tag_in_element114);
            close_tag7=close_tag();

            state._fsp--;


                  if(!open_tag6.equals(close_tag7))
                    throw new IllegalStateException("Element <" + open_tag6 +"> is NOT well formed!");
            	    xml = new XmlElement(open_tag6, (STRING8!=null?STRING8.getText():null));
            	  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return xml;
    }
    // $ANTLR end "element"


    // $ANTLR start "open_tag"
    // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:41:1: open_tag returns [String s] : '<' STRING '>' ;
    public final String open_tag() throws RecognitionException {
        String s = null;

        Token STRING9=null;

        try {
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:42:2: ( '<' STRING '>' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:42:4: '<' STRING '>'
            {
            match(input,8,FOLLOW_8_in_open_tag135); 
            STRING9=(Token)match(input,STRING,FOLLOW_STRING_in_open_tag137); 
             s = (STRING9!=null?STRING9.getText():null); 
            match(input,9,FOLLOW_9_in_open_tag141); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "open_tag"


    // $ANTLR start "close_tag"
    // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:45:1: close_tag returns [String s] : '</' STRING '>' ;
    public final String close_tag() throws RecognitionException {
        String s = null;

        Token STRING10=null;

        try {
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:46:3: ( '</' STRING '>' )
            // /home/student/work/workspace-ss2012-ase10/antlr-parser-xml-solution/Xml.g:46:5: '</' STRING '>'
            {
            match(input,10,FOLLOW_10_in_close_tag161); 
            STRING10=(Token)match(input,STRING,FOLLOW_STRING_in_close_tag163); 
             s = (STRING10!=null?STRING10.getText():null); 
            match(input,9,FOLLOW_9_in_close_tag167); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "close_tag"

    // Delegated rules


 

    public static final BitSet FOLLOW_element_in_xml35 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_open_tag_in_xml47 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_element_list_in_xml49 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_close_tag_in_xml51 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_in_element_list86 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_open_tag_in_element110 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_STRING_in_element112 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_close_tag_in_element114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_8_in_open_tag135 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_STRING_in_open_tag137 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_open_tag141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_close_tag161 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_STRING_in_close_tag163 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_close_tag167 = new BitSet(new long[]{0x0000000000000002L});

}