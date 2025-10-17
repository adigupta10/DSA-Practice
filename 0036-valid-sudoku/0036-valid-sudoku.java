class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=9;
        HashSet<Character>[] row=new HashSet[n];
        HashSet<Character>[] column=new HashSet[n];
        HashSet<Character>[] boxes=new HashSet[n];

        for(int i=0;i<n;i++){
            row[i]=new HashSet<>();
            column[i]=new HashSet<>();
            boxes[i]=new HashSet<>();
        }
        for(int r=0;r<n;r++){
            for(int c=0;c<board[0].length;c++){
                char cell=board[r][c];
                if(board[r][c]=='.'){
                    continue;
                }
                if(row[r].contains(cell)){
                    return false;
                }
                row[r].add(cell);


                if(column[c].contains(cell)){
                    return false;
                }
                column[c].add(cell);

                int boxIndex= 3*(r/3) + (c/3);
                if(boxes[boxIndex].contains(cell)){
                    return false;
                }
                boxes[boxIndex].add(cell);
            }
        }
        return true;
    }
}