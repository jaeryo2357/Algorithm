package backjun;

import java.util.HashSet;
import java.util.Scanner;

public class q1062 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        if (k < 5) {
            System.out.println(0);
            return;
        }

        scanner.nextLine(); //버퍼 제거

        HashSet<String> allWord = new HashSet<>();
        String[] wordArray = new String[n];

        for (int i = 0; i < n; i++) {
           String word = scanner.nextLine();
           wordArray[i] = word;

           //주어진 단어에서 사용하는 모든 단어 저장
            for (int c = 0; c < word.length(); c++) {
                allWord.add(word.charAt(c) + "");
            }
        }

        int answer = dfs(k, wordArray, allWord, new HashSet<>());


        System.out.println(answer);
    }


    /**
     * k 개수의 단어를 배워 최대 읽을 수 있는 단어 수를 반환
     * @param allWord 주어진 단어에서 사용하는 문자 모음
     * @return
     */
    public static int dfs(int k, String[] wordArray, HashSet<String> allWord, HashSet<String> usingWord) {

        if (k <= usingWord.size()) {
            //TODO : 읽을 수 있는 단어 측정
            return readWord(wordArray, usingWord);
        } else {
            int maxAnswer = 0;
            HashSet<String> newUsingWord = new HashSet<>(usingWord);

            for (String word : allWord) {

                if (!usingWord.contains(word)) {
                    newUsingWord.add(word);
                    int answer = dfs(k, wordArray, allWord, newUsingWord);
                    newUsingWord.remove(word);

                    if (maxAnswer < answer) {
                        maxAnswer = answer;
                    }
                }
            }

            return maxAnswer;
        }
    }

    public static int readWord(String[] wordArray, HashSet<String> usingWord) {
        int answer = 0;
        boolean isRead;

        for (String word :  wordArray) {
            isRead = true;
            for (int i = 0; i < word.length(); i++) {
                String checkWord = word.charAt(i) + "";
                if (!usingWord.contains(checkWord)) {
                    isRead = false;
                    break;
                }
            }
            if (isRead) {
                answer++;
            }
        }

        return answer;
    }
}
