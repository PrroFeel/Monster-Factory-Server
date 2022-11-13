package com.profeel.monsterfac.monsterfactoryserver.game.command.infra.service;

import com.profeel.monsterfac.monsterfactoryserver.common.annotation.DomainService;
import com.profeel.monsterfac.monsterfactoryserver.file.command.application.service.UploadFileService;
import com.profeel.monsterfac.monsterfactoryserver.file.command.domain.model.FileInfo;
import com.profeel.monsterfac.monsterfactoryserver.game.command.application.exception.RewardItemQuantityException;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model.DevelopProject;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model.RewardItem;
import com.profeel.monsterfac.monsterfactoryserver.game.command.domain.service.GameService;
import com.profeel.monsterfac.monsterfactoryserver.item.command.application.exception.NotFoundItemException;
import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.model.ItemId;
import com.profeel.monsterfac.monsterfactoryserver.item.query.data.ItemData;
import com.profeel.monsterfac.monsterfactoryserver.item.query.service.ItemQueryService;
import com.profeel.monsterfac.monsterfactoryserver.project.command.application.service.ProjectAppQueryService;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.Project;
import com.profeel.monsterfac.monsterfactoryserver.project.command.domain.model.ProjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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
@DomainService
public class GameServiceImpl implements GameService {
    private ProjectAppQueryService projectQueryService;
    private UploadFileService uploadFileService;

    private ItemQueryService itemQueryService;

    @Autowired
    public GameServiceImpl(
            ProjectAppQueryService projectQueryService,
            UploadFileService uploadFileService,
            ItemQueryService itemQueryService
    ){
        this.projectQueryService = projectQueryService;
        this.uploadFileService = uploadFileService;
        this.itemQueryService = itemQueryService;
    }

    @Override
    public DevelopProject createProject(Integer projectId) {
        Project project = projectQueryService.getProject(projectId);
        return new DevelopProject(
                new ProjectId(project.getId()),
                project.getEditor()
        );
    }

    @Override
    public FileInfo uploadImageFile(MultipartFile thumbnailFile) throws IOException {
        return uploadFileService.uploadImageFile(thumbnailFile);
    }

    @Override
    public RewardItem createRewardItem(Integer id, Integer quantity) {
        List<ItemData> itemDataList = itemQueryService.findItemById(id);
        if(itemDataList.isEmpty()){
            throw new NotFoundItemException("유효하지 않은 아이템 id 입니다");
        }
        if(quantity <= 0) {
            throw new RewardItemQuantityException("보상 아이템 수량이 0개 이하 입니다");
        }

        ItemData itemData = itemDataList.get(0);
        return new RewardItem(new ItemId(itemData.getItemId()), itemData.getItemName(), quantity);
    }
}
