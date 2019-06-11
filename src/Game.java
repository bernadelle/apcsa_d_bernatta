public class Game {


    // BERNY & AISSATA
    private Grid grid;
    private int userRow;
    private int userCol;
    private int msElapsed;
    private int timesGet;
    private int timesAvoid;
    private String userPic = "pac-2.png";
    private String perm = "relaxer.png";
    private String flatiron = "flatiron.png";
    private Color pink;
    private Color white;

    public Game() {
  
      pink = new Color(255, 192, 203);
      white = new Color(255, 255,255);
      grid = new Grid(15,30);
      userRow = 6;
      userCol = 5;
      msElapsed = 0;
      timesGet = 0;
      timesAvoid = 0;
      updateTitle();
      grid.setImage(new Location(userRow, userCol), userPic);
      grid.setImage(new Location(7,15),perm);
      createShelves();
    }
    
    public void createShelves(){
      
      for(int i = 1; i < grid.getNumRows(); i++)
      grid.setColor(new Location(i, 0), pink);
      
      for(int i = 0; i < grid.getNumCols(); i++)
      grid.setColor(new Location(0, i), pink);

      for(int i = 1; i < grid.getNumCols(); i++)
      grid.setColor(new Location(14, i), pink);

      for(int i = 1; i < grid.getNumRows(); i++)
      grid.setColor(new Location(i,29), pink);

      grid.setColor(new Location(grid.getNumRows()/2,0), white);
      grid.setColor(new Location(grid.getNumRows()/2,29), white);

      for(int i =13; i < 18; i++)
      grid.setColor(new Location(8,i),pink);


      grid.setColor(new Location(7,13),pink);
      grid.setColor(new Location(6,13),pink);
      grid.setColor(new Location(7,17),pink);
      grid.setColor(new Location(6,17),pink);
      grid.setColor(new Location(6,14),pink);
      grid.setColor(new Location(6,16),pink);
      grid.setColor(new Location(),pink);
      grid.setColor(new Location(),pink);


      
    }

    public void play() {
  
      while (!isGameOver()) {
        grid.pause(100);
        handleKeyPress();
        if (msElapsed % 300 == 0) {
          scrollLeft();
          populateRightEdge();
        }
        updateTitle();
        msElapsed += 100;
      }
    }
    
    public void handleKeyPress(){
  
      //check last key pressed
      int key = grid.checkLastKeyPressed();
      System.out.println(key);
  
      

      //set "up arrow" key to move the plane up
        if(key == 38 &&  userRow != 0){

          boolean isUpWall = grid.getColor(new Location(userRow - 1, userCol)).equals(pink);
          System.out.print("UpWall: " + isUpWall);

          if(!isUpWall){

            //check case where out of bounds
            Location oldLoc = new Location(userRow, userCol);
            grid.setImage(oldLoc, null);

            //change the field for userrow
            userRow--;
            //shift the user picture up in the array
            Location loc = new Location(userRow, userCol);
            grid.setImage(loc, userPic);

          }
        }

      //if I push down arrow, then plane goes down
      if(key == 40 &&  userRow != grid.getNumRows()-1){

        boolean isDownWall = grid.getColor(new Location(userRow +1, userCol)).equals(pink);
        System.out.print("DownWall: " + isDownWall);

        if(!isDownWall){

        //check case where out of bounds
        Location oldLoc = new Location(userRow, userCol);
        grid.setImage(oldLoc, null);

        //change the field for userrow
        userRow++;
        //shift the user picture up in the array
        Location loc = new Location(userRow, userCol);
        grid.setImage(loc, userPic);

        }
      }

        // push right arrow 
        if(key == 39 &&  userCol != grid.getNumCols()-1){

          boolean isRightWall = grid.getColor(new Location(userRow, userCol+1)).equals(pink);
          System.out.print("RightWall: " + isRightWall);
  
          if(!isRightWall){
  
          //check case where out of bounds
          Location oldLoc = new Location(userRow, userCol);
          grid.setImage(oldLoc, null);
  
          //change the field for userrow
          userCol++;
          //shift the user picture up in the array
          Location loc = new Location(userRow, userCol);
          grid.setImage(loc, userPic);
  
          }
        }


        //push left arrow
        if(key == 37 &&  userRow != 0){

       
          boolean isLeftWall = grid.getColor(new Location(userRow, userCol-1)).equals(pink);
          System.out.print("LeftWall: " + isLeftWall);
  
          if(!isLeftWall ){
  
            //check case where out of bounds
            Location oldLoc = new Location(userRow, userCol);
            grid.setImage(oldLoc, null);
    
            //change the field for userrow
            userCol--;

            //shift the user picture up in the array
            Location loc = new Location(userRow, userCol);
            grid.setImage(loc, userPic);
    
          }
        }
        
      }
  
    
    public void populateRightEdge(){
  
    }
    
    public void scrollLeft(){
  
    }
    
    public void handleCollision(Location loc) {
  
    }
    
    public int getScore() {
      return 0;
    }
    
    public void updateTitle() {
      grid.setTitle("Game:  " + getScore());
    }
    
    public boolean isGameOver() {
      return false;
    }
      
    public static void main(String[] args) {
      Game game = new Game();
      game.play();   
    }
  }