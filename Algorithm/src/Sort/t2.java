
package Sort;

class t2 {
    public int solution(String command, String[] buttons, int[] scores) {
        int answer = 0;

        answer = getMaxScore(command, buttons, scores, 0);

        return answer;
    }

    public int getMaxScore(String command, String[] buttons,int[] scores, int current) {
        int max = current + command.length();

        for (int charIndex = 0; charIndex < command.length(); charIndex++) {
            char temp = command.charAt(charIndex);

            for (int buttonIndex = 0; buttonIndex < buttons.length; buttonIndex++) {
                String button = buttons[buttonIndex];
                if (charIndex + button.length() > command.length()) {
                    continue;
                }
                if (button.equals(command.substring(charIndex, charIndex + button.length()))) {
                    String newCommand = command.substring(0, charIndex) + command.substring(charIndex + button.length());
                    int score = getMaxScore(newCommand, buttons, scores, current + scores[buttonIndex]);

                    if (max < score) {
                        max = score;
                    }
                }
            }
        }

        return max;
    }
}