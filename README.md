# Martian Robots Code Challenge

In my solution to the `Martian Robots` I used pure TDD (red, green, refactor) and allowed myself only 3h to get as much code resolving the given problem so the code itself so yet code to be refactored as mentioned below

## Further refactoring

If i allowed myself more time on the challenge here is what I would implement:

### State pattern

I would encapsulating the behaviours within state objects to remove statement conditions and change object state in context to trigger its behaviour. 

examples:

`Oriontation` would be an type that implement `IOriontation` and embed turn left and right in the object

### Remove coupling

I would relay on interfaces and not `instantiate` any object but instead inject any dependencies it as parameter

example

```
    public Rover(IOrientation orientation, ILandscape landscape) {
        this.orientation = orientation;
        this.landscape = landscape;
    }
```

### Other design improvements

Here is some of the design improvements that could be yet implemented, did not list all of what could be done but here is the major and top issue

#### DRY principle 

remove logical code duplication 

example 

`canMoveYBackward`  and `canMoveXBackward`

#### SRP principle 

remove long methods that does more than one thing

example 

`getSampleOutput` is loading file processing the input and reporting it back

#### Primitive obsession

remove primitive types that can be used as substitution of classes

example

Introduce `Coordinate` use `rover.setCoordinate(coordinates` instead of `rover.setCoordinate(x, y)` 