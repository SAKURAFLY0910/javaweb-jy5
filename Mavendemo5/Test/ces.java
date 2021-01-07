import org.junit.Test;

public class ces {
    @Test
    public void cshi1(){
        StringBuffer s=new StringBuffer(10);

        s.append("1234");
        System.out.println(s);
        System.out.println(s.length());
        System.out.println(s.capacity());
    }
}
