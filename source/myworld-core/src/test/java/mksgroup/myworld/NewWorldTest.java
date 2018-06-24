/**
 * Copyright 2018, MKS GROUP.
 */
package mksgroup.myworld;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

/**
 * @author ThachLN
 *
 */
class NewWorldTest {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    NewWorld myEarth = new NewWorld();
    
    /**
     * Thử tạo 1 người tên là Thạch
     */
    @Test
    void testCreateCreature_N_1() {
        
        
        Creature thach = new Person();
        thach.setName("Thach");
        thach.setNo(0);

        try {
            thach.setBirthday(sdf.parse("1977/11/19"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        myEarth.createCreature(thach);
    }
    
    /**
     * Thử yêu cầu người làm toán
     */
    @Test
    void testCreateCreature_N_2() {
        testCreateCreature_N_1();

        Creature person1 = myEarth.getCreature(0);
        
        assertNotNull(person1);
        assertEquals("Thach", person1.getName());
        
        String sum = person1.doAction("Tính toán được", "1", "2");

        assertEquals("3", sum);
    }
}
