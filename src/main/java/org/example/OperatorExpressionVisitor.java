package org.example;
class OperatorExpressionVisitor implements ExpressionVisitor {

    private int sub = 0;
    private int add = 0;
    private int mult = 0;
    public OperatorExpressionVisitor(){}

    public int getSub() {
        return sub;
    }

    public int getAdd() {
        return add;
    }

    public int getMult() {
        return mult;
    }

    @Override
    public void visit(NumberExpression ne) {
    }

    @Override
    public void visit(BinaryExpression be) {
        be.getLeft().accept(this);
        be.getRight().accept(this);
        switch(be.getOperator()){
            case PLUS :
                add++;
                break;
            case MINUS:
                sub++;
                break;
            case TIMES:
                mult++;
                break;
            default:throw new RuntimeException("l'opérateur est inconnu");
        }
    }
}