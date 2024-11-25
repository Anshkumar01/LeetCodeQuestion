class Solution {
    int[][] DIR = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int slidingPuzzle(int[][] board) {
        //convert board to string
        String startBoard = getBoard(board);
        String targetBoard = "123450";

        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(startBoard);
        visited.add(startBoard);
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentBoard = queue.poll();
                if (currentBoard.equals(targetBoard)) {
                    return steps;
                }

                getNextBoard(currentBoard, visited, queue);
            }
            steps++;
        }

        return -1;
    }

    private String getBoard(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }

    private void getNextBoard(String board, HashSet<String> visited, Queue<String> queue) {
        //find empty block
        int emptyIndex = 0;
        for (int i = 0; i < 6; i++) {
            if (board.charAt(i) == '0') {
                emptyIndex = i;
                break;
            }
        }

        //move in four directions and convert the (row, col) to 1D index
        for (int[] dir : DIR) {
            int newRow = dir[0] + emptyIndex/3, newCol = dir[1] + emptyIndex%3;
            int newIndex = newRow * 3 + newCol;
            if (newRow >= 0 && newRow < 2 && newCol >= 0 && newCol < 3) {
                StringBuilder newBoard = new StringBuilder();
                for (int j = 0; j < 6; j++) {
                    if (j == emptyIndex) {
                        newBoard.append(board.charAt(newIndex));
                    } else if (j == newIndex) {
                        newBoard.append("0");
                    } else {
                        newBoard.append(board.charAt(j));
                    }
                }
                
                String newBoardString = newBoard.toString();
                if (!visited.contains(newBoardString)) {
                    visited.add(newBoardString);
                    queue.offer(newBoardString);
                }
            }
        }
    }
}