package no.cantara.tools.visuale.healthchecker;

import no.cantara.base.command.BaseHttpGetHystrixCommand;

import java.net.URI;

public class CommandGetHealthJson extends BaseHttpGetHystrixCommand<String> {

    URI uri;

    public CommandGetHealthJson(URI uri) {

        super(uri, "hystrixGroupKey", 3000);
        this.uri = uri;
    }


    @Override
    protected String getTargetPath() {
        return "";//uri.toString();
    }
}
