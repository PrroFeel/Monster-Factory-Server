package com.profeel.monsterfac.monsterfactoryserver.category.query.repository;

import com.profeel.monsterfac.monsterfactoryserver.category.query.data.CategoryData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <pre>
 * Class : CategoryMapper
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-14       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Mapper
public interface CategoryMapper {

    List<CategoryData> findAllCategorys();
}
