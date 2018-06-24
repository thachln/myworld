/**
 * Copyright 2018, MKS GROUP.
 */
package mksgroup.myworld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ThachLN
 *
 */
public class Person extends Animal {
    /** Danh sách hành động của Person. */
    private final static String[] ACTIONS = {"Tính toán được"};
    
    /**
     * [Explain the description for this method here].
     * @return
     * @see mksgroup.myworld.Animal#getActions()
     * @set using Arrays.asList: http://codippa.com/unsupportedoperationexception-when-adding-or-removing-element-to-a-list-in-java/
     */
    @Override
    public List<String> getActions() {
        // Lấy danh sách hành động của lớp cha
        List<String> listAction = new ArrayList<>(super.getActions());
        
        // Thêm vào hành động của lớp con Person
        List<String> thisListAction = Arrays.asList(ACTIONS);
        listAction.addAll(thisListAction);

        return listAction;
    }
    
    /**
     * Thực hiện hành động.
     * @param action hành động cần thực hiện
     * @param params các tham số cần truyền vào cho hành động.
     * Vd: muốn thực hiện cộng 2 số 3 + 4 thì gọi doAction("Tính toán được", "3", "4")
     * @return
     */
    @Override
    public String doAction(String action, String...params) {
        List<String> listAction = getActions();
        
        if (action == null) {

            return "Hành động đưa vào không có";
        } else if (listAction.contains(action)) {
            // Hành động cần thực hiện có trong danh sách hành động có thể làm
            
            if (ACTIONS[0].equals(action)) {
                // Tính toán cộng
                // Lấy 2 chữ số từ params
                List<String> listParams = Arrays.asList(params);
                String s1 = (listParams.size() > 0) ? listParams.get(0) : null;
                String s2  = (listParams.size() > 1) ? listParams.get(1) : null;
                
                return sum(s1, s2);
             } else {
                // Call super class to do action
            }
        } else {
            return "Tôi không làm được hành động này: " + action;
        }
        
        return null;
    }
    
    public String sum(String s1, String s2) {

        // Bạn tự viết method này
        return "3";
    }
}
