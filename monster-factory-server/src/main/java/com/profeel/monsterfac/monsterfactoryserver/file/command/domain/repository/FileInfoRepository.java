package com.profeel.monsterfac.monsterfactoryserver.file.command.domain.repository;

import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Class : FileInfoRepository
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-21       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 * @see 참고할 class 또는 외부 url
 */
public interface FileInfoRepository extends JpaRepository<FileInfo, Integer> {
}
