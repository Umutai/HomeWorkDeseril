package API.POJO;

import org.junit.Test;

public class UsersPojo {
    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    private  Data data;
    private  Ad ad;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
