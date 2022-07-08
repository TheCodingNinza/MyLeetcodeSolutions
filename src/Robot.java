import javafx.util.Pair;

public class Robot {
    private int[][] board;
    private String moveForwardDirection;
    private Pair<Integer, Integer> currentLocation;

    private Pair<Integer, Integer> stepForward(Pair<Integer, Integer> currentPosition, int steps){
            if(steps == 0){
                return currentPosition;
            }
            if(this.moveForwardDirection.equals("E")){
                if(currentPosition.getKey() + steps < this.board.length){
                    return new Pair<>(currentPosition.getKey()+steps,currentPosition.getValue());
                }else{
                    this.moveForwardDirection = "N";
                    return stepForward(new Pair<>(board.length-1,currentPosition.getValue()),steps- (board.length - 1 -currentPosition.getKey()));
                }
            } else if (this.moveForwardDirection.equals("N")) {
                if(currentPosition.getValue()+steps < this.board[0].length){
                    return new Pair<>(currentPosition.getKey(),currentPosition.getValue()+steps);
                }else{
                    this.moveForwardDirection = "W";
                    return stepForward(new Pair<>(currentPosition.getKey(),board[0].length-1), steps - (board[0].length - 1 - currentPosition.getValue()));
                }
            } else if (this.moveForwardDirection.equals("W")) {
                if(currentPosition.getKey()-steps >=0 ){
                    return new Pair<>(currentPosition.getKey()-steps,currentPosition.getValue());
                }else{
                    this.moveForwardDirection = "S";
                    return stepForward(new Pair<>(0,currentPosition.getValue()),steps-currentPosition.getKey());
                }
            }else{
               if(currentPosition.getValue()-steps >= 0){
                   return new Pair<>(currentPosition.getKey(),currentPosition.getValue()-steps);
               }else{
                   this.moveForwardDirection = "E";
                   return stepForward(new Pair<>(currentPosition.getKey(),0),steps - currentPosition.getValue());
               }
            }
        }

    public Robot(int width, int height) {
            this.board = new int[width][height];
            this.moveForwardDirection = "E";
            this.currentLocation = new Pair<>(0,0);
    }

    public void step(int num) {

    }

    public int[] getPos() {
        return new int[] {this.currentLocation.getKey(),this.currentLocation.getValue()};
    }

    public String getDir() {
        if(this.moveForwardDirection.equals("E")){
            return "East";
        } else if (this.moveForwardDirection.equals("W")) {
            return "West";
        } else if (this.moveForwardDirection.equals("N")) {
            return "North";
        }else{
            return "South";
        }
    }
}
