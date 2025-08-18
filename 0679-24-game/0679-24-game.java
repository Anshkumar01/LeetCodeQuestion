class Solution {
    public boolean judgePoint24(int[] cards) {
    return judgePoint24(new double[]{cards[0], cards[1], cards[2], cards[3]});
}

private boolean judgePoint24(double[] cards) {
    var n = cards.length;

    if (n == 1)
        return isResult24(cards);

    for (var i = 0; i < n; i++)
        for (var j = i + 1; j < n; j++) {

            var m = 0;
            var cards2 = new double[n - 1];

            for (var k = 0; k < n; k++)
                if (k != i && k != j)
                    cards2[m++] = cards[k];

            for (var result : compute(cards[i], cards[j])) {
                cards2[cards2.length - 1] = result;

                if (judgePoint24(cards2))
                    return true;
            }
        }

    return false;
}

private double[] compute(double x, double y) {
    return new double[]{
            x + y,
            x - y,
            y - x,
            x * y,
            x / y,
            y / x
    };
}

private boolean isResult24(double[] cards) {
    return Math.abs(cards[0] - 24) < 0.0001;
}
}