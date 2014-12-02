slf4j-osgi
==========

An OSGI logging service adapter for SLF4J. Any slf4j logs will get forwarded
to the OSGI LogService in your env.

Copyright (C) 2014 by Jakob Kemi <jakob.kemi@gmail.com>

History
======


This tiny lib was derived from:
 * https://code.google.com/p/osgi-logging/	Rodrigo Reyes, 2008
 * https://github.com/entrusc/slf4j-osgi	Florian Frankenberger, 2013

Modified to handle LogService availability/disavailability at runtime, also to be a bit simpler and cleaner.


Building
========

Build using gradle, like so:

	gradle jar


Usage
=====

Add the following dependencies to project:

		dependencies {
			compile 'org.slf4j:slf4j-api:1.7+'
			compile 'org.slf4j:slf4j-osgi:1.7+'
		}

Add resulting .jar in your project along with the normal slf4j api. Then
call this in OSGI Activator:

        org.slf4j.impl.OSGILogFactory.init(bundleContext);

and messages will be forwarded to the LogService.

LICENSE
=======

This software is licensed under the Apache License, Version 2.0

you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
License for the specific language governing permissions and limitations
under the License.
