package com.softbridge.visionbyte;

import jetbrains.buildServer.serverSide.PropertiesProcessor;
import jetbrains.buildServer.vcs.*;
import jetbrains.buildServer.vcs.patches.PatchBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.*;

public class VBVcsSupport extends ServerVcsSupport
        implements VcsBulkSuitabilityChecker, BuildPatchByCheckoutRules,
        TestConnectionSupport, IncludeRuleBasedMappingProvider,
        VcsRootIdentityProvider {
    @Override
    public void buildPatch(@NotNull VcsRoot root, @Nullable String fromVersion, @NotNull String toVersion, @NotNull PatchBuilder builder, @NotNull CheckoutRules checkoutRules) throws IOException, VcsException {

    }

    @Override
    public Collection<VcsClientMapping> getClientMapping(@NotNull VcsRoot vcsRoot, @NotNull IncludeRule includeRule) throws VcsException {
        return Collections.emptyList();
    }

    @Nullable
    @Override
    public String testConnection(@NotNull VcsRoot vcsRoot) throws VcsException {
        Random random = new Random();

        int randomInt = random.nextInt(); // 任意 int
        if(randomInt % 2 == 0) {
            return "Connection failed";
        }

        return null;    //null, if connection is ok, or a string message otherwise
    }

    @NotNull
    @Override
    public List<Boolean> checkSuitable(@NotNull List<VcsRootEntry> entries, @NotNull Collection<String> paths) throws VcsException {
        return Collections.emptyList();
    }

    @NotNull
    @Override
    public Collection<String> mapFullPath(@NotNull VcsRootEntry rootEntry, @NotNull String fullPath) throws VcsException {
        return Collections.emptyList();
    }

    @NotNull
    @Override
    public String getVcsRootIdentity(@NotNull VcsRoot vcsRoot) throws VcsException {
        return "";
    }

    @Nullable
    @Override
    public String getDefaultBranchName(@NotNull VcsRoot vcsRoot) {
        return Constants.BRANCH_NAME;
    }

    @NotNull
    @Override
    public String getName() {
        return Constants.VB_VCS_NAME;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return Constants.VB_VCS_DISPLAY_NAME;
    }

    @Nullable
    @Override
    public PropertiesProcessor getVcsPropertiesProcessor() {
        return new VcsPropertiesProcessor();
    }

    @NotNull
    @Override
    public String getVcsSettingsJspFilePath() {
        return "vbVcsSettings.jsp";
    }

    @NotNull
    @Override
    public String describeVcsRoot(@NotNull VcsRoot vcsRoot) {
        final String branch = vcsRoot.getProperty(Constants.BRANCH_NAME);
        return "VisionByte VCS: " + vcsRoot.getProperty(Constants.REMOTE_URL) + (branch != null ? " (" + branch + ")" : "(master)");
    }

    @Nullable
    @Override
    public Map<String, String> getDefaultVcsProperties() {
        return Collections.emptyMap();
    }

    @Nullable
    @Override
    public String getVersionDisplayName(@NotNull String version, @NotNull VcsRoot root) throws VcsException {
        return "";
    }

    @NotNull
    @Override
    public Comparator<String> getVersionComparator() {
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
    }

    @NotNull
    @Override
    public VcsFileContentProvider getContentProvider() {
        return null;
    }

    @NotNull
    @Override
    public CollectChangesPolicy getCollectChangesPolicy() {
        return null;
    }

    @NotNull
    @Override
    public BuildPatchPolicy getBuildPatchPolicy() {
        return null;
    }

    @Override
    public boolean sourcesUpdatePossibleIfChangesNotFound(@NotNull VcsRoot root) {
        return false;
    }
}