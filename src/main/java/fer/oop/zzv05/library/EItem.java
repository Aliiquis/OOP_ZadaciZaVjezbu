package fer.oop.zzv05.library;

import java.net.URL;

public class EItem extends LibraryItem {
    private URL url;

    public EItem(int id, String name, URL url) {
        super(id, name);
        this.url = url;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    @Override
    public int getLoanPeriod() {
        return 30;
    }

    @Override
    public String toString() {
        return super.toString() + ' ' + url;
    }
}
