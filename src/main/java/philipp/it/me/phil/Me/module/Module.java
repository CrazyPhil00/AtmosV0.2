package philipp.it.me.phil.Me.module;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import philipp.it.me.phil.Me.events.Events;
import philipp.it.me.phil.Me.settings.Setting;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Module {
    public String name, description;
    private int key;
    private Category category;
    private boolean toggled, showSettings, delaySetting, modeSetting, rangeSetting, custom, bool;
    public Minecraft mc;
    public int index;
    public int delay = 60;
    public double range = 4.5;

    public List<String> modes;

    public HashMap<String, Boolean> booleans;


    public List<Setting> settings = new ArrayList<>();

    public void addSettings(Setting... settings) {
        this.settings.addAll(Arrays.asList(settings));
    }

    public Module(String name, String description, Category category, boolean showSettings,/*double delay ,*/ String defaultMode, String... modes ) {
        super();

        this.name = name;
        this.category = category;
        this.description = description;
        this.key = 0;
        this.toggled = false;
        this.showSettings = showSettings;
        this.modes = Arrays.asList(modes);
        index = this.modes.indexOf(defaultMode);
        this.delaySetting = false;
        this.rangeSetting = false;
        this.modeSetting = true;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }


    public void onEvent(Events e) {


    }


    public Category getCategory() {
        return category;
    }


    public boolean isToggled() {
        return toggled;
    }

    public void setToggled(boolean toggled) throws AWTException {
        this.toggled = toggled;

        if (this.toggled) {
            this.onEnable();
        } else this.onDisable();
    }

    public void toggle() throws AWTException {
        this.toggled = !this.toggled;

        if (this.toggled) {
            this.onEnable();
        } else this.onDisable();
    }


    public void onEnable() throws AWTException {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister(this);
    }


    public String getName() {
        return name;
    }


    public Enum Category() {
        return null;
    }

    public boolean showSettings() {
        return showSettings;
    }

    public void setShowSettings(boolean showSettings) {
        this.showSettings = showSettings;
    }

    public void toggleShowSettings() {
        showSettings = !showSettings;
    }

    public String getMode() {
        return modes.get(index);
    }

    public boolean is(String mode) {
        return index == modes.indexOf(mode);
    }

    public void cycle() {
        if (index < modes.size() -1) {
            index ++;
        }else index = 0;
    }

    public int getDelay() {return delay;}

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public boolean hasDelaySetting() {
        return delaySetting;
    }

    public boolean hasModeSetting() {
        return modeSetting;
    }

    public boolean hasRangeSetting() {
        return rangeSetting;
    }

    public double getRange() {
        DecimalFormat df = new DecimalFormat("#.0");

        String formatedNumber = df.format(this.range);
        return Double.parseDouble(formatedNumber);
    }

    public void setRange(double range) {
        this.range = range;

    }

    public void setDelaySetting(boolean delaySetting) {
        this.delaySetting = delaySetting;
    }

    public void setModeSetting(boolean modeSetting) {
        this.modeSetting = modeSetting;
    }

    public void setRangeSetting(boolean rangeSetting) {
        this.rangeSetting = rangeSetting;
    }

    public boolean isCustom() {
        custom = getMode().equalsIgnoreCase("custom");
        return getMode().equalsIgnoreCase("custom");
    }

    public boolean hasBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public void cycleBoolean(String booleanToCycle) {
        boolean bool = booleans.get(booleanToCycle);
        bool = !bool;
    }
}
