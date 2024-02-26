public class hello {
    public static void main(String[] args) {

       var x=1;
       var y=1;
       if (y==0){
           System.out.println("деление на 0 запрещено");
       } else {
           var z = (double) divide(x, y);
           System.out.println("успешно отработало ");
       }

        }


    private static int divide(int x, int y){
        var z =x/y;
        return z;
    }


    public static class Geometry {
    }
}
