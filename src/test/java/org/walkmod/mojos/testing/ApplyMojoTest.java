package org.walkmod.mojos.testing;

import java.io.File;

import junit.framework.Assert;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.walkmod.mojos.CheckMojo;

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

		CheckMojo myMojo = (CheckMojo) lookupMojo("apply", pom);
		assertNotNull(myMojo);
		myMojo.execute();
		Assert.assertTrue(true);

	}
}
