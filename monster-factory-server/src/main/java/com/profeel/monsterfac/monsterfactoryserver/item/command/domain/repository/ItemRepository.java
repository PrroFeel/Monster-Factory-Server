package com.profeel.monsterfac.monsterfactoryserver.item.command.domain.repository;

import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <pre>
 * Class : ItemRepository
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-10       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
