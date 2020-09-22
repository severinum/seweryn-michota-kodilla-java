public class Game {

    static int GAMES_COUNT = 0;
    int score = 0;

    public Game() {
        GAMES_COUNT++;
    }

    public static int getGamesCount() {
        return GAMES_COUNT;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
