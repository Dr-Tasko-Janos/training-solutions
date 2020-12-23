package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {

    private List<Member> member = new ArrayList<>();

    public void addMember(String name) {
        member.add(new Member(name));
    }

    private Member findByName(String name) {
        for (Member item : member) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public void connect(String name1, String name2) {
        findByName(name1).connectMember(findByName(name2));
    }

    public List<String> bidirectionalConnections() {
        List<String> bidirectionalConnectionsList = new ArrayList<>();
        for (Member item1 : member) {
            for (Member item2 : item1.getConnections()) {
                if (item2.getConnections().contains(item1)) {
                    bidirectionalConnectionsList.add(item1.getName() + " - " + item2.getName());
                }
            }
        }
        return bidirectionalConnectionsList;
    }

    @Override
    public String toString(){
        return member.toString();
    }
}
