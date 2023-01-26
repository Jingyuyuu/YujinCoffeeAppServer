package tw.myapp.YujinCoffeeAppServer.appdbController;

public class orderDetail {
    String name;
    String ice;
    String sugar;
    int price;
    int amount;

    public orderDetail(String name, String ice, String sugar, int price, int amount) {
        this.name = name;
        this.ice = ice;
        this.sugar = sugar;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIce() {
        return ice;
    }

    public void setIce(String ice) {
        this.ice = ice;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
