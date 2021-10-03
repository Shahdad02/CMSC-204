/**
 * @author Shahdad Parsi
 */
public class Notation {
    /**
     * evaluates the postfix expression
     * @param postfixExpr used to be converted
     * @return converted postfix to infix
     * @throws InvalidNotationFormatException
     */
    public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException{
        NotationStack<String> stack = new NotationStack<String>();
        char[] chr = postfixExpr.toCharArray();
        String one, two;
        double result = 0;

        try{
            for(int i = 0; i < chr.length; i++){
                if(chr[i] == ' '){
                    continue;
                }else if(Character.isDigit(chr[i]) || chr[i] == '('){
                    stack.push(String.valueOf(chr[i]));
                }else{
                    if(stack.size() < 2){
                        throw new InvalidNotationFormatException();
                    }else{
                        one = stack.pop();
                        two = stack.pop();
                        result = calc(one, two, chr[i]);
                        stack.push(Double.toString(result));
                    }
                }
            }

            if(stack.size() > 1){
                throw new InvalidNotationFormatException();
            }
        }catch(StackOverflowException e){
            e.printStackTrace();
        }catch(StackUnderflowException ex){
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * completes the calculation between variables
     * @param one parsed as a double to compute
     * @param two parsed as a double to compute
     * @param chr operator used to calculate two variables
     * @return calculation result
     */
    private static double calc(String one, String two, char chr){
        double first, second;
        double result = 0;

        switch (chr){
            case '+':
                first = Double.parseDouble(one);
                second = Double.parseDouble(two);
                result = first + second;
                break;

            case '-':
                first = Double.parseDouble(one);
                second = Double.parseDouble(two);
                result = first - second;
                break;

            case '*':
                first = Double.parseDouble(one);
                second = Double.parseDouble(two);
                result = first * second;
                break;

            case '/':
                first = Double.parseDouble(one);
                second = Double.parseDouble(two);
                result = first / second;
                break;
        }
        return result;
    }

    /**
     * convert postfix to infix
     * @param postfix expression used to convert
     * @return infix expression converted
     * @throws InvalidNotationFormatException
     */
    public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException{
        NotationStack<String> stack = new NotationStack<String>();
        char[] chr = postfix.toCharArray();
        String infix, top;

        try{
            for(int i = 0; i < chr.length; i++){
                if(chr[i] == ' '){
                    continue;
                }else if(Character.isDigit(chr[i])){
                    stack.push(String.valueOf(chr[i]));
                }else if(chr[i] == '+' || chr[i] == '-' || chr[i] == '*'|| chr[i] == '/'){
                    if(stack.size() < 2){
                        throw new InvalidNotationFormatException();
                    }else{
                        top = stack.pop();
                        infix = "(" + stack.pop() + chr[i] + top + ")";
                        stack.push(infix);
                    }
                }
            }

            if(stack.size() > 1){
                throw new InvalidNotationFormatException();
            }
        }catch(StackUnderflowException e){
            e.printStackTrace();
        }catch(StackOverflowException ex){
            ex.printStackTrace();
        }
        return stack.toString();
    }

    /**
     * converts infix to postfix
     * @param infix used to convert
     * @return completed postfix converted
     * @throws InvalidNotationFormatException
     */
    public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException{
        NotationStack<String> stack = new NotationStack<String>();
        NotationQueue<String> queue = new NotationQueue<String>();
        char[] chr = infix.toCharArray();

        try{
            for(int i = 0; i < chr.length; i++){
                if(chr[i] == ' '){
                    continue;
                }else if(Character.isDigit(chr[i])){
                    queue.enqueue(String.valueOf(chr[i]));
                }

                if(chr[i] == '('){
                    stack.push(String.valueOf(chr[i]));
                }

                if(chr[i] == '+'){
                    if(!stack.isEmpty()){
                        while(stack.top().equals("+") || stack.top().equals("-") || stack.top().equals("*") || stack.top().equals("/")){
                            queue.enqueue(stack.pop());
                        }
                    }
                    stack.push(String.valueOf(chr[i]));
                }

                if(chr[i] == '-'){
                    if(!stack.isEmpty()){
                        while(stack.top().equals("+") || stack.top().equals("-") || stack.top().equals("*") || stack.top().equals("/")){
                            queue.enqueue(stack.pop());
                        }
                    }
                    stack.push(String.valueOf(chr[i]));
                }

                if(chr[i] == '*'){
                    if(!stack.isEmpty()){
                        while(stack.top().equals("+") || stack.top().equals("-") || stack.top().equals("*") || stack.top().equals("/")){
                            queue.enqueue(stack.pop());
                        }
                    }
                    stack.push(String.valueOf(chr[i]));
                }

                if(chr[i] == '/'){
                    if(!stack.isEmpty()){
                        while(stack.top().equals("+") || stack.top().equals("-") || stack.top().equals("*") || stack.top().equals("/")){
                            queue.enqueue(stack.pop());
                        }
                    }
                    stack.push(String.valueOf(chr[i]));
                }

                if(chr[i] == ')'){
                    while(!stack.isEmpty() && stack.top().equals("(")){
                        queue.enqueue(stack.pop());
                    }

                    if(stack.isEmpty() || !stack.top().equals("(")){
                        throw new InvalidNotationFormatException();
                    }

                    if(!stack.isEmpty() && stack.top().equals("(")){
                        stack.pop();
                    }
                }
            }

//            while(!stack.isEmpty() || !stack.top().equals("(")){
//                queue.enqueue(stack.pop());
//            }

        }catch(QueueOverflowException e){
            e.printStackTrace();
        }catch(StackOverflowException ex){
            ex.printStackTrace();
        }catch(StackUnderflowException ex2){
            ex2.printStackTrace();
        }
        return queue.toString();
    }
}
