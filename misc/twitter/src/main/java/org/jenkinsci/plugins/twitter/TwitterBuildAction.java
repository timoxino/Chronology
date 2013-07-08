package org.jenkinsci.plugins.twitter;

import hudson.model.AbstractBuild;
import hudson.model.Action;
import twitter4j.Status;

import java.util.List;

/**
 * @author Tsimafei Shchytkavets
 *         Creation Date: 6/25/13
 */
public class TwitterBuildAction implements Action
{
    private final List<Status> statuses;
    private final AbstractBuild<?, ?> build;

    public TwitterBuildAction(List<Status> statuses, AbstractBuild<?, ?> build)
    {
        this.statuses = statuses;
        this.build = build;
    }
    public List<Status> getStatuses()
    {
        return statuses;
    }

    public AbstractBuild<?, ?> getBuild()
    {
        return build;
    }

    public String getIconFileName()
    {
        return "graph.gif";
    }

    public String getDisplayName()
    {
        return "Timeline";
    }

    public String getUrlName()
    {
        return "timeline";
    }
}
