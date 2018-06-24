/**
 * Copyright 2018, MKS GROUP.
 */
package mksgroup.myworld;

import java.util.Arrays;
import java.util.List;

/**
 * @author ThachLN
 */
public class Animal extends Creature {

    /** Danh sách hành động của Animal. */
    private final static String[] ACTIONS = {"Đi"};

    /**
     * Trả lại danh sách hành động của animal có thể thực hiện.
     * @return danh sách chuỗi thể hiện hành động
     * @see mksgroup.myworld.Creature#getActions()
     */
    @Override
    public List<String> getActions() {

        return Arrays.asList(ACTIONS);
    }

    /**
     * Thực hiện hành động.
     * @param action
     * @param params Các thông số cho hành động: tham số 1: cho biết hướng đi; tham số 2 cho biết số mét cần đi.
     * @return text mô tả hành động sẽ thực hiện
     * @see mksgroup.myworld.Creature#doAction(java.lang.String, java.lang.String[])
     */
    @Override
    public String doAction(String action, String... params) {
        if (ACTIONS[0].equals(action)) {
            List<String> listParams = Arrays.asList(params);
            String param1 = (listParams.size() > 0) ? listParams.get(0) : "";
            String param2  = (listParams.size() > 1) ? listParams.get(1) : "";
            
            return "Tôi đi " + param1 + " " + param2;
        } else {

            return "Tôi không làm được hành động này: " + action;
        }
    }
}
