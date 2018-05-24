package mybatis;

import java.io.InputStream;

public class BlobTable {
    private int key;
    private InputStream image;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }
}
