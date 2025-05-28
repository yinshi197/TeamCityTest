package com.softbridge.visionbyte;

import jetbrains.buildServer.vcs.VcsRoot;
/**
 * The configuartion constants for the plugin
 * */
public interface Constants {

    /**
     * The name of the VCS
     * */
    public static final String VB_VCS_NAME = "VisionByte";

    public static final String VB_VCS_DISPLAY_NAME = "VisionByte";

    public static final String VB_VCS_DESCRIPTION = "VisionByte VCS";

    public static final String VB_VCS_PROPERTIES_PROCESSOR_NAME = "VisionByteVcsPropertiesProcessor";

    public static final String BRANCH_NAME = "branch";

    public static final String USERNAME = "username";

    public static final String PASSWORD = VcsRoot.SECURE_PROPERTY_PREFIX + "password";

    public static final String REMOTE_URL = "url";

}
