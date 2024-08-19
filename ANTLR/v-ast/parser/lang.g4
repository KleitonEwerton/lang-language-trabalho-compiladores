grammar lang;

@parser::header {
    package parser;
    import ast.*;
}

@lexer::header {
    package parser;
}

prog returns [StmtList ast]:
  s1=stmt ';' {$ast = new StmtList($s1.ast.getLine(), $s1.ast.getCol(), $s1.ast);}
  (s2=stmt ';' {$ast = new StmtList($s2.ast.getLine(), $s2.ast.getCol(), $ast, $s2.ast);})*
;

// def returns [Node ast]:
//   TYPE_DATA ID '{' f1=fieldList '}' {$ast = new DataDecl($TYPE_DATA.line, $TYPE_DATA.pos, new ID($ID.line, $ID.pos, $ID.text), $f1.ast);}

decl returns [Node ast]:
  TYPE_INT ID TYPE_SRO expr {$ast = new VarInt($TYPE_INT.line, $TYPE_INT.pos, new ID($ID.line, $ID.pos, $ID.text), $expr.ast);};
  


stmt returns [Node ast]:
  decl {$ast = $decl.ast;}
|
  expr op='if' '[' s1=stmt ']' ':' '[' s2=stmt ']' {$ast = new If($op.line, $op.pos, $expr.ast, $s1.ast, $s2.ast);}
|
  expr op='if' '[' s1=stmt ']' {$ast = new If($op.line, $op.pos, $expr.ast, $s1.ast);}
|

  op='iterate' '(' expr ')' '[' s1=stmt ']' {$ast = new Iterate($op.line, $op.pos, $expr.ast, $s1.ast);}

|
  op='print' '(' expr ')' {$ast = new Print($expr.ast.getLine(), $expr.ast.getCol(), $expr.ast);}
;

stmtList returns [StmtList ast]:
  s1=stmt ';' {$ast = new StmtList($s1.ast.getLine(), $s1.ast.getCol(), $s1.ast);}
  (s2=stmt ';' {$ast = new StmtList($s2.ast.getLine(), $s2.ast.getCol(), $ast, $s2.ast);})*
;

expr returns [Expr ast]:
  term op='+' e=expr {$ast = new Add($op.line, $op.pos, $term.ast, $e.ast);}
|
  term {$ast = $term.ast;}
;

term returns [Expr ast]:
  factor op='*' e=term {$ast = new Mul($op.line, $op.pos, $factor.ast, $e.ast);}
|
  factor {$ast = $factor.ast;}
;

factor returns [Expr ast]:
  ID {$ast = new ID($ID.line, $ID.pos, $ID.text);}
|
  INT {$ast = new Num($INT.line, $INT.pos, Integer.parseInt($INT.text));}
;


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
TYPE_RET: 'return';
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
