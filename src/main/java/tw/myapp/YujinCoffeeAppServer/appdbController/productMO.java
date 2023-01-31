package tw.myapp.YujinCoffeeAppServer.appdbController;

import java.util.List;
import java.util.Map;

public class productMO {
    int status;
    String mesg;
    List<Map<String,Object>> data;

    public productMO(int status, String mesg, List<Map<String, Object>> data) {

        this.status = status;
        this.mesg = mesg;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }

    public List<Map<String, Object>> getData() {
        return data;
    }

    public void setData(List<Map<String, Object>> data) {
        this.data = data;
    }

}
