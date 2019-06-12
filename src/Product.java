public class Product{

    private Location pLoc;
    private String img;

    public Product(Location pLoc, String img){
        this.pLoc = pLoc;
        this.img = img;
    }

    public Location getLocation(){
        return pLoc;
    }

    public String getImage(){
        return img;
    }

    public void changeLocation(int dRow, int dCol){
        pLoc.changeCol(dCol);
        pLoc.changeRow(dRow);
    }

    public void setLocation(Location l){
        pLoc = l;
    }


}