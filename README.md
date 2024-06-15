# Maze Explorer

## Overview

This Java program, developed by Naylene Rondon for the Florida Tech CIS 2503 course (6.2 Programming Assignment), simulates an exploration of a random horror maze. The program places the maze's exit and various bonus locations in a stack and allows the user to navigate through the maze.

## Features

- Generates a random maze layout with predefined locations.
- Uses a stack data structure to simulate movement through the maze.
- Alerts the user if they revisit a location and adds new locations during exploration.
- Ends with a message if the stack is empty before finding the maze's exit.

## How It Works

1. **Initialization**:
   - Initializes arrays for main locations (`locations`) and bonus locations (`bonusLocations`).
   - Uses a stack (`stackLocations`) to manage the user's path through the maze.
   - Randomly populates the stack with locations, ensuring the maze's exit (`Maze's Exit`) is placed first.

2. **Exploration Loop**:
   - Begins with a narrative introducing the maze and the need to escape.
   - Uses a `while` loop to navigate through the stack until the exit (`Maze's Exit`) is found or the stack is empty.
   - Checks for repeated locations using the `repeatedLocation` method.

3. **Outcome**:
   - Prints a success message if the maze's exit is found.
   - Ends with a message if the stack is empty before reaching the exit.
