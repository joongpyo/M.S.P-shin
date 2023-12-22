package com.example.project.mapper;

import com.example.project.dto.DiseaseDto;
import com.example.project.dto.UserDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DiseaseMapper {

    @Select("SELECT COUNT(*) FROM disease WHERE dis_name = #{disName} ")
    public int getCheckDisName(String disName);
    @Insert("INSERT INTO disease VALUES(NULL, #{disName}, #{disSym}, now())")
    public void setDisease(DiseaseDto diseaseDto);
    @Select("SELECT * FROM disease ORDER BY dis_id DESC LIMIT #{startNum}, #{offset}")
    public List<DiseaseDto> getDisList(Map<String, Object> map);
    @Select("SELECT COUNT(*) FROM disease")
    public int getDisCount();
}
