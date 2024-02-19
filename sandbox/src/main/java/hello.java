import java.io.File;

public class hello {
    public static void main(String[] args) {
        System.out.println("hello ");
        System.out.println(2+2);
        System.out.println(2/2);
        System.out.println(2+2*2);
        System.out.println("hello " +" mir");
        System.out.println("2+2 =" +4);
        System.out.println("2+2 =" +2+2);
        System.out.println("2+2 =" +(2+2));

        var configFile= new File("sandbox/build.gradle");
        System.out.println(configFile.getAbsolutePath());
        System.out.println(configFile.exists());
    }

    public static class Geometry {
    }
}
