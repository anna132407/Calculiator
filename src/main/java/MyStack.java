import java.util.ArrayList;

public class MyStack <T>{
    private ArrayList ll=new ArrayList();

    public <T> T pop()
    {
        return (T) ll.remove(ll.size()-1);
    }

    public void push(Object o)
    {
        ll.add(o);
    }

    public <T> T peek()
    {
        return (T) ll.get(ll.size()-1);
    }

    public boolean isEmpty()
    {
        return ll.isEmpty();
    }

}
