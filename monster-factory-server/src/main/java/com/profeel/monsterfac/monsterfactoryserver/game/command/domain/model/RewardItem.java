package com.profeel.monsterfac.monsterfactoryserver.game.command.domain.model;

import com.profeel.monsterfac.monsterfactoryserver.item.command.domain.model.ItemId;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * <pre>
 * Class : RewardItem
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

@Embeddable
public class RewardItem {
    @Embedded
    private ItemId itemId;



}
