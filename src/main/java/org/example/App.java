package org.example;

public class App {

    public static void main(String[] args) {
        // Construire l'arbre d'expression
        Expression one = new NumberExpression(1);
        Expression two = new NumberExpression(2);
        Expression three = new NumberExpression(3);
        Expression four = new NumberExpression(4);

        Expression add = new BinaryExpression(one,Operator.PLUS,  two);
        Expression subtract = new BinaryExpression(three,Operator.MINUS,  four);
        Expression multiply = new BinaryExpression(add,Operator.TIMES,  subtract);

        // Parcours en profondeur
        System.out.println("Depth First Iteration:");
        ExpressionIterator depthFirstIterator = new DepthFirstExpressionIterator(multiply);
        while (depthFirstIterator.hasNext()) {
            System.out.println(depthFirstIterator.next());
        }

        // Parcours en largeur
        System.out.println("\nBreadth First Iteration:");
        ExpressionIterator breadthFirstIterator =  new BreadthFirstExpressionIterator(multiply);
        while (breadthFirstIterator.hasNext()) {
            System.out.println(breadthFirstIterator.next());
        }

        ExpressionVisitor evaluateVisitor = new EvaluateExpressionVisitor();
        multiply.accept(evaluateVisitor);
        System.out.println("The result of the expression is: " + ((EvaluateExpressionVisitor) evaluateVisitor).getResult());

        ExpressionVisitor opVisitor = new OperatorExpressionVisitor();
        multiply.accept(opVisitor);
        System.out.println("The expression contains " + ((OperatorExpressionVisitor) opVisitor).getAdd()+ " additions " + ((OperatorExpressionVisitor) opVisitor).getSub() + " substractions " + ((OperatorExpressionVisitor) opVisitor).getMult() + " multiplications "  );
    }
}

