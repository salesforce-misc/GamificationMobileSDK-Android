# GamificationMobileSDK-Android
# Save Time and Effort With Gamification Mobile SDK for Android

Experience Gamification on your Android mobile devices and use the mobile software development kit’s (SDK) capabilities and build custom mobile applications with unique user experiences. Build the SDK for your loyalty program members to view their assigned games, play games.

**Where:** This feature is available in Lightning Experience in all editions.  
**How:** Install the Gamification Mobile SDK for Android, create a connected app, and then clone the GitHub repository.

## Android Mobile SDK for Gamification

Enhance brand engagement by providing Gamification features on your Android mobile devices. Use the Android Mobile Software Development Kit (SDK) for Gamification to build custom mobile applications with immersive member experiences. Elevate member experience and loyalty, by providing personalized offers, rewards, and checkouts on mobile devices.

### Supported Versions of Tools and Components

| Tool or Component       | Supported Version    | Installation Details                    |
|-------------------------|----------------------|-----------------------------------------|
| Android Studio          | Electric Eel         | Install from the Android Developer site |
| Android SDK and APIs    | 8.0+ (API level 26+) | Install from the Android Developer site |
| Android SDK Tools       | 8.0+                 | Install from the Android Developer site |
| Android Virtual Device  | 8.0+                 | Install from Android Studio             |
| Kotlin                  | 1.8.0+               | Installed by Android Studio             |

### Installation

To integrate Gamification Mobile SDK for Android with your Android project, add it as a package dependency.

In the Terminal, execute the following commands within your project:
`git submodule add git@github.com:loyaltysampleapp/GamificationMobileSDK-Android.git
git submodule sync
git submodule update
cd GamificationMobileSDK-Android
git submodule update --init --recursive --remote`


## Import SDK in an Android Project

Adding the above lines in gradle file will automatically download and manage the external dependencies.
Start using the SDK files by importing the appropriate SDK package.

`import com.salesforce.gamification.api.*
import com.salesforce.gamification.model.*
import com.salesforce.gamification.repository.*
import com.salesforce.gamification.utilities.*`

## GamificationRemoteRepository

The `GamificationRemoteRepository` class manages requests related to gamification using the GameAPIClient. Interact with the Salesforce Gamification API and retrieve member games and play game, in development and production environments. With GamificationRemoteRepository, you can:
- Manage authentication by creating an instance of GameAuthenticator that was injected at the time of initialization.
- Interact with the Gamification APIs, including:
  - Get Games
  - Get Game Reward

- Support both live API calls and local JSON file fetch for development mode.
- Manage asynchronous requests by using Retrofit and Kotlin coroutines.

### Usage

1. In order to use the SDK, you need to provide a valid `accessToken` to interact with Salesforce API. To do this, you are required to conform and implement [`GameAuthenticator`](./GamificationMobileSDK/src/main/java/com/salesforce/gamification/api/GameAuthenticator.kt)
2. Create an instance of 'GameAPIClient' with the necessary parameters:

```Kotlin
   val gameAuthenticator = GameAuthenticatorImpl()
   val gameClient = GameAPIClient(auth = gameAuthenticator, instanceUrl = "YourInstanceURL")
```
3. Create an instance of `GamificationRemoteRepository` with the necessary parameters:

```Kotlin
val repository = GamificationRemoteRepository(gameAuthenticator, instanceUrl, gameClient)
```

4. Call the appropriate methods to interact with the Gamification API:

```Kotlin
import com.salesforce.gamification.api.*
import com.salesforce.gamification.model.*
import com.salesforce.gamification.repository.*
import com.salesforce.gamification.utilities.*


val repository = GamificationRemoteRepository(
            auth = gameAuthenticator,
            instanceUrl = mInstanceUrl,
            gameClient = gameClient
        )         
        
// Retrieve games for the specified participant Id
repository.getGames(
                participantId = "1234567890", // The ID of the participant of the game.
                gameParticipantRewardId = "9876543210", // The ID of the participant's game reward for which details are required.
                mockResponse = false // true, if we want to check API with local json
            )

// Retrieve the details of the reward that’s provided to a participant after they play a game.
repository.getGameReward(
                gameParticipantRewardId = gameParticipantRewardId, 
                mockResponse = false // true, if we want to check API with local json
            )
```

For a detailed understanding of each method and its parameters, please refer to the comments in the provided `GamificationRemoteRepository` code.

## Contribute to the SDK

You can contribute to the development of the Gamification Mobile SDK.
1. Fork the Gamification Mobile SDK for Android [repository](https://github.com/loyaltysampleapp/GamificationMobileSDK-Android)
2. Create a branch with a descriptive name.
3. Implement your changes.
4. Test your changes.
5. Submit a pull request.

See also:
[Fork a repo](https://docs.github.com/en/get-started/quickstart/fork-a-repo)

## License

GamificationMobileSDK-Android is available under the BSD 3-Clause License.

Copyright (c) 2023, Salesforce Industries
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
