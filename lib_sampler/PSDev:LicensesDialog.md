# [PSDev/LicensesDialog](https://github.com/PSDev/LicensesDialog)

## build.gradle

```
compile('de.psdev.licensesdialog:licensesdialog:1.8.0')
```

## use case 

```java 
 public void onSingleClick(final View view) {
        final String name = "LicensesDialog";
        final String url = "http://psdev.de";
        final String copyright = "Copyright 2013 Philip Schiffer <admin@psdev.de>";
        final License license = new ApacheSoftwareLicense20();
        final Notice notice = new Notice(name, url, copyright, license);
        new LicensesDialog.Builder(this)
            .setNotices(notice)
            .build()
            .show();
    }

    public void onMultipleClick(final View view) {
        new LicensesDialog.Builder(this)
            .setNotices(R.raw.notices)
            .build()
            .show();
    }

    public void onMultipleIncludeOwnClick(final View view) {
        new LicensesDialog.Builder(this)
            .setNotices(R.raw.notices)
            .setIncludeOwnLicense(true)
            .build()
            .show();
    }

    public void onMultipleProgrammaticClick(final View view) {
        final Notices notices = new Notices();
        notices.addNotice(new Notice("Test 1", "http://example.org", "Example Person", new ApacheSoftwareLicense20()));
        notices.addNotice(new Notice("Test 2", "http://example.org", "Example Person 2", new GnuLesserGeneralPublicLicense21()));

        new LicensesDialog.Builder(this)
            .setNotices(notices)
            .setIncludeOwnLicense(true)
            .build()
            .show();
    }

    public void onSingleFragmentClick(final View view) {
        final String name = "LicensesDialog";
        final String url = "http://psdev.de";
        final String copyright = "Copyright 2013 Philip Schiffer <admin@psdev.de>";
        final License license = new ApacheSoftwareLicense20();
        final Notice notice = new Notice(name, url, copyright, license);

        final LicensesDialogFragment fragment = new LicensesDialogFragment.Builder(this)
            .setNotice(notice)
            .setIncludeOwnLicense(false)
            .build();

        fragment.show(getSupportFragmentManager(), null);
    }

    public void onMultipleFragmentClick(final View view) throws Exception {
        final LicensesDialogFragment fragment = new LicensesDialogFragment.Builder(this)
            .setNotices(R.raw.notices)
            .build();

        fragment.show(getSupportFragmentManager(), null);
    }

    public void onMultipleIncludeOwnFragmentClick(final View view) throws Exception {
        final LicensesDialogFragment fragment = new LicensesDialogFragment.Builder(this)
            .setNotices(R.raw.notices)
            .setShowFullLicenseText(false)
            .setIncludeOwnLicense(true)
            .build();

        fragment.show(getSupportFragmentManager(), null);
    }

    public void onMultipleProgrammaticFragmentClick(final View view) {
        final Notices notices = new Notices();
        notices.addNotice(new Notice("Test 1", "http://example.org", "Example Person", new ApacheSoftwareLicense20()));
        notices.addNotice(new Notice("Test 2", "http://example.org", "Example Person 2", new GnuLesserGeneralPublicLicense21()));

        final LicensesDialogFragment fragment = new LicensesDialogFragment.Builder(this)
            .setNotices(notices)
            .setShowFullLicenseText(false)
            .setIncludeOwnLicense(true)
            .build();

        fragment.show(getSupportFragmentManager(), null);
    }

    public void onCustomThemeClick(final View view) {
        new LicensesDialog.Builder(this)
            .setNotices(R.raw.notices)
            .setIncludeOwnLicense(true)
            .setThemeResourceId(R.style.custom_theme)
            .setDividerColorId(R.color.custom_divider_color)
            .build()
            .show();
    }

    public void onCustomThemeFragmentClick(final View view) throws Exception {
        final LicensesDialogFragment fragment = new LicensesDialogFragment.Builder(this)
            .setNotices(R.raw.notices)
            .setShowFullLicenseText(false)
            .setIncludeOwnLicense(true)
            .setThemeResourceId(R.style.custom_theme)
            .setDividerColorRes(R.color.custom_divider_color)
            .build();

        fragment.show(getSupportFragmentManager(), null);
    }
```


raw/notices.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<notices>
    <notice>
        <name>ActionBarSherlock</name>
        <url>http://actionbarsherlock.com/</url>
        <copyright>Copyright 2012 Jake Wharton</copyright>
        <license>Apache Software License 2.0</license>
    </notice>
    <notice>
        <name>RoboGuice 2.0</name>
        <url>http://roboguice.org</url>
        <copyright/>
        <license>Apache Software License 2.0</license>
    </notice>
    <notice>
        <name>Application Crash Reporting for Android (ACRA)</name>
        <url>http://acra.ch/</url>
        <copyright>Copyright 2010 Emmanuel Astier &amp; Kevin Gaudin</copyright>
        <license>Apache Software License 2.0</license>
    </notice>
    <notice>
        <name>Android ViewPagerIndicator</name>
        <url>http://viewpagerindicator.com/</url>
        <copyright>Copyright (C) 2011 The Android Open Source Project&lt;br/&gt;Copyright (C) 2012 Jake Wharton</copyright>
        <license>Apache Software License 2.0</license>
    </notice>
    <notice>
        <name>Nine Old Androids</name>
        <url>http://nineoldandroids.com/</url>
        <copyright>Copyright (C) 2010 The Android Open Source Project</copyright>
        <license>Apache Software License 2.0</license>
    </notice>
    <notice>
        <name>Crouton</name>
        <url>https://github.com/keyboardsurfer/Crouton</url>
        <copyright>Copyright 2012 Benjamin Weiss&lt;br/&gt;Copyright 2012 Neofonie Mobile GmbH</copyright>
        <license>Apache Software License 2.0</license>
    </notice>
    <notice>
        <name>Jackson JSON-processor</name>
        <url>http://jackson.codehaus.org/</url>
        <copyright/>
        <license>Apache Software License 2.0</license>
    </notice>
    <notice>
        <name>OrmLite</name>
        <url>http://ormlite.com/</url>
        <copyright>Copyright Gray Watson</copyright>
        <license>ISC License</license>
    </notice>
    <notice>
        <name>Apache Commons IO</name>
        <url>http://commons.apache.org/io/</url>
        <copyright>Copyright 2002-2012 The Apache Software Foundation</copyright>
        <license>Apache Software License 2.0</license>
    </notice>
    <notice>
        <name>Apache Commons Lang</name>
        <url>http://commons.apache.org/lang/</url>
        <copyright>Copyright 2002-2011 The Apache Software Foundation</copyright>
        <license>Apache Software License 2.0</license>
    </notice>
    <notice>
        <name>Joda Time</name>
        <url>http://joda-time.sourceforge.net/</url>
        <copyright>Copyright 2001-2005 Stephen Colebourne</copyright>
        <license>Apache Software License 2.0</license>
    </notice>
    <notice>
        <name>StickyListHeaders</name>
        <url>https://github.com/emilsjolander/StickyListHeaders</url>
        <copyright>Copyright 2012 Emil Sjölander</copyright>
        <license>Apache Software License 2.0</license>
    </notice>
</notices>

```