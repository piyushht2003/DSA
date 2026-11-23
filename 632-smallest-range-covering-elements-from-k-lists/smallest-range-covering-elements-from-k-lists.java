class Solution {

    public class Triplet implements Comparable<Triplet> {
        int ele;
        int row;
        int col;

        Triplet(int ele, int row, int col) {
            this.ele = ele;
            this.row = row;
            this.col = col;
        }

        public int compareTo(Triplet t) {
            return this.ele - t.ele;
        }
    }

    public int[] smallestRange(List<List<Integer>> arr) {

        int k = arr.size();

        PriorityQueue<Triplet> pq = new PriorityQueue<>();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {

            int ele = arr.get(i).get(0);

            max = Math.max(max, ele);
            min = Math.min(min, ele);

            pq.add(new Triplet(ele, i, 0));
        }

        int a = min;
        int b = max;

        while (true) {

            Triplet top = pq.remove();

            int ele = top.ele;
            int row = top.row;
            int col = top.col;

            if (max - ele < b - a) {
                a = ele;
                b = max;
            }

            if (col + 1 == arr.get(row).size()) {
                break;
            }

            int next = arr.get(row).get(col + 1);

            max = Math.max(max, next);

            pq.add(new Triplet(next, row, col + 1));
        }

        return new int[]{a, b};
    }
}