package Character;

import Weapon.KnifeBehavior;
import Weapon.SwordBehavior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrollTest {
    private Character character;
    @BeforeEach
    void setUp() {
        this.character = new Troll();
    }

    @Test
    void charaterNameEqualsTroll() {
        assertEquals("Troll",  character.getCharacter());
    }
    @Test
    void defaultWeaponEqualsAxe() {
        assertEquals("Axe", character.getWeapon());
    }
    @Test
    void changeWeaponToKnife() {
        character.setWeapon(new KnifeBehavior());
        assertEquals("Knife", character.getWeapon());
    }
}