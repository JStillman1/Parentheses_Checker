import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParenthesesChecker {

    private List<String> stringToArray (String s){
        List<String> stringList = new ArrayList<>();
        for(int i = 0, n = s.length() ; i < n ; i++) {
            stringList.add(s.substring(i, i+1));
        }
        return stringList;
    }

    private String giveOpenBracket(String s){
        switch(s){
            case ")":
                return "(";
            case "}":
                return "{";
            case "]":
                return "[";
            case ">":
                return "<";
        }
        return "Uh oh!";
    }

    public boolean checkParentheses(String s) {

        Stack<String> bracketStack = new Stack<>();
        List<String> stringList = stringToArray(s);

        for(String c : stringList) {
            if (c.equals("(") || c.equals("{") || c.equals("[") || c.equals("<")){
                bracketStack.push(c);
            }
            else if(c.equals(")")|| c.equals("}") || c.equals("]") || c.equals(">")){
                if(bracketStack.size() == 0){
                    return false;
                }
                else if(giveOpenBracket(c).equals(bracketStack.peek())){
                    bracketStack.pop();
                }
            }
        }

        return(bracketStack.isEmpty());
    }

}
