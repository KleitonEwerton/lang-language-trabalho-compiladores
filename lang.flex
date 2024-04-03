
  /*  Esta seção é copiada antes da declaração da classe do analisador léxico gerado.
  *  É nesta seção que se deve incluir imports e declaração de pacotes.
  *  Neste exemplo não temos nada a incluir nesta seção.
  */

%%

  /* Nesta seção são definidas ERs e configurações da ferramenta */

%unicode
%line
%column
%class Lexer

// %function nextToken : nome da funções
// %type Token : tipo do Token retornado
%standalone // somente léxico, sem sintático


%{
  private int ntks;

  private void incTks() { ++ntks; }
  private int numTokens() { return ntks; }
  
%}

%init{
  ntks = 0; // copiado para o construtor
%init}

/* Agora vamos definir algumas macros */
identificador = [:lowercase:] ([:letter:] | [:digit:] | "_" )*
tipo = [:uppercase:] ([:letter:] | [:digit:] | "_" )*

literal_int = [:digit:] [:digit:]*
literal_float = [:digit:]* "." ([:digit:] [:digit:]*)
literal_caractere = \n | \t | \b | \r // verificar utilização das barras

literal_logico = "true" | "false"
literal_nulo = "null"

FimDeLinha  = \r | \n | \r\n
LineComment = "--" (.)* {FimDeLinha}
abre_chave = "{"
fecha_chave = "}"

%state COMMENT

%%

<YYINITIAL>{
    {identificador} { System.out.println("Token VAR: " + yytext());  incTks(); }
    {numero}        { System.out.println("Token NUM: " + yytext());  incTks(); }
    "="             { System.out.println("Token EQ");  incTks();               }
    ";"             { System.out.println("Token SEMI");  incTks();             }
    "*"             { System.out.println("Token TIMES");  incTks();            }
    "+"             { System.out.println("Token PLUS");  incTks();             }
    "/*"            { yybegin(COMMENT);                                        }
    {Brancos}       { /* Não faz nada - Skip */                                }
    {LineComment}   {                                                          }

    // Simbolos reservados
    "("             { System.out.println("Token OPEN_PAREN");  incTks();       }
    ")"             { System.out.println("Token CLOSE_PAREN");  incTks();      }

}

<COMMENT>{
   abre_chave"-"     { yybegin(YYINITIAL); } 
   [^"-"fecha_chave]  {                     }
}

// erros
[^]                 { throw new RuntimeException("Illegal character <"+yytext()+">"); }