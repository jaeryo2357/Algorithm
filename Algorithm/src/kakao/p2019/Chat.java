package kakao.p2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

//Solution
//StringTokenizer 매우 빠르다.
public class Chat {

    public static void main(String[] args) {
        String[] board = new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        System.out.println(Arrays.toString(solution(board)));
    }

    public static String[] solution(String[] record) {

        HashMap<String, String> userIds = new HashMap<>();
        ArrayList<ChatLog> log = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            StringTokenizer records = new StringTokenizer(record[i]);

            String command = records.nextToken();
            String userId = records.nextToken();
            String userName = "";

            if (!command.equals("Leave")) {
                userName = records.nextToken();
            }

            if (command.equals("Enter") || command.equals("Change")) {
                userIds.put(userId, userName);

                if (command.equals("Enter")) {
                    log.add(new ChatLog(userId, true));
                }
            } else {
                log.add(new ChatLog(userId, false));
            }
        }

        String[] answer = new String[log.size()];

        for (int i = 0; i < answer.length; i++) {
            ChatLog chat = log.get(i);

            String userName = userIds.get(chat.userId);
            answer[i] = chat.isEnter ? chat.getEnterMessage(userName) : chat.getLeaveMessage(userName);
        }

        return answer;
    }


    static class ChatLog {
        String userId;
        boolean isEnter;

        public ChatLog (String userId, boolean isEnter) {
            this.userId = userId;
            this.isEnter = isEnter;
        }

        public String getEnterMessage(String userName) {
            return userName + "님이 들어왔습니다.";
        }

        public String getLeaveMessage(String userName) {
            return userName + "님이 나갔습니다.";
        }
    }
}
