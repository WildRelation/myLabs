import java.util.Arrays;

public class Rod {
    private int n = 0;
    private final Disk[] disks;

    public Rod(int capacity){
        // Aggregation
        disks = new Disk[capacity];
    }

    public boolean canPush(Disk disk){
        if(!isEmpty()) return disk.diameter() < disks[n-1].diameter();
        return true;
    }

    public void push(Disk disk){
        if(canPush(disk)){
            disks[n] = disk;
            n++;
        }
        else throw new IllegalArgumentException("Invalid action");
    }


    public Disk pop(){
        if(isEmpty()) throw new IllegalCallerException("Empty Rod!");
        else{
            Disk tmp = disks[n-1];
            disks[n-1] = null;
            n--;
            return tmp;
        }
    }

    public Disk peek(){
        return disks[n-1];
    }

    public void clear(){
        for (int i = 0; i < n; i++) {
            disks[i] = null;
        }
        n = 0;
    }

    public int getNumberOfDisks(){
        return n;
    }


    public boolean isEmpty(){
        return n==0;
    }

    @Override
    public String toString() {
        return "Rod{" +
                "n=" + n +
                ", disks=" + Arrays.toString(disks) +
                '}';
    }
}
