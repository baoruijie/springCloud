package com.bao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
public class BookEntity {

    int id;
    String bookName;
    String bookDesc;
    String localtion;
    String state;
    Date borrowtime;
}
