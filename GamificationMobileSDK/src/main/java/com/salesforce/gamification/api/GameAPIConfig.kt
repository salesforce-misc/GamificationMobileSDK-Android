/*
 * Copyright (c) 2023, Salesforce, Inc.
 * All rights reserved.
 * SPDX-License-Identifier: BSD-3-Clause
 * For full license text, see the LICENSE file in the repo root or https://opensource.org/licenses/BSD-3-Clause
 */

package com.salesforce.gamification.api

/**
 * GameAPIConfig class is a utility class for holding constant values.
 */
object GameAPIConfig {

    const val HEADER_AUTHORIZATION = "Authorization"

    const val MEMBER_API_SERVICES_PATH = "/services/data/"

    const val API_VERSION_60 = "v60.0"

    const val HEADER_SFORCE_OPTION_KEY = "Sforce-Call-Options"
    const val HEADER_SFORCE_OPTION_Value = "client=gamificationMobileSdk-Android"


    /**
     * Sealed class that is used to define the Resources and its corresponding parameters.
     */
    sealed class Resource {

        class GameReward(val gameParticipantRewardId: String) : Resource()
        class Games(val participantId: String) : Resource()
    }

    /**
     * Get the request URL with appropriate end path for various resources using their corresponding parameters.
     *
     * @param instanceUrl Base URL used for all APIs.
     * @param resource Resource for which url is generated.
     * @return String The request URL to be used for API call.
     */
    fun getRequestUrl(instanceUrl: String, resource: Resource): String {
        return when (resource) {

            is Resource.GameReward -> {
                instanceUrl + MEMBER_API_SERVICES_PATH + API_VERSION_60 + "/game/gameParticipantReward/" + resource.gameParticipantRewardId + "/game-reward"
            }

            is Resource.Games -> {
                instanceUrl + MEMBER_API_SERVICES_PATH + API_VERSION_60 + "/game/participant/" + resource.participantId + "/games"
            }
        }
    }
}