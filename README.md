# LLD-TicTacToe
## Problem Statement

Design a command-line based, 3x3 grid Tic Tac Toe game that can be played by 2-players.

## Requirements

### com.neeraj.Board

3x3 grid board with the following naming convention for squares of the grid

```
A1    A2    A3
B1    B2    B3
C1    C2    C3
```

### Players

com.neeraj.Game has 2 players. Every player has a name and a character. The character is by default, “X” and “O” for player 1 and 2, but players can pick their own characters. Both players must not have the same character.

### com.neeraj.Game

- com.neeraj.Game starts with com.neeraj.Player 1 inserting their character on one of the boxes
- Players get alternative turns, and insert their characters on boxes
- On every turn, take command line input of which box to place character
- After every turn show state of game
- After every turn, one of 4 conditions can happen
    - com.neeraj.Player specifies wrong box (already has been used);  
      In this case, same player will try again
    - Placing the character results in game winning condition (specified below);  
      in this case end the game and declare winner
    - com.neeraj.Player specifies correct box, but doesn’t win game;  
      Give turn to other player and continue game
    - com.neeraj.Board is full (this was last entry), and no winner;  
      Declare game draw and end game
- Winning conditions:   
  Same character in all boxes of:
    - any row
    - Any column
    - Any diagonal

## Data Format

### Initialise com.neeraj.Game & Players

```
Enter com.neeraj.Player 1 Name: 
> Aman 
Enter com.neeraj.Player 1 Character (X):
> ❎
Enter com.neeraj.Player 2 Name:
> Rahul 
Enter com.neeraj.Player 2 Character (O):
> 🛑
``` 

> Note: If player doesn’t enter details, default to following values
> com.neeraj.Player 1 - abc, X
> com.neeraj.Player 2 - qwe, 0


### Gameplay

```
com.neeraj.Board: 
_  _  _
_  _  _
_  _  _

com.neeraj.Player 1: Enter box: 
> A1 


com.neeraj.Board: 
❎ _  _
_  _  _
_  _  _

com.neeraj.Player 2: Enter box: 
> A2 

com.neeraj.Board: 
❎ 🛑 _
_  _  _
_  _  _

com.neeraj.Player 2: Enter box: 
> 
```

## Expectations

### Minimum Requirements
- Make sure that you have a working and demonstrable code
- Make sure that the code is functionally correct
- Code should be modular and readable
- Separation of concern should be addressed
- Please do not write everything in a single file (if not coding in C/C++)
- Code should easily accommodate new requirements and minimal changes
- There should be a main method from where the code could be easily testable
- Write unit tests, wherever applicable
- No need to create a GUI

### Optional Requirements
**Please do these only if you’ve time left.** You can write your code such that these could be accommodated without changing your code much.

- Keep the code extensible to change the size of the grid, max size is 26.
- Keep the code extensible to allow different types of pieces.
- Keep the code extensible to allow more than 2 players/piece types.


 