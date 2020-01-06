import java.util.HashMap; 

class TicTacToe {
    
    int size;
    String[][] board;
    HashMap<Integer, String> mark;
    

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.size = n;
        this.board = new String[n][n];
        this.mark = new HashMap<>();
        mark.put(1, "O");
        mark.put(2, "X");       
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        
        // System.out.print(row);
        // System.out.println(col);
        this.board[row][col] = this.mark.get(player);
        boolean val = check_row(row, player) || check_col(col, player) || check_left_diag(row, col, player) || check_right_diag(row, col, player);
        
        //printboard();
        
        return val? player:0;
    }
    
    public boolean check_row(int row, int player){
        
            
        for (int i=0; i<this.size; i++){
                if (this.board[row][i] != this.mark.get(player))
                    return false;
        }
        return true;       
    } 
    
    public boolean check_col(int col, int player){
        
            
        for (int i=0; i<this.size; i++){
            //System.out.println(this.board[i][col]);
            if (this.board[i][col] != this.mark.get(player))
                return false;
        }
        return true;       
    }
    
    public boolean check_left_diag(int row, int col, int player){
        
        if (row != col)
            return false;
        
        for (int i=0; i<this.size; i++){
                if (this.board[i][i] != this.mark.get(player))
                    return false;
        }
        return true;       
    }
    
    public boolean check_right_diag(int row, int col, int player){
        
        if (col != this.size - row -1)
            return false;
        
        int i = 0, j = this.size-1;
        
        while (i< this.size && j>=0){
            if (this.board[i][j] != this.mark.get(player))
                return false;
            i++;
            j--;
        }
        return true;       
    }
    
    public void printboard(){
        
        for (int i=0; i<this.size; i++){
            for(int j=0; j<this.size; j++)
                System.out.print(this.board[i][j]);
            System.out.println();
        }
            
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
