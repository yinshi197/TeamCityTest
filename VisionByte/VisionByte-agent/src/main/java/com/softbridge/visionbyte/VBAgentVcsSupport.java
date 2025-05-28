package com.softbridge.visionbyte;

import jetbrains.buildServer.agent.AgentRunningBuild;
import jetbrains.buildServer.agent.vcs.AgentVcsSupport;
import jetbrains.buildServer.agent.vcs.UpdateByCheckoutRules2;
import jetbrains.buildServer.agent.vcs.UpdatePolicy;
import jetbrains.buildServer.vcs.CheckoutRules;
import jetbrains.buildServer.vcs.VcsException;
import jetbrains.buildServer.vcs.VcsRoot;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class VBAgentVcsSupport extends AgentVcsSupport implements UpdateByCheckoutRules2 {
    @NotNull
    @Override
    public UpdatePolicy getUpdatePolicy() {
        return this;
    }

    @NotNull
    @Override
    public String getName() {
        return Constants.VB_VCS_NAME;
    }

    @Override
    public void updateSources(@NotNull VcsRoot root, @NotNull CheckoutRules rules, @NotNull String toVersion, @NotNull File destFolder, @NotNull AgentRunningBuild build, boolean cleanCheckoutRequested) throws VcsException {
        // TODO: 先考虑最简单的模式，server 进行 clone 和 checkout， 然后构建patch
    }
}
