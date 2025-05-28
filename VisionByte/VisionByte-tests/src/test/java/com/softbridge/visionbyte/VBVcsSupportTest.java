package com.softbridge.visionbyte;

import jetbrains.buildServer.vcs.VcsException;
import jetbrains.buildServer.vcs.impl.VcsRootImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VBVcsSupportTest extends VBBaseTest {

    @Test
    public void testGetNameAndDisplayName() {
        assertEquals(Constants.VB_VCS_NAME, vcsSupport.getName());
        assertEquals(Constants.VB_VCS_DISPLAY_NAME, vcsSupport.getDisplayName());
    }

    @Test
    public void testDescribeVcsRoot_withBranch() {
        VcsRootImpl root = createRootWithUrlAndBranch("http://example.com/repo", "develop");

        String desc = vcsSupport.describeVcsRoot(root);
        assertTrue(desc.contains("http://example.com/repo"));
        assertTrue(desc.contains("develop"));
    }

    @Test
    public void testDescribeVcsRoot_noBranch() {
        VcsRootImpl root = createRootWithUrlAndBranch("http://example.com/repo", null);

        String desc = vcsSupport.describeVcsRoot(root);
        assertTrue(desc.contains("master")); // fallback
    }

    @Test
    public void testDefaultBranchName() {
        VcsRootImpl root = new VcsRootImpl(3, Constants.VB_VCS_NAME);
        assertEquals(Constants.BRANCH_NAME, vcsSupport.getDefaultBranchName(root));
    }

    @Test
    public void testConnection_random() throws VcsException {
        VcsRootImpl root = createRootWithUrlAndBranch("http://example.com/repo", null);

        boolean success = false;
        for (int i = 0; i < 20; i++) {
            String result = vcsSupport.testConnection(root);
            if (result == null) {
                success = true;
                break;
            }
        }

        assertTrue(success, "Expected at least one successful connection.");
    }
}
