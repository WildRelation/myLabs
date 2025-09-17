public class Tower {
    private final Rod left;
    private final Rod middle;
    private final Rod right;
    private int moves;
    private final int noOfDisks;

    public Tower(int noOfDisks){
        if (noOfDisks <= 0) {
            throw new IllegalArgumentException("noOfDisks must be higher than 0");
        }
        this.noOfDisks = noOfDisks;
        left = new Rod(noOfDisks);
        middle = new Rod(noOfDisks);
        right = new Rod(noOfDisks);
        int tmp = noOfDisks;
        Disk[] disks = new Disk[noOfDisks];
        for (int i = 0; i < noOfDisks; i++) {
            disks[i] = new Disk(tmp, Color.BLACK);
            left.push(disks[i]);
            tmp--;
        }
    }

    public void initNewGame(){
        moves = 0;
        left.clear();
        middle.clear();
        right.clear();

        int tmp = noOfDisks;
        Disk[] disks = new Disk[noOfDisks];
        for (int i = 0; i < noOfDisks; i++) {
            disks[i] = new Disk(tmp, Color.BLACK);
            left.push(disks[i]);
            tmp--;
        }
    }

    public int getNoOfDisks(){
        return noOfDisks;
    }
    public int getMoves() {
        return moves;
    }
    public boolean isLegalMove(RodPos fromPos, RodPos toPos) {
        if (fromPos == toPos) return false;

        Rod from = switch (fromPos) {
            case LEFT -> left; case MIDDLE -> middle; case RIGHT -> right;
        };
        Rod to = switch (toPos) {
            case LEFT -> left; case MIDDLE -> middle; case RIGHT -> right;
        };

        if (from.isEmpty()) return false;
        if (to.isEmpty()) return true;
        return to.canPush(from.peek());
    }


    public boolean makeMove(RodPos fromPos, RodPos toPos) {
        if (!isLegalMove(fromPos, toPos)) return false;

        Rod from = switch (fromPos) {
            case LEFT -> left; case MIDDLE -> middle; case RIGHT -> right;
        };
        Rod to = switch (toPos) {
            case LEFT -> left; case MIDDLE -> middle; case RIGHT -> right;
        };

        to.push(from.pop());
        moves++;
        return true;
    }

    public boolean isSolved() {
        return left.isEmpty() && middle.isEmpty() && right.getNumberOfDisks() == noOfDisks;
    }

    public Disk[] getDisks(RodPos pos) {
        return switch (pos) {
            case LEFT   -> left.copyDiskArr();
            case MIDDLE -> middle.copyDiskArr();
            case RIGHT  -> right.copyDiskArr();
        };
    }


    @Override
    public String toString() {
        return "Moves = " + moves + System.lineSeparator() +
                "LEFT:   " + left + System.lineSeparator() +
                "MIDDLE: " + middle + System.lineSeparator() +
                "RIGHT:  " + right;
    }


}