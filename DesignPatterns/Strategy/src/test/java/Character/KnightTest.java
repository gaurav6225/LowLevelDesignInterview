package Character;

import Weapon.BowAndArrowBehavior;
import Weapon.SwordBehavior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {
    private Character character;
    @BeforeEach
    void setUp() {
        this.character = new Knight();
    }

    @Test
    void charaterNameEqualsKnight() {
        assertEquals("Knight",  character.getCharacter());
    }
    @Test
    void defaultWeaponEqualsBowAndArrow() {
        assertEquals("BowAndArrow", character.getWeapon());
    }
    @Test
    void changeWeaponToSword() {
        character.setWeapon(new SwordBehavior());
        assertEquals("Sword", character.getWeapon());
    }
}