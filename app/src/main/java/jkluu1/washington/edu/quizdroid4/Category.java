package jkluu1.washington.edu.quizdroid4;

/**
 * Created by JenniferLuu on 3/5/15.
 */
public class Category {
    private int icon;
    private String sd;
    private String title;

    public Category() {
        super();
    }

    public Category(int icon, String sd, String title) {
        super();
        this.icon = icon;
        this.sd = sd;
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getSd() {
        return sd;
    }

    public void setSd(String sd) {
        this.sd = sd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}