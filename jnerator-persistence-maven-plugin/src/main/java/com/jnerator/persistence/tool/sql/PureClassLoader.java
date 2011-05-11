/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jnerator.persistence.tool.sql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

public class PureClassLoader extends ClassLoader {
	private static class ClassCacheEntry {

		Class loadedClass;

		File origin;
		long lastModified;

		ClassCacheEntry() {
		}

		public boolean isSystemClass() {
			return origin == null;
		}
	}

	private static int generationCounter = 0;

	private final int generation;

	private final Hashtable cache;

	private final Vector repository;

	public PureClassLoader(Vector vector) throws IllegalArgumentException {
		cache = new Hashtable();
		if (vector != null) {
			for (Enumeration enumeration = vector.elements(); enumeration
					.hasMoreElements();) {
				Object obj = enumeration.nextElement();
				File file;
				try {
					file = (File) obj;
				} catch (ClassCastException _ex) {
					throw new IllegalArgumentException("Object " + obj
							+ "is not a valid \"File\" instance");
				}
				if (!file.exists())
					throw new IllegalArgumentException("Repository "
							+ file.getAbsolutePath() + " doesn't exist!");
				if (!file.canRead())
					throw new IllegalArgumentException(
							"Don't have read access for file "
									+ file.getAbsolutePath());
				if (!file.isDirectory() && !isZipOrJarArchive(file))
					throw new IllegalArgumentException(
							file.getAbsolutePath()
									+ " is not a directory or zip/jar file"
									+ " or if it's a zip/jar file then it is corrupted.");
			}

		}
		repository = vector;
		generation = generationCounter++;
	}

	@Override
	public URL getResource(String s) {
		URL url = ClassLoader.getSystemResource(s);
		if (url != null)
			return url;
		for (Enumeration enumeration = repository.elements(); enumeration
				.hasMoreElements();) {
			File file = (File) enumeration.nextElement();
			if (file.isDirectory()) {
				String s1 = s.replace('/', File.separatorChar);
				File file1 = new File(file, s1);
				if (file1.exists()) {
					try {
						return new URL("file://" + file1.getAbsolutePath());
					} catch (MalformedURLException malformedurlexception) {
						malformedurlexception.printStackTrace();
					}
					return null;
				}
			}
		}

		return null;
	}

	@Override
	public InputStream getResourceAsStream(String s) {
		InputStream inputstream = ClassLoader.getSystemResourceAsStream(s);
		if (inputstream == null) {
			for (Enumeration enumeration = repository.elements(); enumeration
					.hasMoreElements();) {
				File file = (File) enumeration.nextElement();
				if (file.isDirectory())
					inputstream = loadResourceFromDirectory(file, s);
				else if (s.endsWith(".initArgs")) {
					File file1 = new File(file.getParent());
					inputstream = loadResourceFromDirectory(file1, s);
				} else {
					inputstream = loadResourceFromZipfile(file, s);
				}
				if (inputstream != null)
					break;
			}

		}
		return inputstream;
	}

	private boolean isZipOrJarArchive(File file) {
		boolean flag = true;
		ZipFile zipfile = null;
		try {
			zipfile = new ZipFile(file);
		} catch (ZipException _ex) {
			flag = false;
		} catch (IOException _ex) {
			flag = false;
		} finally {
			if (zipfile != null)
				try {
					zipfile.close();
				} catch (IOException _ex) {
				}
		}
		return flag;
	}

	private byte[] loadBytesFromStream(InputStream inputstream, int i)
			throws IOException {
		byte abyte0[] = new byte[i];
		int k = 0;
		int j;
		for (; (i > 0) && ((j = inputstream.read(abyte0, k, i)) != -1); i -= j)
			k += j;

		return abyte0;
	}

	@Override
	protected synchronized Class loadClass(String s, boolean flag)
			throws ClassNotFoundException {
		Class class1 = null;
		ClassCacheEntry classcacheentry = (ClassCacheEntry) cache.get(s);
		if (classcacheentry != null) {
			class1 = classcacheentry.loadedClass;
			if (flag)
				resolveClass(class1);
			return class1;
		}
		if (!securityAllowsClass(s))
			return loadSystemClass(s, flag);
		Enumeration enumeration = repository.elements();
		ClassCacheEntry classcacheentry1 = new ClassCacheEntry();
		while (enumeration.hasMoreElements()) {
			File file = (File) enumeration.nextElement();
			byte abyte0[];
			try {
				if (file.isDirectory())
					abyte0 = loadClassFromDirectory(file, s, classcacheentry1);
				else
					abyte0 = loadClassFromZipfile(file, s, classcacheentry1);
			} catch (IOException _ex) {
				abyte0 = null;
			}
			if (abyte0 != null) {
				class1 = defineClass(s, abyte0, 0, abyte0.length);
				classcacheentry1.loadedClass = class1;
				classcacheentry1.lastModified = classcacheentry1.origin
						.lastModified();
				cache.put(s, classcacheentry1);
				if (flag)
					resolveClass(class1);
				return class1;
			}
		}
		try {
			class1 = loadSystemClass(s, flag);
			if (class1 != null) {
				if (flag)
					resolveClass(class1);
				return class1;
			}
		} catch (Exception _ex) {
			class1 = null;
		}
		throw new ClassNotFoundException(s);
	}

	private byte[] loadClassFromDirectory(File file, String s,
			ClassCacheEntry classcacheentry) throws IOException {
		String s1 = s.replace('.', File.separatorChar) + ".class";
		if (!Character.isJavaIdentifierStart(s1.charAt(0))) {
			int i;
			for (i = 1; !Character.isJavaIdentifierStart(s1.charAt(i++));)
				;
			s1 = s1.substring(i);
		}
		File file1 = new File(file, s1);
		if (file1.exists()) {
			classcacheentry.origin = file1;
			FileInputStream fileinputstream = new FileInputStream(file1);
			try {
				byte abyte0[] = loadBytesFromStream(fileinputstream,
						(int) file1.length());
				return abyte0;
			} finally {
				fileinputstream.close();
			}
		} else {
			return null;
		}
	}

	private byte[] loadClassFromZipfile(File file, String s,
			ClassCacheEntry classcacheentry) throws IOException {
		String s1 = s.replace('.', '/') + ".class";
		ZipFile zipfile = new ZipFile(file);
		try {
			ZipEntry zipentry = zipfile.getEntry(s1);
			if (zipentry != null) {
				classcacheentry.origin = file;
				byte abyte0[] = loadBytesFromStream(zipfile
						.getInputStream(zipentry), (int) zipentry.getSize());
				return abyte0;
			}
			byte abyte1[] = null;
			return abyte1;
		} finally {
			zipfile.close();
		}
	}

	private InputStream loadResourceFromDirectory(File file, String s) {
		String s1 = s.replace('/', File.separatorChar);
		File file1 = new File(file, s1);
		if (file1.exists())
			try {
				return new FileInputStream(file1);
			} catch (FileNotFoundException _ex) {
				return null;
			}
		else
			return null;
	}

	private InputStream loadResourceFromZipfile(File file, String s) {
		try {
			ZipFile zipfile = new ZipFile(file);
			ZipEntry zipentry = zipfile.getEntry(s);
			if (zipentry != null)
				return zipfile.getInputStream(zipentry);
			else
				return null;
		} catch (IOException _ex) {
			return null;
		}
	}

	private Class loadSystemClass(String s, boolean flag)
			throws NoClassDefFoundError, ClassNotFoundException {
		Class class1 = findSystemClass(s);
		ClassCacheEntry classcacheentry = new ClassCacheEntry();
		classcacheentry.origin = null;
		classcacheentry.loadedClass = class1;
		classcacheentry.lastModified = 0x7fffffffffffffffL;
		cache.put(s, classcacheentry);
		if (flag)
			resolveClass(class1);
		return class1;
	}

	public PureClassLoader reinstantiate() {
		return new PureClassLoader(repository);
	}

	private boolean securityAllowsClass(String s) {
		try {
			SecurityManager securitymanager = System.getSecurityManager();
			if (securitymanager == null) {
				return true;
			} else {
				int i = s.lastIndexOf(46);
				securitymanager.checkPackageDefinition(i <= -1 ? "" : s
						.substring(0, i));
				return true;
			}
		} catch (SecurityException _ex) {
			return false;
		}
	}

	public synchronized boolean shouldReload() {
		for (Enumeration enumeration = cache.elements(); enumeration
				.hasMoreElements();) {
			ClassCacheEntry classcacheentry = (ClassCacheEntry) enumeration
					.nextElement();
			if (!classcacheentry.isSystemClass()) {
				long l = classcacheentry.origin.lastModified();
				if (l == 0L)
					return true;
				if (l != classcacheentry.lastModified)
					return true;
			}
		}

		return false;
	}

	public synchronized boolean shouldReload(String s) {
		ClassCacheEntry classcacheentry = (ClassCacheEntry) cache.get(s);
		if (classcacheentry == null)
			return false;
		if (classcacheentry.isSystemClass()) {
			return false;
		} else {
			boolean flag = classcacheentry.origin.lastModified() != classcacheentry.lastModified;
			return flag;
		}
	}

}
