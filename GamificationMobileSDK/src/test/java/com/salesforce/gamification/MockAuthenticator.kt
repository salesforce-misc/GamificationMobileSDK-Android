/*
 * Copyright (c) 2023, Salesforce, Inc.
 * All rights reserved.
 * SPDX-License-Identifier: BSD-3-Clause
 * For full license text, see the LICENSE file in the repo root or https://opensource.org/licenses/BSD-3-Clause
 */

package com.salesforce.gamification

import com.salesforce.gamification.api.GameAuthenticator


object MockAuthenticator : GameAuthenticator {
    override fun getAccessToken(): String? {
        return "AccessToken1234"
    }

    override suspend fun grantAccessToken(): String? {
        return "AccessToken1234"
    }
}