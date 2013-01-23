/*
 * openwms.org, the Open Warehouse Management System.
 *
 * This file is part of openwms.org.
 *
 * openwms.org is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * openwms.org is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software. If not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.openwms.plugins;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;

/**
 * Goal to attach an existing properties file.
 * 
 * @goal bundle
 * @phase package
 * @author <a href="mailto:scherrer@openwms.org">Heiko Scherrer</a>
 * @version $Revision: $
 * @since 1.0
 */
public class PropertiesMojo extends AbstractMojo {

    /**
     * Location of the file.
     * 
     * @parameter
     * @required
     */
    private File path;

    /**
     * The Maven project.
     * 
     * @parameter default-value="${project}"
     * @required
     * @readonly
     */
    private MavenProject project;

    /**
     * Get a reference to the project.
     * 
     * @return The Maven project
     */
    protected final MavenProject getProject() {
        return project;
    }

    /**
     * Do it.
     */
    public void execute() throws MojoExecutionException {
        File f = path;
        if (!f.exists()) {
            throw new MojoExecutionException("File " + f + " does not exist");
        }
        getProject().getArtifact().setFile(f);
    }
}
