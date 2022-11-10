package com.profeel.monsterfac.monsterfactoryserver.tower.command.domain.service;

import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.ModelingFileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <pre>
 * Class : ObjectService
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
 * @see 참고할 class 또는 외부 url
 */
public interface TowerService {

    ModelingFileInfo uploadFile(MultipartFile multipartFile) throws IOException;

}
