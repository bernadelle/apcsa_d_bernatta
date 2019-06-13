import java.util.*;

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
    private List<Product> products;
    private List<String> pacLevels;

    public Game() {
  


      pink = new Color(255, 192, 203);
      white = new Color(255, 255,255);
      grid = new Grid(15,30);
      
      //construct the products object
      
      userRow = 7;
      userCol = 0;
      msElapsed = 0;
      timesGet = 0;
      timesAvoid = 0;
      updateTitle();
      
      createShelves();

      products = new ArrayList<Product>();
      products.add(new Product(new Location(7,15), perm));
      products.add(new Product(new Location(7,17), flatiron));
      products.add(new Product(new Location(10,20), perm));
      products.add(new Product(new Location(4,5), flatiron));
      showProducts();

      pacLevels = new ArrayList<String>();
      pacLevels.add("pac-0.png");
      pacLevels.add("pac-1.png");
      pacLevels.add("pac-2.png");
      pacLevels.add("pac-3.png");
      pacLevels.add("pac-4.png");
      pacLevels.add("pac-5.png");
      pacLevels.add("pac-6.png");
      pacLevels.add("pac-7.png");
      pacLevels.add("pac-8.png");



    }
    
    public void showProducts(){
      for(int i = 0; i < products.size(); i++){
        Product p = products.get(i);
        grid.setImage(p.getLocation(), p.getImage());
      }
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
      grid.setColor(new Location(2,3),pink);
      grid.setColor(new Location(3,3),pink);
      grid.setColor(new Location(4,3),pink);
      grid.setColor(new Location(5,3),pink);
      grid.setColor(new Location(6,3),pink);
      grid.setColor(new Location(2,3),pink);
      grid.setColor(new Location(2,4),pink);
      grid.setColor(new Location(2,5),pink);
      grid.setColor(new Location(4,8),pink);
      grid.setColor(new Location(5,8),pink);
      grid.setColor(new Location(6,8),pink);
      grid.setColor(new Location(7,8),pink);
      grid.setColor(new Location(10,4),pink);
      grid.setColor(new Location(11,4),pink);
      grid.setColor(new Location(12,4),pink);
      grid.setColor(new Location(13,4),pink);
      grid.setColor(new Location(13,2),pink);
      grid.setColor(new Location(13,3),pink);
      grid.setColor(new Location(13,5),pink);
      grid.setColor(new Location(13,6),pink);
      grid.setColor(new Location(2,13),pink);
      grid.setColor(new Location(2,14),pink);
      grid.setColor(new Location(2,15),pink);
      grid.setColor(new Location(2,16),pink);
      grid.setColor(new Location(2,17),pink);
      grid.setColor(new Location(3,15),pink);
      grid.setColor(new Location(4,15),pink);
      grid.setColor(new Location(2,21),pink);
      grid.setColor(new Location(2,22),pink);
      grid.setColor(new Location(2,23),pink);
      grid.setColor(new Location(2,24),pink);
      grid.setColor(new Location(2,25),pink);
      grid.setColor(new Location(2,26),pink);
      grid.setColor(new Location(2,27),pink);
      grid.setColor(new Location(4,24),pink);
      grid.setColor(new Location(5,24),pink);
      grid.setColor(new Location(6,24),pink);
      grid.setColor(new Location(7,24),pink);
      grid.setColor(new Location(8,24),pink);
      grid.setColor(new Location(12,12),pink);
      grid.setColor(new Location(12,13),pink);
      grid.setColor(new Location(12,14),pink);
      grid.setColor(new Location(12,15),pink);
      grid.setColor(new Location(12,16),pink);
      grid.setColor(new Location(12,17),pink);
      grid.setColor(new Location(12,18),pink);
      grid.setColor(new Location(13,12),pink);
      grid.setColor(new Location(13,13),pink);
      grid.setColor(new Location(13,14),pink);
      grid.setColor(new Location(13,15),pink);
      grid.setColor(new Location(13,16),pink);
      grid.setColor(new Location(13,17),pink);
      grid.setColor(new Location(13,18),pink);
      grid.setColor(new Location(13,24),pink);
      grid.setColor(new Location(13,25),pink);
      grid.setColor(new Location(13,26),pink);
      grid.setColor(new Location(13,27),pink);
      grid.setColor(new Location(12,27),pink);
      grid.setColor(new Location(11,27),pink);


    }

    public void play() {
  
      while (!isGameOver()) {
        grid.pause(100);
        grid.setImage(new Location(7,0), userPic);
        grid.setImage(new Location(7,0), null);
        handleKeyPress();
        if (msElapsed % 300 == 0) {
          moveObstacles();
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
  

    public void moveObstacles(){
      
      //loop through all the objects
      for(int i = 0; i < products.size(); i++){
        
        Product p = products.get(i);
        
        //check row diff and col diff and see which is greater
        int productRow = p.getLocation().getRow();
        int productCol = p.getLocation().getCol();
        int rowDiff = userRow - productRow;
        int colDiff = userCol - productCol;
        Location moveLoc;

        Location upLoc = new Location(productRow - 1, productCol);
        Location downLoc = new Location(productRow + 1, productCol);
        Location leftLoc = new Location(productRow, productCol - 1);
        Location rightLoc = new Location(productRow, productCol + 1);

        if(Math.abs(rowDiff) > Math.abs(colDiff)){
          if(rowDiff < 0){  //go up
            moveLoc = upLoc;
          } else { // go down
            moveLoc = downLoc;
          }
        } else {
          if(colDiff < 0){  //go left
            moveLoc = leftLoc;
          } else { // go right
            moveLoc = rightLoc;
          }

        }

        //move greatest way
      
          while(grid.getColor(moveLoc).equals(pink)){
            int rando = (int)(Math.random() * 3);
            // if it's 0 move left, if its 1 move right, if its 2 move down
            if(rando == 0){
              moveLoc = leftLoc;
            }
            if(rando == 1){
              moveLoc = rightLoc;
            }
            if(rando == 2){
              moveLoc = upLoc;
            }
            if(rando == 3){
              moveLoc = downLoc;
            }
          }

          //finally move the object
          grid.setImage(moveLoc, p.getImage());
          grid.setImage(p.getLocation(), null);
          p.setLocation(moveLoc);

        }

         
        }
   
    
  
    
    public void handleCollision(Location loc) {

      for(int i = 0; i < products.size(); i++){

        Product p = products.get(i);
        Location userLocation = new Location(userRow, userCol);
        if(p.getLocation().equals(userLocation)){
          

        }


      }


    }
    
    public int getPacRow() {
      return userRow;
    }

    public int getPackCol(){
      return userCol;
    }
    
    public void updateTitle() {
     
    }
    
    public boolean isGameOver() {
      return false;
    }
      
    public static void main(String[] args) {
      Game game = new Game();
      game.play();   
    }
  }