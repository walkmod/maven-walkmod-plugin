package org.walkmod.maven.plugins;

import java.io.File;

import junit.framework.Assert;

public class CheckMojoTest extends AbstractWalkmodMojoTestCase {

    public void testExecution() throws Exception {
        File pom = getTestFile("src/test/resources/project-to-test/pom.xml");
		CheckMojo myMojo = (CheckMojo) lookupConfiguredMojo(pom, "check");
        myMojo.execute();
        Assert.assertEquals(ExecutionStatus.FINISHED, myMojo.getStatus());
    }
}
