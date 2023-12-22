package com.example.project.mapper;

import com.example.project.dto.AdminBoardDto;
import com.example.project.dto.FileDto;
import com.example.project.dto.MedicineDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminBoardMapper {
    @Insert("INSERT INTO ${board} VALUES(NULL, #{subject}, #{writer}, #{content}, 0, now(),1,1,1,#{isFiles},0,1)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void setAdminBoard(AdminBoardDto adminBoardDto);
    @Insert("INSERT INTO ${board}_files VALUES(#{id}, #{orgName}, #{savedFileName}, #{savedPathName}, #{savedFileSize}, #{folderName}, #{ext})")
    public void setFile(FileDto fileDto);

    //게시판 List view QNA
    @Select("SELECT * FROM qna ORDER BY id DESC LIMIT #{startNum}, #{offset}")
    public List<AdminBoardDto> getQnaList(Map<String, Object> map);
    @Select("SELECT COUNT(*) FROM qna")
    public int getQnaCount();
    //Notice view
    @Select("SELECT * FROM notice ORDER BY id DESC LIMIT #{startNum}, #{offset}")
    public List<AdminBoardDto> getNoticeList(Map<String, Object> map);
    @Select("SELECT COUNT(*) FROM notice")
    public int getNoticeCount();

    // review
    @Select("SELECT * FROM review ORDER BY id DESC LIMIT #{startNum}, #{offset}")
    public List<AdminBoardDto> getReviewList(Map<String, Object> map);
    @Select("SELECT COUNT(*) FROM review")
    public int getReviewCount();
}

