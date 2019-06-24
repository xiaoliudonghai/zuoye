package com.example.zuoye1;

class Student {
    private String name;
    private String url;

    public Student(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
