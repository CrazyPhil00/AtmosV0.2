package philipp.it.me.phil.Me;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.command.ICommand;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import philipp.it.me.phil.Me.commands.TestCommand;
import philipp.it.me.phil.Me.events.Events;
import philipp.it.me.phil.Me.listener.EventKey;
import philipp.it.me.phil.Me.module.Category;
import philipp.it.me.phil.Me.module.Module;
import philipp.it.me.phil.Me.module.ModuleManager;
import philipp.it.me.phil.Me.module.keystrokes.CommandKeystrokes;
import philipp.it.me.phil.Me.module.keystrokes.KeystrokesSettings;
import philipp.it.me.phil.Me.module.keystrokes.render.GuiScreenKeystrokes;
import philipp.it.me.phil.Me.module.keystrokes.render.KeystrokesRenderer;
import philipp.it.me.phil.Me.module.player.FollowEntity;
import philipp.it.me.phil.Me.module.player.NoFall;
import philipp.it.me.phil.Me.module.pvp.Killaura;
import philipp.it.me.phil.Me.module.render.TabGUIToggle;
import philipp.it.me.phil.Me.ui.Hud;
import philipp.it.me.phil.Me.ui.clickgui.ClickGuiToggle;
import philipp.it.me.phil.Me.ui.customize.CustomizeScreenToggle;
import philipp.it.me.phil.Me.utils.Reference;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@net.minecraftforge.fml.common.Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)

public class Mod {

    public static ModuleManager moduleManager;
    public static Hud hud;
    public ClickGuiToggle clickGui;
    public CustomizeScreenToggle customizeScreen;

    @net.minecraftforge.fml.common.Mod.Instance
    public static Mod instance;




    @net.minecraftforge.fml.common.Mod.EventHandler
    public void PreInit(FMLPreInitializationEvent event) {
        Display.setTitle("loading Atmos Client ...");
        // Display.setLocation(5 , 5);
        Display.setInitialBackground(10,0,10);




    }

    @net.minecraftforge.fml.common.Mod.EventHandler
    public void init (FMLInitializationEvent event) throws AWTException {
        MinecraftForge.EVENT_BUS.register(instance);
        MinecraftForge.EVENT_BUS.register(new Hud());
        MinecraftForge.EVENT_BUS.register(new Killaura());
        MinecraftForge.EVENT_BUS.register(new NoFall());

        TabGUIToggle tabGUIToggle = new TabGUIToggle();
        tabGUIToggle.setToggled(true);
        MinecraftForge.EVENT_BUS.register(new FollowEntity());
        moduleManager = new ModuleManager();

    }

    @net.minecraftforge.fml.common.Mod.EventHandler
    public void PostInit(FMLPostInitializationEvent event) {
        Display.setTitle("Atmos Client");

    }


    public static void onEvent(Events e) {
        for (Module m : moduleManager.modules) {
            if (!m.isToggled())
                m.onEvent(e);
        }
    }


    @SubscribeEvent
    public void key(InputEvent.KeyInputEvent event) {
        if (Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null) return;

        try {
            if (Keyboard.isCreated()) {
                if (Keyboard.getEventKeyState()) {

                    int keyCode = Keyboard.getEventKey();
                    if (keyCode <= 0) return;
                    keyPress(keyCode);
                    for (Module m : moduleManager.modules) {
                        if (m.getKey() == keyCode && keyCode>= 0) {
                            m.toggle();
                        }
                    }
                }
            }

        }catch (Exception q) {
            q.printStackTrace();
        }

    }

    public static List<Module> getModuleByCategory(Category c) {
        List<Module> modules = new ArrayList<>();

        for (Module m : modules) {
            if (m.getCategory() == c) {
                modules.add(m);
            }
        }
        return modules;
    }

    public static void keyPress(int key) {
        onEvent(new EventKey(key));
    }


    //todo Keystrokes

    private static KeystrokesSettings settings;
    private static KeystrokesRenderer renderer;
    private static boolean openGui;

    /*@net.minecraftforge.fml.common.Mod.EventHandler
    public void initt(final FMLInitializationEvent event) throws IOException {
        settings = new KeystrokesSettings(new File(Minecraft.getMinecraft().gameDir, "keystrokes.dat"));
        renderer = new KeystrokesRenderer();
        settings.load();
        ClientCommandHandler.instance.registerCommand((ICommand)new TestCommand());
        ClientCommandHandler.instance.registerCommand((ICommand)new CommandKeystrokes());
        MinecraftForge.EVENT_BUS.register(new KeystrokesRenderer());
    }

     */

    @SubscribeEvent
    public void onClientTick(final TickEvent.ClientTickEvent event) {
        if (openGui) {
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new GuiScreenKeystrokes());
            openGui = false;
        }
    }

    public static KeystrokesSettings getSettings() {
        return settings;
    }

    public static KeystrokesRenderer getRenderer() {
        return renderer;
    }

    public static void openGui() {
        openGui = true;
    }

    public static Mod getInstance() {
        return instance;
    }
}

