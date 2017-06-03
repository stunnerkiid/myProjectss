

public class Run{
	  public static void main(String[] args){
	    
	    Lexer lexObject = new Lexer();
	    Token myToken;
	    do{
	      myToken = lexObject.nextToken(); 
	      System.out.println("Line: " + myToken.line + ","
	      		+ "spelling = [" + myToken.spelling + "], " + "kind = " + 
	    		  myToken.kind);
	    }while(myToken.kind != Token.EOT);
	  }
	}
