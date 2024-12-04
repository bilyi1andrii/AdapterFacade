import org.junit.Test;

import com.example.user.FacebookUser;
import com.example.user.TwitterUser;
import com.example.user.User;
import com.example.user.TwitterUserAdapter;
import com.example.user.FacebookUserAdapter;
import com.example.user.MessageSender;

import org.junit.Assert;

public class UserTests {

    private static final String EMAIL = "user@example.com";
    private static final String COUNTRY_CODE = "UA";
    private static final long LAST_ACTIVE_AT = System.currentTimeMillis();

    @Test
    public void testTwitterUserAdapter() {
        TwitterUser twitterUser = new TwitterUser(
                EMAIL, COUNTRY_CODE, LAST_ACTIVE_AT
        );
        User user = new TwitterUserAdapter(twitterUser);

        Assert.assertEquals("Email should match",
                EMAIL, user.getEmail());
        Assert.assertEquals("Country code should match",
                COUNTRY_CODE, user.getCountryCode());
        Assert.assertEquals("Last active time should match",
                LAST_ACTIVE_AT, user.getLastActiveAt());
    }

    @Test
    public void testFacebookUserAdapter() {
        FacebookUser facebookUser = new FacebookUser(
                EMAIL, COUNTRY_CODE, LAST_ACTIVE_AT
        );
        User user = new FacebookUserAdapter(facebookUser);

        Assert.assertEquals("Email should match",
                EMAIL, user.getEmail());
        Assert.assertEquals("Country code should match",
                COUNTRY_CODE, user.getCountryCode());
        Assert.assertEquals("Last active time should match",
                LAST_ACTIVE_AT, user.getLastActiveAt());
    }

    @Test
    public void testMessageSenderWithTwitterUser() {
        TwitterUser twitterUser = new TwitterUser(
                EMAIL, COUNTRY_CODE, LAST_ACTIVE_AT
        );
        User user = new TwitterUserAdapter(twitterUser);
        MessageSender sender = new MessageSender();

        sender.send("My mommy", user, "Ukraine");
        sender.send("Hello", user, "USA");
    }

    @Test
    public void testMessageSenderWithFacebookUser() {
        FacebookUser facebookUser = new FacebookUser(
                EMAIL, COUNTRY_CODE, LAST_ACTIVE_AT
        );
        User user = new FacebookUserAdapter(facebookUser);
        MessageSender sender = new MessageSender();

        sender.send("My mommy", user, "Ukraine");
        sender.send("Hello", user, "USA");
    }
}
