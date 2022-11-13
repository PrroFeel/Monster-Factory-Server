package com.profeel.monsterfac.monsterfactoryserver.game.command.domain.service;

import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.FileInfo;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model.DevelopProject;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model.RewardItem;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <pre>
 * Class : GameService
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-11-11       최윤서           최초 생성
 * </pre>
 *
 * @author 최윤서
 * @version 1
 */
public interface GameService {
    DevelopProject createProject(Integer projectId);

    FileInfo uploadImageFile(MultipartFile thumbnailFile) throws IOException;

    RewardItem createRewardItem(Integer id, Integer quantity);
}
