grammar Lang;

 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */

@parser::header
{
    package lang.parser;
     
}

@lexer::header
{
    package lang.parser;
}

prog: def*  # progName 
    ;

def: data #dataDef
   | fun  #funDef
   ;

data: TYPE_DATA TYPE_NAME TYPE_OPEN_BRACE decl* TYPE_CLOSE_BRACE    # dataName;

decl: ID TYPE_SRO type TYPE_SEMI                             # declName
    ;
fun: ID TYPE_OPEN_PARENTHESIS params? TYPE_CLOSE_PARENTHESIS (TYPE_COLON type (TYPE_COMMA type)*)? TYPE_OPEN_BRACE cmd* TYPE_CLOSE_BRACE    #funName
    ;
params: ID TYPE_SRO type (TYPE_COMMA ID TYPE_SRO type)*  #paramsName
      ;
type: type TYPE_OPEN_BRACKET TYPE_CLOSE_BRACKET   #typeName
    | btype     # btypeName
    ;
btype: TYPE_INT     # intType
    | TYPE_CHAR     # charType
    | TYPE_BOOL     # boolType
    | TYPE_FLOAT    # floatType
    | TYPE_NAME     # nameType
    ;

cmd: TYPE_OPEN_BRACE cmd* TYPE_CLOSE_BRACE      #blockCmd
    | TYPE_IF TYPE_OPEN_PARENTHESIS exp TYPE_CLOSE_PARENTHESIS cmd   # ifCmd
    | TYPE_IF TYPE_OPEN_PARENTHESIS exp TYPE_CLOSE_PARENTHESIS cmd TYPE_ELSE cmd  # ifElseCmd
    | TYPE_ITERATE TYPE_OPEN_PARENTHESIS exp TYPE_CLOSE_PARENTHESIS cmd  # iterateCmd
    | TYPE_READ lvalue TYPE_SEMI  # readCmd
    | TYPE_PRINT exp TYPE_SEMI    # printCmd
    | TYPE_RETURN exp (TYPE_COMMA exp)* TYPE_SEMI  # returnCmd
    | lvalue TYPE_EQUAL exp TYPE_SEMI    # lvalueCmd
    | ID TYPE_OPEN_PARENTHESIS exps? TYPE_CLOSE_PARENTHESIS (TYPE_LESS_THAN lvalue (TYPE_COMMA lvalue)* TYPE_GREATER_THAN)? TYPE_SEMI   # funcCallCmd
    ;
exp:<assoc=left> exp TYPE_AND exp   #andExp
    | cexpr       #cexprExp
    ;
cexpr: baexp TYPE_LESS_THAN baexp   #lessThanCexpr
    |<assoc=left>cexpr TYPE_EQUAL_EQUAL baexp    #equalsCexpr
    |<assoc=left>cexpr TYPE_NO_EQUAL baexp   #notEqualsCexpr
    | baexp      #baexpCexpr
    ;
baexp: baexp TYPE_PLUS opexp    # addBaexp
    | baexp TYPE_MINUS opexp   # subBaexp
    | opexp      # opexpBaexp
    ;
opexp:<assoc=left>opexp TYPE_ASTERISK dexp   #mulOpexp
    |<assoc=left>opexp TYPE_DIV dexp   #divOpexp
    |<assoc=left>opexp TYPE_MOD dexp #modOpexp
    | dexp      #dexpOpexp
    ;
dexp:<assoc=right>TYPE_EXCLAMATION dexp #notDexp
    |<assoc=right>TYPE_MINUS dexp   #negDexp
    | TYPE_TRUE  #trueDexp
    | TYPE_FALSE #falseDexp
    | TYPE_NULL  #nullDexp
    | INT   #intDexp
    | FLOAT #floatDexp
    | CHAR  #charDexp
    | rexp   #rexpDexp
    ;

rexp: lvalue    #lvalueRexp   
    |<assoc=left>TYPE_OPEN_PARENTHESIS exp TYPE_CLOSE_PARENTHESIS  #parenRexp
    | TYPE_NEW type (TYPE_OPEN_BRACKET exp TYPE_CLOSE_BRACKET)?    #newRexp
    | ID TYPE_OPEN_PARENTHESIS exps? TYPE_CLOSE_PARENTHESIS TYPE_OPEN_BRACKET exp TYPE_CLOSE_BRACKET  #funcCallRexp
    ;
lvalue: ID      #idLvalue
    |<assoc=left>lvalue TYPE_OPEN_BRACKET exp TYPE_CLOSE_BRACKET #arrayLvalue
    |<assoc=left>lvalue DOT ID     #dotLvalue
    ;
exps: exp (TYPE_COMMA exp)*      #expsName
    ;


NEWLINE: '\r'? '\n' -> skip;
WS : [ \t]+ -> skip;
LINE_COMMENT : '--' .*? NEWLINE -> skip;
COMMENT: '{-' .*?  '-}' -> skip;

TYPE_INT: 'Int';
TYPE_FLOAT: 'Float';
TYPE_CHAR: 'Char';
TYPE_BOOL: 'Bool';

TYPE_DATA: 'data';

TYPE_IF: 'if';
TYPE_ELSE: 'else';
TYPE_ITERATE: 'iterate';
TYPE_READ: 'read';
TYPE_PRINT: 'print';
TYPE_RETURN: 'return';

TYPE_NEW: 'new';

TYPE_TRUE: 'true';
TYPE_FALSE: 'false';
TYPE_NULL: 'null';


TYPE_AND: '&&';
TYPE_EQUAL_EQUAL: '==';
TYPE_NO_EQUAL: '!='; 

TYPE_EXCLAMATION: '!';
TYPE_COMMA: ',';
DOT: '.';
TYPE_SEMI: ';';
TYPE_COLON: ':';
TYPE_SRO: '::';
TYPE_LESS_THAN: '<';
TYPE_GREATER_THAN: '>';
TYPE_EQUAL: '=';
TYPE_ASTERISK: '*';
TYPE_PLUS: '+';
TYPE_MINUS: '-';
TYPE_DIV: '/';
TYPE_MOD: '%';
    
TYPE_OPEN_BRACKET: '[';
TYPE_CLOSE_BRACKET: ']';
TYPE_OPEN_PARENTHESIS: '(';
TYPE_CLOSE_PARENTHESIS: ')';
TYPE_OPEN_BRACE: '{';
TYPE_CLOSE_BRACE: '}';

ID: [a-z][a-zA-Z0-9_]* ; 
TYPE_NAME : [A-Z][a-zA-Z0-9_]* ;

INT: [0-9]+ ;
FLOAT: [0-9]* '.' ([0-9] [0-9]*) ;
CHAR: '\'' [\u0000-\u007F] '\'' 
   |  '\'' ('\\n' | '\\t' | '\\b' | '\\r' | '\\\\' | '\\') '\''
   ;