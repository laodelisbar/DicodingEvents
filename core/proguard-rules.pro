# Menjaga semua class dalam package data
-keep class com.example.dicodingevents.core.data.** { *; }

# Menjaga semua class dalam package domain
-keep class com.example.dicodingevents.core.domain.** { *; }

# Menjaga semua class dalam package UI (adapter, viewmodel, dll.)
-keep class com.example.dicodingevents.core.ui.** { *; }

# Menjaga semua class dalam package dependency injection (DI)
-keep class com.example.dicodingevents.core.di.** { *; }

# Menjaga semua class dalam package dependency injection (DI)
-keep class com.example.dicodingevents.core.utils.** { *; }

# Menjaga semua interface repository dan use case
-keep class com.example.dicodingevents.core.domain.repository.** { *; }
-keep class com.example.dicodingevents.core.domain.usecase.** { *; }
