# e4-cookbook-basic-recipe
The basic recipe of the Eclipse RCP cookbook extended for integrating JavaFX.

This example has been updated to Java 17 using the following approach:

To use JavaFX, add the following to your target platform:

<location includeDependencyDepth="infinite" includeDependencyScopes="compile,runtime" includeSource="true" label="Tools Platform Libs" missingManifest="generate" type="Maven">
		  <dependencies>
			  <dependency>
				  <groupId>org.openjfx</groupId>
				  <artifactId>javafx-controls</artifactId>
				  <version>22-ea+16</version>
				  <type>jar</type>
			  </dependency>
			  <dependency>
				  <groupId>org.openjfx</groupId>
				  <artifactId>javafx-fxml</artifactId>
				  <version>22-ea+16</version>
				  <type>jar</type>
			  </dependency>
		  </dependencies>
	  </location>

Unfortunately the JavaFX SWT libraries is not available via Maven artifacts, you have to extract it from the the zip file.
This is platform specific:

Windows: Contained in JAR file of Javafx controls
Linux: Contained in the JAR file of Javafx graphics jar
The JAR files in which the JAR file is included is located in .m2/repository/org/openjfx/compoent/version for example: .m2/repository/org/openjfx/javafx-graphics/21

Unfortunately the target platform downloads the platform specific artifacts from Maven using the same bundle name. PDE resolves in some cases (this seems to be platform and library version specific) to the bundle which does not contain the implementation. Therefore, you might have to copy the JAR files into your project and add them to the MANIFEST.MF file.

image

Manifest-Version: 1.0
Bundle-ManifestVersion: 2
Bundle-Name: Inverter
Bundle-SymbolicName: org.fipro.eclipse.tutorial.inverter
Bundle-Version: 1.0.0.qualifier
Bundle-RequiredExecutionEnvironment: JavaSE-17
Require-Bundle: org.eclipse.swt;bundle-version="3.103.1",
 org.eclipse.jface;bundle-version="3.10.1",
 javax.annotation;bundle-version="1.2.0",
 javax.inject;bundle-version="1.0.0"
Automatic-Module-Name: org.fipro.eclipse.tutorial.inverter
Bundle-ClassPath: .,
 lib/javafx-base-17.0.9.jar,
 lib/javafx-base-17.0.9-linux.jar,
 lib/javafx-fxml-17.0.9.jar,
 lib/javafx-fxml-17.0.9-linux.jar,
 lib/javafx-graphics-17.0.9.jar,
 lib/javafx-graphics-17.0.9-linux.jar,
 lib/javafx-swt.jar,
 lib/javafx-controls-17.0.9.jar,
 lib/javafx-controls-17.0.9-linux.jar



The blog post for the basic recipe can be found here:\
https://blog.codecentric.de/en/2015/02/eclipse-rcp-cookbook-basic-recipe/

The original blog post for the JavaFX integration can be found here:\
https://blog.codecentric.de/en/2015/04/add-javafx-controls-swt-eclipse-4-application-eclipse-rcp-cookbook/

The updated blog post for the current version of the JavaFX integration can be found here:\
http://blog.vogella.com/2019/11/15/add-javafx-controls-to-a-swt-eclipse-4-application-eclipse-rcp-cookbook-update/
