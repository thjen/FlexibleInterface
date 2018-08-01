package qthjen_dev.io.flexibleinterface;

import java.io.Serializable;

public class MyModel implements Serializable {

    public String title;
    public String body;

    public MyModel(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
