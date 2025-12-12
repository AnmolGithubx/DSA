import java.util.*;

class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        // 1. Prepare events for sorting
        // We store them as int arrays: [timestamp, type, originalIndex]
        // type: 0 for OFFLINE, 1 for MESSAGE (ensures OFFLINE is processed first on ties)
        List<int[]> sortedEvents = new ArrayList<>();
        
        for (int i = 0; i < events.size(); i++) {
            List<String> event = events.get(i);
            int ts = Integer.parseInt(event.get(1));
            // Map "OFFLINE" to 0 and "MESSAGE" to 1 for sorting priority
            int type = event.get(0).equals("OFFLINE") ? 0 : 1;
            sortedEvents.add(new int[]{ts, type, i});
        }
        
        // 2. Sort the events
        Collections.sort(sortedEvents, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // Sort by timestamp
            }
            return Integer.compare(a[1], b[1]); // Tie-break: OFFLINE(0) before MESSAGE(1)
        });
        
        // 3. Initialize tracking arrays
        int[] mentions = new int[numberOfUsers];
        int[] onlineTime = new int[numberOfUsers]; // Stores the time user is back online
        
        // 4. Process events
        for (int[] se : sortedEvents) {
            int originalIndex = se[2];
            int currentTs = se[0];
            List<String> event = events.get(originalIndex);
            String eventType = event.get(0);
            
            if (eventType.equals("OFFLINE")) {
                int userId = Integer.parseInt(event.get(2));
                // User becomes offline at currentTs, returns at currentTs + 60
                onlineTime[userId] = currentTs + 60;
            } else {
                String mentionString = event.get(2);
                
                if (mentionString.equals("ALL")) {
                    // Mention everyone regardless of status
                    for (int i = 0; i < numberOfUsers; i++) {
                        mentions[i]++;
                    }
                } else if (mentionString.equals("HERE")) {
                    // Mention only online users
                    for (int i = 0; i < numberOfUsers; i++) {
                        // User is online if current time >= time they are back online
                        if (currentTs >= onlineTime[i]) {
                            mentions[i]++;
                        }
                    }
                } else {
                    // Specific IDs: "id0 id1 id0"
                    String[] ids = mentionString.split(" ");
                    for (String idStr : ids) {
                        // Parse "id<number>" -> substring(2) gives the number
                        int userId = Integer.parseInt(idStr.substring(2));
                        mentions[userId]++;
                    }
                }
            }
        }
        
        return mentions;
    }
}