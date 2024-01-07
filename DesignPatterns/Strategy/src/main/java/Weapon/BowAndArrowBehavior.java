package Weapon;

public class BowAndArrowBehavior implements WeaponBehavior {
    private final String weaponName;

    public BowAndArrowBehavior() {
        this.weaponName = "BowAndArrow";
    }

    @Override
    public void useWeapon() {
        System.out.println("Using BowAndArrow");
    }

    @Override
    public String getWeaponType() {
        return this.weaponName;
    }
}
