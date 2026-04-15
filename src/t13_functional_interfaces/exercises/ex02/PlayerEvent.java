package t13_functional_interfaces.exercises.ex02;

public class PlayerEvent {
    private String _playerId;
    private String _eventType;  // e.g. "KILL", "DAMAGE"
    private int _value;

    public PlayerEvent(String playerId, String eventType, int value) {
        _playerId = playerId;
        _eventType = eventType;
        _value = value;
    }

    public String getPlayerId() {
        return _playerId;
    }

    public String getEventType() {
        return _eventType;
    }

    public int getValue() {
        return _value;
    }

    @Override
    public String toString() {
        return _playerId + " | " + _eventType + " | " + _value;
    }
}