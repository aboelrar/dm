package www.dm.com.Main_Screen.Scenario_messages.model;

public class msg_list {
    String id,name,mshg,date;

    public msg_list(String id, String name, String mshg, String date) {
        this.id = id;
        this.name = name;
        this.mshg = mshg;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMshg() {
        return mshg;
    }

    public void setMshg(String mshg) {
        this.mshg = mshg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
