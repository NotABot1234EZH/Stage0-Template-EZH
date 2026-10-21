/*
 * Copyright 2026 FRCSoftware
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

void main() {
    // Create a ScoreKeeper named `redAlliance` using the no-argument
    // constructor. Its score should start at `0`.
    ScoreKeeper redAlliance = new ScoreKeeper();


    // Call `redAlliance.addPoints(10)`, then `redAlliance.addPoints(46)`.
    // Each call should print the running total, ending with
    // "Score is now: 56".
    redAlliance.addPoints(10);
    redAlliance.addPoints(46);


    // Print `redAlliance`'s current score by calling `getScore()`, e.g.
    // `System.out.println(redAlliance.getScore());`
    System.out.println(redAlliance.getScore());


    // Call `redAlliance.applyPenalty(20)`. Since 56 - 20 equals 36, it is still above
    // or equal to `MIN_SCORE`, this should print "Penalty applied. Score is now: 36".
    redAlliance.applyPenalty(20);


    // Call `redAlliance.applyPenalty(100)`. Since 36 - 100 is below
    // `MIN_SCORE`, the score should be clamped instead of going negative,
    // printing "Penalty applied. Score is now: 0".
    redAlliance.applyPenalty(100);


    // Create a second ScoreKeeper named `blueAlliance`, this time using the
    // `ScoreKeeper(int startingScore)` constructor, passing `30`.

    ScoreKeeper blueAlliance = new ScoreKeeper(30);


    // Print the result of `redAlliance.hasWon(blueAlliance.getScore())`.
    // Since `redAlliance`'s score is currently 0, this should print `false`.
    // After running, change `blueAlliance`'s starting score to `-5`; the code
    // should now print `true` instead (recall `applyPenalty` isn't involved
    // here, so a starting score is allowed to be negative if passed in
    // directly through the constructor).
    System.out.println(redAlliance.hasWon(blueAlliance.getScore()));


    // Call `redAlliance.reset()`, then print `redAlliance.getScore()` again.
    // It should now print `0`, even though `redAlliance` never had any
    // penalties applied after its last penalty above.
    redAlliance.reset();
    System.out.println(redAlliance.getScore());

}
