package Weapon;

public class KnifeBehavior implements WeaponBehavior {
    private final String weaponName;

    public KnifeBehavior() {
        this.weaponName = "Knife";
    }
    @Override
    public String getWeaponType() {
        return this.weaponName;
    }
    @Override
    public void useWeapon() {
        System.out.println("Using Knife");
    }
}
