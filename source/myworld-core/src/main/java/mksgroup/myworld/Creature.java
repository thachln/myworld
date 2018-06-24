/**
 * Copyright 2018, MKS GROUP.
 */
package mksgroup.myworld;

import java.util.Date;
import java.util.List;

/**
 * @author ThachLN
 */
public abstract class Creature {
    /** Số thứ tự của Sinh vật. */
    private long no;

    /** Tên loài . */
    private String name;
    /** Ngày ra đời. */
    private Date birthday;

    /** Các Âm thanh phát ra được. */
    private List<String> sounds;

    /** Các Hoạt động làm được. */
    private List<String> actions;
    
    /**
     * Thực hiện hành động.
     * @param action
     * @param params
     * @return
     */
    public abstract String doAction(String action, String...params);

    /**
    * Get value of no.
    * @return the no
    */
    public long getNo() {
        return no;
    }

    /**
    * Get value of name.
    * @return the name
    */
    public String getName() {
        return name;
    }

    /**
    * Get value of birthday.
    * @return the birthday
    */
    public Date getBirthday() {
        return birthday;
    }

    /**
    * Get value of sounds.
    * @return the sounds
    */
    public List<String> getSounds() {
        return sounds;
    }

    /**
    * Get value of actions.
    * @return the actions
    */
    public List<String> getActions() {
        return actions;
    }

    /**
     * Set the value for no.
     * @param no the no to set
     */
    public void setNo(long no) {
        this.no = no;
    }

    /**
     * Set the value for name.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the value for birthday.
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * Set the value for sounds.
     * @param sounds the sounds to set
     */
    public void setSounds(List<String> sounds) {
        this.sounds = sounds;
    }

    /**
     * Set the value for actions.
     * @param actions the actions to set
     */
    public void setActions(List<String> actions) {
        this.actions = actions;
    }

}
