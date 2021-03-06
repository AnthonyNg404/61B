import edu.princeton.cs.algs4.Picture;
import java.util.ArrayList;

public class SeamCarver {

    private Picture pic;
    private ArrayList<Double> energy;
    //ArrayList<Double> energy1;

    public SeamCarver(Picture picture) {
        pic = new Picture(picture);
        energy = new ArrayList<>(pic.width() * pic.height());
        //energy1 = new ArrayList<>(pic.width() * pic.height());
        energySum();
    }

    private void energySum() {
        for (int y = 0; y < pic.height(); y++) {
            for (int x = 0; x < pic.width(); x++) {
                if (y == 0) {
                    energy.add(energy(x, y));
                } else {
                    if (pic.width() == 1) {
                        energy.add(energy(x, y) + energy.get(xyToInt(x, y - 1)));
                    } else if (x == 0) {
                        double a = Math.min(energy.get(xyToInt(x, y - 1)),
                                energy.get(xyToInt(x + 1, y - 1)));
                        energy.add(energy(x, y) + a);
                    } else if (x == pic.width() - 1) {
                        double b = Math.min(energy.get(xyToInt(x, y - 1)),
                                energy.get(xyToInt(x - 1, y - 1)));
                        energy.add(energy(x, y) + b);
                    } else {
                        double c = Math.min(energy.get(xyToInt(x, y - 1)),
                                energy.get(xyToInt(x - 1, y - 1)));
                        double d = Math.min(energy.get(xyToInt(x + 1, y - 1)), c);
                        energy.add(energy(x, y) + d);
                    }
                }
                //System.out.print(energy.get(xyToInt(x, y)) + "    ");
            }
            //System.out.println("     energy sum");
        }
        /*for (int y = 0; y < pic.height(); y++) {
            for (int x = 0; x < pic.width(); x++) {
                energy1.add(energy(x, y));
                //System.out.print(energy1.get(xyToInt(x, y)) + "    ");
            }
            //System.out.println("     energy");
        }*/
    }

    // current picture
    public Picture picture() {
        return new Picture(pic);
    }

    // width of current picture
    public int width() {
        return pic.width();
    }

    // height of current picture
    public int height() {
        return pic.height();
    }

    // energy of pixel at column x and row y
    public double energy(int x, int y) {
        if (x < 0 || x >= pic.width()) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        if (y < 0 || y >= pic.height()) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        int xL;
        int xR;
        int yU;
        int yD;
        if (x == 0) {
            xL = pic.width() - 1;
            xR = x + 1;
        } else if (x == pic.width() - 1) {
            xL = x - 1;
            xR = 0;
        } else {
            xL = x - 1;
            xR = x + 1;
        }
        if (y == 0) {
            yU = pic.height() - 1;
            yD = y + 1;
        } else if (y == pic.height() - 1) {
            yU = y - 1;
            yD = 0;
        } else {
            yU = y - 1;
            yD = y + 1;
        }
        if (pic.height() == 1 && pic.width() == 1) {
            return 0;
        } else if (pic.height() == 1) {
            return getSum(xL, y, xR, y);
        } else if (pic.width() == 1) {
            return getSum(x, yU, x, yD);
        }
        return getSum(xL, y, xR, y) + getSum(x, yU, x, yD);
    }

    private double getSum(int x, int y, int x1, int y1) {
        double red = Math.pow((pic.get(x, y).getRed() - pic.get(x1, y1).getRed()), 2);
        double blue = Math.pow((pic.get(x, y).getBlue() - pic.get(x1, y1).getBlue()), 2);
        double green = Math.pow((pic.get(x, y).getGreen() - pic.get(x1, y1).getGreen()), 2);
        return red + blue + green;
    }

    private int xyToInt(int x, int y) {
        return x + y * pic.width();
    }

    private int toX(int index) {
        return index % pic.width();
    }

    private int toY(int index) {
        return index / pic.width();
    }

    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {
        Picture backup = new Picture(pic);
        Picture p = new Picture(pic.height(), pic.width());
        for (int col = 0; col < p.width(); col++) {
            for (int row = 0; row < p.height(); row++) {
                p.set(col, row, pic.get(row, col));
            }
        }
        pic = p;
        energy.clear();
        //energy1.clear();
        energySum();
        int[] b = findVerticalSeam();
        pic = backup;
        energy.clear();
        //energy1.clear();
        energySum();
        return b;
    }

    // sequence of indices for vertical seam.
    public int[] findVerticalSeam() {
        int [] a = new int[pic.height()];
        double min = Double.MAX_VALUE;
        int y = pic.height() - 1;
        for (int x = 0; x < pic.width(); x++) {
            if (energy.get(xyToInt(x, y)) < min) {
                min = energy.get(xyToInt(x, y));
                a[pic.height() - 1] = x;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            int x = a[i + 1];
            double m = Double.MAX_VALUE;
            for (int j = -1; j < 2; j++) {
                if (x + j < 0) {
                    continue;
                }
                if (x + j >= pic.width()) {
                    continue;
                }
                if (energy.get(xyToInt(x + j, i)) < m) {
                    m = energy.get(xyToInt(x + j, i));
                    a[i] = x + j;
                }
            }
        }
        /* for (int c : a) {
            System.out.print(c + "   ");
        }*/
        return a;
    }

    // remove horizontal seam from picture.
    public void removeHorizontalSeam(int[] seam) {
        if (seam.length > pic.width() || seam.length == 0) {
            throw new java.lang.IllegalArgumentException();
        }
        for (int i = 0; i < seam.length - 1; i++) {
            if (Math.abs(seam[i] - seam[i + 1]) > 1) {
                throw new java.lang.IllegalArgumentException();
            }
        }
        Picture p = new Picture(pic.width(), pic.height() - 1);
        for (int x = 0; x < pic.width(); x++) {
            int i = 0;
            for (int y = 0; y < pic.height() - 1; y++) {
                if (y == seam[x]) {
                    i = 1;
                    continue;
                }
                p.set(x, y, pic.get(x, y + i));
            }
        }
        pic = p;
        energy = new ArrayList<>(pic.width() * pic.height());
        energySum();
    }

    // remove vertical seam from picture.
    public void removeVerticalSeam(int[] seam) {
        if (seam.length > pic.height() || seam.length == 0) {
            throw new java.lang.IllegalArgumentException();
        }
        for (int i = 0; i < seam.length - 1; i++) {
            if (Math.abs(seam[i] - seam[i + 1]) > 1) {
                throw new java.lang.IllegalArgumentException();
            }
        }
        Picture p = new Picture(pic.width() - 1, pic.height());
        for (int y = 0; y < pic.height(); y++) {
            int i = 0;
            for (int x = 0; x < pic.width() - 1; x++) {
                if (x == seam[y]) {
                    i = 1;
                    continue;
                }
                p.set(x, y, pic.get(x + i, y));
            }
        }
        pic = p;
        energy = new ArrayList<>(pic.width() * pic.height());
        energySum();
    }
}
