package Graphs.FloodFill;

public class DFS {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here 
       int [][] newImg = image;
       dfs(newImg,sr,sc,newColor);
       return newImg;
   }
   public static void dfs(int [][] newImg, int sr, int sc, int newCol){
       int n = newImg.length;
       int m = newImg[0].length;
       int iniCol = newImg[sr][sc];
       newImg[sr][sc]=newCol;
       int [] delRow = {1,0,-1,0};
       int [] delCol = {0,1,0,-1};
       for(int i=0;i<4;i++){
           int nrow = sr+delRow[i];
           int ncol = sc+delCol[i];
           if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && newImg[nrow][ncol]!=newCol && newImg[nrow][ncol]==iniCol){
               dfs(newImg,nrow,ncol,newCol);
           }
       }
   }
}
