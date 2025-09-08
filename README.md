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

## Cloning, compiling and running

To clone the project you can:

```sh
# clone using git
git clone https://github.com/nasccped/DP-undo-redo-example
# remove git folder (works for bash based terminals, only)
rm -rf DP-undo-redo-example/.git/
# goto dir
cd DP-undo-redo-example
```

### Compiling

Since this project was built under the kojamp[^kojamp] project
manager, you can use it to handle the project, or:

- compile using a bash terminal (Linux):
```sh
javac $(find src -type f -name **.java) -d out
```
- compile using a powershell terminal (Windows):
```powershell
javac (Get-ChildItem -Recurse -Path src -Filter *.java | ForEach-Object { $_.FullName }) -d out
```

Finally, you can execute the program by running:
```sh
java --class-path out UndoRedoExample
```

## Where's the `Command` pattern?

On the _Design Patterns_[^design-patterns-book] book, this kind of
problem is used to exemplify the _Lexi's_[^lexi-program] program
building.

The author enforces that our program must be able to execute (and
_"unexecute"_) some actions. `Command` is a great design pattern to
this job!

However, I just want to provide this thinking technology of
_"goNext/goPrevious"_ in a machine state timeline (shown in
[image 1](#image-01)).

## How our app works?

Our app can be separated into three pieces:

1. user input catching+parsing
2. the machine itself
3. utilities used throughout the code

### User input

Before defining the valid user input values, we should think about
how our machine works.

#### Machine's policy

The machine doesn't work with real states and commands, but it should
store values as states and run actions. They both come from the user
input's default type (`String`).

With this in mind, we should be able to turn `String`s into state
value's or action's types (from the self `String` value).

Let's consider:
- **unsigned integer (`0`, `312981`, `...`):** as state value's type
- **action entries (`do_it`, `d`, `...`):** as action kind type

Now, we can parse user input (`String`) to value (`Integer`) or
action (`Action`) type:

| user input         | type     | inner value        |
| ------------------ | -------- | ------------------ |
| `String("dothis")` | `Action` | **do this action** |
| `String("dothat")` | `Action` | **do that action** |
| `String("123")`    | `Value`  | **123**            |
| `...`              | `...`    | **...**            |

All this stuff is done by the `userinput` package. `String` input is
parsed by the `UserInputStrategy` object, and converted to an
`AbstractUserInput` child object (like an enum variant).

### Undo/Redo machine

#### Controller

The undo-redo machine stores it's inner attributes (undo and redo
stacks, coloring styles, inner report). You can call any
`UndoRedoMachine` method **as long as this doesn't change the inner
attributes**, otherwise, you'll need to call methods from the
`MachineController`, which provides methods to handle user input
(change machine's inner state) and to update machine's report.

#### Commands

The machine provides four different kind of commands:

| command                     | alias | description                                              |
| --------------------------- | ----- | -------------------------------------------------------- |
| `undo`                      | `u`   | pop an element from undo stack and send it to redo stack |
| `redo`                      | `r`   | pop an element from redo stack and send it to undo stack |
| `<unsigned int>` _(insert)_ | _-_   | insert an element into our machine (to undo stack)       |
| `quit`                      | `q`   | ends the machine process                                 |

##### Command rules

The `undo` command will works only if the undo stack isn't empty. The
`redo` command/stack follows the same rule.

Whenever a new item is pushed to our machine, the `redo` stack will
be clear.

### Utils

This project provides four utils only:

1. `Colors`: a shortcut to use ANSI[^ansi] color escapes without code
   repetition
2. `Printer`: a shortcut to avoid `Sytem.out.println` in the entire
   code
3. `ScannerUtil`: same as bullet above, but for input getting
4. `Strategy`: an interface used to return specific outputs based on
   a defined input

[^design-patterns-book]: Design Patters: Elements of Reusable
  Object-Oriented Software is a software engineering book that
  describes software design patterns. You can find it at
  [amazon website](https://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612).

[^lifo]: **LIFO** is a principle which dictates that the most
  recently added element to a collection is the first one to be
  removed or processed. This is analogous to a stack of plates.

[^kojamp]: Kojamp is a Java and Kotlin project manager I built. You
  can find more info on it's
  [official repository](https://github.com/nasccped/kojamp)

[^lexi-program]: _Lexi_ is a hypothetical word processor that the
  authors use throughout the _Design Patterns_[^design-patterns-book]
  book as a running example to demonstrate different design patterns.

[^ansi]: ANSI escape sequences are a standard for in-band signaling
  to control cursor location, color, font styling, and other options
  on video text terminals and terminal emulators.
