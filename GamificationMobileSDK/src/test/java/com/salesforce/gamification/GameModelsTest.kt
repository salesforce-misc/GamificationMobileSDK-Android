/*
 * Copyright (c) 2023, Salesforce, Inc.
 * All rights reserved.
 * SPDX-License-Identifier: BSD-3-Clause
 * For full license text, see the LICENSE file in the repo root or https://opensource.org/licenses/BSD-3-Clause
 */

package com.salesforce.gamification

import com.salesforce.gamification.model.*
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import org.junit.Test

class GameModelsTest {

    @Test
    fun testGamesResponse() {
        val games = Games(
            errorMessage = null,
            gameDefinitions = listOf(
                GameDefinition(
                    gameDefinitionId = "1",
                    description = "Play Spin The Wheel to Get Amazing Rewards",
                    endDate = "2023-10-31T19:00:00.000Z",
                    gameRewards = listOf(
                        GameReward(
                            gameRewardId = "501",
                            rewardDefinitionId = "101",
                            segColor = "01CD6C",
                            description = "Win\n $12 \n Off",
                            expirationDate = "2023-10-31T19:00:00.000Z",
                            imageUrl = null,
                            name = "10% Off",
                            rewardType = "Voucher",
                            rewardValue = null
                        )
                    ),
                    participantGameRewards = listOf(
                        ParticipantGameReward(
                            gameRewardId = "501",
                            gameParticipantRewardId = "201",
                            sourceActivityId = "201",
                            expirationDate = "2023-12-30T19:00:00.000Z",
                            issuedRewardReference = "12344",
                            status = "YetToReward"
                        )
                    ),
                    name = "Bonnie and Clyde Style Promotion",
                    startDate = "2023-10-01T19:00:00.000Z",
                    status = "active",
                    timeoutDuration = 10,
                    type = "SpintheWheel"
                )
            ),
            status = true
        )
        assertEquals(games.status, true)
        TestCase.assertNull(games.errorMessage)
        assertEquals(games.gameDefinitions.size, 1)
        val gameDef = games.gameDefinitions.firstOrNull()
        TestCase.assertNotNull(gameDef)
        assertEquals(gameDef?.gameDefinitionId, "1")
        assertEquals(gameDef?.description, "Play Spin The Wheel to Get Amazing Rewards")
        assertEquals(gameDef?.endDate, "2023-10-31T19:00:00.000Z")
        assertEquals(gameDef?.name, "Bonnie and Clyde Style Promotion")
        assertEquals(gameDef?.startDate, "2023-10-01T19:00:00.000Z")
        assertEquals(gameDef?.status, "active")
        assertEquals(gameDef?.timeoutDuration, 10)
        assertEquals(gameDef?.type, "SpintheWheel")
        val gameReward = gameDef?.gameRewards?.firstOrNull()
        assertEquals(gameReward?.gameRewardId, "501")
        assertEquals(gameReward?.rewardDefinitionId, "101")
        assertEquals(gameReward?.segColor, "01CD6C")
        assertEquals(gameReward?.description, "Win\n $12 \n Off")
        assertEquals(gameReward?.expirationDate, "2023-10-31T19:00:00.000Z")
        assertEquals(gameReward?.imageUrl, null)
        assertEquals(gameReward?.name, "10% Off")
        assertEquals(gameReward?.rewardType, "Voucher")
        assertEquals(gameReward?.rewardValue, null)
        val gameParticipantReward = gameDef?.participantGameRewards?.firstOrNull()
        assertEquals(gameParticipantReward?.gameRewardId, "501")
        assertEquals(gameParticipantReward?.gameParticipantRewardId, "201")
        assertEquals(gameParticipantReward?.sourceActivityId, "201")
        assertEquals(gameParticipantReward?.expirationDate, "2023-12-30T19:00:00.000Z")
        assertEquals(gameParticipantReward?.issuedRewardReference, "12344")
        assertEquals(gameParticipantReward?.status, "YetToReward")
    }

    @Test
    fun testGameRewardsResponse() {
        val gameRewardsResponse = GameRewardResponse(
            errorMessage = null,
            gameRewards = listOf(
                GameRewards(
                    gameRewardId = "501",
                    rewardDefinitionId = "101",
                    color = "01CD6C",
                    description = null,
                    expirationDate = "2024-01-04T20:00:00.000Z",
                    imageUrl = null,
                    name = "1000 Reward Points",
                    rewardType = "LoyaltyPoints",
                    rewardValue = "100.0",
                    issuedRewardReference = "3GRSB0000000Caf4AE"
                )
            ),

            status = true
        )
        TestCase.assertNotNull(gameRewardsResponse)
        assertEquals(gameRewardsResponse.status, true)
        assertEquals(gameRewardsResponse.gameRewards.size, 1)
        TestCase.assertNull(gameRewardsResponse.errorMessage)
        val reward = gameRewardsResponse?.gameRewards?.firstOrNull()
        TestCase.assertNotNull(reward)
        assertEquals(reward?.gameRewardId, "501")
        assertEquals(reward?.rewardDefinitionId, "101")
        assertEquals(reward?.color, "01CD6C")
        assertEquals(reward?.description, null)
        assertEquals(reward?.expirationDate, "2024-01-04T20:00:00.000Z")
        assertEquals(reward?.imageUrl, null)
        assertEquals(reward?.name, "1000 Reward Points")
        assertEquals(reward?.rewardType, "LoyaltyPoints")
        assertEquals(reward?.rewardValue, "100.0")
        assertEquals(reward?.issuedRewardReference, "3GRSB0000000Caf4AE")
    }
}
