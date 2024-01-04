package com.example.project.mapper;

import com.example.project.dto.MyMedicineDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MypageMapper {

    @Insert("insert into myMedicine values(null, #{medId}, #{uId}) ")
    public void insertMyMed(MyMedicineDto myMedicineDto);
}