import java.util.*;

public class SnakeGame {

    static class Point{
        int r;
        int c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
        @Override
        public boolean equals(Object o) {
            if (o instanceof Point) {
                Point p = (Point)o;
                return this.r == p.r && this.c == p.c;
            }
            return false;
        }
        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }
    public static void main(String[] args){
        int[][] food = {{2,0},{0,0},{0,2},{0,1},{2,2},{0,1}};
        SnakeGame game = new SnakeGame(3,3,food);
        System.out.println(game.move("D"));
        System.out.println(game.move("D"));
        System.out.println(game.move("R"));
        System.out.println(game.move("U"));
        System.out.println(game.move("U"));
        System.out.println(game.move("L"));
        System.out.println(game.move("D"));
        System.out.println(game.move("R"));
        System.out.println(game.move("R"));
        System.out.println(game.move("U"));
        System.out.println(game.move("L"));
        System.out.println(game.move("L"));
        System.out.println(game.move("D"));
        System.out.println(game.move("R"));
        System.out.println(game.move("U"));

    }
    Deque<Point> body;
    Set<Point> set;
    int score;
    int[][] food;
    int width;
    int height;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        set = new HashSet<>();
        body = new LinkedList<>();
        set.add(new Point(0,0));
        body.addFirst(new Point(0,0));
    }


    public int move(String direction) {
        if(score == -1)
            return score;

        int headR = body.peekFirst().r;
        int headC = body.peekFirst().c;
        Point tail = body.peekLast();
        set.remove(tail);
        //move
        switch(direction){
            case "U" : headR--;
                break;
            case "D" : headR++;
                break;
            case "L" : headC--;
                break;
            case "R" : headC++;
                break;
        }

        Point next = new Point(headR,headC);
        //hitwall or bite itself
        if(next.r < 0 || next.c < 0 || next.r == height || next.c == width || set.contains(next)){
            score = -1;
            return score;
        }
        body.addFirst(next);
        set.add(next);
        //eat food
        if(score < food.length && next.r == food[score][0] && next.c == food[score][1]){
            score++;
            return score;
        }
        //normal move
        body.removeLast();
        return score;
    }
}


