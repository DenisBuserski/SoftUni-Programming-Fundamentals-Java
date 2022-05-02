package Songs_04;

public class Song {
    private String typeList;
    private String name;
    private String time;


    public Song(String typeList, String name, String time) {
        this.typeList = typeList;
        this.name = name;
        this.time = time;
    }

    public String getTypeList(String typeList) {
        return typeList;
    }

    public void setTypeList(String typeList) {
        this.typeList = typeList;
    }


    public String getName(String name) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime(String time) {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public Object getTypeList() {
        return typeList;
    }
    
}
