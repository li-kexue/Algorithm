import java.util.Scanner;

/**
 * @author likexue
 * @create 2019/11/1312:23
 **/
public class Calculator {
    private static MyStack stack1 = new MyStack();
    private static MyStack stack2 = new MyStack();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();
        String[] expressiones = expression.split(" ");
        calculate(expressiones);
        System.out.println(stack1.Top());
    }

    public static void calculate(String[] items){
        for (int i = 0; i < items.length; i++) {
            if (!items[i].equals("(")&&!items[i].equals(")")&&!items[i].equals("+")&&!items[i].equals("-")&&!items[i].equals("*")&&!items[i].equals("/")){
                stack1.push(toNumber(items[i]));
                if (stack2.Top()!=null&&stack2.Top().equals("*")){
                    Integer num2 = (Integer) stack1.pop();
                    Integer num1 = (Integer) stack1.pop();
                    int result = num1 * num2;
                    stack1.push(result);
                    stack2.pop();
                }
                if (stack2.Top()!=null&&stack2.Top().equals("/")){
                    Integer num1 = (Integer) stack1.pop();
                    Integer num2 = (Integer) stack1.pop();
                    int result = num1 / num2;
                    stack1.push(result);
                    stack2.pop();
                }
            }else {
                if (stack2.Top()!=null&&!items[i].equals("*")&&!items.equals("/")){
                    int result = result();
                    stack1.push(result);
                    stack2.push(items[i]);
                }else {
                    stack2.push(items[i]);
                }
            }
        }
        while (stack1.length()!=1){
            int result = result();
            stack1.push(result);
        }
    }
    public static Integer toNumber(String item){
        return Integer.parseInt(item);
    }
    public static Integer result(){
        Integer num2 = (Integer) stack1.pop();
        Integer num1 = (Integer) stack1.pop();
        String option = (String)stack2.pop();
        switch (option){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1*num2;
            case "/":
                return num1/num2;
        }
        return null;
    }
}
