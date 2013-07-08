package org.jenkinsci.plugins.twitter;

import antlr.ANTLRException;
import hudson.Extension;
import hudson.model.Cause;
import hudson.model.Item;
import hudson.model.Project;
import hudson.triggers.Trigger;
import hudson.triggers.TriggerDescriptor;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * @author Tsimafei Shchytkavets
 *         Creation Date: 6/25/13
 */
public class TwitterTrigger extends Trigger<Project>
{
    @DataBoundConstructor
    public TwitterTrigger(String spec) throws ANTLRException
    {
        super(spec);
    }

    @Override
    public void run()
    {
        if(Helpers.isMentioned(
                TwitterJobProperty.CONFIG.getConsumerKey(),
                TwitterJobProperty.CONFIG.getConsumerSecret(),
                TwitterJobProperty.CONFIG.getAccessToken(),
                TwitterJobProperty.CONFIG.getAccessTokenSecret()
        ))
        {
            job.scheduleBuild(new Cause()
            {
                @Override
                public String getShortDescription()
                {
                    return "found a mention";
                }
            });
        }
    }

    @Extension
    public static class Descriptor extends TriggerDescriptor
    {
        @Override
        public boolean isApplicable(Item item)
        {
            return true;
        }

        @Override
        public String getDisplayName()
        {
            return "Twitter trigger";
        }

    }
}
