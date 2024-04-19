  
 
# Duck Shooter
2D Shooting Game
─
Team Member
1.Devanshu
2.Sakcham
3.Domendra
4.Tushar


# Table of Content

1.	Introduction
2.	Objective
3.	Implementation Details
    3.1 Gameplay Overview
    3.2 Implementation of OOP’s
4.	Code Sample
5.	Future Scope
6.	Conclusion
7.	References



# Introduction
The 2D Duck Shooter Game is a Java-based project that incorporates object-oriented programming (OOP) concepts to create an entertaining gaming experience. 
The Swing library has been used for the graphical user interface .Developed with a focus on OOP principles, the game showcases various aspects of inheritance, encapsulation, polymorphism, and abstraction to ensure a well-structured and maintainable codebase.
Developed as part of a programming endeavor, this project aims to demonstrate proficiency in programming concepts while delivering a captivating gameplay experience. By leveraging Java's capabilities for graphics rendering, event handling, and object-oriented programming, the game offers players an engaging challenge as they take on the role of a hunter aiming to shoot ducks flying across the screen.

# Objective

The primary objective of this project is to design and implement a 2D shooter game in Java, incorporating key programming principles such as object-oriented programming (OOP), event handling, and graphical user interface (GUI) development. Additionally, the project seeks to provide players with an enjoyable gaming experience while showcasing the versatility of Java for game development.

The main goal of the game is to shoot down as many ducks as possible within a limited time frame.


# Implementation Details

1. Gameplay overview:

The objective of the game is to shoot down as many ducks as possible within a limited time frame.

Player Control:
 The player controls a crosshair using the mouse or keyboard arrow keys to aim at the ducks.

Duck Movement: 
Ducks move across the screen horizontally from one side to another in a random or predefined pattern. The speed of the ducks may vary, making it challenging for the player to aim accurately.

Shooting Mechanics: 
When the player clicks the mouse button or presses a designated key, a projectile is fired from the crosshair towards the aimed direction. If the projectile hits a duck, the duck is considered "shot down."

Scorekeeping:
 Points are awarded to the player for each duck shot down successfully. The score increases with each successful hit. Additionally, bonus points may be awarded for shooting down ducks consecutively or hitting ducks at long distances.

Time Limit:
 The game has a time limit within which the player must shoot as many ducks as possible. As time progresses, the game may become more challenging by increasing the speed of the ducks or introducing more ducks on the screen simultaneously.

Game Over:
 The game ends when the time limit expires or when the player runs out of ammunition without achieving a specified score target. The final score achieved by the player is displayed along with an option to restart the game.




Sound Effects and Visuals:
 Engaging sound effects such as  shooting sounds enhance the gaming experience. Visual elements like animated sprites for ducks, crosshair, and projectiles, along with a visually appealing background, contribute to the overall aesthetic of the game.


2 . Implementation of OOP concept:

Inheritance:

Inheritance is a fundamental OOP concept where a class (subclass) can inherit properties and behaviors from another class (superclass).
In the game, we can have a superclass called GameObject, which represents common properties and behaviors shared by all game objects, such as position, velocity, and rendering methods.
Subclasses like Duck, Bullet, and Player can inherit from GameObject. Each subclass can then add its specific properties and behaviors. For example, the Duck subclass may have attributes like flySpeed and methods like move(), while the Player subclass may have attributes like score and methods like shoot().
 
Encapsulation:

Encapsulation is the bundling of data and methods that operate on the data within a single unit (class), and restricting access to some of the object's components.
In the game, we encapsulate the internal state of game objects by making their member variables private and providing public methods (getters and setters) to access and modify these variables.
For instance, the GameObject class may have private variables like xPosition and yPosition, with public methods like getXPosition() and setYPosition(int y) to access and modify these variables, respectively.
 

Polymorphism:

Polymorphism allows objects of different classes to be treated as objects of a common superclass, enabling methods to behave differently based on the object being operated upon.
In the game, we can achieve polymorphism through method overriding and dynamic method dispatch.
For example, the GameObject superclass may have a method render() to display the game object on the screen. Each subclass (Duck, Bullet, Player) can override this method to provide its own implementation of rendering.
At runtime, when we call the render() method on a game object, the appropriate implementation (either from the superclass or subclass) is dynamically selected based on the actual type of the object.
 




Abstraction:

Abstraction involves hiding the complex implementation details of objects and exposing only the essential features.
In the game, we can use abstraction to define interfaces or abstract classes that specify a set of methods without providing implementations.
For example, we can define an interface Movable with methods like move() and updatePosition(). Both the Duck and Player classes can implement this interface, providing their own implementations of these methods.
Abstraction allows us to treat different types of game objects uniformly based on their common interface, promoting code reuse and flexibility.
 

By effectively implementing these OOP concepts, the 2D Duck Shooter Game achieves a well-structured and maintainable codebase, enabling easy extension and modification as the project evolves.


# Code Samples 
In Source folder : 
entities: This folder contains Java classes representing different entities in the game, such as ducks, players, bullets, etc.
Frames: The “Frames” folder includes classes related to GUI frames and windows. These classes handle the graphical user interface components.
inputs: The “inputs” folder  holds classes responsible for handling user input, such as keyboard and mouse events.
levels: In the “levels” folder, classes or files define the different game levels.
main: The “main” folder contains classes for running the games:
Game: A class responsible for managing the game loop, updating game state, and rendering graphics.
GamePanel: A class representing the game panel where graphics are drawn.
GameWindow: class that creates the game window and handles window-related functionality.
MainClass: This class contains the main method which initializes the game.
utility: The “utility” folder stores utility classes ( loadsave, constants, sprites) providing common functionality used across the game.

 

# Future Scope

●	Despite reaching this milestone, there are still areas for improvement and expansion in the project.
●	Future plans may include implementing additional game features, enhancing graphics and audio, optimizing performance.
●	Additional game modes, such as time trials or survival modes.
●	More diverse duck behaviors and movement patterns to increase gameplay variety.
●	Integration of online leaderboards to allow players to compete for high scores.
●	Support for customizable controls and settings to cater to individual player preferences.


# Conclusion
In conclusion, the development of the 2D Duck Shooter Game in Java has provided a practical application of programming concepts while delivering an engaging and entertaining gaming experience. Through careful implementation of game mechanics, player interaction, and audio-visual effects, the project has demonstrated the versatility of Java for game development and use of the oop concept. By adhering to coding standards and emphasizing key programming principles, the game offers players a captivating experience while serving as a valuable learning tool for us as java learners.






# References
●	Oracle Java Documentation: https://docs.oracle.com/javase/
●	Stack Overflow: https://stackoverflow.com/
●	Java Game Development Tutorials:https://www.youtube.com/@KaarinGaming

