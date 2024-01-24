/*
 * Copyright (c) 2023, Salesforce, Inc.
 * All rights reserved.
 * SPDX-License-Identifier: BSD-3-Clause
 * For full license text, see the LICENSE file in the repo root or https://opensource.org/licenses/BSD-3-Clause
 */

package com.salesforce.gamification

import com.salesforce.gamification.api.GameAPIClient
import junit.framework.TestCase.assertNotNull
import org.junit.Test

class GameClientTest {

    companion object {
        const val INSTANCE_URL = "https://instanceUrl"
    }

    @Test
    fun testGameClient() {
        val gameClient = GameAPIClient(MockAuthenticator, INSTANCE_URL)
        assertNotNull(gameClient.getNetworkClient())
    }
}