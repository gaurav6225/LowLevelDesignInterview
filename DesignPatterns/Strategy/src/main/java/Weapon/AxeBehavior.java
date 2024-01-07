package Weapon;

public class AxeBehavior implements WeaponBehavior {
    private final String weaponName;

    public AxeBehavior() {
        this.weaponName = "Axe";
    }
    @Override
    public String getWeaponType() {
        return this.weaponName;
    }
    @Override
    public void useWeapon() {
        System.out.println("Using Axe");
    }
}
