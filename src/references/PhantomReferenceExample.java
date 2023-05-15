package references;

/**
 *
 * [{
 *     name:
 *     department:
 *     rollNumber:
 *     subjects:[]
 * }]
 * In Java, phantom references are used when we need to track the object's finalization, but without preventing it from being garbage collected. A phantom reference allows us to get notified when the object is about to be finalized, without actually keeping a strong reference to the object.
 *
 * Here's an example of when we might use a phantom reference:
 *
 * Suppose we have a cache of large objects that are expensive to create, and we want to free up memory when the objects are no longer needed. We can use a WeakHashMap to hold the cached objects, where the keys are weak references to the objects. When an object is no longer strongly reachable, it will be garbage collected, and the corresponding weak reference will be removed from the WeakHashMap.
 */
import java.lang.ref.*;
import java.util.WeakHashMap;

public class PhantomReferenceExample {
    private WeakHashMap<Object, LargeObject> cache = new WeakHashMap<>();
    private ReferenceQueue<LargeObject> queue = new ReferenceQueue<>();

    public void put(Object key, LargeObject value) {
        cache.put(key, value);
        PhantomReference<LargeObject> ref = new PhantomReference<>(value, queue);
    }

    public void cleanup() {
        Reference<? extends LargeObject> ref;
        while ((ref = queue.poll()) != null) {
            LargeObject obj = ref.get();
            if (obj != null) {
                // Perform cleanup action on obj
                // ...
            }
        }
    }
}

class LargeObject {

}