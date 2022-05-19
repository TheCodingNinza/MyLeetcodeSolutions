import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ValidPath {
    public static class Node{
        int accepti;
        int acceptj;
        int forwardi;
        int forwardj;

        int type;

        public Node(int i, int j, int type ) {
            if(type == 1){
                this.accepti = i;
                this.acceptj = j-1;
                this.forwardi = i;
                this.forwardj = j+1;
            } else if (type == 2) {
                this.accepti = i-1;
                this.acceptj = j;
                this.forwardi = i+1;
                this.forwardj = j;
            } else if (type == 3) {
                this.accepti = i;
                this.acceptj = j-1;
                this.forwardi = i+1;
                this.forwardj = j;
            } else if (type == 4) {
                this.accepti = i;
                this.acceptj = j+1;
                this.forwardi = i+1;
                this.forwardj = j;
            } else if (type == 5) {
                this.accepti = i;
                this.acceptj = j-1;
                this.forwardi = i-1;
                this.forwardj = j;
            } else{
                this.accepti = i;
                this.acceptj = j+1;
                this.forwardi = i-1;
                this.forwardj = j;
            }
        }
    }
    public static class Cell{
        int indexi;
        int indexj;

        public Cell(int indexi, int indexj) {
            this.indexi = indexi;
            this.indexj = indexj;
        }
    }
    public static boolean hasValidPath(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int row = grid.length;
        int column = grid[0].length;
        Queue<Cell> que = new LinkedList<>();
        que.add(new Cell(0,0));
        while (!que.isEmpty()){
            Cell itr = que.poll();
            visited[itr.indexi][itr.indexj] = true;
            Node nodeOrigin = new Node(itr.indexi, itr.indexj, grid[itr.indexi][itr.indexj]);
            Node nodeLeft = null;
            if(itr.indexj-1 >= 0){
                nodeLeft = new Node(itr.indexi, itr.indexj-1, grid[itr.indexi][itr.indexj-1]);
            }
            Node nodeRight = null;
            if(itr.indexj+1 < column){
                nodeRight = new Node(itr.indexi, itr.indexj+1, grid[itr.indexi][itr.indexj+1]);
            }
            Node nodeUp = null;
            if(itr.indexi-1 >= 0){
                nodeUp = new Node(itr.indexi-1, itr.indexj, grid[itr.indexi-1][itr.indexj]);
            }
            Node nodeDown = null;
            if(itr.indexi+1 < row){
                nodeDown = new Node(itr.indexi+1, itr.indexj, grid[itr.indexi+1][itr.indexj]);
            }
            if(nodeLeft != null){
                if(visited[itr.indexi][itr.indexj-1] == false){
                    if(nodeLeft.accepti == itr.indexi && nodeLeft.acceptj == itr.indexj){
                        if(nodeOrigin.forwardi == itr.indexi && nodeOrigin.forwardj == itr.indexj-1){
                            que.add(new Cell(itr.indexi, itr.indexj-1));
                        } else if (nodeOrigin.accepti == itr.indexi && nodeOrigin.acceptj == itr.indexj-1) {
                            que.add(new Cell(itr.indexi, itr.indexj-1));
                        }
                    }
                    if(nodeLeft.forwardi == itr.indexi && nodeLeft.forwardj == itr.indexj){
                        if(nodeOrigin.forwardi == itr.indexi && nodeOrigin.forwardj == itr.indexj-1){
                            que.add(new Cell(itr.indexi, itr.indexj-1));
                        } else if (nodeOrigin.accepti == itr.indexi && nodeOrigin.acceptj == itr.indexj-1) {
                            que.add(new Cell(itr.indexi, itr.indexj-1));
                        }
                    }
                }
            }
            if(nodeRight != null){
//                System.out.println("here");
                if(visited[itr.indexi][itr.indexj+1] == false){
//                    System.out.println(nodeRight.accepti);
//                    System.out.println(nodeRight.acceptj);
//                    System.out.println(itr.indexi);
//                    System.out.println(itr.indexj);
                    if(nodeRight.accepti == itr.indexi && nodeRight.acceptj == itr.indexj){
                        if(nodeOrigin.forwardi == itr.indexi && nodeOrigin.forwardj == itr.indexj+1){
                            que.add(new Cell(itr.indexi, itr.indexj+1));
                        } else if (nodeOrigin.accepti == itr.indexi && nodeOrigin.acceptj == itr.indexj+1) {
                            que.add(new Cell(itr.indexi, itr.indexj+1));
                        }
                    }
                    if(nodeRight.forwardi == itr.indexi && nodeRight.forwardj == itr.indexj){
                        if(nodeOrigin.forwardi == itr.indexi && nodeOrigin.forwardj == itr.indexj+1){
                            que.add(new Cell(itr.indexi, itr.indexj+1));
                        } else if (nodeOrigin.accepti == itr.indexi && nodeOrigin.acceptj == itr.indexj+1) {
                            que.add(new Cell(itr.indexi, itr.indexj+1));
                        }
                    }
                }
            }
            if(nodeUp != null){
                if(visited[itr.indexi-1][itr.indexj] == false){
                    if(nodeUp.accepti == itr.indexi && nodeUp.acceptj == itr.indexj){
                        if(nodeOrigin.forwardi == itr.indexi-1 && nodeOrigin.forwardj == itr.indexj){
                            que.add(new Cell(itr.indexi-1, itr.indexj));
                        } else if (nodeOrigin.accepti == itr.indexi-1 && nodeOrigin.acceptj == itr.indexj) {
                            que.add(new Cell(itr.indexi-1, itr.indexj));
                        }
                    }
                    if(nodeUp.forwardi == itr.indexi && nodeUp.forwardj == itr.indexj){
                        if(nodeOrigin.forwardi == itr.indexi-1 && nodeOrigin.forwardj == itr.indexj){
                            que.add(new Cell(itr.indexi-1, itr.indexj));
                        } else if (nodeOrigin.accepti == itr.indexi-1 && nodeOrigin.acceptj == itr.indexj) {
                            que.add(new Cell(itr.indexi-1, itr.indexj));
                        }
                    }
                }
            }
            if(nodeDown != null){
                if(visited[itr.indexi+1][itr.indexj] == false){
                    if(nodeDown.accepti == itr.indexi && nodeDown.acceptj == itr.indexj){
                        if(nodeOrigin.forwardi == itr.indexi+1 && nodeOrigin.forwardj == itr.indexj){
                            que.add(new Cell(itr.indexi+1, itr.indexj));
                        } else if (nodeOrigin.accepti == itr.indexi+1 && nodeOrigin.acceptj == itr.indexj) {
                            que.add(new Cell(itr.indexi+1, itr.indexj));
                        }
                    }
                    if(nodeDown.forwardi == itr.indexi && nodeDown.forwardj == itr.indexj){
                        if(nodeOrigin.forwardi == itr.indexi+1 && nodeOrigin.forwardj == itr.indexj){
                            que.add(new Cell(itr.indexi+1, itr.indexj));
                        } else if (nodeOrigin.accepti == itr.indexi+1 && nodeOrigin.acceptj == itr.indexj) {
                            que.add(new Cell(itr.indexi+1, itr.indexj));
                        }
                    }
                }
            }
        }
//        for (int i = 0; i < visited.length; i++) {
//            for (int j = 0; j < visited[0].length; j++) {
//                System.out.print(visited[i][j]+"\t");
//            }
//            System.out.println("");
//        }
//        System.out.println("");
        return visited[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{2},{2},{2},{2},{2},{2},{6}};
        System.out.println(hasValidPath(grid));
    }
}
