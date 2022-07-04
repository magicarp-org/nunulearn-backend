package me.chanwookim.nunulearnbackend.domain;

public enum Category {
    DEV("개발.프로그래밍"),
    SEC("보안"),
    NET("네트워크"),
    DS("데이터 사이언스");

    private final String value;

    Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
