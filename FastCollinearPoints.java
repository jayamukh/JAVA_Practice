/* *****************************************************************************
 *  Name: Jaya Mukherjee
 *  Date: 19.09.2021
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FastCollinearPoints {

    private LineSegment[] s;
    private int count;

    public FastCollinearPoints(Point[] p) {
        // finds all line segments containing 4 points
        checkInput(p);

        Point[] points = p.clone();
        Point[] sortedPoints = p.clone();
        this.s = new LineSegment[2];
        this.count = 0;
        List<Point> skipList = new LinkedList<>();

        int n = points.length;
        for (int i = 0; i < n; i++) {
            Point origin = points[i];
            if (shouldSkip(skipList, origin)) {
                continue;
            }
            Arrays.sort(sortedPoints, 0, n, origin.slopeOrder());
            int collSetSize = 1;
            boolean startCount = false;
            int segmentCount = 1;
            for (int j = 1; j < n - 1; j++) {
                if (origin.slopeTo(sortedPoints[j]) == origin.slopeTo(sortedPoints[j + 1])) {
                    collSetSize++;
                    if (!startCount) {
                        startCount = true;
                        segmentCount = j;
                    }
                }
                else if (startCount) {
                    break;
                }
            }

            if (collSetSize >= 3) {
                Point[] collinearSet = new Point[collSetSize + 1];
                collinearSet[0] = origin;
                StdOut.println(collinearSet[0]);
                for (int k = 0; k < collSetSize; k++) {
                    collinearSet[k + 1] = sortedPoints[k + segmentCount];
                    StdOut.println(collinearSet[k + 1]);
                }
                Arrays.sort(collinearSet, 0, collSetSize + 1);

                addSegment(new LineSegment(collinearSet[0], collinearSet[collSetSize]));

                skipList.addAll(Arrays.asList(collinearSet).subList(0, collSetSize + 1));
            }
        }
    }

    private boolean shouldSkip(List<Point> points, Point p) {

        return points
                .stream()
                .anyMatch(point -> point.compareTo(p) == 0);

    }

    private void resize(int capacity) {
        assert capacity >= count;

        LineSegment[] temp = new LineSegment[capacity];
        System.arraycopy(s, 0, temp, 0, count);
        this.s = temp;

    }

    private void addSegment(LineSegment item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (this.count == this.s.length) {
            resize(2 * this.s.length);
        }

        this.s[count++] = item;
    }

    private void checkInput(Point[] p) {
        if (p == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p.length; j++) {

                if (p[i] == null || p[j] == null) {
                    throw new IllegalArgumentException();
                }

                if (i != j && p[i].compareTo(p[j]) == 0) {
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
