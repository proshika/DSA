import java.util.*;

class Solution {
    
    private int[][] grid;

    public int minimumSum(int[][] grid) {
        this.grid = grid;
        int rows = grid.length;
        int cols = grid[0].length;
        int minArea = rows * cols;

        // Horizontal splits
        for (int firstRow = 0; firstRow < rows - 1; firstRow++) {
            for (int secondRow = firstRow + 1; secondRow < rows - 1; secondRow++) {
                
                int currentArea = computeArea(0, 0, firstRow, cols - 1) +
                                 computeArea(firstRow + 1, 0, secondRow, cols - 1) +
                                 computeArea(secondRow + 1, 0, rows - 1, cols - 1);
                
                minArea = Math.min(minArea, currentArea);
            }
        }

        // Vertical splits
        for (int firstCol = 0; firstCol < cols - 1; firstCol++) {
            for (int secondCol = firstCol + 1; secondCol < cols - 1; secondCol++) {
                
                int currentArea = computeArea(0, 0, rows - 1, firstCol) +
                                 computeArea(0, firstCol + 1, rows - 1, secondCol) +
                                 computeArea(0, secondCol + 1, rows - 1, cols - 1);
                
                minArea = Math.min(minArea, currentArea);
            }
        }

        // Hybrid splits - Case 1
        for (int row = 0; row < rows - 1; row++) {
            int firstArea = computeArea(0, 0, row, cols - 1);
            for (int col = 0; col < cols - 1; col++) {
                int secondArea = computeArea(row + 1, 0, rows - 1, col);
                int thirdArea = computeArea(row + 1, col + 1, rows - 1, cols - 1);
                minArea = Math.min(minArea, firstArea + secondArea + thirdArea);
            }
        }

        // Hybrid splits - Case 2
        for (int row = rows - 1; row >= 0; row--) {
            int firstArea = computeArea(row + 1, 0, rows - 1, cols - 1);
            for (int col = 0; col < cols - 1; col++) {
                int secondArea = computeArea(0, 0, row, col);
                int thirdArea = computeArea(0, col + 1, row, cols - 1);
                minArea = Math.min(minArea, firstArea + secondArea + thirdArea);
            }
        }

        // Hybrid splits - Case 3
        for (int col = 0; col < cols - 1; col++) {
            int firstArea = computeArea(0, 0, rows - 1, col);
            for (int row = 0; row < rows - 1; row++) {
                int secondArea = computeArea(0, col, row, cols - 1);
                int thirdArea = computeArea(row + 1, col, rows - 1, cols - 1);
                minArea = Math.min(minArea, firstArea + secondArea + thirdArea);
            }
        }

        // Hybrid splits - Case 4
        for (int col = cols - 1; col >= 0; col--) {
            int firstArea = computeArea(0, col + 1, rows - 1, cols - 1);
            for (int row = 0; row < rows - 1; row++) {
                int secondArea = computeArea(0, 0, row, col);
                int thirdArea = computeArea(row + 1, 0, rows - 1, col);
                minArea = Math.min(minArea, firstArea + secondArea + thirdArea);
            }
        }

        return minArea;
    }

    // Helper method to compute the minimum area enclosing all 1s in a subgrid
    public int computeArea(int topRow, int leftCol, int bottomRow, int rightCol) {
        int minRow = Integer.MAX_VALUE, minCol = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE, maxCol = Integer.MIN_VALUE;

        // Iterate over the subgrid to find the bounding rectangle for cells with value 1
        for (int i = topRow; i <= bottomRow; i++) {
            for (int j = leftCol; j <= rightCol; j++) {
                if (grid[i][j] == 1) {
                    minRow = Math.min(minRow, i);
                    minCol = Math.min(minCol, j);
                    maxRow = Math.max(maxRow, i);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        
        int[][] grid = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        
        scanner.close();
        
        Solution solution = new Solution();
        System.out.println(solution.minimumSum(grid));
    }
}
