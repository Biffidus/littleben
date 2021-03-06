/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package littleben;

import java.util.prefs.Preferences;

/**
 *
 * @author Simon
 */
public class Settings {

    public Integer startTime,  endTime,  frequency;
    Preferences prefs = Preferences.userNodeForPackage(Settings.class);

    public void save() {
        prefs.putInt("frequency", frequency);
        prefs.putInt("startTime", startTime);
        prefs.putInt("endTime", endTime);
        System.out.println("Settings saved.");
    }

    public Settings() {
        // Load settings
        frequency = prefs.getInt("frequency", 15);
        startTime = prefs.getInt("startTime", 18);
        endTime = prefs.getInt("endTime", 6);
        System.out.println("Settings loaded.");

        // and save them on exit
        Runtime.getRuntime().addShutdownHook(new Thread() {

            public void run() {
                save();
            }
        });
    }
}
