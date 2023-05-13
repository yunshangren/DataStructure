package solution;

import org.junit.Test;

/**
 * @author Acer
 * @create 2022/11/6 14:33
 */
public class Goal {
    public String interpret(String command) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < command.length()){
            if(command.charAt(i) == 'G'){
                builder.append("G");
                i++;
            }else if(command.charAt(i) == '(' && command.charAt(i + 1) == ')'){
                builder.append("o");
                i += 2;
            }else{
                builder.append("al");
                i += 4;
            }
        }
        return builder.toString();
    }

    @Test
    public void test(){
        String command = "(al)G(al)()()G";
        System.out.println(interpret(command));
    }
}
