package org.example;


import java.util.ArrayList;
import java.util.List;

class DepthFirstExpressionIterator implements ExpressionIterator {

    private List<Expression> list = new ArrayList<>();

    private int index = 0;

    public DepthFirstExpressionIterator(Expression exp){
        dfs(exp);

    }

    public void dfs(Expression exp){
        if(exp != null){
            if(exp instanceof BinaryExpression){
                dfs(((BinaryExpression) exp).getLeft());
                list.add(exp);
                dfs(((BinaryExpression) exp).getRight());
            }
            else{
                list.add(exp);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public Expression next() {
        return list.get(index++);
    }

    @Override
    public String toString() {
        return "" +
                 list +
                 index;
    }
}