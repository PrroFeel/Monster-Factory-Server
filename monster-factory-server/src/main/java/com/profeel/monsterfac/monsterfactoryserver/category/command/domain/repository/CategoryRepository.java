package com.profeel.monsterfac.monsterfactoryserver.category.command.domain.repository;

import com.profeel.monsterfac.monsterfactoryserver.category.command.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 * Class : CategoryRepository
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-08       최은진           최초 생성
 * </pre>
 *
 * @author 최은진(최초 작성자)
 * @version 1(클래스 버전)
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
}
