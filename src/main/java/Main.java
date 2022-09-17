import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException
    {
        for(;;) {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println ("Введите пример");
        String expression=br.readLine();
        int index = 0;
        StringBuffer sb = new StringBuffer (expression);
        if (sb.charAt (0)!= '+' || sb.charAt (0)!= '-')
        {
            sb.insert(0, '+');
        }
        sb.append('+');
        while (index <sb.length ())
        {
            if (sb.charAt (index) == '(')
            {
                sb.insert (index + 1, '0');
                if (sb.charAt (index + 2)!= '-')
                {
                    sb.insert(index+2, '+');
                }
            }
            if (sb.charAt (index) == '[')
            {
                sb.replace(index, index+1, "(");
            }
            if (sb.charAt (index) == ']')
            {
                sb.replace(index, index+1, ")");
            }
            if (sb.charAt (index) == '{')
            {
                sb.replace(index, index+1, "(");
            }
            if (sb.charAt (index) == '}')
            {
                sb.replace(index, index+1, ")");
            }
            if (sb.charAt (index) == ' ')
            {
                sb.replace(index, index+1, "");
            }
            index++;
        }
        Comput com=new Comput(sb);
        double result=com.compute();
        System.out.println ("Результат:" + result);
        System.out.println("Для завершения нажмите q. Для продолжения нажмите любую клавишу");
            Scanner scanner = new Scanner(System.in);
            String a = scanner.nextLine();
        char i = a.charAt(0);
        if (i == 'q') break;
    }
    }
}
