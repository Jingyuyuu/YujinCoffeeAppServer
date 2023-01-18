package tw.myapp.YujinCoffeeAppServer.appdbController;

import java.util.Map;


public class MemberMO {
    int status;
    String mesg;
    Map<String,Object> data;

    public MemberMO(int status) {
        this.status = status;
    }

    public MemberMO(int status, String mesg, Map<String, Object> data) {
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

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
