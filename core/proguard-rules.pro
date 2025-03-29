# Please add these rules to your existing keep rules in order to suppress warnings.
# This is generated automatically by the Android Gradle plugin.
-dontwarn com.example.dicodingevents.core.data.Resource$Error
-dontwarn com.example.dicodingevents.core.data.Resource$Loading
-dontwarn com.example.dicodingevents.core.data.Resource$Success
-dontwarn com.example.dicodingevents.core.data.Resource
-dontwarn com.example.dicodingevents.core.di.CoreModuleKt
-dontwarn com.example.dicodingevents.core.domain.model.Event
-dontwarn com.example.dicodingevents.core.domain.repository.IEventRepository
-dontwarn com.example.dicodingevents.core.domain.usecase.EventInteractor
-dontwarn com.example.dicodingevents.core.domain.usecase.EventUseCase
-dontwarn com.example.dicodingevents.core.ui.EventAdapter

# Keep semua kelas dalam package core.data
-keep class com.example.dicodingevents.core.data.** { *; }

# Keep semua kelas dalam package core.domain
-keep class com.example.dicodingevents.core.domain.** { *; }

# Keep semua kelas dalam package core.ui
-keep class com.example.dicodingevents.core.ui.** { *; }

# Keep Koin dependency injection
-keep class com.example.dicodingevents.core.di.CoreModuleKt { *; }

# Keep semua model dan entity agar tidak dihapus oleh R8
-keep class com.example.dicodingevents.core.domain.model.** { *; }
-keep class com.example.dicodingevents.core.data.source.local.entity.** { *; }

# Keep interface repository
-keep class com.example.dicodingevents.core.domain.repository.** { *; }

# Keep use cases agar tidak dihapus
-keep class com.example.dicodingevents.core.domain.usecase.** { *; }

# Keep adapter untuk RecyclerView
-keep class com.example.dicodingevents.core.ui.EventAdapter { *; }

-keep class java.time.** { *; }
-keep class java.util.** { *; }

-dontwarn java.lang.invoke.StringConcatFactory
-dontwarn java.lang.invoke.StringConcatFactory
