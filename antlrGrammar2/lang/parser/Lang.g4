grammar Lang;

@header{
    package lang.parser;    
}

prog: data* func*   # Program
    ;
data: DATA_TYPE NAME_TYPE OPEN_BRACES decl* CLOSE_BRACES    # DataDeclaration
    ;
decl: ID DOUBLE_COLON type SEMI                             # VarDeclaration
    ;
func: ID OPEN_PARENT params? CLOSE_PARENT (COLON type (COMMA type)*)? OPEN_BRACES cmd* CLOSE_BRACES    # Function
    ;
params: ID DOUBLE_COLON type (COMMA ID DOUBLE_COLON type)*  # ParametersFunction
      ;
type: type OPEN_BRACKET CLOSE_BRACKET   # TypeDeclaration 
    | btype     # BTypeCall
    ;
btype: INT_TYPE     # BTypeInt
    | CHAR_TYPE     # BTypeChar
    | BOOL_TYPE     # BTypeBool
    | FLOAT_TYPE    # BTypeFloat
    | NAME_TYPE     # BTypeNameType
    ;
cmd: OPEN_BRACES cmd* CLOSE_BRACES      # CommandsList
    | IF OPEN_PARENT exp CLOSE_PARENT cmd   # If
    | IF OPEN_PARENT exp CLOSE_PARENT cmd ELSE cmd  # IfElse
    | ITERATE OPEN_PARENT exp CLOSE_PARENT cmd  # Iterate
    | READ lvalue SEMI  # Read
    | PRINT exp SEMI    # Print
    | RETURN exp (COMMA exp)* SEMI  # Return
    | lvalue EQUALS exp SEMI    # Attribution
    | ID OPEN_PARENT exps? CLOSE_PARENT (LESS_THAN lvalue (COMMA lvalue)* GREATER_THAN)? SEMI   # FunctionCall
    ;
exp:<assoc=left> exp AND exp    # AndOperation
    | rexp      # RExpCall
    ;
rexp: aexp LESS_THAN aexp   # LessThan
    |<assoc=left>rexp EQUALITY aexp    # Equality
    |<assoc=left>rexp DIFFERENCE aexp  # Difference
    | aexp      # AExpCall
    ;
aexp: aexp PLUS mexp    # AdditionOperation
    | aexp MINUS mexp   # SubtractionOperation
    | mexp      # MExpCall
    ;
mexp:<assoc=left>mexp TIMES sexp   # MultiplicationOperation
    |<assoc=left>mexp SLASH sexp   # DivisionOperation
    |<assoc=left>mexp PERCENT sexp # ModularOperation
    | sexp      # SExpCall
    ;
sexp:<assoc=right>EXCLAMATION sexp # Not
    |<assoc=right>MINUS sexp   # Minus 
    | TRUE  # True
    | FALSE # False
    | NULL  # Null
    | INT   # IntegerNumber
    | FLOAT # FloatNumber
    | CHAR  # CharLitteral
    | pexp  # PExpCall
    ;
pexp: lvalue    # PexpIdentifier    
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
    