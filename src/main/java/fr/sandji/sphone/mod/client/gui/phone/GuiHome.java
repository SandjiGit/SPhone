
/*
 * SPhone - Tous droits réservés. (by 0hSandji)
 */

package fr.sandji.sphone.mod.client.gui.phone;

import fr.aym.acsguis.component.panel.GuiPanel;
import fr.aym.acsguis.component.textarea.GuiLabel;
import fr.sandji.sphone.SPhone;
import fr.sandji.sphone.mod.client.gui.phone.apps.call.GuiCallEnd;
import fr.sandji.sphone.mod.client.gui.phone.apps.call.GuiWaitCall;
import fr.sandji.sphone.mod.client.gui.phone.apps.message.GuiConvList;
import fr.sandji.sphone.mod.client.gui.phone.apps.call.GuiCall;
import fr.sandji.sphone.mod.client.gui.phone.apps.note.GuiNoteList;
import fr.sandji.sphone.mod.common.packets.server.call.PacketJoinCall;
import fr.sandji.sphone.mod.common.packets.server.contacts.PacketGetContacts;
import fr.sandji.sphone.mod.common.phone.Contact;
import fr.sandji.sphone.mod.common.phone.Conversation;
import fr.sandji.sphone.mod.common.phone.Message;
import fr.sandji.sphone.mod.common.phone.Note;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class GuiHome extends GuiBase {

    public GuiHome() {
        super();

        GuiLabel Apps = new GuiLabel("");
        Apps.setCssId("apps");
        add(Apps);

        GuiLabel AppCall = new GuiLabel("");
        AppCall.setCssId("app_call");
        add(AppCall);
        AppCall.addClickListener((p, m, b) -> {
            removeAllChilds();
            add(new GuiWaitCall("0478.36.59.65"));
            //Minecraft.getMinecraft().displayGuiScreen(new GuiCall("0478.36.59.65").getGuiScreen());
        });

        GuiLabel AppNotes = new GuiLabel("");
        AppNotes.setCssId("app_notes");
        add(AppNotes);
        AppNotes.addClickListener((p, m, b) -> {
            List<Note> notes = new ArrayList<>();
            Note note = new Note("Suspect", "Je pense que mon voisin est un tueur en série",1688503674429L);
            notes.add(note);
            Minecraft.getMinecraft().displayGuiScreen(new GuiNoteList(notes).getGuiScreen());
        });

        GuiLabel AppGalery = new GuiLabel("");
        AppGalery.setCssId("app_gallery");
        add(AppGalery);
        AppGalery.addClickListener((p, m, b) -> {
            Minecraft.getMinecraft().displayGuiScreen(new GuiCall("0478.36.59.65").getGuiScreen());
            SPhone.network.sendToServer(new PacketJoinCall(12265));
        });

        GuiLabel AppMessage = new GuiLabel("");
        AppMessage.setCssId("app_message");
        AppMessage.addClickListener((p, m, b) -> {
            //date d'ajourd'hui il y a 4h
            long date = System.currentTimeMillis() ;
            System.out.println(date);

            List<Conversation> conversations = new ArrayList<>();
            Conversation test = new Conversation();
            Message message = new Message("Rdv bar de la place",1688395401123L ,new Contact("michel",1215), new Contact("hugo",1556));
            Message mess = new Message("okay ma poule",1688499414507L ,new Contact("hugo",1556), new Contact("michel",1215));
            Message mess1 = new Message("t'es ou ?",1688500163006L ,new Contact("michel",1215), new Contact("hugo",1556));
            Message mess2 = new Message("dans le bar a droite",1688500173006L ,new Contact("hugo",1556), new Contact("michel",1215));
            Message mess3 = new Message("j'arrive",1688500173006L ,new Contact("michel",1215), new Contact("hugo",1556));
            Message mess4 = new Message("ok",1688500173006L ,new Contact("hugo",1556), new Contact("michel",1215));
            Message mess5 = new Message("je te vois pas",1688500173006L ,new Contact("michel",1215), new Contact("hugo",1556));
            List<Message> messages = new ArrayList<>();
            messages.add(message);
            messages.add(mess);
            messages.add(mess1);
            messages.add(mess2);
            messages.add(mess3);
            messages.add(mess4);
            messages.add(mess5);
            test.setMessages(messages);
            test.setLastUpdate(1688395401123L);
            test.setLastMessage(message);
            test.setSender(new Contact("michel",1215));
            Conversation test2 = new Conversation();
            Message message1 = new Message("vas mourir conard",1688482617877L ,new Contact("jup",1215), new Contact("hugo",1556));
            List<Message> messages1 = new ArrayList<>();
            messages1.add(message1);
            test2.setMessages(messages1);
            test2.setLastUpdate(1688482617877L);
            test2.setLastMessage(message1);
            test2.setSender(new Contact("jup",1215));
            conversations.add(test);
            conversations.add(test2);

            Minecraft.getMinecraft().displayGuiScreen(new GuiConvList(conversations).getGuiScreen());
        });
        add(AppMessage);

        GuiLabel AppMessageText = new GuiLabel("");
        AppMessageText.setCssId("app_text");
        AppMessageText.setCssCode("app_text", "left: 1623px;" + "top: 655px;");
        add(AppMessageText);

        GuiLabel AppInstagram = new GuiLabel("");
        AppInstagram.setCssId("app_instagram");
        add(AppInstagram);
        AppInstagram.addClickListener((p, m, b) -> {
            Minecraft.getMinecraft().displayGuiScreen(new GuiCallEnd("0478.36.59.65").getGuiScreen());
        });

        GuiLabel AppInstagramText = new GuiLabel("");
        AppInstagramText.setCssId("app_text");
        AppInstagramText.setCssCode("app_text", "left: 1700px;" + "top: 655px;");
        add(AppInstagramText);

        GuiLabel AppSettings = new GuiLabel("");
        AppSettings.setCssId("app_settings");
        add(AppSettings);

        GuiLabel AppSettingsText = new GuiLabel("");
        AppSettingsText.setCssId("app_settings");
        AppSettingsText.setCssCode("app_text", "left: 1777;" + "top: 655px;");
        add(AppSettingsText);

        GuiLabel AppMap = new GuiLabel("");
        AppMap.setCssId("app_map");
        add(AppMap);

        GuiPanel AppContact = new GuiPanel();
        AppContact.setCssClass("app_contact");
        AppContact.addClickListener((x, y, bu) -> {
            SPhone.network.sendToServer(new PacketGetContacts());
        });
        add(AppContact);

    }

    public List<ResourceLocation> getCssStyles() {
        List<ResourceLocation> styles = new ArrayList<>();
        styles.add(super.getCssStyles().get(0));
        styles.add(new ResourceLocation("sphone:css/home.css"));
        styles.add(new ResourceLocation("sphone:css/call.css"));
        return styles;
    }


}
