import java.util.Scanner;

public class Operation {
    public static final Operation ADD=new Operation('+',0);
    public static final Operation DEC=new Operation('-',0);
    public static final Operation RIDE=new Operation('*',1);
    public static final Operation DIV=new Operation('/',1);
    public static final Operation lp=new Operation('(',10);
    public static final Operation rp=new Operation(')',-10);
    private char type;
    private int pro;
    public char getType()
    {
        return type;
    }
    public int getPro()
    {
        return pro;
    }
    private Operation(char type, int pro)
    {
        super();
        this.type = type;
        this.pro = pro;
    }

    public double computting(double a,double b)
    {
        switch(this.type)
        {
            case '+':
            {
                return a+b;
            }
            case '-':
            {
                return a-b;
            }
            case '*':
            {
                return (a)*(b);
            }
            case '/':
            {
                return (a)/(b);
            }
            default: {
                System.out.println("Неверно введено выражение!");
            }
            }
                System.exit(-1);
                return 0;
            }
    }



