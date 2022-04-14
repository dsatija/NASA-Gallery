# Nasa Gallery

Nasa Gallery is an android app that allows a user to search for images using The app
utilizes [NASA API](https://images.nasa.gov/).

# User Stories

The following functionality is completed:

- [**DONE**] User can  **search for images**  by specifying a query and launching a search. Search
  displays a list of image results from the NASA Api.
- [**DONE**]  Each search result should display the image and the title.
- [**DONE**]   Tapping on a search result should display a details screen including the image,
  title, description, and date it was created.
- [**DONE**] Pagination

## Video walk through

-- Gifs are under screenshots folder.

## Libraries used

- [Data Binding](https://developer.android.com/topic/libraries/data-binding/)  - Declaratively bind
  observable data to UI elements.
- [Lifecycles](https://developer.android.com/topic/libraries/architecture/lifecycle)  - Create a UI
  that automatically responds to lifecycle events.
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)  - Build data
  objects that notify views when the underlying database changes.
- [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/)  - Handle
  everything needed for in-app navigation.
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)  - Store
  UI-related data that isn't destroyed on app rotations. Easily schedule asynchronous tasks for
  optimal execution.
- [Paging 3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) - Load
  and display pages of data from a larger dataset from local storage or over network
- [Retrofit](https://square.github.io/retrofit/)  - HTTP Calls to Rest Api
- [GSON](https://github.com/google/gson) - Convert Java Objects into their JSON representation and
  vice versa.
- [Glide](https://bumptech.github.io/glide/)  for image loading
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android):
  for  [dependency injection](https://developer.android.com/training/dependency-injection)

## Architecture

The app follows mvvm architecture pattern as below :

![Architecture](https://imagizer.imageshack.com/v2/640x480q90/923/COKb9j.png)

## How to build

Two ways:

- Import the project and build in android studio.
- Download the apk from this google
  drive [link](https://drive.google.com/file/d/1IK4UtUns1v5epigwL7scnR526ynt_hEL/view?usp=sharing)
- Note the apk loads the first page with default search query : "mars".
- If there is no network, the app shows a loading progress bar and then gives the option to retry
  after some time.
- Texts are shown only after the image is loaded (on Details screen).
