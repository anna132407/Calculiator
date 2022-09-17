import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Comput {
    private StringBuffer expression;
    private MyStack<Character> op=new MyStack();
    private MyStack<Double> oprands=new MyStack();
    double a=0,b=0;

    public void op_Push(Operation p)
    {
        if(oprands.isEmpty())
        {
            oprands.push(a);
            oprands.push(b);
            oprands.push(a+b);
        }
        if(op.isEmpty())
        {
            op.push(p);
        }
        else
        {
            Operation top=(Operation)op.peek();
            int com=p.getPro()-top.getPro();
            if(com>0)
            {
                op.push(p);
            }
            else
            {
                if(top.getType()=='(')
                {
                    op.push(p);
                }
                else
                {
                    if(com>-10)
                    {
                        op_Pop();
                        op_Push(p);

                    }
                    else
                    {
                        while(((Operation)op.peek()).getType()!='(')
                        {
                            op_Pop();

                        }
                        op.pop();

                    }
                }
            }
        }
    }
    private void op_Pop()
    {
        a=oprands.pop();
        b=oprands.pop();
        Operation t=op.pop();
        double result=t.computting(b,a);
        oprands.push(result);
    }
    public Comput(StringBuffer sb)
    {
        super();
        this.expression = sb;
    }

    public static boolean isRight(String expression){
        if (!expression.matches("[\\d()*/+-]+")) return false;
        Pattern pat = Pattern.compile("[*/+-][*/+-]+");
        Matcher m = pat.matcher(expression);
        if (m.find()) return false;
        return false;
    }

    public double compute()
    {
        int index=0;
        int length=expression.length();
        char ch='\0';
        String num ="";

        while (index <length)
        {
            ch = expression.charAt (index);
            switch(ch)
            {
                case '+':
                {
                    op_Push (Operation.ADD);
                    index++;
                    break;
                }
                case '-':
                {
                    op_Push (Operation.DEC);
                    index++;
                    break;
                }
                case '*':
                {
                    op_Push (Operation.RIDE);
                    index++;
                    break;
                }
                case '/':
                {
                    op_Push (Operation.DIV);
                    index++;
                    break;
                }
                case '(':
                {
                    op_Push (Operation.lp);
                    index++;
                    break ;
                }
                case ')':
                {
                    op_Push (Operation.rp);
                    index++;
                    break;
                }
                default:
                {
                    while(ch>='0'&&ch<='9'||ch=='.')
                    {
                        num+=ch;
                        index++;
                        if(index<length)
                        {
                            ch=expression.charAt(index);
                        }
                        else
                        {
                            break;
                        }
                    }
                    oprands.push (Double.parseDouble (num));
                    num = "";
                }
            }
        }
        while(!op.isEmpty())
        {
            double a = 0, b = 0;
            if(op.equals('('))
            {
                op.pop ();
            }
            else
            {
                a = oprands.pop ();
                b = oprands.pop ();
                Operation t = op.pop ();
                double result = t.computting (b, a);
                oprands.push (result);
            }
        }
        return oprands.pop ();
    }

}
