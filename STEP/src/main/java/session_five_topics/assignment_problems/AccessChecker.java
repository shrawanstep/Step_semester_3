package session_five_topics.assignment_problems;
import java.util.HashMap;
import java.util.Map;

public class AccessChecker {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        switch (fieldModifier) {
            case "private":
                return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
            case "default":
                return (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) ? "ALLOWED" : "DENIED";
            case "protected":
                if (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE") || accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {
                    return "ALLOWED";
                }
                return "DENIED";
            case "public":
                return "ALLOWED";
            default:
                return "DENIED";
        }
    }

    public static String summarizeByModifier(String[][] attempts) {
        Map<String, int[]> counts = new HashMap<>();
        counts.put("private", new int[]{0, 0});
        counts.put("default", new int[]{0, 0});
        counts.put("protected", new int[]{0, 0});
        counts.put("public", new int[]{0, 0});

        for (String[] attempt : attempts) {
            String mod = attempt[0];
            String ctx = attempt[1];
            if (counts.containsKey(mod)) {
                if ("ALLOWED".equals(classifyAccess(mod, ctx))) {
                    counts.get(mod)[0]++;
                } else {
                    counts.get(mod)[1]++;
                }
            }
        }
        return "private: " + counts.get("private")[0] + " allowed / " + counts.get("private")[1] + " denied | " +
               "default: " + counts.get("default")[0] + " allowed / " + counts.get("default")[1] + " denied | " +
               "protected: " + counts.get("protected")[0] + " allowed / " + counts.get("protected")[1] + " denied | " +
               "public: " + counts.get("public")[0] + " allowed / " + counts.get("public")[1] + " denied";
    }

    public static String firstDeniedAttempt(String[][] attempts) {
        for (int i = 0; i < attempts.length; i++) {
            if ("DENIED".equals(classifyAccess(attempts[i][0], attempts[i][1]))) {
                return attempts[i][0] + " via " + attempts[i][1] + " (attempt #" + (i + 1) + ")";
            }
        }
        return "None Denied";
    }
}
