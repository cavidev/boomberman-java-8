# Bomberman Java Game

<br />
<div align="center">
  <a href="https://github.com/cavidev/Juego-de-Boomberman">
      <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original-wordmark.svg" height="100" alt="Java Logo"  />
  </a>
  
  <h3 align="center">Java 8</h3>

  <p align="center">
    An awesome ROADMAP to learn and practice with Java 8
    <br />
    <a href="https://github.com/cavidev/Juego-de-Boomberman"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/cavidev/Juego-de-Boomberman">View Demo</a>
    ·
    <a href="https://github.com/cavidev/Juego-de-Boomberman/issues/new?labels=bug&template=bug-report---.md">Report Bug</a>
    ·
    <a href="https://github.com/cavidev/Juego-de-Boomberman/issues/new?labels=enhancement&template=feature-request---.md">Request Feature</a>
  </p>
</div>

## Overview

This project is an academic implementation of the classic **Bomberman** game, developed as part of the **Object-Oriented Programming course (IC-2101)** at the *Instituto Tecnologico de Costa Rica*. The game is built entirely in **Java**, following the principles of **object-oriented design** and focusing on applying core Java programming skills.

The main goal of this project was to create a playable version of Bomberman while demonstrating proficiency in Java, class design, inheritance, polymorphism, encapsulation, use of packages, exception handling, and multithreading.

## Features

- Hero places bombs to destroy blocks and eliminate enemies.
- Enemies include balloons and barrels with different behaviors.
- Randomized map generation with destructible and indestructible blocks.
- Three difficulty levels: Easy (20x20), Medium (40x40), and Hard (60x60).
- Object-oriented design with inheritance from a base class `Element`.
- Real-time enemy movement via multithreading.
- Sound effects and graphical representation of game elements.
- Scoreboard system based on game completion time.
- Game configuration through a GUI start menu.
- Internal documentation using Javadoc style.

## Game Mechanics

- **Hero**: Moves with arrow keys, places bombs with the spacebar, and aims to eliminate all enemies and find the secret exit hidden behind a block.
- **Bombs**: One bomb at a time, explodes after 3 seconds, affects a radius of 2 tiles, can kill enemies or the hero.
- **Enemies**:
  - **Balloons**: Move randomly and try to collide with the hero.
  - **Barrels**: Similar in purpose, but with different potential behavior (optional AI challenge).
- **Blocks**:
  - **Destructible Blocks**: Hide the secret door, can be destroyed by bombs.
  - **Barrier Blocks**: Indestructible, strategically placed to form mazes.
- **Empty Space**: Traversable tiles for the hero and enemies.
- **Smart Enemy AI (Optional)**: Bonus points for implementing and documenting enemy pathfinding logic.

## Object-Oriented Programming Concepts Used

- Class hierarchy with a superclass `Element`.
- Encapsulation using `private`, `public`, and `protected`.
- Abstract classes and interfaces where applicable.
- At least one custom exception implemented.
- Proper use of packages to separate GUI, logic, and models.
- Unit testing implemented for two selected classes, including the core gameplay logic class.

## Technical Requirements

- Java 8 or higher
- GUI created using Swing or similar Java library
- Sound and image resources included in the project
- Timer to record gameplay time and manage game events

## Documentation

- All methods are documented using Javadoc.
- External PDF documentation includes class diagrams, use cases, and implementation notes.
- Scoreboard data is saved in a local text file and displayed at game end.

## Evaluation Criteria (Academic)

- GUI Design and Functionality – 20%
- Functional Requirements (Gameplay) – 50%
- OOP Implementation Quality – 15%
- Documentation and Progress Reports – 15%

## Author

This project was developed by a student of Instituto Tecnológico de Costa Rica as part of a course requirement.

---

**Note**: This project was originally delivered on November 13, 2015. It was part of a pair-based assignment and subject to the institution's academic integrity policies.
