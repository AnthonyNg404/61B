package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation1 {
    private WeightedQuickUnionUF siteFull;
    private WeightedQuickUnionUF siteOpen;
    private int dimension;
    private int[][] grid;
    private int openCount = 0;
    private final int[][] DIRECTION = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    // create N-by-N grid, with all sites initially blocked
    public Percolation1(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        siteFull = new WeightedQuickUnionUF(N * N + 2);
        siteOpen = new WeightedQuickUnionUF(N * N + 1);
        dimension = N;
        grid = new int[N][N];
        setup();
    }

    private void setup() {
        for (int i = 0; i < dimension; i++) {
            siteOpen.union(toIndex(0, i), dimension * dimension);
            siteFull.union(toIndex(0, i), dimension * dimension);
            siteFull.union(toIndex(dimension - 1, i), dimension * dimension + 1);
        }
    }

    private int toIndex(int row, int col) {
        return row * dimension + col;
    }

    // open the site (row, col) if it is not open already
    public void open(int row, int col) {
        checkIndex(row, col);
        if (!isOpen(row, col)) {
            grid[row][col] = 1;
            openCount += 1;
            if (dimension == 1) {
                return;
            }
            for (int[] dir : DIRECTION) {
                int r = row + dir[0]; int c = col + dir[1];
                if (validIndex(r, c) && isOpen(r, c)) {
                    int ind1 = toIndex(row, col);
                    int ind2 = toIndex(r, c);
                    siteFull.union(ind1, ind2);
                    siteOpen.union(ind1, ind2);
                }
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkIndex(row, col);
        return grid[row][col] == 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        checkIndex(row, col);
        if (dimension == 1) {
            return isOpen(0, 0);
        }
        if (isOpen(row, col)) {
            return siteOpen.connected(toIndex(row, col), dimension * dimension);
        }
        return false;
    }

    // number of open sites
    public int numberOfOpenSites() {
        return openCount;
    }

    // does the system percolate?
    public boolean percolates() {
        if (dimension == 1) {
            return isOpen(0, 0);
        }
        return siteFull.connected(dimension * dimension, dimension * dimension + 1);
    }

    private boolean validIndex(int row, int col) {
        if (row < 0 || row > dimension - 1) {
            return false;
        }
        return col >= 0 && col <= dimension - 1;
    }

    private void checkIndex(int row, int col) {
        if (!validIndex(row, col)) {
            throw new IndexOutOfBoundsException();
        }
    }

    // use for unit testing (not required)
    public static void main(String[] args) {
    }

}

