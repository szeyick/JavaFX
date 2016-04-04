## JavaFX Fundamentals

Nodes are to JavaFX as to what Graphics objects are to Java Swing. It is the base class for drawing particular types
of shapes onto a scene.

### JavaFX Lines

Lines in JavaFX are similar to that of Java Swing, whereby you define two points in space, a start point and an end
point. The line will then be drawn between those two points.

Lines are drawn in screen coordinates and can have additional properties such as width and colour.

The screen coordinate system starts in the top left hand corner which is defined as point (0,0). This is different to
that of **Cartesian Coordinates**, where (0,0) is either at the centre of the area or where the x and y axis converge
which is the bottom left.

When moving in the x coordinate, these systems do not differ. It only differs when we move in the y-direction as it is
only in the screen coordinate system where if we move downwards along the y-axis, the value of y increases.

Lines require a start and end point, and the API will figure out the rest of how to get those two points to join.

```
Line line = new Line();
line.setStartX(100);
line.setStartY(10);
line.setEndX(10);
line.setEndY(110);
```

In the above code snippet, we will draw a line from (100,10) to (10,110), in screen coordinates. By default if we do
not specify any other properties for the line it will be drawn with a width of 1.0 and Color.BLACK.

There are other properties for lines, which can be found in the parent **Shape** class.

### Code Example (LineMain.java)

Here we set the title to the Stage, then create a root node object. This root object is the object in which we will add
all our graphical nodes too. That in turn is then added to our scene which is then displayed on the stage.

The code example plays around with the properties of the Line class and its parent Shape that allows us to set various
types of properties to the line that we're drawing.

Important to note in this example is for our red line -

```
redLine.getStrokeDashArray().addAll(10d, 5d, 15d, 5d, 20d);
redLine.setStrokeDashOffset(0);
```

In the above snippet, the getStrokeDashArray() allows us to create a dash segment, where the first dash is 10 pixels
wide, the next 5, then 15 and so fourth. The array will repeat itself if it doesn't have enough segments to fill
till the end of the line.

The following line, ```setStrokeDashOffset```, defines the distance into the current pattern that we will begin our
drawing. If we slide it along, we may begin at the second or third index rather than the first.

### Lambda Expressions

In this example, we create a slider to which we add a listener. The code looks a little funny because that is a lambda
expression which is part of the Java 8 API. It essentially creates an anonymous inner class that executes a function.

### Shapes

The shapes that you can draw in JavaFX are very similar to those that you can draw in Swing. In shape drawing, we mostly
just define the point on the screen where we wish to draw, then set the properties of the shape that we want to draw
then the API handles the rest.