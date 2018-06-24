/**
 * Copyright 2018, MKS GROUP.
 */
package mksgroup.myworld;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ThachLN
 */
public class NewWorld {
    /** Danh sách chứa tất cả sinh vật trong thế giới này. */
    private List<Creature> listCreature = new ArrayList<>();
    
    /**
     * Tạo sinh vật mới.
     * @param creature sinh vật
     */
    public void createCreature(Creature creature) {
        listCreature.add(creature);
    }
    
    /**
     * Lấy thông tin của sinh vật.
     * @param no
     * @return
     */
    public Creature getCreature(int no) {
        if ((listCreature != null) && (no >= 0) && (no < listCreature.size())) {
            return listCreature.get(no);
        } else {
            return null;
        }
    }
}
