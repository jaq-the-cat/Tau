package wintersteve25.tau.layout;

import java.util.Stack;

public class StackedAxialSettings<T> {
    private final Stack<T> horizontals;
    private final Stack<T> verticals;

    public StackedAxialSettings() {
        horizontals = new Stack<>();
        verticals = new Stack<>();
    }

    public T getLast(Axis axis) {
        if (axis == Axis.VERTICAL) return verticals.lastElement();
        return horizontals.lastElement();
    }
    
    public Stack<T> get(Axis axis) {
        return axis == Axis.VERTICAL ? verticals : horizontals;
    }
    
    public void push(Axis axis, T setting) {
        if (axis == Axis.VERTICAL) {
            verticals.push(setting);
            return;
        }

        horizontals.push(setting);
    }

    public void pop(Axis axis) {
        if (axis == Axis.VERTICAL) {
            verticals.pop();
            return;
        }

        horizontals.pop();
    }
}
