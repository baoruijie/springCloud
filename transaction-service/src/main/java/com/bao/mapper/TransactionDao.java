package com.bao.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Mapper
@Repository
public interface TransactionDao {

    /*
     * CREATE TABLE `book` :`ID` ,`BOOK_NAME`,`BOOK_DESC` , `location`,`state` , `borrowtime`
     */
    @Update("update book set BOOK_DESC='transactionTest' where id = #{id}")
    int update(int id);
    @Update("update book set BOOK_NAME=#{bookName} where id = #{id}")
    int update2(@Param("id")int id, @Param("bookName") String bookName);
    @Insert("insert into book values (#{bookName}, #{bookDesc}, #{location}, #{state}, #{date})")
    int insert(@Param("bookName")String bookName, @Param("bookDesc")String bookDesc,
               @Param("location") String location, @Param("state") String state, @Param("date") Date date);
}
