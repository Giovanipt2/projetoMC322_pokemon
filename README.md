# Pokémon Battle Simulator

A simple Pokémon battle simulator implemented in Java.

## Description

This project is a turn-based Pokémon battle simulator where two trainers can battle each other with a team of Pokémon. The simulator implements the core mechanics of a Pokémon battle, including attacks, items, and status effects.

## Features

*   **Turn-based battle system:** Engage in classic Pokémon battles.
*   **GUI:** A simple graphical user interface to interact with the game.
*   **Pokémon and attacks:** A variety of Pokémon and attacks with different types and effects.
*   **Items:** Use items to heal your Pokémon or boost their stats.
*   **Status effects:** Pokémon can be affected by status conditions like poison and paralysis.

## How to Run

1.  **Compile the source code:**
    ```bash
    javac projetoMC322_pokemon/pokemon/*.java projetoMC322_pokemon/pokemon/GUI/*.java projetoMC322_pokemon/pokemon/ataques/*.java projetoMC322_pokemon/pokemon/itens/*.java
    ```
2.  **Run the main class:**
    ```bash
    java -cp projetoMC322_pokemon/pokemon Main
    ```

## Project Structure

*   `projetoMC322_pokemon/pokemon/`: Contains the core source code for the project.
    *   `Main.java`: The entry point of the application.
    *   `Batalha.java`: Implements the logic of a Pokémon battle.
    *   `Pokemon.java`: Represents a Pokémon with its stats, attacks, and other attributes.
    *   `Treinador.java`: Represents a Pokémon trainer.
    *   `GUI/`: Contains the graphical user interface classes.
    *   `ataques/`: Contains the different types of attacks.
    *   `itens/`: Contains the different types of items.
    *   `sprites/`: Contains the images of the Pokémon.

## Dependencies

This project does not have any external dependencies. It only requires a Java Development Kit (JDK) to be installed.

## Authors

*   ## Project Overview

The game is a single-elimination (knockout-style) Pokémon tournament designed for 4 players. Each player selects one starter Pokémon and three additional Pokémon. The tournament consists of two semifinals, a third-place match, and a final battle.

## Topics Covered

- **Object-Oriented Programming**: Classes, inheritance, encapsulation, and polymorphism  
- **Game Logic**: Turn-based battle mechanics and tournament structure  
- **Code Organization**: Modular design and clear separation of responsibilities  
- **Team Collaboration**: Development carried out in a team setting  

## Contributors

- [Adriano Campos](https://github.com/AdrianoCampos05)  
- [Pedro da Silva](https://github.com/pedro-git-hub)  
- [Matheus Scatolin](https://github.com/Matheus-F-Scatolin)


