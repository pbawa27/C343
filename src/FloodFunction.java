
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FloodFunction {
	
    public Driver driver;
    public List<Coord> flooded_list = new LinkedList<>();

    public FloodFunction(final Driver _driver) {
        this.driver = _driver;
        this.flooded_list.add(new Coord(0, 0));
    }

    public boolean inbound(final Coord coord) {
        return coord.x > -1 && coord.x < this.driver.size && coord.y > -1 && coord.y < this.driver.size;
    }

    public Coord up(final Coord coord) {
        return new Coord(coord.x, coord.y-1);
    }

    public Coord down(final Coord coord) {
        return new Coord(coord.x, coord.y+1);
    }

    public Coord left(final Coord coord) {
        return new Coord(coord.x-1, coord.y);
    }

    public Coord right(final Coord coord) {
        return new Coord(coord.x+1, coord.y);
    }

    public void flood(final Map color_of_tiles, final Integer color) {
        for(int i = 0; i < flooded_list.size(); i++){  // Iterates through list                  
          if(! flooded_list.contains(up(flooded_list.get(i)))){  // Checking current list of tiles
            if(inbound(up(flooded_list.get(i)))){ 
              if(color_of_tiles.get(up(flooded_list.get(i))) == color){
                flooded_list.add(up(flooded_list.get(i)));                 
              }
            }
          }
          if(! flooded_list.contains(down(flooded_list.get(i)))){
            if(inbound(down(flooded_list.get(i)))){ 
              if(color_of_tiles.get(down(flooded_list.get(i))) == color){     
                flooded_list.add(down(flooded_list.get(i)));                  
              }
            }
          }
          if(! flooded_list.contains(left(flooded_list.get(i)))){
            if(inbound(left(flooded_list.get(i)))){ 
              if(color_of_tiles.get(left(flooded_list.get(i))) == color){     
                flooded_list.add(left(flooded_list.get(i)));                  
              }
            }
          }
          if(! flooded_list.contains(right(flooded_list.get(i)))){
            if(inbound(right(flooded_list.get(i)))){ 
              if(color_of_tiles.get(right(flooded_list.get(i))) == color){    
                flooded_list.add(right(flooded_list.get(i)));                 
              }
            }
          }
        }
      }

}
