package github.informramiz.asteriodradar.dependencyinjection.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Ramiz Raja on 18/04/2020
 */

// annotating with component tells Dagger that this graph needs to be generated and since
// this is an application level component so we make it scoped to application (@Singleton)
@Singleton
@Component
interface AppComponent {
    // we need context for most of the dependencies and we do that
    // by using custom component factory
    @Component.Factory
    interface Factory {
        // using @BindsInstance with a parameter tells dagger to make it available in the
        // graph of the relevant component. Dagger will generate the implementation for this
        // method at compile time
        fun create(@BindsInstance context: Context): AppComponent
    }
}