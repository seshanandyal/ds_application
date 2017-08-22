package com.veda;

import java.util.ArrayList;
import java.util.List;

public class MergingRanges {
	static List<Meeting> sMeetingList = new ArrayList<>();
	
	public static void main(String[] args) {
		mergedMeetingRanges(new Meeting(1, 5));
		mergedMeetingRanges(new Meeting(2, 3));

		
		displayMergedList();
	}
	
	static void displayMergedList() {
		for(Meeting meeting: sMeetingList) {
			System.out.println(meeting);
		}
	}
	
	static void mergedMeetingRanges(Meeting meeting) {
		if(sMeetingList.size() == 0) {
			sMeetingList.add(meeting);
			return;
		}
		
		Meeting lastMeeting = sMeetingList.get(sMeetingList.size()-1);
		
		if((lastMeeting.getEndTime() > meeting.getStartTime()) &&
				(lastMeeting.getStartTime() < meeting.getStartTime())) {
			if(lastMeeting.getEndTime() < meeting.getEndTime()) {
				lastMeeting.setEndTime(meeting.getEndTime());		
			}
			return;
		} else if(lastMeeting.getEndTime() == meeting.getStartTime()) {
			lastMeeting.setEndTime(meeting.getEndTime());
			return;
		} else if(lastMeeting.getStartTime() == meeting.getEndTime()) {
			lastMeeting.setStartTime(meeting.getStartTime());
			return;
		}
		sMeetingList.add(meeting);
	}

}

class Meeting {

    private int startTime;
    private int endTime;

    public Meeting(int startTime, int endTime) {
        // number of 30 min blocks past 9:00 am
        this.startTime = startTime;
        this.endTime   = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
    
    public String toString() {
    	return "start: " + startTime + ", end: " + endTime;
    }
}