package com.profeel.monsterfac.monsterfactoryserver.item.query.repository;

import com.profeel.monsterfac.monsterfactoryserver.item.query.data.ItemData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <pre>
 * Class : ItemQueryMapper
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-11       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Mapper
public interface ItemQueryMapper {

    List<ItemData> findItem();

    List<ItemData> findItemById(int itemId);
}
