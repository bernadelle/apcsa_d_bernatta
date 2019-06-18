import java.util.*;

public class Game {


    // BERNY & AISSATA
    private Grid grid;
    private Grid background;
    private int userRow;
    private int userCol;
    private int msElapsed;
    private int timesGet;
    private int timesAvoid;
    private int userLevel;
    private String userPic() {return pacLevels.get(userLevel);}
    private String perm = "relaxer.png";
    private String flatiron = "flatiron.png";
    private String conditioner = "product1.png";
    private String deepcon = "product2.png";
    private Color pink;
    private Color white;
    private Color black;
    private Color red;
    private List<Product> perms;
    private List<Product> flatirons;
    private List<Product> goodproducts;
    private List<String> pacLevels;
    private String gameName = "Protect The Hair";

    public Game() {
  


      pink = new Color(255, 192, 203);
      white = new Color(255, 255,255);
      black = new Color(0, 0, 0);
      red = new Color(255, 0, 0);
      grid = new Grid(15,30);


      grid.setTitle(gameName);
      
      //construct the products object
      
      userRow = 7;
      userCol = 0;
      msElapsed = 0;
      timesGet = 0;
      timesAvoid = 0;
      updateTitle();
      
      grid.setImage(new Location(userRow, userCol), "pac-2.png");
      
      createShelves();

      perms = new ArrayList<Product>();
      flatirons = new ArrayList<Product>();
      perms.add(new Product(new Location(10,15), perm));
      flatirons.add(new Product(new Location(7,17), flatiron));
      flatirons.add(new Product(new Location(10,20), flatiron));
      flatirons.add(new Product(new Location(4,5), flatiron));
      flatirons.add(new Product(new Location(9,12), flatiron));

      goodproducts = new ArrayList<Product>();
      goodproducts.add(new Product(new Location(5,20), conditioner));
      goodproducts.add(new Product(new Location(10,13), conditioner));
      goodproducts.add(new Product(new Location(13,3), deepcon));
      goodproducts.add(new Product(new Location(1,14), deepcon));
      showProducts();

      userLevel = 2;

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
      for(int i = 0; i < flatirons.size(); i++){
        Product p = flatirons.get(i);
        grid.setImage(p.getLocation(), p.getImage());
      }

      for(int i = 0; i < perms.size(); i++){
        Product p = perms.get(i);
        grid.setImage(p.getLocation(), p.getImage());
      }

      for(int i = 0; i < goodproducts.size(); i++){
        Product p = goodproducts.get(i);
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

      grid.setColor(new Location(8,15), white);


      grid.setColor(new Location(7,13),pink);
      grid.setColor(new Location(6,13),pink);
      grid.setColor(new Location(7,17),pink);
      grid.setColor(new Location(6,17),pink);
      grid.setColor(new Location(6,14),pink);
      grid.setColor(new Location(6,16),pink);
      grid.setColor(new Location(2,2),pink);
      grid.setColor(new Location(3,2),pink);
      grid.setColor(new Location(4,2),pink);
      grid.setColor(new Location(5,2),pink);
      grid.setColor(new Location(6,2),pink);
      grid.setColor(new Location(2,2),pink);
      grid.setColor(new Location(2,3),pink);
      grid.setColor(new Location(2,4),pink);
      grid.setColor(new Location(4,8),pink);
      grid.setColor(new Location(5,8),pink);
      grid.setColor(new Location(6,8),pink);
      grid.setColor(new Location(7,8),pink);
      grid.setColor(new Location(10,4),pink);
      grid.setColor(new Location(11,4),pink);
      grid.setColor(new Location(12,4),pink);
      grid.setColor(new Location(12,4),pink);
      grid.setColor(new Location(12,2),pink);
      grid.setColor(new Location(12,3),pink);
      grid.setColor(new Location(12,5),pink);
      grid.setColor(new Location(12,6),pink);
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
      grid.setColor(new Location(11,12),pink);
      grid.setColor(new Location(11,13),pink);
      grid.setColor(new Location(11,14),pink);
      grid.setColor(new Location(11,15),pink);
      grid.setColor(new Location(11,16),pink);
      grid.setColor(new Location(11,17),pink);
      grid.setColor(new Location(11,18),pink);
      grid.setColor(new Location(12,12),pink);
      grid.setColor(new Location(12,13),pink);
      grid.setColor(new Location(12,14),pink);
      grid.setColor(new Location(12,15),pink);
      grid.setColor(new Location(12,16),pink);
      grid.setColor(new Location(12,17),pink);
      grid.setColor(new Location(12,18),pink);
      grid.setColor(new Location(12,24),pink);
      grid.setColor(new Location(12,25),pink);
      grid.setColor(new Location(12,26),pink);
      grid.setColor(new Location(12,27),pink);
      grid.setColor(new Location(11,27),pink);
      grid.setColor(new Location(10,27),pink);

    
    }

    public void play() {

      grid.fullscreen();

      while (!isGameOver()) {
        grid.pause(100);
        handleKeyPress();
        handleCollisions();
        if (msElapsed % 300 == 0) {
          moveObstacles();
        }
        updateTitle();
        msElapsed += 100;
      }

      endGame();


    }
    
    public void endGame(){

      if(userLevel == 0){
      for(int i = 0; i < 15; i++){
        for(int j = 0; j < 30; j++){
          if(grid.getColor(new Location(i,j)).equals(white)){
            grid.setColor(new Location(i,j), red);
          } else {
            grid.setColor(new Location(i,j), black);
          }

        }
      }

      if(grid.showInputDialog("YOU LOSE!! TYPE 'yes' TO TRY AGAIN").equals("yes")){
        userCol = 0;
        Game game = new Game();
        game.play();
      }

      
    } else if(userLevel != 0 && userCol == 29){
    if(grid.showInputDialog("YOU WIN! YOUR LEVEL IS: " + userLevel +  " TYPE 'yes' TO PLAY AGAIN!").equals("yes") || grid.showInputDialog("YOU LOSE!! TRY AGAIN?").equals("Yes")){
      userCol = 0;
      Game game = new Game();
      game.play();
    } else {
      grid.close();
    }
    }
    }

    public void handleKeyPress(){

  
      //check last key pressed
      int key = grid.checkLastKeyPressed();
      System.out.println(key);
  
      

      //set "up arrow" key to move the plane up
        if(key == 38 &&  userRow != 0){

          grid.setImage(new Location(7,0), null);
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
            grid.setImage(loc, userPic());

          }
        }

      //if I push down arrow, then plane goes down
      if(key == 40 &&  userRow != grid.getNumRows()-1){

        grid.setImage(new Location(7,0), null);
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
        grid.setImage(loc, userPic());

        }
      }

        // push right arrow 
        if(key == 39 &&  userCol != grid.getNumCols()-1){

          grid.setImage(new Location(7,0), null);
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
          grid.setImage(loc, userPic());
  
          }
        }


        //push left arrow
        if(key == 37 &&  userRow != 0){

          grid.setImage(new Location(7,0), null);
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
            grid.setImage(loc, userPic());
    
          }
        }
        
        if(userCol == 0 && key == 37){
          // play noise
          grid.setImage(new Location(userRow, userCol), userPic());
        }

        if(userCol == 29 && key == 39){
          // play noise
          grid.setImage(new Location(userRow, userCol), userPic());
        }
      }
  

    public void moveObstacles(){
      
      //loop through all the objects
      for(int i = 0; i < flatirons.size(); i++){
        
        Product p = flatirons.get(i);
        
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
      
        while(grid.getColor(moveLoc).equals(pink) || perm.equals(grid.getImage(moveLoc)) || conditioner.equals(grid.getImage(moveLoc))){
            
          
            int rando = (int)(Math.random() * 3);
            // if theres a product at the location, the other product should find a new route
            
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
  
    
    public void handleCollisions() {

      for(int i = 0; i < flatirons.size(); i++){

        Product p = flatirons.get(i);
        Location userLocation = new Location(userRow, userCol);
        if(p.getLocation().equals(userLocation) && p.getImage().equals("flatiron.png")){
          userLevel--;
          
          grid.setColor(userLocation, red);
          flatirons.remove(i);
          grid.setImage(userLocation, userPic());
          grid.setColor(userLocation, white);
          return;
        }
      }
      for(int i = 0; i < perms.size(); i++){

        Product p = perms.get(i);
        Location userLocation = new Location(userRow, userCol);
         if(p.getLocation().equals(userLocation) && p.getImage().equals("perm.png")){
          for(int j = userLevel; j >= 0; j--){
            userLevel--;
          }
          grid.setColor(userLocation, red);
          perms.remove(i);
          grid.setImage(userLocation, userPic());
          grid.setColor(userLocation, white);
        
        }
      }
      

      for(int i = 0; i < goodproducts.size(); i++){

        Product p = goodproducts.get(i);
        Location userLocation = new Location(userRow, userCol);
        if(p.getLocation().equals(userLocation)){
          userLevel++;
          goodproducts.remove(i);
          grid.setImage(userLocation, userPic());
          return;
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
     grid.setTitle(gameName + " Cuurent Length: " + userLevel + " Dont get to 0!");
    }
    
    public boolean isGameOver() {
      if(userLevel == 0){
        return true;
      } else if(userLevel != 0 && userCol == 29) {
        return true;
      } else {
        return false;
      }

    }

    
      
    public static void main(String[] args) {
      Game game = new Game();
      game.play();   
    }
  }