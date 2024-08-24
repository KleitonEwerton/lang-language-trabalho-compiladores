package lang.ast;

public class Node extends SuperNode {
    
    private int line,col;

    public Node()
    {
        super();
    }

    public Node(int l, int c){
        super();
        line = l;
        col = c;
   }

   
   public int getLine(){ return line;}

   public int getColumn(){ return col;}
}
