 /*  Trabalho da disciplina DCC045 - Teoria dos Compiladores
  *  Kleiton Ewerton de Oliveira - MAT 202065050C
  *  Nikolas Oliver Sales Genesio - MAT 202065072C
  */
  
package lang.ast;

import java.util.ArrayList;

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

      public int size() {
            return id.size();
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

      public String getSingleId(int id) {
            return this.id.get(id);
        }
    
        public Type getSingleType(int type) {
            return this.type.get(type);
        }

        public void addParameter(String id, Type type) {
            this.id.add(id);
            this.type.add(type);
        }

      @Override
      public String toString() {
            String str = "";
            for (int i = 0; i < id.size(); i++) {
                  str += id.get(i) + " " + type.get(i) + " ";
            }
            return str;
      }

      @Override
      public void accept(Visitor v) {
            v.visit(this);
      }

}
