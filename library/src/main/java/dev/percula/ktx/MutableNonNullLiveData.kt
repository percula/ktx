package dev.percula.ktx

/**
 * A MutableLiveData that enforces the generic type's nullability
 */
class MutableNonNullLiveData<T>(initialValue: T) : NonNullLiveData<T>(initialValue) {
    public override fun setValue(value: T) {
        super.setValue(value)
    }
}