package Model;

import java.util.Arrays;

public class Robot {

    private int x;
    private int y;
    private String type;
    private byte[] image ;

    public Robot(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.image = new byte[221*1024]; // instead of this byte , in real life there can be one image file.
    }

    @Override
    public String toString() {
        return "Robot{" +
                "x=" + x +
                ", y=" + y +
                ", type='" + type + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
