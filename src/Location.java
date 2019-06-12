public class Location {

    private int row;
    private int col;
    
    public Location(int r, int c) {
      row = r;
      col = c;
    }
    
    public int getRow() {
      return row;
    }
    
    public int getCol() {
      return col;
    }

    public void changeRow(int r){
      row+= r;
    }

    public void changeCol(int c){
      col+= c;
    }

    public boolean equals(Location otherLoc) {
      return row == otherLoc.getRow() && col == otherLoc.getCol();
    }
    
    public String toString() {
      return "(" + row + ", " + col + ")";
    }
  } 