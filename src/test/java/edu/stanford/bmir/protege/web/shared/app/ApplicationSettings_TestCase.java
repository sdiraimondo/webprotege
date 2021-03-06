
package edu.stanford.bmir.protege.web.shared.app;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationSettings_TestCase {

    private ApplicationSettings applicationSettings;

    private String applicationName = "The applicationName";

    private String systemNotificationEmailAddress = "The SystemNotificationEmailAddress";

    @Mock
    private ApplicationLocation applicationLocation;

    private long maxUploadSize = 1L;

    @Before
    public void setUp()
    {
        applicationSettings = new ApplicationSettings(applicationName, systemNotificationEmailAddress, applicationLocation, maxUploadSize);
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_applicationName_IsNull() {
        new ApplicationSettings(null, systemNotificationEmailAddress, applicationLocation, maxUploadSize);
    }

    @Test
    public void shouldReturnSupplied_applicationName() {
        assertThat(applicationSettings.getApplicationName(), is(this.applicationName));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_systemNotificationEmailAddress_IsNull() {
        new ApplicationSettings(applicationName, null, applicationLocation, maxUploadSize);
    }

    @Test
    public void shouldReturnSupplied_systemNotificationEmailAddress() {
        assertThat(applicationSettings.getSystemNotificationEmailAddress(), is(this.systemNotificationEmailAddress));
    }

    @SuppressWarnings("ConstantConditions")
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerExceptionIf_applicationLocation_IsNull() {
        new ApplicationSettings(applicationName, systemNotificationEmailAddress, null, maxUploadSize);
    }

    @Test
    public void shouldReturnSupplied_applicationLocation() {
        assertThat(applicationSettings.getApplicationLocation(), is(this.applicationLocation));
    }

    @Test
    public void shouldReturnSupplied_maxUploadSize() {
        assertThat(applicationSettings.getMaxUploadSize(), is(this.maxUploadSize));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(applicationSettings, is(applicationSettings));
    }

    @Test
    @SuppressWarnings("ObjectEqualsNull")
    public void shouldNotBeEqualToNull() {
        assertThat(applicationSettings.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(applicationSettings, is(new ApplicationSettings(applicationName, systemNotificationEmailAddress, applicationLocation, maxUploadSize)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_applicationName() {
        assertThat(applicationSettings, is(Matchers.not(new ApplicationSettings("String-59344631-c3b4-4d9b-9091-e4cf31570afe", systemNotificationEmailAddress, applicationLocation, maxUploadSize))));
    }
    
    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_systemNotificationEmailAddress() {
        assertThat(applicationSettings, is(Matchers.not(new ApplicationSettings(applicationName, "String-05b955de-a3d7-4444-bef7-032fd22c0bb1", applicationLocation, maxUploadSize))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_applicationLocation() {
        assertThat(applicationSettings, is(Matchers.not(new ApplicationSettings(applicationName, systemNotificationEmailAddress, Mockito.mock(ApplicationLocation.class), maxUploadSize))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_maxUploadSize() {
        assertThat(applicationSettings, is(Matchers.not(new ApplicationSettings(applicationName, systemNotificationEmailAddress, applicationLocation, 2L))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(applicationSettings.hashCode(), is(new ApplicationSettings(applicationName, systemNotificationEmailAddress, applicationLocation, maxUploadSize).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(applicationSettings.toString(), Matchers.startsWith("ApplicationSettings"));
    }

}
