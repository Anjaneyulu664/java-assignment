public class Q3_Orchard {

    static int dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 'T')
            return 0;

        grid[i][j] = 'O';
        int count = 1;

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                count += dfs(grid, i + x, j + y);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'O','T','O','O'},
                {'O','T','O','T'},
                {'T','T','O','T'},
                {'O','T','O','T'}
        };

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'T') {
                    int size = dfs(grid, i, j);
                    System.out.println(size);
                }
            }
        }
    }
}