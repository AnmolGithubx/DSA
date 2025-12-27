import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap for free rooms (stores room indices)
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            freeRooms.add(i);
        }

        // Min-heap for busy rooms (stores [end_time, room_index])
        // Sort by end_time, then by room_index if end_times are equal
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });

        int[] meetingCount = new int[n];

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            // Free up rooms that finished before the current meeting starts
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                freeRooms.add((int) busyRooms.poll()[1]);
            }

            if (!freeRooms.isEmpty()) {
                // Assign to the free room with the lowest index
                int room = freeRooms.poll();
                meetingCount[room]++;
                busyRooms.add(new long[]{end, room});
            } else {
                // Delay meeting: wait for the earliest available room
                long[] earliestRoom = busyRooms.poll();
                long newStart = earliestRoom[0];
                int room = (int) earliestRoom[1];
                
                meetingCount[room]++;
                busyRooms.add(new long[]{newStart + duration, room});
            }
        }

        // Find the room with the maximum meetings
        int maxMeetings = -1;
        int resultRoom = -1;
        for (int i = 0; i < n; i++) {
            if (meetingCount[i] > maxMeetings) {
                maxMeetings = meetingCount[i];
                resultRoom = i;
            }
        }

        return resultRoom;
    }
}