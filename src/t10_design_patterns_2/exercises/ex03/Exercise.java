package t10_design_patterns_2.exercises.ex03;

import java.util.ArrayList;
import java.util.List;

// Observer Pattern
// Where objects can "observe" other "observable" objects
//
public class Exercise {
    public static void run() {
        Button button = new Button();

        // ClickListener is the type for an observer
        // ALl observers must implement the Click Listener interface
        // and hence implement the onClick() method
        ClickListener sfx = new SoundListener();
        ClickListener analytics = new AnalyticsListener();

        button.addListener(sfx);  // sfx set to observe the button
        button.addListener(analytics);  //

        button.click();
        button.click();

        button.removeListener(sfx);

        button.click();
    }
}

// Abstract observer
interface ClickListener {
    void onClick();
}

// 'Concrete' ClickListeners (observers)
// that define specific actions
class SoundListener implements ClickListener {
    @Override
    public void onClick() {
        System.out.println("SFX: click");
    }
}

class AnalyticsListener implements ClickListener {
    @Override
    public void onClick() {
        System.out.println("ANALYTICS: click");
    }
}

// Button is "observable" in this case.
// An observer (ClickListener) is registered with the button using addListener()
// When a button is clicked, it iterates over the "observers" and calls the
// onClick() method of each observer.
// The Button doesn't know what concrete type objects are listening - it
// only knows that they exist and it can notify them when the Button is clicked.
class Button {
    private List<ClickListener> _listeners = new ArrayList<>();

    public void addListener(ClickListener l) {
        if (l == null)
            throw new IllegalArgumentException("listener is null.");

        _listeners.add(l);
    }

    public boolean removeListener(ClickListener l) {
        if (l == null)
            throw new IllegalArgumentException("listener is null.");

        return _listeners.remove(l);
    }

    public void click() {
        for (ClickListener l : _listeners)
            l.onClick();
    }
}