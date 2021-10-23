/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newcalcfx.db;

//Класс отвечающий за считывание значений из файла property

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configs {
    
    //Имя файла с настройками
    private static final String CONFIG_MAIN = "calc.property";
    private static final Properties MAIN_PROP = new Properties();
    
    //Начальная загрузка параметров из файла по дефолту
    public static void loadConfigDefault() throws IOException {
        loadConfigDefault(null);
    }

    // Сделать загрузку данных из конфигурационного файла, имя которого передано в виде параметра
    // Если имя null или пустое - берем файл по умолчанию.
    public static void loadConfigDefault(String name) throws IOException {
        if (name != null && !name.trim().isEmpty()) {
            MAIN_PROP.load(new FileReader(name));
        } else {
            MAIN_PROP.load(new FileReader(CONFIG_MAIN));
            
        }
    }

    // Получить значение параметра из глобальной конфигурации по имени
    public static String getProperty(String property) {
        return MAIN_PROP.getProperty(property);
    }

}
