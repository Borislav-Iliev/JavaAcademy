package LeetCode;

public class _1678_GoalParserInterpretation {

    public String interpret(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }
}
