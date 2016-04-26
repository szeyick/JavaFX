## Layouts and UI Controls

It is important to work out how to present information in your application when working with
graphical UI's.

Since JavaFX is designed to create graphically rich applications, it has some built in default
controllers and layouts to quickly create good looking applications.

### Layouts:

JavaFX contains some stock layouts that provide common ways to present UI's onto our Scene.

- HBox
- VBox
- FlowPane
- BorderPane
- GridPane

### HBox

Otherwise known as a horizontal box, it allows for the placement of graphical components in a horizontal row. By default
the child nodes are added from **right to left** and takes the childs **preferred** width and height.

For a parent node that cannot be resized (i.e. Group Node), the height of the HBox will be taken from one of its child nodes,
whichever has the greatest height.

For child nodes that cannot be resized, such as Shape nodes, the parent container will take the **rectangular bounds** of
the shape for the width and height. For child components that can be resized, the parent container can manage the available
space to allow the child to grow horizontally, this is done through the ```HBox.setHrow()``` method.

```
TextField textField = new TextField();
HBox.setHgrow(textField, Priority.ALWAYS);
```

A HBox can contain several properties that can be used to lay out child components.

- Border - The outside space that surrounds the HBox.
- Padding - The space between the border and the child node.
- Spacing - Defines the horizontal space between child nodes.
- Margin - The space between the child node and the padding.

### VBox

Otherwise known as a vertical box, it allows for the placement of graphical components in a vertical row. By default the
child nodes are added from **top to bottom** and takes the childs **preferred** width and height.

For parent nodes that cannot be resized, the width is the largest preferred width from its children.

Each child node is aligned to the top left by default.

A runnable demonstration of the code for a VBox is available from the VerticalBox application.

### Flow Pane

It is similar to a HBox, however if we run out of space on a single row, we wrap the child node and place it onto the
next line.

It is like when we type into a word processor and we reach the maximum width of the parent, then the rest of our text
simply goes onto the next line and continues.

By default, a FlowPane layout sets the child nodes from **left to right**, we can change this by using the **setAlignment()**
method.

```
FlowPane flowPane = new FlowPane();
flowPane.setAlignment(Pos.TOP_RIGHT);
flowPane.getChildren().addAll(...);
```

### Border Pane

It defines a layout that allows us to place child nodes in the top, bottom, left, right or centre. For those that are
familiar with Swing, this is the same as the BorderLayout.

### Grid Pane

This is a layout that resembles a spreadsheet. In this layout we can specify the contraints of a row, column or even individual
cell.

The GridLayoutExample provides a sample application of how to utilise the constraints and layouts.

### UI Controls

These are advanced nodes that allow user input. This include but not limited to text fields, sliders, list views and tables.

As these are also nodes, we can play with its properties so as to set scaling, styling and effects.

### Menus

Like in any other application, JavaFX provides by default a menu component to allow users to interact with different
sections of an application.

```
MenuBar menuBar = new MenuBar();
Menu fileMenu = new Menu("File");
fileMenu.getItems().add(new MenuItem("Save"));
menuBar.getMenus().add(fileMenu);
```

In the code example above, the MenuBar is the parent for all menus. This object is the bar in which menu items are
added to. The Menu allows for adding of sub-menu's and the MenuItem is the actual selectable item.

It is possible to add other graphical nodes to a Menu to make it look more complex. We can add things like check boxes
and separators.

### Invoking Menu Items

Once we have created a menu item, we can assign it an action that will be executed when a user selects it.

To do this, we can assign an EventHandler to the MenuItem that will invoke the handle() method when a user selects the
menu item. We can do this either the traditional way of having an anonymous inner class or a class that extends EventHandler
or if we're using Java 8, we can make use of Lambdas.

```
// Implementing an EventHandler on a MenuItem with an anonymous inner class
myMenuItem.setOnAction(new EventHandler<ActionEvent>() {

    /**
    * Method invoked when user selects the menu item.
    */
    public void handle(ActionEvent t) {
        // Do something.
    }
}

// Implementing an EventHandler using Lambdas.
myMenyItem.setOnAction(actionEvent -> // Do something);
```

### Keyboard Shortcuts

Even though we can create menu items that can be accessed through mouse interactions, sometimes we might want to
access them through the keyboard in the form of shortcuts.

We can do this in JavaFX through **KeyCodeCombinations**, and assign a key that when pressed will invoke the same
Action Event that is assigned to the Menu Item.

```
MenuItem menuItem = new MenuItem("Save");
menuItem.setMnemonicParsing(true);
menuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.SHORTCUT_DOWN));
```

### Context Menus

Is a type of popup menu that appears when a user right clicks the mouse button. We can create a **ContextMenu** the
same way that we create a menu and add items to it the same way.

To get this popup to open, we can add an event handler to the stage and then when the event is received, we can display
the context menu.

```
// Add an event handler to respond to right mouse clicks to open a context popup.
primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent me) -> {
    if (me.getButton() == MouseButton.SECONDARY || me.isControlDown()) {
        contextMenu.show(root, me.getScreenX(), me.getScreenY());
    }
    else {
        contextMenu.hide();
    }
}
```

### Observable List Collection

For a long time, Java Swing developers have built applications using an ArrayList to represent a list of objects that
will be displayed as a list in a UI. This led to some issues when trying to synchronise models with their views.

The solution in JavaFX is to use the ObservableList class. It is a collection that is capable of notifying UI controls
when objects are added, updated and removed. These are generally used in ListView's and TableView's.

An example of the usage of an ObservableList is available in the ObservableListMain application.

In the example we use the ObservableList to contain the list items, we can update the list of items and display
in a single method. We can pass the ObservableList to the ListView which will manage the models in the list.

As we add the items to the ObservableList, the ListView is notified and automatically updated to reflect the changes
in the list.

### Table Views

We can also use the ObservableLists with a TableView. The JavaFX TableView is similar to the JTable for Swing.

Refer to the TableViewApplication for a code demo.

### Threading

When developing GUI applications, we must remember to avoid blocking the UI thread when the system is busy. Typically
in these types of applications, whenever a user interacts with the application, it blocks the UI so we'll need to offload
the user tasks or other tasks onto a different thread.




