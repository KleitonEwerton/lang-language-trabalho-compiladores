
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
ASCII = [\x00-\x7F]
identificador = [:lowercase:] ([:letter:] | [:digit:] | "_" )*
tipo = [:uppercase:] ([:letter:] | [:digit:] | "_" )*
literal_int = ("-")? [:digit:] [:digit:]*
literal_float = ("-")? [:digit:]* "." ([:digit:] [:digit:]*)
literal_caractere = "\'" ([:letter:]) "\'" | "\'\\n\'" | "\'\\t\'" | "\'\\b\'" | "\'\\r\'" | "\'" "\\" "\\" "\'" | "\'" {ASCII} "\'" 
literal_logico = "true" | "false"
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
    "return"        { return symbol(TOKEN_TYPE.RET);                                }

    //linguagem
    {identificador} { System.out.print("ID: "); return symbol(TOKEN_TYPE.ID);                                       }
    {literal_float} { System.out.print("FLOAT: "); return symbol(TOKEN_TYPE.VAL_FLOAT, Float.parseFloat(yytext())); }
    {literal_int}   { System.out.print("INT: "); return symbol(TOKEN_TYPE.VAL_INT, Integer.parseInt(yytext()));     }
    {literal_logico} { return symbol(TOKEN_TYPE.LITERAL_LOGICO);                                                    }
    {literal_caractere}  { return symbol(TOKEN_TYPE.LITERAL_CARACTERE);                                             }
    {tipo} {return symbol(TOKEN_TYPE.TYPE);                                                                         }   
    "{-"            { yybegin(COMMENT);                                                                             }
    {Brancos}       {                                                                                               }
    {LineComment}   {                                                                                               }

    // operadores e separadores

    // nivel 7
    "["             { return symbol(TOKEN_TYPE.OCT);                                }
    "]"             { return symbol(TOKEN_TYPE.CCT);                                }
    "."             { return symbol(TOKEN_TYPE.DOT);                                }
    "("             { return symbol(TOKEN_TYPE.OPT);                                }
    ")"             { return symbol(TOKEN_TYPE.CPT);                                }
    "{"             { return symbol(TOKEN_TYPE.OCV);                                }
    "}"             { return symbol(TOKEN_TYPE.CCV);                                }

    // nivel 6
    "!"             { return symbol(TOKEN_TYPE.NOT);                                }

    // nivel 5
    "*"             { return symbol(TOKEN_TYPE.TIMES);                              }
    "/"             { return symbol(TOKEN_TYPE.DIV);                                }
    "%"             { return symbol(TOKEN_TYPE.MOD);                                }

    // nivel 4
    "+"             { return symbol(TOKEN_TYPE.PLUS);                               }
    "-"             { return symbol(TOKEN_TYPE.MINUS);                              }    
    
    // nivel 3
    "<"             { return symbol(TOKEN_TYPE.LT);                                 }
    ">"             { return symbol(TOKEN_TYPE.BT);                                 }

    // nivel 2
    "=="            { return symbol(TOKEN_TYPE.EQEQ);                               }
    "!="            { return symbol(TOKEN_TYPE.NEQ);                                }
    
    // nivel 1
    "&&"            { return symbol(TOKEN_TYPE.AND);                                }
    ";"             { return symbol(TOKEN_TYPE.SEMI);                               }
    ":"             { return symbol(TOKEN_TYPE.DDOT);                               }
    "::"            { return symbol(TOKEN_TYPE.DDDOT);                              }
    ","             { return symbol(TOKEN_TYPE.CMA);                                }
    "="             { return symbol(TOKEN_TYPE.EQ);                                 }
        
}

<COMMENT>{
   "{-"     { yybegin(YYINITIAL); } 
   [^"-}"]  { /* Ignora os caracteres dentro do bloco de comentário */ }
   "-}"     { yybegin(YYINITIAL); } // Termina o bloco de comentário
}

// erros
[^]                 { throw new RuntimeException("Illegal character <"+yytext()+">"); }


