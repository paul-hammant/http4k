package org.http4k.servirtium;

import kotlin.jvm.functions.Function1;
import org.http4k.client.ApacheClient;
import org.http4k.core.Uri;
import org.http4k.server.SunHttp;

import java.io.File;

public class CompatibilitySuite {

    public static void main(String[] args) {


        if (args[0].equals("record")) {

            Function1<String, InteractionStorage> diskStorage = InteractionStorage.Disk(new File("."));

            ServirtiumServer recording = ServirtiumServer.Recording("todobackend_mocha_interactions", Uri.of("foobar"), diskStorage, InteractionOptions.Defaults, 0,
                SunHttp::new, ApacheClient.create());

            recording.start();

        }
    }
}
