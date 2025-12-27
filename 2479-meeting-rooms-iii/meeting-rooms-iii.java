class Solution {
    public int mostBooked(int n, int[][] meetings) {
        long[] roomAvailable=new long[n];
        int[] meetingCount=new int[n];
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        for(int[] meeting:meetings){
            int startTime=meeting[0];
            int endTime=meeting[1];
            boolean foundUnusedroom=false;  
            int minAvailableroom=0;
            long minRoomAvailable=Long.MAX_VALUE;
            for(int i=0;i<n;i++){
                if(roomAvailable[i]<=startTime){
                    foundUnusedroom=true;
                    meetingCount[i]++;
                    roomAvailable[i]=endTime;
                    break;
                }
                if(minRoomAvailable>roomAvailable[i]){
                    minRoomAvailable=roomAvailable[i];
                    minAvailableroom=i;
                }
            }
            if(!foundUnusedroom){
                roomAvailable[minAvailableroom]+=endTime-startTime;
                meetingCount[minAvailableroom]++;
            }
        }
        int minMeetingcount=0,maxMeetingcount=0;
        for(int i=0;i<n;i++){
            if(meetingCount[i]>minMeetingcount){
                minMeetingcount=meetingCount[i];
                maxMeetingcount=i;
            }
        }
        return maxMeetingcount;
    }
}