package tw.myapp.YujinCoffeeAppServer.Model;

import lombok.Data;

@Data
public class Member {
    private String mid;
    private String name;
    private String email;
    private String account;
    private String passed;
    private String phone;
    private String presetStore;
    private String presetPayment;

}
