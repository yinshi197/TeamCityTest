package com.softbridge.visionbyte;

import jetbrains.buildServer.vcs.impl.VcsRootImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class VBBaseTest {

    protected VBVcsSupport vcsSupport;

    @BeforeEach
    public void setUp() {
        vcsSupport = new VBVcsSupport();
        onSetUp();
    }

    @AfterEach
    public void tearDown() {
        onTearDown();
    }

    /**
     * Subclasses can override this method to inject additional logic into setup.
     */
    protected void onSetUp() {
        // For subclass override
    }

    /**
     * Subclasses can override this method to clean up resources in the teardown
     */
    protected void onTearDown() {
        // For subclass override
    }

    /**
     * Helper methods available for creating Root objects in tests
     */
    protected VcsRootImpl createRootWithUrlAndBranch(String url, String branch) {
        VcsRootImpl root = new VcsRootImpl(0, Constants.VB_VCS_NAME);
        root.addProperty(Constants.REMOTE_URL, url);
        if (branch != null) {
            root.addProperty(Constants.BRANCH_NAME, branch);
        }
        return root;
    }
}
