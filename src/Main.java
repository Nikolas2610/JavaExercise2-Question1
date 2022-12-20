public class Main {
    public static void main(String[] args) {

//        EdgeList e = new EdgeList();
        String test = "2-2";
        String[] parts = test.split("-");
        System.out.println(parts.length);
        System.out.println(Integer.parseInt(parts[0]));
        System.out.println(Integer.parseInt(parts[1]));
        try {
            int num = Integer.parseInt("K");
            System.out.println(num);
            System.out.println("----");
        } catch (NumberFormatException e) {
            // Handle the exception
            System.out.println(e);
        }


    }
}