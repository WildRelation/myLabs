public class Tower {
    public final Rod left;
    public final Rod middle;
    public final Rod right;
    private int moves;

    public Tower(int noOfDisks){

        left = new Rod(noOfDisks);
        middle = new Rod(noOfDisks);
        right = new Rod(noOfDisks);
        int tmp = noOfDisks;
        Disk[] disks = new Disk[noOfDisks];
        for (int i = 0; i < noOfDisks; i++) {
            disks[i] = new Disk(tmp, Color.BlACK);
            left.push(disks[i]);
            tmp--;
        }
    }

    public boolean isLegalMove(RodPos rod1, RodPos rod2){

    }

    public boolean makeMove(RodPos rod1, RodPos rod2){

    }

    public boolean isSolved(){

    }

    public void initGame(){

    }

}
