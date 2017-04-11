package guoxuebing.bawei.com.checkboxdemo;

/**
 * Created by acer on 2017/4/10.
 */
public class Goods {
    private boolean flag;
    private String name;
    private float price;

    public Goods(float price, String name, boolean flag) {
        this.price = price;
        this.name = name;
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
