# A Game Where One Red Square Dodges Lots of Blue Squares
## AP CompSci Final Project | Trevor McKay, Dean Whiteside

---

## Summary
The player takes control of a red square at the bottom of the screen. Enemies spawn in waves with the amount increasing with each completed wave and hard enemies spawning every five waves. Enemies fire projectiles on semi-random intervals. The player advances in the game by destroying all enemies on the screen.

---

## Controls
W - Up,
A- Left,
S- Down,
D - Right,
Spacebar - Fire projectile,
Escape - Close game

---

## How does it work?
### A breakdown of each class and what it does

### STATE and ID
The STATE enumeration allows the game to identify what state the game is in (menu, in-game, paused, etc.).
The ID enumeration allows the game to differentiate between enemies, bosses, players, and projectiles.

### Window
This class is responsible for defining the game window. It creates a JFrame of the desired width and height that is not resizable.

### Menu
This class handles the two separate game menus. It draws rectangles and text to the window to for UI using the built in graphics class. It is also responsible for creating and implementing a mouse listener for mouse input.

### KeyInput
This handles the keyboard input that is used in-game and in the menus. It adds velocity to the player whenever the corresponding key is pressed.

### AudioPlayer
This class uses the Slick, JIunput, JOgg, JOrbis, and lwjgl classes to play .wav or .ogg sound files in-game. Currently implemented are music, menu noises, and some game sound effects.

### GameObject
This is the parent class for BasicEnemy, Boss, Player, and Projectile. Each game object has a size, color, position, x-velocity, y-velocity. Each has the option to implement collision or the ability to fire a projectile.

  * **BasicEnemy** - Has a radom x-position and variable y-position. Represented by a 32x32 blue square. Its collision is slightly larger than itself to make for more forgiving hit detection
  * **Boss** - The same as BasicEnemy except larger and represented by a 64x64 magenta square.
  * **Player** - Similar to BasicEnemy, but the collision is smaller and represented by a 32x32 red square.
  * **Projectile** - Has variable size and color. Does not have collision of its own. A boolean value represents whether or not the projectile was fired by a player.
  
### Spawn
This class handles the level system. It spawns a number of instances of BasicEnemy equal to the number of waves. Every fifth wave it spawns a number of Bosses equal to (number of waves)mod(5). The spawner will distribute enemies into three rows as each fills up. It caps out at wave eleven.
