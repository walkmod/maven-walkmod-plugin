package org.walkmod.maven.plugins;

import java.io.File;

import junit.framework.Assert;

public class ApplyMojoTest extends AbstractWalkmodMojoTestCase {

    public void testExecutionWithSemanticAnalysis() throws Exception {
        File pom = getTestFile("src/test/resources/project-to-test/pom.xml");
        ApplyMojo myMojo = (ApplyMojo) lookupConfiguredMojo(pom, "apply");
        myMojo.execute();
        Assert.assertEquals(ExecutionStatus.FINISHED, myMojo.getStatus());
    }

    public void testExecutionWithMultiModule() throws Exception {
        File pom = getTestFile("src/test/resources/multimodule-project-to-test/pom.xml");
        ApplyMojo myMojo = (ApplyMojo) lookupConfiguredMojo(pom, "apply");
        myMojo.execute();
        Assert.assertEquals(ExecutionStatus.IGNORED, myMojo.getStatus());

        File pomModule = getTestFile("src/test/resources/multimodule-project-to-test/module1/pom.xml");
        ApplyMojo moduleMojo = (ApplyMojo) lookupConfiguredMojo(pomModule, "apply");
        moduleMojo.execute();
        Assert.assertEquals(ExecutionStatus.FINISHED, moduleMojo.getStatus());
    }
}
