package org.jenkinsci.plugins.twitter;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.model.JobProperty;
import hudson.model.JobPropertyDescriptor;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.StaplerRequest;

/**
 * @author Tsimafei Shchytkavets
 *         Creation Date: 6/25/13
 */
public class TwitterJobProperty extends JobProperty<AbstractProject<?,?>>
{
    @Extension
    public static final Descriptor CONFIG = new Descriptor();

    public static class Descriptor extends JobPropertyDescriptor
    {
        private String consumerSecret;
        private String consumerKey;
        private String accessToken;
        private String accessTokenSecret;

        public Descriptor()
        {
            super(TwitterJobProperty.class);
            load();
        }

        @Override
        public boolean configure(StaplerRequest req, JSONObject json) throws FormException
        {
            req.bindJSON(this, json);
            save();
            return super.configure(req, json);    //To change body of overridden methods use File | Settings | File Templates.
        }

        @Override
        public String getDisplayName()
        {
            return "Twitter Job Property";
        }

        public String getConsumerSecret()
        {
            return consumerSecret;
        }

        public void setConsumerSecret(String consumerSecret)
        {
            this.consumerSecret = consumerSecret;
        }

        public String getConsumerKey()
        {
            return consumerKey;
        }

        public void setConsumerKey(String consumerKey)
        {
            this.consumerKey = consumerKey;
        }

        public String getAccessToken()
        {
            return accessToken;
        }

        public void setAccessToken(String accessToken)
        {
            this.accessToken = accessToken;
        }

        public String getAccessTokenSecret()
        {
            return accessTokenSecret;
        }

        public void setAccessTokenSecret(String accessTokenSecret)
        {
            this.accessTokenSecret = accessTokenSecret;
        }
    }
}
