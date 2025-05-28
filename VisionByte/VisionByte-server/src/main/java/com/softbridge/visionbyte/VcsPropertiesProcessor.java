package com.softbridge.visionbyte;

import jetbrains.buildServer.buildTriggers.vcs.AbstractVcsPropertiesProcessor;
import jetbrains.buildServer.serverSide.InvalidProperty;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class VcsPropertiesProcessor extends AbstractVcsPropertiesProcessor {
    @Override
    public Collection<InvalidProperty> process(Map<String, String> properties) {
        return Collections.emptyList();
    }
}
