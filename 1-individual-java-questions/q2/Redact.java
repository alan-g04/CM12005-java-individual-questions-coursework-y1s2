public class Redact {

    public static String redact(String input, String[] redactable) {
        
        if (input == null || redactable == null) return input;

        StringBuilder result = new StringBuilder();
        int length = input.length();
        int i = 0;

        while (i < length) {
            char current = input.charAt(i);

            if (Character.isLetterOrDigit(current)) {
                int j = i;
                
                while (i < length && Character.isLetterOrDigit(input.charAt(i))) i++;
                
                String word = input.substring(j, i);
                boolean shouldRedact = false;

                for (String r : redactable) {
                    if (word.equalsIgnoreCase(r)) {
                        shouldRedact = true;
                        break;
                    }
                }

                if (shouldRedact) {
                    for (int k = 0; k < word.length(); k++) {
                        result.append('#');
                    }
                } else {
                    result.append(word);
                }
            } else {
                result.append(current);
                i++;
            }
        }

        return result.toString();

    }
    
}