package com.tmdb.store.base

typealias Reducer<S, Env> = (state: S, action: Action) -> ReducedResult<S, Env>

typealias ReducedResult<S, Env> = Pair<S, Effect<Env>?>
