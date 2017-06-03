public class Token{
  public byte kind;
  public String spelling;
  int line;

  public Token(byte currentKind, String spelling, int line){
    this.kind = currentKind;
    this.spelling = spelling;
    this.line = line;
    if(currentKind == IDENTIFIER)
      for(int k = ARRAY; k <= WRITE; k++)
        if(spelling.equals(spellings[k])){
          this.kind = (byte)k;
          break;
        }
  }

  public final static byte
    IDENTIFIER  = 0,
    INTLITERAL  = 1,
    ARRAY       = 2,          //array
    BEGIN       = 3,          //begin
    BOOLEAN     = 4,          //boolean
    CALL        = 5,          //call
    CONST       = 6,          //const
    DO          = 7,          //do
    END         = 8,          //end
    FALSE       = 9,          //false
    FI          = 10,         //fi
    IF          = 11,         //if
    INTEGER     = 12,         //integer
    OD          = 13,         //od
    PROC        = 14,         //proc
    READ        = 15,         //read
    SKIP        = 16,         //skip
    TRUE        = 17,         //true
    WRITE       = 18,         //write

    AND         = 19,          //&
    ARROW       = 20,         //->
    ASTERISK    = 21,         //*
    BECOMES     = 22,         //:=
    COMMA       = 23,         //,
    DIV         = 24,         // /
    GUARD       = 25,         //[]
    EOT         = 26,         //end of text
    EQUAL       = 27,         //=
    GREATER     = 28,         //>
    LBRACKET    = 29,         //[
    LPAREN      = 30,         //(
    LESS        = 31,         //<
    MINUS       = 32,         // -
    MOD         = 33,         // \
    NOT         = 34,         //~
    OR          = 35,         //|
    PERIOD      = 36,         //.
    PLUS        = 37,         // +
    RBRACKET    = 38,         //]
    RPAREN      = 39,         //)
    SEMICOLON   = 40,         //;
    LITERAL     = 41,         //,;
    TIMES       = 42,		  //*;
    NOTHING		= 43,
    DIVIDE 		= 44,
    LEQ 		= 45, 
    GEQ			= 46,
    NEQ 		= 47,
    EQ 			= 48;
  

  private final static String[] spellings = {
    "<identifier>",
    "<intliteral>",
    "array",
    "begin",
    "boolean",
    "call",
    "const",
    "do",
    "end",
    "false",
    "fi",
    "if",
    "integer",
    "od",
    "proc",
    "read",
    "skip",
    "true",
    "write",
  };
}