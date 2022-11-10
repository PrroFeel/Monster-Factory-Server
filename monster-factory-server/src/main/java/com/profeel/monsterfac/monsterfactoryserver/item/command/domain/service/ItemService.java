package com.profeel.monsterfac.monsterfactoryserver.item.command.domain.service;

import com.profeel.monsterfac.monsterfactoryserver.common.annotation.DomainService;
import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.model.Item;
import org.springframework.web.multipart.MultipartFile;

/**
 * <pre>
 * Class : ItemService
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

@DomainService
public interface ItemService {

    Object registItem(MultipartFile image, Item item);
}
