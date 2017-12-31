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
package org.walkmod.maven.plugins;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Parameter;
import org.walkmod.OptionsBuilder;
import org.walkmod.WalkModFacade;

public abstract class AbstractWalkmodMojo extends AbstractMojo {

    /**
     * Chains to execute
     */
    @Parameter(property = "chains", defaultValue = "${walkmod.chains}")
    protected String chains = null;

    /**
     * If dependencies are resolved off-line
     */
    @Parameter(property = "offline", defaultValue = "false")
    protected boolean offline = false;

    /**
     * If it is executed in verbose mode.
     */
    @Parameter(property = "verbose", defaultValue = "true")
    protected boolean verbose = true;

    /**
     * If it prints errors
     */
    @Parameter(property = "printError",defaultValue = "false")
    protected boolean printError = false;

    /**
     * Configuration file
     */
    @Parameter(property = "configFile")
    protected File configFile = new File("walkmod.xml");

    /**
     * If it skips walkmod
     */
    @Parameter(property = "skipWalkmod")
    protected boolean skipWalkmod = false;

    /**
     * Source file directory
     */
    @Parameter(property = "path")
    protected String path = null;

    /**
     * List of included files
     */
    @Parameter
    protected String[] includes = null;

    /**
     * List of excluded files
     */
    @Parameter
    protected String[] excludes = null;

    /**
     * Dynamic parameters to set
     */
    @Parameter(property = "properties", defaultValue = "${walkmod.properties}")
    protected String properties = null;

    protected Map<String, Object> dynamicParams = null;

    public void execute() throws MojoExecutionException {
        if (!skipWalkmod) {

            prepare();
            if (properties != null) {
                String[] parts = properties.split("\\=| ");
                if (parts.length % 2 == 0) {
                    if(dynamicParams == null){
                        dynamicParams= new HashMap<String, Object>();
                    }
                    for (int i = 0; i < parts.length - 1; i += 2) {
                        dynamicParams.put(parts[i].trim(), parts[i + 1].trim());
                    }
                }
            }

            WalkModFacade walkmod = new WalkModFacade(configFile,
                    OptionsBuilder.options().printErrors(printError).offline(offline).verbose(verbose).path(path)
                            .includes(includes).excludes(excludes).dynamicArgs(dynamicParams),
                    null);
            String[] selectedChains = null;
            if (chains != null) {
                selectedChains = chains.split(",");
            }
            run(walkmod, selectedChains);
            
        }
    }

    protected void prepare() {}

    protected abstract void run(WalkModFacade facade, String[] chainList) throws MojoExecutionException;

}
