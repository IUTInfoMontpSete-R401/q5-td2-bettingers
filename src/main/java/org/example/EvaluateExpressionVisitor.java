package org.example;
class EvaluateExpressionVisitor implements ExpressionVisitor {

    private int result;
    public EvaluateExpressionVisitor(){}

    @Override
    public void visit(BinaryExpression be) {
        be.getLeft().accept(this);
        int left = result;
        be.getRight().accept(this);
        int right = result;
        switch(be.getOperator()){
            case PLUS :
                result = left + right;
                break;
            case MINUS:
                result = left - right;
                break;
            case TIMES:
                result = left * right;
                break;
            default:throw new RuntimeException("l'opérateur est inconnu");
        }
    }

    @Override
    public void visit(NumberExpression ne) {
        result = ne.getValue();
    }

    public int getResult() {
        return result;
    }


}