
 /*  Esta seção é copiada antes da declaração da classe do analisador léxico.
  *  É nesta seção que se deve incluir imports e declaração de pacotes.
  *  Neste exemplo não temos nada a incluir nesta seção.
  */
  
%%

%unicode
%line
%column
%class Lext
%function nextToken
%type Token

%{
    
    /* Código arbitrário pode ser inserido diretamente no analisador dessa forma. 
     * Aqui podemos declarar variáveis e métodos adicionais que julgarmos necessários. 
     */
    private int ntk;
    
    public int readedTokens(){
       return ntk;
    }
    private Token symbol(TOKEN_TYPE t) {
        ntk++;
        return new Token(t, yytext(), yyline+1, yycolumn+1);
        
    }
    private Token symbol(TOKEN_TYPE t, Object value) {
        ntk++;
        return new Token(t, value, yyline+1, yycolumn+1);
    }
    
    private void incTks() { ++ntk; }
    
    private int numTokens() { return ntk; }
%}

%init{
    ntk = 0; // Isto é copiado direto no construtor do lexer. 
%init}

  
/* Agora vamos definir algumas macros */
identificador = [:lowercase:] ([:letter:] | [:digit:] | "_" )*
tipo = [:uppercase:] ([:letter:] | [:digit:] | "_" )*
literal_int = ("-")? [:digit:] [:digit:]*
literal_float = ("-")? [:digit:]* "." ([:digit:] [:digit:]*)
literal_caractere = \n | \t | \b | \r // verificar utilização das barras
literal_logico_true = "true"
literal_logico_false = "false"
literal_logico = {literal_logico_true} | {literal_logico_false}
literal_nulo = "null"
FimDeLinha  = \r | \n | \r\n
LineComment = "--" (.)* {FimDeLinha}
Brancos     = {FimDeLinha} | [ \t\f]
  
%state COMMENT

%%

<YYINITIAL>{

    //btype
    "Int"           { return symbol(TOKEN_TYPE.INT);                                }
    "Char"          { return symbol(TOKEN_TYPE.CHAR);                               }
    "Bool"          { return symbol(TOKEN_TYPE.BOOL);                               }
    "Float"         { return symbol(TOKEN_TYPE.FLOAT);                              }

    //data
    "data"          { return symbol(TOKEN_TYPE.DATA);                               }

    //cmd
    "if"            { return symbol(TOKEN_TYPE.IF);                                 }
    "else"          { return symbol(TOKEN_TYPE.ELSE);                               }
    "iterate"       { return symbol(TOKEN_TYPE.ITERATE);                            }
    "read"          { return symbol(TOKEN_TYPE.READ);                               }
    "print"         { return symbol(TOKEN_TYPE.PRINT);                              }
    "return"        { return symbol(TOKEN_TYPE.RET);}
    
    //linguagem
    {identificador} { System.out.print("ID: "); return symbol(TOKEN_TYPE.ID);                                 }
    {literal_float} { System.out.print("FLOAT: "); return symbol(TOKEN_TYPE.VAL_FLOAT, Float.parseFloat(yytext()));}
    {literal_int}   { System.out.print("INT: "); return symbol(TOKEN_TYPE.VAL_INT, Integer.parseInt(yytext()));}
    {Brancos}       {                                                               }
    {LineComment}   {                                                               }
    {literal_logico_true} { return symbol(TOKEN_TYPE.TRUE);                         }
    {literal_logico_false} { return symbol(TOKEN_TYPE.FALSE);                       }
    
    //operadores e separadores
    "="             { return symbol(TOKEN_TYPE.EQ);                                 }
    ";"             { return symbol(TOKEN_TYPE.SEMI);                               }
    "*"             { return symbol(TOKEN_TYPE.TIMES);                              }
    "/"             { return symbol(TOKEN_TYPE.DIV);                                }
    "%"             { return symbol(TOKEN_TYPE.MOD);                                }
    "+"             { return symbol(TOKEN_TYPE.PLUS);                               }
    "-"             { return symbol(TOKEN_TYPE.MINUS);                              }
    "("             { return symbol(TOKEN_TYPE.OPT);                                }
    ")"             { return symbol(TOKEN_TYPE.CPT);                                }
    "["             { return symbol(TOKEN_TYPE.OCT);                                }
    "]"             { return symbol(TOKEN_TYPE.CCT);                                }
    "{"             { return symbol(TOKEN_TYPE.OCV);                                }
    "}"             { return symbol(TOKEN_TYPE.CCV);                                }
    ">"             { return symbol(TOKEN_TYPE.BT);                                 }
    "<"             { return symbol(TOKEN_TYPE.LT);                                 }
    ":"             { return symbol(TOKEN_TYPE.DDOT);                               }
    "::"            { return symbol(TOKEN_TYPE.DDDOT);                              }
    "."             { return symbol(TOKEN_TYPE.DOT);                                }
    ","             { return symbol(TOKEN_TYPE.CMA);                                }
    "="             { return symbol(TOKEN_TYPE.EQ);                                 }
    "=="            { return symbol(TOKEN_TYPE.EQEQ);                               }
    "!="            { return symbol(TOKEN_TYPE.NEQ);                                }

}

<COMMENT>{
   "{-"     { yybegin(YYINITIAL); } 
   [^"-}"]  { /* Ignora os caracteres dentro do bloco de comentário */ }
   "-}"     { yybegin(YYINITIAL); } // Termina o bloco de comentário
}

// erros
[^]                 { throw new RuntimeException("Illegal character <"+yytext()+">"); }


