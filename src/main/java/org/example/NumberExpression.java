package org.example;
class NumberExpression extends Expression {

    private int value;

    public NumberExpression(int value){
        this.value=value;
    }

    public void accept(ExpressionVisitor expressionVisitor){
        expressionVisitor.visit(this);
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return " " + value + " ";
    }
}