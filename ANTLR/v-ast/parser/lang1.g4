/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

grammar lang1;


/* Regras da gramática -  Sintaxe da linguagem lang */

/* A notação [E] denota que E é opcional */
/* A notação {E} representa 0 ou mais ocorrências de E */


/* PERGUNTAS */
/* Quanto maior a precedência, mais abaixo a regra é posicionada? */
/* ID do data é o nome de tipo, preciso colocar em alguma regra da gramtática? */
/* Comentários */


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
    | btype
    ;

btype: TYPE_INT 
    |  TYPE_CHAR 
    |  TYPE_BOOL 
    |  TYPE_FLOAT 
    |  ID 
    ;

cmd:  TYPE_OPEN_BRACE cmd* TYPE_OPEN_BRACE 
    | TYPE_IF TYPE_OPEN_PARENTHESIS exp TYPE_CLOSE_PARENTHESIS cmd 
    | TYPE_IF TYPE_OPEN_PARENTHESIS exp TYPE_CLOSE_PARENTHESIS cmd TYPE_ELSE cmd 
    | TYPE_ITERATE TYPE_OPEN_PARENTHESIS exp TYPE_CLOSE_PARENTHESIS cmd 
    | TYPE_READ lvalue TYPE_SEMI 
    | TYPE_PRINT exp TYPE_SEMI 
    | TYPE_RETURN exp (TYPE_COMMA exp)* TYPE_SEMI 
    | lvalue TYPE_EQUAL exp TYPE_SEMI 
    | ID TYPE_OPEN_PARENTHESIS exps TYPE_CLOSE_PARENTHESIS (TYPE_LESS_THAN lvalue (TYPE_COMMA lvalue)* TYPE_GREATER_THAN)? TYPE_SEMI 
    ;

exp:  exp TYPE_AND exp 
    | exp TYPE_LESS_THAN exp 
    | exp TYPE_EQUAL_EQUAL exp 
    | exp TYPE_NO_EQUAL exp 
    | exp TYPE_PLUS exp 
    | exp TYPE_MINUS exp 
    | exp TYPE_ASTERISK exp 
    | exp TYPE_DIV exp 
    | exp TYPE_MOD exp 
    | TYPE_EXCLAMATION exp 
    | TYPE_MINUS exp 
    | TYPE_TRUE
    | TYPE_FALSE 
    | TYPE_NULL 
    | INT 
    | FLOAT 
    | CHAR 
    | lvalue 
    | TYPE_OPEN_PARENTHESIS exp TYPE_CLOSE_PARENTHESIS 
    | TYPE_NEW type (TYPE_OPEN_BRACKET exp TYPE_CLOSE_BRACKET)? 
    | ID TYPE_OPEN_PARENTHESIS exps? TYPE_CLOSE_PARENTHESIS TYPE_OPEN_BRACKET exp TYPE_CLOSE_BRACKET     ;

lvalue: ID 
    |   lvalue TYPE_OPEN_BRACKET exp TYPE_CLOSE_BRACKET
    |   lvalue TYPE_DOT ID
    ;

exps: exp (TYPE_COMMA exp)* 
    ;

/* Regras léxicas */

/* palavras reservadas */ 

TYPE_INT: 'Int';
TYPE_CHAR: 'Char';
TYPE_BOOL: 'Bool';
TYPE_FLOAT: 'Float';
TYPE_NEW: 'new';
 
TYPE_DATA: 'data';

/* cmd */ 
TYPE_IF: 'if';
TYPE_ELSE: 'else';
TYPE_ITERATE: 'iterate';
TYPE_READ: 'read';
TYPE_PRINT: 'print';
TYPE_RETURN: 'return';
TYPE_NULL: 'null';
TYPE_TRUE: 'true';
TYPE_FALSE: 'false';


/* linguagem */
ID: [a-z][a-zA-Z0-9_]* ;
NAME: [A-Z][a-zA-Z0-9_]* ;
INT: '-'? [0-9]+ ;
FLOAT: '-'? [0-9]* '.' ([0-9] [0-9]*) ;
CHAR: ('\'' '\\n' '\'')
    | ('\'' '\\t' '\'')
    | ('\'' '\\b' '\'') 
    | ('\'' '\\r' '\'') 
    | ('\'' '\\' '\\' '\'') 
    | ('\'' [\u0000-\u007F] '\'') 
    | ('\'' '\\' '\'') 
    ;
    
/* none */ 

NEWLINE: '\r'? '\n' -> skip;
WS : [ \t]+ -> skip;
LINE_COMMENT : '//' ~('\r' | '\n')* NEWLINE -> skip;
COMMENT: '/*' .*?  '*/' -> skip;


/* operadores e separadores */

/* nivel 7 */
TYPE_OPEN_BRACKET: '[';
TYPE_CLOSE_BRACKET: ']';
TYPE_DOT: '.';
TYPE_OPEN_PARENTHESIS: '(';
TYPE_CLOSE_PARENTHESIS: ')';
TYPE_OPEN_BRACE: '{';
TYPE_CLOSE_BRACE: '}';

/* nivel 6 */
TYPE_EXCLAMATION: '!';

/* nivel 5 */
TYPE_ASTERISK: '*';
TYPE_DIV: '/';
TYPE_MOD: '%';

/* nivel 4 */
TYPE_PLUS: '+';
TYPE_MINUS: '-';

/* nivel 3 */
TYPE_LESS_THAN: '<';
TYPE_GREATER_THAN: '>';

/* nivel 2 */
TYPE_EQUAL_EQUAL: '==';
TYPE_NO_EQUAL: '!=';

/* nivel 1 */
TYPE_AND: '&&';
TYPE_SEMI: ';';
TYPE_COLON: ':';
TYPE_SRO: '::';
TYPE_COMMA: ',';
TYPE_EQUAL: '=';