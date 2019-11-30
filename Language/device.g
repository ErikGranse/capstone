class P extends Parser;

startRule   : cmnd;

cmnd		:(rateRule
			|modeRule
			|avdRule
			|numRule)+
            ;

rateRule
			: r:RATE
			{System.out.println("Pace " + r.getText());
			}
			;
			
modeRule 
			: m:MODE
			{System.out.println("Pace " + m.getText());
			}
			;

avdRule 
			: a:AVD
			{System.out.println("Pace " + a.getText());
			}
			;
			
numRule 
			: n:NUM
			{
			String temp = n.getText();
			int k = Integer.parseInt(temp.substring(4));
			System.out.println("num = " + k*2);
			}
			;
			
			
class L extends Lexer;

options {
    k=4; // needed for newline junk
    charVocabulary='\u0000'..'\u007F'; // allow ascii
}


RATE:   ( 'r'|'R' ) ( 'a'|'A' ) ( 't'|'T' ) ( 'e'|'E' ) WS INT;

MODE:   ( 'm'|'M' ) ( 'o'|'O' ) ( 'd'|'D' ) ( 'e'|'E' ) WS MODETYPE;

AVD:   ( 'a'|'A' ) ( 'v'|'V' ) ( 'd'|'D' ) WS INT;

NUM:   ( 'n'|'N' ) ( 'u'|'U' ) ( 'm'|'M' ) WS INT;

INT: ('0'..'9')+ ;



MODETYPE:  ( 'v'|'V' ) ( 'o'|'O' ) ( 'o'|'O' )
		 | ( 'v'|'V' ) ( 'v'|'V' ) ( 'i'|'I' )
		 | ( 'v'|'V' ) ( 'v'|'V' ) ( 't'|'T' )
		 ;

WS    : ( ' '
        | '\r' '\n'
        | '\n'
        | '\t'
        )
        {$setType(Token.SKIP);}
    ;


