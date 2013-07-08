package org.jenkinsci.plugins.twitter;

import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.BuildListener;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Builder;
import org.kohsuke.stapler.DataBoundConstructor;

import java.io.IOException;

/**
 * @author Tsimafei Shchytkavets
 *         Creation Date: 6/25/13
 */
public class TwitterBuilder extends Builder
{
    @DataBoundConstructor
    public TwitterBuilder()
    {
    }

    @Override
    public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener) throws InterruptedException, IOException
    {
        build.addAction(new TwitterBuildAction(Helpers.getHomeTimeline(
                TwitterJobProperty.CONFIG.getConsumerKey(),
                TwitterJobProperty.CONFIG.getConsumerSecret(),
                TwitterJobProperty.CONFIG.getAccessToken(),
                TwitterJobProperty.CONFIG.getAccessTokenSecret()), build));
        return true;
    }

    @Extension
    public static class Descriptor extends BuildStepDescriptor<Builder>
    {

        @Override
        public boolean isApplicable(Class<? extends AbstractProject> jobType)
        {
            return true;
        }

        @Override
        public String getDisplayName()
        {
            return "Twitter Builder";
        }
    }
}
