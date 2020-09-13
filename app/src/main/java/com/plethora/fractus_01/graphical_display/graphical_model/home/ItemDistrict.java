package com.plethora.fractus_01.graphical_display.graphical_model.home;


import java.io.Serializable;

public class ItemDistrict implements Serializable {

    private String nameDistrict;
    private String subject;
    private String preview;
    private String date;
    //private boolean stared;
    //private boolean unread;
    private boolean selected;


    public String getNameDistrict() {
        return nameDistrict;
    }

    public void setNameDistrict(String nameDistrict) {
        this.nameDistrict = nameDistrict;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



  /*public boolean isStared() {
    return stared;
  }

  public void setStared(boolean stared) {
    this.stared = stared;
  }


  public boolean isUnread() {
    return unread;
  }

  public void setUnread(boolean unread) {
    this.unread = unread;
  }*/


    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }


    public static class DistrictBuilder {

      transient   private String nameDistrict;
      transient private String subject;
      transient private String preview;
      transient private String date;
      transient private boolean stared;
      transient private boolean unread;
      transient private boolean selected;

      public DistrictBuilder setUser(String nameDistrict) {
            this.nameDistrict = nameDistrict;
            return this;
        }

        public DistrictBuilder setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public DistrictBuilder setPreview(String preview) {
            this.preview = preview;
            return this;
        }

        public DistrictBuilder setDate(String date) {
            this.date = date;
            return this;
        }

        public DistrictBuilder setStared(boolean stared) {
            this.stared = stared;
            return this;
        }

        public DistrictBuilder setUnread(boolean unread) {
            this.unread = unread;
            return this;
        }

        public DistrictBuilder setSelected(boolean selected) {
            this.selected = selected;
            return this;
        }

        private DistrictBuilder() {
        }

        public static DistrictBuilder builder() {
            return new DistrictBuilder();
        }

        public ItemDistrict build() {
            ItemDistrict itemDistrict = new ItemDistrict();
            itemDistrict.nameDistrict = nameDistrict;
            itemDistrict.subject = subject;
            itemDistrict.preview = preview;
            itemDistrict.date = date;
            //itemDistrict.stared = stared;
            //itemDistrict.unread = unread;
            itemDistrict.selected = selected;
            return itemDistrict;
        }

    }

}