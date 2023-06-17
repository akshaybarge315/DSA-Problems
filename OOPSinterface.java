public class OOPSinterface {
    public static void main(String args[]){
        Queen q = new Queen();
        q.moves();

        Bear b = new Bear();
        b.eatGreenFood();
        b.eatmeatFood();
    }
}

interface Herbivore{
    void eatGreenFood();
}

interface Carnivore{
    void eatmeatFood();
}

class Bear implements Herbivore, Carnivore{
    public void eatGreenFood(){
        System.out.println("Eating Green Food");
    }

    public void eatmeatFood(){
        System.out.println("Eating Non-Green Food");
    }
}

interface ChessPlayer{
    void moves();
}

class Queen implements ChessPlayer{
    public void moves() {
        System.out.println("up, down, left, right, diagonal (All 4 dir)");
    }
}

class Rook implements ChessPlayer{
    public void moves() {
        System.out.println("up, down, left, right");
    }
}

class King implements ChessPlayer{
    public void moves() {
        System.out.println("up, down, left, right, diagonal (one step)");
    }
}
