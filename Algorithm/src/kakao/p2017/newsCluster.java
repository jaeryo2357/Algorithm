package kakao.p2017;

import java.util.HashMap;

public class newsCluster {

    private static double samStrCount = 0;
    private static double totalStrCount = 0;

    public static void main(String[] args) {
        System.out.println(solution("handshake", "shake hands"));
    }

    public static int solution(String str1, String str2) {
        double answer = 0;

        HashMap<String, Integer> firstStrHash = new HashMap<>();
        HashMap<String, Integer> secondStrHash = new HashMap<>();

        putWordInHash(firstStrHash, str1);
        putWordInHash(secondStrHash, str2);

        for (int i = 0; i < str1.length() - 1 || i < str2.length() - 1; i++) {

            if (i < str1.length() - 1) {
               calculateStrCount(firstStrHash, secondStrHash, str1, i);
            }
            if (i < str2.length() - 1) {
                calculateStrCount(firstStrHash, secondStrHash, str2, i);
            }
        }

        if (samStrCount == 0 && totalStrCount == 0) {
            answer = 1;
        } else {
            answer = samStrCount / totalStrCount;
        }
        return (int)(answer * 65536);
    }

    public static void putWordInHash(HashMap<String, Integer> hash, String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            String s = str.charAt(i) + "" + str.charAt(i + 1);
            if (!s.matches("^[a-zA-Z]{2}")) {
                continue;
            }

            s = s.toUpperCase();
            Integer num = hash.get(s);
            if (num == null) num = 1;
            else num++;

            hash.put(s, num);
        }
    }

    public static void calculateStrCount(HashMap<String, Integer> firstHash, HashMap<String, Integer> secondHash,
                                     String str, int index) {
        String element = str.charAt(index) + "" + str.charAt(index + 1);
        if (!element.matches("^[a-zA-Z]{2}")) {
            return;
        }
        element = element.toUpperCase();

        Integer firstCount = firstHash.get(element);
        Integer secondCount = secondHash.get(element);

        if (firstCount == null) firstCount = 0;
        if (secondCount == null) secondCount = 0;

        samStrCount += Math.min(firstCount, secondCount);
        totalStrCount += Math.max(firstCount, secondCount);

        firstHash.remove(element);
        secondHash.remove(element);
    }
}
