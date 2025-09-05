<div align="center">

UndoRedoExample
===============

[![built in](https://img.shields.io/badge/built_in-kojamp_0.1.1-blue?)](https://github.com/nasccped/kojamp)
[![project kind: java](https://img.shields.io/badge/project_kind-java-orange?)](#)

</div>

This repository is an attempt to implement the `undo-redo` feature
introduced at _Design Patters: Elements of Reusable Object-Oriented
Software_[^design-patterns-book] book (page 62/358).

Basically, the book give us a problem to be solved by the following
though:

<div align="center">

![image 1: undo redo example](./images/undo-redo-example.jpg)

_image 1: undo redo example_

</div>

The user is facing a program's state. It can go back to previous
states and also go to next states (since the `undo` store the states
which can be reaplied).

[^design-patterns-book]: Design Patters: Elements of Reusable
  Object-Oriented Software is a software engineering book that
  describes software design patterns. You can find it at
  [amazon website](https://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612).
