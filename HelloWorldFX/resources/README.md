## Hello World

The following is a set of introductory notes about JavaFX.

### (Main) Application

This class is responsible for managing the life cycle of the program, whether it be the initialisation, launching,
starting and stopping. It allows Java applications to launch JavaFX GUI components from another thread.

In the Main class, we have 2 methods, **main** and **start**.

Main (```main(String[] args)```), as in most other Java applications is the entry point where the JavaFX application
 starts. It passes the command line arguments to the parent ```launch(args)``` method.

After the launch(...) has been executed, the application will enter a **READY STATE**, and the internal framework will
call the start() method. When this happens, the application will run in the JavaFX application thread.

### Start

When the start() is called, execution begins on the JavaFX application thread. This is similar to Java Swing's
EDT (Event Dispatch Thread)

### JavaFX Scene