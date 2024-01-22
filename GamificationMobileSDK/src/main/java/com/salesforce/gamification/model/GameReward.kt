/*
 * Copyright (c) 2023, Salesforce, Inc.
 * All rights reserved.
 * SPDX-License-Identifier: BSD-3-Clause
 * For full license text, see the LICENSE file in the repo root or https://opensource.org/licenses/BSD-3-Clause
 */

package com.salesforce.gamification.model

import com.google.gson.annotations.SerializedName

/**
 * GameReward data class holds the parameters of game rewards of a [GameDefinition]
 */
data class GameReward(
    @SerializedName("color")
    val segColor: String?,

    @SerializedName("description")
    val description: String?,

    @SerializedName("expirationDate")
    val expirationDate: String?,

    @SerializedName("imageUrl")
    val imageUrl: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("rewardDefinitionId")
    val rewardDefinitionId: String?,

    @SerializedName("rewardType")
    val rewardType: String?,

    @SerializedName("rewardValue")
    val rewardValue: String?,

    @SerializedName("gameRewardId")
    val gameRewardId: String?,
)