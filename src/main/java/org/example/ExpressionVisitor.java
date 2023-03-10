package org.example;



interface ExpressionVisitor {

   public void visit(NumberExpression ne);

   public void visit(BinaryExpression be);

}
