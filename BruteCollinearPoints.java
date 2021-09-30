/* *****************************************************************************
 *  Name: Jaya Mukherjee
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.Arrays;

public class BruteCollinearPoints {

    private LineSegment[] s;
    private int count;

    public BruteCollinearPoints(Point[] p) {
        // finds all line segments containing 4 points

        checkInput(p);

        Point[] points = p.clone();
        this.s = new LineSegment[2];
        this.count = 0;


        int n = points.length;
        Arrays.sort(points);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int m = k + 1; m < n; m++) {
                        if ((points[i].slopeTo(points[j]) == points[j].slopeTo(points[k])) && (
                                points[j]
                                        .slopeTo(points[k]) == points[k].slopeTo(points[m]))) {
                            addSegment(new LineSegment(points[i], points[m]));
                        }
                    }
                }
            }
        }
    }

    private void resize(int capacity) {
        assert capacity >= count;

        LineSegment[] temp = new LineSegment[capacity];
        System.arraycopy(s, 0, temp, 0, count);
        s = temp;

    }

    private void addSegment(LineSegment item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (this.count == s.length) {
            resize(2 * s.length);
        }

        s[count++] = item;
    }

    private void checkInput(Point[] pts) {
        if (pts == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < pts.length; i++) {
            for (int j = 0; j < pts.length; j++) {

                if (pts[i] == null || pts[j] == null) {
                    throw new IllegalArgumentException();
                }

                if (i != j && pts[i].compareTo(pts[j]) == 0) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public int numberOfSegments() {
        // the number of line segments
        return this.count;
    }

    public LineSegment[] segments() {
        // the line segments
        return Arrays.copyOf(this.s, this.count);
    }
}
