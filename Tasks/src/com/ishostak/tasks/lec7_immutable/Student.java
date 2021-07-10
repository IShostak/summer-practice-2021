package com.ishostak.tasks.lec7_immutable;

import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private String group;
    MutableInfo info;

    public Student(String name, int age, String group, MutableInfo info) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.info = new MutableInfo(info.getInfo());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }

    public MutableInfo getInfo() {
        MutableInfo clonedInfo = new MutableInfo(this.info.getInfo());
        return clonedInfo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        if ( !(o instanceof Student)) return false;

        Student st = (Student)o;
        return  st.age == this.age & st.group.equals(this.group) & st.name.equals(this.name);
    }



    @Override
    public int hashCode() {
        return Objects.hash(name, age, group);
    }
}
