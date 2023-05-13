package solution;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/10/27 19:07
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
       return s.replaceAll(" ","%20");

    }
    @Test
    public void test(){
        String s = "we are happy";
        System.out.println(replaceSpace(s));
    }
}
