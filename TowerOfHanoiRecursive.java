public class TowerOfHanoiRecursive {
    public static void moveDisks(int n, char source, char target, char auxiliary) {
        if (n == 1) {
            System.out.println("Move disk from " + source + " to " + target);
        } else {
            moveDisks(n - 1, source, auxiliary, target);
            System.out.println("Move disk from " + source + " to " + target);
            moveDisks(n - 1, auxiliary, target, source);
        }
    }

    public static void main(String[] args) {
        int n = 3; // Number of disks
        moveDisks(n, 'A', 'C', 'B'); // A, B, and C are the pegs
    }
}
