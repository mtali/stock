# stock
A stock market app to browse a list of active or delisted US stocks and ETFs, this project showcase clean architectural approache to developing Android apps. 

## Technologies 🖥

- User Interface built with Jetpack Compose
- A [single-activity](https://www.youtube.com/watch?v=2k8x8V77CrU) architecture, using Navigation Compose.
- A presentation layer that contains a Compose screen.
- Reactive UIs using Flow and coroutines for asynchronous operations.
- A data layer with a repository and two data sources (local using Room and a remote using Retrofit).
- Dependency injection using [Hilt](https://developer.android.com/training/dependency-injection/hilt-android).

## Features
- List of company listings using [alphavantage API](https://www.alphavantage.co/)
- Ability to search company listings
- Offline caching 
- Show company details i.e. Graph (Custom Composable). See attached images


## Architecture
The Stock app follows the [official architecture guidance](https://developer.android.com/topic/architecture).
Clean architectire + Repository Pattern

<img src="docs/CleanArchitecture.png" width="25%" height="25%"/>


## Screenshots

<p align="center">
<img src="docs/Home.png" width="25%" height="25%"/>

<img src="docs/Detail.png" width="25%" height="25%"/>

</p>



## Language
Kotlin 


## License

```
Copyright 2020 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

