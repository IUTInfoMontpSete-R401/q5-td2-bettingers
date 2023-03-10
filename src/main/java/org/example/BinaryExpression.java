package org.example;

class BinaryExpression extends Expression {

    private Expression left;
    private Expression right;
    private Operator operator;
    public BinaryExpression(Expression left, Operator operator, Expression right){
        this.left=left;
        this.right=right;
        this.operator=operator;

    }

    public Expression getLeft(){
        return left;
    }

    public Expression getRight(){
        return right;
    }

    public Operator getOperator(){
        return operator;
    }

    @Override
    public String toString() {
        return "" + left +
                operator +
                 right;
    }

    public void accept(ExpressionVisitor expressionVisitor){
        expressionVisitor.visit(this);

    }


}