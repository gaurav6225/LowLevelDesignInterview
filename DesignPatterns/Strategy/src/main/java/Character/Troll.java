package Character;

import Weapon.AxeBehavior;

public class Troll extends Character {
    public Troll() {
        super.setCharacter("Troll");
        super.setWeapon(new AxeBehavior());
    }
    @Override
    public void fight() {
        System.out.println("Troll is fighting");
    }
}
