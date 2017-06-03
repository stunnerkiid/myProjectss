public class Parser{
	  private Token currentToken;
	  private Lexer scanner;

	  private void accept(byte expectedKind){
		//This method is complete.
	    if(currentToken.kind == expectedKind)
	      currentToken = scanner.nextToken();
	    else
	      new Error("Syntax error: Symbol: " + currentToken.spelling + " is not expected.",
	        currentToken.line);
	  }

	  private void acceptIt(){
		//This method is complete.
	    currentToken = scanner.nextToken();
	  }


	  public void parse(){
	    //This method is complete.
	    scanner = new Lexer();
	    currentToken = scanner.nextToken();
	    parseProgram();
	    if(currentToken.kind != Token.EOT)
	      new Error("Syntax error: Redundant characters at the end of program.",
	        currentToken.line);
	  }

	  //Program ::= Block ".".
	  private void parseProgram(){
	    //This method is complete.
	    parseBlock();
	    accept(Token.PERIOD);
	  }

	  //Block ::= "begin" DefinitionPart StatementPart "end".
	  private void parseBlock(){
		accept(Token.BEGIN); 
		parseDefinitionPart(); 
		parseStatementPart();
		accept(Token.END);  
	  }

	  //DefintionPart ::= {Definition ";"}
	  private void parseDefinitionPart(){
		 while(currentToken.kind == Token.INTEGER ||  currentToken.kind == Token.CONST || currentToken.kind == Token.PROC || currentToken.kind  == Token.BOOLEAN){
		   parseDefinition();
		   accept(Token.SEMICOLON);}
		 
	  }
	  
	  //Defintion ::= ConstantDefinition | VariableDefinition | ProcedureDefinition
	  private void parseDefinition(){
		 if(currentToken.kind == Token.CONST)
		   parseConstantDefinition();
		 else if (currentToken.kind == Token.INTEGER || currentToken.kind == Token.BOOLEAN) 
		   parseVariableDefinition();
		 else if (currentToken.kind == Token.PROC)
		   parseProcedureDefinition();
		 else
			 new Error("Constant not defined" ,currentToken.line);
		 ////else new Error(...)
	  }

	  //ConstantDefinition ::= "const" ConstantName "=" Constant.
	  private void parseConstantDefinition(){
		 accept(Token.CONST); 
		 accept(Token.IDENTIFIER); 
		 accept(Token.EQUAL);
		 parseConstant();
	  }

	  /*
	    VaribaleDefinition ::= TypeSymbol VariableList |
	      TypeSymbol "array" VariableList "[" Constant "]".
	  */
	  private void parseVariableDefinition(){
		 parseTypeSymbol();
		 if(currentToken.kind == Token.ARRAY){
		   acceptIt();	
		   parseVariableList();
		   accept(Token.LBRACKET);
		   parseConstant();
		   accept(Token.RBRACKET);
		   parseVariableList();
		   } 
		   else
				 new Error("Variable not defined" ,currentToken.line);
		 }////else new Error(...)
	  

	  //TypeSymbol ::= "integer" | "boolean".
	  private void parseTypeSymbol(){
		 if(currentToken.kind == Token.INTEGER)
		   acceptIt();
		 else if (currentToken.kind == Token.BOOLEAN)
		   acceptIt();
		 else
			 new Error("Integer not defined" ,currentToken.line);
		 ////else new Error(...)
	  }

	  //VariableList ::= VariableName {"," VariableName}.
	  private void parseVariableList(){
		 accept(Token.IDENTIFIER);
		 while(currentToken.kind == Token.COMMA){
			acceptIt();
		 	accept(Token.IDENTIFIER);
		 }
	  }

	  //ProcedureDefinition ::= "proc" ProcedureName Block.
	  private void parseProcedureDefinition(){
		 accept(Token.PROC);
		 accept(Token.IDENTIFIER);
		 parseBlock();
	  }

	  //StatementPart ::= {Statement ";"}.
	  private void parseStatementPart(){
		  while (currentToken.kind == Token.SKIP || currentToken.kind == Token.WRITE || currentToken.kind == Token.IDENTIFIER || currentToken.kind == Token.READ  || currentToken.kind == Token.CALL || currentToken.kind == Token.IF || currentToken.kind == Token.DO){
		    parseStatement();
		    accept(Token.SEMICOLON);}
	  }

	  /*
	    Statement ::= EmptyStatement | ReadStatement | WriteStatement |
	                  AssigmentStatement | ProcedureStatement |
	                  IfStatement | DoStatement.
	  */
	  private void parseStatement(){
		  if(currentToken.kind == Token.SKIP)
			 parseEmptyStatement();
		  else if (currentToken.kind == Token.READ)
			 parseReadStatement();
		  else if (currentToken.kind == Token.WRITE)
			 parseWriteStatement();
		  else if (currentToken.kind == Token.IDENTIFIER)
			 parseAssignmentStatement();
		  else if (currentToken.kind == Token.CALL)
			 parseProcedureStatement(); 
		  else if (currentToken.kind == Token.IF)
			 parseIfStatement();
		  else if (currentToken.kind == Token.DO)
			 parseDoStatement(); 
		  else
				 new Error("Invalid not statement" , currentToken.line);
		////else new Error(...)	  
	  }

	  //EmptyStatement ::= "skip".
	  private void parseEmptyStatement(){
		  accept(Token.SKIP);
	  }

	  //ReadStatement ::= "read" VariableAccessList.
	  private void parseReadStatement(){
		  accept(Token.READ);
		  parseVariableAccessList();
	  }

	  //VariableAccessList ::= VariableAccess {"," VariableAccess}.
	  private void parseVariableAccessList(){
		  parseVariableAccess();
		  while (currentToken.kind == Token.COMMA){
			 acceptIt();
		  	 parseVariableAccess();
		  }
	  }

	  //WriteStatement ::= "write" ExpressionList.
	  private void parseWriteStatement(){
		 accept(Token.WRITE);
		 parseExpressionList();
	  }

	  //ExpressionList ::= Expression {"," Expression}.
	  private void parseExpressionList(){
		 parseExpression();
		 while(currentToken.kind == Token.COMMA){
			acceptIt();
		 	parseExpression();
		 }
	  }

	  //AssignmentStatement ::= VariableAccessList ":=" ExpressionList.
	  private void parseAssignmentStatement(){
		 parseVariableAccessList();
		 accept(Token.BECOMES);
		 parseExpressionList();
	  }

	  //ProcedureStatement ::= "call" ProcedureName.
	  private void parseProcedureStatement(){
		 accept(Token.CALL);
		 accept(Token.IDENTIFIER);
	  }

	  //IfStatement ::= "if" GuardedCommandList "fi".
	  private void parseIfStatement(){
		 accept(Token.IF);
		 parseGuardedCommandList();
		 accept(Token.FI);
	  }

	  //DoStatement ::= "do" GuardedCommandList "od".
	  private void parseDoStatement(){
		 accept(Token.DO);
		 parseGuardedCommandList();
		 accept(Token.OD);
	  }

	  //GuardedCommandList ::= GuardedCommand {"[]" GuardedCommand}.
	  private void parseGuardedCommandList(){
		 parseGuardedCommand();
		 while(currentToken.kind == Token.GUARD){
			acceptIt();
			parseGuardedCommand();
		 }
	  }

	  //GuardedCommand ::= Expression "->" StatementPart.
	  private void parseGuardedCommand(){
		 parseExpression();
		 accept(Token.ARROW);
		 parseStatementPart();
	  }

	  //Expression ::= PrimaryExpression {PrimaryOperator PrimaryExpression}.
	  ////The first of the PrimaryOperator is only OR and AND
	  private void parseExpression(){
		 parsePrimaryExpression();
		 while(currentToken.kind == Token.PLUS ||  currentToken.kind == Token.ASTERISK || currentToken.kind == Token.MINUS || currentToken.kind == Token.DIV || currentToken.kind == Token.MOD || currentToken.kind == Token.LESS || currentToken.kind == Token.GREATER || currentToken.kind == Token.EQUAL){
		     parsePrimaryExpression();
		     }
	  }

	  //PrimaryExpression ::= SimpleExpression [RelationalOperator SimpleExpression].
	  private void parsePrimaryExpression(){
		  parseSimpleExpression();
		  if(currentToken.kind == Token.LESS || currentToken.kind == Token.EQUAL || currentToken.kind == Token.GREATER){
			  parseRelationalOperator();
			  parseSimpleExpression();
		  }
	  }

	  //RelationalOperator ::= "<" | "=" | ">".
	  private void parseRelationalOperator(){
		 if(currentToken.kind == Token.LESS)
			 acceptIt();
		 else if (currentToken.kind == Token.EQUAL)
			 acceptIt();
		 else if (currentToken.kind == Token.GREATER)
			 acceptIt();
		 else
			 new Error("Operator not defined" ,currentToken.line);
		 ////else new Error(...)
	  }

	  //SimpleExpression ::= ["-"] Term {AddingOperator Term}.
	  private void parseSimpleExpression(){
		  if(currentToken.kind == Token.MINUS)
			 acceptIt();
		  parseTerm();
		  while(currentToken.kind == Token.PLUS || currentToken.kind == Token.MINUS){
			  parseAddingOperator();
			  parseTerm();
		  }
	  }

	  //AddingOperator ::= "+" | "-".
	  private void parseAddingOperator(){
		 if(currentToken.kind == Token.PLUS)
			 acceptIt();
		 else if (currentToken.kind == Token.MINUS)
			 acceptIt();
		 else
			 new Error("Operator not defined" ,currentToken.line);
		 ////else new Error(...)
	  }

	  //Term ::= Factor {MultiplyingOperator Factor}
	  private void parseTerm(){
		  parseFactor();
		  while(currentToken.kind == Token.ASTERISK || currentToken.kind == Token.DIV || currentToken.kind == Token.MOD){
			  parseMultiplyingOperator();
			  parseFactor();
		  }
	  }

	  //MultiplyingOperator ::= "*" | "/" | "\".
	  private void parseMultiplyingOperator(){
		 if(currentToken.kind == Token.ASTERISK)
			 acceptIt();
		 else if (currentToken.kind == Token.DIV)
			 acceptIt();
		 else if (currentToken.kind == Token.MOD)
			 acceptIt();
		 else
			 new Error("Operator not defined" ,currentToken.line);
		 ////else new Error(...)
	  }

	  //Factor ::= Constant | VariableAccess | "(" Expression ")" | "~" Factor.
	  private void parseFactor(){
		 if(currentToken.kind == Token.INTLITERAL ||  currentToken.kind == Token.TRUE || currentToken.kind == Token.FALSE)
			parseConstant();
		 else if (currentToken.kind == Token.IDENTIFIER)
			parseVariableAccess();
		
		 else if (currentToken.kind == Token.NOT){
			acceptIt();
			parseFactor();
		 }
		 
		 else if (currentToken.kind == Token.LPAREN){
				acceptIt();
				parseExpression();
				accept(Token.RPAREN);
			 }
		 else
			 new Error("Invalid Expression" ,currentToken.line);
		 ////else new Error(...)
			 
	  }

	  //VariableAccess ::= VariableName [IndexSelector].
	  private void parseVariableAccess(){
		 accept(Token.IDENTIFIER);
		 if(currentToken.kind == Token.LBRACKET){
			parseIndexSelector();
		 }
	  }

	  //IndexSelector ::= "[" Expression "]".
	  private void parseIndexSelector(){
		 accept(Token.LBRACKET);
		 parseExpression();
		 accept(Token.RBRACKET);
	  }

	  //Constant ::= Numeral|BooleanSymbol|ConstantName.
	  private void parseConstant(){
		 if(currentToken.kind == Token.INTLITERAL)	 
		    acceptIt();
		 else if(currentToken.kind == Token.IDENTIFIER)
				acceptIt();
		 else if(currentToken.kind == Token.TRUE || currentToken.kind == Token.FALSE)
			parseBooleanSymbol();
		 else
			 new Error("Identifier not defined" ,currentToken.line);
	////else new Error(...)	 
		 
	  }

	  //BooleanSymbol ::= "false"|"true".
	  private void parseBooleanSymbol(){
		 if(currentToken.kind == Token.FALSE)
			acceptIt();
		 else if(currentToken.kind == Token.TRUE)
		    acceptIt();
		 else
			 new Error("Invalid Symbol" ,currentToken.line);
		 ////else new Error(...)
	  }
	}