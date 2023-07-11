package LeetCode;

import java.util.List;

public class _1773_CountItemsMatchingARule {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for (List<String> item : items) {
            switch (ruleKey) {
                case "type" -> count += item.get(0).equals(ruleValue) ? 1 : 0;
                case "color" -> count += item.get(1).equals(ruleValue) ? 1 : 0;
                case "name" -> count += item.get(2).equals(ruleValue) ? 1 : 0;
            }
        }
        return count;
    }
}
