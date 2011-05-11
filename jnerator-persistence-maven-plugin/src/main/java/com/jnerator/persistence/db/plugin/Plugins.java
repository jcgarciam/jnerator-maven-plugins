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

package com.jnerator.persistence.db.plugin;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author rflament@laposte.net
 * 
 */
public final class Plugins {

    private static Plugins instance = null;

    public static synchronized Plugins getInstance() {
        if (instance == null) {
            instance = new Plugins();
        }
        return instance;
    }

    private final Map plugins = new LinkedHashMap();

    private Plugins() {
        try {
            loadDefaultConfig();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void addPlugin(IGeneratorPlugin plugin) {
        plugins.put(plugin.getName(), plugin);
    }

    public void addPlugin(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class c = Class.forName(className);
        IGeneratorPlugin plugin = (IGeneratorPlugin) c.newInstance();
        addPlugin(plugin);
    }

    public IGeneratorPlugin getPlugin(String pluginName) {
        return (IGeneratorPlugin) plugins.get(pluginName);
    }

    public Map getPlugins() {
        return plugins;
    }

    public void loadConfig(InputStream is) throws ParserConfigurationException, SAXException, IOException, DOMException,
            ClassNotFoundException, InstantiationException, IllegalAccessException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = factory.newDocumentBuilder();
        Document doc = parser.parse(is);
        NodeList list = doc.getElementsByTagName("plugin");
        for (int i = 0; i < list.getLength(); i++) {
            addPlugin(list.item(i).getAttributes().getNamedItem("class").getNodeValue());
        }

    }

    public void loadDefaultConfig() throws ParserConfigurationException, SAXException, IOException, DOMException,
            ClassNotFoundException, InstantiationException, IllegalAccessException {
        loadConfig(this.getClass().getClassLoader().getResourceAsStream("plugins.xml"));
    }

}
