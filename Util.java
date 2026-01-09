import greenfoot.*;
/**
 * Util Class is to be filled with static utility methods 
 * to be called within other class' code
 * 
 * @Chase Coulter
 * @V1.1
 */
public class Util  
{
    /**
     * Private constructor to prevent instantiation
     */
    private Util(){}
    /**
     * Loads an image from the given file name and scales it to the specified width and height.
     *
     * @param imageName The path of the image file to load.
     * @param sizeX The width to scale the image to.
     * @param sizeY The height to scale the image to.
     * @return A GreenfootImage object with the specified dimensions.
     */
    public static GreenfootImage scale(String imageName, int sizeX, int sizeY) {
        if (imageName == null) {
            System.out.println("Util.scale("+ imageName +") is null");
            return new GreenfootImage(sizeX, sizeY);
        }
        GreenfootImage img = new GreenfootImage(imageName);
        img.scale(sizeX, sizeY);
        return img;
    }
    /**
     * Calculates the Euclidean distance between two Actor objects.
     *
     * @param a1 The first Actor.
     * @param a2 The second Actor.
     * @return The distance between the two Actors.
     */
    public static double distance(Actor a1, Actor a2) {
        int dx = a1.getX() - a2.getX();
        int dy = a1.getY() - a2.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Sets the transparency of an Actor's image. Values are clamped between 0 (invisible) and 255 (fully visible).
     *
     * @param actor The Actor whose image transparency will be set.
     * @param value The transparency value to set.
     */
    public static void setTrans(Actor actor, int value) {
        if (actor == null){
            System.out.println("Util.setTrans(actorName) is null");
            return;
        }
        if(value<0){
            value=0;
        } else if(value>255){
            value=255;
        }
        actor.getImage().setTransparency(value); // 0 = invisible, 255 = solid
    }

    /**
     * Mirrors the image of the given Actor horizontally.
     *
     * @param actor The Actor whose image will be flipped.
     */
    public static void flipImage(Actor actor) {
        if (actor == null) return;
        actor.getImage().mirrorHorizontally();
    }
}
