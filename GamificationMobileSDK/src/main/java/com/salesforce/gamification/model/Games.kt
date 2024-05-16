/*
 * Copyright (c) 2023, Salesforce, Inc.
 * All rights reserved.
 * SPDX-License-Identifier: BSD-3-Clause
 * For full license text, see the LICENSE file in the repo root or https://opensource.org/licenses/BSD-3-Clause
 */

package com.salesforce.gamification.model

import com.google.gson.annotations.SerializedName

/**
 * Games is a data class that holds the response parameters of Get Games API.
 */
data class Games(

    @SerializedName("errorMessage")
    val errorMessage: String?,

    @SerializedName("gameDefinitions")
    val gameDefinitions: List<GameDefinition>,

    @SerializedName("status")
    val status: Boolean
)

data class GameDefinition(

    @SerializedName("description")
    val description: String?,

    @SerializedName("gameDefinitionId")
    val gameDefinitionId: String?,

    @SerializedName("endDate")
    val endDate: String?,

    @SerializedName("gameRewards")
    val gameRewards: List<GameReward>,

    @SerializedName("participantGameRewards")
    val participantGameRewards: List<ParticipantGameReward>,

    @SerializedName("name")
    val name: String?,

    @SerializedName("startDate")
    val startDate: String?,

    @SerializedName("status")
    val status: String?,

    @SerializedName("timeoutDuration")
    val timeoutDuration: Int?,

    @SerializedName("type")
    val type: String
)