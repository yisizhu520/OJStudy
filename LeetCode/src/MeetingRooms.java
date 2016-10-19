import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by WangJun on 2016/10/19.
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 For example,
 Given [[0, 30],[5, 10],[15, 20]],
 return false.

 */
public class MeetingRooms {



    public static class Solution{

        class Interval {
            int start;
            int end;
            public Interval(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        /**
         sort the interval based on the start time, if have same start time use end time.
         go through interval to see if there any overlaps.
         时间复杂度：0（nlgn）
         * @param intervals
         * @return
         */
        public boolean canAttendMeetings(Interval[] intervals) {
            Arrays.sort(intervals, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    if(o1.start > o2.start) return 1;
                    if(o1.start < o2.start) return -1;
                    if(o1.end > o2.end) return 1;
                    if(o1.end < o2.end) return -1;
                    return 0;
                }
            });
            for (int i = 0; i < intervals.length-1; i++) {
                if(intervals[i].end >= intervals[i+1].start){
                    return false;
                }
            }
            return true;
        }


    }




}
