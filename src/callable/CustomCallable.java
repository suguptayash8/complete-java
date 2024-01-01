package callable;

import java.util.concurrent.Callable;

public interface CustomCallable<K> {
    K call();
}
