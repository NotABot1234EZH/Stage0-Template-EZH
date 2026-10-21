import java.util.ArrayList;
import java.util.List;

class Point {
    private final double x;
    private final double y;

    public static final Point ORIGIN = new Point(0,0);

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public Point plus(Point other) {
        return new Point(this.x + other.x, this.y + other.y);
    }

    //Note public Point minus returns a vector that goes from Point other to the called point.
    public Point minus(Point other) {
        return new Point(this.x - other.x, this.y - other.y);
    }

    public double norm() {
        double SumOfSquares = this.x * this.x + this.y * this.y;
        return Math.sqrt(SumOfSquares);
    }
}

/*_________________________________________________________________________________________________________________
___________________________________________________________________________________________________________________
__________________________________________________________________________________________________________________ */


class RobotTracker {
    private Point position;

    //starts tracking position, set ORIGIN as default later
    public RobotTracker(Point startPosition) {
        this.position = startPosition;
    }
    public RobotTracker() {
        this(Point.ORIGIN);
    }

    //Moves the tracked position by delta(their position as added onto the current)
    public void move(Point delta) {
        this.position = this.position.plus(delta);
    }

    public double distanceTo(Point target) {
        Point diff = target.minus(this.position);
        return diff.norm();
    }

    //Makes position Public to other classes, position is set as private so nothing else messes with it
    public Point getPosition() {
        return this.position;
    }

    //moves tracked position back to origin
    public void reset() {
        this.position = Point.ORIGIN;
    }
}

/*_________________________________________________________________________________________________________________
___________________________________________________________________________________________________________________
__________________________________________________________________________________________________________________ */

class RobotHistoryTracker {
    private Point position;
    private final List<Point> history = new ArrayList<>();

    public RobotHistoryTracker(Point startPosition) {
        this.position = startPosition;
        this.history.add(startPosition);
    }

    //we've created an array named history that is mutable using line 81, now we're adding values every movement
    public void move(Point delta) {
        this.position = this.position.plus(delta);
        this.history.add(this.position);
    }

    public Point getPosition() {
        return this.position;
    }

    public List<Point> getHistory() {
        return this.history;
    }
    
}

/*_________________________________________________________________________________________________________________
___________________________________________________________________________________________________________________
__________________________________________________________________________________________________________________ */
class ScoreKeeper {
    // A ScoreKeeper tracks an alliance's score during a match, so its score
    // needs to be able to change over time. Declare a `private int` field
    // named `score` below (don't initialize it here, the constructors will
    // handle that).
    private int score;

    // A team's score can never drop below zero. Declare a
    // constant named `MIN_SCORE`, equal to `0`, to represent
    // that floor.
    public static final int MIN_SCORE = 0;


    // Write a no-argument constructor `ScoreKeeper()` that starts the score
    // at `MIN_SCORE`. Instead of repeating the constructor logic, use
    // `this(...)` to call the other constructor below, passing `MIN_SCORE`
    // as the argument.
    public ScoreKeeper() {
        score = MIN_SCORE;
    }


    // Write a constructor `ScoreKeeper(int startingScore)` that sets `score`
    // to `startingScore`.
    public ScoreKeeper(int startingScore) {
        score = startingScore;
    }


    // Write a method `addPoints(int points)` that adds `points` to `score`,
    // then prints "Score is now: " followed by the new score. This method
    // doesn't need to give anything back to its caller, so its return type
    // should be `void`.
    public void addPoints(int points) {
        score+= points;
        System.out.println("Score is now: " + score);
    }


    // Write a method `applyPenalty(int points)` that subtracts `points` from
    // `score`, but never lets the score drop below `MIN_SCORE`. Use a local
    // variable named `newScore` to store the result of `score - points`.
    // If `newScore` is less than `MIN_SCORE`, set `score` to `MIN_SCORE`;
    // otherwise, set `score` to `newScore`. Either way, finish by printing
    // "Penalty applied. Score is now: " followed by the new score. This
    // method's return type should also be `void`.
    public void applyPenalty(int points) {
        int newScore = score - points;
        if (newScore < MIN_SCORE) {
            score = MIN_SCORE;
        } else {
            score = newScore;
        }
        System.out.println("Penalty applied. Score is now: " + score);
    }


    // Because `score` is private, write a getter method `getScore()` that
    // returns its current value as an `int`.

    public int getScore() {
        return score;
    }


    // Write a method `hasWon(int opponentScore)` that returns `true` if this
    // ScoreKeeper's `score` is greater than `opponentScore`, and `false`
    // otherwise.
    public boolean hasWon(int opponentScore) {
        if (score > opponentScore) {
            return true;
        } else {
            return false;
        }
    }


    // Write a method `reset()` that sets `score` back to `MIN_SCORE`,
    // reusing the constant rather than writing `0` directly.
    public int reset() {
        score = MIN_SCORE;
        return score;
    } 
}
    /*_________________________________________________________________________________________________________________
___________________________________________________________________________________________________________________
__________________________________________________________________________________________________________________ */

