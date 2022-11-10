package com.profeel.monsterfac.monsterfactoryserver.object.command.domain.repostiory;

import com.profeel.monsterfac.monsterfactoryserver.object.command.domain.model.ObjectFileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : ObjectFileRepository
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-09       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
public interface ObjectFileRepository extends JpaRepository<ObjectFileInfo, Integer> {
}
