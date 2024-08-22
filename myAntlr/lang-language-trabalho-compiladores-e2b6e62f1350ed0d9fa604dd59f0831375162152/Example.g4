grammar Example;

prog: stat+ ;
stat: expr NEWLINE ;
expr: 
    expr op=('*'|'/') expr
    | expr op=('+'|'-') expr
    | INT 
    | ID ;
ID: [a-zA-Z]+ ;
INT: [0-9]+ ;
ADD: '+' ;
SUB: '-' ;
MUL: '*' ;
DIV: '/' ;
NEWLINE: '\r'? '\n' ;
WS: [ \t]+ -> skip ;
