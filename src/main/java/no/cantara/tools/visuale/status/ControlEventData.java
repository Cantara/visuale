package no.cantara.tools.visuale.status;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ControlEventData {

    public final CompletableFuture<Void> future = new CompletableFuture<>();

    public ControlEventData() {
    }

    public void signal() {
        future.complete(null);
    }

    public void join() {
        future.join();
    }

    public void join(long timeout, TimeUnit unit) {
        future.orTimeout(timeout, unit)
                .join();
    }
}
