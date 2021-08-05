package com.raywenderlich.android.busso.di.scopes

import dagger.hilt.migration.AliasOf
import javax.inject.Scope
import javax.inject.Singleton

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@AliasOf(Singleton::class) // HERE
annotation class ApplicationScoped