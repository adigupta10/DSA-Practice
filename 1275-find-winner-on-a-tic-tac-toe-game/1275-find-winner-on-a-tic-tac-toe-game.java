class Solution {
    public String tictactoe(int[][] moves) {
        int[][] ans=new int[3][3];
        for(int i=0;i<ans.length;i++){
          Arrays.fill(ans[i],-1);
        }
        
        for(int i=0;i<moves.length;i++){
            int r=moves[i][0];
            int c=moves[i][1];
            if(i%2==0){
                ans[r][c]=1;
            }
            else{
                ans[r][c]=0;
            }
        }
        
        if(ans[0][0]==1 && ans[1][1]==1 && ans[2][2]==1){
            return "A";
        }
        if(ans[0][2]==1 && ans[1][1]==1 && ans[2][0]==1){
            return "A";
        }
        if(ans[0][0]==0 && ans[1][1]==0 && ans[2][2]==0){
            return "B";
        }
        if(ans[0][2]==0 && ans[1][1]==0 && ans[2][0]==0){
            return "B";
        }
        
        for(int i=0;i<3;i++){
            if(ans[i][0]!=-1 && ans[i][0]==ans[i][1] && ans[i][1]==ans[i][2]){
                if(ans[i][0]==1){
                    return "A";
                }
                else if(ans[i][0]==0){
                    return "B";
                }
            }
            if(ans[0][i]!=-1 && ans[0][i]==ans[1][i] &&
                ans[1][i]==ans[2][i]){
                if(ans[0][i]==1){
                    return "A";
                }
                else if(ans[0][i]==0){
                    return "B";
                }
            }
        }
        if(moves.length!=9) return "Pending";
        return "Draw";
    }
}