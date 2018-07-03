package greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 会议安排问题要求在所给的会议集合中选出最大的相容活动子集，即尽可能在有限的时间内召开更多的会议。
 */
public class MeetingArrangement {

    public static void main(String[] args) {
        int[][] meeting = new int[][]{
                {8, 10},
                {9, 11},
                {10, 15},
                {11, 14},
                {13, 16},
                {14, 17},
                {15, 17},
                {17, 18},
                {18, 20},
                {16, 19},
        };
        List<Meeting> meetings = new ArrayList<>(meeting.length);
        for (int i = 0; i < meeting.length; i++) {
            meetings.add(new Meeting(i, meeting[i][0], meeting[i][1]));
        }
        System.out.println(maxMeetingCount(meetings));
    }

    static class Meeting {
        int number;
        int start;
        int end;

        public Meeting(int number, int start, int end) {
            this.number = number;
            this.start = start;
            this.end = end;
        }
    }

    /**
     * 能参加的会议最多的数目
     * @param meetings
     * @return
     */
    private static int maxMeetingCount(List<Meeting> meetings) {
        int count = 1;
        sortByEndTime(meetings);
        int index = 0;
        for (int i = 1; i < meetings.size(); i++) {
            if (meetings.get(i).start >= meetings.get(index).end) {
                index = i;
                count++;
            }
        }
        return count;
    }

    /**
     * TODO 能参加会议的可能组合
     * @param meetings
     * @return
     */
    private static void maxMeetingDetail(List<Meeting> meetings) {
    }

    private static void sortByEndTime(List<Meeting> meetings) {
        meetings.sort(Comparator.comparingInt(o -> o.end));
    }

}
