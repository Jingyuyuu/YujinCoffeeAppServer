package tw.myapp.YujinCoffeeAppServer.appdbController;

public class orderMst {
    String email;
    String date;

    public orderMst(String email, String date,orderDetail OrderDetail) {
        this.email = email;
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
