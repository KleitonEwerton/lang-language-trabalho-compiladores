grammar lang1;

@parser::header
{
    package lang.parser;
     
}

@lexer::header
{
    package lang.parser;
}


prog: def*
   ;

def: data 
   | fun 
   ;

data: TYPE_DATA NAME TYPE_OPEN_BRACE decl* TYPE_CLOSE_BRACE
   ;

decl: ID TYPE_SRO type TYPE_SEMI 
   ;

fun: ID TYPE_OPEN_PARENTHESIS params? TYPE_CLOSE_PARENTHESIS (TYPE_COLON type (TYPE_COMMA type)*)? TYPE_OPEN_BRACE cmd* TYPE_CLOSE_BRACE
   ;

params: ID TYPE_SRO type (TYPE_COMMA ID TYPE_SRO type)* 
   ;

type: type TYPE_OPEN_BRACKET TYPE_CLOSE_BRACKET
   |  btype
   ;

btype: TYPE_INT
   | TYPE_CHAR 
   | TYPE_BOOL 
   | TYPE_FLOAT 
   | NAME
   | ID 
   ;


cmd: TYPE_OPEN_BRACE cmd* TYPE_OPEN_BRACE
   | TYPE_IF TYPE_OPEN_PARENTHESIS exp TYPE_CLOSE_PARENTHESIS cmd
   | TYPE_IF TYPE_OPEN_PARENTHESIS exp TYPE_CLOSE_PARENTHESIS cmd TYPE_ELSE cmd
   | TYPE_ITERATE TYPE_OPEN_PARENTHESIS exp TYPE_CLOSE_PARENTHESIS cmd
   | TYPE_READ lvalue TYPE_SEMI
   | TYPE_PRINT exp TYPE_SEMI
   | TYPE_RETURN exp (TYPE_COMMA exp)* TYPE_SEMI
   | lvalue TYPE_EQUAL exp TYPE_SEMI 
   | ID TYPE_OPEN_PARENTHESIS exps TYPE_CLOSE_PARENTHESIS (TYPE_LESS_THAN lvalue (TYPE_COMMA lvalue)* TYPE_GREATER_THAN)? TYPE_SEMI
   ;

exp: exp TYPE_AND exp
   | cexpr 
   ;

cexpr: baexp TYPE_LESS_THAN baexp 
   |   cexpr TYPE_EQUAL_EQUAL baexp 
   |   cexpr TYPE_NO_EQUAL baexp 
   |   baexp
   ;

baexp: baexp TYPE_PLUS opexp 
   |   baexp TYPE_MINUS opexp
   |   opexp
   ;

opexp: opexp TYPE_ASTERISK dexp 
   |   opexp TYPE_DIV dexp 
   |   opexp TYPE_MOD dexp
   |   dexp
   ;

dexp: TYPE_EXCLAMATION dexp 
   |  TYPE_MINUS dexp 
   |  TYPE_TRUE
   |  TYPE_FALSE 
   |  TYPE_NULL 
   |  INT 
   |  FLOAT 
   |  CHAR
   |  rexp
   ;

rexp: lvalue 
   | TYPE_OPEN_PARENTHESIS exp TYPE_CLOSE_PARENTHESIS 
   | TYPE_NEW type (TYPE_OPEN_BRACKET exp TYPE_CLOSE_BRACKET)? 
   | ID TYPE_OPEN_PARENTHESIS exps? TYPE_CLOSE_PARENTHESIS TYPE_OPEN_BRACKET exp TYPE_CLOSE_BRACKET 
   ;

lvalue: ID 
      | lvalue TYPE_OPEN_BRACKET exp TYPE_CLOSE_BRACKET
      | lvalue TYPE_DOT ID 
      ;

exps: exp (TYPE_COMMA exp)* 
      ;

TYPE_INT: 'int';
TYPE_CHAR: 'char';
TYPE_BOOL: 'bool';
TYPE_FLOAT: 'float';
TYPE_NEW: 'new';

TYPE_DATA: 'data';

TYPE_IF: 'if';
TYPE_ELSE: 'else';
TYPE_ITERATE: 'iterate';
TYPE_READ: 'read';
TYPE_PRINT: 'print';
TYPE_RETURN: 'return';
TYPE_NULL: 'null';
TYPE_TRUE: 'true';
TYPE_FALSE: 'false';

ID: [a-z][a-zA-Z0-9_]* ;
NAME: [A-Z][a-zA-Z0-9_]* ;
INT: '-'? [0-9]+ ;
FLOAT: '-'? [0-9]* '.' ([0-9] [0-9]*) ;
CHAR: '\'' [\u0000-\u007F] '\'' ;

NEWLINE: '\r'? '\n' -> skip;
WS : [ \t]+ -> skip;
LINE_COMMENT : '//' ~('\r' | '\n')* NEWLINE -> skip;
COMMENT: '/*' .*?  '*/' -> skip;

TYPE_OPEN_BRACKET: '[';
TYPE_CLOSE_BRACKET: ']';
TYPE_DOT: '.';
TYPE_OPEN_PARENTHESIS: '(';
TYPE_CLOSE_PARENTHESIS: ')';
TYPE_OPEN_BRACE: '{';
TYPE_CLOSE_BRACE: '}';

TYPE_EXCLAMATION: '!';
TYPE_ASTERISK: '*';
TYPE_DIV: '/';
TYPE_MOD: '%';
TYPE_PLUS: '+';
TYPE_MINUS: '-';
TYPE_LESS_THAN: '<';
TYPE_GREATER_THAN: '>';
TYPE_EQUAL_EQUAL: '==';
TYPE_NO_EQUAL: '!=';
TYPE_AND: '&&';
TYPE_SEMI: ';';
TYPE_COLON: ':';
TYPE_SRO: '::';
TYPE_COMMA: ',';
TYPE_EQUAL: '=';
