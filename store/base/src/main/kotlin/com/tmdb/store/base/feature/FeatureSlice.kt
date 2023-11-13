package com.tmdb.store.base.feature

/***
 * Feature Slice required for store creation
 */
fun interface FeatureSlice<G, Env, F> {
    fun getReducer(): FeatureReducer<G, Env, F>
}
