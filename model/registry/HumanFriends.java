package model.registry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.member.HumanFriendsItem;

public class HumanFriends<HF extends HumanFriendsItem> implements Serializable, Iterable<HF> {
    private List<HF> humanFriends;

    public HumanFriends(){
        this(new ArrayList<>());
    }

    public HumanFriends(List<HF> humanFriends) {
        this.humanFriends = humanFriends;
    }

    public List<HF> getHumanFriends() {
        return humanFriends;
    }

    public HF getHumanFriendsMemberById (Integer id) {
        return humanFriends.get(id);
    }

    public boolean addHumanFriendsMember(HF member) {
        if(member == null) {
            return false;
        }

        if(!humanFriends.contains(member)) {
            humanFriends.add(member);
            return true;
        }
        return false;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("In the registry: ");
        sb.append(humanFriends.size());
        sb.append(" animals: \n");
        for(HF member: humanFriends){
            sb.append(member);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void printItemsByDate(){

    };
    
    public String printItemsByAnimalType(){
    
        return "";
    };

    @Override
    public Iterator<HF> iterator() {
        return new HumanFriendsMemberIterator<>(humanFriends);
    }

    public boolean remove(HF member) {
        return humanFriends.remove(member);
    }

    public void sortByBirthdate() {
        humanFriends.sort(new HumanFriendsCompareByBirthDate<>());
    }

}
