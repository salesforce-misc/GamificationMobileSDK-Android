/*
 * Copyright (c) 2023, Salesforce, Inc.
 * All rights reserved.
 * SPDX-License-Identifier: BSD-3-Clause
 * For full license text, see the LICENSE file in the repo root or https://opensource.org/licenses/BSD-3-Clause
 */

package com.salesforce.gamification.repository

import com.google.gson.Gson
import com.salesforce.gamification.api.GameAPIConfig
import com.salesforce.gamification.api.GameAuthenticator
import com.salesforce.gamification.api.NetworkClient
import com.salesforce.gamification.model.GameRewardResponse
import com.salesforce.gamification.model.Games
import com.salesforce.gamification.utilities.GamificationLogger
import java.io.InputStreamReader

class GamificationRemoteRepository constructor(
    auth: GameAuthenticator,
    instanceUrl: String,
    gameClient: NetworkClient
) {

    companion object {
        private const val TAG = "GamificationAPIManager"
    }

    private val authenticator: GameAuthenticator

    private val mGameClient: NetworkClient

    private val mInstanceUrl: String

    init {
        authenticator = auth
        mInstanceUrl = instanceUrl
        mGameClient = gameClient
    }

    suspend fun getGameReward(
        gameParticipantRewardId: String,
        mockResponse: Boolean
    ): Result<GameRewardResponse> {
        GamificationLogger.d(TAG, "getGameReward() mockResponse : $mockResponse")

        if (mockResponse) {
            val reader =
                InputStreamReader(this.javaClass.classLoader?.getResourceAsStream("GameRewards.json"))
            val content: String = reader.readText()
            reader.close()
            val response =
                Gson().fromJson(content, GameRewardResponse::class.java)
            return Result.success(response)
        } else {
            return mGameClient.getNetworkClient().getGameReward(
                GameAPIConfig.getRequestUrl(
                    mInstanceUrl,
                    GameAPIConfig.Resource.GameReward(gameParticipantRewardId)
                ),
            )
        }
    }

    suspend fun getGames(
        participantId: String,
        gameParticipantRewardId: String? = null,
        mockResponse: Boolean
    ): Result<Games> {
        GamificationLogger.d(
            TAG,
            "getGames() participantId: $participantId gameParticipantRewardId: $gameParticipantRewardId mockResponse: $mockResponse"
        )

        if (mockResponse) {
            val reader =
                InputStreamReader(this.javaClass.classLoader?.getResourceAsStream("Games.json"))
            val content: String = reader.readText()
            reader.close()
            val response =
                Gson().fromJson(content, Games::class.java)
            return Result.success(response)
        } else {
            return mGameClient.getNetworkClient().getGames(
                GameAPIConfig.getRequestUrl(
                    mInstanceUrl,
                    GameAPIConfig.Resource.Games(participantId)
                ), gameParticipantRewardId = gameParticipantRewardId
            )
        }
    }
}