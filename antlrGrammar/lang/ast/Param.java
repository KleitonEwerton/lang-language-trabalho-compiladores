package lang.ast;

import java.util.ArrayList;
/*
 * Esta classe representa um comando de Impressão.
 * Expr
 */
import java.util.HashMap;
import java.util.List;

import lang.visitors.*;
import lang.ast.*;
import lang.parser.*;

/*
 * params: ID TYPE_SRO type (TYPE_COMMA ID TYPE_SRO type)* #paramsName
 */

public class Param extends Node {

      private List<String> id; // ID do parâmetro
      private List<Type> type; // Tipo do parâmetro

      public Param(int line, int column, List<String> id, List<Type> type) {
            super(line, column);
            this.id = id;
            this.type = type;
      }

      public Param(int line, int column) {
            super(line, column);
            this.id = new ArrayList<String>();
            this.type = new ArrayList<Type>();
      }

      public List<String> getId() {
            return id;
      }

      public void setId(List<String> id) {
            this.id = id;
      }

      public List<Type> getType() {
            return type;
      }

      public void setType(List<Type> type) {
            this.type = type;
      }

      @Override
      public void accept(Visitor v) {
            v.visit(this);
      }

}
