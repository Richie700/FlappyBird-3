# FlappyBird
FlappyBird Game for Android

---FullscreenActivity.java---
Main activity to display game

---GameEnvironment.java---
Class that holds all the corresponding game objects and is in charged
of  updating the screen throughout the game.

--GraphicComponent.java---
Represents a graphical element, such as the flappy bird and a pipe.
Contains methods such as hit testing and draw.

---PipeFactory.java---
Class in charge of creating a pipe object given the pipe's x-coordinate,
width, height and whether it is inverted.

---PipeList.java---
Class holding all the pipe objects and in charge of drawing all the pipes
and checking if the flappy bird has collided with a pipe.
