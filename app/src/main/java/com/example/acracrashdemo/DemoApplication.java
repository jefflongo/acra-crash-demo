package com.example.acracrashdemo;

import android.app.Application;
import android.content.Context;

import org.acra.ACRA;
import org.acra.config.CoreConfigurationBuilder;
import org.acra.config.MailSenderConfigurationBuilder;
import org.acra.config.NotificationConfigurationBuilder;
import org.acra.data.StringFormat;

public class DemoApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        ACRA.init(this, new CoreConfigurationBuilder()
                .withBuildConfigClass(BuildConfig.class)
                .withReportFormat(StringFormat.JSON)
                .withLogcatArguments("-t", "100", "-v", "long")
                .withPluginConfigurations(
                        new NotificationConfigurationBuilder()
                                .withTitle("title")
                                .withText("text")
                                .withChannelName(getString(R.string.app_name))
                                .withSendOnClick(true)
                                .build(),
                        new MailSenderConfigurationBuilder()
                                .withMailTo("dummy@dummy.com")
                                .withReportAsFile(true)
                                .withReportFileName("filename")
                                .withSubject("Subject")
                                .withBody("body")
                                .build()
                )
        );
    }
}
