package com.profeel.monsterfac.monsterfactoryserver.project.query.dao;

import com.profeel.monsterfac.monsterfactoryserver.project.query.data.EditInfoData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : EditInfoDataDao
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-13       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
public interface EditInfoDataDao extends JpaRepository<EditInfoData, Integer> {
}
