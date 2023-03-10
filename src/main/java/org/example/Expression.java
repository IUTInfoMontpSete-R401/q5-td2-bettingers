package org.example;

abstract class Expression {


    public Expression(){

    }

    public abstract void accept(ExpressionVisitor expressionVisitor);

}