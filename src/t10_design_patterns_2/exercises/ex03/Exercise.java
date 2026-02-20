package t10_design_patterns_2.exercises.ex03;

import java.util.ArrayList;
import java.util.List;

// Observer Pattern
// Where objects can "observe" other "observable" objects.
// Observers are registered with the object being observed.
// When some Event occurs, the observed object notifies all its observers.
//
public class Exercise {
    public static void run() {
        Button button = new Button();

        // ClickListener is the type for an observer
        // ALl observers/listeners must implement the ClickListener interface
        // and hence implement the onClick() method
        ClickListener sfxListener = new SoundListener();  // sound effects listener
        ClickListener analyticsListener = new AnalyticsListener();

        button.addListener(sfxListener);  // sfxListener is registered with the button as observer/listener
        button.addListener(analyticsListener);  //

        button.click();
        button.click();

        button.removeListener(sfxListener);  // remove a specific listener

        button.click();
    }
}

// Observer/Listener Interface
// All observers must comply with this 'contract'
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
// only knows that they exist, and that they are CLickListener types.
//
class Button {

    private List<ClickListener> _listeners = new ArrayList<>();

    public void addListener(ClickListener listener) {
        if (listener == null)
            throw new IllegalArgumentException("listener is null.");

        _listeners.add(listener);
    }

    public boolean removeListener(ClickListener listener) {
        if (listener == null)
            throw new IllegalArgumentException("listener is null.");

        return _listeners.remove(listener);
    }

    // Notify all registered listeners
    public void click() {
        for (ClickListener listener : _listeners)
            listener.onClick();
    }
}