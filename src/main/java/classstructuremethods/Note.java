package classstructuremethods;

public class Note {

    private String name, topic, text;

    //Setters:
    public void setName(String name) {
        this.name = name;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setText(String text) {
        this.text = text;
    }

    //Full query getter:
    public String getNoteText(){
        return name + ": (" + topic + ") " + text;
    }
}
