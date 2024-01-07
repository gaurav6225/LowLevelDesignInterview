package Weapon;

public class SwordBehavior implements WeaponBehavior {

    private final String weaponName;
    public SwordBehavior() {
        this.weaponName = "Sword";
    }
    @Override
    public void useWeapon() {
        System.out.println("Using Sword");
    }
    @Override
    public String getWeaponType() {
        return this.weaponName;
    }
}
