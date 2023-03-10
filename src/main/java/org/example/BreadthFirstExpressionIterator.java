package org.example;

import java.util.LinkedList;
import java.util.Queue;

class BreadthFirstExpressionIterator implements ExpressionIterator {

    public Queue<Expression> queue = new LinkedList<>();

    public BreadthFirstExpressionIterator(Expression exp){
        queue.offer(exp);
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public Expression next() {
        Expression courant = queue.poll();
        if(courant instanceof BinaryExpression){
            BinaryExpression be = (BinaryExpression) courant;
            if(be.getLeft() != null){
                queue.offer(be.getLeft());
            }
            if(be.getRight() != null){
                queue.offer(be.getRight());
            }
        }
        return courant;
    }
}