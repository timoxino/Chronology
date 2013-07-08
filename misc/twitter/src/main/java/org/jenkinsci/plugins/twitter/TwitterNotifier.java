package org.jenkinsci.plugins.twitter;

import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.BuildListener;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Notifier;
import hudson.tasks.Publisher;
import org.kohsuke.stapler.DataBoundConstructor;

import java.io.IOException;

/**
 * @author Tsimafei Shchytkavets
 *         Creation Date: 6/25/13
 */
public class TwitterNotifier extends Notifier
{
    public BuildStepMonitor getRequiredMonitorService()
    {
        return BuildStepMonitor.BUILD;
    }

    @DataBoundConstructor
    public TwitterNotifier()
    {
    }

    @Override
    public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener) throws InterruptedException, IOException
    {
        Helpers.publishMessage(TwitterJobProperty.CONFIG.getConsumerKey(),
                TwitterJobProperty.CONFIG.getConsumerSecret(),
                TwitterJobProperty.CONFIG.getAccessToken(),
                TwitterJobProperty.CONFIG.getAccessTokenSecret(), "I'm done build " + build.getDisplayName() + ".");
        return true;
    }

    @Extension
    public static class Descriptor extends BuildStepDescriptor<Publisher>
    {

        @Override
        public boolean isApplicable(Class<? extends AbstractProject> jobType)
        {
            return true;
        }

        @Override
        public String getDisplayName()
        {
            return "Twitter Notifier";
        }
    }
}
