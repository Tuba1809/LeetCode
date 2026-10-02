import java.util.*;

class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {

        int[] mentions = new int[numberOfUsers];
        int[] offlineUntil = new int[numberOfUsers];

        // Sort by timestamp
        // For the same timestamp, OFFLINE must come before MESSAGE
        events.sort((a, b) -> {
            int timeA = Integer.parseInt(a.get(1));
            int timeB = Integer.parseInt(b.get(1));

            if (timeA != timeB) {
                return timeA - timeB;
            }

            if (a.get(0).equals(b.get(0))) {
                return 0;
            }

            return a.get(0).equals("OFFLINE") ? -1 : 1;
        });

        for (List<String> event : events) {

            String type = event.get(0);
            int time = Integer.parseInt(event.get(1));

            // OFFLINE event
            if (type.equals("OFFLINE")) {

                int user = Integer.parseInt(event.get(2));

                offlineUntil[user] = time + 60;
            }

            // MESSAGE event
            else {

                String message = event.get(2);

                // ALL -> mention every user
                if (message.equals("ALL")) {

                    for (int i = 0; i < numberOfUsers; i++) {
                        mentions[i]++;
                    }
                }

                // HERE -> mention only online users
                else if (message.equals("HERE")) {

                    for (int i = 0; i < numberOfUsers; i++) {

                        if (time >= offlineUntil[i]) {
                            mentions[i]++;
                        }
                    }
                }

                // Individual IDs
                else {

                    String[] tokens = message.split(" ");

                    for (String token : tokens) {

                        if (token.startsWith("id")) {

                            int user = Integer.parseInt(token.substring(2));

                            mentions[user]++;
                        }
                    }
                }
            }
        }

        return mentions;
    }
}