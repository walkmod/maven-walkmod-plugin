/* 
  Copyright (C) 2013 Raquel Pau and Albert Coroleu.
 
 Walkmod is free software: you can redistribute it and/or modify
 it under the terms of the GNU Lesser General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.
 
 Walkmod is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Lesser General Public License for more details.
 
 You should have received a copy of the GNU Lesser General Public License
 along with Walkmod.  If not, see <http://www.gnu.org/licenses/>.*/
package org.walkmod.mojos;

import java.io.File;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Parameter;

public abstract class AbstractWalkmodMojo extends AbstractMojo {

	/**
	 * Chains to execute
	 */
	@Parameter
	protected String[] chains = null;

	/**
	 * If dependencies are resolved off-line 
	 */
	@Parameter
	protected boolean offline = false;

	/**
	 * If is executed in verbose mode.
	 */
	@Parameter
	protected boolean verbose = true;

	/**
	 * if prints errors
	 */
	@Parameter
	protected boolean printError = false;

	/**
	 * Configuration file
	 */
	@Parameter
	protected File configFile = new File("walkmod.xml");
}
