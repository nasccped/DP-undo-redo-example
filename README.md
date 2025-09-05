<div align="center">

DP-undo-redo-example
====================

[![built in](https://img.shields.io/badge/built_in-kojamp_0.1.1-blue?)](https://github.com/nasccped/kojamp)
[![project kind: java](https://img.shields.io/badge/project_kind-java-orange?)](#)

</div>

This repository is an attempt to implement the `undo-redo` feature
introduced at _Design Patters: Elements of Reusable Object-Oriented
Software_[^design-patterns-book] book (page 62/358).

Basically, the book give us a problem to be solved by the following
though:

<div align="center" id="image-01">

![image 1: undo redo example](./images/undo-redo-example.jpg)

_image 1: undo redo example_

</div>

The user is facing a program's state. It can go back to previous
states and also go to next states (since the `undo` store the states
which can be reaplied).

My solution approach is a `stack` based object: (suitable for
LIFO[^lifo] problems).

<div align="center" id="image-02">

![image 2: solution approach](./images/solution-approach.jpg)

_image 2: solution approach_

</div>

Now, we can:
- insert incoming objects (states) in our `undo` stack,
- get the current state with `peek` (`undo` top state = current
  state),
- send top state from `undo` to `redo` stack whenever we call the
  _undo action_,
- send top element from `redo` to `undo` stack whenever we call the
  _redo action_,
- clear `redo` stack whenever a new states comes in our _"UndoRedo"_
  machine.

[^design-patterns-book]: Design Patters: Elements of Reusable
  Object-Oriented Software is a software engineering book that
  describes software design patterns. You can find it at
  [amazon website](https://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612).

[^lifo]: **LIFO** is a principle which dictates that the most
  recently added element to a collection is the first one to be
  removed or processed. This is analogous to a stack of plates.
