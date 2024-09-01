grammar Lang;

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
cexpr: baexp LESS_THAN baexp   # LessThan
    |<assoc=left>cexpr EQUALITY baexp    # Equality
    |<assoc=left>cexpr DIFFERENCE baexp  # Difference
    | baexp      # AExpCall
    ;
baexp: baexp PLUS opexp    # AdditionOperation
    | baexp MINUS opexp   # SubtractionOperation
    | opexp      # MExpCall
    ;
opexp:<assoc=left>opexp TIMES dexp   # MultiplicationOperation
    |<assoc=left>opexp SLASH dexp   # DivisionOperation
    |<assoc=left>opexp PERCENT dexp # ModularOperation
    | dexp      # SExpCall
    ;
dexp:<assoc=right>EXCLAMATION dexp # Not
    |<assoc=right>MINUS dexp   # Minus 
    | TRUE  # True
    | FALSE # False
    | NULL  # Null
    | INT   # IntegerNumber
    | FLOAT # FloatNumber
    | CHAR  # CharLitteral
    | rexp  # PExpCall
    ;
rexp: lvalue    # PexpIdentifier    
    |<assoc=left>OPEN_PARENT exp CLOSE_PARENT  # ExpParenthesis
    | NEW type (OPEN_BRACKET exp CLOSE_BRACKET)?    # TypeInstanciate
    | ID OPEN_PARENT exps? CLOSE_PARENT OPEN_BRACKET exp CLOSE_BRACKET  # FunctionReturn 
    ;
lvalue: ID      # Identifier
    |<assoc=left>lvalue OPEN_BRACKET exp CLOSE_BRACKET # ArrayAccess
    |<assoc=left>lvalue DOT ID     # DataAccess
    ;
exps: exp (COMMA exp)*      # FCallParams
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
    | ('\'''\\n''\'')           // '\n' => Contrabarra_n
    | ('\'''\\t''\'')           // '\t' => Contrabarra_t
    | ('\'''\\b''\'')           // '\b' => Contrabarra_b
    | ('\'''\\r''\'')           // '\r' => Contrabarra_r
    | ('\'''\\\\''\'')          // Especifica '\\' que é a '\' => Contrabarra
    | ('\'\\\'\'')              // Especifica a aspas simples: "\\\'" => \' => '
    ;
    