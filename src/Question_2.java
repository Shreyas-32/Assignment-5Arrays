public class Question_2 {
    public static int countCompleteRows(int n) {
        int row = 1;
        while (n >= row) {
            n -= row;
            row++;
        }
        return row - 1;
    }

    public static void main(String[] args) {
        int n = 5;
        int completeRows = countCompleteRows(n);
        System.out.println("Number of complete rows: " + completeRows);
    }
}
