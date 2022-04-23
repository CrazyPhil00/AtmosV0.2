package philipp.it.me.phil.Me.module.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.entity.Render;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;
import philipp.it.me.phil.Me.module.Category;
import philipp.it.me.phil.Me.module.ModuleManager;
import philipp.it.me.phil.Me.module.Modules;

import java.awt.*;

import static philipp.it.me.phil.Me.module.render.Tracer.rainbows;


public class TabGUI extends Gui{



    public Category category;
    public int currentTab, expandedTab;
    public static boolean expanded, pressed, visible;
    public int textColor = -1;
    public int backgroundColor = 0x30000000;



    private boolean combat , render , world , movement , player , exploits;


    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent e) {
        //if (visible) {
        FontRenderer fr = Minecraft.getMinecraft().fontRenderer;
        if (e.getType().equals(RenderGameOverlayEvent.ElementType.TEXT)) {
            if (!visible) return;

            Gui.drawRect(3, 20, 70, 175, backgroundColor);
            if (!expanded) {
                Gui.drawRect(3, 28 + currentTab * 20, 8, 50 + currentTab * 20, textColor);
                //Gui.drawRect(3, 28 + currentTab *20, 80, 50 + currentTab *20 , rainbows(1));
            }

            fr.drawString("Combat", 10, 35, textColor);
            fr.drawString("Render", 10, 55, textColor);
            fr.drawString("World", 10, 75, textColor);
            fr.drawString("Movement", 10, 95, textColor);
            fr.drawString("Player", 10, 115, textColor);
            fr.drawString("Exploits", 10, 135, textColor);
            fr.drawString("Client", 10, 155, textColor);



            if (expanded) {
                int t = 35;
                if (currentTab == 0) {
                    for (String m : Modules.getCombatSection()) {
                        fr.drawString(m, 77, t, -1);
                        t += 20;
                    }

                } else if (currentTab == 1) {
                    for (String m : Modules.getRenderSection()) {

                        fr.drawString(m, 77, t, -1);
                        t += 20;
                    }

                } else if (currentTab == 2) {
                    for (String m : Modules.getWorldSection()) {

                        fr.drawString(m, 77, t, -1);
                        t += 20;
                    }

                } else if (currentTab == 3) {
                    for (String m : Modules.getMovementSection()) {

                        fr.drawString(m, 77, t, -1);
                        t += 20;
                    }

                } else if (currentTab == 4) {
                    for (String m : Modules.getPlayerSection()) {

                        fr.drawString(m, 77, t, -1);
                        t += 20;
                    }

                } else if (currentTab == 5) {
                    for (String m : Modules.getExploitSection()) {

                        fr.drawString(m, 77, t, -1);
                        t += 20;
                    }

                } else if (currentTab == 6) {
                    for (String m : Modules.getClientSection()) {
                        fr.drawString(m, 77, t, -1);
                        t += 20;
                    }
                }


                Gui.drawRect(70, 20, 137, 175, backgroundColor);

                Gui.drawRect(72, 28 + expandedTab * 20, 77, 50 + expandedTab * 20, -1);
                //Gui.drawRect(3, 28 + currentTab *20, 80, 50 + currentTab *20 , rainbows(1));

                /*fr.drawStringWithShadow("Combat", 77, 35, rainbows(1));
                fr.drawStringWithShadow("Render", 77, 55, rainbows(1));
                fr.drawStringWithShadow("World", 77, 75, rainbows(1));
                fr.drawStringWithShadow("Movement", 77, 95, rainbows(1));
                fr.drawStringWithShadow("Player", 77, 115, rainbows(1));
                fr.drawStringWithShadow("Exploits", 77, 135, rainbows(1));
                fr.drawStringWithShadow("Client", 77 ,155, rainbows(1));

                 */
            }
        }
    }

    @SubscribeEvent
    public void onKey(InputEvent.KeyInputEvent e) {

        if (Keyboard.isCreated()) {
            if (Keyboard.getEventKeyState()) {

                int keyCode = Keyboard.getEventKey();
                if (keyCode <= 0) return;
                Keyboard.getKeyName(keyCode);


                if (keyCode == Keyboard.KEY_UP) {
                    if (expandedTab >= 6) {
                        expandedTab = -1;
                    }
                    if (currentTab <= 0) {
                        if (expanded) {
                            expandedTab = Category.values().length -1;
                        }else
                        currentTab = Category.values().length - 1;
                    } else
                        if (expanded) {
                            expandedTab --;
                        }else
                        currentTab--;
                }

                if (keyCode == Keyboard.KEY_DOWN) {
                    if (expandedTab >= 6) {
                        expandedTab = -1;
                    }
                    if (currentTab >= Category.values().length - 1) {
                        if (expanded) {
                            expandedTab = 0;
                        }else
                        currentTab = 0;
                    } else
                        if (expanded) {
                            expandedTab ++;
                        }else
                        currentTab++;
                }

                if (keyCode == Keyboard.KEY_RIGHT) {
                    if (!visible) visible = true;
                    else expanded = true;
                }

                if (keyCode == Keyboard.KEY_LEFT) {
                    
                    if (!expanded) visible = false;
                    else expanded = false;
                }

                if (keyCode == Keyboard.KEY_RETURN) {
                    if (expanded) {
                        int t = 35;

                        //ModuleManager.getModulebyNumber(expandedTab,ModuleManager.getCategorybyNumber(currentTab)).toggle();
                        try {


                            ModuleManager.getModule(ModuleManager.getCategorybyNumber(currentTab), expandedTab).toggle();
                        }catch (NullPointerException | AWTException nulle) {
                            nulle.printStackTrace();
                        }
                    }
                }
            }
        }
    }



}
