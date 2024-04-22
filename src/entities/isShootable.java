package entities; // Package declaration for the 'entities' package

// Interface representing objects that can be shot
public interface isShootable {

    // Method signature for shooting action
    // Parameters:
    // - px: x-coordinate of the shot
    // - py: y-coordinate of the shot
    // Returns:
    // - boolean: true if the object was hit, false otherwise
    boolean shot(int px, int py); // Method to determine if an object is hit by a shot
}
