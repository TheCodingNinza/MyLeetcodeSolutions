public class MatrixDP {
    static int count = 0;
    public static class Node{
        int i;
        int j;
        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static int[][] updateMatrix(int[][] mat) {
        int[][] distance = new int[mat.length][mat[0].length];
        int start = 0, end = 0;
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[0].length; j++) {
                if(mat[i][j] == 0){
                    distance[i][j] = 0;
                }else{
                    distance[i][j] = Integer.MAX_VALUE;
                }

            }
        }
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[0].length; j++) {
                if(distance[i][j] != 0) {
                    solveBottomLeft(mat,distance,new Node(i,j));
        solveUpRight(mat,distance,new Node(i,j));
                }
            }
        }

        return distance;
    }

    public static int solveBottomLeft(int[][] mat, int[][] distance, Node source){
//        count++;
//        System.out.println("bottomLeft");
//        System.out.println("source.i : "+source.i+" source.j : "+source.j);
//        if(count >= 20)
//            return -5;

        if(distance[source.i][source.j] != Integer.MAX_VALUE){
            return distance[source.i][source.j];
        }
        Node up = null;
        Node left = null;
        if(source.j-1 >= 0){
            left = new Node(source.i, source.j-1);
        }
        Node bottom = null;
        if(source.i+1 < mat.length){
            bottom = new Node(source.i+1, source.j);
        }

        int bottomValue = Integer.MAX_VALUE;
        if( bottom != null){
            bottomValue = solveBottomLeft(mat,distance,bottom);
        }
        int leftValue = Integer.MAX_VALUE;
        if( left != null){
            leftValue = solveBottomLeft(mat,distance,left);
        }


        int minimum = Math.min(bottomValue,leftValue);
        int ans = 0;
        if(minimum == Integer.MAX_VALUE){
            ans = Integer.MAX_VALUE;
        }else{
            ans = minimum + 1;
        }
        distance[source.i][source.j] = ans;
//        System.out.println("The answer is : "+ans);
        return ans;

    }

    public static int solveUpRight(int[][] mat, int[][] distance, Node source){
//        count++;
//        System.out.println("upRight");
//        System.out.println("source.i : "+source.i+" source.j : "+source.j);
//        if(count >= 20)
//            return -5;

        if(distance[source.i][source.j] != Integer.MAX_VALUE){
            return distance[source.i][source.j];
        }

        Node right = null;
        if(source.j+1 < mat[0].length){
            right = new Node(source.i, source.j+1);
        }
        Node up = null;
        if(source.i-1 >= 0){
            up = new Node(source.i-1, source.j);
        }

        int upValue = Integer.MAX_VALUE;
        if( up != null){
            upValue = solveUpRight(mat,distance,up);
        }
        int rightValue = Integer.MAX_VALUE;
        if( right != null){
            rightValue = solveUpRight(mat,distance,right);
        }


        int ans = Math.min(upValue,rightValue)+1;
        distance[source.i][source.j] = ans;
        return ans;

    }

    public static void main(String args[]){
        int[][] mat = new int[][] {{0,0,0},{0,1,0},{1,1,1}};
        int[][] distance = updateMatrix(mat);
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[0].length; j++) {
                System.out.print(distance[i][j]+"\t");
            }
            System.out.println("");
        }

    }

}
