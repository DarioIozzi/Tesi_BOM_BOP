package Optimization.Cost;

public class CostMatrix {

    private final int n;
    private int costMatrix[];

    CostMatrix(int n) {

        this.n = n;
        costMatrix = new int[n * n];
    }

    private int index(int row, int col) {
        return row * n + col;
    }

    public void setCost(int row, int col, int cost) {
        costMatrix[index(row, col)] = cost;
    }

    public int getCost(int row, int col) {
        return costMatrix[index(row, col)];
    }
}
