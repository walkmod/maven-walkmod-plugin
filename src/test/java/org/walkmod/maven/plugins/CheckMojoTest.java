package org.walkmod.maven.plugins;

import java.io.File;

import junit.framework.Assert;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.walkmod.maven.plugins.CheckMojo;


public class CheckMojoTest extends AbstractMojoTestCase{

	/** {@inheritDoc} */
    protected void setUp()
        throws Exception
    {
        // required
        super.setUp();
    }

    /** {@inheritDoc} */
    protected void tearDown()
        throws Exception
    {
        // required
        super.tearDown();

    }

    /**
     * @throws Exception if any
     */
    public void testExecution()
        throws Exception
    {
        File pom = getTestFile( "src/test/resources/project-to-test/pom.xml" );
        assertNotNull( pom );
        assertTrue( pom.exists() );

		CheckMojo myMojo = (CheckMojo) lookupMojo("check", pom );
        assertNotNull( myMojo );
        myMojo.execute();
        Assert.assertTrue(true);

    }
}
