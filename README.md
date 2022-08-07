# stock
A stock market app to browse a list of active or delisted US stocks and ETFs, this project showcase clean architectural approache to developing Android apps. 

# Technologies  🖥

- User Interface built with Jetpack Compose
A single-activity architecture, using Navigation Compose.
A presentation layer that contains a Compose screen (View) and a ViewModel per screen (or feature).
Reactive UIs using Flow and coroutines for asynchronous operations.
A data layer with a repository and two data sources (local using Room and a fake remote).
Two product flavors, mock and prod, to ease development and testing.
A collection of unit, integration and e2e tests, including "shared" tests that can be run on emulator/device or Robolectric.
Dependency injection using Hilt.
Variations
This project hosts each sample app in separate repository branches. For more information, see the README.md file in each branch.

Stable samples - Kotlin
Sample	Description
main	This branch
service-locator	A simple setup that removes Hilt in favor of a service locator
livedata	Uses LiveData instead of StateFlow as the data stream solution
usecases	Adds a new domain layer that uses UseCases for business logic (not using Compose yet)
views	Uses Views instead of Jetpack Compose to render UI elements on the screen
views-hilt	Uses Views and Hilt instead together
Why a to-do app?
A demo illustraating the UI of the app

The app in this project aims to be simple enough that you can understand it quickly, but complex enough to showcase difficult design decisions and testing scenarios. For more information, see the app's specification.
