import java.io.*;
import java.util.Scanner;

public class Lexer{
  static char currentChar;
   static int line = 1;
  static BufferedReader inFile = null;
  static StringBuffer currentSpelling;
  static int currentKind;
  
public static void main (String[] args){
	try{
    	  System.out.print("Enter the file name: ");
    	  Scanner keyboard = new Scanner(System.in);
    	  String FileName = keyboard.next();
    	  inFile = new BufferedReader(new FileReader(FileName));
          int i = inFile.read();
          if(i == -1) //end of file
            currentChar = '\u0000';
          else
            currentChar = (char)i;
    	  takeIt();
    	  keyboard.close();
      }catch(Exception e){}
     
  }
  
  static void takeIt(){
    currentSpelling.append(currentChar);
    try{
    	int i = (int)inFile.read();
    	if(i == -1) //end of file
    		currentChar = '\u0000';
    	else
    		currentChar = (char)i;
    }catch(Exception e){}     
  }

  static void discard(){
    try{
	int i = (int)inFile.read();
	if(i == -1) //end of file
		currentChar = '\u0000';
	else
	    	currentChar = (char)i;
    }catch(Exception e){}
  }

  static int scanToken(){
    switch(currentChar){
      case 'a': case 'b': case 'c': case 'd': case 'e': case 'f': 
      case 'g': case 'h': case 'i': case 'j': case 'k': case 'l': 
      case 'm': case 'n': case 'o': case 'p': case 'q': case 'r':
      case 's': case 't': case 'u': case 'v': case 'w': case 'x': 
      case 'y': case 'z':
      case 'A': case 'B': case 'C': case 'D': case 'E': case 'F': 
      case 'G': case 'H': case 'I': case 'J': case 'K': case 'L': 
      case 'M': case 'N': case 'O': case 'P': case 'Q': case 'R':
      case 'S': case 'T': case 'U': case 'V': case 'W': case 'X': 
      case 'Y': case 'Z':
        takeIt();
        while(isLetter(currentChar) || isDigit(currentChar))
          takeIt();
        return Token.IDENTIFIER;
      case '0': case '1': case '2': case '3': case '4':
      case '5': case '6': case '7': case '8': case '9':
        takeIt();
        while(isDigit(currentChar))
          takeIt();
        return Token.INTLITERAL;
      case '+': takeIt(); return Token.PLUS; 
      case '*': takeIt(); return Token.ASTERISK;
      case '(': takeIt(); return Token.LPAREN;
      case ')': takeIt(); return Token.RPAREN;
      case '\\': takeIt(); return Token.MOD;
      case ']': takeIt(); return Token.RBRACKET;
      case '.': takeIt(); return Token.PERIOD;
      case ';': takeIt(); return Token.SEMICOLON;
      case ',': takeIt(); return Token.COMMA;
      case '\u0000': takeIt(); return Token.EOT;    	  
      case '-': 
      takeIt();  
    	  if(currentChar == '>'){
                takeIt();
                return Token.ARROW;
            }
            return Token.MINUS;
           
            case '/':
            takeIt();
            return Token.DIV;
            case '<':
            takeIt();
          
            return Token.LESS;
            case '>':
            takeIt();
          
            return Token.GREATER;
            case '~':
            takeIt();
           
            return Token.NOT;
            case ':':
            takeIt();
            if(currentChar == '='){
                takeIt();
                return Token.BECOMES;
            }
            new Error("Error: The symbol : is not a token", line);
            return Token.NOTHING;
            case '=':
            takeIt();
            return Token.EQUAL;
            case '&':
            takeIt();
         
            return Token.AND;
            case '|':
            takeIt();
         
            return Token.OR;
            
            case '$':
                takeIt(); 
                line++;
                while(currentChar != '\n' && currentChar != '\u0000')
                    discard();
                if(currentChar == '\n')
                    discard();
                return Token.NOTHING;
                
            case '[':
            takeIt();
            if(currentChar == ']'){
                takeIt();
                return Token.GUARD;
            }
            else{
                return Token.LBRACKET;
            }
            default:
            new Error("Error: The symbol " + currentChar + " is not a token", line);
            return Token.NOTHING;
        }
    }

  static void scanEscapeCharacters(){
    switch(currentChar){
      case ' ': case '\n': case '\r': case '\t':
        if(currentChar == '\n')
          line++;
        discard();
    }
  }

  static Token nextToken(){
    currentSpelling = new StringBuffer("");
    while(currentChar == ' ' || currentChar == '\n' || 
      currentChar == '\r' || currentChar == '\t')
      scanEscapeCharacters();
    currentKind = scanToken();
    if(currentKind == Token.NOTHING)
    	nextToken();
    return new Token((byte) currentKind, currentSpelling.toString(), line);
  }

  static boolean isDigit(char c){
    return '0' <= c && c <= '9';
  }

  static boolean isLetter(char c){
    return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
  }
}

