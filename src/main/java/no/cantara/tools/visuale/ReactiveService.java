package no.cantara.tools.visuale;

import io.helidon.webserver.Routing;
import io.helidon.webserver.Service;

import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;

/**
 * TODO javadoc.
 */
public class ReactiveService implements Service {
    @Inject
    private SecurityContext securityContext;

    @Override
    public void update(Routing.Rules rules) {
        rules.get("/", (req, res) -> res.send("Context: " + securityContext));
    }
}
