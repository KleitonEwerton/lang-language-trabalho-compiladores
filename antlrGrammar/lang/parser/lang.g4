grammar Lang;

 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */

@header{
    package lang.parser;    
}

prog: data* func*   # progName 
    ;
data: DATA_TYPE NAME_TYPE OPEN_BRACES decl* CLOSE_BRACES    # dataName;

decl: ID DOUBLE_COLON type SEMI                             # declName
    ;
func: ID OPEN_PARENT params? CLOSE_PARENT (COLON type (COMMA type)*)? OPEN_BRACES cmd* CLOSE_BRACES    #funName
    ;
params: ID DOUBLE_COLON type (COMMA ID DOUBLE_COLON type)*  #paramsName
      ;
type: type OPEN_BRACKET CLOSE_BRACKET   #typeName
    | btype     # btypeName
    ;
btype: INT_TYPE     # intType
    | CHAR_TYPE     # charType
    | BOOL_TYPE     # boolType
    | FLOAT_TYPE    # floatType
    | NAME_TYPE     # idType
    ;
cmd: OPEN_BRACES cmd* CLOSE_BRACES      #blockCmd
    | IF OPEN_PARENT exp CLOSE_PARENT cmd   # ifCmd
    | IF OPEN_PARENT exp CLOSE_PARENT cmd ELSE cmd  # ifElseCmd
    | ITERATE OPEN_PARENT exp CLOSE_PARENT cmd  # iterateCmd
    | READ lvalue SEMI  # readCmd
    | PRINT exp SEMI    # printCmd
    | RETURN exp (COMMA exp)* SEMI  # returnCmd
    | lvalue EQUALS exp SEMI    # lvalueCmd
    | ID OPEN_PARENT exps? CLOSE_PARENT (LESS_THAN lvalue (COMMA lvalue)* GREATER_THAN)? SEMI   # funcCallCmd
    ;
exp:<assoc=left> exp AND exp   #andExp
    | cexpr       #cexprExp
    ;
cexpr: baexp LESS_THAN baexp   #lessThanCexpr
    |<assoc=left>cexpr EQUALITY baexp    #equalsCexpr
    |<assoc=left>cexpr DIFFERENCE baexp   #notEqualsCexpr
    | baexp      #baexpCexpr
    ;
baexp: baexp PLUS opexp    # addBaexp
    | baexp MINUS opexp   # subBaexp
    | opexp      # opexpBaexp
    ;
opexp:<assoc=left>opexp TIMES dexp   #mulOpexp
    |<assoc=left>opexp SLASH dexp   #divOpexp
    |<assoc=left>opexp PERCENT dexp #modOpexp
    | dexp      #dexpOpexp
    ;
dexp:<assoc=right>EXCLAMATION dexp #notDexp
    |<assoc=right>MINUS dexp   #negDexp
    | TRUE  #trueDexp
    | FALSE #falseDexp
    | NULL  #nullDexp
    | INT   #intDexp
    | FLOAT #floatDexp
    | CHAR  #charDexp
    | rexp   #rexpDexp
    ;
rexp: lvalue    #lvalueRexp   
    |<assoc=left>OPEN_PARENT exp CLOSE_PARENT  #parenRexp
    | NEW type (OPEN_BRACKET exp CLOSE_BRACKET)?    #newRexp
    | ID OPEN_PARENT exps? CLOSE_PARENT OPEN_BRACKET exp CLOSE_BRACKET  #funcCallRexp
    ;
lvalue: ID      #idLvalue
    |<assoc=left>lvalue OPEN_BRACKET exp CLOSE_BRACKET #arrayLvalue
    |<assoc=left>lvalue DOT ID     #dotLvalue
    ;
exps: exp (COMMA exp)*      #expsName
    ;

EOL: '\r' ? '\n' -> skip;                               
WS : [ \t]+ -> skip;                                    
SINGLE_LINE_COMMENT: '--' .*? EOL -> skip;             
MULTI_LINE_COMMENT: '{-' .*? '-}' -> skip;

INT_TYPE: 'Int';
FLOAT_TYPE: 'Float';
CHAR_TYPE: 'Char';
BOOL_TYPE: 'Bool';
DATA_TYPE: 'data';

IF: 'if';
ELSE: 'else';
ITERATE: 'iterate';
READ: 'read';
PRINT: 'print';
RETURN: 'return';
NEW: 'new';
FALSE: 'false';
TRUE: 'true';
NULL: 'null';

AND: '&&';
EQUALITY: '==';
DIFFERENCE: '!='; 

EXCLAMATION: '!';
COMMA: ',';
DOT: '.';
SEMI: ';';
COLON: ':';
DOUBLE_COLON: '::';
LESS_THAN: '<';
GREATER_THAN: '>';
EQUALS: '=';
TIMES: '*';
PLUS: '+';
MINUS: '-';
SLASH: '/';
PERCENT: '%';
    
OPEN_BRACKET: '[';
CLOSE_BRACKET: ']';
OPEN_PARENT: '(';
CLOSE_PARENT: ')';
OPEN_BRACES: '{';
CLOSE_BRACES: '}';

ID: [a-z][a-zA-Z0-9_]* ; 
NAME_TYPE : [A-Z][a-zA-Z0-9_]* ;

INT: [0-9]+ ;
FLOAT: [0-9]* '.' ([0-9] [0-9]*) ;
CHAR: ('\''([\u0000-\u0026]|[\u0028-\u005B]|[\u005D-\u007F])'\'')      
    | ('\'''\\n''\'')          
    | ('\'''\\t''\'')          
    | ('\'''\\b''\'')           
    | ('\'''\\r''\'')          
    | ('\'''\\\\''\'')          
    | ('\'\\\'\'')          
    ;
    