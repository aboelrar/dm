package www.dm.com.Main_Screen.Scenario_Previous_Analyzis.model;

public class previous_anal_list {
    String id,date,result;

    public previous_anal_list(String id, String date, String result) {
        this.id = id;
        this.date = date;
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
