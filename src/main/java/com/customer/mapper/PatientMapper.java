package com.customer.mapper;

import com.customer.entity.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PatientMapper {
    /**
     * 取消之前的默认就诊人
     * @param userId
     */
    @Update("update patient set is_default = 0 where user_id = #{userId} and is_default = 1")
    void cancelPreviousDefault(Long userId);

    /**
     * 新增就诊人
     * @param patient
     */
    void insert(Patient patient);
    /**
     * 动态条件查询
     * @param patient
     * @return
     */
    List<Patient> list(Patient patient);

    /**
     * 根据就诊人id列表批量删除就诊人
     * @param ids
     */
    void deleteByIds(@Param("ids") List<Long> ids);

    /**
     * 修改就诊人信息
     * @param patient
     */
    void update(Patient patient);
    /**
     * 根据id查询就诊人信息
     * @param id
     * @return
     */
    @Select("select * from patient where id = #{id}")
    Patient getById(Long id);
    /**
     * 根据id查询就诊人姓名
     * @param patientId
     * @return
     */
    @Select("select name from patient where id = #{patientId}")
    String getpatientNameById(Long patientId);
}
