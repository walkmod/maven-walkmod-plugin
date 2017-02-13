package org.walkmod.maven.plugins;

import java.io.File;

import junit.framework.Assert;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.walkmod.maven.plugins.ApplyMojo;

public class ApplyMojoTest extends AbstractMojoTestCase {
	/** {@inheritDoc} */
	protected void setUp() throws Exception {
		// required
		super.setUp();
	}

	/** {@inheritDoc} */
	protected void tearDown() throws Exception {
		// required
		super.tearDown();

	}

	/**
	 * @throws Exception
	 *             if any
	 */
	public void testExecution() throws Exception {
		File pom = getTestFile("src/test/resources/project-to-test-apply/pom.xml");
		assertNotNull(pom);
		assertTrue(pom.exists());

		ApplyMojo myMojo = (ApplyMojo) lookupMojo("apply", pom);
		assertNotNull(myMojo);
		myMojo.execute();
		Assert.assertTrue(true);

	}
	
	public void testExecutionWithSemanticAnalysis() throws Exception {
	   File pom = getTestFile("src/test/resources/project-with-pmd/pom.xml");
	   ApplyMojo myMojo = (ApplyMojo) lookupMojo("apply", pom);
      assertNotNull(myMojo);
      myMojo.execute();
      Assert.assertTrue(true);
	}
}
