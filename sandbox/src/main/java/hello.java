public class hello {
    public static void main(String[] args) {
       try { System.out.println("hello ");
       var x=1;
       var y=0;
        int z = divide(x, y);
        System.out.println(z);
       }
       catch (ArithmeticException exception)
    {
          // System.out.println(exception.getMessage());
        exception.printStackTrace();
        }
        }

    private static int divide(int x, int y){
        var z =x/y;
        return z;
    }


    public static class Geometry {
    }
}
