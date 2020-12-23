package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private String name;

    private List<Member> connections = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Member> getConnections() {
        return connections;
    }

    public void connectMember(Member member) {
        connections.add(member);
    }

    public String getConnectedName() {
        String markedNames = "";
        for (int i = 0; i < connections.size(); i++) {
            markedNames += (i == connections.size() - 1) ? connections.get(i).getName() : connections.get(i) + ", ";
        }
        return markedNames;
    }

    @Override
    public String toString() {
        return name + " marked as firend the following memebers:" + getConnectedName() + "\n";
    }

    /*
    Bonus task:
    It will not working. The list contains "Member" type elements, and we have to use their getName() methods.

    @Override
    public String toString() {
        return name + " " + connections.toString();
    }*/


}

