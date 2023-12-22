package com.example.project.mapper;

import com.example.project.dto.DiseaseDto;
import com.example.project.dto.FileDto;
import com.example.project.dto.MedicineDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface MedicineMapper {
    @Insert("INSERT INTO medicine VALUES(NULL, #{medName}, #{medDis}, #{medEff}, #{medType}, #{medStore}, #{medCom}, #{medAge}, #{medPregnant}, now(), #{isFiles})")
    @Options(useGeneratedKeys = true, keyProperty = "medId")
    public void setMedUpdate(MedicineDto medicineDto);
    @Insert("INSERT INTO admin_files VALUES(#{id}, #{orgName}, #{savedFileName}, #{savedPathName}, #{savedFileSize}, #{folderName}, #{ext})")
    public void setFile(FileDto fileDto);
    @Select("SELECT * FROM medicine ORDER BY med_id DESC LIMIT #{startNum}, #{offset}")
    public List<MedicineDto> getMedList(Map<String, Object> map);
    @Select("SELECT COUNT(*) FROM medicine")
    public int getMedCount();
}
