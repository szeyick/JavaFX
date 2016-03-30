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

In JavaFX, the API is modeled on a stage play. In the start() method, you'll see that there are two objects called
**Stage** and **Scene**. If we take this example, the play is comprised of one to many **scenes**, and each scene
is performed on a **stage**.

The stage is the equivalent to a JFrame or JDialog in Swing, whereas the scene is the content pane like a JPanel that
  acts as a container that can hold other objects.

If we follow the example defined in the Main class we'll see the following lines

```
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root, 300, 275));
    primaryStage.show();
```

Here, the primaryStage object is where the scene takes place. If this was Swing, it'd be the JFrame and is the world
in which our play will take place. We give it a name, and scene object which takes the **root** as a parameter. The
root in this instance is the top level surface for the window.

### JavaFX Node

A node is the base class for all other scene graph nodes that can be drawn onto the screen. Nodes can have the following
properties applied to them, scaling, transform, translation and effects. These are generally graphical objects that can
be manipulated within the scene.

Common JavaFX nodes are UI controllers (i.e. buttons, labels) and shape objects. Much like in Swing, a scene will contain a
collection of child nodes, or a group of nodes that need to be displayed.

In our example, we define the layout of the nodes in the **sample.fxml**, where we add a **Label** and a **Button**.
These UI controllers are part of the **root** element ```<GridPane> </GridPane>```.

This root element is added to the primaryStage, then show() is called. This prompts the stage object to display the
JavaFX window and to show the scene that we have set to it.