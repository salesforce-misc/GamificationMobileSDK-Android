/*
 * Copyright (c) 2023, Salesforce, Inc.
 * All rights reserved.
 * SPDX-License-Identifier: BSD-3-Clause
 * For full license text, see the LICENSE file in the repo root or https://opensource.org/licenses/BSD-3-Clause
 */

package com.salesforce.gamification.model

import com.google.gson.annotations.SerializedName

/**
 * ParticipantGameReward is a data class that holds parameters of reward corresponding to gameParticipantRewardId.
 */
data class ParticipantGameReward(
    @SerializedName("gameRewardId")
    val gameRewardId: String?,

    @SerializedName("gameParticipantRewardId")
    val gameParticipantRewardId: String?,

    @SerializedName("sourceActivityId")
    val sourceActivityId: String?,

    @SerializedName("expirationDate")
    val expirationDate: String?,

    @SerializedName("issuedRewardReference")
    val issuedRewardReference: String?,

    @SerializedName("status")
    val status: String?,
)