package week02;

import java.util.ArrayList;
import java.util.List;

public class Office {
    List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    //function 1:
    public void printNames() {
        System.out.println("\nMeeting rooms in order of registration:\n");
        for (int i = 0; i < meetingRooms.size(); i++) {
            System.out.println("\t" + (i + 1) + " " + meetingRooms.get(i).getName());
        }
    }

    //function 2:
    public void printNamesReverse() {
        System.out.println("\nMeeting rooms in reverse order of registration:\n");
        for (int i = meetingRooms.size() - 1; i >= 0; i--) {
            System.out.println("\t" + (i + 1) + " " + meetingRooms.get(i).getName());
        }
    }

    //function 3:
    public void printEventNames() {
        System.out.println("\nList of every second meeting room of the register:\n");
        for (int i = 1; i <= meetingRooms.size(); i++) {
            if (i % 2 == 0) {
                System.out.println("\t" +
                        i + " " + meetingRooms.get(i - 1).getName());
            }
        }
    }

    //function 4:
    public void printAreas() {
        System.out.println("\nList of meeting room(s) properties:\n");
        for (int i = 0; i < meetingRooms.size(); i++) {
            System.out.println("\t" + (i + 1) + " " + meetingRooms.get(i).getName() +
                    " -- width: " + meetingRooms.get(i).getWidth() +
                    "m -- length: " + meetingRooms.get(i).getLength() +
                    "m -- area: " + meetingRooms.get(i).getArea() + "m\u00B2");
        }
    }

    //function 5:
    public void printMeetingRoomsWithName(String name) {
        System.out.println("\nYou typed the following String: \"" + name +
                "\", which String contained by the name of the following meeting room(s): \n");
        for (MeetingRoom i : meetingRooms) {
            if (i.getName().contentEquals(name)) {
                System.out.println(" * " + i.getName() + ":" +
                        " -- width : " + i.getWidth() +
                        " -- length: " + i.getLength() +
                        " -- area: " + i.getArea());
            }
        }
    }

    //function 6:
    public void printMeetingRoomsContains(String part) {
        System.out.print("\nYou typed the following substring: \"" + part + "\". This substring contained by: \n");
        for (MeetingRoom i : meetingRooms) {
            if (i.getName().toLowerCase().contains(part.toLowerCase())) {
                System.out.println("\n\t* \"" + i.getName() + "\"" +
                        ", which meeting room has the following properties: " +
                        " width: " + i.getWidth() +
                        "m -- length: " + i.getLength() +
                        "m -- area: " + (i.getWidth() * i.getLength()) + "m\u00B2");
            }
        }
    }

    //function 7:
    public void printAreasLargerThan(int area) {
        System.out.println("\nYou typed the following area value: \"" + area + "m\u00B2\"." +
                " Here is the list of the meeting room(s) which has a larger area:\n");
        for (MeetingRoom i : meetingRooms) {
            if (i.getArea() > (double) area) {
                System.out.println("\t* \"" + i.getName() + "\"" +
                        ", which meeting room has the following properties: " +
                        " width: " + i.getWidth() +
                        "m -- length: " + i.getLength() +
                        "m -- area: " + i.getArea() + "m\u00B2");
            }
        }
    }

}


