class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Pair, Integer> map = new HashMap<>();
        for (int[] domino : dominoes) {
            Arrays.sort(domino);
            Pair dominoPair = new Pair(domino);
            map.put(dominoPair, map.getOrDefault(dominoPair, 0) + 1);
        }
        int result = 0;
        for (Map.Entry<Pair, Integer> entry : map.entrySet()) {
            int n = entry.getValue();
            if (n > 1) {
                int pairs = n * (n - 1) / 2;
                result += pairs;
            }
        }
        return result;
    }
}

class Pair {
    int v1;
    int v2;

    public Pair(int[] domino) {
        this.v1 = domino[0];
        this.v2 = domino[1];
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Pair pair = (Pair) obj;
        return pair.v1 == this.v1 && pair.v2 == this.v2;
    }

    @Override
    public int hashCode() {
        return this.v1 * 31 + this.v2;
    }

    @Override
    public String toString() {
        return String.format("%d,%d", this.v1, this.v2);
    }
}