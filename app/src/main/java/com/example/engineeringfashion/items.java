package com.example.engineeringfashion;

public class items {
    public String categoryiconlinkl;
    public String categoryname;

    public items(String categoryiconlinkl, String categoryname) {
        this.categoryiconlinkl = categoryiconlinkl;
        this.categoryname = categoryname;
    }

    public String getCategoryiconlinkl() {
        return categoryiconlinkl;
    }

    public void setCategoryiconlinkl(String categoryiconlinkl) {
        this.categoryiconlinkl = categoryiconlinkl;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
}
