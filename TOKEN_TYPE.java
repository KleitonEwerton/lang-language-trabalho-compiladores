/*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
 *  Kleiton Ewerton de Oliveira - MAT 202065050C
 *  Nikolas Oliver Sales Genesio - MAT 202065072C
 */

public enum TOKEN_TYPE {
  ID, // identificador
  TYPE, // tipo de dado
  VAL_INT, // inteiros
  VAL_FLOAT, // reais
  RET, // return
  INT, // int
  FLOAT, // float
  CHAR, // char
  BOOL, // bool
  DATA, // data
  EQ, // =
  NEQ, // !=
  PLUS, // +
  TIMES, // *
  MINUS, // -
  DIV, // /
  MOD, // %
  SEMI, // ;
  LP, // ( (Left Parenthesis)
  RP, // ) (Right Parenthesis)
  LB, // [ (Left Bracket)
  RB, // ] (Right Bracket)
  LC, // { (Left Curly Brace)
  RC, // } (Right Curly Brace)
  LT, // <
  BT, // >
  CMA, // ,
  DOT, // .
  COLON, // :
  SRO, // :: scope resolution operator
  EQEQ, // ==
  NOT, // !
  AND, // &&
  IF,
  ELSE,
  ITERATE,
  READ,
  PRINT,
  LITERAL_CARACTERE,
  TRUE,
  FALSE,
  NULL
}
