package philipp.it.me.phil.Me.module;


import philipp.it.me.phil.Me.module.render.TabGUI;

import java.awt.*;


public enum Category {
    COMBAT("Combat", 150, 50, false, false, new Color(148, 9, 9).getRGB(), Modules.getCombatSection().size()),
    EXPLOITS("Exploits", 150, 100, false, false, new Color(0, 255, 255).getRGB(), Modules.getExploitSection().size()),
    RENDER("Render", 150, 150, false, false, new Color(156, 0, 173).getRGB(), Modules.getRenderSection().size()),
    PLAYER("Player", 150, 200, false, false, new Color(0, 26, 255).getRGB(), Modules.getPlayerSection().size()),
    CLIENT("Client", 150, 250, false, false, new Color(86, 94, 86).getRGB(), Modules.getClientSection().size()) ,
    MOVEMENT("Movement", 150, 300, false, false, new Color(217, 168, 7).getRGB(), Modules.getMovementSection().size()) ,
    WORLD("World", 150, 350, false,false, new Color(12, 122, 9).getRGB(), Modules.getWorldSection().size());

    public TabGUI tabGUI = new TabGUI();

    public String name;
    public int posX, posY;
    public boolean mouseClicked, showModules;
    int color, size;


    Category(String name, int posX, int posY, boolean mouseClicked, boolean showModules, int color, int size) {
        this.name = name;
        this.posY = posY;
        this.posX = posX;
        this.mouseClicked = mouseClicked;
        this.showModules = showModules;
        this.color = color;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getSize() {
        return size;
    }
}
