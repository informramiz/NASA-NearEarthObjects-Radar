# NASA-NearEarthObjects-Radar
Asteroid Radar is an app to view the asteroids detected by NASA that pass near Earth, you can view all the detected asteroids in a period of time, their data (Size, velocity, distance to Earth) and if they are potentially hazardous. The app uses [NASA Open API](https://api.nasa.gov/) to fetch the data.

![demo](demo/demo.gif)

## Functionality Details

- The app displays a list of asteroids in the Main Screen by using a `RecyclerView`, when tapping an item the app opens Details screen.
- The asteroids displayed in the screens are downloaded from the `NASA API`
- The NASA image of the day is displayed in the Main Screen (if available)
- The app **can save the downloaded asteroids in the database** and then display them also from the database. The app filters asteroids from the past
- The app downloads the next 7 days asteroids and saves them in the database once a day using **workManager with requirements of internet connection and device plugged in**. The app can display saved asteroids from the database even if internet connection is not available
- The app **works correctly in talk back mode**, it provides descriptions for all the texts and images: Asteroid images in details screen and image of the day. It also provides description for the details screen help button


## Code Details

The app follows **MVVM design pattern** and makes use of following libraries.


1. Dagger2
2. Assisted Inject
3. Retrofit2
4. Room
5. Lifecycle Components
6. Android Navigation Component
7. Kotlin Coroutines
8. WorkManager
9. Data Binding
9. Glide
10. Moshi
11. Timber
12. ConstraintLayout
13. RecyclerView




