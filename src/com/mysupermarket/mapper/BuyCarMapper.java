package com.mysupermarket.mapper;

import com.mysupermarket.pojo.BuyCar;
import com.mysupermarket.pojo.BuyCarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuyCarMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_car
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    int countByExample(BuyCarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_car
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    int deleteByExample(BuyCarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_car
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    int deleteByPrimaryKey(Integer bcId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_car
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    int insert(BuyCar record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_car
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    int insertSelective(BuyCar record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_car
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    List<BuyCar> selectByExample(BuyCarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_car
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    BuyCar selectByPrimaryKey(Integer bcId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_car
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    int updateByExampleSelective(@Param("record") BuyCar record, @Param("example") BuyCarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_car
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    int updateByExample(@Param("record") BuyCar record, @Param("example") BuyCarExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_car
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    int updateByPrimaryKeySelective(BuyCar record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table buy_car
     *
     * @mbggenerated Sun Aug 06 09:44:18 CST 2017
     */
    int updateByPrimaryKey(BuyCar record);
}