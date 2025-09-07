public class Main {
    public static void main(String[] args){
        Disk d1 = new Disk(1,Color.RED);
        Disk d2 = new Disk(2, Color.BlACK);
        Disk d3 = new Disk (3, Color.YELLOW);
        Disk d4 = new Disk (4, Color.WHITE);
        Rod r1 = new Rod(5);
        /*System.out.println(r1.toString());
        r1.push(d4);
        r1.push(d3);
        r1.push(d2);
        r1.push(d1);
        System.out.println(r1.toString());
        System.out.println(r1.pop());
        System.out.println(r1.toString());
        System.out.println(r1.peek());
        */
        Tower mytower = new Tower(5);
        System.out.println(mytower.middle.toString());
        System.out.println(mytower.left.toString());
        System.out.println(mytower.right.toString());









    }
}
