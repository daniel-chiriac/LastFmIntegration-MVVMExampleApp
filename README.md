# LastFmIntegration-MVVMExampleApp
Android app integrating with last.fm api. It allows searching for artists, songs and albums.

**Build the app**
You will need to create a file named "lastfmapi.properties" in the root directory of the project.
This must contain the api key for last.fm and the base api url of last.fm. Example:

```
api_key="ajgnlksjngklsnfksln"
api_url="http://ws.audioscrobbler.com"
```

To get an api key, [go to last.fm's website](https://www.last.fm/api/account/create).

Use the api_url from the example file.

**Install without building**

To just run the app, install the apk in the release directory.

**TODO**
  - Add pagination support - currently shows just the first 50 items in a search;

**About the project**

This is my first app I wrote using android databinding and the MVVM pattern. 

_The first impressions about MVVM pattern with data binding_

It feels I ended up with a cleaner up than if I had used MVP. The bouncing between view model and the view  makes it feel like I am writting more code than usually. This happens when the view observes the changes in the view model, then it commands back the view model to do something based on view model's changes. Initially it could be tempting to just do the work in the view itself, but then you won't end up with a clean, modular app that's easy to test. In conclusion, I'm really liking the MVVM pattern with data binding in android so far.

_Issues and bugs_

  - LiveData not behaving as expected (or maybe I'm missunderstanding something)
  
  In the [documentation about observing live data](https://developer.android.com/topic/libraries/architecture/livedata.html#observe_livedata_objects) it states: "Furthermore, if the observer changes from inactive to active a second time, it only receives an update if the value has changed since the last time it became active." However in my app I get updates resent everytime on screen rotation even though the data hasn't changed. It could be just something I overlooked though and should investigate further. 

  - Dagger and Kotlin
  
  Initially I planned to write the fragments for albums, artists and tracks in Kotlin. And I started with the albums fragment written in Kotlin. Then I came across an issue related to wild cards when trying to create view model factories. I couldn't get dagger to inject dependencies, so I had to get rid of the Kotlin fragment to speed up app writting. 
  The error I was getting was
  ```
  error: [dagger.android.AndroidInjector.inject(T)] java.util.Map<java.lang.Class<? extends android.arch.lifecycle.ViewModel>,? extends javax.inject.Provider> cannot be provided without an @Provides-annotated method.
  ```
  The solution is explained on [this blog](https://brightinventions.pl/blog/injectable-android-viewmodels/). Things would have been easier if I had started the app in Kotlin.
  
_Thanks_

For the architecture of the app it helped having a look and using some code and patterns from the following projects:

[google samples todoapp](https://github.com/googlesamples/android-architecture/tree/dev-todo-mvvm-live/todoapp/app/src/main/java/com/example/android/architecture/blueprints/todoapp)
[Mindork Open soure app on mvvm architecture](https://github.com/MindorksOpenSource/android-mvvm-architecture)
  

