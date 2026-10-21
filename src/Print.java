/*
 * Copyright 2026 FRCSoftware
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

void main() {
    // Print "Hello World!", with a newline at the end.
    System.out.println("Hello World!");


    // Print the following lines, each with a separate `println()` statement:
    System.out.println("The robot knows where it is at all times");
    System.out.println("It knows this because it knows where it isn't");
    // The robot knows where it is at all times.
    // It knows this because it knows where it isn't.


    // Define a variable `pi` that is equal to 3.14159.
    double PI = 3.14159;
    // HINT: Pick the correct data types.


    // Define a variable `g` that is equal to 10.
    int valueOfG = 10;


    // Define a variable `mode` that is equal to "autonomous".

    String robotMode = "autonomous";

    // Now, print all three variables in the **same** print statement,
    // separated by spaces.
    System.out.println(PI + " " + valueOfG + " " + robotMode);


    // Now, change pi to equal 3.142857 (a slightly incorrect approximation of pi
    // equal to 22 divided by 7). Then, print the value of `pi` again.

    PI = 3.142857;
    System.out.println(PI);


    // Create a variable `degrees` of type `double` and assign it a value of
    // 360. Then, print the variable to observe type narrowing behavior
    // (it prints 360.0 with a decimal part, instead of just 360, since the
    // variable uses a data type with decimal parts).
    double degrees = 360;
    System.out.println(degrees);

}
